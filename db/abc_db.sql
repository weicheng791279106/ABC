/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : abc_db

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-04-11 09:08:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `article_inf`
-- ----------------------------
DROP TABLE IF EXISTS `article_inf`;
CREATE TABLE `article_inf` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `price` double(11,0) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_inf
-- ----------------------------
INSERT INTO `article_inf` VALUES ('1', 'vivo手机', '2000');
INSERT INTO `article_inf` VALUES ('2', 'oppo手机', '3000');
INSERT INTO `article_inf` VALUES ('3', '联想手机', '5000');
INSERT INTO `article_inf` VALUES ('4', 'iphoneX', '8000');
INSERT INTO `article_inf` VALUES ('5', '小米手机', '1000');

-- ----------------------------
-- Table structure for `dept_inf`
-- ----------------------------
DROP TABLE IF EXISTS `dept_inf`;
CREATE TABLE `dept_inf` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `remark` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept_inf
-- ----------------------------
INSERT INTO `dept_inf` VALUES ('1', '技术部', '兼职修电脑');
INSERT INTO `dept_inf` VALUES ('2', '人事部', '专职搞事情');
INSERT INTO `dept_inf` VALUES ('3', '后勤部', '管仓库');
INSERT INTO `dept_inf` VALUES ('4', '运维部', '电脑坏了不要找我，我是修服务器的哈哈');
INSERT INTO `dept_inf` VALUES ('6', '运营部', '产品运营');

-- ----------------------------
-- Table structure for `emp_inf`
-- ----------------------------
DROP TABLE IF EXISTS `emp_inf`;
CREATE TABLE `emp_inf` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `dept_id` bigint(20) NOT NULL,
  `job_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `salary` int(11) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `addr` text,
  `email` varchar(30) DEFAULT NULL,
  `sex` tinyint(4) NOT NULL DEFAULT '1' COMMENT '1男 2女',
  `birthday` date DEFAULT NULL,
  `createdate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `dept_id` (`dept_id`),
  KEY `job_id` (`job_id`),
  CONSTRAINT `dept_id` FOREIGN KEY (`dept_id`) REFERENCES `dept_inf` (`id`),
  CONSTRAINT `job_id` FOREIGN KEY (`job_id`) REFERENCES `job_inf` (`id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user_inf` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp_inf
-- ----------------------------
INSERT INTO `emp_inf` VALUES ('3', '肖大宝', '3', '3', '15', '14000', '13065474747', '深圳福田', '79797979@qq.com', '1', '1991-09-02', '2018-04-08 09:51:09');
INSERT INTO `emp_inf` VALUES ('4', '韦小宝', '1', '1', '10', '10000', '13065474747', '深圳南山', '79797979@qq.com', '1', '1991-08-15', '2018-04-08 14:17:04');

-- ----------------------------
-- Table structure for `job_inf`
-- ----------------------------
DROP TABLE IF EXISTS `job_inf`;
CREATE TABLE `job_inf` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `remark` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job_inf
-- ----------------------------
INSERT INTO `job_inf` VALUES ('1', 'Android开发', '兼职java后台');
INSERT INTO `job_inf` VALUES ('3', 'iOS开发', '水果机是真真贵');
INSERT INTO `job_inf` VALUES ('4', '客服', '接电话');
INSERT INTO `job_inf` VALUES ('5', '前台', '接待下老板');
INSERT INTO `job_inf` VALUES ('6', '人事主管', '管招人');

-- ----------------------------
-- Table structure for `notice_inf`
-- ----------------------------
DROP TABLE IF EXISTS `notice_inf`;
CREATE TABLE `notice_inf` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) NOT NULL,
  `content` text NOT NULL,
  `createdate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice_inf
-- ----------------------------
INSERT INTO `notice_inf` VALUES ('1', '吃饭啦', '中午12点吃饭快点', '2018-04-08 15:28:55', '7');
INSERT INTO `notice_inf` VALUES ('2', '睡觉啦', '晚上12点睡觉', '2018-04-02 15:29:36', '7');
INSERT INTO `notice_inf` VALUES ('3', '打嗝啦', '不定时需要打一下嗝不然对肠胃不好', '2018-04-08 16:05:22', '9');

-- ----------------------------
-- Table structure for `order_detail_inf`
-- ----------------------------
DROP TABLE IF EXISTS `order_detail_inf`;
CREATE TABLE `order_detail_inf` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) NOT NULL,
  `article_id` bigint(20) NOT NULL,
  `count` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_detail_inf
-- ----------------------------
INSERT INTO `order_detail_inf` VALUES ('1', '1', '1', '1');
INSERT INTO `order_detail_inf` VALUES ('2', '1', '2', '1');
INSERT INTO `order_detail_inf` VALUES ('3', '1', '5', '1');
INSERT INTO `order_detail_inf` VALUES ('4', '2', '4', '1');
INSERT INTO `order_detail_inf` VALUES ('5', '2', '5', '2');
INSERT INTO `order_detail_inf` VALUES ('6', '3', '3', '2');
INSERT INTO `order_detail_inf` VALUES ('7', '3', '1', '1');
INSERT INTO `order_detail_inf` VALUES ('8', '3', '2', '1');

-- ----------------------------
-- Table structure for `order_inf`
-- ----------------------------
DROP TABLE IF EXISTS `order_inf`;
CREATE TABLE `order_inf` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addr` text NOT NULL,
  `total` double NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `userId` (`user_id`),
  CONSTRAINT `userId` FOREIGN KEY (`user_id`) REFERENCES `user_inf` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_inf
