-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 08, 2020 at 05:08 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `panganan`
--

-- --------------------------------------------------------

--
-- Table structure for table `konsumsi`
--

CREATE TABLE `konsumsi` (
  `id` int(11) NOT NULL,
  `besar_konsumsi` decimal(7,2) DEFAULT NULL,
  `jenis_tanaman_id` int(11) DEFAULT NULL,
  `tahun` int(4) NOT NULL,
  `last_update` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `konsumsi`
--

INSERT INTO `konsumsi` (`id`, `besar_konsumsi`, `jenis_tanaman_id`, `tahun`, `last_update`) VALUES
(1, '6.19', 1, 2019, '2020-04-30'),
(2, '0.20', 2, 2019, '2020-04-30'),
(4, '2.15', 3, 2019, '2020-04-30');

-- --------------------------------------------------------

--
-- Table structure for table `kota`
--

CREATE TABLE `kota` (
  `id` int(11) NOT NULL,
  `nama_kota` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kota`
--

INSERT INTO `kota` (`id`, `nama_kota`) VALUES
(1, 'Kota Batu'),
(2, 'Kota Surabaya'),
(3, 'Kota Madiun'),
(4, 'Kota Mojokerto'),
(5, 'Kota Pasuruan'),
(6, 'Kota Probolinggo'),
(7, 'Kota Malang'),
(8, 'Kota Blitar'),
(9, 'Kota Kediri'),
(10, 'Kab. Sumenep'),
(11, 'Kab. Pamekasan'),
(12, 'Kab. Sampang'),
(13, 'Kab. Gresik'),
(14, 'Kab. Lamongan'),
(15, 'Kab. Tuban'),
(16, 'Kab. Bojonegoro'),
(17, 'Kab. Ngawi'),
(18, 'Kab. Magetan'),
(19, 'Kab. Madiun'),
(20, 'Kab. Nganjuk'),
(21, 'Kab. Jombang'),
(22, 'Kab. Mojokerto'),
(23, 'Kab. Sidoarjo'),
(24, 'Kab. Pasuruan'),
(25, 'Kab. Probolinggo'),
(26, 'Kab. Situbondo'),
(27, 'Kab. Bangkalan'),
(28, 'Kab. Banyuwangi'),
(29, 'Kab. Bondowoso'),
(30, 'Kab. Jember'),
(31, 'Kab. Lumajang'),
(32, 'Kab. Malang'),
(33, 'Kab. Kediri'),
(34, 'Kab. Blitar'),
(35, 'Kab. Tulungagung'),
(36, 'Kab. Trenggalek'),
(37, 'Kab. Ponorogo'),
(38, 'Kab. Pacitan');

-- --------------------------------------------------------

--
-- Table structure for table `lahan_pertanian`
--

CREATE TABLE `lahan_pertanian` (
  `id` int(11) NOT NULL,
  `kota_id` int(11) NOT NULL,
  `luas_lahan` decimal(12,2) DEFAULT NULL,
  `tahun` int(11) DEFAULT NULL,
  `last_update` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `lahan_pertanian`
--

INSERT INTO `lahan_pertanian` (`id`, `kota_id`, `luas_lahan`, `tahun`, `last_update`) VALUES
(1, 38, '20504.49', 2019, '2020-04-30'),
(2, 37, '58080.19', 2019, '2020-04-30'),
(3, 36, '20474.89', 2019, '2020-04-30'),
(4, 35, '34584.26', 2019, '2020-04-30');

-- --------------------------------------------------------

--
-- Table structure for table `penduduk`
--

CREATE TABLE `penduduk` (
  `id` int(11) NOT NULL,
  `kota_id` int(11) NOT NULL,
  `jumlah_penduduk` int(11) DEFAULT NULL,
  `tahun` int(11) DEFAULT NULL,
  `last_update` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `penduduk`
--

INSERT INTO `penduduk` (`id`, `kota_id`, `jumlah_penduduk`, `tahun`, `last_update`) VALUES
(1, 38, 555000, 2019, '2020-04-28'),
(2, 37, 871000, 2019, '2020-04-28'),
(3, 36, 696000, 2019, '2020-04-28'),
(4, 35, 1039000, 2019, '2020-04-28'),
(5, 34, 1161000, 2019, '2020-04-28'),
(6, 33, 1574000, 2019, '2020-04-28'),
(7, 32, 2606000, 2019, '2020-04-28'),
(8, 31, 1042000, 2019, '2020-04-29'),
(9, 30, 2451000, 2019, '2020-04-29'),
(10, 28, 1614000, 2019, '2020-04-29'),
(11, 29, 776000, 2019, '2020-04-29'),
(12, 26, 683000, 2019, '2020-04-29'),
(13, 25, 1169000, 2019, '2020-04-29'),
(14, 24, 1627000, 2019, '2020-04-29'),
(15, 23, 2249000, 2019, '2020-04-29'),
(16, 22, 1118000, 2019, '2020-04-29'),
(17, 21, 1264000, 2019, '2020-04-29');

-- --------------------------------------------------------

--
-- Table structure for table `produksi`
--

CREATE TABLE `produksi` (
  `id` int(11) NOT NULL,
  `kota_id` int(11) NOT NULL,
  `jenis_tanaman_id` int(11) NOT NULL,
  `jumlah_produksi` decimal(12,2) DEFAULT NULL,
  `tahun` int(11) DEFAULT NULL,
  `last_update` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `produksi`
--

INSERT INTO `produksi` (`id`, `kota_id`, `jenis_tanaman_id`, `jumlah_produksi`, `tahun`, `last_update`) VALUES
(1, 38, 1, '91941.66', 2019, '2020-04-30'),
(2, 37, 1, '322205.50', 2019, '2020-04-30'),
(3, 36, 1, '112213.57', 2019, '2020-04-30'),
(5, 35, 1, '196430.58', 2019, '2020-04-30'),
(6, 34, 1, '224027.19', 2019, '2020-04-30'),
(8, 33, 1, '222837.82', 2019, '2020-04-30'),
(9, 32, 1, '281072.26', 2019, '2020-04-30'),
(10, 31, 1, '283894.22', 2019, '2020-04-30');

-- --------------------------------------------------------

--
-- Table structure for table `tanaman`
--

CREATE TABLE `tanaman` (
  `id` int(11) NOT NULL,
  `jenis_tanaman` varchar(40) DEFAULT NULL,
  `nama_pangan` varchar(30) NOT NULL,
  `potensi_rata_rata_hasil` decimal(7,2) DEFAULT NULL,
  `keterangan` varchar(255) DEFAULT NULL,
  `last_update` date DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tanaman`
--

INSERT INTO `tanaman` (`id`, `jenis_tanaman`, `nama_pangan`, `potensi_rata_rata_hasil`, `keterangan`, `last_update`) VALUES
(1, 'Padi', 'Beras', '7.50', 'Dummy', '2020-05-01'),
(2, 'Jagung', 'Jagung', '7.92', 'Dummy', '2020-04-30'),
(3, 'Kedelai', 'Kedelai', '2.40', 'Dummy', '2020-04-30');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `konsumsi`
--
ALTER TABLE `konsumsi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `jenis_tanaman_id` (`jenis_tanaman_id`);

--
-- Indexes for table `kota`
--
ALTER TABLE `kota`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `lahan_pertanian`
--
ALTER TABLE `lahan_pertanian`
  ADD PRIMARY KEY (`id`),
  ADD KEY `kota_id` (`kota_id`);

--
-- Indexes for table `penduduk`
--
ALTER TABLE `penduduk`
  ADD PRIMARY KEY (`id`),
  ADD KEY `kota_id` (`kota_id`);

--
-- Indexes for table `produksi`
--
ALTER TABLE `produksi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `kota_id` (`kota_id`),
  ADD KEY `jenis_tanaman_id` (`jenis_tanaman_id`);

--
-- Indexes for table `tanaman`
--
ALTER TABLE `tanaman`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `konsumsi`
--
ALTER TABLE `konsumsi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `kota`
--
ALTER TABLE `kota`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT for table `lahan_pertanian`
--
ALTER TABLE `lahan_pertanian`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `penduduk`
--
ALTER TABLE `penduduk`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `produksi`
--
ALTER TABLE `produksi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `tanaman`
--
ALTER TABLE `tanaman`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `konsumsi`
--
ALTER TABLE `konsumsi`
  ADD CONSTRAINT `konsumsi_ibfk_1` FOREIGN KEY (`jenis_tanaman_id`) REFERENCES `tanaman` (`id`);

--
-- Constraints for table `lahan_pertanian`
--
ALTER TABLE `lahan_pertanian`
  ADD CONSTRAINT `lahan_pertanian_ibfk_1` FOREIGN KEY (`kota_id`) REFERENCES `kota` (`id`);

--
-- Constraints for table `penduduk`
--
ALTER TABLE `penduduk`
  ADD CONSTRAINT `penduduk_ibfk_1` FOREIGN KEY (`kota_id`) REFERENCES `kota` (`id`);

--
-- Constraints for table `produksi`
--
ALTER TABLE `produksi`
  ADD CONSTRAINT `produksi_ibfk_1` FOREIGN KEY (`kota_id`) REFERENCES `kota` (`id`),
  ADD CONSTRAINT `produksi_ibfk_2` FOREIGN KEY (`jenis_tanaman_id`) REFERENCES `tanaman` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
