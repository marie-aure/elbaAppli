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
-- Table structure for table `l_communautaire_rabbithole`
--

DROP TABLE IF EXISTS `l_communautaire_rabbithole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `l_communautaire_rabbithole` (
  `id_terrain` int(11) NOT NULL,
  `id_rabbithole` int(11) NOT NULL,
  KEY `FK_irb5yw7v8vauqquupgk5egx18` (`id_rabbithole`),
  KEY `FK_t4ibgbeemy8wsx73mq26koui0` (`id_terrain`),
  CONSTRAINT `FK_irb5yw7v8vauqquupgk5egx18` FOREIGN KEY (`id_rabbithole`) REFERENCES `rabbitholes` (`id`),
  CONSTRAINT `FK_t4ibgbeemy8wsx73mq26koui0` FOREIGN KEY (`id_terrain`) REFERENCES `terrains` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `l_communautaire_rabbithole`
--

LOCK TABLES `l_communautaire_rabbithole` WRITE;
/*!40000 ALTER TABLE `l_communautaire_rabbithole` DISABLE KEYS */;
INSERT INTO `l_communautaire_rabbithole` VALUES (90,8),(90,20),(90,21),(90,22),(103,14),(104,14),(105,2),(106,2),(108,5),(109,5),(110,5),(111,5),(112,5),(113,6),(114,6),(115,6),(116,6),(117,6),(118,7),(119,16),(120,16),(121,15),(122,4),(138,13),(141,9),(144,19),(145,28),(156,23),(156,24),(156,25),(156,26),(156,27),(170,3),(171,10),(172,17),(174,12),(175,12),(107,5),(124,5),(127,5),(130,5),(139,1),(173,12),(213,12),(214,12),(215,12),(99,12),(140,11),(262,2),(262,3),(262,4),(263,2),(263,3),(263,4);
/*!40000 ALTER TABLE `l_communautaire_rabbithole` ENABLE KEYS */;
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
