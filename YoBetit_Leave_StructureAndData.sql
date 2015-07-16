CREATE DATABASE  IF NOT EXISTS `yobetit_leave_db` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `yobetit_leave_db`;
-- MySQL dump 10.13  Distrib 5.6.19, for osx10.7 (i386)
--
-- Host: localhost    Database: yobetit_leave_db
-- ------------------------------------------------------
-- Server version	5.1.44

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
-- Table structure for table `tbl_department`
--

DROP TABLE IF EXISTS `tbl_department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_department` (
  `department_id` int(11) NOT NULL AUTO_INCREMENT,
  `department_details` varchar(45) DEFAULT NULL,
  `department_name` varchar(45) NOT NULL,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_department`
--

LOCK TABLES `tbl_department` WRITE;
/*!40000 ALTER TABLE `tbl_department` DISABLE KEYS */;
INSERT INTO `tbl_department` VALUES (1,'IT Dept','IT'),(2,'ACC Dept','ACC');
/*!40000 ALTER TABLE `tbl_department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_employee`
--

DROP TABLE IF EXISTS `tbl_employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_employee` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_balance` decimal(2,0) DEFAULT NULL,
  `employee_name` varchar(45) NOT NULL,
  `employee_surname` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `department_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  PRIMARY KEY (`employee_id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `FK_o9xodsq3osvj7l40vgwgst2jl` (`department_id`),
  KEY `FK_knxblndej7yscjqhycyt9vvmj` (`group_id`),
  CONSTRAINT `FK_knxblndej7yscjqhycyt9vvmj` FOREIGN KEY (`group_id`) REFERENCES `tbl_groups` (`group_id`),
  CONSTRAINT `FK_o9xodsq3osvj7l40vgwgst2jl` FOREIGN KEY (`department_id`) REFERENCES `tbl_department` (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_employee`
--

LOCK TABLES `tbl_employee` WRITE;
/*!40000 ALTER TABLE `tbl_employee` DISABLE KEYS */;
INSERT INTO `tbl_employee` VALUES (1,36,'Chris','Magro','1234','cmagro',1,2),(3,24,'Tonio','Micallef','1234','tmicallef',1,1),(19,88,'Karl','Pace','KRELAVMC','kpace',2,1),(20,31,'Joe','Borg','66Z99U6G','jborg',2,1);
/*!40000 ALTER TABLE `tbl_employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_groups`
--

DROP TABLE IF EXISTS `tbl_groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_groups` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT,
  `status_name` varchar(45) NOT NULL,
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_groups`
--

LOCK TABLES `tbl_groups` WRITE;
/*!40000 ALTER TABLE `tbl_groups` DISABLE KEYS */;
INSERT INTO `tbl_groups` VALUES (1,'Admin'),(2,'User');
/*!40000 ALTER TABLE `tbl_groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_leave_history`
--

DROP TABLE IF EXISTS `tbl_leave_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_leave_history` (
  `leavehistory_id` int(11) NOT NULL AUTO_INCREMENT,
  `approval_date` datetime DEFAULT NULL,
  `hours` decimal(2,0) DEFAULT NULL,
  `request_date` datetime NOT NULL,
  `start_date` datetime NOT NULL,
  `employee_id` int(11) NOT NULL,
  `manager_id` int(11) NOT NULL,
  `status_id` int(11) NOT NULL,
  `leave_cancelled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`leavehistory_id`),
  KEY `FK_9s5wv4u0schoe32vqiysr3nus` (`employee_id`),
  KEY `FK_q5ktxh3ccinnnkjls4oy057js` (`manager_id`),
  KEY `FK_ka9a3trmk0ig10nowp8n9gmoo` (`status_id`),
  CONSTRAINT `FK_9s5wv4u0schoe32vqiysr3nus` FOREIGN KEY (`employee_id`) REFERENCES `tbl_employee` (`employee_id`),
  CONSTRAINT `FK_q5ktxh3ccinnnkjls4oy057js` FOREIGN KEY (`manager_id`) REFERENCES `tbl_manager` (`manager_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_leave_history`
--

LOCK TABLES `tbl_leave_history` WRITE;
/*!40000 ALTER TABLE `tbl_leave_history` DISABLE KEYS */;
INSERT INTO `tbl_leave_history` VALUES (25,NULL,8,'2015-07-15 16:14:06','2015-01-12 00:00:00',20,2,1,0),(26,NULL,8,'2015-07-15 16:14:07','2015-03-12 00:00:00',20,2,1,0),(27,NULL,8,'2015-07-15 16:14:10','2015-07-12 00:00:00',20,2,1,0),(29,NULL,8,'2015-07-15 17:30:47','2015-07-12 00:00:00',20,2,1,0),(30,NULL,8,'2015-07-15 17:30:49','2015-12-12 00:00:00',20,2,1,0),(31,NULL,8,'2015-07-15 17:30:51','2015-12-12 00:00:00',20,2,1,0),(32,NULL,8,'2015-07-15 19:32:07','2015-09-05 00:00:00',1,1,1,0),(33,NULL,4,'2015-07-15 19:32:20','2015-08-16 00:00:00',1,1,1,0),(34,NULL,40,'2015-07-15 19:32:25','2015-02-04 00:00:00',1,1,1,0);
/*!40000 ALTER TABLE `tbl_leave_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_manager`
--

DROP TABLE IF EXISTS `tbl_manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_manager` (
  `manager_id` int(11) NOT NULL AUTO_INCREMENT,
  `department_id` int(11) NOT NULL,
  `employee_id` int(11) NOT NULL,
  PRIMARY KEY (`manager_id`),
  KEY `FK_nty4quwsn71yotam6yhq95hys` (`department_id`),
  KEY `FK_2af7g3f2xjyow5od2rsetkeau` (`employee_id`),
  CONSTRAINT `FK_2af7g3f2xjyow5od2rsetkeau` FOREIGN KEY (`employee_id`) REFERENCES `tbl_employee` (`employee_id`),
  CONSTRAINT `FK_nty4quwsn71yotam6yhq95hys` FOREIGN KEY (`department_id`) REFERENCES `tbl_department` (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_manager`
--

LOCK TABLES `tbl_manager` WRITE;
/*!40000 ALTER TABLE `tbl_manager` DISABLE KEYS */;
INSERT INTO `tbl_manager` VALUES (1,1,3),(2,2,19);
/*!40000 ALTER TABLE `tbl_manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_status`
--

DROP TABLE IF EXISTS `tbl_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_status` (
  `status_id` int(11) NOT NULL AUTO_INCREMENT,
  `status_name` varchar(45) NOT NULL,
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_status`
--

LOCK TABLES `tbl_status` WRITE;
/*!40000 ALTER TABLE `tbl_status` DISABLE KEYS */;
INSERT INTO `tbl_status` VALUES (1,'new'),(2,'accepted'),(3,'cancelled'),(4,'rejected');
/*!40000 ALTER TABLE `tbl_status` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-07-15 19:41:02
