-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: hotel
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.21-MariaDB

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
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `booking` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `room_id` int(11) NOT NULL,
  `time_from` date NOT NULL,
  `time_to` date NOT NULL,
  `total` float NOT NULL,
  `payment` tinyint(4) DEFAULT 0,
  `cus_id` int(11) NOT NULL,
  `qr_id` int(11) DEFAULT 0,
  `status` varchar(45) DEFAULT 'NO',
  `create_at` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (1,1,'2012-11-12','2012-11-14',380,1,1,0,'0',NULL),(2,2,'2012-12-14','2012-12-15',470,0,1,0,'NO',NULL),(3,2,'2012-11-16','2012-11-17',390,1,1,0,'NO',NULL),(4,3,'2012-12-12','2012-12-13',450,1,2,0,'NO',NULL),(5,4,'2012-12-12','2012-12-13',450,1,2,0,'0',NULL),(6,5,'2012-12-12','2012-12-13',450,0,3,0,'0',NULL),(7,6,'2012-12-12','2012-12-13',450,0,3,0,'NO',NULL),(8,2,'2012-12-14','2012-12-15',470,0,3,0,'0',NULL),(9,2,'2012-07-16','2012-07-17',390,1,3,0,'NO',NULL),(10,3,'2012-07-12','2012-07-13',342,1,4,0,'0',NULL),(11,4,'2012-08-12','2012-08-13',111,1,5,0,'0',NULL),(12,5,'2012-08-12','2012-08-13',543,0,5,0,'NO',NULL),(13,6,'2012-08-12','2012-08-13',463,0,6,0,'NO',NULL),(14,6,'2012-08-12','2012-08-14',555,0,7,0,'0',NULL),(16,1,'2012-12-14','2012-12-14',500,1,2,NULL,'NO',NULL),(17,1,'2012-12-14','2012-12-14',500,0,2,NULL,'NO',NULL),(18,1,'2012-12-14','2012-12-14',500,0,2,NULL,'NO','2022-08-19');
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(150) NOT NULL,
  `gender` tinyint(4) DEFAULT NULL,
  `birthday` varchar(50) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `avt` varchar(200) DEFAULT NULL,
  `cccd_img` varchar(200) NOT NULL,
  `status` tinyint(4) DEFAULT 1,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'hai','hai@gmail.com','qqq',1,'2018-05-05','2983641829','face.jpg','DSC_5643.jpg',1);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discount`
--

DROP TABLE IF EXISTS `discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discount` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(200) NOT NULL,
  `code` varchar(45) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discount`
--

