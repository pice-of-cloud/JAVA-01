create database usercenter;
use usercenter;

--
-- Table structure for table `bb_company_address`
--

DROP TABLE IF EXISTS `bb_company_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bb_company_address` (
                                      `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                      `address_name` varchar(200) DEFAULT NULL COMMENT '地址名称',
                                      `send_status` int(1) DEFAULT NULL COMMENT '默认发货地址：0->否；1->是',
                                      `receive_status` int(1) DEFAULT NULL COMMENT '是否默认收货地址：0->否；1->是',
                                      `name` varchar(64) DEFAULT NULL COMMENT '收发货人姓名',
                                      `phone` varchar(64) DEFAULT NULL COMMENT '收货人电话',
                                      `province` varchar(64) DEFAULT NULL COMMENT '省/直辖市',
                                      `city` varchar(64) DEFAULT NULL COMMENT '市',
                                      `region` varchar(64) DEFAULT NULL COMMENT '区',
                                      `detail_address` varchar(200) DEFAULT NULL COMMENT '详细地址',
                                      PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='公司收货地址表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bb_company_address`
--

LOCK TABLES `bb_company_address` WRITE;
/*!40000 ALTER TABLE `bb_company_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `bb_company_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bc_customer_addr`
--

DROP TABLE IF EXISTS `bc_customer_addr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bc_customer_addr` (
                                    `customer_addr_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
                                    `customer_id` int(10) unsigned NOT NULL COMMENT 'customer_login表的自增ID',
                                    `zip` smallint(6) NOT NULL COMMENT '邮编',
                                    `province` smallint(6) NOT NULL COMMENT '地区表中省份的ID',
                                    `city` smallint(6) NOT NULL COMMENT '地区表中城市的ID',
                                    `district` smallint(6) NOT NULL COMMENT '地区表中的区ID',
                                    `address` varchar(200) NOT NULL COMMENT '具体的地址门牌号',
                                    `is_default` tinyint(4) NOT NULL COMMENT '是否默认',
                                    `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
                                    PRIMARY KEY (`customer_addr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户地址表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bc_customer_addr`
--

LOCK TABLES `bc_customer_addr` WRITE;
/*!40000 ALTER TABLE `bc_customer_addr` DISABLE KEYS */;
/*!40000 ALTER TABLE `bc_customer_addr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bc_customer_balance_log`
--

DROP TABLE IF EXISTS `bc_customer_balance_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bc_customer_balance_log` (
                                           `balance_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '余额日志ID',
                                           `customer_id` int(10) unsigned NOT NULL COMMENT '用户ID',
                                           `source` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '记录来源：1订单，2退货单',
                                           `source_sn` int(10) unsigned NOT NULL COMMENT '相关单据ID',
                                           `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录生成时间',
                                           `amount` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '变动金额',
                                           PRIMARY KEY (`balance_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户余额变动表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bc_customer_balance_log`
--

LOCK TABLES `bc_customer_balance_log` WRITE;
/*!40000 ALTER TABLE `bc_customer_balance_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `bc_customer_balance_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bc_customer_inf`
--

DROP TABLE IF EXISTS `bc_customer_inf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bc_customer_inf` (
                                   `customer_inf_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
                                   `customer_id` bigint(20) NOT NULL COMMENT 'customer_login表的自增ID',
                                   `customer_name` varchar(20) NOT NULL COMMENT '用户真实姓名',
                                   `identity_card_type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '证件类型：1 身份证，2 军官证，3 护照',
                                   `identity_card_no` varchar(20) DEFAULT NULL COMMENT '证件号码',
                                   `mobile_phone` int(11) DEFAULT NULL COMMENT '手机号',
                                   `customer_email` varchar(50) DEFAULT NULL COMMENT '邮箱',
                                   `gender` char(1) DEFAULT NULL COMMENT '性别',
                                   `user_point` int(11) NOT NULL DEFAULT '0' COMMENT '用户积分',
                                   `register_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
                                   `birthday` datetime DEFAULT NULL COMMENT '会员生日',
                                   `customer_level` tinyint(4) NOT NULL DEFAULT '1' COMMENT '会员级别：1 普通会员，2 青铜，3白银，4黄金，5钻石',
                                   `user_money` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '用户余额',
                                   `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
                                   PRIMARY KEY (`customer_inf_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bc_customer_inf`
--

LOCK TABLES `bc_customer_inf` WRITE;
/*!40000 ALTER TABLE `bc_customer_inf` DISABLE KEYS */;
/*!40000 ALTER TABLE `bc_customer_inf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bc_customer_inf1`
--

DROP TABLE IF EXISTS `bc_customer_inf1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bc_customer_inf1` (
                                    `customer_inf_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
                                    `customer_id` bigint(20) NOT NULL COMMENT 'customer_login表的自增ID',
                                    `customer_name` varchar(20) NOT NULL COMMENT '用户真实姓名',
                                    `identity_card_type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '证件类型：1 身份证，2 军官证，3 护照',
                                    `identity_card_no` varchar(20) DEFAULT NULL COMMENT '证件号码',
                                    `mobile_phone` int(11) DEFAULT NULL COMMENT '手机号',
                                    `customer_email` varchar(50) DEFAULT NULL COMMENT '邮箱',
                                    `gender` char(1) DEFAULT NULL COMMENT '性别',
                                    `user_point` int(11) NOT NULL DEFAULT '0' COMMENT '用户积分',
                                    `register_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
                                    `birthday` datetime DEFAULT NULL COMMENT '会员生日',
                                    `customer_level` tinyint(4) NOT NULL DEFAULT '1' COMMENT '会员级别：1 普通会员，2 青铜，3白银，4黄金，5钻石',
                                    `user_money` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '用户余额',
                                    `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
                                    PRIMARY KEY (`customer_inf_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bc_customer_inf1`
--

LOCK TABLES `bc_customer_inf1` WRITE;
/*!40000 ALTER TABLE `bc_customer_inf1` DISABLE KEYS */;
/*!40000 ALTER TABLE `bc_customer_inf1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bc_customer_level_inf`
--

DROP TABLE IF EXISTS `bc_customer_level_inf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bc_customer_level_inf` (
                                         `customer_level` tinyint(4) NOT NULL AUTO_INCREMENT COMMENT '会员级别ID',
                                         `level_name` varchar(10) NOT NULL COMMENT '会员级别名称',
                                         `min_point` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '该级别最低积分',
                                         `max_point` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '该级别最高积分',
                                         `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
                                         PRIMARY KEY (`customer_level`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户级别信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bc_customer_level_inf`
--

LOCK TABLES `bc_customer_level_inf` WRITE;
/*!40000 ALTER TABLE `bc_customer_level_inf` DISABLE KEYS */;
/*!40000 ALTER TABLE `bc_customer_level_inf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bc_customer_login`
--

DROP TABLE IF EXISTS `bc_customer_login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bc_customer_login` (
                                     `customer_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
                                     `login_name` varchar(20) NOT NULL COMMENT '用户登录名',
                                     `password` char(32) NOT NULL COMMENT 'md5加密的密码',
                                     `user_stats` tinyint(4) NOT NULL DEFAULT '1' COMMENT '用户状态',
                                     `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
                                     PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=821672251614035969 DEFAULT CHARSET=utf8mb4 COMMENT='用户登录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bc_customer_login`
--

LOCK TABLES `bc_customer_login` WRITE;
/*!40000 ALTER TABLE `bc_customer_login` DISABLE KEYS */;
INSERT INTO `bc_customer_login` VALUES (821672249768542208,'dufu0','099990000',2,'2021-03-17 01:12:10');
INSERT INTO `bc_customer_login` VALUES (821672250284441600,'dufu1','099990001',2,'2021-03-17 01:12:10');
INSERT INTO `bc_customer_login` VALUES (821672250422853632,'dufu2','099990002',2,'2021-03-17 01:12:10');
INSERT INTO `bc_customer_login` VALUES (821672250565459968,'dufu3','099990003',2,'2021-03-17 01:12:10');
INSERT INTO `bc_customer_login` VALUES (821672250737426432,'dufu4','099990004',2,'2021-03-17 01:12:11');
INSERT INTO `bc_customer_login` VALUES (821672250901004288,'dufu5','099990005',2,'2021-03-17 01:12:11');
INSERT INTO `bc_customer_login` VALUES (821672251068776448,'dufu6','099990006',2,'2021-03-17 01:12:11');
INSERT INTO `bc_customer_login` VALUES (821672251202994176,'dufu7','099990007',2,'2021-03-17 01:12:11');
INSERT INTO `bc_customer_login` VALUES (821672251345600512,'dufu8','099990008',2,'2021-03-17 01:12:11');
INSERT INTO `bc_customer_login` VALUES (821672251484012544,'dufu9','099990009',2,'2021-03-17 01:12:11');
INSERT INTO `bc_customer_login` VALUES (821672251614035968,'dufu10','0999900010',2,'2021-03-17 01:12:11');
/*!40000 ALTER TABLE `bc_customer_login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bc_customer_login1`
--

DROP TABLE IF EXISTS `bc_customer_login1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bc_customer_login1` (
                                      `customer_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
                                      `login_name` varchar(20) NOT NULL COMMENT '用户登录名',
                                      `password` char(32) NOT NULL COMMENT 'md5加密的密码',
                                      `user_stats` tinyint(4) NOT NULL DEFAULT '1' COMMENT '用户状态',
                                      `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
                                      PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户登录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bc_customer_login1`
--

LOCK TABLES `bc_customer_login1` WRITE;
/*!40000 ALTER TABLE `bc_customer_login1` DISABLE KEYS */;
/*!40000 ALTER TABLE `bc_customer_login1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bc_customer_login_log`
--

DROP TABLE IF EXISTS `bc_customer_login_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bc_customer_login_log` (
                                         `login_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '登陆日志ID',
                                         `customer_id` int(10) unsigned NOT NULL COMMENT '登陆用户ID',
                                         `login_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '用户登陆时间',
                                         `login_ip` int(10) unsigned NOT NULL COMMENT '登陆IP',
                                         `login_type` tinyint(4) NOT NULL COMMENT '登陆类型：0未成功，1成功',
                                         PRIMARY KEY (`login_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户登陆日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bc_customer_login_log`
--

LOCK TABLES `bc_customer_login_log` WRITE;
/*!40000 ALTER TABLE `bc_customer_login_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `bc_customer_login_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bc_customer_point_log`
--

DROP TABLE IF EXISTS `bc_customer_point_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bc_customer_point_log` (
                                         `point_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '积分日志ID',
                                         `customer_id` int(10) unsigned NOT NULL COMMENT '用户ID',
                                         `source` tinyint(3) unsigned NOT NULL COMMENT '积分来源：0订单，1登陆，2活动',
                                         `refer_number` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '积分来源相关编号',
                                         `change_point` smallint(6) NOT NULL DEFAULT '0' COMMENT '变更积分数',
                                         `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '积分日志生成时间',
                                         PRIMARY KEY (`point_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户积分日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bc_customer_point_log`
--

LOCK TABLES `bc_customer_point_log` WRITE;
/*!40000 ALTER TABLE `bc_customer_point_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `bc_customer_point_log` ENABLE KEYS */;
UNLOCK TABLES;
