-- MySQL dump 10.13  Distrib 8.4.8, for Linux (x86_64)
--
-- Host: localhost    Database: missao_espacial
-- ------------------------------------------------------
-- Server version	8.4.8

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `astronautas`
--

DROP TABLE IF EXISTS `astronautas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `astronautas` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NOME` varchar(255) NOT NULL,
  `PESO` decimal(5,2) NOT NULL,
  `STATUS` varchar(255) DEFAULT NULL,
  `ID_EQUIPE` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_EQUIPE` (`ID_EQUIPE`),
  CONSTRAINT `FK_EQUIPE` FOREIGN KEY (`ID_EQUIPE`) REFERENCES `equipe` (`ID_EQUIPE`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `astronautas`
--

LOCK TABLES `astronautas` WRITE;
/*!40000 ALTER TABLE `astronautas` DISABLE KEYS */;
INSERT INTO `astronautas` VALUES (1,'João Silva',78.50,'Ativo',NULL),(2,'Maria Souza',62.30,'Ativo',NULL),(3,'Carlos Lima',85.00,'Ativo',NULL),(4,'Ana Pereira',55.75,'Ativo',NULL),(5,'Lucas Martins',90.20,'Ativo',NULL),(6,'Fernanda Rocha',68.40,'Ativo',NULL),(7,'Bruno Alves',82.10,'Ativo',NULL),(8,'Juliana Costa',59.90,'Ativo',NULL),(9,'Rafael Gomes',88.60,'Ativo',NULL),(10,'Patricia Fernandes',64.00,'Ativo',NULL);
/*!40000 ALTER TABLE `astronautas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipe`
--

DROP TABLE IF EXISTS `equipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipe` (
  `ID_EQUIPE` int NOT NULL AUTO_INCREMENT,
  `NOME` varchar(255) NOT NULL,
  `QNT_MEMBROS` int DEFAULT NULL,
  PRIMARY KEY (`ID_EQUIPE`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipe`
--

