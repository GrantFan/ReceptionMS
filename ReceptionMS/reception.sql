/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : reception

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2018-04-12 14:48:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for accommodation_record
-- ----------------------------
DROP TABLE IF EXISTS `accommodation_record`;
CREATE TABLE `accommodation_record` (
  `id` int(128) NOT NULL AUTO_INCREMENT,
  `reception_number` varchar(128) DEFAULT NULL COMMENT '接待编号',
  `hotel` varchar(255) DEFAULT NULL COMMENT '住宿酒店',
  `room_number` varchar(128) DEFAULT NULL COMMENT '房间号码',
  `checkin_time` date DEFAULT NULL COMMENT '入住时间',
  `checkout_time` date DEFAULT NULL COMMENT '退房时间',
  `hobby` varchar(255) DEFAULT NULL COMMENT '宾客喜好',
  `record_time` datetime DEFAULT NULL COMMENT '录入时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='接待住房记录';

-- ----------------------------
-- Records of accommodation_record
-- ----------------------------

-- ----------------------------
-- Table structure for accommodation_record1
-- ----------------------------
DROP TABLE IF EXISTS `accommodation_record1`;
CREATE TABLE `accommodation_record1` (
  `id` int(128) NOT NULL AUTO_INCREMENT,
  `reception_number` varchar(128) DEFAULT NULL COMMENT '接待编号',
  `reception_date` datetime DEFAULT NULL COMMENT '接待日期',
  `reception_person` varchar(255) DEFAULT NULL COMMENT '接待人',
  `guest_name` varchar(255) DEFAULT NULL COMMENT '宾客姓名',
  `hotel` varchar(255) DEFAULT NULL COMMENT '住宿酒店',
  `room_type_number` varchar(128) DEFAULT NULL COMMENT '房间类型编号',
  `room_number` varchar(128) DEFAULT NULL COMMENT '房间号码',
  `checkin_time` date DEFAULT NULL COMMENT '入住时间',
  `checkout_time` date DEFAULT NULL COMMENT '退房时间',
  `hobby` varchar(255) DEFAULT NULL COMMENT '宾客喜好',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='接待住房记录';

-- ----------------------------
-- Records of accommodation_record1
-- ----------------------------
INSERT INTO `accommodation_record1` VALUES ('1', 'JZ20180203001', '2018-02-03 00:00:00', null, '徐立毅', '东方国际大酒店', 'F00001', '8302', '2018-02-03', '2018-02-04', null, null);

-- ----------------------------
-- Table structure for conference_info
-- ----------------------------
DROP TABLE IF EXISTS `conference_info`;
CREATE TABLE `conference_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `conference_name` varchar(255) DEFAULT NULL COMMENT '会议室名称',
  `hotel` varchar(255) DEFAULT NULL COMMENT '所属酒店',
  `type` varchar(128) DEFAULT NULL COMMENT '会议室类型',
  `position` varchar(128) DEFAULT NULL COMMENT '位置',
  `capacity_num` varchar(128) DEFAULT NULL COMMENT '容纳人数',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='会议室信息';

-- ----------------------------
-- Records of conference_info
-- ----------------------------
INSERT INTO `conference_info` VALUES ('2', '1111', '敦煌国际大酒店', '会议室', '', '1', null);
INSERT INTO `conference_info` VALUES ('3', '2222', '敦煌国际大酒店', '讲座室', '', '2', null);
INSERT INTO `conference_info` VALUES ('4', '东二楼多功能厅', '敦煌丝路怡苑大酒店', '会议室', '', '200-350', null);
INSERT INTO `conference_info` VALUES ('5', '侯见厅', '东方国际大酒店', '会议室', '一号楼', '30', null);
INSERT INTO `conference_info` VALUES ('6', '多功能厅', '敦煌宾馆', '会议室', '南楼', '200', null);
INSERT INTO `conference_info` VALUES ('7', '孟兰厅', '东方国际大酒店', '会议室', '二号楼', '500-700', null);
INSERT INTO `conference_info` VALUES ('8', '悬泉厅', '敦煌宾馆', '会议室', '南楼', '20-30', null);
INSERT INTO `conference_info` VALUES ('9', '牡丹厅', '东方国际大酒店', '会议室', '一号楼', '200-400', null);
INSERT INTO `conference_info` VALUES ('10', '西二楼多功能厅', '敦煌丝路怡苑大酒店', '会议室', '', '400-800', null);
INSERT INTO `conference_info` VALUES ('11', '贵宾厅', '敦煌丝路怡苑大酒店', '会议室', '', '30-40', null);
INSERT INTO `conference_info` VALUES ('12', '飞天厅', '敦煌宾馆', '会议室', '南楼', '80', null);

-- ----------------------------
-- Table structure for conference_record
-- ----------------------------
DROP TABLE IF EXISTS `conference_record`;
CREATE TABLE `conference_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `use_number` varchar(128) DEFAULT NULL COMMENT '会议室使用编号',
  `conference_name` varchar(255) DEFAULT NULL COMMENT '会议室名称',
  `hotel` varchar(255) DEFAULT NULL COMMENT '酒店名称',
  `use_date` date DEFAULT NULL COMMENT '使用日期',
  `start_time` varchar(255) DEFAULT NULL COMMENT '开始时间',
  `end_time` varchar(255) DEFAULT NULL COMMENT '结束时间',
  `purpose` varchar(255) DEFAULT NULL COMMENT '用途说明',
  `guest_num` int(10) DEFAULT NULL COMMENT '来宾人数',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='会议室使用记录';

-- ----------------------------
-- Records of conference_record
-- ----------------------------
INSERT INTO `conference_record` VALUES ('1', 'H20180207001', '东二楼多功能厅', '敦煌丝路怡苑大酒店', '2018-02-07', '08:00', '09:00', null, '10', null);
INSERT INTO `conference_record` VALUES ('2', 'H20180207002', '东二楼多功能厅', '敦煌丝路怡苑大酒店', '2018-02-07', '13:00:00', '15:00:00', null, '20', null);
INSERT INTO `conference_record` VALUES ('3', 'H20180207003', '侯见厅', '东方国际大酒店', '2018-02-08', '9:00:00', '12:00:00', null, '10', null);
INSERT INTO `conference_record` VALUES ('4', 'H20180207004', '多功能厅', '敦煌宾馆', '2018-02-08', '13:00:00', '17:00:00', null, '50', null);
INSERT INTO `conference_record` VALUES ('5', 'H20180208001', '孟兰厅', '酒店名称\r\n东方国际大酒店', '2018-02-08', '15:00:00', '16:00:00', null, '2', null);

-- ----------------------------
-- Table structure for conference_record1
-- ----------------------------
DROP TABLE IF EXISTS `conference_record1`;
CREATE TABLE `conference_record1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `use_number` varchar(128) DEFAULT NULL COMMENT '会议室使用编号',
  `conference_name` varchar(255) DEFAULT NULL COMMENT '会议室名称',
  `hotel_name` varchar(255) DEFAULT NULL COMMENT '酒店名称',
  `use_date` date DEFAULT NULL COMMENT '使用日期',
  `start_time` varchar(255) DEFAULT NULL COMMENT '开始时间',
  `end_time` varchar(255) DEFAULT NULL COMMENT '结束时间',
  `purpose` varchar(255) DEFAULT NULL COMMENT '用途说明',
  `guest_num` int(10) DEFAULT NULL COMMENT '来宾人数',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='会议室使用记录';

-- ----------------------------
-- Records of conference_record1
-- ----------------------------
INSERT INTO `conference_record1` VALUES ('1', 'H20180207001', '东二楼多功能厅', '敦煌丝路怡苑大酒店', '2018-02-07', '08:00', '09:00', null, '10', null);
INSERT INTO `conference_record1` VALUES ('2', 'H20180207002', '东二楼多功能厅', '敦煌丝路怡苑大酒店', '2018-02-07', '13:00:00', '15:00:00', null, '20', null);
INSERT INTO `conference_record1` VALUES ('3', 'H20180207003', '侯见厅', '东方国际大酒店', '2018-02-08', '9:00:00', '12:00:00', null, '10', null);
INSERT INTO `conference_record1` VALUES ('4', 'H20180207004', '多功能厅', '敦煌宾馆', '2018-02-08', '13:00:00', '17:00:00', null, '50', null);
INSERT INTO `conference_record1` VALUES ('5', 'H20180208001', '孟兰厅', '酒店名称\r\n东方国际大酒店', '2018-02-08', '15:00:00', '16:00:00', null, '2', null);

-- ----------------------------
-- Table structure for food_info
-- ----------------------------
DROP TABLE IF EXISTS `food_info`;
CREATE TABLE `food_info` (
  `id` int(128) NOT NULL AUTO_INCREMENT,
  `food_number` varchar(20) DEFAULT NULL COMMENT '套餐编号',
  `food_name` varchar(255) DEFAULT NULL COMMENT '菜品名称',
  `price` decimal(12,0) DEFAULT NULL COMMENT '菜品单价',
  `flavor` varchar(255) DEFAULT NULL COMMENT '菜品口味',
  `type` varchar(255) DEFAULT NULL COMMENT '菜品类型（热菜/凉菜/主食/土产/饮品）',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8 COMMENT='菜品信息';

-- ----------------------------
-- Records of food_info
-- ----------------------------
INSERT INTO `food_info` VALUES ('1', '菜品编号', '菜品名称', null, null, '类型', null);
INSERT INTO `food_info` VALUES ('2', 'T00005', '炝炒菜心', null, null, '热菜', null);
INSERT INTO `food_info` VALUES ('3', 'T00005', '木耳炒肉', null, null, '热菜', null);
INSERT INTO `food_info` VALUES ('4', 'T00005', '虎皮辣子', null, null, '热菜', null);
INSERT INTO `food_info` VALUES ('5', 'T00005', '肉末水蒸蛋', null, null, '热菜', null);
INSERT INTO `food_info` VALUES ('6', 'T00005', '酸辣海带结', null, null, '热菜', null);
INSERT INTO `food_info` VALUES ('7', 'T00005', '蒜泥肘花', null, null, '热菜', null);
INSERT INTO `food_info` VALUES ('8', 'T00005', '凉拌苜蓿', null, null, '热菜', null);
INSERT INTO `food_info` VALUES ('9', 'T00005', '牛肉面（现做）', null, null, '热菜', null);
INSERT INTO `food_info` VALUES ('10', 'T00005', '蒸鸡蛋', null, null, '主食', null);
INSERT INTO `food_info` VALUES ('11', 'T00005', '特色包子', null, null, '主食', null);
INSERT INTO `food_info` VALUES ('12', 'T00005', '糊锅', null, null, '主食', null);
INSERT INTO `food_info` VALUES ('13', 'T00005', '油条', null, null, '主食', null);
INSERT INTO `food_info` VALUES ('14', 'T00005', '烤肠', null, null, '主食', null);
INSERT INTO `food_info` VALUES ('15', 'T00005', '烤番茄', null, null, '主食', null);
INSERT INTO `food_info` VALUES ('16', 'T00005', '牛奶', null, null, '主食', null);
INSERT INTO `food_info` VALUES ('17', 'T00005', '豆浆', null, null, '主食', null);
INSERT INTO `food_info` VALUES ('18', 'T00006', '干煸四季豆', null, null, '主食', null);
INSERT INTO `food_info` VALUES ('19', 'T00006', '小葱木耳', null, null, '热菜', null);
INSERT INTO `food_info` VALUES ('20', 'T00006', '烤番茄', null, null, '热菜', null);
INSERT INTO `food_info` VALUES ('21', 'T00006', '青笋肉片', null, null, '热菜', null);
INSERT INTO `food_info` VALUES ('22', 'T00006', '清炒菊花菜', null, null, '热菜', null);
INSERT INTO `food_info` VALUES ('23', 'T00006', '烤肉肠', null, null, '热菜', null);
INSERT INTO `food_info` VALUES ('24', 'T00006', '土豆片炒肉', null, null, '热菜', null);
INSERT INTO `food_info` VALUES ('25', 'T00006', '手撕甘蓝', null, null, '热菜', null);
INSERT INTO `food_info` VALUES ('26', 'T00006', '酱牛肉', null, null, '热菜', null);
INSERT INTO `food_info` VALUES ('27', 'T00006', '千叶芹菜', null, null, '凉菜', null);
INSERT INTO `food_info` VALUES ('28', 'T00006', '三色萝卜苗', null, null, '凉菜', null);
INSERT INTO `food_info` VALUES ('29', 'T00006', '凉拌黄瓜', null, null, '凉菜', null);
INSERT INTO `food_info` VALUES ('30', 'T00006', '口味海带结', null, null, '凉菜', null);
INSERT INTO `food_info` VALUES ('31', 'T00006', '黄豆菜心', null, null, '凉菜', null);
INSERT INTO `food_info` VALUES ('32', 'T00006', '手撕甘蓝', null, null, '凉菜', null);
INSERT INTO `food_info` VALUES ('33', 'T00006', '大米粥', null, null, '凉菜', null);
INSERT INTO `food_info` VALUES ('34', 'T00006', '玉米珍子粥', null, null, '粥类', null);
INSERT INTO `food_info` VALUES ('35', 'T00006', '红枣糯米粥', null, null, '粥类', null);
INSERT INTO `food_info` VALUES ('36', 'T00006', '现场煎鸡蛋', null, null, '粥类', null);
INSERT INTO `food_info` VALUES ('37', 'T00006', '葫芦素包子', null, null, '主食', null);
INSERT INTO `food_info` VALUES ('38', 'T00006', '小花卷', null, null, '主食', null);
INSERT INTO `food_info` VALUES ('39', 'T00006', '油条', null, null, '主食', null);
INSERT INTO `food_info` VALUES ('40', 'T00006', '牛奶', null, null, '主食', null);
INSERT INTO `food_info` VALUES ('41', 'T00006', '牛肉面', null, null, '主食', null);
INSERT INTO `food_info` VALUES ('42', 'T00006', '酸奶', null, null, '主食', null);
INSERT INTO `food_info` VALUES ('43', 'T00006', '煮鸡蛋', null, null, '主食', null);
INSERT INTO `food_info` VALUES ('44', 'T00006', '糊 锅', null, null, '主食', null);
INSERT INTO `food_info` VALUES ('45', 'T00006', '蛋炒饭', null, null, '主食', null);
INSERT INTO `food_info` VALUES ('46', 'T00006', '炒米线', null, null, '主食', null);
INSERT INTO `food_info` VALUES ('47', 'T00006', '甜 点', null, null, '主食', null);
INSERT INTO `food_info` VALUES ('48', 'T00006', '面 包', null, null, '主食', null);
INSERT INTO `food_info` VALUES ('49', 'T00006', '蒸红萝卜', null, null, '主食', null);
INSERT INTO `food_info` VALUES ('50', 'T00006', '土豆', null, null, '土产', null);
INSERT INTO `food_info` VALUES ('51', 'T00006', '卤水核桃', null, null, '土产', null);
INSERT INTO `food_info` VALUES ('52', 'T00006', '红薯', null, null, '土产', null);
INSERT INTO `food_info` VALUES ('53', 'T00006', '咖啡', null, null, '土产', null);
INSERT INTO `food_info` VALUES ('54', 'T00006', '橙汁', null, null, '饮 品', null);
INSERT INTO `food_info` VALUES ('55', 'T00006', '茶水 柠檬水', null, null, '饮 品', null);
INSERT INTO `food_info` VALUES ('56', 'T00007', '爽口海蜇丝', null, null, '饮 品', null);
INSERT INTO `food_info` VALUES ('57', 'T00007', '芝麻菠菜 ', null, null, '凉 菜', null);
INSERT INTO `food_info` VALUES ('58', 'T00007', '炝拌西兰花', null, null, '凉 菜', null);
INSERT INTO `food_info` VALUES ('59', 'T00007', '炝拌萝卜皮 ', null, null, '凉 菜', null);
INSERT INTO `food_info` VALUES ('60', 'T00007', '雪菜土豆片', null, null, '凉 菜', null);
INSERT INTO `food_info` VALUES ('61', 'T00007', '香拌莲藕', null, null, '凉 菜', null);
INSERT INTO `food_info` VALUES ('62', 'T00007', '冬菜炒肉丝', null, null, '凉 菜', null);
INSERT INTO `food_info` VALUES ('63', 'T00007', '酱爆真菌', null, null, '热 菜', null);
INSERT INTO `food_info` VALUES ('64', 'T00007', '烤番茄', null, null, '热 菜', null);
INSERT INTO `food_info` VALUES ('65', 'T00007', '豆豉青椒圈', null, null, '热 菜', null);
INSERT INTO `food_info` VALUES ('66', 'T00007', '香炝广菜心', null, null, '热 菜', null);
INSERT INTO `food_info` VALUES ('67', 'T00007', '烤肉肠', null, null, '热 菜', null);
INSERT INTO `food_info` VALUES ('68', 'T00007', '上海青炒肉', null, null, '热 菜', null);
INSERT INTO `food_info` VALUES ('69', 'T00007', '醋溜西葫芦', null, null, '热 菜', null);
INSERT INTO `food_info` VALUES ('70', 'T00007', '南瓜小米粥', null, null, '热 菜', null);
INSERT INTO `food_info` VALUES ('71', 'T00007', '黑米粥', null, null, '粥 类', null);
INSERT INTO `food_info` VALUES ('72', 'T00007', '现场煎鸡蛋', null, null, '粥 类', null);
INSERT INTO `food_info` VALUES ('73', 'T00007', '甘蓝素包子', null, null, '主 食', null);
INSERT INTO `food_info` VALUES ('74', 'T00007', '花 卷', null, null, '主 食', null);
INSERT INTO `food_info` VALUES ('75', 'T00007', '油 条', null, null, '主 食', null);
INSERT INTO `food_info` VALUES ('76', 'T00007', '牛肉面', null, null, '主 食', null);
INSERT INTO `food_info` VALUES ('77', 'T00007', '酸 奶', null, null, '主 食', null);
INSERT INTO `food_info` VALUES ('78', 'T00007', '煮鸡蛋', null, null, '主 食', null);
INSERT INTO `food_info` VALUES ('79', 'T00007', '糊 锅', null, null, '主 食', null);
INSERT INTO `food_info` VALUES ('80', 'T00007', '蛋炒饭', null, null, '主 食', null);
INSERT INTO `food_info` VALUES ('81', 'T00007', '炒米线', null, null, '主 食', null);
INSERT INTO `food_info` VALUES ('82', 'T00007', '牛 奶', null, null, '主 食', null);
INSERT INTO `food_info` VALUES ('83', 'T00007', '甜 点', null, null, '主 食', null);
INSERT INTO `food_info` VALUES ('84', 'T00007', '面 包', null, null, '主 食', null);
INSERT INTO `food_info` VALUES ('85', 'T00007', '蒸红萝卜', null, null, '主 食', null);
INSERT INTO `food_info` VALUES ('86', 'T00007', '紫薯', null, null, '土 产', null);
INSERT INTO `food_info` VALUES ('87', 'T00007', '铁杆山药', null, null, '土 产', null);
INSERT INTO `food_info` VALUES ('88', 'T00007', '卤水花生', null, null, '土 产', null);
INSERT INTO `food_info` VALUES ('89', 'T00007', '咖啡', null, null, '土 产', null);
INSERT INTO `food_info` VALUES ('90', 'T00007', '橙汁', null, null, '饮 品', null);
INSERT INTO `food_info` VALUES ('91', 'T00007', '茶水柠檬水', null, null, '饮 品', null);
INSERT INTO `food_info` VALUES ('92', 'T00007', '大米粥', null, null, '饮 品', null);
INSERT INTO `food_info` VALUES ('93', 'T00009', '白切鸡', null, null, '粥 类', null);
INSERT INTO `food_info` VALUES ('94', 'T00009', '酸辣海带', null, null, '凉 菜', null);
INSERT INTO `food_info` VALUES ('95', 'T00009', '凉拌三丝', null, null, '凉 菜', null);
INSERT INTO `food_info` VALUES ('96', 'T00009', '爽口藕带', null, null, '凉 菜', null);
INSERT INTO `food_info` VALUES ('97', 'T00009', '菠菜面筋', null, null, '凉 菜', null);
INSERT INTO `food_info` VALUES ('98', 'T00009', '大拌菜', null, null, '凉 菜', null);
INSERT INTO `food_info` VALUES ('99', 'T00009', '蔬菜沙拉（生菜、苦菊、黄瓜、胡萝卜）', null, null, '凉 菜', null);
INSERT INTO `food_info` VALUES ('100', 'T00009', '尖椒牛肉丝', null, null, '凉 菜', null);
INSERT INTO `food_info` VALUES ('101', 'T00009', '香辣蹄花', null, null, '热 菜', null);
INSERT INTO `food_info` VALUES ('102', 'T00009', '蒜蓉油麦菜', null, null, '热 菜', null);
INSERT INTO `food_info` VALUES ('103', 'T00009', '清炒芥兰圈', null, null, '热 菜', null);
INSERT INTO `food_info` VALUES ('104', 'T00009', '牛肉面', null, null, '热 菜', null);
INSERT INTO `food_info` VALUES ('105', 'T00009', '蛋炒米线', null, null, '主 食', null);
INSERT INTO `food_info` VALUES ('106', 'T00009', '糊锅', null, null, '主 食', null);
INSERT INTO `food_info` VALUES ('107', 'T00009', '油条', null, null, '主 食', null);
INSERT INTO `food_info` VALUES ('108', 'T00009', '地达菜包子', null, null, '主 食', null);
INSERT INTO `food_info` VALUES ('109', 'T00009', '牛奶 ', null, null, '主 食', null);
INSERT INTO `food_info` VALUES ('110', 'T00009', '面包', null, null, '主 食', null);
INSERT INTO `food_info` VALUES ('111', 'T00009', '烤番茄 ', null, null, '主 食', null);
INSERT INTO `food_info` VALUES ('112', 'T00009', '小蛋糕', null, null, '主 食', null);
INSERT INTO `food_info` VALUES ('113', 'T00009', '哈雷杯', null, null, '主 食', null);
INSERT INTO `food_info` VALUES ('114', 'T00009', '咖啡', null, null, '主 食', null);
INSERT INTO `food_info` VALUES ('115', 'T00009', '橙汁', null, null, '饮 品', null);
INSERT INTO `food_info` VALUES ('116', 'T00009', '茶水柠檬水', null, null, '饮 品', null);

-- ----------------------------
-- Table structure for guest_info
-- ----------------------------
DROP TABLE IF EXISTS `guest_info`;
CREATE TABLE `guest_info` (
  `id` int(128) NOT NULL AUTO_INCREMENT,
  `guest_name` varchar(255) DEFAULT NULL COMMENT '宾客姓名',
  `main_position` varchar(255) DEFAULT NULL COMMENT '主职务',
  `deputy_position` varchar(255) DEFAULT NULL COMMENT '副职务',
  `office_area` varchar(255) DEFAULT NULL COMMENT '任职地区',
  `sex` int(1) DEFAULT '1' COMMENT '性别',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `birth_date` date DEFAULT NULL COMMENT '出生日期',
  `nation` int(2) DEFAULT NULL COMMENT '民族',
  `education` int(2) DEFAULT NULL COMMENT '学历',
  `origin_place` varchar(255) DEFAULT NULL COMMENT '籍贯',
  `telphone` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `phone` varchar(11) DEFAULT NULL COMMENT '家庭/办公电话',
  `email` varchar(30) DEFAULT NULL COMMENT '邮件地址',
  `address` varchar(255) DEFAULT NULL COMMENT '家庭地址',
  `guest_type` varchar(255) DEFAULT NULL COMMENT '宾客类型',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='宾客信息';

-- ----------------------------
-- Records of guest_info
-- ----------------------------

-- ----------------------------
-- Table structure for hotel_info
-- ----------------------------
DROP TABLE IF EXISTS `hotel_info`;
CREATE TABLE `hotel_info` (
  `id` int(128) NOT NULL AUTO_INCREMENT,
  `hotel_name` varchar(64) DEFAULT NULL COMMENT '酒店名称',
  `linkman` varchar(64) DEFAULT NULL COMMENT '酒店联系人',
  `telphone` varchar(64) DEFAULT NULL COMMENT '联系电话',
  `phone` varchar(64) DEFAULT NULL COMMENT '座机',
  `area` varchar(255) DEFAULT NULL COMMENT '所属行政区',
  `address` varchar(255) DEFAULT NULL COMMENT '酒店地址',
  `plane_graph` varchar(255) DEFAULT NULL COMMENT '酒店平面图',
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='酒店信息';

-- ----------------------------
-- Records of hotel_info
-- ----------------------------
INSERT INTO `hotel_info` VALUES ('1', '酒店名称', '联系人', '联系电话', '酒店座机', '所属行政区', '酒店地址', null, null);
INSERT INTO `hotel_info` VALUES ('2', '世纪大酒店', '', '', '0937-2666186', '肃州区', '酒泉市世纪大道55号', null, null);
INSERT INTO `hotel_info` VALUES ('3', '东方国际大酒店', '马艳玲', '18193748166', '0937-2699999', '肃州区', '酒泉市肃州区仓门街6号', null, null);
INSERT INTO `hotel_info` VALUES ('4', '光明大酒店', '王海锋', '18919375595', '0937-2807777', '肃州区', '甘肃省酒泉市肃州区盘旋中路18号', null, null);
INSERT INTO `hotel_info` VALUES ('5', '宏兴大酒店', '陈浩', '18919427777', '0937-2802222', '肃州区', '甘肃省酒泉市肃州区盘旋西路7号', null, null);
INSERT INTO `hotel_info` VALUES ('6', '惠城大酒店', '马春梅', '18093729288', '0937-2671616', '肃州区', '酒泉市新城区莫高路16号', null, null);
INSERT INTO `hotel_info` VALUES ('7', '敦煌丝路怡苑大酒店', '张建华', '18193769066', '0937-8859824', '敦煌', '甘肃省酒泉市敦煌市环城东路6号', null, null);
INSERT INTO `hotel_info` VALUES ('8', '敦煌华夏国际大酒店', '侯红林', '13519375666', '0937-8887110', '敦煌', '甘肃省酒泉市敦煌市敦月公路中端888号', null, null);
INSERT INTO `hotel_info` VALUES ('9', '敦煌国际大酒店', '叶彦萍', '13993722999', '0397-8821821', '敦煌', '甘肃省酒泉市敦煌市鸣山北路827号', null, null);
INSERT INTO `hotel_info` VALUES ('10', '敦煌天润大酒店', '权玉霞', '18993732897', '0937-8819501', '敦煌', '甘肃省酒泉市敦煌市鸣山路309号', null, null);
INSERT INTO `hotel_info` VALUES ('11', '敦煌太阳大酒店', '张春艳', '13893726729', '\"0937-8841858', null, null, null, null);

-- ----------------------------
-- Table structure for meals_record
-- ----------------------------
DROP TABLE IF EXISTS `meals_record`;
CREATE TABLE `meals_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `reception_number` varchar(128) DEFAULT NULL COMMENT '接待编号',
  `menu_number` varchar(128) DEFAULT NULL COMMENT '套餐编号',
  `meals_time` varchar(64) DEFAULT NULL COMMENT '用餐时间',
  `hobby` varchar(255) DEFAULT NULL COMMENT '宾客喜好',
  `ramark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='接待用餐记录';

-- ----------------------------
-- Records of meals_record
-- ----------------------------

-- ----------------------------
-- Table structure for meals_record1
-- ----------------------------
DROP TABLE IF EXISTS `meals_record1`;
CREATE TABLE `meals_record1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `reception_number` varchar(128) DEFAULT NULL COMMENT '接待编号',
  `reception_date` varchar(18) DEFAULT NULL COMMENT '接待日期',
  `reception_person` varchar(64) DEFAULT NULL COMMENT '接待人',
  `guest_name` varchar(64) DEFAULT NULL COMMENT '宾客姓名',
  `menu_number` varchar(128) DEFAULT NULL COMMENT '套餐编号',
  `meals_time` varchar(64) DEFAULT NULL COMMENT '用餐时间',
  `hobby` varchar(255) DEFAULT NULL COMMENT '宾客喜好',
  `ramark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='接待用餐记录';

-- ----------------------------
-- Records of meals_record1
-- ----------------------------
INSERT INTO `meals_record1` VALUES ('1', 'J180203001', '2018/2/3', '占三', '徐立毅', 'T00002', '18:00', '', '');

-- ----------------------------
-- Table structure for menu_info
-- ----------------------------
DROP TABLE IF EXISTS `menu_info`;
CREATE TABLE `menu_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_number` varchar(128) DEFAULT NULL COMMENT '套餐编号',
  `short_name` varchar(255) DEFAULT NULL COMMENT '套餐简称',
  `menu_type` varchar(64) DEFAULT NULL COMMENT '套餐类型',
  `hotel` varchar(128) DEFAULT NULL COMMENT '酒店',
  `meals_time` varchar(64) DEFAULT NULL COMMENT '用餐时间（早/午/晚）',
  `meals_type` varchar(64) DEFAULT NULL COMMENT '用餐方式',
  `standard` varchar(255) DEFAULT NULL COMMENT '标准分类',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='套餐信息';

-- ----------------------------
-- Records of menu_info
-- ----------------------------
INSERT INTO `menu_info` VALUES ('1', '套餐编号', '备注', '套餐类型', '酒店名称', '用餐时间分类', '用餐方式分类', '标准分类', null);
INSERT INTO `menu_info` VALUES ('2', 'T00005', 'A单', '一般套餐', '东方国际大酒店', '早餐', '自助餐', '30', null);
INSERT INTO `menu_info` VALUES ('3', 'T00006', 'B单', '一般套餐', '东方国际大酒店', '早餐', '自助餐', '30', null);
INSERT INTO `menu_info` VALUES ('4', 'T00007', 'C单', '一般套餐', '东方国际大酒店', '早餐', '自助餐', '30', null);
INSERT INTO `menu_info` VALUES ('5', 'T00009', 'D单', '一般套餐', '东方国际大酒店', '早餐', '自助餐', '30', null);

-- ----------------------------
-- Table structure for reception_record
-- ----------------------------
DROP TABLE IF EXISTS `reception_record`;
CREATE TABLE `reception_record` (
  `id` int(128) NOT NULL AUTO_INCREMENT,
  `reception_number` varchar(128) DEFAULT NULL COMMENT '接待编号',
  `reception_title` varchar(255) DEFAULT NULL COMMENT '接待标题',
  `reception_date` date DEFAULT NULL COMMENT '接待日期',
  `reception_person` varchar(255) DEFAULT NULL COMMENT '接待人',
  `guest_name` varchar(255) DEFAULT NULL COMMENT '宾客姓名',
  `hotel` varchar(255) DEFAULT NULL COMMENT '住宿酒店',
  `description` varchar(255) DEFAULT NULL COMMENT '接待描述',
  `record_time` datetime DEFAULT NULL COMMENT '录入时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='接待记录';

-- ----------------------------
-- Records of reception_record
-- ----------------------------

-- ----------------------------
-- Table structure for room_info
-- ----------------------------
DROP TABLE IF EXISTS `room_info`;
CREATE TABLE `room_info` (
  `id` int(128) NOT NULL AUTO_INCREMENT,
  `room_number` varchar(128) DEFAULT NULL COMMENT '房间编号',
  `hotel` varchar(128) DEFAULT NULL COMMENT '所属酒店',
  `floor` varchar(10) DEFAULT NULL COMMENT '楼层',
  `room_type` varchar(20) DEFAULT NULL COMMENT '房间类型',
  `special_type` varchar(20) DEFAULT NULL COMMENT '特殊类型',
  `orientation` varchar(20) DEFAULT NULL COMMENT '房间朝向',
  `support_facilities` varchar(255) DEFAULT NULL COMMENT '配套设施',
  `special_serve` varchar(255) DEFAULT NULL COMMENT '特色服务',
  `outside_phone` varchar(15) DEFAULT NULL COMMENT '外线电话',
  `innerline_phone` varchar(15) DEFAULT NULL COMMENT '内线电话',
  `responsible_person` varchar(128) DEFAULT NULL COMMENT '房间负责人',
  `rack_price` decimal(12,0) DEFAULT NULL COMMENT '门市价',
  `agreement_price` decimal(12,0) DEFAULT NULL COMMENT '协议价',
  `contain_food` varchar(10) DEFAULT NULL COMMENT '是否含餐',
  `state` varchar(10) DEFAULT NULL COMMENT '房间状态',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='房间信息';

-- ----------------------------
-- Records of room_info
-- ----------------------------

-- ----------------------------
-- Table structure for room_type
-- ----------------------------
DROP TABLE IF EXISTS `room_type`;
CREATE TABLE `room_type` (
  `id` int(128) NOT NULL AUTO_INCREMENT,
  `type_number` varchar(128) DEFAULT NULL COMMENT '类型编号',
  `hotel_name` varchar(255) DEFAULT NULL COMMENT '酒店名称',
  `floor` varchar(128) DEFAULT NULL COMMENT '楼层',
  `room_type` varchar(128) DEFAULT NULL COMMENT '房间类型',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room_type
-- ----------------------------
