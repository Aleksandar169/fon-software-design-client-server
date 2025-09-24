/*
SQLyog Community v13.3.0 (64 bit)
MySQL - 8.0.18 : Database - seminarski_v2
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`seminarski_v2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `seminarski_v2`;

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `idCustomer` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `number` varchar(50) NOT NULL,
  `place` int(11) NOT NULL,
  PRIMARY KEY (`idCustomer`),
  KEY `place` (`place`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`place`) REFERENCES `place` (`idPlace`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `customer` */

insert  into `customer`(`idCustomer`,`name`,`lastname`,`number`,`place`) values 
(1,'Marko','Markovic','066-777-888',2),
(2,'Pero','Peric','061-111-222',3),
(5,'Seselj','Peric','061-111-222',1);

/*Table structure for table `phone` */

DROP TABLE IF EXISTS `phone`;

CREATE TABLE `phone` (
  `idPhone` int(11) NOT NULL AUTO_INCREMENT,
  `mark` varchar(50) NOT NULL,
  `model` varchar(50) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`idPhone`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `phone` */

insert  into `phone`(`idPhone`,`mark`,`model`,`price`) values 
(1,'Iphone','15pro',900),
(2,'Iphone','15',700),
(3,'Samsung','S24',1000),
(6,'Samsung','Galaxy S24',1010);

/*Table structure for table `place` */

DROP TABLE IF EXISTS `place`;

CREATE TABLE `place` (
  `idPlace` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`idPlace`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `place` */

insert  into `place`(`idPlace`,`name`) values 
(1,'Trebinje'),
(2,'Beograd'),
(3,'NoviSad'),
(9,'Kraljevo');

/*Table structure for table `professionaldegree` */

DROP TABLE IF EXISTS `professionaldegree`;

CREATE TABLE `professionaldegree` (
  `idProfessionaldegree` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`idProfessionaldegree`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `professionaldegree` */

insert  into `professionaldegree`(`idProfessionaldegree`,`name`) values 
(1,'Visa'),
(8,'Visoka');

/*Table structure for table `receipt` */

DROP TABLE IF EXISTS `receipt`;

CREATE TABLE `receipt` (
  `idReceipt` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `totalAmount` double DEFAULT NULL,
  `worker` int(11) NOT NULL,
  `customer` int(11) NOT NULL,
  PRIMARY KEY (`idReceipt`),
  KEY `worker` (`worker`),
  KEY `customer` (`customer`),
  CONSTRAINT `receipt_ibfk_1` FOREIGN KEY (`worker`) REFERENCES `worker` (`idWorker`),
  CONSTRAINT `receipt_ibfk_2` FOREIGN KEY (`customer`) REFERENCES `customer` (`idCustomer`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `receipt` */

insert  into `receipt`(`idReceipt`,`date`,`totalAmount`,`worker`,`customer`) values 
(4,'2025-01-30',1900,1,1),
(5,'2025-02-06',2300,1,2),
(6,'2025-02-05',1910,1,2),
(7,'2025-02-03',3400,1,2),
(8,'2025-02-06',3410,1,1),
(9,'2025-02-06',1600,1,5);

/*Table structure for table `receiptitem` */

DROP TABLE IF EXISTS `receiptitem`;

CREATE TABLE `receiptitem` (
  `rb` int(11) NOT NULL AUTO_INCREMENT,
  `receipt` int(11) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `phonePrice` double DEFAULT NULL,
  `totalPrice` double DEFAULT NULL,
  `phoneId` int(11) NOT NULL,
  PRIMARY KEY (`rb`,`receipt`),
  KEY `receipt` (`receipt`),
  KEY `phoneId` (`phoneId`),
  CONSTRAINT `receiptitem_ibfk_1` FOREIGN KEY (`receipt`) REFERENCES `receipt` (`idReceipt`),
  CONSTRAINT `receiptitem_ibfk_2` FOREIGN KEY (`phoneId`) REFERENCES `phone` (`idPhone`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `receiptitem` */

insert  into `receiptitem`(`rb`,`receipt`,`quantity`,`phonePrice`,`totalPrice`,`phoneId`) values 
(1,4,1,700,700,2),
(14,8,1,1000,1000,3),
(15,9,1,700,700,2),
(17,9,1,900,900,1);

/*Table structure for table `worker` */

DROP TABLE IF EXISTS `worker`;

CREATE TABLE `worker` (
  `idWorker` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`idWorker`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `worker` */

insert  into `worker`(`idWorker`,`name`,`lastname`,`username`,`password`) values 
(1,'Aco','Brajic','aco','aco'),
(2,'Stevo','Brajic','stevo','stevo');

/*Table structure for table `wp` */

DROP TABLE IF EXISTS `wp`;

CREATE TABLE `wp` (
  `date` date DEFAULT NULL,
  `worker` int(11) NOT NULL,
  `pd` int(11) NOT NULL,
  PRIMARY KEY (`worker`,`pd`),
  KEY `pd` (`pd`),
  CONSTRAINT `wp_ibfk_1` FOREIGN KEY (`worker`) REFERENCES `worker` (`idWorker`),
  CONSTRAINT `wp_ibfk_2` FOREIGN KEY (`pd`) REFERENCES `professionaldegree` (`idProfessionaldegree`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `wp` */

insert  into `wp`(`date`,`worker`,`pd`) values 
('2024-12-12',1,1),
('2021-12-12',2,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
