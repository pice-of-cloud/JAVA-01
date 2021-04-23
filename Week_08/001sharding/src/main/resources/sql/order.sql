

create database ordercenter0;
use ordercenter0;
--
-- Table structure for table `bo_order`
--

DROP TABLE IF EXISTS `bo_order0`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bo_order0` (
                             `order_id` bigint(20) NOT NULL COMMENT '订单id',
                             `customer_id` bigint(20) NOT NULL COMMENT '用户d',
                             `order_sn` varchar(64) DEFAULT NULL COMMENT '订单编号',
                             `create_time` datetime DEFAULT NULL COMMENT '提交时间',
                             `user_username` varchar(64) DEFAULT NULL COMMENT '用户帐号',
                             `total_amount` decimal(10,2) DEFAULT NULL COMMENT '订单总金额',
                             `pay_amount` decimal(10,2) DEFAULT NULL COMMENT '应付金额（实际支付金额）',
                             `freight_amount` decimal(10,2) DEFAULT NULL COMMENT '运费金额',
                             `pay_type` int(1) DEFAULT NULL COMMENT '支付方式：0->未支付；1->支付宝；2->微信',
                             `source_type` int(1) DEFAULT NULL COMMENT '订单来源：0->PC订单；1->app订单',
                             `status` int(1) DEFAULT NULL COMMENT '订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单',
                             `order_type` int(1) DEFAULT NULL COMMENT '订单类型：0->正常订单；1->秒杀订单',
                             `delivery_company` varchar(64) DEFAULT NULL COMMENT '物流公司(配送方式)',
                             `delivery_sn` varchar(64) DEFAULT NULL COMMENT '物流单号',
                             `auto_confirm_day` int(11) DEFAULT NULL COMMENT '自动确认时间（天）',
                             `receiver_name` varchar(100) NOT NULL COMMENT '收货人姓名',
                             `receiver_phone` varchar(32) NOT NULL COMMENT '收货人电话',
                             `receiver_post_code` varchar(32) DEFAULT NULL COMMENT '收货人邮编',
                             `receiver_province` varchar(32) DEFAULT NULL COMMENT '省份/直辖市',
                             `receiver_city` varchar(32) DEFAULT NULL COMMENT '城市',
                             `receiver_region` varchar(32) DEFAULT NULL COMMENT '区',
                             `receiver_detail_address` varchar(200) DEFAULT NULL COMMENT '详细地址',
                             `note` varchar(500) DEFAULT NULL COMMENT '订单备注',
                             `confirm_status` int(1) DEFAULT NULL COMMENT '确认收货状态：0->未确认；1->已确认',
                             `delete_status` int(1) NOT NULL DEFAULT '0' COMMENT '删除状态：0->未删除；1->已删除',
                             `payment_time` datetime DEFAULT NULL COMMENT '支付时间',
                             `delivery_time` datetime DEFAULT NULL COMMENT '发货时间',
                             `receive_time` datetime DEFAULT NULL COMMENT '确认收货时间',
                             `comment_time` datetime DEFAULT NULL COMMENT '评价时间',
                             `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
                             PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bo_order0`
--

LOCK TABLES `bo_order0` WRITE;
/*!40000 ALTER TABLE `bo_order0` DISABLE KEYS */;
/*!40000 ALTER TABLE `bo_order0` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `bo_order1`
--

create table bo_order1 like bo_order0;
create table bo_order2 like bo_order0;
create table bo_order3 like bo_order0;
create table bo_order4 like bo_order0;
create table bo_order5 like bo_order0;
create table bo_order6 like bo_order0;
create table bo_order7 like bo_order0;
create table bo_order8 like bo_order0;
create table bo_order9 like bo_order0;
create table bo_order10 like bo_order0;
create table bo_order11 like bo_order0;
create table bo_order12 like bo_order0;
create table bo_order13 like bo_order0;
create table bo_order14 like bo_order0;
create table bo_order16 like bo_order0;
--
-- Table structure for table `bo_order_item`
--

DROP TABLE IF EXISTS `bo_order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bo_order_item` (
                                 `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                 `order_id` bigint(20) DEFAULT NULL COMMENT '订单id',
                                 `order_sn` varchar(64) DEFAULT NULL COMMENT '订单编号',
                                 `product_id` bigint(20) DEFAULT NULL COMMENT '商品id',
                                 `product_pic` varchar(500) DEFAULT NULL COMMENT '商品图片',
                                 `product_name` varchar(200) DEFAULT NULL COMMENT '商品名称',
                                 `product_brand` varchar(200) DEFAULT NULL COMMENT '商品品牌',
                                 `product_sn` varchar(64) DEFAULT NULL COMMENT '商品条码',
                                 `product_price` decimal(10,2) DEFAULT NULL COMMENT '销售价格',
                                 `product_quantity` int(11) DEFAULT NULL COMMENT '购买数量',
                                 `product_sku_id` bigint(20) DEFAULT NULL COMMENT '商品sku编号',
                                 `product_sku_code` varchar(50) DEFAULT NULL COMMENT '商品sku条码',
                                 `product_category_id` bigint(20) DEFAULT NULL COMMENT '商品分类id',
                                 `sp1` varchar(100) DEFAULT NULL COMMENT '商品的销售属性1',
                                 `sp2` varchar(100) DEFAULT NULL COMMENT '商品的销售属性2',
                                 `sp3` varchar(100) DEFAULT NULL COMMENT '商品的销售属性3',
                                 `product_attr` varchar(500) DEFAULT NULL COMMENT '商品销售属性:[{"key":"颜色","value":"颜色"},{"key":"容量","value":"4G"}]',
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单商品信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bo_order_item`
--

LOCK TABLES `bo_order_item` WRITE;
/*!40000 ALTER TABLE `bo_order_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `bo_order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bo_order_operate_history`
--