-- ----------------------------
INSERT INTO `order_inf` VALUES ('1', '深圳茶光', '6000', '9');
INSERT INTO `order_inf` VALUES ('2', '深圳白石洲', '10000', '9');
INSERT INTO `order_inf` VALUES ('3', '深圳福田', '15000', '19');

-- ----------------------------
-- Table structure for `user_inf`
-- ----------------------------
DROP TABLE IF EXISTS `user_inf`;
CREATE TABLE `user_inf` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(20) NOT NULL,
  `password` varchar(16) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '1可用\r\n -1不可用',
  `createdate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `user_name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_inf
-- ----------------------------
INSERT INTO `user_inf` VALUES ('1', 'admin', '123456', '1', '2018-04-03 15:06:15', '超级管理员');
INSERT INTO `user_inf` VALUES ('7', 'wangdabao', '123456', '1', '2018-04-04 11:11:08', '王大宝');
INSERT INTO `user_inf` VALUES ('9', 'dabaoxiao', '123456', '1', '2018-04-04 09:26:49', '肖大宝');
INSERT INTO `user_inf` VALUES ('10', 'xiaobaowei', '123456', '1', '2018-04-04 09:27:08', '韦小宝');
INSERT INTO `user_inf` VALUES ('12', 'menger', '123456', '1', '2018-04-04 09:28:14', '萌二');
INSERT INTO `user_inf` VALUES ('13', 'mengsan', '123456', '1', '2018-04-04 09:28:29', '萌三');
INSERT INTO `user_inf` VALUES ('14', 'heier', '123456', '1', '2018-04-04 09:28:47', '黑二');
INSERT INTO `user_inf` VALUES ('15', 'heiba', '123456', '1', '2018-04-04 09:29:01', '黑八');
INSERT INTO `user_inf` VALUES ('16', 'queen', '123456', '1', '2018-04-04 09:29:33', '皇后');
INSERT INTO `user_inf` VALUES ('17', 'wangba', '123456', '1', '2018-04-04 09:29:59', '王八');
INSERT INTO `user_inf` VALUES ('18', 'shuijiu', '123456', '1', '2018-04-04 09:30:15', '水九');
INSERT INTO `user_inf` VALUES ('19', 'chunmengdriver', '123456', '1', '2018-04-04 11:11:47', '蠢萌车主');
