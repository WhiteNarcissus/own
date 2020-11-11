/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : own

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2020-11-11 10:44:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_action`
-- ----------------------------
DROP TABLE IF EXISTS `t_action`;
CREATE TABLE `t_action` (
  `action_id` bigint(32) NOT NULL,
  `program_code` varchar(50) NOT NULL COMMENT '所执行程序代码',
  `case_id` bigint(32) NOT NULL,
  `node_code` varchar(32) NOT NULL,
  `task_id` bigint(32) NOT NULL,
  `status` varchar(10) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(30) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`action_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_action
-- ----------------------------

-- ----------------------------
-- Table structure for `t_admire`
-- ----------------------------
DROP TABLE IF EXISTS `t_admire`;
CREATE TABLE `t_admire` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stuIded` varchar(255) NOT NULL,
  `stuId` varchar(255) NOT NULL,
  `admire` int(255) NOT NULL COMMENT '是否被赞  奇数是赞 偶数是赞 ',
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(30) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_admire_stuId` (`stuId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admire
-- ----------------------------

-- ----------------------------
-- Table structure for `t_case`
-- ----------------------------
DROP TABLE IF EXISTS `t_case`;
CREATE TABLE `t_case` (
  `case_id` bigint(20) NOT NULL COMMENT '案件号',
  `message` varchar(255) DEFAULT NULL COMMENT '随便写点什么内容',
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(30) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`case_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_case
-- ----------------------------

-- ----------------------------
-- Table structure for `t_knowledge`
-- ----------------------------
DROP TABLE IF EXISTS `t_knowledge`;
CREATE TABLE `t_knowledge` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `stuId` varchar(10) NOT NULL COMMENT '学号',
  `title` varchar(40) NOT NULL COMMENT '分享标题',
  `content` varchar(2000) DEFAULT NULL COMMENT '知识内容',
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(30) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_knowledge` (`stuId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_knowledge
-- ----------------------------

-- ----------------------------
-- Table structure for `t_node`
-- ----------------------------
DROP TABLE IF EXISTS `t_node`;
CREATE TABLE `t_node` (
  `node_id` bigint(32) NOT NULL,
  `product_code` varchar(32) DEFAULT NULL,
  `node_code` varchar(20) NOT NULL,
  `node_name` varchar(4000) NOT NULL,
  `node_type` varchar(8) NOT NULL DEFAULT 'manual' COMMENT 'manual,auto',
  `status` tinyint(2) NOT NULL COMMENT '是否有效 1 ，0 ',
  `is_show` tinyint(4) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(30) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`node_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_node
-- ----------------------------

-- ----------------------------
-- Table structure for `t_node_program`
-- ----------------------------
DROP TABLE IF EXISTS `t_node_program`;
CREATE TABLE `t_node_program` (
  `node_program_id` bigint(32) NOT NULL,
  `program_code` varchar(50) NOT NULL,
  `node_code` varchar(20) NOT NULL,
  `priority` int(10) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(30) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`node_program_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_node_program
-- ----------------------------

-- ----------------------------
-- Table structure for `t_permission`
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` int(5) NOT NULL,
  `role_id` int(5) NOT NULL COMMENT '和t_role 的id 对应',
  `permission` varchar(15) NOT NULL COMMENT '权限 采用url的形式 /login',
  `description` varchar(20) DEFAULT NULL COMMENT '权限描述 ',
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(30) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_permission
-- ----------------------------

-- ----------------------------
-- Table structure for `t_program`
-- ----------------------------
DROP TABLE IF EXISTS `t_program`;
CREATE TABLE `t_program` (
  `program_id` bigint(32) NOT NULL,
  `program_code` varchar(50) NOT NULL,
  `program_name` varchar(50) NOT NULL,
  `program_type` varchar(31) NOT NULL,
  `status` tinyint(4) NOT NULL,
  `intput_field` longtext NOT NULL,
  `output_field` text NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `product_code` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(30) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`program_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_program
-- ----------------------------

-- ----------------------------
-- Table structure for `t_promo`
-- ----------------------------
DROP TABLE IF EXISTS `t_promo`;
CREATE TABLE `t_promo` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `stuId` varchar(10) NOT NULL COMMENT '学号',
  `title` varchar(50) DEFAULT NULL COMMENT '宣传标题',
  `content` varchar(500) DEFAULT NULL COMMENT '宣传内容',
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(30) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_promo_stuId` (`stuId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_promo
-- ----------------------------

-- ----------------------------
-- Table structure for `t_reviewers`
-- ----------------------------
DROP TABLE IF EXISTS `t_reviewers`;
CREATE TABLE `t_reviewers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stuIded` varchar(255) NOT NULL COMMENT ' 被留言的学号',
  `stuId` varchar(255) NOT NULL COMMENT '留言的学号',
  `message` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '留言信息',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  PRIMARY KEY (`id`),
  KEY `idx_reviewers_stuId` (`stuId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_reviewers
-- ----------------------------

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` bigint(5) NOT NULL AUTO_INCREMENT,
  `role` varchar(10) NOT NULL COMMENT '角色名 admin 超管（增删改查）；guest 访客 （查看）；organizer （新增修改查看）',
  `role_description` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(30) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------

-- ----------------------------
-- Table structure for `t_task`
-- ----------------------------
DROP TABLE IF EXISTS `t_task`;
CREATE TABLE `t_task` (
  `task_id` bigint(32) NOT NULL,
  `case_id` bigint(32) NOT NULL,
  `cur_prog_index` int(20) NOT NULL DEFAULT '0',
  `node_code` varchar(32) NOT NULL,
  `status` varchar(10) NOT NULL,
  `last_node` varchar(32) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(30) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_task
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` bigint(5) NOT NULL,
  `stuId` bigint(5) NOT NULL,
  `role_id` bigint(5) NOT NULL COMMENT '用户 角色 关联表',
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(30) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
