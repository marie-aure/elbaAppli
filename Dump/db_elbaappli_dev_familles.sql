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
-- Table structure for table `familles`
--

DROP TABLE IF EXISTS `familles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `familles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `argentIG` int(11) NOT NULL,
  `generation` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `chef_id` int(11) DEFAULT NULL,
  `classe_id` int(11) DEFAULT NULL,
  `residence_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_su5v4w34d6axn9sy5s9djgns6` (`chef_id`),
  KEY `FK_9euu85frrn67iovh7wfk614hi` (`classe_id`),
  KEY `FK_sw7cta02ix0nlso5blv76b1m4` (`residence_id`),
  CONSTRAINT `FK_9euu85frrn67iovh7wfk614hi` FOREIGN KEY (`classe_id`) REFERENCES `classes` (`id`),
  CONSTRAINT `FK_su5v4w34d6axn9sy5s9djgns6` FOREIGN KEY (`chef_id`) REFERENCES `sims` (`id`),
  CONSTRAINT `FK_sw7cta02ix0nlso5blv76b1m4` FOREIGN KEY (`residence_id`) REFERENCES `terrains` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `familles`
--

LOCK TABLES `familles` WRITE;
/*!40000 ALTER TABLE `familles` DISABLE KEYS */;
INSERT INTO `familles` VALUES (1,100,1,'Lagasca',17,3,3),(2,100,1,'Queton',23,3,11),(3,209,1,'Ivanov',35,3,15),(4,100,1,'Matcha',39,3,4),(5,100,1,'Maurice',41,3,12),(6,0,1,'Ferron',45,3,5),(7,0,1,'Durand',49,3,NULL),(8,0,1,'Fabre',71,3,NULL);
/*!40000 ALTER TABLE `familles` ENABLE KEYS */;
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
