-- MySQL dump 10.13  Distrib 5.7.19, for Win64 (x86_64)
--
-- Host: localhost    Database: mediaone
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bill` (
  `ID` char(9) NOT NULL,
  `employeeID` char(9) NOT NULL,
  `customerID` char(9) NOT NULL,
  `sellTimestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  KEY `key_phu6` (`employeeID`),
  KEY `key_phu7` (`customerID`),
  CONSTRAINT `key_phu6` FOREIGN KEY (`employeeID`) REFERENCES `employee` (`ID`),
  CONSTRAINT `key_phu7` FOREIGN KEY (`customerID`) REFERENCES `customer` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `billdetail`
--

DROP TABLE IF EXISTS `billdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `billdetail` (
  `ID` char(9) NOT NULL,
  `billID` char(9) NOT NULL,
  `productID` char(9) NOT NULL,
  `productNumber` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `key_phu8` (`billID`),
  KEY `key_phu9` (`productID`),
  CONSTRAINT `key_phu8` FOREIGN KEY (`billID`) REFERENCES `bill` (`ID`),
  CONSTRAINT `key_phu9` FOREIGN KEY (`productID`) REFERENCES `product` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billdetail`
--

LOCK TABLES `billdetail` WRITE;
/*!40000 ALTER TABLE `billdetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `billdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `ID` char(9) NOT NULL,
  `publishingCompany` varchar(256) NOT NULL,
  `authorName` varchar(256) NOT NULL,
  `bookType` varchar(256) NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `key_phu3` FOREIGN KEY (`ID`) REFERENCES `product` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES ('BK000001','Kim Đồng','Kishimoto Masashi',''),('BK000002','Kim Đồng','Oda Eiichiro','');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `ID` char(9) NOT NULL,
  `point` double NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `key_phu` FOREIGN KEY (`ID`) REFERENCES `human` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `ID` char(9) NOT NULL,
  `salary` double NOT NULL,
  `password` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `key_phu2` FOREIGN KEY (`ID`) REFERENCES `human` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('20151998',1000,'khailinh1997');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fee`
--

DROP TABLE IF EXISTS `fee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fee` (
  `feeName` varchar(256) NOT NULL,
  `feeValue` double NOT NULL,
  `feeCycle` int(11) NOT NULL,
  `requestTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`feeName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fee`
--

LOCK TABLES `fee` WRITE;
/*!40000 ALTER TABLE `fee` DISABLE KEYS */;
INSERT INTO `fee` VALUES ('Tiền mạng',30000,1,'2017-10-24 04:15:25'),('Tiền mua thương hiệu',5000000,30,'2017-10-24 04:14:35'),('Tiền nhà',10000000,30,'2017-10-24 04:10:16'),('Tiền thuê người nộm',100000,1,'2017-10-24 04:16:05'),('Tiền điện nước',2000000,30,'2017-10-24 04:15:11');
/*!40000 ALTER TABLE `fee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `human`
--

DROP TABLE IF EXISTS `human`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `human` (
  `ID` char(9) NOT NULL,
  `fullName` varchar(256) NOT NULL,
  `telephoneNumber` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `human`
--

LOCK TABLES `human` WRITE;
/*!40000 ALTER TABLE `human` DISABLE KEYS */;
INSERT INTO `human` VALUES ('20151998','Nguyễn Bá Khải','01699417566');
/*!40000 ALTER TABLE `human` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `moviedisc`
--

DROP TABLE IF EXISTS `moviedisc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `moviedisc` (
  `ID` char(9) NOT NULL,
  `directorName` varchar(256) NOT NULL,
  `actorName` varchar(256) NOT NULL,
  `dicsType` varchar(256) NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `key_phu4` FOREIGN KEY (`ID`) REFERENCES `product` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `moviedisc`
--

LOCK TABLES `moviedisc` WRITE;
/*!40000 ALTER TABLE `moviedisc` DISABLE KEYS */;
/*!40000 ALTER TABLE `moviedisc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `musicdisc`
--

DROP TABLE IF EXISTS `musicdisc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `musicdisc` (
  `ID` char(9) NOT NULL,
  `authorName` varchar(256) NOT NULL,
  `singerName` varchar(256) NOT NULL,
  `dicsType` varchar(256) NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `key_phu5` FOREIGN KEY (`ID`) REFERENCES `product` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musicdisc`
--

LOCK TABLES `musicdisc` WRITE;
/*!40000 ALTER TABLE `musicdisc` DISABLE KEYS */;
/*!40000 ALTER TABLE `musicdisc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paid`
--

DROP TABLE IF EXISTS `paid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paid` (
  `ID` char(9) NOT NULL,
  `feeName` varchar(256) NOT NULL,
  `status` tinyint(1) NOT NULL,
  `paidTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `requestTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`ID`),
  KEY `key_phu10` (`feeName`),
  CONSTRAINT `key_phu10` FOREIGN KEY (`feeName`) REFERENCES `fee` (`feeName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paid`
--

LOCK TABLES `paid` WRITE;
/*!40000 ALTER TABLE `paid` DISABLE KEYS */;
/*!40000 ALTER TABLE `paid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `ID` char(9) NOT NULL,
  `productName` varchar(256) NOT NULL,
  `productType` smallint(6) NOT NULL,
  `productQuota` int(11) NOT NULL,
  `buyPrice` double NOT NULL,
  `sellPrice` double NOT NULL,
  `buyTimestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('BK000001','Naruto',1,100,20000,25000,'2017-10-24 04:07:34'),('BK000002','Onepiece',1,100,20000,30000,'2017-10-24 04:09:25');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-24 11:24:10
