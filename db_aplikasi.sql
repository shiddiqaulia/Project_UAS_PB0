-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 11, 2024 at 03:51 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_aplikasi`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `id` int(11) NOT NULL,
  `nip` varchar(30) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `tanggal` date NOT NULL,
  `keterangan` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`id`, `nip`, `nama`, `tanggal`, `keterangan`) VALUES
(5, '1998060220041001', 'Angelina Jolie', '2024-01-04', 'Present'),
(6, '1999091020062003', 'Iqbaal Ramadhan', '2024-01-08', 'Present'),
(7, '2000100120062004', 'Dani Irawan', '2024-01-10', 'Present'),
(8, '312', 'Fikry', '2024-01-11', 'Present'),
(10, '1992040220042005', 'Muhammad Zulfahmi Khairullah', '2024-01-11', 'Present');

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE `pegawai` (
  `id` int(11) NOT NULL,
  `nip` varchar(30) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `umur` varchar(30) NOT NULL,
  `thn_lahir` varchar(30) NOT NULL,
  `gender` enum('Laki - Laki','Perempuan','','') NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `jabatan` enum('Manager','Employee','','') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pegawai`
--

INSERT INTO `pegawai` (`id`, `nip`, `nama`, `umur`, `thn_lahir`, `gender`, `alamat`, `jabatan`) VALUES
(4, '312', 'wqe', 'adc', 'adb', 'Laki - Laki', 'das', 'Manager');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `nip` varchar(30) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `gender` enum('Laki - Laki','Perempuan','','') NOT NULL,
  `jabatan` enum('Manager','Employee','','') NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `nip`, `nama`, `gender`, `jabatan`, `email`, `password`) VALUES
(1, '1998060220041001', 'Angelina Jolie', 'Perempuan', 'Manager', 'AngelinaJolie@gmail.com', 'angel1998'),
(2, '1997030420042002', 'Fikri Firmansyah', 'Laki - Laki', 'Manager', 'FikriFirmansyah@gmail.com', 'firmansyah2004'),
(3, '1999091020062003', 'Iqbaal Ramadhan', 'Laki - Laki', 'Employee', 'IqbalRamadhan@gmail.com', 'iqbaal1999'),
(5, '2000100120062004', 'Dani Irawan', 'Laki - Laki', 'Employee', 'daniirawan@gmail.com', 'dani123'),
(8, '1992040220042005', 'Muhammad Zulfahmi Khairullah', 'Laki - Laki', 'Manager', 'fahmikhairullah@gmail.com', 'fahmi1992'),
(9, '1995070210042006', 'Aulia Shiddiq Asy-Syifa', 'Laki - Laki', 'Manager', 'auliashiddiq@gmail.com', 'auliashiddiq19'),
(10, '1998050620022007', 'M. Dzaki Fauzi', 'Laki - Laki', 'Manager', 'zeekyy@gmail.com', 'zakizeek'),
(11, '312', 'Fikry', 'Laki - Laki', 'Manager', 'fikri', 'fikri');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nip` (`nip`),
  ADD UNIQUE KEY `nama` (`nama`);

--
-- Indexes for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `nama` (`nama`),
  ADD KEY `jabatan` (`jabatan`),
  ADD KEY `gender` (`gender`),
  ADD KEY `nip` (`nip`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `attendance`
--
ALTER TABLE `attendance`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `pegawai`
--
ALTER TABLE `pegawai`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `attendance`
--
ALTER TABLE `attendance`
  ADD CONSTRAINT `attendance_ibfk_1` FOREIGN KEY (`nama`) REFERENCES `user` (`nama`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
