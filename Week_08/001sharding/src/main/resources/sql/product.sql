
create database productcenter;
use productcenter;
--
-- Table structure for table `bp_brand`
--

DROP TABLE IF EXISTS `bp_brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bp_brand` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT,
                            `name` varchar(64) DEFAULT NULL COMMENT '名称',
                            `first_letter` varchar(8) DEFAULT NULL COMMENT '首字母',
                            `sort` int(11) DEFAULT NULL COMMENT '排序',
                            `factory_status` int(1) DEFAULT NULL COMMENT '是否为品牌制造商：0->不是；1->是',
                            `show_status` int(1) DEFAULT NULL COMMENT '是否显示',
                            `product_count` int(11) DEFAULT NULL COMMENT '产品数量',
                            `product_comment_count` int(11) DEFAULT NULL COMMENT '产品评论数量',
                            `logo` varchar(255) DEFAULT NULL COMMENT '品牌logo',
                            `big_pic` varchar(255) DEFAULT NULL COMMENT '专区大图',
                            `brand_story` text COMMENT '品牌故事',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品品牌表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bp_brand`
--

LOCK TABLES `bp_brand` WRITE;
/*!40000 ALTER TABLE `bp_brand` DISABLE KEYS */;
/*!40000 ALTER TABLE `bp_brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bp_product_attribute`
--

DROP TABLE IF EXISTS `bp_product_attribute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bp_product_attribute` (
                                        `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                        `product_attribute_category_id` bigint(20) DEFAULT NULL COMMENT '商品属性分类id',
                                        `name` varchar(64) DEFAULT NULL COMMENT '名称',
                                        `select_type` int(1) DEFAULT NULL COMMENT '属性选择类型：0->唯一；1->单选；2->多选；对应属性和参数意义不同；',
                                        `input_type` int(1) DEFAULT NULL COMMENT '属性录入方式：0->手工录入；1->从列表中选取',
                                        `input_list` varchar(255) DEFAULT NULL COMMENT '可选值列表，以逗号隔开',
                                        `sort` int(11) DEFAULT NULL COMMENT '排序字段：最高的可以单独上传图片',
                                        `filter_type` int(1) DEFAULT NULL COMMENT '分类筛选样式：1->普通；1->颜色',
                                        `search_type` int(1) DEFAULT NULL COMMENT '检索类型；0->不需要进行检索；1->关键字检索；2->范围检索',
                                        `related_status` int(1) DEFAULT NULL COMMENT '相同属性产品是否关联；0->不关联；1->关联',
                                        `hand_add_status` int(1) DEFAULT NULL COMMENT '是否支持手动新增；0->不支持；1->支持',
                                        `type` int(1) DEFAULT NULL COMMENT '属性的类型；0->规格；1->参数',
                                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品属性表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bp_product_attribute`
--

LOCK TABLES `bp_product_attribute` WRITE;
/*!40000 ALTER TABLE `bp_product_attribute` DISABLE KEYS */;
/*!40000 ALTER TABLE `bp_product_attribute` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bp_product_attribute_category`
--

DROP TABLE IF EXISTS `bp_product_attribute_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bp_product_attribute_category` (
                                                 `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                                 `name` varchar(64) DEFAULT NULL COMMENT '名称',
                                                 `attribute_count` int(11) DEFAULT NULL COMMENT '属性数量',
                                                 `param_count` int(11) DEFAULT NULL COMMENT '参数数量',
                                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品属性分类表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bp_product_attribute_category`
--

LOCK TABLES `bp_product_attribute_category` WRITE;
/*!40000 ALTER TABLE `bp_product_attribute_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `bp_product_attribute_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bp_product_attribute_value`
--

DROP TABLE IF EXISTS `bp_product_attribute_value`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bp_product_attribute_value` (
                                              `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                              `product_id` bigint(20) DEFAULT NULL COMMENT '商品id',
                                              `product_attribute_id` bigint(20) DEFAULT NULL COMMENT '商品属性id',
                                              `value` varchar(64) DEFAULT NULL COMMENT '手动添加规格或参数的值，参数单值，规格有多个时以逗号隔开',
                                              PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品属性值表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bp_product_attribute_value`
--

LOCK TABLES `bp_product_attribute_value` WRITE;
/*!40000 ALTER TABLE `bp_product_attribute_value` DISABLE KEYS */;
/*!40000 ALTER TABLE `bp_product_attribute_value` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bp_product_category`
--

DROP TABLE IF EXISTS `bp_product_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bp_product_category` (
                                       `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                       `parent_id` bigint(20) DEFAULT NULL COMMENT '上级分类的编号：0表示一级分类',
                                       `name` varchar(64) DEFAULT NULL COMMENT '名称',
                                       `level` int(1) DEFAULT NULL COMMENT '分类级别：0->1级；1->2级',
                                       `product_count` int(11) DEFAULT NULL COMMENT '商品数量',
                                       `product_unit` varchar(64) DEFAULT NULL COMMENT '商品单位',
                                       `nav_status` int(1) DEFAULT NULL COMMENT '是否显示在导航栏：0->不显示；1->显示',
                                       `show_status` int(1) DEFAULT NULL COMMENT '显示状态：0->不显示；1->显示',
                                       `sort` int(11) DEFAULT NULL COMMENT '排序',
                                       `icon` varchar(255) DEFAULT NULL COMMENT '图标',
                                       `keywords` varchar(255) DEFAULT NULL COMMENT '关键字',
                                       `description` text COMMENT '描述',
                                       PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品分类';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bp_product_category`
--

LOCK TABLES `bp_product_category` WRITE;
/*!40000 ALTER TABLE `bp_product_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `bp_product_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bp_product_category_attribute_relation`
--

DROP TABLE IF EXISTS `bp_product_category_attribute_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bp_product_category_attribute_relation` (
                                                          `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                                          `product_category_id` bigint(20) DEFAULT NULL COMMENT '商品分类id',
                                                          `product_attribute_id` bigint(20) DEFAULT NULL COMMENT '商品属性id',
                                                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品分类和属性的关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bp_product_category_attribute_relation`
--

LOCK TABLES `bp_product_category_attribute_relation` WRITE;
/*!40000 ALTER TABLE `bp_product_category_attribute_relation` DISABLE KEYS */;
/*!40000 ALTER TABLE `bp_product_category_attribute_relation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-17 19:24:10
