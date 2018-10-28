-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_elbaappli_dev
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `liasonsdvcl`
--

DROP TABLE IF EXISTS `liasonsdvcl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `liasonsdvcl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `valeurMax` double DEFAULT NULL,
  `valeurMin` double DEFAULT NULL,
  `classe_id` int(11) DEFAULT NULL,
  `devoir_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_5ur1vfupnli6xwi0b2q2skuwo` (`classe_id`),
  KEY `FK_mwpvyq23nxmhfr7e32cs31fdw` (`devoir_id`),
  CONSTRAINT `FK_5ur1vfupnli6xwi0b2q2skuwo` FOREIGN KEY (`classe_id`) REFERENCES `classes` (`id`),
  CONSTRAINT `FK_mwpvyq23nxmhfr7e32cs31fdw` FOREIGN KEY (`devoir_id`) REFERENCES `devoirs` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `liasonsdvcl`
--

LOCK TABLES `liasonsdvcl` WRITE;
/*!40000 ALTER TABLE `liasonsdvcl` DISABLE KEYS */;
/*!40000 ALTER TABLE `liasonsdvcl` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-28 23:20:42
