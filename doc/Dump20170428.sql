-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: myblog
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
  `UserId` varchar(64) NOT NULL COMMENT '用户主键',
  `UserName` varchar(128) NOT NULL COMMENT '用户名',
  `EnableComment` int(11) NOT NULL COMMENT '是否可以评论 0：可以评论，1：不能评论',
  `Status` int(11) NOT NULL COMMENT '状态：0:审核中,1:已发布,2:已删除,3:草稿,4:精华,5推到首页',
  `CreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `LastModifyTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `ModifyUserId` varchar(64) DEFAULT NULL COMMENT '修改人的主键',
  `NickName` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`PostId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帖子';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES ('02213ac985204d88b810c531a9fb60af','大战长坂坡45','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡45',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:51','2017-04-27 02:02:51',NULL,'张翼德'),('02a678af14034336815228f85b58ac16','大战长坂坡1','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡1',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:07','2017-04-27 02:02:07',NULL,'张翼德'),('076ddde6ed644a21be4894bc35eaec93','大战长坂坡14','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡14',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:20','2017-04-27 02:02:20',NULL,'张翼德'),('09a4d1e35d88402b8b53cc44168f0050','大战长坂坡29','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡29',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:35','2017-04-27 02:02:35',NULL,'张翼德'),('0b2ba49d7efb427c88c425953a585c4a','大战长坂坡43','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡43',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:49','2017-04-27 02:02:49',NULL,'张翼德'),('0ca865fdae3b411ea93d7b9a0a1b63f1','大战长坂坡12','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡12',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:18','2017-04-27 02:02:18',NULL,'张翼德'),('0f6ca83630d24b4daa69a9c66d49415c','大战长坂坡28','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡28',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:34','2017-04-27 02:02:34',NULL,'张翼德'),('13658d7968544c3988f755ed3d04160c','大战长坂坡26','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡26',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:32','2017-04-27 02:02:32',NULL,'张翼德'),('188e6cc5ba1d441f834b56794d854462','大战长坂坡15','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡15',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:21','2017-04-27 02:02:21',NULL,'张翼德'),('1a46186a302e48e7a3ee7da35d9d6306','大战长坂坡8','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡8',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:14','2017-04-27 02:02:14',NULL,'张翼德'),('1ab35314aa264a18b35406eeb0de472d','大战长坂坡10','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡10',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:16','2017-04-27 02:02:16',NULL,'张翼德'),('1afee5ecb28f4f828541e17d14e37f46','大战长坂坡35','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡35',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:41','2017-04-27 02:02:41',NULL,'张翼德'),('25d5dbe895ad48e5a0e9338548d12667','大战长坂坡44','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡44',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:50','2017-04-27 02:02:50',NULL,'张翼德'),('275a744373154ce3a5549daa22092f4a','大战长坂坡36','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡36',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:42','2017-04-27 02:02:42',NULL,'张翼德'),('2cf5be09196341718e4da46de075a7f8','大战长坂坡6','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡6',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:12','2017-04-27 02:02:12',NULL,'张翼德'),('2fb5f6b12f684f08b0bdbc51e4a8bc17','大战长坂坡48','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡48',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:54','2017-04-27 02:02:54',NULL,'张翼德'),('332ea644a0c642d69adb05accd09fad0','大战长坂坡5','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡5',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:11','2017-04-27 02:02:11',NULL,'张翼德'),('3deb7a79f10c47679357f23ffef3ab10','大战长坂坡23','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡23',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:29','2017-04-27 02:02:29',NULL,'张翼德'),('43897c7aedc14b35928a1c50d4ec13c2','大战长坂坡41','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡41',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:47','2017-04-27 02:02:47',NULL,'张翼德'),('48ba8eaf53ff4c1ca850105233d452e4','大战长坂坡25','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡25',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:31','2017-04-27 02:02:31',NULL,'张翼德'),('4bcb965a503e49a7b629f29c17c5565a','大战长坂坡2','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡2',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:08','2017-04-27 02:02:08',NULL,'张翼德'),('5104651fbd734455a29a7ca3edb42915','大战长坂坡39','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡39',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:45','2017-04-27 02:02:45',NULL,'张翼德'),('5866b405daf34aceaff966535cf9ef39','大战长坂坡0','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡0',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:06','2017-04-27 02:02:06',NULL,'张翼德'),('71e6f7729da145c29be8d0e6708f625c','大战长坂坡19','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡19',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:25','2017-04-27 02:02:25',NULL,'张翼德'),('748cdcc3df494926b63ef8906595d92f','大战长坂坡38','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡38',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:44','2017-04-27 02:02:44',NULL,'张翼德'),('80f362be3aba4b42b4b98f3d056e73c3','大战长坂坡16','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡16',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:22','2017-04-27 02:02:22',NULL,'张翼德'),('88377b97aae1463cb4eab165e96d4b63','大战长坂坡3','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡3',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:09','2017-04-27 02:02:09',NULL,'张翼德'),('89ce7e7cf83a4ad58e79bf9c207da7e7','大战长坂坡27','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡27',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:33','2017-04-27 02:02:33',NULL,'张翼德'),('914b94fa6001466a809d3dd981e37890','大战长坂坡40','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡40',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:46','2017-04-27 02:02:46',NULL,'张翼德'),('990358fe8e494b6a81591d848da90fe8','大战长坂坡17','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡17',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:23','2017-04-27 02:02:23',NULL,'张翼德'),('9a7be33fa8ba4201b47d6103a68d28f8','大战长坂坡47','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡47',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:53','2017-04-27 02:02:53',NULL,'张翼德'),('a1479f1ab78f4942b356451e6e8f47d6','大战长坂坡34','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡34',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:40','2017-04-27 02:02:40',NULL,'张翼德'),('a76c0dfd083d40c1abf74177dbaae30c','大战长坂坡31','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡31',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:37','2017-04-27 02:02:37',NULL,'张翼德'),('a891686ac528410897baa26ca4d5a975','大战长坂坡33','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡33',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:39','2017-04-27 02:02:39',NULL,'张翼德'),('a93b2aabff1e453b95a1841af1a4940b','大战长坂坡18','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡18',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:24','2017-04-27 02:02:24',NULL,'张翼德'),('ae25bb0e4728409bacc353ea46200164','大战长坂坡49','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡49',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:55','2017-04-27 02:02:55',NULL,'张翼德'),('af185686b1654c3281f5855ef18aebbc','大战长坂坡32','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡32',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:38','2017-04-27 02:02:38',NULL,'张翼德'),('afc8bfff3251441183940fdfc0eb2e5d','大战长坂坡22','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡22',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:28','2017-04-27 02:02:28',NULL,'张翼德'),('b8d15a1342ea4149a1da42fba3117512','大战长坂坡24','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡24',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:30','2017-04-27 02:02:30',NULL,'张翼德'),('c6940dd46dee462382c0982ecb13416b','大战长坂坡7','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡7',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:13','2017-04-27 02:02:13',NULL,'张翼德'),('c83c0e4a698041fdaf3e68e6e0b50d96','大战长坂坡30','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡30',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:36','2017-04-27 02:02:36',NULL,'张翼德'),('cc8c070f603f4fc78c8d14884f7d9f6c','大战长坂坡13','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡13',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:19','2017-04-27 02:02:19',NULL,'张翼德'),('d345ece096634e49a5103508656de243','大战长坂坡20','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡20',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:26','2017-04-27 02:02:26',NULL,'张翼德'),('d80fb32b8c5649568a2d0c7496511f2a','大战长坂坡4','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡4',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:10','2017-04-27 02:02:10',NULL,'张翼德'),('d8daa12f7e8742b7b86cc385652cc9de','大战长坂坡37','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡37',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:43','2017-04-27 02:02:43',NULL,'张翼德'),('da0d71bbf02f4861999326a0c911304d','大战长坂坡46','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡46',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:52','2017-04-27 02:02:52',NULL,'张翼德'),('ecc27205214749a58f75fc9141ea6400','大战长坂坡11','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡11',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:17','2017-04-27 02:02:17',NULL,'张翼德'),('f0423c17dee8476e807716eed613c3c0','大战长坂坡21','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡21',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:27','2017-04-27 02:02:27',NULL,'张翼德'),('f3fa67ed8eeb4105b4a70db6e6630b5c','大战长坂坡9','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡9',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:15','2017-04-27 02:02:15',NULL,'张翼德'),('f4c44f6ff3284658a3138f71507bbd88','大战长坂坡42','dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡42',1,NULL,99,100,0,'8d2a7444767f4051a0628b02e45b3e79','zhangfei',1000,1,'2017-04-27 02:02:48','2017-04-27 02:02:48',NULL,'张翼德');
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

-- Dump completed on 2017-04-28 18:09:53
