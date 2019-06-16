CREATE DATABASE  IF NOT EXISTS `db_elbaappli` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `db_elbaappli`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_elbaappli
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
-- Table structure for table `classes`
--

DROP TABLE IF EXISTS `classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) DEFAULT NULL,
  `classeSup_id` int(11) DEFAULT NULL,
  `quartier_id` int(11) DEFAULT NULL,
  `chef_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_q8ox85ngdgb0xf8tvv5xrlul7` (`classeSup_id`),
  KEY `FK_5umqw2rwebgdau1mf64k5guy` (`quartier_id`),
  KEY `FK_qxbmdu8hb624qwouc9stj46rc` (`chef_id`),
  CONSTRAINT `FK_5umqw2rwebgdau1mf64k5guy` FOREIGN KEY (`quartier_id`) REFERENCES `quartiers` (`id`),
  CONSTRAINT `FK_q8ox85ngdgb0xf8tvv5xrlul7` FOREIGN KEY (`classeSup_id`) REFERENCES `classes` (`id`),
  CONSTRAINT `FK_qxbmdu8hb624qwouc9stj46rc` FOREIGN KEY (`chef_id`) REFERENCES `sims` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classes`
--

LOCK TABLES `classes` WRITE;
/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
INSERT INTO `classes` VALUES (1,'Illégitime',NULL,3,NULL),(2,'Paysan',3,3,NULL),(3,'Pauvre',4,3,NULL),(4,'Modeste',5,4,NULL),(5,'Aisée',6,4,NULL),(6,'Riche',7,5,NULL),(7,'Noblesse',NULL,5,NULL);
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comptes`
--

DROP TABLE IF EXISTS `comptes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comptes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `depot` int(11) NOT NULL,
  `montant` bigint(20) NOT NULL,
  `retrait` int(11) NOT NULL,
  `taux` bigint(20) NOT NULL,
  `famille_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_3n14xdohatik888u4t6uwsi8k` (`famille_id`),
  CONSTRAINT `FK_3n14xdohatik888u4t6uwsi8k` FOREIGN KEY (`famille_id`) REFERENCES `familles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comptes`
--