LOCK TABLES `equipe` WRITE;
/*!40000 ALTER TABLE `equipe` DISABLE KEYS */;
INSERT INTO `equipe` VALUES (1,'Equipe Alpha',5),(2,'Equipe Beta',5);
/*!40000 ALTER TABLE `equipe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flyway_schema_history`
--

DROP TABLE IF EXISTS `flyway_schema_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flyway_schema_history` (
  `installed_rank` int NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flyway_schema_history`
--

LOCK TABLES `flyway_schema_history` WRITE;
/*!40000 ALTER TABLE `flyway_schema_history` DISABLE KEYS */;
INSERT INTO `flyway_schema_history` VALUES (1,'1','initial schema','SQL','V1__initial_schema.sql',1995868255,'root','2026-03-15 21:17:57',169,1),(2,'2','add coluna criadoem','SQL','V2__add_coluna_criadoem.sql',-802802790,'root','2026-03-16 11:05:32',116,1),(3,'3','trocar variavel','SQL','V3__trocar_variavel.sql',-855560005,'root','2026-03-16 12:26:23',293,1),(4,'4','tabelas novas','SQL','V4__tabelas_novas.sql',1671046856,'root','2026-03-18 23:42:12',84,1),(5,'5','astronautas','SQL','V5__astronautas.sql',1249152880,'root','2026-03-18 23:57:26',35,1),(6,'6','preencher tabelas','SQL','V6__preencher_tabelas.sql',966155965,'root','2026-03-19 00:14:40',54,1);
/*!40000 ALTER TABLE `flyway_schema_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `foguete`
--

DROP TABLE IF EXISTS `foguete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `foguete` (
  `ID_FOGUETE` int NOT NULL AUTO_INCREMENT,
  `NOME` varchar(100) NOT NULL,
  `MASSA_TOTAL` decimal(8,2) DEFAULT NULL,
  `CARGA_UTIL` decimal(10,2) DEFAULT NULL,
  `COMBUSTIVEL` decimal(10,2) DEFAULT NULL,
  `DATA_LANCAMENTO` date DEFAULT NULL,
  `STATUS` varchar(50) DEFAULT 'Em solo',
  `CRIADO_EM` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID_FOGUETE`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foguete`
--

LOCK TABLES `foguete` WRITE;
/*!40000 ALTER TABLE `foguete` DISABLE KEYS */;
INSERT INTO `foguete` VALUES (1,'Apollo',500.00,250.00,100.00,NULL,'Em solo','2026-03-17 14:47:23'),(12,'Falcon 9',549054.00,22800.00,500000.00,NULL,'Em solo','2026-03-19 00:14:40'),(13,'Saturn V',29700.00,140000.00,2034000.00,NULL,'Em solo','2026-03-19 00:14:40'),(14,'Soyuz',3050.00,8200.00,274000.00,NULL,'Em solo','2026-03-19 00:14:40'),(15,'Ariane 5',777000.00,21600.00,670000.00,NULL,'Em solo','2026-03-19 00:14:40'),(16,'Delta IV Heavy',733000.00,28600.00,620000.00,NULL,'Em solo','2026-03-19 00:14:40'),(17,'Starship',500000.00,100000.00,4600000.00,NULL,'Em solo','2026-03-19 00:14:40'),(18,'New Shepard',75000.00,1000.00,68000.00,NULL,'Em solo','2026-03-19 00:14:40'),(19,'Atlas V',546700.00,18850.00,480000.00,NULL,'Em solo','2026-03-19 00:14:40'),(20,'Electron',12500.00,300.00,11000.00,NULL,'Em solo','2026-03-19 00:14:40'),(21,'Long March 5',869000.00,25000.00,800000.00,NULL,'Em solo','2026-03-19 00:14:40');
/*!40000 ALTER TABLE `foguete` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `missao`
--

DROP TABLE IF EXISTS `missao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `missao` (
  `ID_MISSAO` int NOT NULL AUTO_INCREMENT,
  `ID_SATELITE` int NOT NULL,
  `ID_FOGUETE` int NOT NULL,
  `NOME_MISSAO` varchar(100) DEFAULT NULL,
  `DATA_LANCAMENTO` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `STATUS` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID_MISSAO`),
  KEY `ID_SATELITE` (`ID_SATELITE`),
  KEY `ID_FOGUETE` (`ID_FOGUETE`),
  CONSTRAINT `missao_ibfk_1` FOREIGN KEY (`ID_SATELITE`) REFERENCES `satelite` (`ID_SATELITE`),
  CONSTRAINT `missao_ibfk_2` FOREIGN KEY (`ID_FOGUETE`) REFERENCES `foguete` (`ID_FOGUETE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `missao`
--

LOCK TABLES `missao` WRITE;
/*!40000 ALTER TABLE `missao` DISABLE KEYS */;
/*!40000 ALTER TABLE `missao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `satelite`
--

DROP TABLE IF EXISTS `satelite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `satelite` (
  `ID_SATELITE` int NOT NULL AUTO_INCREMENT,
  `NOME` varchar(100) DEFAULT NULL,
  `MASSA` decimal(10,2) DEFAULT NULL,
  `TIPO_ORBITA` varchar(100) DEFAULT NULL,
  `VELOCIDADE_ORBITAL` decimal(8,2) DEFAULT NULL,
  `DATA_LANCAMENTO` date DEFAULT NULL,
  `STATUS` varchar(50) DEFAULT 'Em solo',
  `CRIADOEM` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID_SATELITE`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `satelite`
--

LOCK TABLES `satelite` WRITE;
/*!40000 ALTER TABLE `satelite` DISABLE KEYS */;
INSERT INTO `satelite` VALUES (1,'Hubble',200.00,NULL,25.00,NULL,'Em solo','2026-03-17 14:40:31'),(12,'Hubble',11110.00,NULL,7.50,NULL,'Em solo','2026-03-19 00:14:40'),(13,'GPS IIF-1',1630.00,NULL,3.90,NULL,'Em solo','2026-03-19 00:14:40'),(14,'GOES-16',5192.00,NULL,3.07,NULL,'Em solo','2026-03-19 00:14:40'),(15,'Sputnik 1',83.60,NULL,7.80,NULL,'Em solo','2026-03-19 00:14:40'),(16,'ISS',419725.00,NULL,7.66,NULL,'Em solo','2026-03-19 00:14:40'),(17,'Terra',4864.00,NULL,7.50,NULL,'Em solo','2026-03-19 00:14:40'),(18,'Aqua',2850.00,NULL,7.50,NULL,'Em solo','2026-03-19 00:14:40'),(19,'Envisat',8211.00,NULL,7.40,NULL,'Em solo','2026-03-19 00:14:40'),(20,'Starlink-1001',260.00,NULL,7.80,NULL,'Em solo','2026-03-19 00:14:40'),(21,'James Webb',6200.00,NULL,0.00,NULL,'Em solo','2026-03-19 00:14:40');
/*!40000 ALTER TABLE `satelite` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-03-20  0:01:55
