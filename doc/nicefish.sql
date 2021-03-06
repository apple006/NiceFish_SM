/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : nicefish

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2017-02-15 17:44:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `COMMENT_ID` varchar(64) NOT NULL,
  `P_ID` varchar(64) DEFAULT '-1',
  `USER_ID` varchar(64) NOT NULL DEFAULT '-1',
  `USER_NAME` varchar(64) DEFAULT NULL,
  `NICK_NAME` varchar(64) DEFAULT NULL,
  `COMMENT_NAME` varchar(64) DEFAULT NULL COMMENT '对于从网络上抓取到的评论，此字段表示评论者名字。',
  `CONTENT` text,
  `COMMENT_IP` varchar(64) DEFAULT NULL COMMENT '评论者的IP地址',
  `COMMENT_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `POST_ID` varchar(64) DEFAULT NULL,
  `STATUS` int(11) DEFAULT '1' COMMENT '评论状态：0：已删除；1：已发布；2:优质评论；',
  PRIMARY KEY (`COMMENT_ID`),
  KEY `index_post_id` (`POST_ID`),
  KEY `index_comment_time` (`COMMENT_TIME`),
  KEY `index_user_id` (`USER_ID`),
  KEY `index_isbn_status_time` (`COMMENT_TIME`,`STATUS`),
  KEY `index_bookid_status_time` (`COMMENT_TIME`,`STATUS`),
  KEY `index_postid_status_time` (`COMMENT_TIME`,`POST_ID`,`STATUS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `PERMISSION_ID` varchar(64) NOT NULL,
  `PERMISSION_CODE` varchar(64) DEFAULT NULL,
  `PERMISSION_DESC` varchar(512) NOT NULL,
  PRIMARY KEY (`PERMISSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限';

-- ----------------------------
-- Records of permission
-- ----------------------------

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `POST_ID` varchar(64) NOT NULL,
  `POST_TITLE` varchar(128) NOT NULL,
  `POST_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `POST_CONTENT` text NOT NULL,
  `POST_TYPE` int(11) NOT NULL DEFAULT '0' COMMENT '文章的类型，0原创1翻译',
  `LAST_MODIFY_TIME` timestamp NULL DEFAULT NULL,
  `READ_TIMES` int(11) NOT NULL DEFAULT '1',
  `LIKED_TIMES` int(11) NOT NULL DEFAULT '0',
  `COLLECT_TIMES` int(11) NOT NULL DEFAULT '0',
  `USER_ID` varchar(64) NOT NULL,
  `USER_NAME` varchar(64) DEFAULT NULL,
  `ENABLE_COMMENT` int(11) NOT NULL DEFAULT '1' COMMENT '是否可评论\n            0不可\n            1可',
  `STATUS` int(11) NOT NULL DEFAULT '4' COMMENT '状态：\n            1、已删除\n            2、已归档，已归档的内容禁止评论，文章不可删除\n            3、草稿\n            4、已发布\n            5、精华-->精华文章不可删除\n            6、已推至首页\n            ',
  `NICK_NAME` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`POST_ID`),
  KEY `index_user_id` (`USER_ID`),
  KEY `index_post_time` (`POST_TIME`),
  KEY `index_status` (`STATUS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `ROLE_ID` varchar(64) NOT NULL,
  `ROLE_NAME` varchar(64) NOT NULL,
  `ROLE_DESC` varchar(256) DEFAULT NULL,
  `TYPE` int(11) NOT NULL COMMENT '0内置角色不能修改；1用户自定义角色；',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `ID` varchar(64) NOT NULL,
  `PERMISSION_ID` varchar(64) NOT NULL,
  `ROLE_ID` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色和权限映射';

-- ----------------------------
-- Records of role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for upload
-- ----------------------------
DROP TABLE IF EXISTS `upload`;
CREATE TABLE `upload` (
  `UP_ID` varchar(64) NOT NULL,
  `UP_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `FILE_NAME` varchar(128) DEFAULT NULL COMMENT '与物理保存的文件名一致',
  `FILE_TYPE` varchar(16) DEFAULT '1' COMMENT '1、图片；\n            2、附件；',
  `FILE_WIDTH` int(11) DEFAULT '0',
  `FILE_HEIGHT` int(11) DEFAULT '0',
  `FILE_SIZE` float DEFAULT '0',
  `DISPLAY_ORDER` int(11) DEFAULT '0',
  `USER_ID` varchar(64) DEFAULT '0',
  `FILE_MODULE` int(11) DEFAULT '1' COMMENT '1、metro相关的图片\n            2、文章相关的图片\n            3、图书相关的图片\n            4、小图标\n            5、用户头像\n            ',
  `FILE_DESC` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`UP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='上传的文件，会员头像、用户头像、门店图片介绍、项目图片介绍等，所有上传的文件都记录在这张表。';

-- ----------------------------
-- Records of upload
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `USER_ID` varchar(64) NOT NULL,
  `CODE` varchar(64) DEFAULT NULL COMMENT '激活码',
  `REAL_NAME` varchar(64) NOT NULL COMMENT '中文真实姓名',
  `NICK_NAME` varchar(64) DEFAULT NULL COMMENT '中文昵称',
  `E_NAME` varchar(64) DEFAULT NULL COMMENT '英文名',
  `USER_NAME` varchar(64) DEFAULT NULL COMMENT '登录时的账号',
  `PASSWORD` varchar(128) DEFAULT NULL COMMENT '密码',
  `QQ` varchar(64) DEFAULT NULL,
  `EMAIL` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `CELL_PHONE` varchar(64) DEFAULT NULL COMMENT '手机号',
  `USER_DESC` varchar(512) DEFAULT NULL COMMENT '用户简介',
  `UP_ID` varchar(128) DEFAULT NULL COMMENT '上传附件id',
  `STATUS` int(11) DEFAULT '0' COMMENT '0未激活1已激活2已禁用',
  `TYPE` int(11) DEFAULT NULL COMMENT '0超级管理员1管理员2普通用户',
  `JOIN_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登入时间',
  `LEAVE_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '离开时间',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户预计百万级的数据';

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `ID` varchar(64) NOT NULL,
  `USER_ID` varchar(64) NOT NULL,
  `ROLE_ID` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色映射';

-- ----------------------------
-- Records of user_role
-- ----------------------------
