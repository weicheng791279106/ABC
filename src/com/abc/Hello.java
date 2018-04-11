package com.abc;

public class Hello {

	/**
	 * Spring MVC + MyBaits实战：人事管理系统
	 * 本工程不涉及View层，仅提供相关业务接口返回json数据
	 * 
	 * #包含功能：
	 * 	用户管理，部门管理，职位管理，员工管理，公告管理，订单管理
	 * 
	 * #涉及技术点：
	 * 	1、基本框架的搭建
	 * 	2、使用注释完成mapper的编码（重点关注如何使用动态sql及多表之间的关联查询）
	 * 	3、对Controller层进行单元测试
	 * 	4、登录拦截器需求
	 * 
	 * #所使用到的数据库表：
	 * 各个表之间关联请参考doc/表关系图.png
	 * 
	 * 用户表：
	 * CREATE TABLE `user_inf` (
  		`id` bigint(20) NOT NULL AUTO_INCREMENT,
  		`login_name` varchar(20) NOT NULL,
  		`password` varchar(16) NOT NULL,
  		`status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '1可用\r\n -1不可用',
  		`createdate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  		`user_name` varchar(20) NOT NULL,
  		PRIMARY KEY (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
	 * 
	 * 
	 * 员工表：
	 * CREATE TABLE `emp_inf` (
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

	 * 
	 * 
	 * 部门表：
	 * CREATE TABLE `dept_inf` (
  		`id` bigint(20) NOT NULL AUTO_INCREMENT,
  		`name` varchar(20) NOT NULL,
  		`remark` text,
  		PRIMARY KEY (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

	 * 
	 * 
	 * 岗位表：
	 * CREATE TABLE `job_inf` (
  		`id` bigint(20) NOT NULL AUTO_INCREMENT,
  		`name` varchar(20) NOT NULL,
  		`remark` text,
  		PRIMARY KEY (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
	 * 
	 * 
	 * 公告表：
	 * CREATE TABLE `notice_inf` (
  		`id` bigint(20) NOT NULL AUTO_INCREMENT,
  		`title` varchar(20) NOT NULL,
  		`content` text NOT NULL,
  		`createdate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  		`user_id` bigint(20) NOT NULL,
  		PRIMARY KEY (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
	 * 
	 * 
	 * 订单表：
	 * CREATE TABLE `order_inf` (
  		`id` bigint(20) NOT NULL AUTO_INCREMENT,
  		`addr` text NOT NULL,
  		`total` double NOT NULL,
  		`user_id` bigint(20) NOT NULL,
  		PRIMARY KEY (`id`),
  		KEY `userId` (`user_id`),
  		CONSTRAINT `userId` FOREIGN KEY (`user_id`) REFERENCES `user_inf` (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
	 * 
	 * 
	 * 订单详情表：
	 * CREATE TABLE `order_detail_inf` (
  		`id` bigint(20) NOT NULL AUTO_INCREMENT,
  		`order_id` bigint(20) NOT NULL,
  		`article_id` bigint(20) NOT NULL,
  		`count` tinyint(4) NOT NULL,
  		PRIMARY KEY (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
	 * 
	 * 
	 * 商品表：
	 * CREATE TABLE `article_inf` (
  		`id` bigint(20) NOT NULL AUTO_INCREMENT,
  		`name` varchar(20) NOT NULL,
  		`price` double(11,0) NOT NULL,
  		PRIMARY KEY (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
	 * 
	 * 
	 * 
	 * */
	
}
