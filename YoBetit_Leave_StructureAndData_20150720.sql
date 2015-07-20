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
-- Dumping data for table `tbl_department`
--

LOCK TABLES `tbl_department` WRITE;
/*!40000 ALTER TABLE `tbl_department` DISABLE KEYS */;
INSERT INTO `tbl_department` VALUES (1,'IT Dept','IT'),(2,'ACC Dept','ACC');
/*!40000 ALTER TABLE `tbl_department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tbl_employee`
--

LOCK TABLES `tbl_employee` WRITE;
/*!40000 ALTER TABLE `tbl_employee` DISABLE KEYS */;
INSERT INTO `tbl_employee` VALUES (1,243,'Chris','Magro','1234','cmagro',1,1,''),(3,24,'Tonio','Micallef','1234','tmicallef',1,1,''),(19,88,'Karl','Pace','KRELAVMC','kpace',2,1,''),(20,39,'Joe','Borg','66Z99U6G','jborg',2,1,''),(21,88,'foo','bar','P60LUHMJ','test',1,1,''),(57,88,'test','test','ADATW71R','test1234',1,2,''),(58,88,'xzczxczcxzxc','czxczxczcx','8KD7WX0D','czxczxczxczxczxczxc',1,1,'');
/*!40000 ALTER TABLE `tbl_employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tbl_groups`
--

LOCK TABLES `tbl_groups` WRITE;
/*!40000 ALTER TABLE `tbl_groups` DISABLE KEYS */;
INSERT INTO `tbl_groups` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `tbl_groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tbl_leave_history`
--

LOCK TABLES `tbl_leave_history` WRITE;
/*!40000 ALTER TABLE `tbl_leave_history` DISABLE KEYS */;
INSERT INTO `tbl_leave_history` VALUES (25,NULL,8,'2015-07-15 16:14:06','2015-01-12 00:00:00',20,2,1,0),(26,NULL,8,'2015-07-15 16:14:07','2015-03-12 00:00:00',20,2,1,1),(27,NULL,8,'2015-07-15 16:14:10','2015-07-12 00:00:00',20,2,1,0),(29,NULL,8,'2015-07-15 17:30:47','2015-07-12 00:00:00',20,2,1,0),(30,NULL,8,'2015-07-15 17:30:49','2015-12-12 00:00:00',20,2,1,0),(31,NULL,8,'2015-07-15 17:30:51','2015-12-12 00:00:00',20,2,1,0),(46,NULL,32,'2015-07-19 18:57:22','2015-07-21 00:00:00',1,1,3,1),(47,NULL,16,'2015-07-19 19:00:55','2015-07-01 00:00:00',1,1,1,0),(48,NULL,24,'2015-07-19 19:01:07','2015-07-04 00:00:00',1,1,1,0),(49,NULL,40,'2015-07-19 19:01:42','2015-08-27 00:00:00',1,1,3,1),(50,NULL,40,'2015-07-19 19:08:06','2015-12-24 00:00:00',1,1,3,1),(51,NULL,8,'2015-07-19 19:08:22','2015-11-25 00:00:00',1,1,3,1),(52,NULL,16,'2015-07-19 20:04:26','2015-07-31 00:00:00',1,1,3,1),(53,NULL,24,'2015-07-19 20:05:17','2015-07-31 00:00:00',1,1,3,1),(54,NULL,24,'2015-07-19 20:05:56','2015-07-29 00:00:00',1,1,3,1),(55,NULL,8,'2015-07-19 20:06:03','2015-07-31 00:00:00',1,1,3,1),(56,NULL,16,'2015-07-19 20:08:05','2015-07-30 00:00:00',1,1,3,1),(57,NULL,16,'2015-07-19 20:12:16','2015-07-30 00:00:00',1,1,3,1),(58,NULL,8,'2015-07-20 01:20:53','2015-07-31 00:00:00',1,1,3,1),(59,NULL,24,'2015-07-20 01:28:41','2015-07-23 00:00:00',1,1,1,0),(60,NULL,4,'2015-07-20 01:28:58','2015-07-31 00:00:00',1,1,1,0);
/*!40000 ALTER TABLE `tbl_leave_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tbl_manager`
--

LOCK TABLES `tbl_manager` WRITE;
/*!40000 ALTER TABLE `tbl_manager` DISABLE KEYS */;
INSERT INTO `tbl_manager` VALUES (1,1,3),(2,2,19);
/*!40000 ALTER TABLE `tbl_manager` ENABLE KEYS */;
UNLOCK TABLES;

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

-- Dump completed on 2015-07-20  7:50:04
