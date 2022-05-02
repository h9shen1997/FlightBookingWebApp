-- MySQL dump 10.13  Distrib 8.0.28, for macos11 (x86_64)
--
-- Host: 127.0.0.1    Database: airline_company
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `airports`
--

DROP TABLE IF EXISTS `airports`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airports` (
  `airport` varchar(5) NOT NULL,
  PRIMARY KEY (`airport`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airports`
--

LOCK TABLES `airports` WRITE;
/*!40000 ALTER TABLE `airports` DISABLE KEYS */;
INSERT INTO `airports` VALUES ('ATL'),('BOS'),('DCA'),('DEN'),('HNL'),('HOU'),('JFK'),('LAX'),('MIA'),('ORD'),('SAN'),('SEA'),('SFO');
/*!40000 ALTER TABLE `airports` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_operation_logs`
--

DROP TABLE IF EXISTS `customer_operation_logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_operation_logs` (
  `log_id` int NOT NULL AUTO_INCREMENT,
  `operation` varchar(45) NOT NULL,
  `reservation` int NOT NULL,
  `performed_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `customer` int NOT NULL,
  PRIMARY KEY (`log_id`),
  KEY `log_to_customer_idx` (`customer`),
  KEY `log_to_reservation_idx` (`reservation`),
  CONSTRAINT `log_to_customer` FOREIGN KEY (`customer`) REFERENCES `customers` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `log_to_reservation` FOREIGN KEY (`reservation`) REFERENCES `reservations` (`reservation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_operation_logs`
--

LOCK TABLES `customer_operation_logs` WRITE;
/*!40000 ALTER TABLE `customer_operation_logs` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_operation_logs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `id` int NOT NULL,
  `status` varchar(45) NOT NULL DEFAULT 'GENERAL',
  `miles_accrued` int NOT NULL DEFAULT '0',
  `travel_companion` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customer_to_status_idx` (`status`),
  KEY `customer_to_customer_idx` (`travel_companion`),
  CONSTRAINT `customer_to_customer` FOREIGN KEY (`travel_companion`) REFERENCES `customers` (`id`) ON DELETE SET NULL,
  CONSTRAINT `customer_to_status` FOREIGN KEY (`status`) REFERENCES `statuses` (`status`),
  CONSTRAINT `customer_to_user` FOREIGN KEY (`id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (3,'GENERAL',7392,5),(5,'PLATINUM',67382,NULL),(6,'BRONZE',14839,7),(7,'GOLD',48739,NULL),(8,'SILVER',28749,NULL),(35,'GENERAL',0,NULL);
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_operation_logs`
--

DROP TABLE IF EXISTS `employee_operation_logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_operation_logs` (
  `log_id` int NOT NULL AUTO_INCREMENT,
  `operation` varchar(45) NOT NULL,
  `flight` int NOT NULL,
  `performed_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `employee` int NOT NULL,
  PRIMARY KEY (`log_id`),
  KEY `log_to_employee_idx` (`employee`),
  KEY `log_to_flight_idx` (`flight`),
  CONSTRAINT `log_to_employee` FOREIGN KEY (`employee`) REFERENCES `employees` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `log_to_flight` FOREIGN KEY (`flight`) REFERENCES `flights` (`flight_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_operation_logs`
--

LOCK TABLES `employee_operation_logs` WRITE;
/*!40000 ALTER TABLE `employee_operation_logs` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_operation_logs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `id` int NOT NULL,
  `passcode` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `employee_to_user` FOREIGN KEY (`id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'_h3&T$'),(4,'3s)R$F');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight_classes`
--

DROP TABLE IF EXISTS `flight_classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight_classes` (
  `class` varchar(45) NOT NULL,
  PRIMARY KEY (`class`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight_classes`
--

LOCK TABLES `flight_classes` WRITE;
/*!40000 ALTER TABLE `flight_classes` DISABLE KEYS */;
INSERT INTO `flight_classes` VALUES ('BASIC'),('BUSINESS'),('FIRST'),('MAIN');
/*!40000 ALTER TABLE `flight_classes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flights`
--

DROP TABLE IF EXISTS `flights`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flights` (
  `flight_id` int NOT NULL AUTO_INCREMENT,
  `airline` varchar(45) NOT NULL,
  `departure_airport` varchar(45) NOT NULL,
  `arrival_airport` varchar(45) NOT NULL,
  `flight_number` varchar(45) NOT NULL,
  `cost` double NOT NULL,
  `mileage` int NOT NULL,
  `duration` int NOT NULL,
  `departure_time` datetime NOT NULL,
  `arrival_time` datetime NOT NULL,
  `trip` int DEFAULT NULL,
  `capacity` int NOT NULL,
  PRIMARY KEY (`flight_id`),
  KEY `flight_to_trip_idx` (`trip`),
  KEY `flight_to_depature_airport_idx` (`departure_airport`,`arrival_airport`),
  KEY `flight_to_departure_idx` (`departure_airport`),
  KEY `flight_to_arrival_idx` (`arrival_airport`),
  CONSTRAINT `flight_to_arrival` FOREIGN KEY (`arrival_airport`) REFERENCES `airports` (`airport`),
  CONSTRAINT `flight_to_departure` FOREIGN KEY (`departure_airport`) REFERENCES `airports` (`airport`),
  CONSTRAINT `flight_to_trip` FOREIGN KEY (`trip`) REFERENCES `trips` (`trip_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flights`
--

LOCK TABLES `flights` WRITE;
/*!40000 ALTER TABLE `flights` DISABLE KEYS */;
INSERT INTO `flights` VALUES (1,'Delta','SEA','BOS','DL234',575,2496,313,'2022-04-18 10:00:00','2022-04-18 15:13:00',NULL,138),(2,'Jet Blue','ATL','SEA','JB22',378,3513,270,'2022-04-18 08:30:00','2022-04-18 12:40:00',NULL,141),(3,'United Airlines','ORD','DEN','UA112',353,1101,140,'2022-04-18 08:30:00','2022-04-18 12:40:00',NULL,121),(4,'Delta','BOS','HOU','DL12',583,2392,573,'2022-04-18 08:30:00','2022-04-18 08:30:00',NULL,90),(5,'American Airlines','DCA','MIA','AA1874',335,1223,234,'2022-04-18 08:30:00','2022-04-18 08:30:00',NULL,120),(6,'Spirit Airlines','SEA','DCA','SA329',785,4523,134,'2022-04-18 08:30:00','2022-04-18 08:30:00',NULL,112),(7,'Delta','HOU','LAX','DL9280',123,2453,452,'2022-04-18 08:30:00','2022-04-18 08:30:00',NULL,115),(8,'Jet Blue','MIA','LAX','JB128',356,3534,232,'2022-04-18 08:30:00','2022-04-18 08:30:00',NULL,116),(9,'Alaska Airlines','LAX','SAN','AA7382',223,2332,100,'2022-04-18 08:30:00','2022-04-18 08:30:00',NULL,128),(10,'United Airlines','SEA','LAX','UA492',79,322,129,'2022-04-18 08:30:00','2022-04-18 08:30:00',NULL,200),(11,'Delta','HNL','DEN','DL768',345,5334,720,'2022-04-18 08:30:00','2022-04-18 08:30:00',NULL,174);
/*!40000 ALTER TABLE `flights` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operations`
--

DROP TABLE IF EXISTS `operations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `operations` (
  `operation` varchar(45) NOT NULL,
  PRIMARY KEY (`operation`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operations`
--

LOCK TABLES `operations` WRITE;
/*!40000 ALTER TABLE `operations` DISABLE KEYS */;
INSERT INTO `operations` VALUES ('ADD'),('DELETE'),('UDPATE');
/*!40000 ALTER TABLE `operations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservations`
--

DROP TABLE IF EXISTS `reservations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservations` (
  `reservation_id` int NOT NULL AUTO_INCREMENT,
  `reservation_code` varchar(45) NOT NULL,
  `flight_class` varchar(45) NOT NULL,
  `trip` int NOT NULL,
  `reservation_cost` double NOT NULL,
  PRIMARY KEY (`reservation_id`),
  UNIQUE KEY `reservation_code_UNIQUE` (`reservation_code`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservations`
--

LOCK TABLES `reservations` WRITE;
/*!40000 ALTER TABLE `reservations` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `statuses`
--

DROP TABLE IF EXISTS `statuses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `statuses` (
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statuses`
--

LOCK TABLES `statuses` WRITE;
/*!40000 ALTER TABLE `statuses` DISABLE KEYS */;
INSERT INTO `statuses` VALUES ('BRONZE'),('GENERAL'),('GOLD'),('PLATINUM'),('SILVER');
/*!40000 ALTER TABLE `statuses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trips`
--

DROP TABLE IF EXISTS `trips`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trips` (
  `trip_id` int NOT NULL AUTO_INCREMENT,
  `reservation` int DEFAULT NULL,
  `duration` int DEFAULT NULL,
  `total_mileage` int NOT NULL,
  `total_cost` double NOT NULL,
  PRIMARY KEY (`trip_id`),
  KEY `trip_to_reservation_idx` (`reservation`),
  CONSTRAINT `trip_to_reservation` FOREIGN KEY (`reservation`) REFERENCES `reservations` (`reservation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trips`
--

LOCK TABLES `trips` WRITE;
/*!40000 ALTER TABLE `trips` DISABLE KEYS */;
INSERT INTO `trips` VALUES (13,NULL,1338,7341,1281),(14,NULL,129,322,79),(15,NULL,1338,7341,1281),(16,NULL,129,322,79),(17,NULL,129,322,79),(18,NULL,129,322,79);
/*!40000 ALTER TABLE `trips` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `dob` date NOT NULL,
  `employee` tinyint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_UNIQUE` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Ellis','Madison','emad12','*A\"qj3h*H>','emad12@yahoo.com','1989-04-24',1),(2,'Chuck','Brain','cbrain1','\"6;6[)Tp2D','cbrain1@hotmail.com','2001-01-27',0),(3,'Chase','Franklin','cfrank','s:)rT}vF6y','cfrank@gmail.com','2001-06-01',0),(4,'Marisa','Geraldine','mrald','2WH],9VhHt','mrald@gmail.com','1997-05-29',1),(5,'Allisa','Maid','almad','vY6N+C\"nN~','almad@gmail.com','2003-09-16',0),(6,'Bob','William','bbwill','6r)k[!sCAX','bbwill@outlook.com','1990-11-03',0),(7,'William','Flemings','willf','XN9Pn{Y#QB','willf@gmail.com','1995-09-02',0),(8,'Frank','Gilbert','fgibt12','xf,}Gh\'B43','fgibt12@gmail.com','1997-08-15',0),(35,'Qiaozhi','Liu','qliu','1234','qliu@gmail.com','1995-05-05',0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-02  0:54:16
