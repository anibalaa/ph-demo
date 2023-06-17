CREATE DATABASE  IF NOT EXISTS `ph3` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `ph3`;
-- MySQL dump 10.13  Distrib 5.7.20, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: ph3
-- ------------------------------------------------------
-- Server version	5.7.20-0ubuntu0.17.10.1

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
-- Table structure for table `Agrupacion`
--

DROP TABLE IF EXISTS `Agrupacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Agrupacion` (
  `idAgrupacion` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idAgrupacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Agrupacion`
--

LOCK TABLES `Agrupacion` WRITE;
/*!40000 ALTER TABLE `Agrupacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `Agrupacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Fase`
--

DROP TABLE IF EXISTS `Fase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Fase` (
  `idFase` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(180) DEFAULT NULL,
  PRIMARY KEY (`idFase`),
  UNIQUE KEY `descripcion_UNIQUE` (`descripcion`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Fase`
--

LOCK TABLES `Fase` WRITE;
/*!40000 ALTER TABLE `Fase` DISABLE KEYS */;
INSERT INTO `Fase` VALUES (7,'FASE 1'),(8,'FASE 2'),(9,'FASE 3'),(3,'FASE A'),(12,'FASE apoyo TAA'),(11,'FASE apoyo TAC'),(10,'FASE apoyo TPP'),(18,'FASE autoconocimiento'),(4,'FASE B'),(5,'FASE C'),(15,'FASE familia 1'),(16,'FASE familia 2'),(21,'FASE IMI laboral'),(20,'FASE IMI prelaboral'),(22,'FASE IMI profesional'),(14,'FASE medida'),(17,'FASE motivacion'),(23,'FASE operacion 1'),(24,'FASE operacion 2'),(25,'FASE operacion 3'),(19,'FASE reinsercion social'),(13,'FASE voluntario');
/*!40000 ALTER TABLE `Fase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FaseGrupo`
--

DROP TABLE IF EXISTS `FaseGrupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `FaseGrupo` (
  `idFaseGrupo` int(11) NOT NULL AUTO_INCREMENT,
  `idFase` int(11) DEFAULT NULL,
  `idGrupo` int(11) DEFAULT NULL,
  PRIMARY KEY (`idFaseGrupo`),
  KEY `fk_Fase_has_Grupo_Grupo1_idx` (`idGrupo`),
  KEY `fk_Fase_has_Grupo_Fase1_idx` (`idFase`),
  CONSTRAINT `Fk_FaseGrupoFase` FOREIGN KEY (`idFase`) REFERENCES `Fase` (`idFase`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Fk_FaseGrupoGrupo` FOREIGN KEY (`idGrupo`) REFERENCES `Grupo` (`idGrupo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FaseGrupo`
--

LOCK TABLES `FaseGrupo` WRITE;
/*!40000 ALTER TABLE `FaseGrupo` DISABLE KEYS */;
INSERT INTO `FaseGrupo` VALUES (1,4,3),(2,4,4),(3,4,6),(4,9,3),(5,9,6),(16,4,5),(17,7,5);
/*!40000 ALTER TABLE `FaseGrupo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Grupo`
--

DROP TABLE IF EXISTS `Grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Grupo` (
  `idGrupo` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(180) DEFAULT NULL,
  PRIMARY KEY (`idGrupo`),
  UNIQUE KEY `descripcion_UNIQUE` (`descripcion`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Grupo`
--

LOCK TABLES `Grupo` WRITE;
/*!40000 ALTER TABLE `Grupo` DISABLE KEYS */;
INSERT INTO `Grupo` VALUES (3,'GRUPO A'),(4,'GRUPO B'),(5,'GRUPO C'),(6,'GRUPO D');
/*!40000 ALTER TABLE `Grupo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Motivo`
--

DROP TABLE IF EXISTS `Motivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Motivo` (
  `idMotivo` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(180) DEFAULT NULL,
  PRIMARY KEY (`idMotivo`),
  UNIQUE KEY `descripcion_UNIQUE` (`descripcion`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Motivo`
--

LOCK TABLES `Motivo` WRITE;
/*!40000 ALTER TABLE `Motivo` DISABLE KEYS */;
INSERT INTO `Motivo` VALUES (3,'alta abandono'),(11,'alta derivacion'),(2,'alta expulsion'),(6,'alta forzosa encarcelamiento'),(5,'alta forzosa enfermedad'),(7,'alta forzosa fallecimiento'),(8,'alta forzosa no necesita'),(10,'alta forzosa no se acepta'),(9,'alta forzosa paso a otro PH'),(12,'alta terapeutica'),(4,'alta voluntaria'),(1,'ingreso');
/*!40000 ALTER TABLE `Motivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Persona`
--

DROP TABLE IF EXISTS `Persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Persona` (
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido1` varchar(45) DEFAULT NULL,
  `apellido2` varchar(45) DEFAULT NULL,
  `activo` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`idPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Persona`
--

LOCK TABLES `Persona` WRITE;
/*!40000 ALTER TABLE `Persona` DISABLE KEYS */;
INSERT INTO `Persona` VALUES (1,'ramon','prada','diez','1'),(3,'john','doe1','doe2','0'),(8,'luv','2','code','1'),(10,'anibal','alvarez','alvarez','1'),(11,'julio','sutil','algo','1'),(12,'aaa','alvarez','a','1');
/*!40000 ALTER TABLE `Persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Programa`
--

DROP TABLE IF EXISTS `Programa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Programa` (
  `idPrograma` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(180) DEFAULT NULL,
  PRIMARY KEY (`idPrograma`),
  UNIQUE KEY `descripcion_UNIQUE` (`descripcion`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Programa`
--

LOCK TABLES `Programa` WRITE;
/*!40000 ALTER TABLE `Programa` DISABLE KEYS */;
INSERT INTO `Programa` VALUES (23,'PG. acogida Gijon'),(24,'PG. acogida Mieres'),(25,'PG. acogida Oviedo'),(41,'PG. acogimiento y apoyo Gijon (PAG)'),(42,'PG. acogimiento y apoyo Oviedo (PAO)'),(40,'PG. ACRA + control'),(39,'PG. ACRA + incentivos'),(46,'PG. AKERANDO ROM'),(29,'PG. ambulatorio'),(31,'PG. apoyo'),(30,'PG. centro de dia'),(20,'PG. centro de dia/ambulatorio'),(22,'PG. centro de dia/apoyo'),(33,'PG. comunidad terapeutica del Caudal'),(26,'PG. comunidad terapeutica Miranda'),(27,'PG. comunidad terapeutica Pielgo'),(19,'PG. evaluacion AKERANDO ROM'),(18,'PG. evaluacion FAM RECIELLA'),(16,'PG. evaluacion PSDC'),(17,'PG. evaluacion RECIELLA'),(14,'PG. evaluacion TAA'),(13,'PG. evaluacion TAC'),(15,'PG. evaluacion TPMM'),(12,'PG. evaluacion TPP'),(38,'PG. familias'),(45,'PG. habilidades marentales (HHMM)'),(47,'PG. IMI'),(32,'PG. inactivo'),(48,'PG. insercion socio laboral (ISL)'),(49,'PG. INSOLA'),(36,'PG. jovenes'),(44,'PG. ludopatias'),(35,'PG. menores'),(21,'PG. no residencial'),(43,'PG. piso de insercion socio laboral Oviedo (PINS)'),(9,'PG. primera demanda AJENA'),(3,'PG. primera demanda CAM'),(8,'PG. primera demanda FAM RECIELLA'),(11,'PG. primera demanda NO PRESENCIAL'),(10,'PG. primera demanda PENITENCIARIA'),(6,'PG. primera demanda PIELGO'),(7,'PG. primera demanda PSDC'),(5,'PG. primera demanda RECIELLA'),(4,'PG. primera demanda TPMM'),(28,'PG. reinsercion social'),(34,'PG. reinsercion social del Caudal'),(50,'PG. residencial'),(37,'PG. servicio de orientacion y medidas judiciales (SOyMJ)');
/*!40000 ALTER TABLE `Programa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ProgramaFase`
--

DROP TABLE IF EXISTS `ProgramaFase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ProgramaFase` (
  `idProgramaFase` int(11) NOT NULL AUTO_INCREMENT,
  `idPrograma` int(11) DEFAULT NULL,
  `idFase` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProgramaFase`),
  KEY `fk_Programa_has_Fase_Fase1_idx` (`idFase`),
  KEY `fk_Programa_has_Fase_Programa1_idx` (`idPrograma`),
  CONSTRAINT `Fk_ProgramaFaseFase` FOREIGN KEY (`idFase`) REFERENCES `Fase` (`idFase`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Fk_ProgramaFasePrograma` FOREIGN KEY (`idPrograma`) REFERENCES `Programa` (`idPrograma`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ProgramaFase`
--

LOCK TABLES `ProgramaFase` WRITE;
/*!40000 ALTER TABLE `ProgramaFase` DISABLE KEYS */;
INSERT INTO `ProgramaFase` VALUES (1,23,7),(2,23,8),(3,23,9),(4,25,11),(5,33,12),(6,33,18),(7,33,19),(8,41,12),(9,20,3),(10,20,4),(11,20,5),(12,50,3),(13,50,4),(14,21,7),(15,21,8),(16,21,9),(17,28,3),(18,28,4),(19,28,5),(20,24,7);
/*!40000 ALTER TABLE `ProgramaFase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Recorrido`
--

DROP TABLE IF EXISTS `Recorrido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Recorrido` (
  `idRecorrido` int(11) NOT NULL AUTO_INCREMENT,
  `idPersona` int(11) DEFAULT NULL,
  `idTratamiento` int(11) DEFAULT NULL,
  `idPrograma` int(11) DEFAULT NULL,
  `idFase` int(11) DEFAULT NULL,
  `idGrupo` int(11) DEFAULT NULL,
  `fechaInicio` date DEFAULT NULL,
  `fechaFin` date DEFAULT NULL,
  `activo` varchar(1) DEFAULT NULL,
  `idMotivo` int(11) DEFAULT NULL,
  PRIMARY KEY (`idRecorrido`),
  KEY `fk_Persona_has_Motivo_Motivo1_idx` (`idMotivo`),
  KEY `fk_Persona_has_Motivo_Persona1_idx` (`idPersona`),
  KEY `fk_Recorrido_Tratamiento1_idx` (`idTratamiento`),
  KEY `fk_Recorrido_Programa1_idx` (`idPrograma`),
  KEY `fk_Recorrido_Fase1_idx` (`idFase`),
  KEY `fk_Recorrido_Grupo1_idx` (`idGrupo`),
  CONSTRAINT `Fk_RecorridoFase` FOREIGN KEY (`idFase`) REFERENCES `Fase` (`idFase`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Fk_RecorridoGrupo` FOREIGN KEY (`idGrupo`) REFERENCES `Grupo` (`idGrupo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Fk_RecorridoMotivo` FOREIGN KEY (`idMotivo`) REFERENCES `Motivo` (`idMotivo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Fk_RecorridoPersona` FOREIGN KEY (`idPersona`) REFERENCES `Persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Fk_RecorridoPrograma` FOREIGN KEY (`idPrograma`) REFERENCES `Programa` (`idPrograma`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Fk_RecorridoTratamiento` FOREIGN KEY (`idTratamiento`) REFERENCES `Tratamiento` (`idTratamiento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Recorrido`
--

LOCK TABLES `Recorrido` WRITE;
/*!40000 ALTER TABLE `Recorrido` DISABLE KEYS */;
INSERT INTO `Recorrido` VALUES (76,1,10,23,9,3,'2001-12-01','2014-01-15','0',4),(77,1,10,23,9,6,'2015-02-21','2017-09-05','0',3),(78,10,10,23,9,6,'2014-03-15',NULL,'1',1),(79,3,7,41,12,3,'2015-02-21','2016-08-10','0',3),(83,1,10,25,11,4,'2017-11-06','2017-11-27','0',1),(84,1,10,23,9,6,'2017-11-06',NULL,'1',1),(85,11,5,23,7,5,'2017-12-28','2017-12-29','0',1),(86,12,10,23,7,5,'2017-12-29','2017-12-05','0',1),(87,12,5,23,9,3,'2017-12-05',NULL,'1',2),(88,11,10,23,7,5,'2017-12-29',NULL,'1',1);
/*!40000 ALTER TABLE `Recorrido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Rol`
--

DROP TABLE IF EXISTS `Rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Rol` (
  `idRol` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(180) DEFAULT NULL,
  PRIMARY KEY (`idRol`),
  UNIQUE KEY `descripcion_UNIQUE` (`descripcion`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Rol`
--

LOCK TABLES `Rol` WRITE;
/*!40000 ALTER TABLE `Rol` DISABLE KEYS */;
INSERT INTO `Rol` VALUES (1,'admin'),(2,'registrado');
/*!40000 ALTER TABLE `Rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RolPersona`
--

DROP TABLE IF EXISTS `RolPersona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RolPersona` (
  `idRolPersona` int(11) NOT NULL AUTO_INCREMENT,
  `idRol` int(11) DEFAULT NULL,
  `idPersona` int(11) DEFAULT NULL,
  PRIMARY KEY (`idRolPersona`),
  KEY `fk_rol_has_persona_persona1_idx` (`idPersona`),
  KEY `fk_rol_has_persona_rol_idx` (`idRol`),
  CONSTRAINT `Fk_RolPersonaPersona` FOREIGN KEY (`idPersona`) REFERENCES `Persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Fk_RolPersonaRol` FOREIGN KEY (`idRol`) REFERENCES `Rol` (`idRol`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RolPersona`
--

LOCK TABLES `RolPersona` WRITE;
/*!40000 ALTER TABLE `RolPersona` DISABLE KEYS */;
/*!40000 ALTER TABLE `RolPersona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tratamiento`
--

DROP TABLE IF EXISTS `Tratamiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tratamiento` (
  `idTratamiento` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(180) DEFAULT NULL,
  PRIMARY KEY (`idTratamiento`),
  UNIQUE KEY `descripcion_UNIQUE` (`descripcion`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tratamiento`
--

LOCK TABLES `Tratamiento` WRITE;
/*!40000 ALTER TABLE `Tratamiento` DISABLE KEYS */;
INSERT INTO `Tratamiento` VALUES (10,'Recurso para menores y jovenes RECIELLA'),(6,'Tratamiento para la adiccion a la cocaina (TAC)'),(7,'Tratamiento para la adiccion al alcohol (TAA)'),(8,'Tratamiento para personas en mantenimiento con metadona (TPMM)'),(9,'Tratamiento para personas en situacion de drogodependencia del Caudal (PSDC)'),(5,'Tratamiento para personas policonsumidoras (TTP)');
/*!40000 ALTER TABLE `Tratamiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TratamientoPrograma`
--

DROP TABLE IF EXISTS `TratamientoPrograma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TratamientoPrograma` (
  `idTratamientoPrograma` int(11) NOT NULL AUTO_INCREMENT,
  `idTratamiento` int(11) DEFAULT NULL,
  `idPrograma` int(11) DEFAULT NULL,
  PRIMARY KEY (`idTratamientoPrograma`),
  KEY `fk_Tratamiento_has_Programa_Programa1_idx` (`idPrograma`),
  KEY `fk_Tratamiento_has_Programa_Tratamiento1_idx` (`idTratamiento`),
  CONSTRAINT `Fk_TratamientoProgramaPrograma` FOREIGN KEY (`idPrograma`) REFERENCES `Programa` (`idPrograma`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Fk_TratamientoProgramaTratamiento` FOREIGN KEY (`idTratamiento`) REFERENCES `Tratamiento` (`idTratamiento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TratamientoPrograma`
--

LOCK TABLES `TratamientoPrograma` WRITE;
/*!40000 ALTER TABLE `TratamientoPrograma` DISABLE KEYS */;
INSERT INTO `TratamientoPrograma` VALUES (1,10,23),(2,10,24),(4,6,41),(5,6,42),(36,10,25),(37,10,41),(38,7,23),(39,5,23);
/*!40000 ALTER TABLE `TratamientoPrograma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `usuarioNombre` varchar(45) DEFAULT NULL,
  `usuarioClave` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `usuarioNombre_UNIQUE` (`usuarioNombre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES (1,'charo','admin'),(2,'julia','registrado');
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `UsuarioRol`
--

DROP TABLE IF EXISTS `UsuarioRol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `UsuarioRol` (
  `idUsuarioRol` int(11) NOT NULL AUTO_INCREMENT,
  `idUsuario` int(11) DEFAULT NULL,
  `idRol` int(11) DEFAULT NULL,
  PRIMARY KEY (`idUsuarioRol`),
  KEY `fk_Usuario_has_Rol_Rol1_idx` (`idRol`),
  KEY `fk_Usuario_has_Rol_Usuario1_idx` (`idUsuario`),
  CONSTRAINT `Fk_UsuarioRolRol` FOREIGN KEY (`idRol`) REFERENCES `Rol` (`idRol`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Fk_UsuarioRolUsuario` FOREIGN KEY (`idUsuario`) REFERENCES `Usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UsuarioRol`
--

LOCK TABLES `UsuarioRol` WRITE;
/*!40000 ALTER TABLE `UsuarioRol` DISABLE KEYS */;
INSERT INTO `UsuarioRol` VALUES (1,1,1),(2,2,2);
/*!40000 ALTER TABLE `UsuarioRol` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-06  0:02:11
