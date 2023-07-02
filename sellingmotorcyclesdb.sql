-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: web_sale_motorcycles
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `a_motorcycle`
--

DROP TABLE IF EXISTS `a_motorcycle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `a_motorcycle` (
  `a_motor_id` int NOT NULL,
  `motors_id` int NOT NULL,
  `color` varchar(20) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `date_insert` datetime DEFAULT CURRENT_TIMESTAMP,
  `date_update` datetime DEFAULT NULL,
  `check_sold` enum('sold','not sold yet') DEFAULT 'not sold yet',
  `aMotorDesc` text,
  PRIMARY KEY (`a_motor_id`),
  KEY `motors_id` (`motors_id`),
  CONSTRAINT `a_motorcycle_ibfk_1` FOREIGN KEY (`motors_id`) REFERENCES `motorcycles` (`motors_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `a_motorcycle`
--

LOCK TABLES `a_motorcycle` WRITE;
/*!40000 ALTER TABLE `a_motorcycle` DISABLE KEYS */;
INSERT INTO `a_motorcycle` VALUES (2,6103,'Đỏ đen',408,'2022-12-01 21:05:16','2022-12-02 21:28:18','not sold yet','Airblade xe airblade màu đỏ xe màu đỏ xe màu đen xe 125 CC xe ga xe honda ab đen 2022 xe đẹp'),(3,6103,'Đen',362,'2022-11-21 20:19:38','2022-12-01 21:10:18','not sold yet','xe AirBlade 125 CC đen xe honda xe 125 CC xe ga xe màu đen ab đen 2022 '),(4,6108,'Đỏ',422.49,'2022-11-22 13:24:09','2022-12-01 20:23:10','not sold yet','xe Jupiter MX xe 110 CC xe yamaha xe màu đỏ xe yamaha màu đỏ  xe số'),(5,6108,'Xanh',603.56,'2022-11-22 13:25:29','2022-12-01 20:24:02','not sold yet','jupiter mx màu xanh xe jupiter màu xanh xe màu xanh xe 110 CC xe số xe yamaha'),(6,6109,'Đen nâu',804.75,'2022-11-22 13:31:40','2022-12-01 20:24:56','not sold yet','winner x abs xe winner xe tay côn xe số xe honda 150 CC xe 150 CC xe đẹp'),(7,6109,'Đỏ Đen',999.59,'2022-12-01 20:34:55','2022-12-01 20:34:56','not sold yet','winner x abs xe winner x abs xe honda xe đẹp xe tay côn xe 2021 xe đẹp 2021 xe đẹp rin '),(8,7101,'Đỏ ',2855.98,'2022-12-01 21:12:46','2022-12-01 21:12:47','not sold yet','sh xe sh đỏ xe sh 2021 xe 150 xe ga xe honda xe đẹp xe rin '),(9,6102,'Xám Xanh',856.79,'2022-12-01 23:17:12','2022-12-02 21:27:21','not sold yet','Exciter xe exciter màu xám xe màu xám xe 150 xe yamaha xe tay côn xe đẹp'),(10,124,'đỏ',897.59,'2022-12-01 23:21:17','2022-12-01 23:21:18','not sold yet','xe vision màu đỏ xe màu đỏ xe honda xe ga xe 110 CC xe rin xe đẹp rin '),(12,6107,'xnah',10000,'2022-12-01 23:25:55','2022-12-01 23:25:55','not sold yet','ádad'),(123,6107,'Xanh đỏ',1690,'2022-11-21 20:45:52','2022-12-01 20:21:58','not sold yet','xe vario 150 CC xe màu xanh đỏ xe màu đỏ xe màu xanh xe 2022 xe ga xe Honda'),(124,7101,'Trắng',2012,'2022-11-21 20:47:10','2022-12-01 20:25:35','not sold yet','xe SH 2012 xe đẹp xe honda xe sh 150 CC xe 150 CC xe ga '),(199,17,'Xanh',10000,'2022-12-01 16:52:02','2022-12-01 20:27:10','not sold yet','Xe Jupiter Xe Yamaha Xe 150 CC xe số '),(1992,1992,'Đen',1852,'2022-12-07 15:41:36','2022-12-07 15:41:36','not sold yet','xe honda xe màu đen xe lead xe 110 xe lead 110 xe đẹp'),(6102,124,'Đen Nhám',1267,'2022-11-22 13:16:56','2022-12-02 21:27:50','not sold yet','Xe Vision 110 CC  Xe Vision Đen Nhám Xe Honda xe ga xe đẹp'),(6103,6102,'Cam đen',1005.94,'2022-11-22 13:18:32','2022-12-01 20:27:41','not sold yet','Exciter Xe Exciter 150 CC Xe Exciter Cam đen xe màu cam đen xe màu đen xe tay côn');
/*!40000 ALTER TABLE `a_motorcycle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `cart_id` int NOT NULL AUTO_INCREMENT,
  `a_motor_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (8,10,4),(12,199,9);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `cmt_id` int(5) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `a_motor_id` int NOT NULL,
  `user_id` int(5) unsigned zerofill NOT NULL,
  `date_cmt` datetime DEFAULT CURRENT_TIMESTAMP,
  `cmt_desc` text,
  PRIMARY KEY (`cmt_id`),
  KEY `a_motor_id` (`a_motor_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`a_motor_id`) REFERENCES `a_motorcycle` (`a_motor_id`) ON DELETE CASCADE,
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (00001,6,00009,'2022-12-08 21:04:46','xịn quá'),(00002,199,00004,'2022-12-08 22:53:48','xin qua'),(00003,2,00004,'2023-01-13 09:21:14','ấdasdas');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `cus_id` int NOT NULL AUTO_INCREMENT,
  `cus_name` varchar(100) DEFAULT NULL,
  `id_card` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phoneNum` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`cus_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (5,'Thịnh Huỳnh Đình','12313','20110404@student.hcmute.edu.vn','97781123','QNT','Vietnam'),(6,'Thịnh Huỳnh Đình','12314','20110404@student.hcmute.edu.vn','97781123','QNT','Vietnam'),(7,'Tho','12314','lck0601111202@gmail.com','97781123','QNT','Vietnam'),(8,'toàn','111112','20110404@student.hcmute.edu.vn','97781123','QNT','Vietnam'),(9,'toàn2','21141','20110404@student.hcmute.edu.vn','97781123','QNT','Vietnam'),(10,'john','1231231','20110404@student.hcmute.edu.vn','97781123','QNT','Vietnam'),(11,'thutam','456','thinhhuynh249@gmail.com','09712731231','quang ngai','Vietnam'),(12,'thn','1221','thinhhuynh249@gmail.com','97781123','QNT','Vietnam'),(13,'toàn','212817212','20110402@student.hcmute.edu.vn','0912731412','qang','Vietnam'),(14,'thinh','1213112','thinhhuynh249@gmail.com','97781123','QNT','Vietnam');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motorcycles`
--

DROP TABLE IF EXISTS `motorcycles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `motorcycles` (
  `motors_id` int NOT NULL,
  `motors_name` varchar(50) NOT NULL,
  `version` varchar(50) NOT NULL,
  `motor_type` varchar(50) DEFAULT NULL,
  `branch` varchar(50) NOT NULL,
  `style` varchar(50) DEFAULT NULL,
  `quantity` int NOT NULL DEFAULT '0',
  `motor_desc` text,
  `check_sale` enum('sale','stop sale') NOT NULL DEFAULT 'sale',
  PRIMARY KEY (`motors_id`),
  UNIQUE KEY `motors_id_name_ver` (`motors_id`,`motors_name`,`version`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motorcycles`
--

LOCK TABLES `motorcycles` WRITE;
/*!40000 ALTER TABLE `motorcycles` DISABLE KEYS */;
INSERT INTO `motorcycles` VALUES (1,'SH Mode','2018','xe ga ','honda','cá tính',0,'Xe rin êm, ngoại hình đẹp','sale'),(17,'Jupiter','2022','Xe số','Yamaha','Thường nhật',1,'Cơ bản, phong cách.','sale'),(124,'Vision','2021','Xe ga','Honda','Thường nhật',5,'Xe bản đặt biệt bánh lớn, xe đẹp miễn bàn.','sale'),(1992,'Lead','2012','xe ga','Honda','xe nữ ',1,'đa dạng, cá tính','sale'),(6102,'Exciter','2022','Xe tay côn','Yamaha','Xe thể thao',11,'Nhả tay côn, lên ga cảm nhận tốc độ. ','sale'),(6103,'AirBlade','2022','Xe ga','Honda','Thường nhật',11,'Sang trọng, lịch lãm, phù hợp cho mọi đối tượng.','sale'),(6104,'Dream','2010','Xe số','Honda','Xe cổ',5,'Bền bỉ, hoài niệm, xe đẹp, rin, êm. ','sale'),(6107,'Vario','2022','Xe ga','Honda','Thể thao',11,'Xe đẹp rin êm.','sale'),(6108,'Jupiter MX','2011','Xe số','Yamaha','Thường nhật',5,'Máy rin êm, ngoại hình đẹp.','sale'),(6109,'Winner X ABS','2020','Xe tay côn','Honda','Xe thể thao',6,' Xe máy rin êm, gtdd. ','sale'),(7101,'SH','2014','Xe ga','Honda','Thường nhật',6,' Xe đẹp rin êm, chưa sơn dặm tút.','sale');
/*!40000 ALTER TABLE `motorcycles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `payment_id` int(6) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `a_motor_id` int DEFAULT NULL,
  `date_buy` datetime DEFAULT NULL,
  `date_prepaid` datetime DEFAULT NULL,
  `money_prepaid` float DEFAULT NULL,
  `price` float DEFAULT NULL,
  `payment_menthod` varchar(30) DEFAULT NULL,
  `status` enum('not paid','paid','successful','cancel') DEFAULT 'paid',
  `cus_id` int NOT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`payment_id`),
  KEY `a_motor_id` (`a_motor_id`),
  CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`a_motor_id`) REFERENCES `a_motorcycle` (`a_motor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (000007,6103,'2022-11-27 16:41:03','2022-11-30 22:17:05',101,1005.94,'prepaid','paid',5,7),(000008,3,'2022-11-27 16:41:03','2022-11-29 13:24:42',101,362,'prepaid','paid',5,9),(000016,6102,'2022-11-28 14:39:38','2022-11-29 13:25:12',200,1267,'prepaid','paid',10,NULL),(000017,6103,'2022-11-28 14:39:38','2022-11-28 14:39:38',100,1005.94,'prepaid','paid',10,NULL),(000018,6102,'2022-11-28 14:39:38','2022-11-28 14:39:38',100,1267,'prepaid','paid',10,NULL),(000019,6102,'2022-11-30 15:43:11','2022-11-30 15:43:51',102,1267,'prepaid','paid',11,NULL),(000020,124,'2022-11-30 16:55:25','2022-11-30 16:55:25',1006,2012,'prepaid','paid',12,NULL),(000021,8,'2022-12-01 23:11:11','2022-12-01 23:11:11',713.995,2855.98,'prepaid','paid',13,NULL),(000022,2,'2022-12-04 23:53:49','2022-12-04 23:53:49',102,408,'prepaid','paid',14,NULL),(000023,199,'2022-12-04 23:53:49','2022-12-04 23:53:49',2500,10000,'prepaid','paid',14,NULL),(000024,10,'2022-12-04 23:53:49','2022-12-04 23:53:49',224.398,897.59,'prepaid','paid',14,NULL);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `picturepro`
--

DROP TABLE IF EXISTS `picturepro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `picturepro` (
  `pic_id` int NOT NULL AUTO_INCREMENT,
  `picName` text NOT NULL,
  `a_motor_id` int NOT NULL,
  PRIMARY KEY (`pic_id`),
  KEY `a_motor_id` (`a_motor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=193 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `picturepro`
--

LOCK TABLES `picturepro` WRITE;
/*!40000 ALTER TABLE `picturepro` DISABLE KEYS */;
INSERT INTO `picturepro` VALUES (85,'visden2-5152687314500.jpg',6102),(86,'visden3-5152711885100.jpg',6102),(87,'visionden1-5152729966300.jpg',6102),(88,'vsden4-5152748960500.jpg',6102),(89,'vsden6-5165394129600.jpg',6102),(90,'vsden7-5165419601700.jpg',6102),(91,'vsden8-5165464193300.jpg',6102),(92,'excam1-5213341064900.jpg',6103),(93,'excam2-5213361214300.jpg',6103),(94,'excam3-5213381365400.jpg',6103),(95,'excam4-5213401788300.jpg',6103),(96,'excam5-5230474049900.jpg',6103),(97,'excam6-5230500287100.jpg',6103),(98,'HONDA-AIR-BLADE-2018-5267462566500.jpg',3),(99,'variodo-5314511445200.jpg',123),(100,'jupido1-5347943692200.jpg',4),(101,'jupido2-5347960782700.jpg',4),(102,'jupido3-5347978744600.jpg',4),(103,'jupido4-5347995994900.jpg',4),(104,'jupido5-5348014263500.jpg',4),(105,'jupixanh1-5385037467500.jpg',5),(106,'jupixanh2-5385062784100.jpg',5),(107,'jupixanh3-5385085151200.jpg',5),(108,'jupixanh4-5385101523600.jpg',5),(109,'winden1-5424348975000.jpg',6),(110,'winden2-5424431642700.jpg',6),(111,'winden3-5424452534800.jpg',6),(112,'winden4-5424470734400.jpg',6),(113,'winden5-5424490644100.jpg',6),(114,'winden6-5440659820700.jpg',6),(115,'shtrang1-5471842029700.jpg',124),(116,'shtrang2-5471859489500.jpg',124),(117,'shtrang3-5471875742600.jpg',124),(118,'shtrang4-5471888241200.jpg',124),(119,'shtrang5-5471906390700.jpg',124),(120,'shtrang6-5483198162800.jpg',124),(121,'shtrang7-5483216978400.jpg',124),(128,'HONDA-VISION-2019-12809892376800.jpg',6102),(130,'jupixanh1-5007268132400.jpg',199),(131,'jupixanh2-5007319555300.jpg',199),(132,'jupixanh3-5007333860200.jpg',199),(133,'windo-3322328844200.jpg',7),(134,'windo2-3322418780000.jpg',7),(135,'windo3-3322442524100.jpg',7),(136,'windo4-3322471800700.jpg',7),(137,'windo5-3322490302800.jpg',7),(138,'windo6-3334642569900.jpg',7),(139,'windo7-3334690031200.jpg',7),(148,'abdoden-4789299228500.jpg',2),(149,'abdoden2-4789314258000.jpg',2),(150,'abdoden3-4789325821600.jpg',2),(151,'abdoden4-4789338871000.jpg',2),(152,'abdoden5-4789353738600.jpg',2),(153,'abdoden6-4801331026300.jpg',2),(154,'abdoden7-4801345943900.jpg',2),(155,'shdo-5175272551000.jpg',8),(156,'shdo1-5175289443400.jpg',8),(157,'shdo2-5175303121500.jpg',8),(158,'shdo3-5175317193100.jpg',8),(159,'shdo4-5175330984100.jpg',8),(160,'shdo5-5186074942700.jpg',8),(161,'exxam-12645004846100.jpg',9),(162,'exxam2-12645021156600.jpg',9),(163,'exxam3-12645041446700.jpg',9),(164,'exxam4-12645058207600.jpg',9),(165,'exxamxanh-12645077498700.jpg',9),(166,'vision đỏ-12933224474900.jpg',10),(167,'visiond5-12933245558200.jpg',10),(168,'visiondo2-12933261189800.jpg',10),(169,'visiondo3-12933276741900.jpg',10),(170,'visiondo4-12933297068500.jpg',10),(171,'visiondo7-12950545502600.jpg',10),(172,'visiondo8-12950568380000.jpg',10),(173,'visiondo9-12950589243600.jpg',10),(174,'visiondo6-12963103269900.jpg',10),(180,'variodo-467406489800.jpg',12),(186,'jupixanh3-608245807300.jpg',199),(187,'abdoden-1318679930900.jpg',18),(188,'abdoden2-1318704279600.jpg',18),(189,'abdoden3-1318724948800.jpg',18),(190,'abdoden4-1318747304500.jpg',18),(191,'abdoden5-1318768369800.jpg',18),(192,'xe máy SH mode màu nâu-887918642300.jpg',1992);
/*!40000 ALTER TABLE `picturepro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `rv_id` int(5) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `a_motor_id` int NOT NULL,
  `user_id` int(5) unsigned zerofill NOT NULL,
  `date_rv` datetime DEFAULT CURRENT_TIMESTAMP,
  `rv_desc` text,
  PRIMARY KEY (`rv_id`),
  KEY `a_motor_id` (`a_motor_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `review_ibfk_1` FOREIGN KEY (`a_motor_id`) REFERENCES `a_motorcycle` (`a_motor_id`) ON DELETE CASCADE,
  CONSTRAINT `review_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (00003,199,00007,'2022-12-08 22:53:00','xinj qua');
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` int NOT NULL,
  `role_name` varchar(50) DEFAULT NULL,
  `role_decs` text,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_name` (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'user',NULL),(2,'admin',NULL);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `specification`
--

DROP TABLE IF EXISTS `specification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `specification` (
  `motors_id` int NOT NULL,
  `size` varchar(20) DEFAULT NULL,
  `mass_kg` float DEFAULT NULL,
  `saddle_height_cm` float DEFAULT NULL,
  `rpm` int DEFAULT NULL,
  `engine_torque` float DEFAULT NULL,
  `horse_power` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`motors_id`),
  CONSTRAINT `specification_ibfk_1` FOREIGN KEY (`motors_id`) REFERENCES `motorcycles` (`motors_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specification`
--

LOCK TABLES `specification` WRITE;
/*!40000 ALTER TABLE `specification` DISABLE KEYS */;
INSERT INTO `specification` VALUES (1,'100',80,80,6000,125,'10'),(17,'100',100,100,100,150,'10'),(124,'100',99,70,5750,110,'8.6'),(1992,'100',100,70,6500,110,'9'),(6102,'100',115,108,7000,150,'9'),(6103,'68.7',111,33,1200,125,'7.8'),(6104,'68.7',110,100,4000,110,'6.8'),(6107,'100',111,100,7000,150,'9.3'),(6108,'66',99,70,4000,110,'6.8'),(6109,'100',100,100,7000,150,'9.375'),(7101,'74',134,115.2,7000,150,'9.3');
/*!40000 ALTER TABLE `specification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int(5) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `role_id` int DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `user_pass` varchar(50) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `cccd` int DEFAULT NULL,
  `num_phone` int DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `check_delete` enum('still','deleted') DEFAULT 'still',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email_check` (`email`,`check_delete`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (00002,2,'thinhhuynh249@gmail.com','123','admin2',1231,113,NULL,'still'),(00004,1,'20110404@student.hcmute.edu.vn','123','thinh',121234541,9001167,NULL,'still'),(00007,1,'lck0601111202@gmail.com','123','Nhu',212897765,9077749,NULL,'still'),(00008,1,'tnhubh@gmail.com','123','TamNhu',2127181271,9172,NULL,'still'),(00009,1,'20110402@student.hcmute.edu.vn','123','Toan',212351212,912345678,NULL,'still');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-18 10:57:48
