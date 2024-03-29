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

package org.apache.poi.openxml4j;

import org.apache.poi.hssf.HSSFTestDataSamples;
import org.apache.poi.ooxml.TrackingInputStream;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestOPCPackage {
    @Test
    void testPackageCloseClosesInputStream() throws Exception {
        try (TrackingInputStream stream = new TrackingInputStream(
                     HSSFTestDataSamples.openSampleFileStream("HeaderFooterComplexFormats.xlsx"))) {
            try (OPCPackage opcPackage = OPCPackage.open(stream)) {
                assertFalse(opcPackage.isClosed());
            }
            assertTrue(stream.isClosed(), "stream should be closed by OPCPackage");
        }
    }

    @Test
    void testPackageCloseDoesNptCloseInputStream() throws Exception {
        try (TrackingInputStream stream = new TrackingInputStream(
                HSSFTestDataSamples.openSampleFileStream("HeaderFooterComplexFormats.xlsx"))) {
            try (OPCPackage opcPackage = OPCPackage.open(stream, false)) {
                assertFalse(opcPackage.isClosed());
            }
            assertFalse(stream.isClosed(), "stream should not be closed by OPCPackage");
        }
    }

}
