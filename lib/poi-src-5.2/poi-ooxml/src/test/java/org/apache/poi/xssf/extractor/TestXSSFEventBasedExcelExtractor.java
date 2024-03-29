/* ====================================================================
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
==================================================================== */

package org.apache.poi.xssf.extractor;

import static org.apache.poi.POITestCase.assertContains;
import static org.apache.poi.POITestCase.assertStartsWith;
import static org.apache.poi.POITestCase.assertEndsWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.extractor.POITextExtractor;
import org.apache.poi.ooxml.extractor.POIXMLTextExtractor;
import org.apache.poi.hssf.HSSFTestDataSamples;
import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.xssf.XSSFTestDataSamples;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link XSSFEventBasedExcelExtractor}
 */
class TestXSSFEventBasedExcelExtractor {
    protected XSSFEventBasedExcelExtractor getExtractor(String sampleName) throws Exception {
        return new XSSFEventBasedExcelExtractor(XSSFTestDataSamples.
                openSamplePackage(sampleName));
    }

    /**
     * Get text out of the simple file
     */
    @Test
    void testGetSimpleText() throws Exception {
        // a very simple file
        XSSFEventBasedExcelExtractor extractor = getExtractor("sample.xlsx");
        extractor.getText();

        String text = extractor.getText();
        assertTrue(text.length() > 0);

        // Check sheet names
        assertStartsWith(text, "Sheet1");
        assertEndsWith(text, "Sheet3\n");

        // Now without, will have text
        extractor.setIncludeSheetNames(false);
        text = extractor.getText();
        String CHUNK1 =
                "Lorem\t111\n" +
                        "ipsum\t222\n" +
                        "dolor\t333\n" +
                        "sit\t444\n" +
                        "amet\t555\n" +
                        "consectetuer\t666\n" +
                        "adipiscing\t777\n" +
                        "elit\t888\n" +
                        "Nunc\t999\n";
        String CHUNK2 =
                "The quick brown fox jumps over the lazy dog\n" +
                        "hello, xssf\thello, xssf\n" +
                        "hello, xssf\thello, xssf\n" +
                        "hello, xssf\thello, xssf\n" +
                        "hello, xssf\thello, xssf\n";
        assertEquals(
                CHUNK1 +
                        "at\t4995\n" +
                        CHUNK2
                , text);

        // Now get formulas not their values
        extractor.setFormulasNotResults(true);
        text = extractor.getText();
        assertEquals(
                CHUNK1 +
                        "at\tSUM(B1:B9)\n" +
                        CHUNK2, text);

        // With sheet names too
        extractor.setIncludeSheetNames(true);
        text = extractor.getText();
        assertEquals(
                "Sheet1\n" +
                        CHUNK1 +
                        "at\tSUM(B1:B9)\n" +
                        "rich test\n" +
                        CHUNK2 +
                        "Sheet3\n"
                , text);

        extractor.close();
    }

    @Test
    void testGetComplexText() throws Exception {
        // A fairly complex file
        XSSFEventBasedExcelExtractor extractor = getExtractor("AverageTaxRates.xlsx");
        extractor.getText();

        String text = extractor.getText();
        assertTrue(text.length() > 0);

        // Might not have all formatting it should do!
        assertStartsWith(text,
                "Avgtxfull\n" +
                        "(iii) AVERAGE TAX RATES ON ANNUAL"
        );

        extractor.close();
    }

    @Test
    void testInlineStrings() throws Exception {
        XSSFEventBasedExcelExtractor extractor = getExtractor("InlineStrings.xlsx");
        extractor.setFormulasNotResults(true);
        String text = extractor.getText();

        // Numbers
        assertContains(text, "43");
        assertContains(text, "22");

        // Strings
        assertContains(text, "ABCDE");
        assertContains(text, "Long Text");

        // Inline Strings
        assertContains(text, "1st Inline String");
        assertContains(text, "And More");

        // Formulas
        assertContains(text, "A2");
        assertContains(text, "A5-A$2");

        extractor.close();
    }

    /**
     * Test that we return pretty much the same as
     *  ExcelExtractor does, when we're both passed
     *  the same file, just saved as xls and xlsx
     */
    @Test
    void testComparedToOLE2() throws Exception {
        // A fairly simple file - ooxml
        XSSFEventBasedExcelExtractor ooxmlExtractor = getExtractor("SampleSS.xlsx");

        ExcelExtractor ole2Extractor =
                new ExcelExtractor(HSSFTestDataSamples.openSampleWorkbook("SampleSS.xls"));

        POITextExtractor[] extractors =
                new POITextExtractor[] { ooxmlExtractor, ole2Extractor };
        for (POITextExtractor extractor : extractors) {
            String text = extractor.getText().replaceAll("[\r\t]", "");
            assertStartsWith(text, "First Sheet\nTest spreadsheet\n2nd row2nd row 2nd column\n");
            Pattern pattern = Pattern.compile(".*13(\\.0+)?\\s+Sheet3.*", Pattern.DOTALL);
            Matcher m = pattern.matcher(text);
            assertTrue(m.matches());
        }

        ole2Extractor.close();
        ooxmlExtractor.close();
    }

