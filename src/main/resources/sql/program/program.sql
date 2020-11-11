/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : own

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2020-11-11 17:25:27
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
