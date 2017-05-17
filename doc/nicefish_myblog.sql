-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 119.23.209.42    Database: myblog
-- ------------------------------------------------------
-- Server version	5.7.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `classify`
--

DROP TABLE IF EXISTS `classify`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classify` (
  `ClassifyId` varchar(64) NOT NULL,
  `ClassifyName` varchar(128) NOT NULL,
  `ClassifyDesc` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`ClassifyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帖子分类';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classify`
--

LOCK TABLES `classify` WRITE;
/*!40000 ALTER TABLE `classify` DISABLE KEYS */;
/*!40000 ALTER TABLE `classify` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  ` CommentId` varchar(64) NOT NULL COMMENT '主键',
  `UserId` varchar(64) NOT NULL COMMENT '用户主键',
  `UserName` varchar(128) NOT NULL COMMENT '用户名',
  `NickName` varchar(128) DEFAULT NULL COMMENT '用户昵称',
  `VisitorName` varchar(128) DEFAULT NULL COMMENT '游客评论时网络截取的名称',
  `Content` text NOT NULL COMMENT '评论的主体内容',
  `CommentIP` varchar(64) DEFAULT NULL COMMENT '评论者（用户）的IP',
  `CreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '评论时间',
  `PostId` varchar(64) DEFAULT NULL COMMENT '帖子主键',
  `status` int(11) NOT NULL COMMENT '状态，0:审核，1：发布，2：删除，3：优质评论',
  PRIMARY KEY (` CommentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permission` (
  `PermissionId` varchar(64) NOT NULL COMMENT '权限主键',
  `PermissionCode` varchar(64) NOT NULL COMMENT '权限代码',
  `PermissionDesc` varchar(512) DEFAULT NULL COMMENT '权限描述',
  PRIMARY KEY (`PermissionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表	';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post` (
  `PostId` varchar(64) NOT NULL COMMENT '主键',
  `PostTitle` varchar(128) NOT NULL COMMENT '标题',
  `PostContent` text NOT NULL COMMENT '内容',
  `IsOriginal` int(11) DEFAULT '0' COMMENT '是否为原创 0:原创 1：转载',
  `ClassifyId` varchar(64) DEFAULT NULL COMMENT '帖子分类主键 ',
  `ReadTimes` int(11) DEFAULT '0' COMMENT '阅读次数',
  `LikedTimes` int(11) DEFAULT '0' COMMENT '点赞次数',
  `CollectTimes` int(11) DEFAULT '0' COMMENT '收藏次数',
  `CommentTimes` int(11) DEFAULT '0' COMMENT '评论次数',
  `UserId` varchar(64) NOT NULL COMMENT '用户主键',
  `UserName` varchar(128) NOT NULL COMMENT '用户名',
  `EnableComment` int(11) NOT NULL COMMENT '是否可以评论 0：可以评论，1：不能评论',
  `Status` int(11) NOT NULL COMMENT '状态：0:审核中,1:已发布,2:已删除,3:草稿,4:精华,5推到首页',
  `CreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `LastModifyTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `ModifyUserId` varchar(64) DEFAULT NULL COMMENT '修改人的主键',
  `NickName` varchar(128) DEFAULT NULL COMMENT '昵称',
  `PostURL` varchar(128) DEFAULT NULL COMMENT '转载地址',
  `IsFamous` varchar(11) DEFAULT '1' COMMENT '是否精华帖',
  PRIMARY KEY (`PostId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帖子';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `RoleId` varchar(64) NOT NULL,
  `RoleName` varchar(64) NOT NULL,
  `RoleDesc` varchar(256) DEFAULT NULL COMMENT '角色描述',
  `Type` int(11) DEFAULT NULL COMMENT '0内置角色不能修改；1用户自定义角色',
  PRIMARY KEY (`RoleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_permission`
--

DROP TABLE IF EXISTS `role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_permission` (
  `Id` varchar(64) NOT NULL,
  `RoleId` varchar(64) NOT NULL,
  `PermissionId` varchar(64) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限映射表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_permission`
--

LOCK TABLES `role_permission` WRITE;
/*!40000 ALTER TABLE `role_permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uer_role`
--

DROP TABLE IF EXISTS `uer_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uer_role` (
  `Id` varchar(64) NOT NULL,
  `UserId` varchar(64) NOT NULL,
  `RoleId` varchar(64) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色映射表		';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uer_role`
--

LOCK TABLES `uer_role` WRITE;
/*!40000 ALTER TABLE `uer_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `uer_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `upload`
--

DROP TABLE IF EXISTS `upload`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `upload` (
  `UpId` varchar(64) NOT NULL COMMENT '上传主键',
  `UpTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '上传时间',
  `FileType` int(11) NOT NULL COMMENT '文件类型 0 ：图片 1： 附件',
  `FilePath` varchar(128) NOT NULL COMMENT '文件路径',
  `FileName` varchar(64) NOT NULL COMMENT '文件名称',
  `ImgWidth` int(11) DEFAULT NULL COMMENT '图片宽度',
  `ImgHeight` int(11) DEFAULT NULL COMMENT '图片高度',
  `FileDesc` varchar(256) DEFAULT NULL COMMENT '文件描述',
  `UserId` varchar(64) NOT NULL COMMENT '用户主键',
  `ImgModule` int(11) NOT NULL COMMENT '0:文章相关1小图标,2,metro3:用户图像 ',
  `PostId` varchar(64) DEFAULT NULL COMMENT '帖子主键',
  PRIMARY KEY (`UpId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='上传的文件，会员头像、用户头像、门店图片介绍、项目图片介绍等，所有上传的文件都记录在这张表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `upload`
--

LOCK TABLES `upload` WRITE;
/*!40000 ALTER TABLE `upload` DISABLE KEYS */;
/*!40000 ALTER TABLE `upload` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `UserId` varchar(64) NOT NULL COMMENT '用户主键',
  `UserName` varchar(128) NOT NULL COMMENT '用户名',
  `UserRealName` varchar(64) DEFAULT NULL COMMENT '用户真实姓名',
  `NicKName` varchar(128) NOT NULL COMMENT '昵称',
  `EName` varchar(64) DEFAULT NULL COMMENT '英文名',
  `Password` varchar(64) NOT NULL COMMENT '密码',
  `Email` varchar(64) DEFAULT NULL,
  `QQ` varchar(64) DEFAULT NULL COMMENT 'QQ',
  `CellPhone` varchar(64) DEFAULT NULL COMMENT '手机号码',
  `UserDesc` varchar(256) DEFAULT NULL COMMENT '用户描述',
  `UpId` varchar(64) DEFAULT NULL COMMENT '上传文件的主键',
  `Type` int(11) NOT NULL COMMENT '用户类型：0超级管理员1管理员2普通用户',
  `Status` int(11) NOT NULL COMMENT '状态：0未激活1已激活2已禁用',
  `Code` varchar(64) DEFAULT NULL COMMENT '激活码',
  `JoinTime` timestamp NULL DEFAULT NULL COMMENT '登入时间',
  `LeaveTime` timestamp NULL DEFAULT NULL COMMENT '离开时间',
  `RegisterTime` timestamp NULL DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表	';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-17 17:45:48
