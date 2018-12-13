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
-- Table structure for table `prets`
--

DROP TABLE IF EXISTS `prets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prets` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ferme` tinyint(1) NOT NULL,
  `interet` bigint(20) NOT NULL,
  `rembourse` bigint(20) NOT NULL,
  `restant` bigint(20) NOT NULL,
  `somme` bigint(20) NOT NULL,
  `taux` bigint(20) NOT NULL,
  `famille_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_act2a4qrn8wab7vnv24f20334` (`famille_id`),
  CONSTRAINT `FK_act2a4qrn8wab7vnv24f20334` FOREIGN KEY (`famille_id`) REFERENCES `familles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prets`
--

LOCK TABLES `prets` WRITE;
/*!40000 ALTER TABLE `prets` DISABLE KEYS */;
INSERT INTO `prets` VALUES (1,1,0,0,0,0,5,1),(2,0,233,0,4908,4675,5,1),(3,1,0,0,0,0,5,2),(4,0,262,0,5512,5250,5,3),(5,0,262,0,5512,5250,5,4),(6,0,43,0,917,874,5,5),(7,1,0,0,0,0,5,6),(8,0,250,0,5250,5000,5,6);
/*!40000 ALTER TABLE `prets` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-28 23:20:40
