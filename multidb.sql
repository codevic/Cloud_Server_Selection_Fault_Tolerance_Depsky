/*
SQLyog - Free MySQL GUI v5.19
Host - 5.0.15-nt : Database - multi_cloud
*********************************************************************
Server version : 5.0.15-nt
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `multi_cloud`;

USE `multi_cloud`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `m_admin` */

DROP TABLE IF EXISTS `m_admin`;

CREATE TABLE `m_admin` (
  `id` int(5) NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  `password` varchar(50) default NULL,
  `adminid` varchar(20) NOT NULL,
  `address` varchar(50) default NULL,
  `phone` varchar(15) default NULL,
  `email` varchar(50) default NULL,
  PRIMARY KEY  (`id`,`adminid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_admin` */

insert into `m_admin` (`id`,`name`,`password`,`adminid`,`address`,`phone`,`email`) values (1,'Admin','admin','admin','T R Nagar','9916876540','admin@gmail.com');

/*Table structure for table `m_cloud` */

DROP TABLE IF EXISTS `m_cloud`;

CREATE TABLE `m_cloud` (
  `c_id` int(10) NOT NULL auto_increment,
  `c_url` varchar(200) NOT NULL,
  `c_username` varchar(200) NOT NULL,
  `c_password` varchar(200) NOT NULL,
  `c_status` varchar(50) default NULL,
  `c_remarks` varchar(200) default NULL,
  PRIMARY KEY  (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_cloud` */

insert into `m_cloud` (`c_id`,`c_url`,`c_username`,`c_password`,`c_status`,`c_remarks`) values (1,'ftp://dhsinformatics.com/cloud1','dhsinf17','nikisujai','Inactive','First cloud space');
insert into `m_cloud` (`c_id`,`c_url`,`c_username`,`c_password`,`c_status`,`c_remarks`) values (2,'ftp://dhsinformatics.com/cloud2','dhsinf17','nikisujai','Inactive','Second Cloud Space');
insert into `m_cloud` (`c_id`,`c_url`,`c_username`,`c_password`,`c_status`,`c_remarks`) values (3,'ftp://dhsinformatics.com/cloud3','dhsinf17','nikisujai','Active','Third Cloud Space');
insert into `m_cloud` (`c_id`,`c_url`,`c_username`,`c_password`,`c_status`,`c_remarks`) values (4,'ftp://dhsinformatics.com/cloud4','dhsinf17','nikisujai','Active','Fourth Cloud Space');

/*Table structure for table `m_download` */

DROP TABLE IF EXISTS `m_download`;

CREATE TABLE `m_download` (
  `d_id` int(10) NOT NULL auto_increment,
  `d_filename` varchar(100) NOT NULL,
  `d_filetype` varchar(100) NOT NULL,
  `d_date` varchar(100) NOT NULL,
  `d_time` varchar(100) NOT NULL,
  `m_id` int(100) NOT NULL,
  `d_messagedigest` varchar(100) NOT NULL,
  `u_id` int(10) NOT NULL,
  `c_id` int(10) NOT NULL,
  `integrity_status` varchar(100) NOT NULL,
  PRIMARY KEY  (`d_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_download` */

insert into `m_download` (`d_id`,`d_filename`,`d_filetype`,`d_date`,`d_time`,`m_id`,`d_messagedigest`,`u_id`,`c_id`,`integrity_status`) values (11,'a.txt','.txt','27-08-2012','15:55:20',1,'dfa2de7165ad36d331d35d8b1ea8b6af',22,1,'Failed');
insert into `m_download` (`d_id`,`d_filename`,`d_filetype`,`d_date`,`d_time`,`m_id`,`d_messagedigest`,`u_id`,`c_id`,`integrity_status`) values (15,'a.txt','.txt','27-08-2012','18:03:34',1,'dfa2de7165ad36d331d35d8b1ea8b6af',22,1,'Failed');
insert into `m_download` (`d_id`,`d_filename`,`d_filetype`,`d_date`,`d_time`,`m_id`,`d_messagedigest`,`u_id`,`c_id`,`integrity_status`) values (26,'a.txt','.txt','28-08-2012','13:00:58',1,'dfa2de7165ad36d331d35d8b1ea8b6af',3,4,'Failed');
insert into `m_download` (`d_id`,`d_filename`,`d_filetype`,`d_date`,`d_time`,`m_id`,`d_messagedigest`,`u_id`,`c_id`,`integrity_status`) values (27,'a.txt','.txt','28-08-2012','13:09:45',1,'dfa2de7165ad36d331d35d8b1ea8b6af',3,4,'Failed');
insert into `m_download` (`d_id`,`d_filename`,`d_filetype`,`d_date`,`d_time`,`m_id`,`d_messagedigest`,`u_id`,`c_id`,`integrity_status`) values (41,'a.txt','.txt','28-08-2012','16:31:54',1,'dfa2de7165ad36d331d35d8b1ea8b6af',1,1,'Failed');
insert into `m_download` (`d_id`,`d_filename`,`d_filetype`,`d_date`,`d_time`,`m_id`,`d_messagedigest`,`u_id`,`c_id`,`integrity_status`) values (42,'a.txt','.txt','28-08-2012','16:33:10',1,'dfa2de7165ad36d331d35d8b1ea8b6af',1,3,'Failed');
insert into `m_download` (`d_id`,`d_filename`,`d_filetype`,`d_date`,`d_time`,`m_id`,`d_messagedigest`,`u_id`,`c_id`,`integrity_status`) values (43,'a.txt','.txt','28-08-2012','16:34:59',1,'dfa2de7165ad36d331d35d8b1ea8b6af',1,3,'Failed');
insert into `m_download` (`d_id`,`d_filename`,`d_filetype`,`d_date`,`d_time`,`m_id`,`d_messagedigest`,`u_id`,`c_id`,`integrity_status`) values (44,'example.txt','.txt','15-10-2012','18:26:54',3,'',5,3,'Passed');
insert into `m_download` (`d_id`,`d_filename`,`d_filetype`,`d_date`,`d_time`,`m_id`,`d_messagedigest`,`u_id`,`c_id`,`integrity_status`) values (45,'example.txt','.txt','15-10-2012','18:28:41',3,'',5,3,'Passed');
insert into `m_download` (`d_id`,`d_filename`,`d_filetype`,`d_date`,`d_time`,`m_id`,`d_messagedigest`,`u_id`,`c_id`,`integrity_status`) values (46,'example.txt','.txt','15-10-2012','18:30:59',3,'',5,3,'Passed');
insert into `m_download` (`d_id`,`d_filename`,`d_filetype`,`d_date`,`d_time`,`m_id`,`d_messagedigest`,`u_id`,`c_id`,`integrity_status`) values (47,'dmocloud1.txt','.txt','15-10-2012','18:35:18',3,'a08eb7ae76d7a37e476d9c5e7802fbea',6,3,'Passed');
insert into `m_download` (`d_id`,`d_filename`,`d_filetype`,`d_date`,`d_time`,`m_id`,`d_messagedigest`,`u_id`,`c_id`,`integrity_status`) values (48,'dmocloud1.txt','.txt','15-10-2012','18:36:00',3,'a08eb7ae76d7a37e476d9c5e7802fbea',6,3,'Passed');
insert into `m_download` (`d_id`,`d_filename`,`d_filetype`,`d_date`,`d_time`,`m_id`,`d_messagedigest`,`u_id`,`c_id`,`integrity_status`) values (49,'dmocloud1.txt','.txt','16-10-2012','16:11:48',3,'a08eb7ae76d7a37e476d9c5e7802fbea',7,3,'Passed');
insert into `m_download` (`d_id`,`d_filename`,`d_filetype`,`d_date`,`d_time`,`m_id`,`d_messagedigest`,`u_id`,`c_id`,`integrity_status`) values (50,'dmocloud1.txt','.txt','19-10-2012','17:53:20',3,'a08eb7ae76d7a37e476d9c5e7802fbea',7,3,'Passed');
insert into `m_download` (`d_id`,`d_filename`,`d_filetype`,`d_date`,`d_time`,`m_id`,`d_messagedigest`,`u_id`,`c_id`,`integrity_status`) values (51,'demo16.txt','.txt','25-10-2012','16:11:23',2,'aa847cf987920769fe0bd60e9bf02159',8,2,'Failed');
insert into `m_download` (`d_id`,`d_filename`,`d_filetype`,`d_date`,`d_time`,`m_id`,`d_messagedigest`,`u_id`,`c_id`,`integrity_status`) values (52,'demo16.txt','.txt','25-10-2012','16:52:44',2,'aa847cf987920769fe0bd60e9bf02159',9,2,'Failed');
insert into `m_download` (`d_id`,`d_filename`,`d_filetype`,`d_date`,`d_time`,`m_id`,`d_messagedigest`,`u_id`,`c_id`,`integrity_status`) values (53,'demo16.txt','.txt','25-10-2012','16:53:05',2,'aa847cf987920769fe0bd60e9bf02159',9,2,'Failed');
insert into `m_download` (`d_id`,`d_filename`,`d_filetype`,`d_date`,`d_time`,`m_id`,`d_messagedigest`,`u_id`,`c_id`,`integrity_status`) values (54,'demo16.txt','.txt','25-10-2012','17:35:46',2,'aa847cf987920769fe0bd60e9bf02159',9,2,'Failed');
insert into `m_download` (`d_id`,`d_filename`,`d_filetype`,`d_date`,`d_time`,`m_id`,`d_messagedigest`,`u_id`,`c_id`,`integrity_status`) values (55,'pic.jpg','.jpg','25-10-2012','17:55:50',11,'e3b4298e7e5c98a7fa771327b098e9d2',10,2,'Failed');
insert into `m_download` (`d_id`,`d_filename`,`d_filetype`,`d_date`,`d_time`,`m_id`,`d_messagedigest`,`u_id`,`c_id`,`integrity_status`) values (56,'pic.jpg','.jpg','25-10-2012','17:58:08',11,'e3b4298e7e5c98a7fa771327b098e9d2',10,2,'Failed');
insert into `m_download` (`d_id`,`d_filename`,`d_filetype`,`d_date`,`d_time`,`m_id`,`d_messagedigest`,`u_id`,`c_id`,`integrity_status`) values (57,'p2.jpg','.jpg','25-10-2012','18:17:44',11,'bd7c27afc5a7a93c26353aaeead798e6',11,2,'Failed');
insert into `m_download` (`d_id`,`d_filename`,`d_filetype`,`d_date`,`d_time`,`m_id`,`d_messagedigest`,`u_id`,`c_id`,`integrity_status`) values (58,'p2.jpg','.jpg','25-10-2012','18:19:14',11,'bd7c27afc5a7a93c26353aaeead798e6',12,2,'Failed');
insert into `m_download` (`d_id`,`d_filename`,`d_filetype`,`d_date`,`d_time`,`m_id`,`d_messagedigest`,`u_id`,`c_id`,`integrity_status`) values (59,'Winter.jpg','.jpg','21-11-2012','18:43:36',11,'4721ec8bd0ac4114713abf6d7144a26d',13,3,'Passed');

/*Table structure for table `m_fault_tolerance` */

DROP TABLE IF EXISTS `m_fault_tolerance`;

CREATE TABLE `m_fault_tolerance` (
  `f_id` int(10) NOT NULL auto_increment,
  `f_probability` decimal(10,1) NOT NULL,
  `f_formula` varchar(100) NOT NULL,
  `f_value` decimal(10,1) NOT NULL,
  `f_no_of_clouds` int(10) default NULL,
  PRIMARY KEY  (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_fault_tolerance` */

insert into `m_fault_tolerance` (`f_id`,`f_probability`,`f_formula`,`f_value`,`f_no_of_clouds`) values (1,'0.3','3*0.3+1','1.9',2);

/*Table structure for table `m_transactions` */

DROP TABLE IF EXISTS `m_transactions`;

CREATE TABLE `m_transactions` (
  `t_id` int(10) NOT NULL auto_increment,
  `u_id` int(10) NOT NULL,
  `c_id` int(10) NOT NULL,
  PRIMARY KEY  (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_transactions` */

insert into `m_transactions` (`t_id`,`u_id`,`c_id`) values (1,1,1);
insert into `m_transactions` (`t_id`,`u_id`,`c_id`) values (2,1,2);
insert into `m_transactions` (`t_id`,`u_id`,`c_id`) values (3,1,3);
insert into `m_transactions` (`t_id`,`u_id`,`c_id`) values (4,2,1);
insert into `m_transactions` (`t_id`,`u_id`,`c_id`) values (5,2,3);
insert into `m_transactions` (`t_id`,`u_id`,`c_id`) values (6,2,4);
insert into `m_transactions` (`t_id`,`u_id`,`c_id`) values (7,3,3);
insert into `m_transactions` (`t_id`,`u_id`,`c_id`) values (8,3,4);
insert into `m_transactions` (`t_id`,`u_id`,`c_id`) values (9,4,3);
insert into `m_transactions` (`t_id`,`u_id`,`c_id`) values (10,4,4);
insert into `m_transactions` (`t_id`,`u_id`,`c_id`) values (11,5,3);
insert into `m_transactions` (`t_id`,`u_id`,`c_id`) values (12,5,4);
insert into `m_transactions` (`t_id`,`u_id`,`c_id`) values (13,6,3);
insert into `m_transactions` (`t_id`,`u_id`,`c_id`) values (14,6,4);
insert into `m_transactions` (`t_id`,`u_id`,`c_id`) values (15,7,3);
insert into `m_transactions` (`t_id`,`u_id`,`c_id`) values (16,7,4);
insert into `m_transactions` (`t_id`,`u_id`,`c_id`) values (17,8,2);
insert into `m_transactions` (`t_id`,`u_id`,`c_id`) values (18,8,3);
insert into `m_transactions` (`t_id`,`u_id`,`c_id`) values (19,9,2);
insert into `m_transactions` (`t_id`,`u_id`,`c_id`) values (20,9,3);
insert into `m_transactions` (`t_id`,`u_id`,`c_id`) values (21,10,2);
insert into `m_transactions` (`t_id`,`u_id`,`c_id`) values (22,10,3);
insert into `m_transactions` (`t_id`,`u_id`,`c_id`) values (23,11,2);
insert into `m_transactions` (`t_id`,`u_id`,`c_id`) values (24,11,3);
insert into `m_transactions` (`t_id`,`u_id`,`c_id`) values (25,12,2);
insert into `m_transactions` (`t_id`,`u_id`,`c_id`) values (26,12,3);
insert into `m_transactions` (`t_id`,`u_id`,`c_id`) values (27,13,3);
insert into `m_transactions` (`t_id`,`u_id`,`c_id`) values (28,13,4);

/*Table structure for table `m_upload` */

DROP TABLE IF EXISTS `m_upload`;

CREATE TABLE `m_upload` (
  `u_id` int(10) NOT NULL auto_increment,
  `u_filename` varchar(100) NOT NULL,
  `u_filetype` varchar(100) NOT NULL,
  `u_date` varchar(100) NOT NULL,
  `u_time` varchar(100) NOT NULL,
  `m_id` int(10) NOT NULL,
  `m_messagedigest` varchar(70) NOT NULL,
  `u_no_clouds` int(10) default NULL,
  PRIMARY KEY  (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_upload` */

insert into `m_upload` (`u_id`,`u_filename`,`u_filetype`,`u_date`,`u_time`,`m_id`,`m_messagedigest`,`u_no_clouds`) values (1,'a.txt','.txt','28-08-2012','16:30:16',1,'830ba2e74b85e5a48e4822e34adffd0f',3);
insert into `m_upload` (`u_id`,`u_filename`,`u_filetype`,`u_date`,`u_time`,`m_id`,`m_messagedigest`,`u_no_clouds`) values (2,'color gradient link.txt','.txt','28-08-2012','16:31:30',1,'7a7c7f261c146e903364879b8ed2ed02',3);
insert into `m_upload` (`u_id`,`u_filename`,`u_filetype`,`u_date`,`u_time`,`m_id`,`m_messagedigest`,`u_no_clouds`) values (3,'StudyLinks.txt','.txt','15-10-2012','17:57:08',3,'19a5d25090d4c0a3b62d6dd0bafa4a2d',3);
insert into `m_upload` (`u_id`,`u_filename`,`u_filetype`,`u_date`,`u_time`,`m_id`,`m_messagedigest`,`u_no_clouds`) values (4,'example.txt','.txt','15-10-2012','18:09:20',0,'d18fa5cfcbe781f5d9b502623b259381',3);
insert into `m_upload` (`u_id`,`u_filename`,`u_filetype`,`u_date`,`u_time`,`m_id`,`m_messagedigest`,`u_no_clouds`) values (5,'example.txt','.txt','15-10-2012','18:21:34',3,'d18fa5cfcbe781f5d9b502623b259381',3);
insert into `m_upload` (`u_id`,`u_filename`,`u_filetype`,`u_date`,`u_time`,`m_id`,`m_messagedigest`,`u_no_clouds`) values (6,'dmocloud1.txt','.txt','15-10-2012','18:34:57',3,'a08eb7ae76d7a37e476d9c5e7802fbea',3);
insert into `m_upload` (`u_id`,`u_filename`,`u_filetype`,`u_date`,`u_time`,`m_id`,`m_messagedigest`,`u_no_clouds`) values (7,'dmocloud1.txt','.txt','16-10-2012','16:11:30',3,'a08eb7ae76d7a37e476d9c5e7802fbea',3);
insert into `m_upload` (`u_id`,`u_filename`,`u_filetype`,`u_date`,`u_time`,`m_id`,`m_messagedigest`,`u_no_clouds`) values (8,'demo16.txt','.txt','25-10-2012','16:02:52',2,'d4715f9581e6b2d847543e93346f28f8',2);
insert into `m_upload` (`u_id`,`u_filename`,`u_filetype`,`u_date`,`u_time`,`m_id`,`m_messagedigest`,`u_no_clouds`) values (9,'demo16.txt','.txt','25-10-2012','16:19:50',2,'d4715f9581e6b2d847543e93346f28f8',2);
insert into `m_upload` (`u_id`,`u_filename`,`u_filetype`,`u_date`,`u_time`,`m_id`,`m_messagedigest`,`u_no_clouds`) values (10,'pic.jpg','.jpg','25-10-2012','17:54:52',11,'f35d855863dadd9db355f053da3c118d',2);
insert into `m_upload` (`u_id`,`u_filename`,`u_filetype`,`u_date`,`u_time`,`m_id`,`m_messagedigest`,`u_no_clouds`) values (11,'p2.jpg','.jpg','25-10-2012','18:14:45',11,'1ca166e42fd0b47d4401d44c0beaa45',2);
insert into `m_upload` (`u_id`,`u_filename`,`u_filetype`,`u_date`,`u_time`,`m_id`,`m_messagedigest`,`u_no_clouds`) values (12,'p2.jpg','.jpg','25-10-2012','18:17:42',11,'1ca166e42fd0b47d4401d44c0beaa45',2);
insert into `m_upload` (`u_id`,`u_filename`,`u_filetype`,`u_date`,`u_time`,`m_id`,`m_messagedigest`,`u_no_clouds`) values (13,'Winter.jpg','.jpg','21-11-2012','18:42:29',11,'4721ec8bd0ac4114713abf6d7144a26d',2);

/*Table structure for table `m_user` */

DROP TABLE IF EXISTS `m_user`;

CREATE TABLE `m_user` (
  `m_id` int(10) NOT NULL auto_increment,
  `m_user` varchar(50) NOT NULL,
  `m_pass` varchar(50) default NULL,
  `m_name` varchar(50) default NULL,
  `m_city` varchar(50) default NULL,
  `m_mob` bigint(10) default NULL,
  PRIMARY KEY  (`m_id`,`m_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_user` */

insert into `m_user` (`m_id`,`m_user`,`m_pass`,`m_name`,`m_city`,`m_mob`) values (11,'user','user','User','Blr',123456789);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