LOCK TABLES `discount` WRITE;
/*!40000 ALTER TABLE `discount` DISABLE KEYS */;
/*!40000 ALTER TABLE `discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food`
--

DROP TABLE IF EXISTS `food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `food` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` float NOT NULL,
  `part` varchar(45) DEFAULT NULL,
  `food` varchar(100) NOT NULL,
  `daytime` datetime DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food`
--

LOCK TABLES `food` WRITE;
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
/*!40000 ALTER TABLE `food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotelimage`
--

DROP TABLE IF EXISTS `hotelimage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hotelimage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image` varchar(200) NOT NULL,
  `room_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotelimage`
--

LOCK TABLES `hotelimage` WRITE;
/*!40000 ALTER TABLE `hotelimage` DISABLE KEYS */;
INSERT INTO `hotelimage` VALUES (2,'face.jpg',3),(3,'face.jpg',4),(4,'face.jpg',5),(5,'face.jpg',0),(6,'face.jpg',0),(7,'TVY_5385.jpg',5),(9,'DSC_5910.jpg',1),(10,'DSC_5910.jpg',6),(11,'DSC_5910.jpg',1),(12,'TVY_5396.jpg',11),(13,'DSC_5906.jpg',1),(14,'DSC_5906.jpg',2),(15,'8.jpg',1),(16,'4.png',4);
/*!40000 ALTER TABLE `hotelimage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `food_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_STAFF');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `priceday` float NOT NULL,
  `status` varchar(50) DEFAULT '0',
  `description` varchar(1000) DEFAULT NULL,
  `roomtype` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,'P001',380,'Empty','Voluptatem doloribus tempore quo totam sequi deleniti qui rem sapiente sed voluptatem architecto blanditiis consequatur vel et reprehenderit nihil officia voluptas deleniti neque doloribus voluptatum et alias omnis omnis et itaque soluta repudiandae et voluptate molestiae aut iusto quas deserunt sequi ratione nam eligendi aperiam sint voluptatem quo quae aut eaque qui sint dolorem laudantium ipsam ut nesciunt.','VIP'),(2,'P002',490,'Lease','Voluptatem doloribus tempore quo totam sequi deleniti qui rem sapiente sed voluptatem architecto blanditiis consequatur vel et reprehenderit nihil officia voluptas deleniti neque doloribus voluptatum et alias omnis omnis et itaque soluta repudiandae et voluptate molestiae aut iusto quas deserunt sequi ratione nam eligendi aperiam sint voluptatem quo quae aut eaque qui sint dolorem laudantium ipsam ut nesciunt.','ĐÔI'),(3,'P003',600,'Lease','Voluptatem doloribus tempore quo totam sequi deleniti qui rem sapiente sed voluptatem architecto blanditiis consequatur vel et reprehenderit nihil officia voluptas deleniti neque doloribus voluptatum et alias omnis omnis et itaque soluta repudiandae et voluptate molestiae aut iusto quas deserunt sequi ratione nam eligendi aperiam sint voluptatem quo quae aut eaque qui sint dolorem laudantium ipsam ut nesciunt.','VIP'),(4,'P004',400,'Empty','Voluptatem doloribus tempore quo totam sequi deleniti qui rem sapiente sed voluptatem architecto blanditiis consequatur vel et reprehenderit nihil officia voluptas deleniti neque doloribus voluptatum et alias omnis omnis et itaque soluta repudiandae et voluptate molestiae aut iusto quas deserunt sequi ratione nam eligendi aperiam sint voluptatem quo quae aut eaque qui sint dolorem laudantium ipsam ut nesciunt.','VIP'),(5,'P005',7000,'Empty','Voluptatem doloribus tempore quo totam sequi deleniti qui rem sapiente sed voluptatem architecto blanditiis consequatur vel et reprehenderit nihil officia voluptas deleniti neque doloribus voluptatum et alias omnis omnis et itaque soluta repudiandae et voluptate molestiae aut iusto quas deserunt sequi ratione nam eligendi aperiam sint voluptatem quo quae aut eaque qui sint dolorem laudantium ipsam ut nesciunt.','ĐƠN'),(6,'P006',6000,'Empty','Voluptatem doloribus tempore quo totam sequi deleniti qui rem sapiente sed voluptatem architecto blanditiis consequatur vel et reprehenderit nihil officia voluptas deleniti neque doloribus voluptatum et alias omnis omnis et itaque soluta repudiandae et voluptate molestiae aut iusto quas deserunt sequi ratione nam eligendi aperiam sint voluptatem quo quae aut eaque qui sint dolorem laudantium ipsam ut nesciunt.','VIP'),(11,'P007',6000,'Lease','Voluptatem doloribus tempore quo totam sequi deleniti qui rem sapiente sed voluptatem architecto blanditiis consequatur vel et reprehenderit nihil officia voluptas deleniti neque doloribus voluptatum et alias omnis omnis et itaque soluta repudiandae et voluptate molestiae aut iusto quas deserunt sequi ratione nam eligendi aperiam sint voluptatem quo quae aut eaque qui sint dolorem laudantium ipsam ut nesciunt.','ĐÔI');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `slider`
--

DROP TABLE IF EXISTS `slider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `slider` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `image` varchar(200) DEFAULT NULL,
  `status` tinyint(4) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `slider`
--

LOCK TABLES `slider` WRITE;
/*!40000 ALTER TABLE `slider` DISABLE KEYS */;
INSERT INTO `slider` VALUES (1,NULL,'TVY_5385.jpg',0),(2,NULL,'DSC_5910.jpg',0),(3,NULL,'TVY_5396.jpg',0);
/*!40000 ALTER TABLE `slider` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `password` varchar(200) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `cccd_img` varchar(200) NOT NULL,
  `gender` tinyint(4) DEFAULT NULL,
  `birthday` varchar(50) DEFAULT NULL,
  `code_id` varchar(45) NOT NULL,
  `role_id` int(11) NOT NULL DEFAULT 2,
  `avt` varchar(200) DEFAULT NULL,
  `create_at` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (1,'thanh hai','$2a$10$sMkXHyY6wWnoNsA5LVIxAuuAV/jmiBuHseeE34ia5KU8Dpg5ATdoi','2893675018','dohai30112002@gmail.com','img',1,'2002-11-11','CODE001',1,'face.jpg','2002-10-11'),(2,'thanh hai','$2a$10$BBcqx.zRcrcApUtlaK/f3OtUx7sZXbIBseKan.1QSOulRMxIWgj9S','2893675018','doha30112002@gmail.com','img2',1,'2002-11-20','CODE002',2,'TVY_5396.jpg','2002-12-11'),(3,'thanh','$2a$10$Gj.C35zDfixqH28Nr8lCfO2QKPKu4LPPgj.NxyQBq6bY/2YWMqFJu','29837401829','do30112002@gmail.com','TVY_5188.jpg',0,'2018-05-05','CODE003',1,'face.jpg','2002-09-11'),(4,'thanh Hai do','$2a$10$E4yOZ0RWcPZP39ga.iEMSOj67qumF4jriU3JjwOHl9e1lrQ/nA9qO','7812364192','do2002@gmail.com','4.png',1,'30-11-2002','CODE004',1,'TVY_5396.jpg','2002-07-11'),(5,'Thanh Thanh thanh','$2a$10$kTFJoRUvl0nIHYCND7T2m.78Hl9H5xSxJoJpYAMSZkKwr7pzWSMoC','928312389','bbaoloc311@gmail.com','TVY_5395.jpg',1,'1997-10-10','CODE005',2,'face.jpg','2002-11-11'),(8,'Tiến Đạt','$2a$10$OBNglDIqZQzw16DR5z523.AgCOrSdY93TtaP7m.EBujtg5uL0C7ae','0346164334','dat@gmail.com','TVY_5396.jpg',0,' 2018-05-05','CODE006',2,'face.jpg','2002-11-11'),(9,'Thông điếu','$2a$10$ffVKmGttpGEEinXZUQJy2O572tM.inBeZZAJK17JiCevAjdPaIcbe','122222225','thong@gmail.com','3.png',1,'2022-08-16','CODE009',2,'5.png','2002-11-11');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-20 19:49:21
