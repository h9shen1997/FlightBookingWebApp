-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: airline_company_modified
-- ------------------------------------------------------
-- Server version	8.0.20

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
  CONSTRAINT `log_to_customer` FOREIGN KEY (`customer`) REFERENCES `customers` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `log_to_reservation` FOREIGN KEY (`reservation`) REFERENCES `reservations` (`reservation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_operation_logs`
--

LOCK TABLES `customer_operation_logs` WRITE;
/*!40000 ALTER TABLE `customer_operation_logs` DISABLE KEYS */;
INSERT INTO `customer_operation_logs` VALUES (1,'ADD',1,'2020-03-04 00:00:00',1),(2,'DELETE',2,'2019-08-01 00:00:00',2),(3,'UPDATE',3,'2021-11-01 00:00:00',3),(4,'DELETE',4,'2017-05-23 00:00:00',4),(5,'ADD',5,'2015-04-11 00:00:00',5);
/*!40000 ALTER TABLE `customer_operation_logs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `customer_id` int NOT NULL,
  `status` varchar(45) NOT NULL DEFAULT 'GENERAL',
  `miles_accrued` int NOT NULL DEFAULT '0',
  `travel_companion` int DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `customer_to_status_idx` (`status`),
  KEY `customer_to_customer_idx` (`travel_companion`),
  CONSTRAINT `customer_to_customer` FOREIGN KEY (`travel_companion`) REFERENCES `customers` (`customer_id`) ON DELETE SET NULL,
  CONSTRAINT `customer_to_status` FOREIGN KEY (`status`) REFERENCES `statuses` (`status`),
  CONSTRAINT `customer_to_user` FOREIGN KEY (`customer_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'GENERAL',109,NULL),(2,'GENERAL',1302,NULL),(3,'GENERAL',109,NULL),(4,'GENERAL',80999,NULL),(5,'GENERAL',4000,NULL),(6,'GENERAL',2500,NULL),(7,'GENERAL',2385,NULL);
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
  CONSTRAINT `log_to_employee` FOREIGN KEY (`employee`) REFERENCES `employees` (`employee_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `log_to_flight` FOREIGN KEY (`flight`) REFERENCES `flights` (`flight_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_operation_logs`
--

LOCK TABLES `employee_operation_logs` WRITE;
/*!40000 ALTER TABLE `employee_operation_logs` DISABLE KEYS */;
INSERT INTO `employee_operation_logs` VALUES (1,'ADD',1,'2009-01-03 01:01:03',1),(2,'DELETE',2,'2011-11-03 01:01:03',3),(3,'ADD',3,'2012-11-18 01:01:03',4),(4,'UPDATE',4,'2013-01-03 01:01:03',2),(5,'DELETE',1,'2014-12-15 01:01:03',1);
/*!40000 ALTER TABLE `employee_operation_logs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `employee_id` int NOT NULL,
  `passcode` varchar(45) NOT NULL,
  PRIMARY KEY (`employee_id`),
  CONSTRAINT `employee_to_user` FOREIGN KEY (`employee_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'test_passworld1'),(2,'test_passworld2'),(3,'test_passworld3'),(4,'test_passworld4'),(5,'test_passworld5'),(6,'test_passworld6'),(7,'test_passworld7');
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
  `trip` int NOT NULL,
  `capacity` int NOT NULL,
  PRIMARY KEY (`flight_id`),
  KEY `flight_to_trip_idx` (`trip`),
  KEY `flight_to_depature_airport_idx` (`departure_airport`,`arrival_airport`),
  KEY `flight_to_departure_idx` (`departure_airport`),
  KEY `flight_to_arrival_idx` (`arrival_airport`),
  CONSTRAINT `flight_to_arrival` FOREIGN KEY (`arrival_airport`) REFERENCES `airports` (`airport`),
  CONSTRAINT `flight_to_departure` FOREIGN KEY (`departure_airport`) REFERENCES `airports` (`airport`),
  CONSTRAINT `flight_to_trip` FOREIGN KEY (`trip`) REFERENCES `trips` (`trip_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flights`
--

LOCK TABLES `flights` WRITE;
/*!40000 ALTER TABLE `flights` DISABLE KEYS */;
INSERT INTO `flights` VALUES (1,'DELTA AIRLINE','SEA','BOS','DL 234',200.7,1200,480,'2020-01-09 01:01:01','2020-01-09 13:01:01',1,130),(2,'JET BLUE','ATL','SEA','JB 22',240.4,1234,510,'2020-01-09 01:01:01','2020-01-09 13:01:01',2,100),(3,'UNITED AIRLINE','ORD','DEN','UA 112',70.3,1000,103,'2020-01-09 01:01:01','2020-01-09 13:01:01',3,186),(4,'DELTA AIRLINE','MIA','HOU','DL 12',260.9,1300,1002,'2020-01-09 01:01:01','2020-01-09 13:01:01',4,90);
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
-- Table structure for table `recommendations`
--

DROP TABLE IF EXISTS `recommendations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recommendations` (
  `recommendation_id` int NOT NULL AUTO_INCREMENT,
  `trip` int NOT NULL,
  `departure_airport` varchar(45) NOT NULL,
  `likes` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`recommendation_id`),
  KEY `rec_to_trip_idx` (`trip`),
  KEY `rec_to_airport_idx` (`departure_airport`),
  CONSTRAINT `rec_to_departure` FOREIGN KEY (`departure_airport`) REFERENCES `airports` (`airport`),
  CONSTRAINT `rec_to_trip` FOREIGN KEY (`trip`) REFERENCES `trips` (`trip_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recommendations`
--

LOCK TABLES `recommendations` WRITE;
/*!40000 ALTER TABLE `recommendations` DISABLE KEYS */;
INSERT INTO `recommendations` VALUES (1,1,'SEA',20),(2,2,'BOS',120),(3,3,'LAX',230),(4,4,'ATL',1239),(5,5,'DEN',637),(6,6,'MIA',237);
/*!40000 ALTER TABLE `recommendations` ENABLE KEYS */;
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
  PRIMARY KEY (`reservation_id`),
  UNIQUE KEY `reservation_code_UNIQUE` (`reservation_code`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservations`
--

LOCK TABLES `reservations` WRITE;
/*!40000 ALTER TABLE `reservations` DISABLE KEYS */;
INSERT INTO `reservations` VALUES (1,'RSV01','BASIC',1),(2,'RSV02','MAIN',2),(3,'RSV03','BUSINESS',3),(4,'RSV04','FIRST',4),(5,'RSV05','BUSINESS',5),(6,'RSV06','BUSINESS',6);
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
  `reservation` int NOT NULL,
  `duration` int NOT NULL,
  `total_mileage` int NOT NULL,
  `total_cost` double NOT NULL,
  PRIMARY KEY (`trip_id`),
  KEY `trip_to_reservation_idx` (`reservation`),
  CONSTRAINT `trip_to_reservation` FOREIGN KEY (`reservation`) REFERENCES `reservations` (`reservation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trips`
--

LOCK TABLES `trips` WRITE;
/*!40000 ALTER TABLE `trips` DISABLE KEYS */;
INSERT INTO `trips` VALUES (1,1,124,250,100.4),(2,2,230,218,220.1),(3,3,40,50,98.6),(4,4,20,69,102.2),(5,5,43,54,89.9),(6,6,132,34,89.98);
/*!40000 ALTER TABLE `trips` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `dob` date NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name_UNIQUE` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Jimmy','Ofallon','jof1','12345','jof1@gmail.com','1992-01-09'),(2,'Emily','Warren','ew001','12345','ew001@gmail.com','1995-12-10'),(3,'Steven','Buffet','sbuffet12','12345','sbuffet12@gmail.com','1989-02-07'),(4,'Beth','McArthur','bma23','12345','bma23@gmail.com','1975-11-06'),(5,'Ellis','Madison','emadison','12345','emadison@gmail.com','1976-06-11'),(6,'Bucky','Winter','bwinter','12345','bwinter@gmail.com','1967-11-29'),(7,'Jonny','Bilt','jbit','12345','jblt@gmail.com','1973-09-09'),(8,'Chuck','Brain','cbrain','12345','cbrain@gmail.com','1956-07-28');
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

-- Dump completed on 2022-03-31 21:59:45
