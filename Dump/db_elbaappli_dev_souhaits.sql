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
-- Table structure for table `souhaits`
--

DROP TABLE IF EXISTS `souhaits`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `souhaits` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `souhaits`
--

LOCK TABLES `souhaits` WRITE;
/*!40000 ALTER TABLE `souhaits` DISABLE KEYS */;
INSERT INTO `souhaits` VALUES (1,'Acteur Superstar'),(2,'Artisan alchimiste'),(3,'Artiste de rue crédible'),(4,'Artiste du blog'),(5,'As du design interieur'),(6,'Auteur professionnel'),(7,'Bourreau des cœurs'),(8,'Casanova'),(9,'Chef de la meute'),(10,'Chirurgien de renommée mondiale'),(11,'Collectionneur high-tech'),(12,'Compagnon des chiens'),(13,'Compositeur de bande originale'),(14,'Créateur de monstres'),(15,'Création d\'arche'),(16,'Créer le parfait aquarium privé'),(17,'Célèbre chef cinq étoiles'),(18,'Des mots et des doigts en or'),(19,'Descendant de Da Vinci'),(20,'Devenir astronaute'),(21,'Devenir le roi des voleurs'),(22,'Devenir un athlète superstar'),(23,'Devenir éleveur de cyborgs'),(24,'Dirigeant du monde libre'),(25,'Détective privé omniprésent'),(26,'Empire hôtelier'),(27,'Entouré par une famille'),(28,'Espion international'),(29,'Etudiant magistral'),(30,'Etudiant parfait'),(31,'Extrêmement populaire'),(32,'Fan de félins'),(33,'Galerie de niveau mondial'),(34,'Grand acrobate'),(35,'Grand explorateur'),(36,'Grand magicien'),(37,'Illustre auteur'),(38,'Jardins plus verts'),(39,'Jockey'),(40,'L\'empereur du mal'),(41,'La vie des VIP'),(42,'Le sim-orchestre'),(43,'Le bibliothécaire culinaire'),(44,'Le jardin parfait'),(45,'Légende des échecs'),(46,'Légende vocale'),(47,'Maître des arts martiaux'),(48,'Maître du mysticisme'),(49,'Mixologue magistral'),(50,'Musée privé'),(51,'Médium pour célébrités'),(52,'Obtenir une influence maximale sur tous les groupes sociaux'),(53,'Opportuniste'),(54,'PDG dune multinationale'),(55,'Perfection physique'),(56,'Plongeur des profondeurs'),(57,'Plus qu\'une machine'),(58,'Prendre du bon temps'),(59,'Pro du paranormal'),(60,'Protection d\'animaux'),(61,'Présentateur des actualités '),(62,'Relooking magique'),(63,'Rock star'),(64,'Réalisateur reconnu'),(65,'Sauveteur de bord de mer'),(66,'Si j\'ai un objet dans la main il est à moi'),(67,'Sim au multiples talents'),(68,'Soigneur mystique'),(69,'Spécialiste des arts'),(70,'Spécialiste des licornes'),(71,'Spécialiste en médecine légale'),(72,'Spécialiste scientifique'),(73,'Superhéros des pompiers'),(74,'Transformer la ville'),(75,'Un esprit parfait dans un corps parfait'),(76,'Une cave à nectar sans fond'),(77,'Visionnaire'),(78,'Vivre dans le grand luxe'),(79,'Voyageur expérimenté'),(80,'Zombificateur magistral'),(81,'Zoologiste');
/*!40000 ALTER TABLE `souhaits` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-28 23:20:41