    /** Test text extraction from text box using getShapes() */
    @Test
    void testShapes() throws Exception{

        try (XSSFEventBasedExcelExtractor ooxmlExtractor = getExtractor("WithTextBox.xlsx")) {
            String text = ooxmlExtractor.getText();
            assertContains(text, "Line 1");
            assertContains(text, "Line 2");
            assertContains(text, "Line 3");
        }
    }

    /**
     * Test that we return the same output for unstyled numbers as the
     * non-event-based XSSFExcelExtractor.
     */
    @Test
    void testUnstyledNumbersComparedToNonEventBasedExtractor()
            throws Exception {

        String expectedOutput = "Sheet1\n99.99\n";

        try (XSSFExcelExtractor extractor = new XSSFExcelExtractor(
                XSSFTestDataSamples.openSampleWorkbook("56011.xlsx"))) {
            assertEquals(expectedOutput, extractor.getText().replace(",", "."));
        }

        try (XSSFEventBasedExcelExtractor fixture = new XSSFEventBasedExcelExtractor(
                XSSFTestDataSamples.openSamplePackage("56011.xlsx"))) {
            assertEquals(expectedOutput, fixture.getText().replace(",", "."));
        }
    }

    /**
     * Test that we return the same output headers and footers as the
     * non-event-based XSSFExcelExtractor.
     */
    @Test
    void testHeadersAndFootersComparedToNonEventBasedExtractor()
            throws Exception {

        String expectedOutputWithHeadersAndFooters =
                "Sheet1\n" +
                        "&\"Calibri,Regular\"&K000000top left\t&\"Calibri,Regular\"&K000000top center\t&\"Calibri,Regular\"&K000000top right\n" +
                        "abc\t123\n" +
                        "&\"Calibri,Regular\"&K000000bottom left\t&\"Calibri,Regular\"&K000000bottom center\t&\"Calibri,Regular\"&K000000bottom right\n";

        String expectedOutputWithoutHeadersAndFooters =
                "Sheet1\n" +
                        "abc\t123\n";

        try (XSSFExcelExtractor extractor = new XSSFExcelExtractor(
                XSSFTestDataSamples.openSampleWorkbook("headerFooterTest.xlsx"))) {
            assertEquals(expectedOutputWithHeadersAndFooters, extractor.getText());
            extractor.setIncludeHeadersFooters(false);
            assertEquals(expectedOutputWithoutHeadersAndFooters, extractor.getText());
        }

        try (XSSFEventBasedExcelExtractor fixture = new XSSFEventBasedExcelExtractor(
                XSSFTestDataSamples.openSamplePackage("headerFooterTest.xlsx"))) {
            assertEquals(expectedOutputWithHeadersAndFooters, fixture.getText());
            fixture.setIncludeHeadersFooters(false);
            assertEquals(expectedOutputWithoutHeadersAndFooters, fixture.getText());
        }
    }