LOCK TABLES `comptes` WRITE;
/*!40000 ALTER TABLE `comptes` DISABLE KEYS */;
INSERT INTO `comptes` VALUES (1,0,60429,0,4,1),(2,0,3480,0,4,2),(3,0,1040,0,4,3),(4,0,1976,0,4,4),(5,0,104,0,4,5),(6,0,104,0,4,6),(7,0,1040,0,4,7),(8,0,2971,0,4,8),(9,0,5000,0,4,9),(10,0,5000,0,4,10),(11,0,5000,0,4,11),(12,0,5000,0,4,12),(13,0,5000,0,4,13),(14,0,5000,0,4,14),(15,0,5000,0,4,15),(16,0,5000,0,4,16);
/*!40000 ALTER TABLE `comptes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conditions`
--

DROP TABLE IF EXISTS `conditions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conditions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `valeurMax` bigint(20) NOT NULL,
  `valeurMin` bigint(20) NOT NULL,
  `classe_id` int(11) DEFAULT NULL,
  `passage_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_trk663d5x1x6g2q077blmnv47` (`classe_id`),
  KEY `FK_30qx6fu3bmweeap7c87dtqf24` (`passage_id`),
  CONSTRAINT `FK_30qx6fu3bmweeap7c87dtqf24` FOREIGN KEY (`passage_id`) REFERENCES `passages` (`id`),
  CONSTRAINT `FK_trk663d5x1x6g2q077blmnv47` FOREIGN KEY (`classe_id`) REFERENCES `classes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conditions`
--

LOCK TABLES `conditions` WRITE;
/*!40000 ALTER TABLE `conditions` DISABLE KEYS */;
INSERT INTO `conditions` VALUES (1,0,8000,3,1),(3,0,8000,3,2),(4,0,10000,3,3),(5,0,0,3,4),(6,0,5,3,5),(7,0,20,3,7),(8,0,3,3,8),(9,0,5,3,10),(11,0,10,3,11),(12,0,4,3,12),(13,0,10,3,13);
/*!40000 ALTER TABLE `conditions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `devoirs`
--

DROP TABLE IF EXISTS `devoirs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `devoirs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categorie` varchar(255) DEFAULT NULL,
  `commentaire` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `precisions` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `devoirs`
--

LOCK TABLES `devoirs` WRITE;
/*!40000 ALTER TABLE `devoirs` DISABLE KEYS */;
/*!40000 ALTER TABLE `devoirs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `droits`
--

DROP TABLE IF EXISTS `droits`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `droits` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categorie` varchar(255) DEFAULT NULL,
  `commentaire` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `precisions` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `droits`
--

LOCK TABLES `droits` WRITE;
/*!40000 ALTER TABLE `droits` DISABLE KEYS */;
INSERT INTO `droits` VALUES (11,'abc','abc','abc','abc'),(12,'def','def','def','def'),(13,'ghi','ghi','ghi','ghi');
/*!40000 ALTER TABLE `droits` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `familles`
--

LOCK TABLES `familles` WRITE;
/*!40000 ALTER TABLE `familles` DISABLE KEYS */;
INSERT INTO `familles` VALUES (1,1000,1,'Lagasca',17,3,3),(2,100,1,'Queton',23,3,11),(3,209,1,'Ivanov',35,3,15),(4,100,1,'Matcha',39,3,4),(5,100,1,'Maurice',41,3,12),(6,100,1,'Ferron',45,3,5),(7,100,1,'Durand',49,3,16),(8,100,1,'Fabre',71,3,6),(9,0,1,'Irin',2,3,NULL),(10,0,1,'Rowena',13,3,NULL),(11,0,1,'Kart',19,3,NULL),(12,0,1,'Belan',33,3,NULL),(13,0,1,'André',63,3,NULL),(14,0,1,'Ferrandi',73,3,NULL),(15,0,1,'Sorel',80,3,NULL),(16,0,1,'Petit',82,3,NULL);
/*!40000 ALTER TABLE `familles` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `liaisoncofa`
--

DROP TABLE IF EXISTS `liaisoncofa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `liaisoncofa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `commentaire` varchar(255) DEFAULT NULL,
  `progression` varchar(255) DEFAULT NULL,
  `valeur` bigint(20) NOT NULL,
  `valide` tinyint(1) NOT NULL,
  `condition_id` int(11) DEFAULT NULL,
  `famille_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_5bcrhsctrs4x6a9gsf1ucl15b` (`condition_id`),
  KEY `FK_3vd3xa4295m4ttieb1si8t41s` (`famille_id`),
  CONSTRAINT `FK_3vd3xa4295m4ttieb1si8t41s` FOREIGN KEY (`famille_id`) REFERENCES `familles` (`id`),
  CONSTRAINT `FK_5bcrhsctrs4x6a9gsf1ucl15b` FOREIGN KEY (`condition_id`) REFERENCES `conditions` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `liaisoncofa`
--

LOCK TABLES `liaisoncofa` WRITE;
/*!40000 ALTER TABLE `liaisoncofa` DISABLE KEYS */;
/*!40000 ALTER TABLE `liaisoncofa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `liasonsdrcl`
--

DROP TABLE IF EXISTS `liasonsdrcl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `liasonsdrcl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `valeurMax` double DEFAULT NULL,
  `valeurMin` double DEFAULT NULL,
  `classe_id` int(11) DEFAULT NULL,
  `droit_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ghva8rq54ddsdc4vcn2ddwmh` (`classe_id`),
  KEY `FK_g6qv8cw1vp88ehtd2d0wjjkse` (`droit_id`),
  CONSTRAINT `FK_g6qv8cw1vp88ehtd2d0wjjkse` FOREIGN KEY (`droit_id`) REFERENCES `droits` (`id`),
  CONSTRAINT `FK_ghva8rq54ddsdc4vcn2ddwmh` FOREIGN KEY (`classe_id`) REFERENCES `classes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `liasonsdrcl`
--

LOCK TABLES `liasonsdrcl` WRITE;
/*!40000 ALTER TABLE `liasonsdrcl` DISABLE KEYS */;
/*!40000 ALTER TABLE `liasonsdrcl` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `liasonssitr`
--

DROP TABLE IF EXISTS `liasonssitr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `liasonssitr` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `heritage1` tinyint(1) NOT NULL,
  `heritage2` tinyint(1) NOT NULL,
  `heritage3` tinyint(1) NOT NULL,
  `heritage4` tinyint(1) NOT NULL,
  `heritage5` tinyint(1) NOT NULL,
  `sim_id` int(11) DEFAULT NULL,
  `trait1_id` int(11) DEFAULT NULL,
  `trait2_id` int(11) DEFAULT NULL,
  `trait3_id` int(11) DEFAULT NULL,
  `trait4_id` int(11) DEFAULT NULL,
  `trait5_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_4jwwxprphsr0q8gm3b36blpxq` (`sim_id`),
  KEY `FK_d9c7ujal0x0oq5bhauxmd5t2s` (`trait1_id`),
  KEY `FK_gaey4nc7ip6mf6dx19x34sbty` (`trait2_id`),
  KEY `FK_14g1bkixs7vvqbg7trriphs6i` (`trait3_id`),
  KEY `FK_9scwsn5ef34ejfs3ufqmji478` (`trait4_id`),
  KEY `FK_p2v7fbsbunqb6psv0khmcvi3e` (`trait5_id`),
  CONSTRAINT `FK_14g1bkixs7vvqbg7trriphs6i` FOREIGN KEY (`trait3_id`) REFERENCES `traits` (`id`),
  CONSTRAINT `FK_4jwwxprphsr0q8gm3b36blpxq` FOREIGN KEY (`sim_id`) REFERENCES `sims` (`id`),
  CONSTRAINT `FK_9scwsn5ef34ejfs3ufqmji478` FOREIGN KEY (`trait4_id`) REFERENCES `traits` (`id`),
  CONSTRAINT `FK_d9c7ujal0x0oq5bhauxmd5t2s` FOREIGN KEY (`trait1_id`) REFERENCES `traits` (`id`),
  CONSTRAINT `FK_gaey4nc7ip6mf6dx19x34sbty` FOREIGN KEY (`trait2_id`) REFERENCES `traits` (`id`),
  CONSTRAINT `FK_p2v7fbsbunqb6psv0khmcvi3e` FOREIGN KEY (`trait5_id`) REFERENCES `traits` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `liasonssitr`
--

LOCK TABLES `liasonssitr` WRITE;
/*!40000 ALTER TABLE `liasonssitr` DISABLE KEYS */;
INSERT INTO `liasonssitr` VALUES (1,0,0,0,0,0,1,21,27,42,72,43),(2,0,0,0,0,0,2,4,35,56,87,90),(3,0,0,0,0,0,3,2,29,70,85,69),(4,0,0,0,0,0,4,19,35,55,96,2),(5,0,0,0,0,0,5,18,23,62,94,79),(6,0,0,0,0,0,6,1,32,45,99,50),(9,0,0,0,0,0,9,21,32,45,98,4),(10,0,0,0,0,0,10,6,30,58,78,26),(13,0,0,0,0,0,13,1,32,44,94,60),(14,0,0,0,0,0,14,10,33,65,78,97),(15,0,0,0,0,0,15,2,29,47,82,65),(16,0,0,0,0,0,16,6,32,57,76,34),(17,0,0,0,0,0,17,12,35,58,91,20),(18,0,0,0,0,0,18,19,35,45,90,15),(19,0,0,0,0,0,19,1,35,49,98,31),(20,0,0,0,0,0,20,1,37,49,97,48),(21,0,0,0,0,0,21,14,34,58,78,62),(22,0,0,0,0,0,22,20,33,70,73,71),(23,0,0,0,0,0,23,12,22,53,92,26),(24,0,0,0,0,0,24,1,33,71,74,21),(25,0,0,0,0,0,25,17,26,49,76,14),(26,0,0,0,0,0,26,14,33,55,93,93),(27,0,0,0,0,0,27,12,24,42,90,60),(28,0,0,0,0,0,28,4,31,63,80,97),(29,0,0,0,0,0,29,5,31,53,75,32),(30,0,0,0,0,0,30,3,38,49,83,71),(31,0,0,0,0,0,31,10,33,59,80,69),(32,0,0,0,0,0,32,18,27,49,84,85),(33,0,0,0,0,0,33,19,29,62,73,60),(34,0,0,0,0,0,34,14,31,45,88,90),(35,0,0,0,0,0,35,14,37,40,75,46),(36,0,0,0,0,0,36,7,30,58,98,88),(39,0,0,0,0,0,39,13,23,44,98,12),(40,0,0,0,0,0,40,1,30,60,73,6),(41,0,0,0,0,0,41,18,28,49,76,87),(42,0,0,0,0,0,42,1,23,54,88,11),(45,0,0,0,0,0,45,4,26,59,78,51),(46,0,0,0,0,0,46,3,39,46,90,53),(49,0,0,0,0,0,49,16,27,65,99,42),(50,0,0,0,0,0,50,16,36,49,92,94),(51,0,0,0,0,0,51,13,24,55,74,70),(52,0,0,0,0,0,52,21,33,40,94,17),(53,0,0,0,0,0,53,10,26,45,92,60),(54,0,0,0,0,0,54,7,30,48,90,64),(55,0,0,0,0,0,55,14,23,45,99,50),(56,0,0,0,0,0,56,15,25,58,95,3),(57,0,0,0,0,0,57,20,28,57,92,93),(58,0,0,0,0,0,58,10,38,47,92,3),(61,0,0,0,0,0,61,17,22,42,95,73),(62,0,0,0,0,0,62,19,25,49,91,40),(63,0,0,0,0,0,63,2,34,64,93,66),(64,0,0,0,0,0,64,1,35,70,88,4),(65,0,0,0,0,0,65,5,37,45,81,5),(66,0,0,0,0,0,66,18,31,49,97,66),(67,0,0,0,0,0,67,2,33,62,82,54),(68,0,0,0,0,0,68,8,29,46,85,50),(69,0,0,0,0,0,69,6,37,69,90,41),(70,0,0,0,0,0,70,21,22,51,84,96),(71,0,0,0,0,0,71,20,31,40,94,3),(72,0,0,0,0,0,72,13,28,63,82,46),(73,0,0,0,0,0,73,15,26,55,87,97),(74,0,0,0,0,0,74,11,32,42,77,47),(75,0,0,0,0,0,75,19,29,52,85,70),(76,0,0,0,0,0,76,16,27,56,87,19),(77,0,0,0,0,0,77,2,22,48,83,19),(78,0,0,0,0,0,78,4,35,55,72,68),(79,0,0,0,0,0,79,7,29,62,82,5),(80,0,0,0,0,0,80,3,29,65,74,75),(81,0,0,0,0,0,81,21,29,53,91,40),(82,0,0,0,0,0,82,15,31,47,85,9),(83,0,0,0,0,0,83,13,35,65,84,78),(84,0,0,0,0,0,84,18,33,71,78,57),(85,0,0,0,0,0,85,14,36,57,80,72),(86,0,0,0,0,0,86,17,25,54,74,56),(87,0,0,0,0,0,87,2,30,53,93,66),(88,0,0,0,0,0,88,5,32,41,96,88),(89,0,0,0,0,0,89,2,36,69,85,7),(90,0,0,0,0,0,90,5,25,59,87,79),(91,0,0,0,0,0,91,17,27,66,78,6),(92,0,0,0,0,0,92,20,25,62,72,16),(93,0,0,0,0,0,93,77,28,NULL,NULL,NULL),(94,0,0,0,0,0,94,12,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `liasonssitr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passages`
--

DROP TABLE IF EXISTS `passages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `passages` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categorie` varchar(255) DEFAULT NULL,
  `commentaire` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `precisions` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passages`
--

LOCK TABLES `passages` WRITE;
/*!40000 ALTER TABLE `passages` DISABLE KEYS */;
INSERT INTO `passages` VALUES (1,'Propriété','Minimale seulement pour le moment','Valeur résidence principale','Valeur meublée de la résidence principale de la famille'),(2,'Propriété','Valeur meublée de tous les terrains possédés','Valeur de tous les terrains possédés','Valeur meublée de tous les terrains possédés'),(3,'Finances','Argent in game de la famille','Valeur du compte courant','Argent in game de la famille'),(4,'Finances','0 = aucun','Prêt bancaire non remboursé','Nombre de prêts bancaires non remboursés'),(5,'Compétence','Au moins niveau 1','Nombre connues adultes','Nombre de compétences connues par un adulte'),(6,'Compétence','Niveau 10','Nombre maîtrisées adultes','Nombre de compétences maîtrisées par un adulte'),(7,'Compétence','1 point par niveau par compétence','Points compétences adultes','Nombre de points de compétences pour un adulte'),(8,'Compétence','Niveau 1 minimum','Nombre connues enfants','Nombre de compétences connues par un enfant'),(9,'Compétence','Niveau 10','Nombre maîtrisées enfants','Nombre de compétences maîtrisées par un enfant'),(10,'Compétence','1 point par niveau par compétence','Points compétences enfants','Nombre de points de compétences pour un enfant'),(11,'Compétence','Niveau 1 minimum','Nombre connues famille','Nombre compétences connues par la famille'),(12,'Compétence','Niveau 10','Nombre maîtrisées famille','Nombre compétences maîtrisées par la famille'),(13,'Compétence','1 point par niveau par compétence','Points compétences famille','Nombre de points de compétences pour la famille');
/*!40000 ALTER TABLE `passages` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prets`
--

LOCK TABLES `prets` WRITE;
/*!40000 ALTER TABLE `prets` DISABLE KEYS */;
INSERT INTO `prets` VALUES (1,1,0,0,0,0,5,1),(2,1,0,0,0,0,5,1),(3,1,0,0,0,0,5,2),(4,0,262,0,5512,5250,5,3),(5,0,262,0,5512,5250,5,4),(6,0,43,0,917,874,5,5),(7,1,0,0,0,0,5,6),(8,0,236,0,4961,4725,5,6),(10,0,146,0,3077,2931,5,7),(11,1,0,0,0,0,5,8);
/*!40000 ALTER TABLE `prets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quartiers`
--

DROP TABLE IF EXISTS `quartiers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quartiers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quartiers`
--

LOCK TABLES `quartiers` WRITE;
/*!40000 ALTER TABLE `quartiers` DISABLE KEYS */;
INSERT INTO `quartiers` VALUES (1,'Isolé'),(2,'Campagne'),(3,'Rural'),(4,'Modeste'),(5,'Riche'),(6,'Divertissement'),(7,'Centre-Ville'),(8,'Université'),(9,'Vacancier');
/*!40000 ALTER TABLE `quartiers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rabbitholes`
--

DROP TABLE IF EXISTS `rabbitholes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rabbitholes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rabbitholes`
--

LOCK TABLES `rabbitholes` WRITE;
/*!40000 ALTER TABLE `rabbitholes` DISABLE KEYS */;
INSERT INTO `rabbitholes` VALUES (1,'Repaire'),(2,'Restaurant'),(3,'Librairie'),(4,'Hôtel de ville'),(5,'Fast Food'),(6,'Epicerie'),(7,'Hôpital'),(8,'Mausolée'),(9,'Base'),(10,'Centre d\'affaire'),(11,'Comissariat'),(12,'Ecole'),(13,'Laboratoire'),(14,'Spa'),(15,'Stade'),(16,'Théàtre'),(17,'Cinéma'),(18,'Métro'),(19,'Centre équestre'),(20,'Caravane'),(21,'Arboterum'),(22,'Temple'),(23,'Centre administratif'),(24,'Annexe'),(25,'Ecole de science'),(26,'Ecole d\'art'),(27,'Ecole de commerce'),(28,'Bistro (Showtime)');
/*!40000 ALTER TABLE `rabbitholes` ENABLE KEYS */;
UNLOCK TABLES;

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
  `heritier` tinyint(1) NOT NULL,
  `legitime` tinyint(1) NOT NULL,
  `mort` tinyint(1) NOT NULL,
  `adulte` tinyint(1) NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sims`
--

LOCK TABLES `sims` WRITE;
/*!40000 ALTER TABLE `sims` DISABLE KEYS */;
INSERT INTO `sims` VALUES ('starter',1,'5',0,'Irin','1','Kévin',0,'0',6,5,3,2,2,3,8,18,4,3,6,1,5,8,4,2,9,9,24,NULL,NULL,'Xander',0,0,0,1),('starter',2,'4',0,'Irin','1','Konrad',0,'0',3,3,2,3,2,8,4,7,4,42,4,7,5,8,12,1,9,9,30,NULL,NULL,NULL,0,0,0,1),('starter',3,'0',0,'G','1','C',0,'0',14,8,18,2,4,2,25,24,8,5,6,5,5,10,5,4,NULL,NULL,30,NULL,NULL,NULL,0,0,0,1),('starter',4,'0',0,'E','1','M',0,'0',17,5,9,4,4,5,25,15,10,40,4,8,1,8,11,3,NULL,NULL,26,NULL,NULL,NULL,0,0,0,1),('starter',5,'0',0,'C','1','L',0,'0',2,2,15,8,5,4,9,23,1,12,4,8,2,3,7,6,NULL,NULL,60,NULL,NULL,NULL,0,0,0,1),('starter',6,'0',0,'J','1','X',0,'0',6,4,1,3,5,1,15,7,2,39,6,9,8,1,8,5,NULL,NULL,9,NULL,NULL,NULL,0,0,0,1),('starter',9,'0',0,'B','1','F',0,'1',16,2,9,1,5,10,11,8,10,27,4,1,7,11,9,10,NULL,NULL,4,NULL,NULL,NULL,0,0,0,1),('starter',10,'0',0,'F','1','G',0,'1',15,7,1,5,5,2,23,4,10,39,3,7,12,6,5,9,NULL,NULL,62,NULL,NULL,NULL,0,0,0,1),('starter',13,'7',0,'Rowena','1','Wanda',0,'1',12,3,12,6,2,2,24,3,10,10,2,7,4,8,10,14,10,10,65,NULL,NULL,NULL,0,0,0,1),('starter',14,'3',0,'Rowena','1','Irina',0,'1',14,2,6,4,2,3,10,19,2,31,4,7,4,11,11,13,10,10,35,NULL,NULL,'Tesla',0,0,0,1),('starter',15,'1',0,'R','1','S',0,'1',13,4,2,8,5,4,19,9,9,35,8,4,6,10,1,16,NULL,NULL,66,NULL,NULL,NULL,0,0,0,1),('starter',16,'8',0,'I','1','W',0,'1',3,2,14,2,5,8,12,6,9,3,9,6,11,10,7,15,NULL,NULL,49,NULL,NULL,NULL,0,0,0,1),('starter',17,'1',0,'Lagasca','1','Flora',0,'1',16,2,20,2,1,10,2,3,8,41,4,9,10,4,14,18,1,1,81,NULL,NULL,NULL,0,0,0,1),('starter',18,'1',1,'Lagasca','1','Wendi',0,'1',1,6,19,2,1,3,21,5,4,44,5,8,5,6,15,17,1,1,23,NULL,NULL,'Zein',0,0,0,1),('starter',19,'0',0,'Kart','0','Noé',0,'0',6,4,13,5,2,7,19,9,3,45,10,2,5,8,11,20,11,11,12,NULL,NULL,NULL,0,0,0,1),('starter',20,'0',0,'Kart','0','Inna',0,'1',16,4,13,5,2,7,22,11,5,48,6,10,5,4,2,19,11,11,36,NULL,NULL,'Simon',0,0,0,1),('starter',21,'0',0,'U','0','K',0,'0',1,1,2,5,5,9,15,4,6,30,2,8,7,1,14,22,NULL,NULL,34,NULL,NULL,NULL,0,0,0,1),('starter',22,'0',0,'B','0','P',0,'1',11,2,15,6,5,6,15,19,9,22,10,5,7,10,5,21,NULL,NULL,70,NULL,NULL,NULL,0,0,0,1),('starter',23,'2',0,'Queton','0','Domenico',0,'0',16,6,19,4,1,7,22,22,10,1,3,6,12,11,5,24,2,2,31,NULL,NULL,NULL,0,0,0,1),('starter',24,'2',0,'Queton','0','Kendra',0,'1',11,4,19,8,1,10,19,2,10,6,6,3,12,5,11,23,2,2,23,NULL,NULL,'Xanthis',0,0,0,1),('starter',25,'2',0,'P','0','M',0,'0',11,1,3,7,3,3,9,24,8,11,2,6,9,6,11,26,NULL,NULL,73,NULL,NULL,NULL,0,0,0,1),('starter',26,'8',0,'W','0','Q',0,'1',6,4,3,1,3,7,27,19,8,21,6,8,9,7,1,25,NULL,NULL,67,NULL,NULL,NULL,0,0,0,1),('starter',27,'0',0,'M','0','E',0,'0',17,7,12,2,3,6,1,8,9,6,7,4,11,8,13,28,NULL,NULL,3,NULL,NULL,NULL,0,0,0,1),('starter',28,'0',0,'F','0','X',0,'1',13,3,6,4,3,6,27,10,9,40,1,2,11,1,12,27,NULL,NULL,38,NULL,NULL,NULL,0,0,0,1),('starter',29,'0',0,'C','0','C',0,'0',1,8,4,1,3,1,12,4,8,24,3,8,10,12,1,30,NULL,NULL,65,NULL,NULL,NULL,0,0,0,1),('starter',30,'0',0,'M','0','E',0,'1',2,3,6,2,3,2,15,23,9,37,9,7,10,10,6,29,NULL,NULL,72,NULL,NULL,NULL,0,0,0,1),('starter',31,'0',0,'E','0','U',0,'0',10,1,9,4,4,10,20,13,6,43,9,10,4,6,1,32,NULL,NULL,56,NULL,NULL,NULL,0,0,0,1),('starter',32,'0',0,'H','0','A',0,'1',17,6,4,6,4,7,22,6,7,19,3,7,4,5,9,31,NULL,NULL,71,NULL,NULL,NULL,0,0,0,1),('starter',33,'0',0,'Belan','0','Ian',0,'0',10,3,7,4,2,4,18,17,10,14,10,10,3,8,15,34,12,12,23,NULL,NULL,NULL,0,0,0,1),('starter',34,'0',0,'Belan','0','Erika',0,'1',13,6,11,6,2,8,27,10,9,23,4,10,3,2,14,33,12,12,71,NULL,NULL,'Thomas',0,0,0,1),('starter',35,'0',0,'Ivanov','0','Pavel',0,'0',1,4,17,6,1,8,8,7,5,47,10,6,4,11,12,36,3,3,38,NULL,NULL,NULL,0,0,0,1),('starter',36,'0',0,'Ivanov','0','Quetty',0,'1',10,3,3,4,1,10,23,20,4,38,7,6,4,3,1,35,3,3,70,NULL,NULL,'Hector',0,0,0,1),('starter',39,'0',0,'Matcha','0','Juan',0,'0',2,2,15,2,1,10,2,8,10,20,8,7,4,2,10,40,4,4,46,NULL,NULL,NULL,0,0,0,1),('starter',40,'0',0,'Matcha','0','Valentine',0,'1',10,4,18,7,1,7,25,3,8,15,8,9,4,5,8,39,4,4,13,NULL,NULL,'Unico',0,0,0,1),('starter',41,'8',0,'Maurice','0','Damien',0,'0',9,8,2,5,1,1,12,9,5,27,1,8,8,2,8,42,5,5,56,NULL,NULL,NULL,0,0,0,1),('starter',42,'1',0,'Maurice','0','Amélia',0,'1',6,4,3,2,1,4,12,7,7,3,1,7,8,1,15,41,5,5,13,NULL,NULL,'Erikson',0,0,0,1),('starter',45,'6',0,'Ferron','0','Stan',0,'0',10,2,13,5,1,10,19,17,10,47,2,7,1,2,1,46,6,6,45,NULL,NULL,NULL,0,0,0,1),('starter',46,'4',0,'Ferron','0','Béa',0,'1',7,4,7,2,1,1,19,23,6,36,10,9,1,10,10,45,6,6,47,NULL,NULL,'Faust',0,0,0,1),('starter',49,'4',0,'Durand','0','Wilfried',0,'0',11,4,2,2,1,1,22,9,10,6,4,10,2,10,5,50,7,7,17,NULL,NULL,NULL,0,0,0,1),('starter',50,'8',0,'Durand','0','Gwen',0,'1',17,6,5,8,1,10,15,14,10,50,3,8,2,6,3,49,7,7,65,NULL,NULL,'Pelletier',0,0,0,1),('starter',51,'0',0,'U','0','G',0,'0',10,8,13,3,3,6,11,20,10,35,10,3,3,11,7,52,NULL,NULL,69,NULL,NULL,NULL,0,0,0,1),('starter',52,'7',0,'F','0','B',0,'1',9,8,13,8,3,8,11,20,10,35,3,1,11,10,7,51,NULL,NULL,4,NULL,NULL,NULL,0,0,0,1),('starter',53,'0',0,'T','0','G',0,'0',2,5,1,4,3,1,22,17,9,20,4,9,2,7,11,54,NULL,NULL,18,NULL,NULL,NULL,0,0,0,1),('starter',54,'0',0,'U','0','N',0,'1',1,8,1,1,3,2,6,3,10,1,6,10,6,8,9,53,NULL,NULL,55,NULL,NULL,NULL,0,0,0,1),('starter',55,'0',0,'X','0','T',0,'0',9,6,7,4,3,6,27,8,7,37,7,1,2,3,10,56,NULL,NULL,76,NULL,NULL,NULL,0,0,0,1),('starter',56,'0',0,'F','0','D',0,'1',11,4,7,7,3,3,6,16,6,7,10,4,8,1,7,55,NULL,NULL,70,NULL,NULL,NULL,0,0,0,1),('starter',57,'6',0,'K','0','X',0,'0',14,1,16,8,4,1,21,24,9,26,2,6,4,1,10,58,NULL,NULL,45,NULL,NULL,NULL,0,0,0,1),('starter',58,'8',0,'O','0','T',0,'1',6,5,2,1,4,1,18,10,10,5,3,9,4,12,6,57,NULL,NULL,76,NULL,NULL,NULL,0,0,0,1),('starter',61,'3',0,'T','0','M',0,'0',12,2,5,3,4,2,10,6,8,10,6,5,8,8,8,62,NULL,NULL,4,NULL,NULL,NULL,0,0,0,1),('starter',62,'6',0,'Y','0','X',0,'1',3,8,12,1,4,9,27,22,10,44,6,8,8,9,4,61,NULL,NULL,68,NULL,NULL,NULL,0,0,0,1),('starter',63,'0',0,'André','0','Théo',0,'0',14,1,3,8,2,3,5,8,7,42,4,6,3,2,4,64,13,13,26,NULL,NULL,NULL,0,0,0,1),('starter',64,'0',0,'André','0','Yandra',0,'1',5,1,11,8,2,10,5,5,5,29,6,10,7,3,14,63,13,13,70,NULL,NULL,'Séba',0,0,0,1),('starter',65,'5',0,'V','0','E',0,'0',17,3,18,4,3,10,11,8,6,30,2,2,5,7,13,66,NULL,NULL,8,NULL,NULL,NULL,0,0,0,1),('starter',66,'5',0,'X','0','Z',0,'1',7,7,9,1,3,4,20,21,4,46,6,7,5,1,3,65,NULL,NULL,32,NULL,NULL,NULL,0,0,0,1),('starter',67,'4',0,'K','0','D',0,'0',12,1,4,3,4,3,28,8,9,48,2,8,6,9,15,68,NULL,NULL,44,NULL,NULL,NULL,0,0,0,1),('starter',68,'3',0,'E','0','Q',0,'1',12,5,5,5,4,7,6,4,7,21,1,9,6,7,13,67,NULL,NULL,67,NULL,NULL,NULL,0,0,0,1),('starter',69,'2',0,'O','0','O',0,'0',1,1,15,4,5,9,22,20,3,39,9,2,12,3,14,70,NULL,NULL,17,NULL,NULL,NULL,0,0,0,1),('starter',70,'2',0,'W','0','M',0,'1',1,3,16,3,5,2,3,19,5,43,1,10,12,5,4,69,NULL,NULL,34,NULL,NULL,NULL,0,0,0,1),('starter',71,'7',0,'Fabre','0','Bastien',0,'0',13,3,10,7,1,3,11,12,4,38,7,1,3,6,14,72,8,8,16,NULL,NULL,NULL,0,0,0,1),('starter',72,'5',0,'Fabre','0','Zoé',0,'1',12,8,5,3,1,1,2,9,7,3,10,7,3,6,5,71,8,8,37,NULL,NULL,'Justin',0,0,0,1),('starter',73,'0',0,'Ferrandi','0','Xavier',0,'0',9,2,15,7,2,5,14,22,4,23,8,7,11,2,7,74,14,14,57,NULL,NULL,NULL,0,0,0,1),('starter',74,'0',0,'Ferrandi','0','Fanny',0,'1',12,3,14,6,2,10,24,21,4,46,9,5,8,9,1,73,14,14,52,NULL,NULL,'Yvet',0,0,0,1),('starter',75,'6',0,'F','0','I',0,'0',13,3,14,8,5,6,17,14,4,40,7,5,9,10,15,76,NULL,NULL,51,NULL,NULL,NULL,0,0,0,1),('starter',76,'3',0,'B','0','K',0,'1',11,6,13,1,5,5,14,10,9,43,5,7,9,8,2,75,NULL,NULL,45,NULL,NULL,NULL,0,0,0,1),('starter',77,'0',0,'I','0','S',0,'0',17,7,2,6,4,7,28,3,1,23,4,9,6,1,1,78,NULL,NULL,79,NULL,NULL,NULL,0,0,0,1),('starter',78,'0',0,'T','0','Q',0,'1',11,7,5,5,4,4,28,13,6,20,7,3,9,3,6,77,NULL,NULL,70,NULL,NULL,NULL,0,0,0,1),('starter',79,'5',0,'Sorel','0','Samuel',0,'0',4,5,11,5,2,10,8,4,4,37,7,9,1,7,5,80,15,15,26,NULL,NULL,'Usul',0,0,0,1),('starter',80,'3',0,'Sorel','0','Béatrice',0,'1',14,4,3,3,2,7,6,5,10,50,10,1,1,9,1,79,15,15,71,NULL,NULL,NULL,0,0,0,1),('starter',81,'3',0,'Petit','0','Charlie',0,'0',16,2,9,8,2,5,16,7,6,14,4,7,2,7,13,82,16,16,26,NULL,NULL,'Verrant',0,0,0,1),('starter',82,'7',0,'Petit','0','Urielle',0,'1',17,7,19,4,2,7,12,17,7,14,8,3,12,9,7,81,16,16,22,NULL,NULL,NULL,0,0,0,1),('starter',83,'1',0,'W','0','P',0,'0',16,1,2,5,4,4,15,21,2,7,2,6,1,3,8,84,NULL,NULL,30,NULL,NULL,NULL,0,0,0,1),('starter',84,'4',0,'N','0','Q',0,'1',15,1,2,2,4,1,1,18,1,13,2,10,11,9,14,83,NULL,NULL,58,NULL,NULL,NULL,0,0,0,1),('starter',85,'5',0,'X','0','J',0,'0',16,8,8,8,4,10,20,15,9,51,7,2,2,11,4,86,NULL,NULL,3,NULL,NULL,NULL,0,0,0,1),('starter',86,'5',0,'D','0','K',0,'1',11,5,9,7,4,2,11,17,8,34,3,8,12,1,11,85,NULL,NULL,36,NULL,NULL,NULL,0,0,0,1),('starter',87,'3',0,'J','0','G',0,'0',10,4,13,6,5,1,9,7,2,22,2,9,8,2,12,88,NULL,NULL,9,NULL,NULL,NULL,0,0,0,1),('starter',88,'0',0,'J','0','O',0,'1',9,1,5,4,5,6,2,19,3,45,1,1,8,7,12,87,NULL,NULL,53,NULL,NULL,NULL,0,0,0,1),('starter',89,'8',0,'I','0','O',0,'0',7,8,14,7,3,5,20,11,7,49,9,6,11,6,4,90,NULL,NULL,73,NULL,NULL,NULL,0,0,0,1),('starter',90,'0',0,'O','0','X',0,'1',14,2,14,6,3,9,26,20,8,46,3,5,9,2,9,89,NULL,NULL,65,NULL,NULL,NULL,0,0,0,1),('starter',91,'4',0,'K','0','C',0,'0',13,2,14,8,5,9,20,17,3,4,4,10,2,7,13,92,NULL,NULL,52,NULL,NULL,NULL,0,0,0,1),('starter',92,'0',0,'A','0','S',0,'1',2,6,17,1,5,2,17,9,3,50,7,9,12,4,11,91,NULL,NULL,25,NULL,NULL,NULL,0,0,0,1),('sim',93,'0',0,'Lagasca','0','Lorie',0,'1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,1,NULL,18,17,NULL,1,1,0,0),('sim',94,'0',0,'Queton','1','Elias',0,'0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2,2,NULL,23,24,NULL,1,1,0,0);
/*!40000 ALTER TABLE `sims` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `terrains`
--

DROP TABLE IF EXISTS `terrains`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `terrains` (
  `categorie` varchar(31) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adresse` varchar(255) DEFAULT NULL,
  `batiment` tinyint(1) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `lieuDit` varchar(255) DEFAULT NULL,
  `terrain` tinyint(1) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `fonction` varchar(255) DEFAULT NULL,
  `groupe` tinyint(1) DEFAULT NULL,
  `preConstruit` tinyint(1) DEFAULT NULL,
  `proprietaire_id` int(11) DEFAULT NULL,
  `quartier_id` int(11) DEFAULT NULL,
  `classe_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_spslpcsrcyumg8pje20blgwp4` (`proprietaire_id`),
  KEY `FK_dvgqpak9iqgvfo30q39ouv5sr` (`quartier_id`),
  KEY `FK_ny9ojieklhbaxsli40cuikaa9` (`classe_id`),
  CONSTRAINT `FK_dvgqpak9iqgvfo30q39ouv5sr` FOREIGN KEY (`quartier_id`) REFERENCES `quartiers` (`id`),
  CONSTRAINT `FK_ny9ojieklhbaxsli40cuikaa9` FOREIGN KEY (`classe_id`) REFERENCES `classes` (`id`),
  CONSTRAINT `FK_spslpcsrcyumg8pje20blgwp4` FOREIGN KEY (`proprietaire_id`) REFERENCES `familles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=266 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `terrains`
--

LOCK TABLES `terrains` WRITE;
/*!40000 ALTER TABLE `terrains` DISABLE KEYS */;
INSERT INTO `terrains` VALUES ('prive',1,'',0,'Prison','',0,'Terrain',NULL,0,1,NULL,1,1),('prive',2,'',1,'Foyer','',1,'Terrain',NULL,0,1,NULL,3,2),('prive',3,'',1,'Caravane 1','',1,'Terrain',NULL,1,1,1,3,3),('prive',4,'',1,'Caravane 2','',1,'Terrain',NULL,1,1,4,3,3),('prive',5,'',1,'Caravane 3','',1,'Terrain',NULL,1,1,6,3,3),('prive',6,'',0,'Caravane 4','',1,'Terrain',NULL,1,1,8,3,3),('prive',7,'',1,'Caravane 5','',1,'Terrain',NULL,1,1,NULL,3,3),('prive',8,'',1,'Caravane 6','',1,'Terrain',NULL,1,1,NULL,3,3),('prive',9,'',1,'Caravane 7','',1,'Terrain',NULL,1,1,NULL,3,3),('prive',10,'',1,'Caravane 8','',1,'Terrain',NULL,1,1,NULL,3,3),('prive',11,'',1,'Barque 1','Port Rural',1,'Bateau',NULL,1,1,2,3,3),('prive',12,'',1,'Barque 2','Port Rural',1,'Bateau',NULL,1,1,5,3,3),('prive',13,'',1,'Barque 3','Port Rural',1,'Bateau',NULL,1,1,NULL,3,3),('prive',14,'',1,'Barque 4','Port Rural',1,'Bateau',NULL,1,1,NULL,3,3),('prive',15,'',0,'HLM 1','Village Rural',1,'Bâtiment',NULL,1,1,3,3,3),('prive',16,'',0,'HLM 2','Village Rural',1,'Bâtiment',NULL,1,1,7,3,3),('prive',17,'',0,'HLM 3','Village Rural',1,'Bâtiment',NULL,1,1,NULL,3,3),('prive',18,'',0,'HLM 4','Village Rural',1,'Bâtiment',NULL,1,1,NULL,3,3),('prive',19,'',0,'Maisonnette 1','',0,'Terrain',NULL,0,0,NULL,4,4),('prive',20,'',0,'Maisonnette 2','',0,'Terrain',NULL,0,0,NULL,4,4),('prive',21,'',0,'Maisonnette 3','',0,'Terrain',NULL,0,0,NULL,4,4),('prive',22,'',0,'Maisonnette 4','',0,'Terrain',NULL,0,0,NULL,4,4),('prive',23,'',0,'Maisonnette 5','',0,'Terrain',NULL,0,0,NULL,4,4),('prive',24,'',0,'Maisonnette 6','',0,'Terrain',NULL,0,0,NULL,4,4),('prive',25,'',0,'Maisonnette 7','',0,'Terrain',NULL,0,0,NULL,4,4),('prive',26,'',0,'Maisonnette 8','',0,'Terrain',NULL,0,0,NULL,4,4),('prive',27,'',0,'Appartement 1','Village Modeste',0,'Bâtiment',NULL,1,1,NULL,4,4),('prive',28,'',0,'Appartement 2','Village Modeste',0,'Bâtiment',NULL,1,1,NULL,4,4),('prive',29,'',0,'Appartement 3','Village Modeste',0,'Bâtiment',NULL,1,1,NULL,4,4),('prive',30,'',0,'Appartement 4','Village Modeste',0,'Bâtiment',NULL,1,1,NULL,4,4),('prive',31,'',0,'Plaisance 1','Port Modeste',0,'Bateau',NULL,1,0,NULL,4,4),('prive',32,'',0,'Plaisance 2','Port Modeste',0,'Bateau',NULL,1,0,NULL,4,4),('prive',33,'',0,'Plaisance 3','Port Modeste',0,'Bateau',NULL,1,0,NULL,4,4),('prive',34,'',0,'Plaisance 4','Port Modeste',0,'Bateau',NULL,1,0,NULL,4,4),('prive',35,'',0,'Pavillon 1','',0,'Terrain',NULL,0,0,NULL,4,5),('prive',36,'',0,'Pavillon 2','',0,'Terrain',NULL,0,0,NULL,4,5),('prive',37,'',0,'Pavillon 3','',0,'Terrain',NULL,0,0,NULL,4,5),('prive',38,'',0,'Pavillon 4','',0,'Terrain',NULL,0,0,NULL,4,5),('prive',39,'',0,'Pavillon 5','',0,'Terrain',NULL,0,0,NULL,4,4),('prive',40,'',0,'Pavillon 6','',0,'Terrain',NULL,0,0,NULL,4,5),('prive',41,'',0,'Pavillon 7','',0,'Terrain',NULL,0,0,NULL,4,5),('prive',42,'',0,'Pavillon 8','',0,'Terrain',NULL,0,0,NULL,4,5),('prive',43,'',0,'Loft 1','Village Modeste',0,'Bâtiment',NULL,1,1,NULL,4,5),('prive',44,'',0,'Loft 2','Village Modeste',0,'Bâtiment',NULL,1,1,NULL,4,5),('prive',45,'',0,'Loft 3','Village Modeste',0,'Bâtiment',NULL,1,1,NULL,4,5),('prive',46,'',0,'Loft 4','Village Modeste',0,'Bâtiment',NULL,1,1,NULL,4,5),('prive',47,'',0,'Vedette 1','Port Modeste',0,'Bateau',NULL,1,0,NULL,4,5),('prive',48,'',0,'Vedette 2','Port Modeste',0,'Bateau',NULL,1,0,NULL,4,5),('prive',49,'',0,'Vedette 3','Port Modeste',0,'Bateau',NULL,1,0,NULL,4,5),('prive',50,'',0,'Vedette 4','Port Modeste',0,'Bateau',NULL,1,0,NULL,4,5),('prive',51,'',0,'Villa 1','',0,'Terrain',NULL,0,0,NULL,5,6),('prive',52,'',0,'Villa 2','',0,'Terrain',NULL,0,0,NULL,5,6),('prive',53,'',0,'Villa 3','',0,'Terrain',NULL,0,0,NULL,5,6),('prive',54,'',0,'Villa 4','',0,'Terrain',NULL,0,0,NULL,5,6),('prive',55,'',0,'Villa 5','',0,'Terrain',NULL,0,0,NULL,5,6),('prive',56,'',0,'Villa 6','',0,'Terrain',NULL,0,0,NULL,5,6),('prive',57,'',0,'Villa 7','',0,'Terrain',NULL,0,0,NULL,5,6),('prive',58,'',0,'Villa 8','',0,'Terrain',NULL,0,0,NULL,5,6),('prive',59,'',0,'Penthouse 1','',0,'Bâtiment',NULL,1,1,NULL,7,6),('prive',60,'',0,'Penthouse 2','',0,'Bâtiment',NULL,1,1,NULL,7,6),('prive',61,'',0,'Penthouse 3','',0,'Terrain',NULL,0,0,NULL,7,6),('prive',62,'',0,'Penthouse 4','',0,'Bâtiment',NULL,1,1,NULL,7,6),('prive',63,'',0,'Yacht 1','Port Riche',0,'Bateau',NULL,1,0,NULL,5,6),('prive',64,'',0,'Yacht 2','Port Riche',0,'Bateau',NULL,1,0,NULL,5,6),('prive',65,'',0,'Yacht 3','Port Riche',0,'Bateau',NULL,1,0,NULL,5,6),('prive',66,'',0,'Yacht 4','Port Riche',0,'Bateau',NULL,1,0,NULL,5,6),('prive',67,'',0,'Domaine 1','',0,'Terrain',NULL,0,0,NULL,5,7),('prive',68,'',0,'Domaine 2','',0,'Terrain',NULL,0,0,NULL,5,7),('prive',69,'',0,'Domaine 3','',0,'Terrain',NULL,0,0,NULL,5,6),('prive',70,'',0,'Domaine 4','',0,'Terrain',NULL,0,0,NULL,5,7),('prive',71,'',0,'Domaine 5','',0,'Terrain',NULL,0,0,NULL,5,6),('prive',72,'',0,'Domaine 6','',0,'Terrain',NULL,0,0,NULL,5,7),('prive',73,'',0,'Domaine 7','',0,'Terrain',NULL,0,0,NULL,5,7),('prive',74,'',0,'Domaine 8','',0,'Terrain',NULL,0,0,NULL,5,7),('prive',75,'',0,'Domaine 9','',0,'Terrain',NULL,0,0,NULL,5,7),('prive',76,'',0,'Domaine 10','',0,'Terrain',NULL,0,0,NULL,5,7),('prive',77,'',0,'Paquebot 1','Port Riche',0,'Bateau',NULL,1,0,NULL,5,7),('prive',78,'',0,'Paquebot 2','Port Riche',0,'Bateau',NULL,1,0,NULL,5,7),('prive',79,'',0,'Paquebot 3','Port Riche',0,'Bateau',NULL,1,0,NULL,5,7),('prive',80,'',0,'Paquebot 4','Port Riche',0,'Bateau',NULL,1,0,NULL,5,7),('prive',81,'',0,'Paquebot 5','Port Riche',0,'Bateau',NULL,1,0,NULL,5,7),('prive',82,'',0,'Paquebot 6','Port Riche',0,'Bateau',NULL,1,0,NULL,5,7),('communautaire',83,'',0,'Petit Parc Rural','Village Rural',1,'Terrain','Petit Parc',NULL,NULL,NULL,3,NULL),('communautaire',84,'',0,'Petit parc modeste','Village Modeste',0,'Terrain','Petit parc',NULL,NULL,NULL,4,NULL),('communautaire',85,'',0,'Petit parc université','',0,'Terrain','Petit parc',NULL,NULL,NULL,8,NULL),('communautaire',86,'',0,'Petit parc vacancier','Village vacancier',0,'Terrain','Petit parc',NULL,NULL,NULL,9,NULL),('communautaire',87,'',0,'Marché','',0,'Terrain','Marché',NULL,NULL,NULL,7,NULL),('communautaire',88,'',0,'Plantation','',0,'Terrain','Plantation',NULL,NULL,NULL,2,NULL),('communautaire',89,'',0,'Grand parc','',1,'Terrain','Grand parc',NULL,NULL,NULL,7,NULL),('communautaire',90,'',0,'Cimetière','',0,'Terrain','Cimetière',NULL,NULL,NULL,1,NULL),('prive',91,'',0,'Maison de retraite','',0,'Terrain',NULL,0,1,NULL,7,NULL),('communautaire',92,'',0,'Piscine olympique','',0,'Terrain','Piscine',NULL,NULL,NULL,7,NULL),('communautaire',93,'',0,'Piscine loisir','Village vacancier',0,'Terrain','Pisncine',NULL,NULL,NULL,9,NULL),('communautaire',94,'',0,'Bibliothèque','',0,'Terrain','Bibliothèque',NULL,NULL,NULL,7,NULL),('communautaire',95,'',0,'Gymnase','',0,'Terrain','Gymnase',NULL,NULL,NULL,7,NULL),('communautaire',96,'',0,'Galerie','',0,'Terrain','Galerie',NULL,NULL,NULL,7,NULL),('communautaire',97,'',0,'Lieu de pêche isolé','',0,'Terrain','Lieu de pêche',NULL,NULL,NULL,1,NULL),('communautaire',98,'',0,'Lieu de pêche vacancier','',0,'Terrain','Lieu de pêche',NULL,NULL,NULL,9,NULL),('communautaire',99,'',0,'Plage rurale','Port Rural',1,'Terrain','Plage',NULL,NULL,NULL,3,NULL),('communautaire',100,'',0,'Plage modeste','Port modeste',0,'Terrain','Plage',NULL,NULL,NULL,4,NULL),('communautaire',101,'',0,'Plage riche','',0,'Terrain','Plage',NULL,NULL,NULL,5,NULL),('communautaire',102,'',0,'Plage Vacancière','',0,'Terrain','Plage',NULL,NULL,NULL,9,NULL),('communautaire',103,'',0,'Spa urbain','',0,'Terrain','Spa',NULL,NULL,NULL,7,NULL),('communautaire',104,'',0,'Spa vacancier','Village vacancier',0,'Terrain','Spa',NULL,NULL,NULL,9,NULL),('communautaire',105,'',0,'Restaurant urbain','',0,'Terrain','Restaurant',NULL,NULL,NULL,7,NULL),('communautaire',106,'',0,'Restaurant vacancier','Village vacancier',0,'Terrain','Restaurant',NULL,NULL,NULL,9,NULL),('communautaire',107,'',0,'Fast food rural','Village Rural',1,'Terrain','Fastfood',NULL,NULL,NULL,3,NULL),('communautaire',108,'',0,'Fastfood modeste','Village modeste',0,'Terrain','Fastfood',NULL,NULL,NULL,4,NULL),('communautaire',109,'',0,'Fastfood divertissement','',0,'Terrain','Fastfood',NULL,NULL,NULL,6,NULL),('communautaire',110,'',0,'Fastfood urbain','',0,'Terrain','Fastfood',NULL,NULL,NULL,7,NULL),('communautaire',111,'',0,'Fastfood universitaire','',0,'Terrain','Fastfood',NULL,NULL,NULL,8,NULL),('communautaire',112,'',0,'Fastfood vacancier','Village vacancier',0,'Terrain','Fastfood',NULL,NULL,NULL,9,NULL),('communautaire',113,'',0,'Epicerie','Village rural',1,'Terrain','Petit magasin',NULL,NULL,NULL,3,NULL),('communautaire',114,'',0,'Epicerie modeste','Village modeste',0,'Terrain','Petit magasin',NULL,NULL,NULL,4,NULL),('communautaire',115,'',0,'Epicerie universitaire','',0,'Terrain','Petit magasin',NULL,NULL,NULL,8,NULL),('communautaire',116,'',0,'Epicerie Vacancier','Village vacancier',0,'Terrain','Petit magasin',NULL,NULL,NULL,9,NULL),('communautaire',117,'',0,'Epicerie urbaine','',0,'Terrain','Grand magasin',NULL,NULL,NULL,7,NULL),('communautaire',118,'',0,'Hopital','',0,'Terrain','Hopital',NULL,NULL,NULL,7,NULL),('communautaire',119,'',0,'Théâtre divertissement','',0,'Terrain','Théâtre',NULL,NULL,NULL,6,NULL),('communautaire',120,'',0,'Théâtre vacancier','Village vacancier',0,'Terrain','Théätre',NULL,NULL,NULL,9,NULL),('communautaire',121,'',0,'Stade','',0,'Terrain','Stade',NULL,NULL,NULL,6,NULL),('communautaire',122,'',0,'Mairie','',1,'Terrain','Hotel de Ville',NULL,NULL,NULL,7,NULL),('communautaire',123,'',0,'Dépôt-vente','',0,'Terrain','Dépôt-vente',NULL,NULL,NULL,7,NULL),('communautaire',124,'',0,'Lavomatique','Village Rural',1,'Terrain','Laverie automatique',NULL,NULL,NULL,3,NULL),('communautaire',125,'',0,'Salon','',0,'Terrain','Salon de beauté',NULL,NULL,NULL,7,NULL),('communautaire',126,'',0,'Caserne','',0,'Terrain','Caserne de pompiers',NULL,NULL,NULL,7,NULL),('communautaire',127,'',0,'Casse','Village Rural',1,'Terrain','Casse',NULL,NULL,NULL,3,NULL),('communautaire',128,'',0,'Bar sportif','',0,'Terrain','Bar sportif',NULL,NULL,NULL,7,NULL),('communautaire',129,'',0,'Pub local','village modeste',0,'Terrain','Pub local',NULL,NULL,NULL,4,NULL),('communautaire',130,'',0,'Bar de quartier','Village Rural',1,'Terrain','Bar de quartier',NULL,NULL,NULL,3,NULL),('communautaire',131,'',0,'Bar à cocktail asiatique','',0,'Bâtiment','Bar à cocktail asiatique',NULL,NULL,NULL,6,NULL),('communautaire',132,'',0,'Bar à cocktail de vampire','',0,'Bâtiment','Bar à cocktail de vampire',NULL,NULL,NULL,6,NULL),('communautaire',133,'',0,'Bar à cocktail sélect','',0,'Bâtiment','Bar à cocktail sélect',NULL,NULL,NULL,6,NULL),('communautaire',134,'',0,'Boite de nuit','',0,'Bâtiment','Boite de nuit',NULL,NULL,NULL,6,NULL),('communautaire',135,'',0,'Bar de pisnice','',0,'Bâtiment','Bar piscine',NULL,NULL,NULL,6,NULL),('communautaire',136,'',0,'Club disco','',0,'Bâtiment','Club disco',NULL,NULL,NULL,6,NULL),('communautaire',137,'',0,'Elevage','Village equestre',0,'Terrain','Elevage',NULL,NULL,NULL,2,NULL),('communautaire',138,'',0,'Laboratoire','',0,'Terrain','Laboratoire scientifique',NULL,NULL,NULL,1,NULL),('communautaire',139,'',0,'Repaire de criminels','Village Rural',1,'Terrain','Repaire des criminels',NULL,NULL,NULL,3,NULL),('communautaire',140,'',0,'Commissariat','',0,'Terrain','Comissariat',NULL,NULL,NULL,7,NULL),('communautaire',141,'',0,'Base','',0,'Terrain','Base militaire',NULL,NULL,NULL,1,NULL),('communautaire',142,'',0,'Parc chien','',0,'Terrain','Parc à chien',NULL,NULL,NULL,7,NULL),('communautaire',143,'',0,'Parc chat','',0,'Terrain','Parc à chat',NULL,NULL,NULL,7,NULL),('communautaire',144,'',0,'Centre equestre','Village equestre',0,'Terrain','Centre equestre',NULL,NULL,NULL,2,NULL),('communautaire',145,'',0,'Petit restaurant','',0,'Terrain','Petit restaurant (showtime)',NULL,NULL,NULL,6,NULL),('communautaire',146,'',0,'Performance Club','',0,'Terrain','Bar/Boite de nuit',NULL,NULL,NULL,6,NULL),('communautaire',147,'',0,'Lieu privé','',0,'Terrain','Lieu privé',NULL,NULL,NULL,6,NULL),('communautaire',148,'',0,'Salle grande capacité','',0,'Terrain','Salle grande capacité',NULL,NULL,NULL,6,NULL),('communautaire',149,'',0,'Boutique elixir','',0,'Terrain','Boutique elixir',NULL,NULL,NULL,7,NULL),('communautaire',150,'',0,'LPCS','',0,'Terrain','Lieu de prédi....',NULL,NULL,NULL,7,NULL),('communautaire',151,'',0,'Terrain de festival','',0,'Terrain','Terrain de festival',NULL,NULL,NULL,7,NULL),('prive',152,'',0,'Dortoir Modeste','',0,'Terrain',NULL,0,1,NULL,8,NULL),('prive',153,'',0,'Dortoir luxe','',0,'Terrain',NULL,0,1,NULL,8,NULL),('communautaire',154,'',0,'Association étudiante','',0,'Terrain','Association étudiante',NULL,NULL,NULL,8,NULL),('communautaire',155,'',0,'Repaire des rebelles','',0,'Terrain','Repaire des rebelles',NULL,NULL,NULL,8,NULL),('communautaire',156,'',0,'Université','',0,'Terrain','Lieu Universitaire',NULL,NULL,NULL,8,NULL),('communautaire',157,'',0,'Boutique de geek','',0,'Terrain','Boutique de geek',NULL,NULL,NULL,7,NULL),('communautaire',158,'',0,'Arcade','',0,'Terrain','Salle de jeu',NULL,NULL,NULL,7,NULL),('communautaire',159,'',0,'Coffe shop','',0,'Terrain','Expressos à gogo',NULL,NULL,NULL,7,NULL),('communautaire',160,'',0,'Parc de science','',0,'Terrain','Parc du projet scientifique de groupe',NULL,NULL,NULL,8,NULL),('communautaire',161,'',0,'Zone de plongée','',0,'Terrain','Zone de plongée',NULL,NULL,NULL,1,NULL),('communautaire',162,'',0,'Hotel','',0,'Terrain','Hotel',NULL,NULL,NULL,6,NULL),('communautaire',163,'',0,'Hotel Mediocre','',0,'Terrain','Hotel',NULL,NULL,NULL,9,NULL),('communautaire',164,'',0,'Hotel Confortable','',0,'Terrain','Hotel',NULL,NULL,NULL,9,NULL),('communautaire',165,'',0,'Hotel de luxe','',0,'Terrain','Hotel',NULL,NULL,NULL,9,NULL),('communautaire',166,'',0,'Marina médiocre','Port Rural',1,'Terrain','Marina',NULL,NULL,NULL,3,NULL),('communautaire',167,'',0,'Marina','port modeste',0,'Terrain','Marina',NULL,NULL,NULL,4,NULL),('communautaire',168,'',0,'Marina riche','port riche',0,'Terrain','Marina',NULL,NULL,NULL,5,NULL),('communautaire',169,'',0,'Port de plaisance','',0,'Terrain','Marina',NULL,NULL,NULL,9,NULL),('communautaire',170,'',0,'Librairie','',0,'Terrain','Librairie',NULL,NULL,NULL,7,NULL),('communautaire',171,'',0,'Centre d\'affaire','',0,'Terrain','Centre d\'affaire',NULL,NULL,NULL,7,NULL),('communautaire',172,'',0,'Cinema','',0,'Terrain','Cinema',NULL,NULL,NULL,6,NULL),('communautaire',173,'',0,'Ecole médiocre','Village Rural',1,'Terrain','Ecole',NULL,NULL,NULL,3,NULL),('communautaire',174,'',0,'Ecole','Village modeste',0,'Terrain','Ecole',NULL,NULL,NULL,4,NULL),('communautaire',175,'',0,'Ecole privée','',0,'Terrain','Ecole',NULL,NULL,NULL,7,NULL),('prive',176,'',0,'Champ 1','',0,'Terrain',NULL,0,0,1,2,NULL),('prive',177,'',0,'Champ 2','',0,'Terrain',NULL,0,0,4,2,NULL),('prive',178,'',0,'Champ 3','',0,'Terrain',NULL,0,0,6,2,NULL),('prive',179,'',0,'Champ 4','',0,'Terrain',NULL,0,0,NULL,2,NULL),('prive',180,'',0,'Champ 5','',0,'Terrain',NULL,0,0,NULL,2,NULL),('prive',181,'',0,'Champ 6','',0,'Terrain',NULL,0,0,NULL,2,NULL),('prive',182,'',0,'Champ 7','',0,'Terrain',NULL,0,0,NULL,2,NULL),('prive',183,'',0,'Champ 8','',0,'Terrain',NULL,0,0,NULL,2,NULL),('prive',184,'',0,'Champ 9','',0,'Terrain',NULL,0,0,NULL,2,NULL),('prive',185,'',0,'Champ 10','',0,'Terrain',NULL,0,0,NULL,2,NULL),('prive',186,'',0,'Champ 11','',0,'Terrain',NULL,0,0,NULL,2,NULL),('prive',187,'',0,'Champ 12','',0,'Terrain',NULL,0,0,NULL,2,NULL),('prive',188,'',0,'Champ 13','',0,'Terrain',NULL,0,0,NULL,2,NULL),('prive',189,'',0,'Champ 14','',0,'Terrain',NULL,0,0,NULL,2,NULL),('prive',190,'',0,'Champ 15','',0,'Terrain',NULL,0,0,NULL,2,NULL),('prive',191,'',0,'Champ 16','',0,'Terrain',NULL,0,0,NULL,2,NULL),('prive',192,'',0,'Champ 17','',0,'Terrain',NULL,0,0,NULL,2,NULL),('prive',193,'',0,'Champ 18','',0,'Terrain',NULL,0,0,NULL,2,NULL),('prive',194,'',0,'Champ 19','',0,'Terrain',NULL,0,0,NULL,2,NULL),('prive',195,'',0,'Champ 20','',0,'Terrain',NULL,0,0,NULL,2,NULL),('prive',203,'',0,'Ecurie 1','Village Equestre',0,'Terrain',NULL,1,0,NULL,2,NULL),('prive',204,'',0,'Ecurie 2','Village Equestre',0,'Terrain',NULL,1,0,NULL,2,NULL),('prive',205,'',0,'Ecurie 3','Village Equestre',0,'Terrain',NULL,1,0,NULL,2,NULL),('prive',206,'',0,'Ecurie 4','Village Equestre',0,'Terrain',NULL,1,0,NULL,2,NULL),('prive',207,'',0,'Ecurie 5','Village Equestre',0,'Terrain',NULL,1,0,NULL,2,NULL),('prive',208,'',0,'Ecurie 6','Village Equestre',0,'Terrain',NULL,1,0,NULL,2,NULL),('prive',209,'',0,'Ecurie 7','Village Equestre',0,'Terrain',NULL,1,0,NULL,2,NULL),('prive',210,'',0,'Ecurie 8','Village Equestre',0,'Terrain',NULL,1,0,NULL,2,NULL),('prive',211,'',0,'Ecurie 9','Village Equestre',0,'Terrain',NULL,1,0,NULL,2,NULL),('prive',212,'',0,'Ecurie 10','Village Equestre',0,'Terrain',NULL,1,0,NULL,2,NULL),('communautaire',213,'',0,'Commerce rural 1','Village Rural',1,'Bâtiment','--',NULL,NULL,NULL,3,NULL),('communautaire',214,'',0,'Commerce rural 2','Village Rural',1,'Terrain','--',NULL,NULL,NULL,3,NULL),('communautaire',215,'',0,'Commerce rural 3','Village Rural',1,'Terrain','--',NULL,NULL,NULL,3,NULL),('communautaire',216,'',0,'Commerce modeste 1','Village Modeste',0,'Terrain','--',NULL,NULL,NULL,4,NULL),('communautaire',217,'',0,'Commerce modeste 2','Village Modeste',0,'Terrain','--',NULL,NULL,NULL,4,NULL),('communautaire',218,'',0,'Commerce modeste 3','Village modeste',0,'Terrain','--',NULL,NULL,NULL,4,NULL),('communautaire',219,'',0,'Commerce cv 1','',0,'Bâtiment','',NULL,NULL,NULL,7,NULL),('communautaire',220,'',0,'Commerce cv 2','',0,'Bâtiment','',NULL,NULL,NULL,7,NULL),('communautaire',221,'',0,'Commerce cv 3','',0,'Bâtiment','',NULL,NULL,NULL,7,NULL),('communautaire',222,'',0,'Commerce cv 4','',0,'Bâtiment','',NULL,NULL,NULL,7,NULL),('communautaire',223,'',0,'Commerce cv 5','',0,'Bâtiment','',NULL,NULL,NULL,7,NULL),('communautaire',224,'',0,'Commerce cv 6','',0,'Bâtiment','',NULL,NULL,NULL,7,NULL),('prive',225,'',0,'Résidence 1','',0,'Terrain',NULL,1,0,NULL,8,NULL),('prive',226,'',0,'Résidence 2','',0,'Terrain',NULL,1,0,NULL,8,NULL),('prive',227,'',0,'Résidence 3','',0,'Bâtiment',NULL,1,0,NULL,8,NULL),('prive',228,'',0,'Résidence 4','',0,'Bâtiment',NULL,1,0,NULL,8,NULL),('prive',229,'',0,'Résidence 5','',0,'Terrain',NULL,1,0,NULL,8,NULL),('prive',230,'',0,'Maison de vacances aisée 1','',0,'Terrain',NULL,1,0,NULL,9,5),('prive',231,'',0,'Maison de vacances aisée 2','',0,'Terrain',NULL,1,0,NULL,9,5),('prive',232,'',0,'Maison de vacances aisée 3','',0,'Terrain',NULL,1,0,NULL,9,5),('prive',233,'',0,'Maison de vacances aisée 4','',0,'Terrain',NULL,1,0,NULL,9,5),('prive',234,'',0,'Maison de vacances aisée 5','',0,'Terrain',NULL,1,0,NULL,9,5),('prive',235,'',0,'Maison de vacances aisée 6','',0,'Terrain',NULL,1,0,NULL,9,5),('prive',236,'',0,'Maison de vacances aisée 7','',0,'Terrain',NULL,1,0,NULL,9,5),('prive',237,'',0,'Maison de vacances aisée 8','',0,'Terrain',NULL,1,0,NULL,9,5),('prive',238,'',0,'Maison de vacances riche 1','',0,'Terrain',NULL,1,0,NULL,9,6),('prive',239,'',0,'Maison de vacances riche 2','',0,'Terrain',NULL,1,0,NULL,9,6),('prive',240,'',0,'Maison de vacances riche 3','',0,'Terrain',NULL,1,0,NULL,9,6),('prive',241,'',0,'Maison de vacances riche 4','',0,'Terrain',NULL,1,0,NULL,9,6),('prive',242,'',0,'Maison de vacances riche 5','',0,'Terrain',NULL,1,0,NULL,9,6),('prive',243,'',0,'Maison de vacances riche 6','',0,'Terrain',NULL,1,0,NULL,9,6),('prive',244,'',0,'Maison de vacances riche 7','',0,'Terrain',NULL,1,0,NULL,9,6),('prive',245,'',0,'Maison de vacances riche 8','',0,'Terrain',NULL,1,0,NULL,9,6),('prive',246,'',0,'Maison de vacances noble 1','',0,'Terrain',NULL,1,0,NULL,9,7),('prive',247,'',0,'Maison de vacances noble 2','',0,'Terrain',NULL,1,0,NULL,9,7),('prive',248,'',0,'Maison de vacances noble 3','',0,'Terrain',NULL,1,0,NULL,9,7),('prive',249,'',0,'Maison de vacances noble 4','',0,'Terrain',NULL,1,0,NULL,9,7),('prive',250,'',0,'Maison de vacances noble 5','',0,'Terrain',NULL,1,0,NULL,9,7),('prive',251,'',0,'Maison de vacances noble 6','',0,'Terrain',NULL,1,0,NULL,9,7),('prive',252,'',0,'Maison de vacances noble 7','',0,'Terrain',NULL,1,0,NULL,9,7),('prive',253,'',0,'Maison de vacances noble 8','',0,'Terrain',NULL,1,0,NULL,9,7),('communautaire',254,'',0,'Parking médiocre','Village Rural',1,'Terrain','Parking',NULL,NULL,NULL,3,NULL),('communautaire',255,'',0,'Parking modeste','Village modeste',0,'Terrain','Parking',NULL,NULL,NULL,4,NULL),('communautaire',256,'',0,'Parking centre-ville','',0,'Terrain','Parking',NULL,NULL,NULL,7,NULL),('communautaire',257,'',0,'Parking divertissement','',0,'Terrain','Parking',NULL,NULL,NULL,6,NULL),('communautaire',258,'',0,'Parking université','',0,'Terrain','Parking',NULL,NULL,NULL,8,NULL),('communautaire',259,'',0,'Parking Vacancier','Village vacancier',0,'Terrain','Parking',NULL,NULL,NULL,9,NULL),('communautaire',260,'',0,'camping','',0,'Terrain','',NULL,NULL,NULL,9,NULL),('communautaire',261,'',0,'','',0,NULL,'',NULL,NULL,NULL,3,NULL),('communautaire',262,'ghgh',0,'ghg','ghgh',0,NULL,'ghgh',NULL,NULL,NULL,2,NULL),('communautaire',263,'ghgh',0,'ghg','ghgh',0,NULL,'ghgh',NULL,NULL,NULL,2,NULL),('prive',264,'mmm',0,'mmmm','mmm',0,NULL,NULL,0,1,NULL,9,5),('prive',265,'mmm',0,'mmmm','mmm',0,NULL,NULL,0,1,NULL,NULL,NULL);
/*!40000 ALTER TABLE `terrains` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tour`
--

DROP TABLE IF EXISTS `tour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tour` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enCours` tinyint(1) DEFAULT NULL,
  `nb` int(11) NOT NULL,
  `classe_id` int(11) DEFAULT NULL,
  `famille_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_qfpd26kmhdaq6cbfvrcftr9gg` (`classe_id`),
  KEY `FK_cegd4ulrynqdis22qvsjfu8bp` (`famille_id`),
  CONSTRAINT `FK_cegd4ulrynqdis22qvsjfu8bp` FOREIGN KEY (`famille_id`) REFERENCES `familles` (`id`),
  CONSTRAINT `FK_qfpd26kmhdaq6cbfvrcftr9gg` FOREIGN KEY (`classe_id`) REFERENCES `classes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tour`
--

LOCK TABLES `tour` WRITE;
/*!40000 ALTER TABLE `tour` DISABLE KEYS */;
INSERT INTO `tour` VALUES (1,0,2,2,NULL),(2,0,2,3,1),(3,1,1,3,2),(4,0,1,3,3),(5,0,1,3,4),(6,0,1,3,5),(7,0,1,3,6),(8,0,1,3,7),(9,0,1,3,8),(10,0,1,3,9),(11,0,1,3,10),(12,0,1,3,11),(13,0,1,3,12),(14,0,1,3,13),(15,0,1,3,14),(16,0,1,3,15),(17,0,1,3,16);
/*!40000 ALTER TABLE `tour` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Dumping events for database 'db_elbaappli'
--

--
-- Dumping routines for database 'db_elbaappli'
--
/*!50003 DROP PROCEDURE IF EXISTS `enumeration` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `enumeration`()
BEGIN
update sims set espece = '0' where espece = 'Humain';
update sims set espece = '1' where espece = 'Fée';
update sims set espece = '2' where espece = 'Vampire';
update sims set espece = '3' where espece = 'Loup Garou';
update sims set espece = '4' where espece = 'Sorcier';
update sims set espece = '5' where espece = 'Sirène';
update sims set espece = '6' where espece = 'Végésim';
update sims set espece = '7' where espece = 'Génie';
update sims set espece = '8' where espece = 'Fantôme';

update sims set orientation = '0' where orientation = 'Hétérosexuel';
update sims set orientation = '0' where orientation = 'Homosexuel';

update sims set sexe = '0' where sexe = 'M';
update sims set sexe = '1' where sexe = 'F';

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_dernierGroupe` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_dernierGroupe`()
BEGIN

select s.groupe, count(*) from sims s where s.groupe = (select max(groupe) from sims );

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_groupe` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_groupe`(groupe bigint)
BEGIN
Select l.* from liasonssitr l
left join sims s on l.sim_id = s.id
where s.groupe = groupe;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_nombreTour` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_nombreTour`(classe bigint)
BEGIN
 select min(nb) from tour where classe_id = classe;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-16 23:33:57