DROP TABLE IF EXISTS `bo_order_operate_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bo_order_operate_history` (
                                            `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                            `order_id` bigint(20) DEFAULT NULL COMMENT '订单id',
                                            `operate_man` varchar(100) DEFAULT NULL COMMENT '操作人：用户；系统；后台管理员',
                                            `create_time` datetime DEFAULT NULL COMMENT '操作时间',
                                            `order_status` int(1) DEFAULT NULL COMMENT '订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单',
                                            `note` varchar(500) DEFAULT NULL COMMENT '备注',
                                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单操作';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bo_order_operate_history`
--

LOCK TABLES `bo_order_operate_history` WRITE;
/*!40000 ALTER TABLE `bo_order_operate_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `bo_order_operate_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bo_order_return_apply`
--

DROP TABLE IF EXISTS `bo_order_return_apply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bo_order_return_apply` (
                                         `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                         `order_id` bigint(20) DEFAULT NULL COMMENT '订单id',
                                         `company_address_id` bigint(20) DEFAULT NULL COMMENT '收货地址表id',
                                         `product_id` bigint(20) DEFAULT NULL COMMENT '退货商品id',
                                         `order_sn` varchar(64) DEFAULT NULL COMMENT '订单编号',
                                         `create_time` datetime DEFAULT NULL COMMENT '申请时间',
                                         `member_username` varchar(64) DEFAULT NULL COMMENT '会员用户名',
                                         `return_amount` decimal(10,2) DEFAULT NULL COMMENT '退款金额',
                                         `return_name` varchar(100) DEFAULT NULL COMMENT '退货人姓名',
                                         `return_phone` varchar(100) DEFAULT NULL COMMENT '退货人电话',
                                         `status` int(1) DEFAULT NULL COMMENT '申请状态：0->待处理；1->退货中；2->已完成；3->已拒绝',
                                         `handle_time` datetime DEFAULT NULL COMMENT '处理时间',
                                         `product_pic` varchar(500) DEFAULT NULL COMMENT '商品图片',
                                         `product_name` varchar(200) DEFAULT NULL COMMENT '商品名称',
                                         `product_brand` varchar(200) DEFAULT NULL COMMENT '商品品牌',
                                         `product_attr` varchar(500) DEFAULT NULL COMMENT '商品销售属性：颜色：红色；尺码：xl;',
                                         `product_count` int(11) DEFAULT NULL COMMENT '退货数量',
                                         `product_price` decimal(10,2) DEFAULT NULL COMMENT '商品单价',
                                         `product_real_price` decimal(10,2) DEFAULT NULL COMMENT '商品实际支付单价',
                                         `reason` varchar(200) DEFAULT NULL COMMENT '原因',
                                         `description` varchar(500) DEFAULT NULL COMMENT '描述',
                                         `proof_pics` varchar(1000) DEFAULT NULL COMMENT '凭证图片，以逗号隔开',
                                         `handle_note` varchar(500) DEFAULT NULL COMMENT '处理备注',
                                         `handle_man` varchar(100) DEFAULT NULL COMMENT '处理人员',
                                         `receive_man` varchar(100) DEFAULT NULL COMMENT '收货人',
                                         `receive_time` datetime DEFAULT NULL COMMENT '收货时间',
                                         `receive_note` varchar(500) DEFAULT NULL COMMENT '收货备注',
                                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单退货申请表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bo_order_return_apply`
--

LOCK TABLES `bo_order_return_apply` WRITE;
/*!40000 ALTER TABLE `bo_order_return_apply` DISABLE KEYS */;
/*!40000 ALTER TABLE `bo_order_return_apply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bo_order_return_reason`
--

DROP TABLE IF EXISTS `bo_order_return_reason`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bo_order_return_reason` (
                                          `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                          `name` varchar(100) DEFAULT NULL COMMENT '退货类型',
                                          `sort` int(11) DEFAULT NULL,
                                          `status` int(1) DEFAULT NULL COMMENT '状态：0->不启用；1->启用',
                                          `create_time` datetime DEFAULT NULL COMMENT '添加时间',
                                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单退货原因表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bo_order_return_reason`
--

LOCK TABLES `bo_order_return_reason` WRITE;
/*!40000 ALTER TABLE `bo_order_return_reason` DISABLE KEYS */;
/*!40000 ALTER TABLE `bo_order_return_reason` ENABLE KEYS */;
UNLOCK TABLES;