    /**
     * Test that XSSFEventBasedExcelExtractor outputs comments when specified.
     * The output will contain two improvements over the output from
     *  XSSFExcelExtractor in that (1) comments from empty cells will be
     * outputted, and (2) the author will not be outputted twice.
     * <p>
     * This test will need to be modified if these improvements are ported to
     * XSSFExcelExtractor.
     */
    @Test
    void testCommentsComparedToNonEventBasedExtractor()
            throws Exception {

        String expectedOutputWithoutComments =
                "Sheet1\n" +
                        "\n" +
                        "abc\n" +
                        "\n" +
                        "123\n" +
                        "\n" +
                        "\n" +
                        "\n";

        String nonEventBasedExtractorOutputWithComments =
                "Sheet1\n" +
                        "\n" +
                        "abc Comment by Shaun Kalley: Shaun Kalley: Comment A2\n" +
                        "\n" +
                        "123 Comment by Shaun Kalley: Shaun Kalley: Comment B4\n" +
                        "\n" +
                        "\n" +
                        "\n";

        String eventBasedExtractorOutputWithComments =
                "Sheet1\n" +
                        "Comment by Shaun Kalley: Comment A1\tComment by Shaun Kalley: Comment B1\n" +
                        "abc Comment by Shaun Kalley: Comment A2\tComment by Shaun Kalley: Comment B2\n" +
                        "Comment by Shaun Kalley: Comment A3\tComment by Shaun Kalley: Comment B3\n" +
                        "Comment by Shaun Kalley: Comment A4\t123 Comment by Shaun Kalley: Comment B4\n" +
                        "Comment by Shaun Kalley: Comment A5\tComment by Shaun Kalley: Comment B5\n" +
                        "Comment by Shaun Kalley: Comment A7\tComment by Shaun Kalley: Comment B7\n" +
                        "Comment by Shaun Kalley: Comment A8\tComment by Shaun Kalley: Comment B8\n";

        try (XSSFExcelExtractor extractor = new XSSFExcelExtractor(
                XSSFTestDataSamples.openSampleWorkbook("commentTest.xlsx"))) {
            assertEquals(expectedOutputWithoutComments, extractor.getText());
            extractor.setIncludeCellComments(true);
            assertEquals(nonEventBasedExtractorOutputWithComments, extractor.getText());
        }

        try (XSSFEventBasedExcelExtractor fixture = new XSSFEventBasedExcelExtractor(
                XSSFTestDataSamples.openSamplePackage("commentTest.xlsx"))) {
            assertEquals(expectedOutputWithoutComments, fixture.getText());
            fixture.setIncludeCellComments(true);
            assertEquals(eventBasedExtractorOutputWithComments, fixture.getText());
        }
    }

    @Test
    void testFile56278_normal() throws Exception {
        // first with normal Text Extractor
        try (POIXMLTextExtractor extractor = new XSSFExcelExtractor(
                XSSFTestDataSamples.openSampleWorkbook("56278.xlsx"))) {
            assertNotNull(extractor.getText());
        }
    }

    @Test
    void testFile56278_event() throws Exception {
        // then with event based one
        try (POIXMLTextExtractor extractor = getExtractor("56278.xlsx")) {
            assertNotNull(extractor.getText());
        }
    }

    @Test
    void test59021() throws Exception {
        XSSFEventBasedExcelExtractor ex =
                new XSSFEventBasedExcelExtractor(
                        XSSFTestDataSamples.openSamplePackage("59021.xlsx"));
        String text = ex.getText();
        assertContains(text, "Abkhazia - Fixed");
        assertContains(text, "10/02/2016");
        ex.close();
    }

    @Test
    void test51519() throws Exception {
        //default behavior: include phonetic runs
        XSSFEventBasedExcelExtractor ex =
                new XSSFEventBasedExcelExtractor(
                        XSSFTestDataSamples.openSamplePackage("51519.xlsx"));
        String text = ex.getText();
        assertContains(text, "\u65E5\u672C\u30AA\u30E9\u30AF\u30EB \u30CB\u30DB\u30F3");
        ex.close();

        //now try turning them off
        ex =
                new XSSFEventBasedExcelExtractor(
                        XSSFTestDataSamples.openSamplePackage("51519.xlsx"));
        ex.setConcatenatePhoneticRuns(false);
        text = ex.getText();
        assertFalse(text.contains("\u65E5\u672C\u30AA\u30E9\u30AF\u30EB \u30CB\u30DB\u30F3"),
                "should not be able to find appended phonetic run");
        ex.close();

    }

    @Test
    void test66365() throws Exception {
        try (XSSFEventBasedExcelExtractor ex =
                new XSSFEventBasedExcelExtractor(
                        XSSFTestDataSamples.openSamplePackage("66365.xlsx"))) {
            String text = ex.getText();
            assertContains(text, "Alice\tAlice");
            assertContains(text, "Bob\tBob");
        }
    }

    @Test
    void test67784() throws Exception {
        try (XSSFEventBasedExcelExtractor ex =
                     new XSSFEventBasedExcelExtractor(
                             XSSFTestDataSamples.openSamplePackage("bug67784.xlsx"))) {
            String text = ex.getText().replace("\r", "");
            String[] lines = text.split("\n");
            assertEquals("FALSE", lines[2]);
            assertEquals("TRUE", lines[3]);
            assertEquals("ERROR:#DIV/0!", lines[4]);
        }
    }

    @Test
    void test67784Formulas() throws Exception {
        try (XSSFEventBasedExcelExtractor ex =
                     new XSSFEventBasedExcelExtractor(
                             XSSFTestDataSamples.openSamplePackage("bug67784.xlsx"))) {
            ex.setFormulasNotResults(true);
            String text = ex.getText().replace("\r", "");
            String[] lines = text.split("\n");
            assertEquals("(2 > 5)", lines[2]);
            assertEquals("(2 < 4)", lines[3]);
            assertEquals("10/0", lines[4]);
        }
    }
}
