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
-- Table structure for table `traits`
--

DROP TABLE IF EXISTS `traits`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `traits` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `traits`
--

LOCK TABLES `traits` WRITE;
/*!40000 ALTER TABLE `traits` DISABLE KEYS */;
INSERT INTO `traits` VALUES (1,'A l\'aise avec les jeunes','Mental'),(2,'Allergique à l\'art','Mental'),(3,'Artiste','Mental'),(4,'Avant gardiste','Mental'),(5,'Bricoleurs','Mental'),(6,'Cordon Bleu','Mental'),(7,'Dénicheur','Mental'),(8,'Etourdi','Mental'),(9,'Excentrique','Mental'),(10,'Excité','Mental'),(11,'Fou','Mental'),(12,'Génie','Mental'),(13,'Génie de l\'informatique','Mental'),(14,'Instable','Mental'),(15,'Main Verte','Mental'),(16,'Névrosé','Mental'),(17,'Perspicace','Mental'),(18,'Rat de bibliothèque','Mental'),(19,'Sculpteur doué','Mental'),(20,'Virtuose','Mental'),(21,'Œil de photographe','Mental'),(22,'Adore nager','Physique'),(23,'Aime la chaleur','Physique'),(24,'Aime le froid','Physique'),(25,'Athlète','Physique'),(26,'Chanceux','Physique'),(27,'Courageux','Physique'),(28,'Crasseux','Physique'),(29,'Discipliné','Physique'),(30,'Lâche','Physique'),(31,'Maladroit','Physique'),(32,'Malchanceux','Physique'),(33,'Marin','Physique'),(34,'Pantouflard','Physique'),(35,'Peur de l\'eau','Physique'),(36,'Pudique','Physique'),(37,'Soigneux','Physique'),(38,'Sommeil lourd','Physique'),(39,'Sommeil léger','Physique'),(40,'Allergique aux enfants','Social'),(41,'Amical','Social'),(42,'Artiste né','Social'),(43,'Aucun sens de l\'humour','Social'),(44,'Baisers divins','Social'),(45,'Charismatique','Social'),(46,'Diva','Social'),(47,'En pleine introspection','Social'),(48,'Enjôleur','Social'),(49,'Ermite','Social'),(50,'Excessif','Social'),(51,'Fan de surnaturel','Social'),(52,'Froid','Social'),(53,'Fêtard','Social'),(54,'Grognon','Social'),(55,'Impressionnable','Social'),(56,'Incorrect','Social'),(57,'Irrésistible','Social'),(58,'Loser','Social'),(59,'Lèche-bottes','Social'),(60,'Mal à l\'aise en société','Social'),(61,'Mesquin','Social'),(62,'Parasite','Social'),(63,'Plus que romantique','Social'),(64,'Respectable','Social'),(65,'Réticent au surnaturel','Social'),(66,'Réticent à s\'engager','Social'),(67,'Sens de l\'humour','Social'),(68,'Snob','Social'),(69,'Timide','Social'),(70,'Ultrasociable','Social'),(71,'Vendeur né','Social'),(72,'Aime les animaux','Style de vie'),(73,'Aime les chats','Style de vie'),(74,'Aime les chiens','Style de vie'),(75,'Allergique à la nature','Style de vie'),(76,'Ambitieux','Style de vie'),(77,'Amoureux de la nature','Style de vie'),(78,'Aventureux','Style de vie'),(79,'Bienveillant','Style de vie'),(80,'Bourreau de travail','Style de vie'),(81,'Casse-cou','Style de vie'),(82,'Cavalier','Style de vie'),(83,'Ecolo','Style de vie'),(84,'Econome','Style de vie'),(85,'Fan de robots','Style de vie'),(86,'Grand gamin','Style de vie'),(87,'Hypersensible','Style de vie'),(88,'Kleptomane','Style de vie'),(89,'Malveillant','Style de vie'),(90,'Oiseau de nuit','Style de vie'),(91,'Passionné d\'automobile','Style de vie'),(92,'Perfectionniste','Style de vie'),(93,'Pêcheur','Style de vie'),(94,'Rebelle','Style de vie'),(95,'Sang chaud','Style de vie'),(96,'Star par nature','Style de vie'),(97,'Technophobe','Style de vie'),(98,'Tourné vers la famille','Style de vie'),(99,'Végétarien','Style de vie');
/*!40000 ALTER TABLE `traits` ENABLE KEYS */;
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
