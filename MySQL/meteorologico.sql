-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: meteorologico
-- ------------------------------------------------------
-- Server version	5.7.43-log

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
-- Dumping data for table `ciudad`
--

LOCK TABLES `ciudad` WRITE;
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` VALUES (5,'buenos aires'),(3,'cordoba'),(4,'mendoza'),(1,'parana'),(2,'santa fe');
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `clima`
--

LOCK TABLES `clima` WRITE;
/*!40000 ALTER TABLE `clima` DISABLE KEYS */;
INSERT INTO `clima` VALUES (1,'2023-10-11',90,10,1,2),(2,'2023-10-12',90,10,1,2);
/*!40000 ALTER TABLE `clima` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `estado_clima`
--

LOCK TABLES `estado_clima` WRITE;
/*!40000 ALTER TABLE `estado_clima` DISABLE KEYS */;
INSERT INTO `estado_clima` VALUES (1,'despejado'),(2,'nublado'),(3,'lluvioso'),(4,'nevando');
/*!40000 ALTER TABLE `estado_clima` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
INSERT INTO `evento` VALUES (1,'Fuertes vientos','2023-10-12',1),(2,'Fuertes vientos','2023-10-12',1),(3,'Fuertes vientos','2023-10-12',1),(4,'Fuertes vientos','2023-10-12',1),(5,'Fuertes vientos','2023-10-12',1),(6,'Fuertes vientos','2023-10-13',1),(7,'Fuertes vientos','2023-10-13',1);
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `pronostico`
--

LOCK TABLES `pronostico` WRITE;
/*!40000 ALTER TABLE `pronostico` DISABLE KEYS */;
INSERT INTO `pronostico` VALUES (1,1,'Lluvioso','2023-10-11',99,1),(2,1,'Lluvioso','2023-10-13',99,1);
/*!40000 ALTER TABLE `pronostico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `suscripcion`
--

LOCK TABLES `suscripcion` WRITE;
/*!40000 ALTER TABLE `suscripcion` DISABLE KEYS */;
INSERT INTO `suscripcion` VALUES (1,'lisandro@gmail.com'),(2,'juan@gmail.com'),(3,'daniel@gmail.com'),(4,'jose@gmail.com'),(5,'rocio@gmail.com');
/*!40000 ALTER TABLE `suscripcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `suscripcion_ciudad`
--

LOCK TABLES `suscripcion_ciudad` WRITE;
/*!40000 ALTER TABLE `suscripcion_ciudad` DISABLE KEYS */;
INSERT INTO `suscripcion_ciudad` VALUES (1,1),(2,1),(3,1);
/*!40000 ALTER TABLE `suscripcion_ciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `suscripcion_ciudades`
--

LOCK TABLES `suscripcion_ciudades` WRITE;
/*!40000 ALTER TABLE `suscripcion_ciudades` DISABLE KEYS */;
/*!40000 ALTER TABLE `suscripcion_ciudades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'administrador','ADMIN','administrador'),(2,'usuario','USER','usuario');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-12 19:20:51
