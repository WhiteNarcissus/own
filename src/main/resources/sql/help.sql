/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : help

Target Server Type    : MYSQL
Target Server Version :
/n  ]\
File Encoding         : 65001

Date: 2019-04-11 00:26:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_admire`
-- ----------------------------
DROP TABLE IF EXISTS `t_admire`;
CREATE TABLE `t_admire` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stuIded` varchar(255) NOT NULL,
  `stuId` varchar(255) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `admire` int(255) NOT NULL COMMENT '是否被赞  奇数是赞 偶数是赞 ',
  PRIMARY KEY (`id`),
  KEY `idx_admire_stuId` (`stuId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_admire
-- ----------------------------
INSERT INTO `t_admire` VALUES ('20', '1234', '123456', '2019-04-10 23:54:10', '5');
INSERT INTO `t_admire` VALUES ('21', '9528', '123456', '2019-04-10 23:54:13', '3');
INSERT INTO `t_admire` VALUES ('22', '9527', '123456', '2019-04-10 23:54:18', '3');
INSERT INTO `t_admire` VALUES ('23', '9529', '123456', '2019-04-10 23:54:28', '1');

-- ----------------------------
-- Table structure for `t_knowledge`
-- ----------------------------
DROP TABLE IF EXISTS `t_knowledge`;
CREATE TABLE `t_knowledge` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `stuId` varchar(10) NOT NULL COMMENT '学号',
  `title` varchar(40) NOT NULL COMMENT '分享标题',
  `content` varchar(2000) DEFAULT NULL COMMENT '知识内容',
  `create_by` varchar(20) DEFAULT NULL COMMENT '创建人',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_knowledge` (`stuId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_knowledge
-- ----------------------------
INSERT INTO `t_knowledge` VALUES ('13', '123456', '来自管理员得分享', '<p><img src=\"/image/15260429-12fc6f11a1dc4b6f20190410164644645.jpg\" style=\"width: 367.358px; height: 456px;\"></p><p>学习是一辈子得事情，希望大家都能一直一直学习下去，加油哟</p>', null, '2019-04-10 16:47:35', null);
INSERT INTO `t_knowledge` VALUES ('14', '9527', '真的很喜欢的李清照', '<p><img src=\"/image/527468d5-d4e7-4f51-8321-5bc8670f763e201904101649008.jpg\" style=\"width: 560px;\"><br></p>', null, '2019-04-10 16:49:22', null);
INSERT INTO `t_knowledge` VALUES ('15', '9527', '月小似眉弯', '<p><img src=\"/image/13530291-736f95679e23346620190410165002397.jpg\" style=\"width: 560px;\"></p><p>很久之前看的《你是人间四月天》，名字同样听起来很文艺，很喜欢这样的封面与文风，推荐大家去看哟。</p>', null, '2019-04-10 16:52:34', null);
INSERT INTO `t_knowledge` VALUES ('16', '9528', 'kindle看书心得', '<p><img src=\"/image/u=3466544537,610109080&amp;fm=214&amp;gp=020190410165325522.jpg\" style=\"width: 560px;\"></p><p>对于不喜欢使用手机等电子产品看书的朋友可以试试使用kindle看书，水墨屏，看起来不累眼睛，超级舒服哟</p>', null, '2019-04-10 16:54:56', null);
INSERT INTO `t_knowledge` VALUES ('17', '9528', '凡人怎知相思意', '<p><img src=\"/image/f1fd319168de4c329bf5a1e5b9717f1620190410165536469.jpeg\" style=\"width: 560px;\"></p><p>红豆生南国，是它最耀眼的时候。</p>', null, '2019-04-10 16:56:30', null);
INSERT INTO `t_knowledge` VALUES ('18', '9528', '分享一首诗', '<p><img src=\"/image/15723383-c40548e991665c6620190410165659210.png\" style=\"width: 560px;\"><br></p>', null, '2019-04-10 16:57:16', null);
INSERT INTO `t_knowledge` VALUES ('19', '9529', '世界读书日，让我们都好好读一本书吧', '<p><img src=\"/image/48MJW1SX9hyt20190410165749546.jpg\" style=\"width: 427.217px; height: 889px;\"></p><p>今日份毛姆的《月亮与六便士》：人不能总是看着天上的月亮，而忘记脚下的六便士</p>', null, '2019-04-10 16:59:28', null);
INSERT INTO `t_knowledge` VALUES ('20', '9529', '你喜欢写作吗', '<p><img src=\"/image/12044611-52ffc3b927a9e79e20190410165954149.jpg\" style=\"width: 560px;\"></p><p>喜欢写作的人，大多数心是静的。</p>', null, '2019-04-10 17:00:30', null);
INSERT INTO `t_knowledge` VALUES ('21', '9529', '灵魂碰撞', '<p><img src=\"/image/7978117-1f10c4e78bd95c9a20190410170044485.png\" style=\"width: 367.131px; height: 653px;\"></p><p>好看的皮囊千篇一律，有趣的灵魂万里无一。</p><p>让我们来分享一下，自己有趣的灵魂，好吗？</p>', null, '2019-04-10 17:01:59', null);
INSERT INTO `t_knowledge` VALUES ('22', '9529', '今日读书分享', '<p><img src=\"/image/16269389-0d5a202463044c4020190410170216785.jpg\" style=\"width: 560px;\"></p><p>安静读书是一种乐趣</p>', null, '2019-04-10 17:02:46', null);
INSERT INTO `t_knowledge` VALUES ('23', '9529', '牛顿定律', '<p><img src=\"/image/u=162798554,3635192915&amp;fm=26&amp;gp=020190410170304697.jpg\" style=\"width: 380.255px; height: 507px;\"></p><p>有质量的物体之间存在吸引，妈的，什么鬼物理，老子不学了</p>', null, '2019-04-10 17:03:59', null);
INSERT INTO `t_knowledge` VALUES ('24', '9529', '一起看书吧', '<p><img src=\"/image/16404131-7319ac7a4955864920190410170457576.jpg\" style=\"width: 369.566px; height: 657px;\"></p><p>分享你最近看的一本书，好吗</p>', null, '2019-04-10 17:05:40', null);

-- ----------------------------
-- Table structure for `t_permission`
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` int(5) NOT NULL,
  `role_id` int(5) NOT NULL COMMENT '和t_role 的id 对应',
  `permission` varchar(15) NOT NULL COMMENT '权限 采用url的形式 /login',
  `description` varchar(20) DEFAULT NULL COMMENT '权限描述 ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES ('1', '1', '/edit', '修改权限');
INSERT INTO `t_permission` VALUES ('2', '1', '/delete', '删除权限');
INSERT INTO `t_permission` VALUES ('3', '2', '/edit', '修改权限');
INSERT INTO `t_permission` VALUES ('4', '2', '/delete', '删除权限');

-- ----------------------------
-- Table structure for `t_promo`
-- ----------------------------
DROP TABLE IF EXISTS `t_promo`;
CREATE TABLE `t_promo` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `stuId` varchar(10) NOT NULL COMMENT '学号',
  `title` varchar(50) DEFAULT NULL COMMENT '宣传标题',
  `content` varchar(500) DEFAULT NULL COMMENT '宣传内容',
  `create_user` varchar(20) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_promo_stuId` (`stuId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_promo
-- ----------------------------
INSERT INTO `t_promo` VALUES ('14', '123456', '111', '的风格和接口', null, '2019-04-10 15:51:06', null);
INSERT INTO `t_promo` VALUES ('15', '9529', '今日晨会', '今日晨会大概会在9点15开始，请各位准时参加', null, '2019-04-10 17:06:41', null);
INSERT INTO `t_promo` VALUES ('16', '9529', '软件学院招新啦', '你想加入软件学院吗，欢迎哟', null, '2019-04-10 17:07:27', null);
INSERT INTO `t_promo` VALUES ('17', '9529', '来吧，来吧，相约酒吧', '来，一起嗨嗨嗨', null, '2019-04-10 17:07:58', null);
INSERT INTO `t_promo` VALUES ('18', '9527', '生活大爆炸', '嘿嘿，你感兴趣的活动来啦', null, '2019-04-10 17:16:49', null);
INSERT INTO `t_promo` VALUES ('19', '9527', '真爱九九', '真爱九九活动来了', null, '2019-04-10 17:17:34', null);
INSERT INTO `t_promo` VALUES ('20', '9528', '我是9528', '我的活动是，一起慢跑吧', null, '2019-04-10 17:18:17', null);
INSERT INTO `t_promo` VALUES ('21', '9528', '轰动大事件', '宣传部招新啦，小鲜肉快来', null, '2019-04-10 17:19:56', null);
INSERT INTO `t_promo` VALUES ('22', '1234', '活动', '11122444889联系它', null, '2019-04-10 17:25:14', null);
INSERT INTO `t_promo` VALUES ('24', '123456', '安全为上', '请给位同学不要直接将电话号码贴出来，尽量是qq一类的第三方信息', null, '2019-04-10 17:27:16', null);
INSERT INTO `t_promo` VALUES ('25', '123456', '为广州最靓的boy颁奖典礼！', '颁奖地点：时代广场。 最帅奖得主：毛毛', null, '2019-04-10 23:59:39', null);

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
INSERT INTO `t_reviewers` VALUES ('14', '1234', '123456', '你好，我想要，已经加您了，通过一下，谢谢', '2019-04-10 17:36:37');
INSERT INTO `t_reviewers` VALUES ('15', '9527', '123456', '哈哈哈，好像不错哟', '2019-04-10 17:44:49');
INSERT INTO `t_reviewers` VALUES ('16', '9528', '123456', '可以便宜点吗', '2019-04-10 23:42:32');

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` bigint(5) NOT NULL AUTO_INCREMENT,
  `role` varchar(10) NOT NULL COMMENT '角色名 admin 超管（增删改查）；guest 访客 （查看）；organizer （新增修改查看）',
  `role_description` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', 'admin', '超级管理员');
INSERT INTO `t_role` VALUES ('2', 'student', '学生');
INSERT INTO `t_role` VALUES ('3', 'guest', '游客');

-- ----------------------------
-- Table structure for `t_secondhand`
-- ----------------------------
DROP TABLE IF EXISTS `t_secondhand`;
CREATE TABLE `t_secondhand` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `stuId` int(10) NOT NULL,
  `title` varchar(50) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `create_user` varchar(20) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `price` double DEFAULT NULL COMMENT '商品价格',
  `contact` varchar(255) DEFAULT NULL COMMENT '联系方式',
  `contact_type` varchar(255) DEFAULT NULL COMMENT '联系方式类型',
  `secondhand_url` varchar(255) DEFAULT NULL COMMENT '商品图片url',
  PRIMARY KEY (`id`),
  KEY `idx_secondhand_stuId` (`stuId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2242 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_secondhand
-- ----------------------------
INSERT INTO `t_secondhand` VALUES ('2234', '123456', '111', '<p><img src=\"/image/1220190410153731270.jpg\" style=\"width: 560px;\"><br></p>', null, '2019-04-10 15:37:42', null, '1', '1', 'qq:', '/image/1220190410153731270.jpg,');
INSERT INTO `t_secondhand` VALUES ('2235', '123456', '男士手表一只', '<p><img src=\"/image/binggebiao20190410162844720.png\" style=\"width: 560px;\">买了没多久，喜欢得加我QQ，联系我哈，谢谢<br></p>', null, '2019-04-10 16:30:17', null, '800', '1786873697', 'qq:', '/image/binggebiao20190410162844720.png,');
INSERT INTO `t_secondhand` VALUES ('2236', '123456', '男士手表一只', '<p><img src=\"/image/binggebiao20190410162844720.png\" style=\"width: 560px;\">买了没多久，喜欢得加我QQ，联系我哈，谢谢<br></p>', null, '2019-04-10 16:30:48', null, '800', '1786873697', 'qq:', '/image/binggebiao20190410162844720.png,');
INSERT INTO `t_secondhand` VALUES ('2237', '9529', '本人新买三个月的电磁炉，因为搬家带不走，需要的请联系', '<p><img src=\"/image/daincilv20190410170819500.png\" style=\"width: 560px;\"><br></p>', null, '2019-04-10 17:09:08', null, '1000', '123456790754', '微信:', '/image/daincilv20190410170819500.png,');
INSERT INTO `t_secondhand` VALUES ('2238', '9529', '离校带不走那么多东西，全新茵曼小碎花，要的来拿', '<p><img src=\"/image/fuzhuang2019041017111329.png\" style=\"width: 560px;\"><br></p>', null, '2019-04-10 17:12:03', null, '200', '17388789020', '手机:', '/image/fuzhuang2019041017111329.png,');
INSERT INTO `t_secondhand` VALUES ('2239', '9527', '行李箱一只，由于本人有很多只，所以这只出了，给需要的人', '<p><img src=\"/image/xinglixiang20190410171420805.png\" style=\"width: 560px;\"><br></p>', null, '2019-04-10 17:15:04', null, '300', '1456782345', 'qq:', '/image/xinglixiang20190410171420805.png,');
INSERT INTO `t_secondhand` VALUES ('2240', '9528', '皮鞋，要的来，面试的穿过一次而已', '<p><img src=\"/image/xiezi20190410172015419.png\" style=\"width: 560px;\"><br></p>', null, '2019-04-10 17:20:50', null, '120', '1111', 'qq:', '/image/xiezi20190410172015419.png,');
INSERT INTO `t_secondhand` VALUES ('2241', '1234', '我是游客', '<p><img src=\"/image/fengshan20190410172227202.png\" style=\"width: 560px;\"><br></p>', null, '2019-04-10 17:22:32', null, '12', '55555533443', 'qq:', '/image/fengshan20190410172227202.png,');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `stuId` varchar(10) NOT NULL COMMENT '用户姓名',
  `user_password` varchar(25) NOT NULL COMMENT '密码在 6-15位，字母+数字',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL,
  `user_phone` varchar(25) DEFAULT NULL,
  `user_hobbit` varchar(255) DEFAULT NULL,
  `user_message` varchar(255) DEFAULT NULL,
  `remember` varchar(255) DEFAULT '' COMMENT '如果勾选了 1 没有就用0',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `idx_user_stuId` (`stuId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '123456', '123456', '2019-04-05 00:32:13', null, '2', '2', '2', '');
INSERT INTO `t_user` VALUES ('2', '9527', '123456', '2019-04-05 00:46:23', null, null, null, null, '');
INSERT INTO `t_user` VALUES ('3', '9528', '123456', '2019-04-10 16:36:36', null, '2', '2', '2', '');
INSERT INTO `t_user` VALUES ('4', '9529', '123456', '2019-04-10 16:36:43', null, null, null, null, '');
INSERT INTO `t_user` VALUES ('5', '1234', '123456', '2019-04-10 17:21:38', null, null, null, null, '');

-- ----------------------------
-- Table structure for `t_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` bigint(5) NOT NULL,
  `stuId` bigint(5) NOT NULL,
  `role_id` bigint(5) NOT NULL COMMENT '用户 角色 关联表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '123456', '1');
INSERT INTO `t_user_role` VALUES ('2', '9527', '2');
INSERT INTO `t_user_role` VALUES ('3', '1234', '3');
INSERT INTO `t_user_role` VALUES ('4', '9528', '2');
INSERT INTO `t_user_role` VALUES ('5', '9529', '2');
