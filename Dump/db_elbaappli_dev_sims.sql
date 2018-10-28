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
-- Table structure for table `sims`
--

DROP TABLE IF EXISTS `sims`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sims` (
  `DTYPE` varchar(31) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `espece` varchar(255) DEFAULT NULL,
  `marie` tinyint(1) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `orientation` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `realise` tinyint(1) NOT NULL,
  `sexe` varchar(255) DEFAULT NULL,
  `bouche` int(11) DEFAULT NULL,
  `cheveux` int(11) DEFAULT NULL,
  `couleur` int(11) DEFAULT NULL,
  `couleurYeux` int(11) DEFAULT NULL,
  `groupe` int(11) DEFAULT NULL,
  `muscle` int(11) DEFAULT NULL,
  `musique` int(11) DEFAULT NULL,
  `nez` int(11) DEFAULT NULL,
  `peau` int(11) DEFAULT NULL,
  `plat` int(11) DEFAULT NULL,
  `poids` int(11) DEFAULT NULL,
  `poitrine` int(11) DEFAULT NULL,
  `signe` int(11) DEFAULT NULL,
  `visage` int(11) DEFAULT NULL,
  `yeux` int(11) DEFAULT NULL,
  `couple_id` int(11) DEFAULT NULL,
  `famille_id` int(11) DEFAULT NULL,
  `familleOrigine_id` int(11) DEFAULT NULL,
  `souhait_id` int(11) DEFAULT NULL,
  `parent1_id` int(11) DEFAULT NULL,
  `parent2_id` int(11) DEFAULT NULL,
  `nomOrigine` varchar(255) DEFAULT NULL,
  `mort` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_57i8yoimd2eqohy41cvhjdb1h` (`couple_id`),
  KEY `FK_7h2y5q5o0u3dp3hxswrq0nkoi` (`famille_id`),
  KEY `FK_gf0tkc3rixupnseg7efa7xlwj` (`familleOrigine_id`),
  KEY `FK_phgiqcgmoc4wkjqpkaskwbubl` (`souhait_id`),
  KEY `FK_dnzjnj_idx` (`parent1_id`),
  KEY `FK_djezkcbejk_idx` (`parent2_id`),
  CONSTRAINT `FK_57i8yoimd2eqohy41cvhjdb1h` FOREIGN KEY (`couple_id`) REFERENCES `sims` (`id`),
  CONSTRAINT `FK_7h2y5q5o0u3dp3hxswrq0nkoi` FOREIGN KEY (`famille_id`) REFERENCES `familles` (`id`),
  CONSTRAINT `FK_djezkcbejk` FOREIGN KEY (`parent2_id`) REFERENCES `sims` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_dnzjnj` FOREIGN KEY (`parent1_id`) REFERENCES `sims` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_gf0tkc3rixupnseg7efa7xlwj` FOREIGN KEY (`familleOrigine_id`) REFERENCES `familles` (`id`),
  CONSTRAINT `FK_phgiqcgmoc4wkjqpkaskwbubl` FOREIGN KEY (`souhait_id`) REFERENCES `souhaits` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sims`
--

LOCK TABLES `sims` WRITE;
/*!40000 ALTER TABLE `sims` DISABLE KEYS */;
INSERT INTO `sims` VALUES ('starter',1,'Sirène',0,'X','Homosexuel','K',0,'M',6,5,3,2,2,3,8,18,4,3,6,1,5,8,4,2,NULL,NULL,24,NULL,NULL,NULL,0),('starter',2,'Sorcier',0,'I','Homosexuel','K',0,'M',3,3,2,3,2,8,4,7,4,42,4,7,5,8,12,1,NULL,NULL,30,NULL,NULL,NULL,0),('starter',3,'Humain',0,'G','Homosexuel','C',0,'M',14,8,18,2,4,2,25,24,8,5,6,5,5,10,5,4,NULL,NULL,30,NULL,NULL,NULL,0),('starter',4,'Humain',0,'E','Homosexuel','M',0,'M',17,5,9,4,4,5,25,15,10,40,4,8,1,8,11,3,NULL,NULL,26,NULL,NULL,NULL,0),('starter',5,'Humain',0,'C','Homosexuel','L',0,'M',2,2,15,8,5,4,9,23,1,12,4,8,2,3,7,6,NULL,NULL,60,NULL,NULL,NULL,0),('starter',6,'Humain',0,'J','Homosexuel','X',0,'M',6,4,1,3,5,1,15,7,2,39,6,9,8,1,8,5,NULL,NULL,9,NULL,NULL,NULL,0),('starter',7,'Sorcier',0,'M','Homosexuel','J',0,'M',6,3,16,1,6,2,16,22,10,7,9,8,3,11,9,8,NULL,NULL,13,NULL,NULL,NULL,0),('starter',8,'Vampire',0,'O','Homosexuel','T',0,'M',6,5,20,2,6,1,10,19,10,40,8,3,11,1,11,7,NULL,NULL,58,NULL,NULL,NULL,0),('starter',9,'Humain',0,'B','Homosexuel','F',0,'F',16,2,9,1,5,10,11,8,10,27,4,1,7,11,9,10,NULL,NULL,4,NULL,NULL,NULL,0),('starter',10,'Humain',0,'F','Homosexuel','G',0,'F',15,7,1,5,5,2,23,4,10,39,3,7,12,6,5,9,NULL,NULL,62,NULL,NULL,NULL,0),('starter',11,'Fantôme',0,'K','Homosexuel','M',0,'F',7,2,19,3,6,3,16,12,1,36,5,5,3,9,13,12,NULL,NULL,54,NULL,NULL,NULL,0),('starter',12,'Génie',0,'E','Homosexuel','H',0,'F',15,8,3,5,6,4,26,7,9,40,8,8,3,12,7,11,NULL,NULL,47,NULL,NULL,NULL,0),('starter',13,'Génie',0,'R','Homosexuel','W',0,'F',12,3,12,6,2,2,24,3,10,10,2,7,4,8,10,14,NULL,NULL,65,NULL,NULL,NULL,0),('starter',14,'Loup Garou',0,'T','Homosexuel','I',0,'F',14,2,6,4,2,3,10,19,2,31,4,7,4,11,11,13,NULL,NULL,35,NULL,NULL,NULL,0),('starter',15,'Fée',0,'R','Homosexuel','S',0,'F',13,4,2,8,5,4,19,9,9,35,8,4,6,10,1,16,NULL,NULL,66,NULL,NULL,NULL,0),('starter',16,'Fantôme',0,'I','Homosexuel','W',0,'F',3,2,14,2,5,8,12,6,9,3,9,6,11,10,7,15,NULL,NULL,49,NULL,NULL,NULL,0),('starter',17,'Fée',0,'Lagasca','Homosexuel','Flora',0,'F',16,2,20,2,1,10,2,3,8,41,4,9,10,4,14,18,1,1,81,NULL,NULL,NULL,0),('starter',18,'Fée',0,'Lagasca','Homosexuel','Wendi',0,'F',1,6,19,2,1,3,21,5,4,44,5,8,5,6,15,17,1,1,23,NULL,NULL,'Zein',0),('starter',19,'Humain',0,'K','Hétérosexuel','N',0,'M',6,4,13,5,2,7,19,9,3,45,10,2,5,8,11,20,NULL,NULL,12,NULL,NULL,NULL,0),('starter',20,'Humain',0,'S','Hétérosexuel','I',0,'F',16,4,13,5,2,7,22,11,5,48,6,10,5,4,2,19,NULL,NULL,36,NULL,NULL,NULL,0),('starter',21,'Humain',0,'U','Hétérosexuel','K',0,'M',1,1,2,5,5,9,15,4,6,30,2,8,7,1,14,22,NULL,NULL,34,NULL,NULL,NULL,0),('starter',22,'Humain',0,'B','Hétérosexuel','P',0,'F',11,2,15,6,5,6,15,19,9,22,10,5,7,10,5,21,NULL,NULL,70,NULL,NULL,NULL,0),('starter',23,'Vampire',0,'Queton','Hétérosexuel','Domenico',0,'M',16,6,19,4,1,7,22,22,10,1,3,6,12,11,5,24,2,2,31,NULL,NULL,NULL,0),('starter',24,'Vampire',0,'Queton','Hétérosexuel','Kendra',0,'F',11,4,19,8,1,10,19,2,10,6,6,3,12,5,11,23,2,2,23,NULL,NULL,'Xanthis',0),('starter',25,'Vampire',0,'P','Hétérosexuel','M',0,'M',11,1,3,7,3,3,9,24,8,11,2,6,9,6,11,26,NULL,NULL,73,NULL,NULL,NULL,0),('starter',26,'Fantôme',0,'W','Hétérosexuel','Q',0,'F',6,4,3,1,3,7,27,19,8,21,6,8,9,7,1,25,NULL,NULL,67,NULL,NULL,NULL,0),('starter',27,'Humain',0,'M','Hétérosexuel','E',0,'M',17,7,12,2,3,6,1,8,9,6,7,4,11,8,13,28,NULL,NULL,3,NULL,NULL,NULL,0),('starter',28,'Humain',0,'F','Hétérosexuel','X',0,'F',13,3,6,4,3,6,27,10,9,40,1,2,11,1,12,27,NULL,NULL,38,NULL,NULL,NULL,0),('starter',29,'Humain',0,'C','Hétérosexuel','C',0,'M',1,8,4,1,3,1,12,4,8,24,3,8,10,12,1,30,NULL,NULL,65,NULL,NULL,NULL,0),('starter',30,'Humain',0,'M','Hétérosexuel','E',0,'F',2,3,6,2,3,2,15,23,9,37,9,7,10,10,6,29,NULL,NULL,72,NULL,NULL,NULL,0),('starter',31,'Humain',0,'E','Hétérosexuel','U',0,'M',10,1,9,4,4,10,20,13,6,43,9,10,4,6,1,32,NULL,NULL,56,NULL,NULL,NULL,0),('starter',32,'Humain',0,'H','Hétérosexuel','A',0,'F',17,6,4,6,4,7,22,6,7,19,3,7,4,5,9,31,NULL,NULL,71,NULL,NULL,NULL,0),('starter',33,'Humain',0,'B','Hétérosexuel','I',0,'M',10,3,7,4,2,4,18,17,10,14,10,10,3,8,15,34,NULL,NULL,23,NULL,NULL,NULL,0),('starter',34,'Humain',0,'T','Hétérosexuel','E',0,'F',13,6,11,6,2,8,27,10,9,23,4,10,3,2,14,33,NULL,NULL,71,NULL,NULL,NULL,0),('starter',35,'Humain',0,'Ivanov','Hétérosexuel','Pavel',0,'M',1,4,17,6,1,8,8,7,5,47,10,6,4,11,12,36,3,3,38,NULL,NULL,NULL,0),('starter',36,'Humain',0,'Ivanov','Hétérosexuel','Quetty',0,'F',10,3,3,4,1,10,23,20,4,38,7,6,4,3,1,35,3,3,70,NULL,NULL,'Hector',0),('starter',37,'Humain',0,'U','Hétérosexuel','P',0,'M',15,2,19,7,6,2,3,13,1,26,2,7,2,4,1,38,NULL,NULL,21,NULL,NULL,NULL,0),('starter',38,'Humain',0,'S','Hétérosexuel','A',0,'F',11,7,2,8,6,10,8,12,3,5,5,7,2,10,4,37,NULL,NULL,63,NULL,NULL,NULL,0),('starter',39,'Humain',0,'Matcha','Hétérosexuel','Juan',0,'M',2,2,15,2,1,10,2,8,10,20,8,7,4,2,10,40,4,4,46,NULL,NULL,NULL,0),('starter',40,'Humain',0,'Matcha','Hétérosexuel','Valentine',0,'F',10,4,18,7,1,7,25,3,8,15,8,9,4,5,8,39,4,4,13,NULL,NULL,'Unico',0),('starter',41,'Fantôme',0,'Maurice','Hétérosexuel','Damien',0,'M',9,8,2,5,1,1,12,9,5,27,1,8,8,2,8,42,5,5,56,NULL,NULL,NULL,0),('starter',42,'Fée',0,'Maurice','Hétérosexuel','Amélia',0,'F',6,4,3,2,1,4,12,7,7,3,1,7,8,1,15,41,5,5,13,NULL,NULL,'Erikson',0),('starter',43,'Humain',0,'E','Hétérosexuel','J',0,'M',5,2,13,4,6,3,20,5,2,8,4,2,9,4,1,44,NULL,NULL,32,NULL,NULL,NULL,0),('starter',44,'Humain',0,'A','Hétérosexuel','N',0,'F',10,8,20,4,6,1,10,20,4,29,2,2,9,4,13,43,NULL,NULL,79,NULL,NULL,NULL,0),('starter',45,'Végésim',1,'Ferron','Hétérosexuel','Stan',0,'M',10,2,13,5,1,10,19,17,10,47,2,7,1,2,1,46,6,6,45,NULL,NULL,NULL,0),('starter',46,'Sorcier',0,'Ferron','Hétérosexuel','Béa',0,'F',7,4,7,2,1,1,19,23,6,36,10,9,1,10,10,45,6,6,47,NULL,NULL,'Faust',0),('starter',47,'Fée',0,'S','Hétérosexuel','Q',0,'M',4,4,11,4,6,7,3,2,2,48,4,7,1,1,10,48,NULL,NULL,74,NULL,NULL,NULL,0),('starter',48,'Fée',0,'U','Hétérosexuel','C',0,'F',17,4,5,6,6,10,3,15,7,18,2,4,1,10,10,47,NULL,NULL,23,NULL,NULL,NULL,0),('starter',49,'Sorcier',0,'Durand','Hétérosexuel','Wilfried',0,'M',11,4,2,2,1,1,22,9,10,6,4,10,2,10,5,50,7,7,17,NULL,NULL,NULL,0),('starter',50,'Fantôme',0,'Durand','Hétérosexuel','Gwen',0,'F',17,6,5,8,1,10,15,14,10,50,3,8,2,6,3,49,7,7,65,NULL,NULL,'Pelletier',0),('starter',51,'Humain',0,'U','Hétérosexuel','G',0,'M',10,8,13,3,3,6,11,20,10,35,10,3,3,11,7,52,NULL,NULL,69,NULL,NULL,NULL,0),('starter',52,'Génie',0,'F','Hétérosexuel','B',0,'F',9,8,13,8,3,8,11,20,10,35,3,1,11,10,7,51,NULL,NULL,4,NULL,NULL,NULL,0),('starter',53,'Humain',0,'T','Hétérosexuel','G',0,'M',2,5,1,4,3,1,22,17,9,20,4,9,2,7,11,54,NULL,NULL,18,NULL,NULL,NULL,0),('starter',54,'Humain',0,'U','Hétérosexuel','N',0,'F',1,8,1,1,3,2,6,3,10,1,6,10,6,8,9,53,NULL,NULL,55,NULL,NULL,NULL,0),('starter',55,'Humain',0,'X','Hétérosexuel','T',0,'M',9,6,7,4,3,6,27,8,7,37,7,1,2,3,10,56,NULL,NULL,76,NULL,NULL,NULL,0),('starter',56,'Humain',0,'F','Hétérosexuel','D',0,'F',11,4,7,7,3,3,6,16,6,7,10,4,8,1,7,55,NULL,NULL,70,NULL,NULL,NULL,0),('starter',57,'Végésim',0,'K','Hétérosexuel','X',0,'M',14,1,16,8,4,1,21,24,9,26,2,6,4,1,10,58,NULL,NULL,45,NULL,NULL,NULL,0),('starter',58,'Fantôme',0,'O','Hétérosexuel','T',0,'F',6,5,2,1,4,1,18,10,10,5,3,9,4,12,6,57,NULL,NULL,76,NULL,NULL,NULL,0),('starter',59,'Humain',0,'B','Hétérosexuel','O',0,'M',16,1,15,3,6,6,13,11,9,21,6,8,2,1,12,60,NULL,NULL,31,NULL,NULL,NULL,0),('starter',60,'Humain',0,'Q','Hétérosexuel','W',0,'F',10,6,16,7,6,7,13,9,8,31,3,2,9,2,8,59,NULL,NULL,6,NULL,NULL,NULL,0),('starter',61,'Loup Garou',0,'T','Hétérosexuel','M',0,'M',12,2,5,3,4,2,10,6,8,10,6,5,8,8,8,62,NULL,NULL,4,NULL,NULL,NULL,0),('starter',62,'Végésim',0,'Y','Hétérosexuel','X',0,'F',3,8,12,1,4,9,27,22,10,44,6,8,8,9,4,61,NULL,NULL,68,NULL,NULL,NULL,0),('starter',63,'Humain',0,'A','Hétérosexuel','T',0,'M',14,1,3,8,2,3,5,8,7,42,4,6,3,2,4,64,NULL,NULL,26,NULL,NULL,NULL,0),('starter',64,'Humain',0,'S','Hétérosexuel','Y',0,'F',5,1,11,8,2,10,5,5,5,29,6,10,7,3,14,63,NULL,NULL,70,NULL,NULL,NULL,0),('starter',65,'Sirène',0,'V','Hétérosexuel','E',0,'M',17,3,18,4,3,10,11,8,6,30,2,2,5,7,13,66,NULL,NULL,8,NULL,NULL,NULL,0),('starter',66,'Sirène',0,'X','Hétérosexuel','Z',0,'F',7,7,9,1,3,4,20,21,4,46,6,7,5,1,3,65,NULL,NULL,32,NULL,NULL,NULL,0),('starter',67,'Sorcier',0,'K','Hétérosexuel','D',0,'M',12,1,4,3,4,3,28,8,9,48,2,8,6,9,15,68,NULL,NULL,44,NULL,NULL,NULL,0),('starter',68,'Loup Garou',0,'E','Hétérosexuel','Q',0,'F',12,5,5,5,4,7,6,4,7,21,1,9,6,7,13,67,NULL,NULL,67,NULL,NULL,NULL,0),('starter',69,'Vampire',0,'O','Hétérosexuel','O',0,'M',1,1,15,4,5,9,22,20,3,39,9,2,12,3,14,70,NULL,NULL,17,NULL,NULL,NULL,0),('starter',70,'Vampire',0,'W','Hétérosexuel','M',0,'F',1,3,16,3,5,2,3,19,5,43,1,10,12,5,4,69,NULL,NULL,34,NULL,NULL,NULL,0),('starter',71,'Génie',0,'Fabre','Hétérosexuel','Bastien',0,'M',13,3,10,7,1,3,11,12,4,38,7,1,3,6,14,72,8,8,16,NULL,NULL,NULL,0),('starter',72,'Sirène',0,'Fabre','Hétérosexuel','Zoé',0,'F',12,8,5,3,1,1,2,9,7,3,10,7,3,6,5,71,8,8,37,NULL,NULL,'Justin',0),('starter',73,'Humain',0,'F','Hétérosexuel','X',0,'M',9,2,15,7,2,5,14,22,4,23,8,7,11,2,7,74,NULL,NULL,57,NULL,NULL,NULL,0),('starter',74,'Humain',0,'Y','Hétérosexuel','F',0,'F',12,3,14,6,2,10,24,21,4,46,9,5,8,9,1,73,NULL,NULL,52,NULL,NULL,NULL,0),('starter',75,'Végésim',0,'F','Hétérosexuel','I',0,'M',13,3,14,8,5,6,17,14,4,40,7,5,9,10,15,76,NULL,NULL,51,NULL,NULL,NULL,0),('starter',76,'Loup Garou',0,'B','Hétérosexuel','K',0,'F',11,6,13,1,5,5,14,10,9,43,5,7,9,8,2,75,NULL,NULL,45,NULL,NULL,NULL,0),('starter',77,'Humain',0,'I','Hétérosexuel','S',0,'M',17,7,2,6,4,7,28,3,1,23,4,9,6,1,1,78,NULL,NULL,79,NULL,NULL,NULL,0),('starter',78,'Humain',0,'T','Hétérosexuel','Q',0,'F',11,7,5,5,4,4,28,13,6,20,7,3,9,3,6,77,NULL,NULL,70,NULL,NULL,NULL,0),('starter',79,'Sirène',0,'U','Hétérosexuel','S',0,'M',4,5,11,5,2,10,8,4,4,37,7,9,1,7,5,80,NULL,NULL,26,NULL,NULL,NULL,0),('starter',80,'Loup Garou',0,'S','Hétérosexuel','B',0,'F',14,4,3,3,2,7,6,5,10,50,10,1,1,9,1,79,NULL,NULL,71,NULL,NULL,NULL,0),('starter',81,'Loup Garou',0,'V','Hétérosexuel','C',0,'M',16,2,9,8,2,5,16,7,6,14,4,7,2,7,13,82,NULL,NULL,26,NULL,NULL,NULL,0),('starter',82,'Génie',0,'P','Hétérosexuel','U',0,'F',17,7,19,4,2,7,12,17,7,14,8,3,12,9,7,81,NULL,NULL,22,NULL,NULL,NULL,0),('starter',83,'Fée',0,'W','Hétérosexuel','P',0,'M',16,1,2,5,4,4,15,21,2,7,2,6,1,3,8,84,NULL,NULL,30,NULL,NULL,NULL,0),('starter',84,'Sorcier',0,'N','Hétérosexuel','Q',0,'F',15,1,2,2,4,1,1,18,1,13,2,10,11,9,14,83,NULL,NULL,58,NULL,NULL,NULL,0),('starter',85,'Sirène',0,'X','Hétérosexuel','J',0,'M',16,8,8,8,4,10,20,15,9,51,7,2,2,11,4,86,NULL,NULL,3,NULL,NULL,NULL,0),('starter',86,'Sirène',0,'D','Hétérosexuel','K',0,'F',11,5,9,7,4,2,11,17,8,34,3,8,12,1,11,85,NULL,NULL,36,NULL,NULL,NULL,0),('starter',87,'Loup Garou',0,'J','Hétérosexuel','G',0,'M',10,4,13,6,5,1,9,7,2,22,2,9,8,2,12,88,NULL,NULL,9,NULL,NULL,NULL,0),('starter',88,'Humain',0,'J','Hétérosexuel','O',0,'F',9,1,5,4,5,6,2,19,3,45,1,1,8,7,12,87,NULL,NULL,53,NULL,NULL,NULL,0),('starter',89,'Fantôme',0,'I','Hétérosexuel','O',0,'M',7,8,14,7,3,5,20,11,7,49,9,6,11,6,4,90,NULL,NULL,73,NULL,NULL,NULL,0),('starter',90,'Humain',0,'O','Hétérosexuel','X',0,'F',14,2,14,6,3,9,26,20,8,46,3,5,9,2,9,89,NULL,NULL,65,NULL,NULL,NULL,0),('starter',91,'Sorcier',0,'K','Hétérosexuel','C',0,'M',13,2,14,8,5,9,20,17,3,4,4,10,2,7,13,92,NULL,NULL,52,NULL,NULL,NULL,0),('starter',92,'Humain',0,'A','Hétérosexuel','S',0,'F',2,6,17,1,5,2,17,9,3,50,7,9,12,4,11,91,NULL,NULL,25,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `sims` ENABLE KEYS */;
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
