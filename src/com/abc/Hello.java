package com.abc;

public class Hello {

	/**
	 * Spring MVC + MyBaitsʵս�����¹���ϵͳ
	 * �����̲��漰View�㣬���ṩ���ҵ��ӿڷ���json����
	 * 
	 * #�������ܣ�
	 * 	�û��������Ź���ְλ����Ա���������������������
	 * 
	 * #�漰�����㣺
	 * 	1��������ܵĴ
	 * 	2��ʹ��ע�����mapper�ı��루�ص��ע���ʹ�ö�̬sql�����֮��Ĺ�����ѯ��
	 * 	3����Controller����е�Ԫ����
	 * 	4����¼����������
	 * 
	 * #��ʹ�õ������ݿ��
	 * ������֮�������ο�doc/���ϵͼ.png
	 * 
	 * �û���
	 * CREATE TABLE `user_inf` (
  		`id` bigint(20) NOT NULL AUTO_INCREMENT,
  		`login_name` varchar(20) NOT NULL,
  		`password` varchar(16) NOT NULL,
  		`status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '1����\r\n -1������',
  		`createdate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  		`user_name` varchar(20) NOT NULL,
  		PRIMARY KEY (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
	 * 
	 * 
	 * Ա����
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
  		`sex` tinyint(4) NOT NULL DEFAULT '1' COMMENT '1�� 2Ů',
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
	 * ���ű�
	 * CREATE TABLE `dept_inf` (
  		`id` bigint(20) NOT NULL AUTO_INCREMENT,
  		`name` varchar(20) NOT NULL,
  		`remark` text,
  		PRIMARY KEY (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

	 * 
	 * 
	 * ��λ��
	 * CREATE TABLE `job_inf` (
  		`id` bigint(20) NOT NULL AUTO_INCREMENT,
  		`name` varchar(20) NOT NULL,
  		`remark` text,
  		PRIMARY KEY (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
	 * 
	 * 
	 * �����
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
	 * ������
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
	 * ���������
	 * CREATE TABLE `order_detail_inf` (
  		`id` bigint(20) NOT NULL AUTO_INCREMENT,
  		`order_id` bigint(20) NOT NULL,
  		`article_id` bigint(20) NOT NULL,
  		`count` tinyint(4) NOT NULL,
  		PRIMARY KEY (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
	 * 
	 * 
	 * ��Ʒ��
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
