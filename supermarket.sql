/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 8.0.22 : Database - supermarketcashier
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`supermarketcashier` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `supermarketcashier`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `adminid` int NOT NULL AUTO_INCREMENT COMMENT '收银/管理员id',
  `username` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '收银/管理员账号',
  `password` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '收银/管理员密码',
  `identify` char(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '收银员' COMMENT '身份（收银/管理员）',
  PRIMARY KEY (`adminid`,`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `admin` */

insert  into `admin`(`adminid`,`username`,`password`,`identify`) values 
(1,'20201001','123','管理员'),
(2,'1001','123456','收银员'),
(4,'1003','123456','收银员'),
(5,'366428','123','收银员');

/*Table structure for table `buyrecord` */

DROP TABLE IF EXISTS `buyrecord`;

CREATE TABLE `buyrecord` (
  `totalid` int DEFAULT NULL COMMENT '销售总计id（外键）',
  `gid` int DEFAULT NULL COMMENT '商品的id（外键）',
  `buyAmount` int DEFAULT NULL COMMENT '购买每个商品的数量',
  KEY `buyrecord_buytotal` (`totalid`),
  KEY `buyrecord_goods` (`gid`),
  CONSTRAINT `buyrecord_buytotal` FOREIGN KEY (`totalid`) REFERENCES `buytotal` (`totalid`),
  CONSTRAINT `buyrecord_goods` FOREIGN KEY (`gid`) REFERENCES `goods` (`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `buyrecord` */

insert  into `buyrecord`(`totalid`,`gid`,`buyAmount`) values 
(72,2,1),
(72,2,1),
(75,1,1),
(75,4,1),
(76,2,1),
(76,2,1);

/*Table structure for table `buytotal` */

DROP TABLE IF EXISTS `buytotal`;

CREATE TABLE `buytotal` (
  `totalid` int NOT NULL AUTO_INCREMENT COMMENT '销售总计id',
  `uid` int DEFAULT NULL COMMENT '用户id（外键）',
  `salesMoney` double DEFAULT '0' COMMENT '销售总金额（本次消费金额）',
  `payMoney` double DEFAULT NULL COMMENT '客户实际付款',
  `changeMoney` double DEFAULT NULL COMMENT '找零（实际-本次消费）',
  `adminid` int DEFAULT NULL COMMENT '收银员id（外键）',
  PRIMARY KEY (`totalid`),
  KEY `buytotal_admin` (`adminid`),
  KEY `buytotal_user` (`uid`),
  CONSTRAINT `buytotal_admin` FOREIGN KEY (`adminid`) REFERENCES `admin` (`adminid`),
  CONSTRAINT `buytotal_user` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `buytotal` */

insert  into `buytotal`(`totalid`,`uid`,`salesMoney`,`payMoney`,`changeMoney`,`adminid`) values 
(72,2,40,99,59,2),
(75,2,25.4,99,73.6,2),
(76,10,22.2,100,77.8,2);

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `gid` int NOT NULL AUTO_INCREMENT COMMENT '货物的id',
  `gNo` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '货物的编号',
  `gName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '货物的名称',
  `price` double DEFAULT NULL COMMENT '原价',
  `isBargainPrice` char(1) DEFAULT '否' COMMENT '是否特价',
  `bargainPrice` double DEFAULT NULL COMMENT '特价(是特价则执行此价格)',
  `unit` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '单位',
  `stock` int DEFAULT NULL COMMENT '库存',
  PRIMARY KEY (`gid`,`gNo`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `goods` */

insert  into `goods`(`gid`,`gNo`,`gName`,`price`,`isBargainPrice`,`bargainPrice`,`unit`,`stock`) values 
(1,'1003','葡萄',12,'是',10.8,'斤',25),
(2,'1004','哈密瓜',14,'是',11.1,'斤',20),
(3,'1005','火龙果',16.5,'否',14,'斤',100),
(4,'1006','荔枝',15.8,'否',13.8,'斤',100),
(5,'1007','卫龙小辣棒/50g',3.5,'否',3.4,'斤',50),
(6,'1008','卫龙大辣棒/50g',3,'否',2.99,'包',21),
(7,'1011','榴莲',50,'是',40.5,'斤',25),
(10,'1012','润田/550ml',1,'否',0.99,'瓶',100),
(11,'2013','宝马牌自行车',1000,'否',999,'辆',5);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `uid` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `idCard` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户的卡号',
  `integral` double DEFAULT '0' COMMENT '积分',
  PRIMARY KEY (`uid`,`idCard`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user` */

insert  into `user`(`uid`,`idCard`,`integral`) values 
(2,'157',238.4),
(7,'152',99),
(8,'151',110),
(9,'150',138.3),
(10,'188',222.2),
(11,'15909443383',100),
(12,'15797975824',100.6),
(13,'18888888',99),
(14,'16666666',123);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
