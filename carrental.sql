-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 08, 2020 at 01:45 PM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `carrental`
--

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE `city` (
  `CITY_ID` varchar(30) NOT NULL,
  `CITY_NAME` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`CITY_ID`, `CITY_NAME`) VALUES
('0123', 'Athens'),
('1234', 'Leukada'),
('2345', 'Karditsa'),
('3456', 'Patra'),
('4567', 'Lamia'),
('5678', 'Thessaloniki'),
('6789', 'Trikala'),
('7890', 'Tripoli');

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `CLIENT_ID` varchar(50) NOT NULL,
  `CLIENT_NAME` varchar(50) NOT NULL,
  `CLIENT_SURNAME` varchar(50) NOT NULL,
  `CLIENT_DRIVING_LICENSE` varchar(20) NOT NULL,
  `CLIENT_ADDRESS` varchar(50) NOT NULL,
  `CLIENT_EMAIL` varchar(50) NOT NULL,
  `CLIENT_TELEPHONE_NO` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`CLIENT_ID`, `CLIENT_NAME`, `CLIENT_SURNAME`, `CLIENT_DRIVING_LICENSE`, `CLIENT_ADDRESS`, `CLIENT_EMAIL`, `CLIENT_TELEPHONE_NO`) VALUES
('123', 'Dimitris', 'Koutsoukos', '112233', 'Paraskeua 1', 'dim@gmail.com', '9874563210'),
('234', 'Maureta', 'Grapsa', '223344', 'kalamitsi', 'mau@gmail.com', '69874521302'),
('345', 'Russel', 'Westbrook', '334455', 'Houston', 'Rus@gmail.com', '6523102578'),
('456', 'Andre', 'Drummond', '445566', 'Detroit', 'And@gmail.com', '520445697550'),
('567', 'Clay', 'Thompson', '556677', 'California', 'Cley@gmail.com', '123456789'),
('678', 'Steven', 'Adams', '667788', 'Oklahoma', 'Moustage@gmail.com', '987456321'),
('789', 'Cj', 'McCollum', '778899', 'Portland', 'CJ@gmail.com', '23546789'),
('890', 'Devonte', 'Graham', '889900', 'Charlotte', 'dev@gmail.com', '03215874');

-- --------------------------------------------------------

--
-- Table structure for table `rental`
--

CREATE TABLE `rental` (
  `RENTAL_ID` varchar(50) NOT NULL,
  `VEHICLE_LICENCE_NO` varchar(10) NOT NULL,
  `CLIENT_ID` varchar(50) NOT NULL,
  `RENTAL_PICKUP_LOCATION` varchar(50) NOT NULL,
  `RENTAL_PICKUP_DATETIME` datetime NOT NULL,
  `RENTAL_RETURN_LOCATION` varchar(50) NOT NULL,
  `RENTAL_RETURN_DATETIME` datetime NOT NULL,
  `RENTAL_TOTAL_COST` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `store`
--

CREATE TABLE `store` (
  `STORE_ID` varchar(30) NOT NULL,
  `CITY_ID` varchar(30) NOT NULL,
  `STORE_NAME` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `vehicle`
--

CREATE TABLE `vehicle` (
  `VEHICLE_LICENCE_NO` varchar(10) NOT NULL,
  `STORE_ID` varchar(30) NOT NULL,
  `VEHICLE_MODEL` varchar(30) NOT NULL,
  `VEHICLE_FUEL` varchar(20) NOT NULL,
  `VEHICLE_CAPACITY` varchar(20) NOT NULL,
  `VEHICLE_RENTAL_COST` int(11) NOT NULL,
  `VEHICLE_TYPE` varchar(50) NOT NULL,
  `VEHICLE_SEAT_HEIGHT` int(11) DEFAULT NULL,
  `VEHICLE_LUGGAGE_SUPPORT` varchar(50) DEFAULT NULL,
  `VEHICLE_SEAT_NO` int(11) DEFAULT NULL,
  `VEHICLE_DOOR_NUMBER` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`CITY_ID`);

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`CLIENT_ID`);

--
-- Indexes for table `rental`
--
ALTER TABLE `rental`
  ADD PRIMARY KEY (`RENTAL_ID`),
  ADD KEY `FK_APPEARS` (`VEHICLE_LICENCE_NO`),
  ADD KEY `FK_PERFORMS` (`CLIENT_ID`);

--
-- Indexes for table `store`
--
ALTER TABLE `store`
  ADD PRIMARY KEY (`STORE_ID`),
  ADD KEY `FK_HAS` (`CITY_ID`);

--
-- Indexes for table `vehicle`
--
ALTER TABLE `vehicle`
  ADD PRIMARY KEY (`VEHICLE_LICENCE_NO`),
  ADD KEY `FK_OWNS` (`STORE_ID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `rental`
--
ALTER TABLE `rental`
  ADD CONSTRAINT `FK_APPEARS` FOREIGN KEY (`VEHICLE_LICENCE_NO`) REFERENCES `vehicle` (`VEHICLE_LICENCE_NO`),
  ADD CONSTRAINT `FK_PERFORMS` FOREIGN KEY (`CLIENT_ID`) REFERENCES `client` (`CLIENT_ID`);

--
-- Constraints for table `store`
--
ALTER TABLE `store`
  ADD CONSTRAINT `FK_HAS` FOREIGN KEY (`CITY_ID`) REFERENCES `city` (`CITY_ID`);

--
-- Constraints for table `vehicle`
--
ALTER TABLE `vehicle`
  ADD CONSTRAINT `FK_OWNS` FOREIGN KEY (`STORE_ID`) REFERENCES `store` (`STORE_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
