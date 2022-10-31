-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: iso_ii
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `centro`
--

DROP TABLE IF EXISTS `centro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `centro` (
  `nombre` varchar(100) NOT NULL,
  `localizacion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `centro`
--

LOCK TABLES `centro` WRITE;
/*!40000 ALTER TABLE `centro` DISABLE KEYS */;
/*!40000 ALTER TABLE `centro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursopropio`
--

DROP TABLE IF EXISTS `cursopropio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cursopropio` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `ECTS` int DEFAULT NULL,
  `fechaInicio` date DEFAULT NULL,
  `fechaFin` date DEFAULT NULL,
  `tasaMatricula` double DEFAULT NULL,
  `edicion` int DEFAULT NULL,
  `estado` varchar(100) DEFAULT NULL,
  `tipoCurso` varchar(100) DEFAULT NULL,
  `Centro` varchar(100) DEFAULT NULL,
  `secretario` varchar(9) DEFAULT NULL,
  `director` varchar(9) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKCursoPropi877771` (`Centro`),
  KEY `FKCursoPropi466812` (`secretario`),
  KEY `FKCursoPropi658153` (`director`),
  CONSTRAINT `FKCursoPropi466812` FOREIGN KEY (`secretario`) REFERENCES `profesoruclm` (`dni`),
  CONSTRAINT `FKCursoPropi658153` FOREIGN KEY (`director`) REFERENCES `profesoruclm` (`dni`),
  CONSTRAINT `FKCursoPropi877771` FOREIGN KEY (`Centro`) REFERENCES `centro` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursopropio`
--

LOCK TABLES `cursopropio` WRITE;
/*!40000 ALTER TABLE `cursopropio` DISABLE KEYS */;
/*!40000 ALTER TABLE `cursopropio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudiante`
--

DROP TABLE IF EXISTS `estudiante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudiante` (
  `dni` varchar(9) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `titulacion` varchar(100) NOT NULL,
  `calificacion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`dni`),
  KEY `FKEstudiante540879` (`titulacion`),
  CONSTRAINT `FKEstudiante540879` FOREIGN KEY (`titulacion`) REFERENCES `matricula` (`titulacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiante`
--

LOCK TABLES `estudiante` WRITE;
/*!40000 ALTER TABLE `estudiante` DISABLE KEYS */;
/*!40000 ALTER TABLE `estudiante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materia`
--

DROP TABLE IF EXISTS `materia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materia` (
  `nombre` varchar(50) NOT NULL,
  `horas` double DEFAULT NULL,
  `fechaInicio` date DEFAULT NULL,
  `fechaFinal` date DEFAULT NULL,
  `Curso` int DEFAULT NULL,
  PRIMARY KEY (`nombre`),
  KEY `FKMateria203058` (`Curso`),
  CONSTRAINT `FKMateria203058` FOREIGN KEY (`Curso`) REFERENCES `cursopropio` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materia`
--

LOCK TABLES `materia` WRITE;
/*!40000 ALTER TABLE `materia` DISABLE KEYS */;
/*!40000 ALTER TABLE `materia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matricula`
--

DROP TABLE IF EXISTS `matricula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `matricula` (
  `titulacion` varchar(100) NOT NULL,
  `Fecha` date DEFAULT NULL,
  `pagado` tinyint DEFAULT NULL,
  `Modo` varchar(50) DEFAULT NULL,
  `Curso` int DEFAULT NULL,
  PRIMARY KEY (`titulacion`),
  KEY `FKMatricula544796` (`Curso`),
  CONSTRAINT `FKMatricula544796` FOREIGN KEY (`Curso`) REFERENCES `cursopropio` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matricula`
--

LOCK TABLES `matricula` WRITE;
/*!40000 ALTER TABLE `matricula` DISABLE KEYS */;
/*!40000 ALTER TABLE `matricula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesor` (
  `dni` varchar(9) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `doctor` tinyint NOT NULL,
  `materia` varchar(50) NOT NULL,
  PRIMARY KEY (`dni`),
  KEY `FKProfesor880853` (`materia`),
  CONSTRAINT `FKProfesor156388` FOREIGN KEY (`dni`) REFERENCES `profesoruclm` (`dni`),
  CONSTRAINT `FKProfesor880853` FOREIGN KEY (`materia`) REFERENCES `materia` (`nombre`),
  CONSTRAINT `FKProfesorExterno` FOREIGN KEY (`dni`) REFERENCES `profesorexterno` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesorexterno`
--

DROP TABLE IF EXISTS `profesorexterno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesorexterno` (
  `dni` varchar(9) NOT NULL,
  `titulacion` varchar(45) NOT NULL,
  PRIMARY KEY (`dni`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesorexterno`
--

LOCK TABLES `profesorexterno` WRITE;
/*!40000 ALTER TABLE `profesorexterno` DISABLE KEYS */;
/*!40000 ALTER TABLE `profesorexterno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesoruclm`
--

DROP TABLE IF EXISTS `profesoruclm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesoruclm` (
  `dni` varchar(9) NOT NULL,
  `categoria` varchar(50) NOT NULL,
  `Centronombre` varchar(100) NOT NULL,
  PRIMARY KEY (`dni`),
  KEY `FKProfesorUC109331` (`Centronombre`),
  CONSTRAINT `FKProfesorUC109331` FOREIGN KEY (`Centronombre`) REFERENCES `centro` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesoruclm`
--

LOCK TABLES `profesoruclm` WRITE;
/*!40000 ALTER TABLE `profesoruclm` DISABLE KEYS */;
/*!40000 ALTER TABLE `profesoruclm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `idusuarios` int NOT NULL,
  `password` varchar(45) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`idusuarios`),
  UNIQUE KEY `password_UNIQUE` (`password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-31 12:12:01
