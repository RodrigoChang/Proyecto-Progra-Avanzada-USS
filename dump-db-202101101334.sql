-- MySQL dump 10.13  Distrib 8.0.22, for macos10.15 (x86_64)
--
-- Host: ec2-52-23-239-197.compute-1.amazonaws.com    Database: db
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `administrador`
--

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrador` (
  `id` int NOT NULL AUTO_INCREMENT,
  `login` varchar(45) DEFAULT NULL,
  `clave` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `user_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador`
--

LOCK TABLES `administrador` WRITE;
/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
INSERT INTO `administrador` VALUES (1,'admin','1234','prueba@correo.com','admin'),(2,'administrador','1234','correoadm@correo.com','admin'),(4,'admin2','1234','prueba@gmail.com','admin'),(5,'admin3','1234','admin@gmail.com','admin'),(6,'adminlogin','1234','adminlogin@admin.com','admin'),(7,'SuperPersona','1234','super@admin.com','admin');
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumno` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nivel_id` int DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `clave` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellidos` varchar(45) DEFAULT NULL,
  `user_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Alumno_FKIndex1_idx` (`nivel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (4,1,'alumno','1234','Juan','Perez','alumno'),(6,1,'alumno2','1234','Rodrigo','Chang','alumno'),(7,2,'alumno3','1234','Fabian','Estefania','alumno'),(8,4,'alumno4','1234','Helena','Gevara','alumno'),(9,3,'alumno5','1234','Horacio','Cade','alumno'),(10,3,'alumno6','1234','Kike','Morande','alumno'),(11,4,'alumno7','1234','Felipe','Ferraza','alumno'),(12,5,'alumno8','1234','Enzo','Ferrari','alumno'),(13,6,'alumno9','1234','Korone','Dominguez','alumno'),(14,7,'alumno10','1234','Okayu','Calliope','alumno'),(15,9,'alumno11','1234','Amy','Watson','alumno'),(17,10,'alumno12','1234','Aki','Rose','alumno'),(18,5,'alumno13','1234','Pepe','Papudo','alumno'),(19,7,'alumno14','1234','Rosa','Maravillosa','alumno');
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asignatura`
--

DROP TABLE IF EXISTS `asignatura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asignatura` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nivel_id` int DEFAULT NULL,
  `profesor_id` int DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `asignatura_FKIndex2_idx` (`nivel_id`),
  KEY `asignatura_FKIndex1_idx` (`profesor_id`),
  CONSTRAINT `asignatura_FKIndex1` FOREIGN KEY (`profesor_id`) REFERENCES `profesor` (`id`),
  CONSTRAINT `asignatura_FKIndex2` FOREIGN KEY (`nivel_id`) REFERENCES `alumno` (`nivel_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asignatura`
--

LOCK TABLES `asignatura` WRITE;
/*!40000 ALTER TABLE `asignatura` DISABLE KEYS */;
INSERT INTO `asignatura` VALUES (3,1,4,'Redes CCNA'),(4,1,4,'Redes CCNA Trapezoide'),(5,4,5,'Algebra1'),(6,4,5,'Algebra1'),(7,3,6,'Algebra2'),(8,4,6,'Algebra2'),(9,5,7,'POO1'),(10,6,7,'POO1'),(11,6,5,'Algebra1'),(12,9,6,'Algebra Lineal'),(14,7,5,'Calculo Hipercuantico Avanzado');
/*!40000 ALTER TABLE `asignatura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asignatura_has_alumno`
--

DROP TABLE IF EXISTS `asignatura_has_alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asignatura_has_alumno` (
  `asignatura_id` int NOT NULL,
  `alumno_id` int NOT NULL,
  `nota` int DEFAULT NULL,
  PRIMARY KEY (`asignatura_id`,`alumno_id`),
  KEY `asignatura_has_alumno_FKIndex2_idx` (`alumno_id`),
  CONSTRAINT `asignatura_has_alumno_FKIndex1` FOREIGN KEY (`asignatura_id`) REFERENCES `asignatura` (`id`),
  CONSTRAINT `asignatura_has_alumno_FKIndex2` FOREIGN KEY (`alumno_id`) REFERENCES `alumno` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asignatura_has_alumno`
--

LOCK TABLES `asignatura_has_alumno` WRITE;
/*!40000 ALTER TABLE `asignatura_has_alumno` DISABLE KEYS */;
INSERT INTO `asignatura_has_alumno` VALUES (3,6,50),(4,7,56),(4,14,54),(7,8,34),(7,13,68),(8,8,69),(9,6,70),(12,17,45),(14,6,15),(14,7,68),(14,13,56);
/*!40000 ALTER TABLE `asignatura_has_alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nivel`
--

DROP TABLE IF EXISTS `nivel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nivel` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nivel` varchar(45) DEFAULT NULL,
  `curso` varchar(45) DEFAULT NULL,
  `aula` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nivel`
--

LOCK TABLES `nivel` WRITE;
/*!40000 ALTER TABLE `nivel` DISABLE KEYS */;
INSERT INTO `nivel` VALUES (1,'Primero','Tercero','A308'),(2,'Segundo','Cuarto','A506'),(3,'Tercero','Segundo','B803');
/*!40000 ALTER TABLE `nivel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nota`
--

DROP TABLE IF EXISTS `nota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nota` (
  `id` int NOT NULL AUTO_INCREMENT,
  `asignatura_has_alumno_alumno_id` int NOT NULL,
  `asignatura_has_alumno_asignatura_id` int NOT NULL,
  `trimestre` int NOT NULL,
  `nota` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `nota_FKIndex1_idx` (`asignatura_has_alumno_asignatura_id`,`asignatura_has_alumno_alumno_id`),
  CONSTRAINT `nota_FKIndex1` FOREIGN KEY (`asignatura_has_alumno_asignatura_id`, `asignatura_has_alumno_alumno_id`) REFERENCES `asignatura_has_alumno` (`asignatura_id`, `alumno_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nota`
--

LOCK TABLES `nota` WRITE;
/*!40000 ALTER TABLE `nota` DISABLE KEYS */;
/*!40000 ALTER TABLE `nota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `login` varchar(45) DEFAULT NULL,
  `clave` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellidos` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `especialista` int DEFAULT NULL,
  `user_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` VALUES (4,'profe1','1234','Dagmar','Pearce','dpearce@uss.cl',84,'profesor'),(5,'profe2','1234','Felipe','Farrufo','farrufo@uss.cl',84,'profesor'),(6,'profe4','1234','Oriel','Miranda','miranda@uss.cl',84,'profesor'),(7,'profe5','1234','Julio','Perez','jperez@uss.cl',84,'profesor'),(8,'elprofe','1234','Julio','Henriquez','jhenriquez@mail.com',4,'profesor');
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-10 13:34:53
