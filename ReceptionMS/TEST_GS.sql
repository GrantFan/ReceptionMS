/*
Navicat Oracle Data Transfer
Oracle Client Version : 11.2.0.1.0

Source Server         : 10.1.2.42_gs
Source Server Version : 110100
Source Host           : 10.1.2.42:1521
Source Schema         : TEST_GS

Target Server Type    : ORACLE
Target Server Version : 110100
File Encoding         : 65001

Date: 2018-05-13 19:01:25
*/


-- ----------------------------
-- Table structure for ACCOMMODATION_RECORD
-- ----------------------------
DROP TABLE "TEST_GS"."ACCOMMODATION_RECORD";
CREATE TABLE "TEST_GS"."ACCOMMODATION_RECORD" (
"ID" VARCHAR2(64 BYTE) NOT NULL ,
"RECEPTION_NUMBER" NVARCHAR2(128) NULL ,
"HOTEL" NVARCHAR2(255) NULL ,
"ROOM_NUMBER" NVARCHAR2(128) NULL ,
"CHECKIN_TIME" VARCHAR2(20 BYTE) NULL ,
"CHECKOUT_TIME" VARCHAR2(20 BYTE) NULL ,
"HOBBY" NVARCHAR2(255) NULL ,
"RECORD_TIME" DATE NULL ,
"REMARK" NVARCHAR2(255) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TEST_GS"."ACCOMMODATION_RECORD" IS '接待住房记录';
COMMENT ON COLUMN "TEST_GS"."ACCOMMODATION_RECORD"."RECEPTION_NUMBER" IS '接待编号';
COMMENT ON COLUMN "TEST_GS"."ACCOMMODATION_RECORD"."HOTEL" IS '住宿酒店';
COMMENT ON COLUMN "TEST_GS"."ACCOMMODATION_RECORD"."ROOM_NUMBER" IS '房间号码';
COMMENT ON COLUMN "TEST_GS"."ACCOMMODATION_RECORD"."CHECKIN_TIME" IS '入住时间';
COMMENT ON COLUMN "TEST_GS"."ACCOMMODATION_RECORD"."CHECKOUT_TIME" IS '退房时间';
COMMENT ON COLUMN "TEST_GS"."ACCOMMODATION_RECORD"."HOBBY" IS '宾客喜好';
COMMENT ON COLUMN "TEST_GS"."ACCOMMODATION_RECORD"."RECORD_TIME" IS '录入时间';
COMMENT ON COLUMN "TEST_GS"."ACCOMMODATION_RECORD"."REMARK" IS '备注';

-- ----------------------------
-- Records of ACCOMMODATION_RECORD
-- ----------------------------
INSERT INTO "TEST_GS"."ACCOMMODATION_RECORD" VALUES ('196b6e785aaa4cdeae9b836dbb9e3fd3', 'JD20180512110504', 'bzd', 'roomNumber', 'checkinTime', 'checkinTime', 'bzd', TO_DATE('2018-05-12 11:31:04', 'YYYY-MM-DD HH24:MI:SS'), 'bzd');
INSERT INTO "TEST_GS"."ACCOMMODATION_RECORD" VALUES ('75e60b04f2844b098d5e4cb661112585', 'JD20180513100501', '东方国际大酒店', '201', '2018-05-16', '2018-05-24', '没有', TO_DATE('2018-05-13 11:06:23', 'YYYY-MM-DD HH24:MI:SS'), 'null');
INSERT INTO "TEST_GS"."ACCOMMODATION_RECORD" VALUES ('5cef71f52176468382172f9a8689ccdb', 'JD20180513100501', '光明大酒店', '201', '2018-05-09', '2018-05-22', '没有', TO_DATE('2018-05-13 11:06:35', 'YYYY-MM-DD HH24:MI:SS'), 'null');

-- ----------------------------
-- Table structure for CONFERENCE_INFO
-- ----------------------------
DROP TABLE "TEST_GS"."CONFERENCE_INFO";
CREATE TABLE "TEST_GS"."CONFERENCE_INFO" (
"ID" NUMBER(11) NOT NULL ,
"CONFERENCE_NAME" NVARCHAR2(255) NULL ,
"HOTEL" NVARCHAR2(255) NULL ,
"TYPE" NVARCHAR2(128) NULL ,
"POSITION" NVARCHAR2(128) NULL ,
"FLOOR" NVARCHAR2(255) NULL ,
"CAPACITY_NUM" NVARCHAR2(128) NULL ,
"REMARK" NVARCHAR2(255) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TEST_GS"."CONFERENCE_INFO" IS '会议室信息';
COMMENT ON COLUMN "TEST_GS"."CONFERENCE_INFO"."CONFERENCE_NAME" IS '会议室名称';
COMMENT ON COLUMN "TEST_GS"."CONFERENCE_INFO"."HOTEL" IS '所属酒店';
COMMENT ON COLUMN "TEST_GS"."CONFERENCE_INFO"."TYPE" IS '会议室类型';
COMMENT ON COLUMN "TEST_GS"."CONFERENCE_INFO"."POSITION" IS '位置';
COMMENT ON COLUMN "TEST_GS"."CONFERENCE_INFO"."FLOOR" IS '楼层';
COMMENT ON COLUMN "TEST_GS"."CONFERENCE_INFO"."CAPACITY_NUM" IS '容纳人数';
COMMENT ON COLUMN "TEST_GS"."CONFERENCE_INFO"."REMARK" IS '备注';

-- ----------------------------
-- Records of CONFERENCE_INFO
-- ----------------------------
INSERT INTO "TEST_GS"."CONFERENCE_INFO" VALUES ('2', '1111', '敦煌国际大酒店', '会议室', null, null, '1', null);
INSERT INTO "TEST_GS"."CONFERENCE_INFO" VALUES ('3', '2222', '敦煌国际大酒店', '讲座室', null, null, '2', null);
INSERT INTO "TEST_GS"."CONFERENCE_INFO" VALUES ('4', '东二楼多功能厅', '敦煌丝路怡苑大酒店', '会议室', null, null, '200-350', null);
INSERT INTO "TEST_GS"."CONFERENCE_INFO" VALUES ('5', '侯见厅', '东方国际大酒店', '会议室', '一号楼', null, '30', null);
INSERT INTO "TEST_GS"."CONFERENCE_INFO" VALUES ('6', '多功能厅', '敦煌宾馆', '会议室', '南楼', null, '200', null);
INSERT INTO "TEST_GS"."CONFERENCE_INFO" VALUES ('7', '孟兰厅', '东方国际大酒店', '会议室', '二号楼', null, '500-700', null);
INSERT INTO "TEST_GS"."CONFERENCE_INFO" VALUES ('8', '悬泉厅', '敦煌宾馆', '会议室', '南楼', null, '20-30', null);
INSERT INTO "TEST_GS"."CONFERENCE_INFO" VALUES ('9', '牡丹厅', '东方国际大酒店', '会议室', '一号楼', null, '200-400', null);
INSERT INTO "TEST_GS"."CONFERENCE_INFO" VALUES ('10', '西二楼多功能厅', '敦煌丝路怡苑大酒店', '会议室', null, null, '400-800', null);
INSERT INTO "TEST_GS"."CONFERENCE_INFO" VALUES ('11', '贵宾厅', '敦煌丝路怡苑大酒店', '会议室', null, null, '30-40', null);
INSERT INTO "TEST_GS"."CONFERENCE_INFO" VALUES ('12', '飞天厅', '敦煌宾馆', '会议室', '南楼', null, '80', null);

-- ----------------------------
-- Table structure for CONFERENCE_RECORD
-- ----------------------------
DROP TABLE "TEST_GS"."CONFERENCE_RECORD";
CREATE TABLE "TEST_GS"."CONFERENCE_RECORD" (
"ID" NUMBER(11) NOT NULL ,
"USE_NUMBER" NVARCHAR2(128) NULL ,
"CONFERENCE_NAME" NVARCHAR2(255) NULL ,
"HOTEL" NVARCHAR2(255) NULL ,
"USE_DATE" DATE NULL ,
"START_TIME" NVARCHAR2(255) NULL ,
"END_TIME" NVARCHAR2(255) NULL ,
"PURPOSE" NVARCHAR2(255) NULL ,
"GUEST_NUM" NUMBER(11) NULL ,
"REMARK" NVARCHAR2(255) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TEST_GS"."CONFERENCE_RECORD" IS '会议室使用记录';
COMMENT ON COLUMN "TEST_GS"."CONFERENCE_RECORD"."USE_NUMBER" IS '会议室使用编号';
COMMENT ON COLUMN "TEST_GS"."CONFERENCE_RECORD"."CONFERENCE_NAME" IS '会议室名称';
COMMENT ON COLUMN "TEST_GS"."CONFERENCE_RECORD"."HOTEL" IS '酒店名称';
COMMENT ON COLUMN "TEST_GS"."CONFERENCE_RECORD"."USE_DATE" IS '使用日期';
COMMENT ON COLUMN "TEST_GS"."CONFERENCE_RECORD"."START_TIME" IS '开始时间';
COMMENT ON COLUMN "TEST_GS"."CONFERENCE_RECORD"."END_TIME" IS '结束时间';
COMMENT ON COLUMN "TEST_GS"."CONFERENCE_RECORD"."PURPOSE" IS '用途说明';
COMMENT ON COLUMN "TEST_GS"."CONFERENCE_RECORD"."GUEST_NUM" IS '来宾人数';
COMMENT ON COLUMN "TEST_GS"."CONFERENCE_RECORD"."REMARK" IS '备注';

-- ----------------------------
-- Records of CONFERENCE_RECORD
-- ----------------------------
INSERT INTO "TEST_GS"."CONFERENCE_RECORD" VALUES ('1', 'H20180207001', '东二楼多功能厅', '敦煌丝路怡苑大酒店', TO_DATE('2018-02-07 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '08:00', '09:00', null, '10', null);
INSERT INTO "TEST_GS"."CONFERENCE_RECORD" VALUES ('2', 'H20180207002', '东二楼多功能厅', '敦煌丝路怡苑大酒店', TO_DATE('2018-02-07 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '13:00:00', '15:00:00', null, '20', null);
INSERT INTO "TEST_GS"."CONFERENCE_RECORD" VALUES ('3', 'H20180207003', '侯见厅', '东方国际大酒店', TO_DATE('2018-02-08 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '9:00:00', '12:00:00', null, '10', null);
INSERT INTO "TEST_GS"."CONFERENCE_RECORD" VALUES ('4', 'H20180207004', '多功能厅', '敦煌宾馆', TO_DATE('2018-02-08 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '13:00:00', '17:00:00', null, '50', null);
INSERT INTO "TEST_GS"."CONFERENCE_RECORD" VALUES ('5', 'H20180208001', '孟兰厅', '酒店名称
东方国际大酒店', TO_DATE('2018-02-08 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '15:00:00', '16:00:00', null, '2', null);

-- ----------------------------
-- Table structure for DM_AREA
-- ----------------------------
DROP TABLE "TEST_GS"."DM_AREA";
CREATE TABLE "TEST_GS"."DM_AREA" (
"NAME" NVARCHAR2(255) NULL ,
"VALUE" NVARCHAR2(255) NULL ,
"DECRIPTION" NVARCHAR2(255) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "TEST_GS"."DM_AREA"."NAME" IS '地区名称';
COMMENT ON COLUMN "TEST_GS"."DM_AREA"."VALUE" IS '值';
COMMENT ON COLUMN "TEST_GS"."DM_AREA"."DECRIPTION" IS '描述';

-- ----------------------------
-- Records of DM_AREA
-- ----------------------------
INSERT INTO "TEST_GS"."DM_AREA" VALUES ('华东', '1', '上海、江苏、浙江、安徽、江西');
INSERT INTO "TEST_GS"."DM_AREA" VALUES ('华南', '2', '广东、福建、广西、海南');
INSERT INTO "TEST_GS"."DM_AREA" VALUES ('华北', '3', '北京、天津、河北、山东、河南、山西、内蒙古');
INSERT INTO "TEST_GS"."DM_AREA" VALUES ('华中', '4', '湖北、湖南');
INSERT INTO "TEST_GS"."DM_AREA" VALUES ('西南', '5', '四川、重庆、贵州、云南、西藏');
INSERT INTO "TEST_GS"."DM_AREA" VALUES ('西北', '7', '陕西、甘肃、宁夏、青海、新疆');

-- ----------------------------
-- Table structure for DM_CONFERENCE_TYPE
-- ----------------------------
DROP TABLE "TEST_GS"."DM_CONFERENCE_TYPE";
CREATE TABLE "TEST_GS"."DM_CONFERENCE_TYPE" (
"NAME" NVARCHAR2(255) NULL ,
"VALUE" NVARCHAR2(255) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TEST_GS"."DM_CONFERENCE_TYPE" IS '会议室类型';
COMMENT ON COLUMN "TEST_GS"."DM_CONFERENCE_TYPE"."NAME" IS '会议室类型';
COMMENT ON COLUMN "TEST_GS"."DM_CONFERENCE_TYPE"."VALUE" IS '值';

-- ----------------------------
-- Records of DM_CONFERENCE_TYPE
-- ----------------------------
INSERT INTO "TEST_GS"."DM_CONFERENCE_TYPE" VALUES ('会议室', '1');
INSERT INTO "TEST_GS"."DM_CONFERENCE_TYPE" VALUES ('讲座室', '2');
INSERT INTO "TEST_GS"."DM_CONFERENCE_TYPE" VALUES ('演播室', '3');

-- ----------------------------
-- Table structure for DM_DISTRICT
-- ----------------------------
DROP TABLE "TEST_GS"."DM_DISTRICT";
CREATE TABLE "TEST_GS"."DM_DISTRICT" (
"NAME" NVARCHAR2(255) NULL ,
"VALUE" NVARCHAR2(255) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TEST_GS"."DM_DISTRICT" IS '行政区';
COMMENT ON COLUMN "TEST_GS"."DM_DISTRICT"."NAME" IS '行政区名称';
COMMENT ON COLUMN "TEST_GS"."DM_DISTRICT"."VALUE" IS '值';

-- ----------------------------
-- Records of DM_DISTRICT
-- ----------------------------
INSERT INTO "TEST_GS"."DM_DISTRICT" VALUES ('敦煌', '1');
INSERT INTO "TEST_GS"."DM_DISTRICT" VALUES ('肃州区', '2');
INSERT INTO "TEST_GS"."DM_DISTRICT" VALUES ('金塔县', '3');
INSERT INTO "TEST_GS"."DM_DISTRICT" VALUES ('玉门市', '4');

-- ----------------------------
-- Table structure for DM_EDUCATION
-- ----------------------------
DROP TABLE "TEST_GS"."DM_EDUCATION";
CREATE TABLE "TEST_GS"."DM_EDUCATION" (
"NAME" NVARCHAR2(128) NULL ,
"VALUE" NVARCHAR2(64) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TEST_GS"."DM_EDUCATION" IS '学历表';
COMMENT ON COLUMN "TEST_GS"."DM_EDUCATION"."NAME" IS '名称';
COMMENT ON COLUMN "TEST_GS"."DM_EDUCATION"."VALUE" IS '值';

-- ----------------------------
-- Records of DM_EDUCATION
-- ----------------------------
INSERT INTO "TEST_GS"."DM_EDUCATION" VALUES ('高中及以下', '1');
INSERT INTO "TEST_GS"."DM_EDUCATION" VALUES ('大专', '2');
INSERT INTO "TEST_GS"."DM_EDUCATION" VALUES ('本科', '3');
INSERT INTO "TEST_GS"."DM_EDUCATION" VALUES ('硕士', '4');
INSERT INTO "TEST_GS"."DM_EDUCATION" VALUES ('博士', '5');

-- ----------------------------
-- Table structure for DM_MEALS_STANDARD
-- ----------------------------
DROP TABLE "TEST_GS"."DM_MEALS_STANDARD";
CREATE TABLE "TEST_GS"."DM_MEALS_STANDARD" (
"NAME" NVARCHAR2(255) NULL ,
"VALUE" NVARCHAR2(255) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TEST_GS"."DM_MEALS_STANDARD" IS '套餐标准';
COMMENT ON COLUMN "TEST_GS"."DM_MEALS_STANDARD"."NAME" IS '套餐标准';
COMMENT ON COLUMN "TEST_GS"."DM_MEALS_STANDARD"."VALUE" IS '值';

-- ----------------------------
-- Records of DM_MEALS_STANDARD
-- ----------------------------
INSERT INTO "TEST_GS"."DM_MEALS_STANDARD" VALUES ('30', '1');
INSERT INTO "TEST_GS"."DM_MEALS_STANDARD" VALUES ('50', '2');
INSERT INTO "TEST_GS"."DM_MEALS_STANDARD" VALUES ('120', '3');

-- ----------------------------
-- Table structure for DM_MEALS_TIME
-- ----------------------------
DROP TABLE "TEST_GS"."DM_MEALS_TIME";
CREATE TABLE "TEST_GS"."DM_MEALS_TIME" (
"NAME" NVARCHAR2(255) NULL ,
"VALUE" NVARCHAR2(255) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TEST_GS"."DM_MEALS_TIME" IS '用餐时间类别';
COMMENT ON COLUMN "TEST_GS"."DM_MEALS_TIME"."NAME" IS '用餐时间类别';
COMMENT ON COLUMN "TEST_GS"."DM_MEALS_TIME"."VALUE" IS '值';

-- ----------------------------
-- Records of DM_MEALS_TIME
-- ----------------------------
INSERT INTO "TEST_GS"."DM_MEALS_TIME" VALUES ('早餐', '1');
INSERT INTO "TEST_GS"."DM_MEALS_TIME" VALUES ('正餐', '2');
INSERT INTO "TEST_GS"."DM_MEALS_TIME" VALUES ('晚餐', '3');

-- ----------------------------
-- Table structure for DM_MEALS_TYPE
-- ----------------------------
DROP TABLE "TEST_GS"."DM_MEALS_TYPE";
CREATE TABLE "TEST_GS"."DM_MEALS_TYPE" (
"NAME" NVARCHAR2(255) NULL ,
"VALUE" NVARCHAR2(255) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "TEST_GS"."DM_MEALS_TYPE"."NAME" IS '用餐方式类别';
COMMENT ON COLUMN "TEST_GS"."DM_MEALS_TYPE"."VALUE" IS '值';

-- ----------------------------
-- Records of DM_MEALS_TYPE
-- ----------------------------
INSERT INTO "TEST_GS"."DM_MEALS_TYPE" VALUES ('餐桌', '1');
INSERT INTO "TEST_GS"."DM_MEALS_TYPE" VALUES ('自助餐', '2');
INSERT INTO "TEST_GS"."DM_MEALS_TYPE" VALUES ('工作餐', '3');

-- ----------------------------
-- Table structure for DM_MENU_TYPE
-- ----------------------------
DROP TABLE "TEST_GS"."DM_MENU_TYPE";
CREATE TABLE "TEST_GS"."DM_MENU_TYPE" (
"NAME" NVARCHAR2(255) NULL ,
"VALUE" NVARCHAR2(255) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TEST_GS"."DM_MENU_TYPE" IS '套餐类型';
COMMENT ON COLUMN "TEST_GS"."DM_MENU_TYPE"."NAME" IS '套餐类型名';
COMMENT ON COLUMN "TEST_GS"."DM_MENU_TYPE"."VALUE" IS '值';

-- ----------------------------
-- Records of DM_MENU_TYPE
-- ----------------------------
INSERT INTO "TEST_GS"."DM_MENU_TYPE" VALUES ('一般套餐', '1');
INSERT INTO "TEST_GS"."DM_MENU_TYPE" VALUES ('贵宾套餐', '2');

-- ----------------------------
-- Table structure for DM_NATION
-- ----------------------------
DROP TABLE "TEST_GS"."DM_NATION";
CREATE TABLE "TEST_GS"."DM_NATION" (
"NAME" NVARCHAR2(255) NULL ,
"VALUE" NVARCHAR2(255) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TEST_GS"."DM_NATION" IS '民族';
COMMENT ON COLUMN "TEST_GS"."DM_NATION"."NAME" IS '民族名称';
COMMENT ON COLUMN "TEST_GS"."DM_NATION"."VALUE" IS '值';

-- ----------------------------
-- Records of DM_NATION
-- ----------------------------
INSERT INTO "TEST_GS"."DM_NATION" VALUES ('汉族', '1');
INSERT INTO "TEST_GS"."DM_NATION" VALUES ('回族', '2');
INSERT INTO "TEST_GS"."DM_NATION" VALUES ('蒙古族', '3');
INSERT INTO "TEST_GS"."DM_NATION" VALUES ('藏族', '4');

-- ----------------------------
-- Table structure for DM_ROOM_SPECIAL_TYPE
-- ----------------------------
DROP TABLE "TEST_GS"."DM_ROOM_SPECIAL_TYPE";
CREATE TABLE "TEST_GS"."DM_ROOM_SPECIAL_TYPE" (
"NAME" NVARCHAR2(255) NULL ,
"VALUE" NVARCHAR2(255) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TEST_GS"."DM_ROOM_SPECIAL_TYPE" IS '房间特殊类型';
COMMENT ON COLUMN "TEST_GS"."DM_ROOM_SPECIAL_TYPE"."NAME" IS '房间特殊类型';
COMMENT ON COLUMN "TEST_GS"."DM_ROOM_SPECIAL_TYPE"."VALUE" IS '值';

-- ----------------------------
-- Records of DM_ROOM_SPECIAL_TYPE
-- ----------------------------
INSERT INTO "TEST_GS"."DM_ROOM_SPECIAL_TYPE" VALUES ('有柱子', '1');
INSERT INTO "TEST_GS"."DM_ROOM_SPECIAL_TYPE" VALUES ('噪音大', '2');

-- ----------------------------
-- Table structure for DM_ROOM_TYPE
-- ----------------------------
DROP TABLE "TEST_GS"."DM_ROOM_TYPE";
CREATE TABLE "TEST_GS"."DM_ROOM_TYPE" (
"NAME" NVARCHAR2(255) NULL ,
"VALUE" NVARCHAR2(255) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TEST_GS"."DM_ROOM_TYPE" IS '房间类型表';
COMMENT ON COLUMN "TEST_GS"."DM_ROOM_TYPE"."NAME" IS '房间类型';
COMMENT ON COLUMN "TEST_GS"."DM_ROOM_TYPE"."VALUE" IS '值';

-- ----------------------------
-- Records of DM_ROOM_TYPE
-- ----------------------------
INSERT INTO "TEST_GS"."DM_ROOM_TYPE" VALUES ('普通标间', '1');
INSERT INTO "TEST_GS"."DM_ROOM_TYPE" VALUES ('商务标间', '2');
INSERT INTO "TEST_GS"."DM_ROOM_TYPE" VALUES ('商务单间', '3');
INSERT INTO "TEST_GS"."DM_ROOM_TYPE" VALUES ('豪华套间', '4');

-- ----------------------------
-- Table structure for DM_SEX
-- ----------------------------
DROP TABLE "TEST_GS"."DM_SEX";
CREATE TABLE "TEST_GS"."DM_SEX" (
"NAME" NVARCHAR2(8) NULL ,
"VALUE" NUMBER(11) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of DM_SEX
-- ----------------------------
INSERT INTO "TEST_GS"."DM_SEX" VALUES ('男', '1');
INSERT INTO "TEST_GS"."DM_SEX" VALUES ('女', '2');
INSERT INTO "TEST_GS"."DM_SEX" VALUES ('其他', '0');

-- ----------------------------
-- Table structure for FOOD_INFO
-- ----------------------------
DROP TABLE "TEST_GS"."FOOD_INFO";
CREATE TABLE "TEST_GS"."FOOD_INFO" (
"ID" NUMBER(11) NOT NULL ,
"FOOD_NUMBER" NVARCHAR2(20) NULL ,
"FOOD_NAME" NVARCHAR2(255) NULL ,
"MENU_NUMBER" NVARCHAR2(128) NULL ,
"PRICE" NUMBER(6) NULL ,
"FLAVOR" NVARCHAR2(255) NULL ,
"TYPE" NVARCHAR2(255) NULL ,
"REMARK" NVARCHAR2(255) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TEST_GS"."FOOD_INFO" IS '菜品信息';
COMMENT ON COLUMN "TEST_GS"."FOOD_INFO"."FOOD_NUMBER" IS '菜品编号';
COMMENT ON COLUMN "TEST_GS"."FOOD_INFO"."FOOD_NAME" IS '菜品名称';
COMMENT ON COLUMN "TEST_GS"."FOOD_INFO"."MENU_NUMBER" IS '套餐编号';
COMMENT ON COLUMN "TEST_GS"."FOOD_INFO"."PRICE" IS '菜品单价';
COMMENT ON COLUMN "TEST_GS"."FOOD_INFO"."FLAVOR" IS '菜品口味';
COMMENT ON COLUMN "TEST_GS"."FOOD_INFO"."TYPE" IS '菜品类型（热菜/凉菜/主食/土产/饮品）';
COMMENT ON COLUMN "TEST_GS"."FOOD_INFO"."REMARK" IS '备注';

-- ----------------------------
-- Records of FOOD_INFO
-- ----------------------------
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('1', '菜品编号', '菜品名称', null, null, null, '类型', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('18', 'T00006', '干煸四季豆', null, null, null, '主食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('19', 'T00006', '小葱木耳', null, null, null, '热菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('20', 'T00006', '烤番茄', null, null, null, '热菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('21', 'T00006', '青笋肉片', null, null, null, '热菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('22', 'T00006', '清炒菊花菜', null, null, null, '热菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('23', 'T00006', '烤肉肠', null, null, null, '热菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('24', 'T00006', '土豆片炒肉', null, null, null, '热菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('25', 'T00006', '手撕甘蓝', null, null, null, '热菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('26', 'T00006', '酱牛肉', null, null, null, '热菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('27', 'T00006', '千叶芹菜', null, null, null, '凉菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('28', 'T00006', '三色萝卜苗', null, null, null, '凉菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('29', 'T00006', '凉拌黄瓜', null, null, null, '凉菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('30', 'T00006', '口味海带结', null, null, null, '凉菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('31', 'T00006', '黄豆菜心', null, null, null, '凉菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('32', 'T00006', '手撕甘蓝', null, null, null, '凉菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('33', 'T00006', '大米粥', null, null, null, '凉菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('34', 'T00006', '玉米珍子粥', null, null, null, '粥类', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('35', 'T00006', '红枣糯米粥', null, null, null, '粥类', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('36', 'T00006', '现场煎鸡蛋', null, null, null, '粥类', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('37', 'T00006', '葫芦素包子', null, null, null, '主食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('38', 'T00006', '小花卷', null, null, null, '主食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('39', 'T00006', '油条', null, null, null, '主食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('40', 'T00006', '牛奶', null, null, null, '主食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('41', 'T00006', '牛肉面', null, null, null, '主食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('42', 'T00006', '酸奶', null, null, null, '主食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('43', 'T00006', '煮鸡蛋', null, null, null, '主食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('44', 'T00006', '糊 锅', null, null, null, '主食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('45', 'T00006', '蛋炒饭', null, null, null, '主食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('46', 'T00006', '炒米线', null, null, null, '主食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('47', 'T00006', '甜 点', null, null, null, '主食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('48', 'T00006', '面 包', null, null, null, '主食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('49', 'T00006', '蒸红萝卜', null, null, null, '主食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('50', 'T00006', '土豆', null, null, null, '土产', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('51', 'T00006', '卤水核桃', null, null, null, '土产', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('52', 'T00006', '红薯', null, null, null, '土产', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('53', 'T00006', '咖啡', null, null, null, '土产', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('54', 'T00006', '橙汁', null, null, null, '饮 品', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('55', 'T00006', '茶水 柠檬水', null, null, null, '饮 品', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('56', 'T00007', '爽口海蜇丝', null, null, null, '饮 品', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('57', 'T00007', '芝麻菠菜 ', null, null, null, '凉 菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('58', 'T00007', '炝拌西兰花', null, null, null, '凉 菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('59', 'T00007', '炝拌萝卜皮 ', null, null, null, '凉 菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('60', 'T00007', '雪菜土豆片', null, null, null, '凉 菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('61', 'T00007', '香拌莲藕', null, null, null, '凉 菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('62', 'T00007', '冬菜炒肉丝', null, null, null, '凉 菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('63', 'T00007', '酱爆真菌', null, null, null, '热 菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('64', 'T00007', '烤番茄', null, null, null, '热 菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('65', 'T00007', '豆豉青椒圈', null, null, null, '热 菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('66', 'T00007', '香炝广菜心', null, null, null, '热 菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('67', 'T00007', '烤肉肠', null, null, null, '热 菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('68', 'T00007', '上海青炒肉', null, null, null, '热 菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('69', 'T00007', '醋溜西葫芦', null, null, null, '热 菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('70', 'T00007', '南瓜小米粥', null, null, null, '热 菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('71', 'T00007', '黑米粥', null, null, null, '粥 类', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('72', 'T00007', '现场煎鸡蛋', null, null, null, '粥 类', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('73', 'T00007', '甘蓝素包子', null, null, null, '主 食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('74', 'T00007', '花 卷', null, null, null, '主 食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('75', 'T00007', '油 条', null, null, null, '主 食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('76', 'T00007', '牛肉面', null, null, null, '主 食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('77', 'T00007', '酸 奶', null, null, null, '主 食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('78', 'T00007', '煮鸡蛋', null, null, null, '主 食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('79', 'T00007', '糊 锅', null, null, null, '主 食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('80', 'T00007', '蛋炒饭', null, null, null, '主 食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('81', 'T00007', '炒米线', null, null, null, '主 食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('82', 'T00007', '牛 奶', null, null, null, '主 食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('83', 'T00007', '甜 点', null, null, null, '主 食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('84', 'T00007', '面 包', null, null, null, '主 食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('85', 'T00007', '蒸红萝卜', null, null, null, '主 食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('86', 'T00007', '紫薯', null, null, null, '土 产', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('87', 'T00007', '铁杆山药', null, null, null, '土 产', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('88', 'T00007', '卤水花生', null, null, null, '土 产', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('89', 'T00007', '咖啡', null, null, null, '土 产', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('90', 'T00007', '橙汁', null, null, null, '饮 品', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('91', 'T00007', '茶水柠檬水', null, null, null, '饮 品', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('92', 'T00007', '大米粥', null, null, null, '饮 品', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('93', 'T00009', '白切鸡', null, null, null, '粥 类', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('94', 'T00009', '酸辣海带', null, null, null, '凉 菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('95', 'T00009', '凉拌三丝', null, null, null, '凉 菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('96', 'T00009', '爽口藕带', null, null, null, '凉 菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('97', 'T00009', '菠菜面筋', null, null, null, '凉 菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('98', 'T00009', '大拌菜', null, null, null, '凉 菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('99', 'T00009', '蔬菜沙拉（生菜、苦菊、黄瓜、胡萝卜）', null, null, null, '凉 菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('100', 'T00009', '尖椒牛肉丝', null, null, null, '凉 菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('101', 'T00009', '香辣蹄花', null, null, null, '热 菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('102', 'T00009', '蒜蓉油麦菜', null, null, null, '热 菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('103', 'T00009', '清炒芥兰圈', null, null, null, '热 菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('104', 'T00009', '牛肉面', null, null, null, '热 菜', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('105', 'T00009', '蛋炒米线', null, null, null, '主 食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('106', 'T00009', '糊锅', null, null, null, '主 食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('107', 'T00009', '油条', null, null, null, '主 食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('108', 'T00009', '地达菜包子', null, null, null, '主 食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('109', 'T00009', '牛奶 ', null, null, null, '主 食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('110', 'T00009', '面包', null, null, null, '主 食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('111', 'T00009', '烤番茄 ', null, null, null, '主 食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('112', 'T00009', '小蛋糕', null, null, null, '主 食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('113', 'T00009', '哈雷杯', null, null, null, '主 食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('114', 'T00009', '咖啡', null, null, null, '主 食', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('115', 'T00009', '橙汁', null, null, null, '饮 品', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('116', 'T00009', '茶水柠檬水', null, null, null, '饮 品', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('118', 'T6', 'asdfsa', null, '20', null, 'asdf', null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('117', 'T00005', 'sacads', null, '20', null, null, null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('119', 'T6', 'asdf', null, '20', null, 'gffergws', null);

-- ----------------------------
-- Table structure for GUEST_INFO
-- ----------------------------
DROP TABLE "TEST_GS"."GUEST_INFO";
CREATE TABLE "TEST_GS"."GUEST_INFO" (
"ID" NUMBER(11) NOT NULL ,
"GUEST_NAME" NVARCHAR2(255) NULL ,
"MAIN_POSITION" NVARCHAR2(255) NULL ,
"DEPUTY_POSITION" NVARCHAR2(255) NULL ,
"OFFICE_AREA" NVARCHAR2(255) NULL ,
"SEX" VARCHAR2(11 BYTE) NULL ,
"AGE" VARCHAR2(11 BYTE) NULL ,
"URL" VARCHAR2(128 CHAR) NULL ,
"BIRTH_DATE" VARCHAR2(20 BYTE) NULL ,
"NATION" VARCHAR2(11 BYTE) NULL ,
"EDUCATION" VARCHAR2(11 BYTE) NULL ,
"ORIGIN_PLACE" NVARCHAR2(255) NULL ,
"TELPHONE" NVARCHAR2(11) NULL ,
"PHONE" NVARCHAR2(11) NULL ,
"EMAIL" NVARCHAR2(30) NULL ,
"ADDRESS" NVARCHAR2(255) NULL ,
"GUEST_TYPE" NVARCHAR2(255) NULL ,
"REMARK" NVARCHAR2(255) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TEST_GS"."GUEST_INFO" IS '宾客信息';
COMMENT ON COLUMN "TEST_GS"."GUEST_INFO"."GUEST_NAME" IS '宾客姓名';
COMMENT ON COLUMN "TEST_GS"."GUEST_INFO"."MAIN_POSITION" IS '主职务';
COMMENT ON COLUMN "TEST_GS"."GUEST_INFO"."DEPUTY_POSITION" IS '副职务';
COMMENT ON COLUMN "TEST_GS"."GUEST_INFO"."OFFICE_AREA" IS '任职地区';
COMMENT ON COLUMN "TEST_GS"."GUEST_INFO"."SEX" IS '性别';
COMMENT ON COLUMN "TEST_GS"."GUEST_INFO"."AGE" IS '年龄';
COMMENT ON COLUMN "TEST_GS"."GUEST_INFO"."BIRTH_DATE" IS '出生日期';
COMMENT ON COLUMN "TEST_GS"."GUEST_INFO"."NATION" IS '民族';
COMMENT ON COLUMN "TEST_GS"."GUEST_INFO"."EDUCATION" IS '学历';
COMMENT ON COLUMN "TEST_GS"."GUEST_INFO"."ORIGIN_PLACE" IS '籍贯';
COMMENT ON COLUMN "TEST_GS"."GUEST_INFO"."TELPHONE" IS '联系电话';
COMMENT ON COLUMN "TEST_GS"."GUEST_INFO"."PHONE" IS '家庭/办公电话';
COMMENT ON COLUMN "TEST_GS"."GUEST_INFO"."EMAIL" IS '邮件地址';
COMMENT ON COLUMN "TEST_GS"."GUEST_INFO"."ADDRESS" IS '家庭地址';
COMMENT ON COLUMN "TEST_GS"."GUEST_INFO"."GUEST_TYPE" IS '宾客类型';
COMMENT ON COLUMN "TEST_GS"."GUEST_INFO"."REMARK" IS '备注';

-- ----------------------------
-- Records of GUEST_INFO
-- ----------------------------
INSERT INTO "TEST_GS"."GUEST_INFO" VALUES ('1', 'adsf', 'asdf', 'sadf', null, '男', null, 'http://localhost:8088/ReceptionMS/views/upload/imgs/photo/1526206262827_285.png', '2018-05-16', null, null, null, null, null, null, null, '小客户', null);
INSERT INTO "TEST_GS"."GUEST_INFO" VALUES ('2', '张三', '局长', '家长', '无', '女', null, null, '2018-05-10', '本科', null, '内蒙古', '1634473945', '15344475945', '1364', '1', '小客户', 'hjkh');
INSERT INTO "TEST_GS"."GUEST_INFO" VALUES ('3', '张三', '局长', '家长', '无', '其他', null, null, '2018-05-10', '硕士', null, '内蒙古', '1634473945', '15344475945', '1364', '1', '小客户', 'hjkh');
INSERT INTO "TEST_GS"."GUEST_INFO" VALUES ('4', '阿斯顿发', null, null, null, '男', null, null, '2018-05-10', '本科', null, null, null, null, null, null, '小客户', '很快就好');
INSERT INTO "TEST_GS"."GUEST_INFO" VALUES ('5', '阿斯顿发', null, null, null, '男', null, null, '2018-05-10', null, null, null, null, null, null, null, '小客户', '很快就好');
INSERT INTO "TEST_GS"."GUEST_INFO" VALUES ('6', '张三', '局长', '家长', '无', '女', null, null, '2018-05-10', null, null, '内蒙古', '1634473945', '15344475945', '1364', '1', '小客户', 'hjkh');
INSERT INTO "TEST_GS"."GUEST_INFO" VALUES ('7', '阿斯顿发', null, null, null, '男', null, null, '2018-05-10', null, null, null, null, null, null, null, '小客户', '很快就好');
INSERT INTO "TEST_GS"."GUEST_INFO" VALUES ('8', 'sdaf', 'adf', 'asdf', 'sadf', '女', null, null, '2018-05-08', '本科', null, 'sadf', 'sadf', 'sdaf', 'sadf', 'sadf', '普通客户', null);

-- ----------------------------
-- Table structure for HOTEL_INFO
-- ----------------------------
DROP TABLE "TEST_GS"."HOTEL_INFO";
CREATE TABLE "TEST_GS"."HOTEL_INFO" (
"ID" NUMBER(11) NOT NULL ,
"HOTEL_NAME" NVARCHAR2(64) NULL ,
"LINKMAN" NVARCHAR2(64) NULL ,
"TELPHONE" NVARCHAR2(64) NULL ,
"PHONE" NVARCHAR2(64) NULL ,
"AREA" NVARCHAR2(255) NULL ,
"ADDRESS" NVARCHAR2(255) NULL ,
"PLANE_GRAPH" NVARCHAR2(255) NULL ,
"REMARK" VARCHAR2(255 CHAR) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TEST_GS"."HOTEL_INFO" IS '酒店信息';
COMMENT ON COLUMN "TEST_GS"."HOTEL_INFO"."HOTEL_NAME" IS '酒店名称';
COMMENT ON COLUMN "TEST_GS"."HOTEL_INFO"."LINKMAN" IS '酒店联系人';
COMMENT ON COLUMN "TEST_GS"."HOTEL_INFO"."TELPHONE" IS '联系电话';
COMMENT ON COLUMN "TEST_GS"."HOTEL_INFO"."PHONE" IS '座机';
COMMENT ON COLUMN "TEST_GS"."HOTEL_INFO"."AREA" IS '所属行政区';
COMMENT ON COLUMN "TEST_GS"."HOTEL_INFO"."ADDRESS" IS '酒店地址';
COMMENT ON COLUMN "TEST_GS"."HOTEL_INFO"."PLANE_GRAPH" IS '酒店平面图';

-- ----------------------------
-- Records of HOTEL_INFO
-- ----------------------------
INSERT INTO "TEST_GS"."HOTEL_INFO" VALUES ('13', null, null, null, null, null, null, null, null);
INSERT INTO "TEST_GS"."HOTEL_INFO" VALUES ('1', '酒店名称', '联系人', '联系电话', '酒店座机', '所属行政区', '酒店地址', null, null);
INSERT INTO "TEST_GS"."HOTEL_INFO" VALUES ('3', '东方国际大酒店', '马艳玲', '18193748166', '0937-2699999', '敦煌', '酒泉市肃州区仓门街6号', null, '11111');
INSERT INTO "TEST_GS"."HOTEL_INFO" VALUES ('4', '光明大酒店', '王海锋', '18919375595', '0937-2807777', '肃州区', '甘肃省酒泉市肃州区盘旋中路18号', null, null);
INSERT INTO "TEST_GS"."HOTEL_INFO" VALUES ('5', '宏兴大酒店', '陈浩', '18919427777', '0937-2802222', '肃州区', '甘肃省酒泉市肃州区盘旋西路7号', null, null);
INSERT INTO "TEST_GS"."HOTEL_INFO" VALUES ('6', '惠城大酒店', '马春梅', '18093729288', '0937-2671616', '玉门市', '酒泉市新城区莫高路16号', null, null);
INSERT INTO "TEST_GS"."HOTEL_INFO" VALUES ('7', '敦煌丝路怡苑大酒店', '张建华', '18193769066', '0937-8859824', '敦煌', '甘肃省酒泉市敦煌市环城东路6号', null, null);
INSERT INTO "TEST_GS"."HOTEL_INFO" VALUES ('8', '敦煌华夏国际大酒店', '侯红林', '13519375666', '0937-8887110', '敦煌', '甘肃省酒泉市敦煌市敦月公路中端888号', null, null);
INSERT INTO "TEST_GS"."HOTEL_INFO" VALUES ('9', '敦煌国际大酒店', '叶彦萍', '13993722999', '0397-8821821', '敦煌', '甘肃省酒泉市敦煌市鸣山北路827号', null, null);
INSERT INTO "TEST_GS"."HOTEL_INFO" VALUES ('10', '敦煌天润大酒店', '权玉霞', '18993732897', '0937-8819501', '敦煌', '甘肃省酒泉市敦煌市鸣山路309号', null, null);
INSERT INTO "TEST_GS"."HOTEL_INFO" VALUES ('11', '敦煌太阳大酒店', '张春艳', '13893726729', '0937-8841858', '敦煌', null, null, null);
INSERT INTO "TEST_GS"."HOTEL_INFO" VALUES ('12', '行星酒店', '我也不', '1235135', '1231412', '肃州区', '肃州区', '123', '空');

-- ----------------------------
-- Table structure for HOTEL_PLANE_GRAPH
-- ----------------------------
DROP TABLE "TEST_GS"."HOTEL_PLANE_GRAPH";
CREATE TABLE "TEST_GS"."HOTEL_PLANE_GRAPH" (
"ID" NUMBER(11) NULL ,
"GRAPH_NAME" NVARCHAR2(255) NULL ,
"GRAPH_URL" NVARCHAR2(255) NULL ,
"FLOOR" NVARCHAR2(255) NULL ,
"HOTEL" NVARCHAR2(255) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "TEST_GS"."HOTEL_PLANE_GRAPH"."GRAPH_NAME" IS '平面图名称';
COMMENT ON COLUMN "TEST_GS"."HOTEL_PLANE_GRAPH"."GRAPH_URL" IS '图片路径';
COMMENT ON COLUMN "TEST_GS"."HOTEL_PLANE_GRAPH"."FLOOR" IS '楼层';
COMMENT ON COLUMN "TEST_GS"."HOTEL_PLANE_GRAPH"."HOTEL" IS '所属酒店';

-- ----------------------------
-- Records of HOTEL_PLANE_GRAPH
-- ----------------------------
INSERT INTO "TEST_GS"."HOTEL_PLANE_GRAPH" VALUES ('3', '{3B07188B-5C96-4120-81DE-AC5631EA9DDB}_光明大酒店', 'http://localhost:8088/ReceptionMS/views/upload/imgs/hotelphoto/1526207977306_232.png', null, '3');
INSERT INTO "TEST_GS"."HOTEL_PLANE_GRAPH" VALUES ('2', 'QQ截图20180330094419', 'http://localhost:8088/ReceptionMS/views/upload/imgs/hotelphoto/1526207519330_779.png', null, '3');
INSERT INTO "TEST_GS"."HOTEL_PLANE_GRAPH" VALUES ('4', '{4F8E9606-F8AA-4EAE-9B76-7E378385E1B7}_贵宾楼平面图', 'http://localhost:8088/ReceptionMS/views/upload/imgs/hotelphoto/1526208003797_377.jpg', null, '3');

-- ----------------------------
-- Table structure for MEALS_RECORD
-- ----------------------------
DROP TABLE "TEST_GS"."MEALS_RECORD";
CREATE TABLE "TEST_GS"."MEALS_RECORD" (
"ID" VARCHAR2(64 BYTE) NOT NULL ,
"RECEPTION_NUMBER" NVARCHAR2(128) NULL ,
"MENU_NUMBER" NVARCHAR2(128) NULL ,
"HOTEL" NVARCHAR2(64) NULL ,
"MEALS_TIME" NVARCHAR2(64) NULL ,
"HOBBY" NVARCHAR2(255) NULL ,
"RECORD_TIME" DATE NULL ,
"REMARK" NVARCHAR2(255) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TEST_GS"."MEALS_RECORD" IS '接待用餐记录';
COMMENT ON COLUMN "TEST_GS"."MEALS_RECORD"."RECEPTION_NUMBER" IS '接待编号';
COMMENT ON COLUMN "TEST_GS"."MEALS_RECORD"."MENU_NUMBER" IS '套餐编号';
COMMENT ON COLUMN "TEST_GS"."MEALS_RECORD"."HOTEL" IS '酒店';
COMMENT ON COLUMN "TEST_GS"."MEALS_RECORD"."MEALS_TIME" IS '用餐时间';
COMMENT ON COLUMN "TEST_GS"."MEALS_RECORD"."HOBBY" IS '宾客喜好';
COMMENT ON COLUMN "TEST_GS"."MEALS_RECORD"."RECORD_TIME" IS '登记时间';
COMMENT ON COLUMN "TEST_GS"."MEALS_RECORD"."REMARK" IS '备注';

-- ----------------------------
-- Records of MEALS_RECORD
-- ----------------------------
INSERT INTO "TEST_GS"."MEALS_RECORD" VALUES ('f3a47c2bcad84788bc315325b8de2a29', 'JD20180512110540', 'bzd', 'bzd', 'bzd', 'bzd', TO_DATE('2018-05-12 11:35:41', 'YYYY-MM-DD HH24:MI:SS'), 'bzd');
INSERT INTO "TEST_GS"."MEALS_RECORD" VALUES ('921ddcbb17694366a8dc9700f5ae9f28', 'JD20180512110540', 'bzd', 'bzd', 'bzd', 'bzd', TO_DATE('2018-05-12 11:35:41', 'YYYY-MM-DD HH24:MI:SS'), 'bzd');
INSERT INTO "TEST_GS"."MEALS_RECORD" VALUES ('83a91f03b38f4b81a8d6cb9c97ccf104', 'JD20180513100501', 'A单', '东方国际大酒店', '2018-01-01', '没有', TO_DATE('2018-05-13 10:56:01', 'YYYY-MM-DD HH24:MI:SS'), '无');

-- ----------------------------
-- Table structure for MENU_INFO
-- ----------------------------
DROP TABLE "TEST_GS"."MENU_INFO";
CREATE TABLE "TEST_GS"."MENU_INFO" (
"ID" NUMBER(11) NOT NULL ,
"MENU_NUMBER" NVARCHAR2(128) NULL ,
"SHORT_NAME" NVARCHAR2(255) NULL ,
"MENU_TYPE" NVARCHAR2(64) NULL ,
"HOTEL" NVARCHAR2(128) NULL ,
"MEALS_TIME" NVARCHAR2(64) NULL ,
"MEALS_TYPE" NVARCHAR2(64) NULL ,
"STANDARD" NVARCHAR2(255) NULL ,
"REMARK" NVARCHAR2(255) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TEST_GS"."MENU_INFO" IS '套餐信息';
COMMENT ON COLUMN "TEST_GS"."MENU_INFO"."MENU_NUMBER" IS '套餐编号';
COMMENT ON COLUMN "TEST_GS"."MENU_INFO"."SHORT_NAME" IS '套餐简称';
COMMENT ON COLUMN "TEST_GS"."MENU_INFO"."MENU_TYPE" IS '套餐类型';
COMMENT ON COLUMN "TEST_GS"."MENU_INFO"."HOTEL" IS '酒店';
COMMENT ON COLUMN "TEST_GS"."MENU_INFO"."MEALS_TIME" IS '用餐时间（早/午/晚）';
COMMENT ON COLUMN "TEST_GS"."MENU_INFO"."MEALS_TYPE" IS '用餐方式';
COMMENT ON COLUMN "TEST_GS"."MENU_INFO"."STANDARD" IS '标准分类';
COMMENT ON COLUMN "TEST_GS"."MENU_INFO"."REMARK" IS '备注';

-- ----------------------------
-- Records of MENU_INFO
-- ----------------------------
INSERT INTO "TEST_GS"."MENU_INFO" VALUES ('6', 'T6', null, '贵宾套餐', '宏兴大酒店', '正餐', '桌餐', '50', null);
INSERT INTO "TEST_GS"."MENU_INFO" VALUES ('2', 'T00005', null, '一般套餐', '东方国际大酒店', '早餐', '自助餐', '30', null);
INSERT INTO "TEST_GS"."MENU_INFO" VALUES ('3', 'T00006', 'B单', '一般套餐', '东方国际大酒店', '早餐', '自助餐', '30', null);
INSERT INTO "TEST_GS"."MENU_INFO" VALUES ('4', 'T00007', 'C单', '一般套餐', '东方国际大酒店', '早餐', '自助餐', '30', null);
INSERT INTO "TEST_GS"."MENU_INFO" VALUES ('5', 'T00009', 'D单', '一般套餐', '东方国际大酒店', '早餐', '自助餐', '30', null);

-- ----------------------------
-- Table structure for RECEPTION_RECORD
-- ----------------------------
DROP TABLE "TEST_GS"."RECEPTION_RECORD";
CREATE TABLE "TEST_GS"."RECEPTION_RECORD" (
"ID" NUMBER(11) NOT NULL ,
"RECEPTION_NUMBER" NVARCHAR2(128) NOT NULL ,
"RECEPTION_TITLE" NVARCHAR2(255) NULL ,
"RECEPTION_DATE" VARCHAR2(20 BYTE) NULL ,
"RECEPTION_PERSON" NVARCHAR2(255) NULL ,
"RECEPTION_PRINTER" NVARCHAR2(255) NULL ,
"GUEST_NAME" NVARCHAR2(255) NULL ,
"ENTOURAGE" NVARCHAR2(255) NULL ,
"GUEST_NUM" VARCHAR2(11 BYTE) NULL ,
"RECEPTION_NUM" VARCHAR2(11 BYTE) NULL ,
"RECEPTION_DAYS" NVARCHAR2(10) NULL ,
"HOTEL" NVARCHAR2(255) NULL ,
"DESCRIPTION" NVARCHAR2(255) NULL ,
"RECORD_TIME" DATE NULL ,
"REMARK" NVARCHAR2(255) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TEST_GS"."RECEPTION_RECORD" IS '接待记录';
COMMENT ON COLUMN "TEST_GS"."RECEPTION_RECORD"."RECEPTION_NUMBER" IS '接待编号';
COMMENT ON COLUMN "TEST_GS"."RECEPTION_RECORD"."RECEPTION_TITLE" IS '接待标题';
COMMENT ON COLUMN "TEST_GS"."RECEPTION_RECORD"."RECEPTION_DATE" IS '接待日期';
COMMENT ON COLUMN "TEST_GS"."RECEPTION_RECORD"."RECEPTION_PERSON" IS '接待人员';
COMMENT ON COLUMN "TEST_GS"."RECEPTION_RECORD"."RECEPTION_PRINTER" IS '接待打印人员';
COMMENT ON COLUMN "TEST_GS"."RECEPTION_RECORD"."GUEST_NAME" IS '宾客姓名';
COMMENT ON COLUMN "TEST_GS"."RECEPTION_RECORD"."ENTOURAGE" IS '陪同人员';
COMMENT ON COLUMN "TEST_GS"."RECEPTION_RECORD"."GUEST_NUM" IS '来宾人数';
COMMENT ON COLUMN "TEST_GS"."RECEPTION_RECORD"."RECEPTION_NUM" IS '接待人次';
COMMENT ON COLUMN "TEST_GS"."RECEPTION_RECORD"."RECEPTION_DAYS" IS '接待天数';
COMMENT ON COLUMN "TEST_GS"."RECEPTION_RECORD"."HOTEL" IS '接待酒店';
COMMENT ON COLUMN "TEST_GS"."RECEPTION_RECORD"."DESCRIPTION" IS '接待描述';
COMMENT ON COLUMN "TEST_GS"."RECEPTION_RECORD"."RECORD_TIME" IS '录入时间';
COMMENT ON COLUMN "TEST_GS"."RECEPTION_RECORD"."REMARK" IS '备注';

-- ----------------------------
-- Records of RECEPTION_RECORD
-- ----------------------------
INSERT INTO "TEST_GS"."RECEPTION_RECORD" VALUES ('2', 'JD20180512110504', '13', '2018-01-01', '31', '3', '11', '13', '123', '13', '31', '光明大酒店', '31', TO_DATE('2018-05-12 11:31:04', 'YYYY-MM-DD HH24:MI:SS'), '13');
INSERT INTO "TEST_GS"."RECEPTION_RECORD" VALUES ('4', 'JD20180513100501', '领导视察', '2018-05-13', '10', '李丹丹', '嘉佳', '某哦某', '10', '12', '5', '东方国际大酒店', '没有', TO_DATE('2018-05-13 10:56:01', 'YYYY-MM-DD HH24:MI:SS'), '无');

-- ----------------------------
-- Table structure for RESTAURANT_INFO
-- ----------------------------
DROP TABLE "TEST_GS"."RESTAURANT_INFO";
CREATE TABLE "TEST_GS"."RESTAURANT_INFO" (
"ID" NUMBER(11) NOT NULL ,
"RESTAURANT_NUMBER" NUMBER(11) NULL ,
"RESTAURANT_NAME" NVARCHAR2(255) NULL ,
"RESTAURANT_TYPE" NVARCHAR2(255) NULL ,
"HOTEL" NVARCHAR2(255) NULL ,
"POSITION" NVARCHAR2(255) NULL ,
"FLOOR" NVARCHAR2(255) NULL ,
"CAPACITY_NUM" NVARCHAR2(255) NULL ,
"STATE" NVARCHAR2(255) NULL ,
"REMARK" NVARCHAR2(255) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TEST_GS"."RESTAURANT_INFO" IS '餐厅包厢信息';
COMMENT ON COLUMN "TEST_GS"."RESTAURANT_INFO"."RESTAURANT_NUMBER" IS '餐厅编号';
COMMENT ON COLUMN "TEST_GS"."RESTAURANT_INFO"."RESTAURANT_NAME" IS '餐厅名 包厢名';
COMMENT ON COLUMN "TEST_GS"."RESTAURANT_INFO"."RESTAURANT_TYPE" IS '餐厅类型';
COMMENT ON COLUMN "TEST_GS"."RESTAURANT_INFO"."HOTEL" IS '所属酒店';
COMMENT ON COLUMN "TEST_GS"."RESTAURANT_INFO"."POSITION" IS '位置 在哪座楼';
COMMENT ON COLUMN "TEST_GS"."RESTAURANT_INFO"."FLOOR" IS '楼层';
COMMENT ON COLUMN "TEST_GS"."RESTAURANT_INFO"."CAPACITY_NUM" IS '容纳人数';
COMMENT ON COLUMN "TEST_GS"."RESTAURANT_INFO"."STATE" IS '状态';
COMMENT ON COLUMN "TEST_GS"."RESTAURANT_INFO"."REMARK" IS '备注';

-- ----------------------------
-- Records of RESTAURANT_INFO
-- ----------------------------

-- ----------------------------
-- Table structure for ROOM_INFO
-- ----------------------------
DROP TABLE "TEST_GS"."ROOM_INFO";
CREATE TABLE "TEST_GS"."ROOM_INFO" (
"ID" NUMBER(11) NOT NULL ,
"ROOM_NUMBER" NVARCHAR2(128) NULL ,
"HOTEL" NVARCHAR2(128) NULL ,
"FLOOR" NVARCHAR2(10) NULL ,
"ROOM_TYPE" NVARCHAR2(20) NULL ,
"SPECIAL_TYPE" NVARCHAR2(20) NULL ,
"ORIENTATION" NVARCHAR2(20) NULL ,
"SUPPORT_FACILITIES" NVARCHAR2(255) NULL ,
"SPECIAL_SERVE" NVARCHAR2(255) NULL ,
"OUTSIDE_PHONE" NVARCHAR2(20) NULL ,
"INNERLINE_PHONE" NVARCHAR2(20) NULL ,
"RESPONSIBLE_PERSON" NVARCHAR2(128) NULL ,
"RACK_PRICE" NVARCHAR2(20) NULL ,
"AGREEMENT_PRICE" NVARCHAR2(20) NULL ,
"CONTAIN_FOOD" NVARCHAR2(10) NULL ,
"STATE" NVARCHAR2(10) NULL ,
"REMARK" NVARCHAR2(255) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TEST_GS"."ROOM_INFO" IS '房间信息';
COMMENT ON COLUMN "TEST_GS"."ROOM_INFO"."ROOM_NUMBER" IS '房间编号';
COMMENT ON COLUMN "TEST_GS"."ROOM_INFO"."HOTEL" IS '所属酒店';
COMMENT ON COLUMN "TEST_GS"."ROOM_INFO"."FLOOR" IS '楼层';
COMMENT ON COLUMN "TEST_GS"."ROOM_INFO"."ROOM_TYPE" IS '房间类型';
COMMENT ON COLUMN "TEST_GS"."ROOM_INFO"."SPECIAL_TYPE" IS '特殊类型';
COMMENT ON COLUMN "TEST_GS"."ROOM_INFO"."ORIENTATION" IS '房间朝向';
COMMENT ON COLUMN "TEST_GS"."ROOM_INFO"."SUPPORT_FACILITIES" IS '配套设施';
COMMENT ON COLUMN "TEST_GS"."ROOM_INFO"."SPECIAL_SERVE" IS '特色服务';
COMMENT ON COLUMN "TEST_GS"."ROOM_INFO"."OUTSIDE_PHONE" IS '外线电话';
COMMENT ON COLUMN "TEST_GS"."ROOM_INFO"."INNERLINE_PHONE" IS '内线电话';
COMMENT ON COLUMN "TEST_GS"."ROOM_INFO"."RESPONSIBLE_PERSON" IS '房间负责人';
COMMENT ON COLUMN "TEST_GS"."ROOM_INFO"."RACK_PRICE" IS '门市价';
COMMENT ON COLUMN "TEST_GS"."ROOM_INFO"."AGREEMENT_PRICE" IS '协议价';
COMMENT ON COLUMN "TEST_GS"."ROOM_INFO"."CONTAIN_FOOD" IS '是否含餐';
COMMENT ON COLUMN "TEST_GS"."ROOM_INFO"."STATE" IS '房间状态';
COMMENT ON COLUMN "TEST_GS"."ROOM_INFO"."REMARK" IS '备注';

-- ----------------------------
-- Records of ROOM_INFO
-- ----------------------------
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('36', '111', '5', '1', '1', '没有', '北', '没有', '没有', '123', '123', '没有', '123', '1231', 'Y', '1', '11');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('1', '101', '3', '1', '1', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', 'Y', '1', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('2', '201', '3', '2', '1', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', 'Y', '2', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('3', '102', '4', '1', '1', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', 'Y', '1', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('33', '103', '3', '1', '1', '没有', '南', '没有', '没有', '没有', '没有', '没有', null, '111', 'Y', '2', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('35', '202', '4', '2', '2', '有噪音', '南', '电脑', '没有', '123456323', null, '我', null, null, 'N', '2', null);

-- ----------------------------
-- Table structure for ROOM_TYPE
-- ----------------------------
DROP TABLE "TEST_GS"."ROOM_TYPE";
CREATE TABLE "TEST_GS"."ROOM_TYPE" (
"ID" NUMBER(11) NOT NULL ,
"TYPE_NUMBER" NVARCHAR2(128) NULL ,
"HOTEL_NAME" NVARCHAR2(255) NULL ,
"FLOOR" NVARCHAR2(128) NULL ,
"ROOM_TYPE" NVARCHAR2(128) NULL ,
"REMARK" NVARCHAR2(255) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "TEST_GS"."ROOM_TYPE"."TYPE_NUMBER" IS '类型编号';
COMMENT ON COLUMN "TEST_GS"."ROOM_TYPE"."HOTEL_NAME" IS '酒店名称';
COMMENT ON COLUMN "TEST_GS"."ROOM_TYPE"."FLOOR" IS '楼层';
COMMENT ON COLUMN "TEST_GS"."ROOM_TYPE"."ROOM_TYPE" IS '房间类型';
COMMENT ON COLUMN "TEST_GS"."ROOM_TYPE"."REMARK" IS '备注';

-- ----------------------------
-- Records of ROOM_TYPE
-- ----------------------------

-- ----------------------------
-- Table structure for SYS_MODULE
-- ----------------------------
DROP TABLE "TEST_GS"."SYS_MODULE";
CREATE TABLE "TEST_GS"."SYS_MODULE" (
"ID" NUMBER(11) NOT NULL ,
"MODULE_NAME" NVARCHAR2(255) NULL ,
"MODULE_ID" NUMBER(11) NULL ,
"MODULE_PARENT_ID" NUMBER(11) NULL ,
"URL" NVARCHAR2(255) NULL ,
"SORT" NVARCHAR2(62) NULL ,
"CREATE_TIME" DATE NULL ,
"ICON" NVARCHAR2(255) NULL ,
"REMARK" NVARCHAR2(255) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "TEST_GS"."SYS_MODULE"."MODULE_NAME" IS '模块名称';
COMMENT ON COLUMN "TEST_GS"."SYS_MODULE"."MODULE_ID" IS '模块id';
COMMENT ON COLUMN "TEST_GS"."SYS_MODULE"."MODULE_PARENT_ID" IS '模块上级id';
COMMENT ON COLUMN "TEST_GS"."SYS_MODULE"."URL" IS '模块页面地址';
COMMENT ON COLUMN "TEST_GS"."SYS_MODULE"."SORT" IS '排序';
COMMENT ON COLUMN "TEST_GS"."SYS_MODULE"."CREATE_TIME" IS '创建时间';
COMMENT ON COLUMN "TEST_GS"."SYS_MODULE"."ICON" IS '图标';

-- ----------------------------
-- Records of SYS_MODULE
-- ----------------------------
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('1', '系统管理', '1', '0', null, '4', null, 'xtgl', null);
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('2', '用户设置', '2', '1', '../system/userSheZhi.html', '1', null, 'yhsz', null);
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('3', '角色设置', '3', '1', '../system/roleSheZhi.html', '2', null, 'jssz', null);
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('4', '模块设置', '4', '1', '../system/module.html', '3', null, 'mksz', null);
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('5', '操作日志', '5', '1', '../system/log.html', '4', null, 'czrz', null);
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('6', '数据库配置', '6', '1', '../system/configure.html', '5', null, 'sjkpz', null);
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('7', '接待管理', '7', '0', null, '1', null, 'jdgl', null);
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('8', '接待登记', '8', '7', '../reception/register.html', '1', null, 'jddj', null);
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('9', '接待信息', '9', '7', '../reception/receptionManage.html', '2', null, 'jdxxgl', null);
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('10', '酒店管理', '10', '0', null, '2', null, 'Jdgl', null);
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('11', '酒店信息设置', '11', '10', '../hotel/HotelManage.html', '1', null, 'Jdxxgl', null);
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('12', '房间信息设置', '12', '10', '../hotel/roomManage.html', '2', null, 'fjxxgl', null);
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('13', '会议室信息设置', '13', '10', '../conference/conferenceInfo.html', '3', null, 'hysxxgl', null);
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('14', '会议室使用登记', '14', '7', '../reception/boardroomManage.html', '3', null, 'hyssyjl', null);
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('15', '套餐菜品设置', '15', '10', '../menu/menuInformation.html', '4', null, 'tccpxxgl', null);
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('17', '数据字典维护', '17', '1', '../system/weiHu.html', '6', null, 'sjzdwh', null);
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('18', '宾客管理', '18', '0', null, '3', null, 'bkxxgl', null);
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('19', '宾客信息设置', '19', '18', '../guest/guestInformation.html', '1', null, 'bkxxgl', null);
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('20', '酒店对比', '20', '10', '../hotel/HotelContrasts.html', '6', null, 'Jddb', null);
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('21', '餐厅(包厢)信息设置', '21', '10', null, '5', null, 'fjxxgl', null);

-- ----------------------------
-- Table structure for SYS_OPERATION_LOG
-- ----------------------------
DROP TABLE "TEST_GS"."SYS_OPERATION_LOG";
CREATE TABLE "TEST_GS"."SYS_OPERATION_LOG" (
"ID" NUMBER(11) NOT NULL ,
"OPERATOR" NVARCHAR2(255) NULL ,
"MODULE" NVARCHAR2(255) NULL ,
"OPERATION" NVARCHAR2(255) NULL ,
"TIME" NVARCHAR2(255) NULL ,
"COMPUER_IP" NVARCHAR2(255) NULL ,
"COMPUER_NAME" NVARCHAR2(255) NULL ,
"REMARK" NVARCHAR2(255) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TEST_GS"."SYS_OPERATION_LOG" IS '操作日志表';
COMMENT ON COLUMN "TEST_GS"."SYS_OPERATION_LOG"."OPERATOR" IS '操作用户';
COMMENT ON COLUMN "TEST_GS"."SYS_OPERATION_LOG"."MODULE" IS '操作模块';
COMMENT ON COLUMN "TEST_GS"."SYS_OPERATION_LOG"."OPERATION" IS '操作内容';
COMMENT ON COLUMN "TEST_GS"."SYS_OPERATION_LOG"."TIME" IS '操作时间';
COMMENT ON COLUMN "TEST_GS"."SYS_OPERATION_LOG"."COMPUER_IP" IS '操作电脑IP地址';
COMMENT ON COLUMN "TEST_GS"."SYS_OPERATION_LOG"."COMPUER_NAME" IS '操作电脑名';
COMMENT ON COLUMN "TEST_GS"."SYS_OPERATION_LOG"."REMARK" IS '备注';

-- ----------------------------
-- Records of SYS_OPERATION_LOG
-- ----------------------------

-- ----------------------------
-- Table structure for SYS_ROLE
-- ----------------------------
DROP TABLE "TEST_GS"."SYS_ROLE";
CREATE TABLE "TEST_GS"."SYS_ROLE" (
"ID" NUMBER(11) NOT NULL ,
"ROLE_NAME" NVARCHAR2(255) NULL ,
"DESCRIPTION" NVARCHAR2(255) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "TEST_GS"."SYS_ROLE"."ROLE_NAME" IS '角色名';
COMMENT ON COLUMN "TEST_GS"."SYS_ROLE"."DESCRIPTION" IS '描述';

-- ----------------------------
-- Records of SYS_ROLE
-- ----------------------------
INSERT INTO "TEST_GS"."SYS_ROLE" VALUES ('1', '管理员', '普通管理员');
INSERT INTO "TEST_GS"."SYS_ROLE" VALUES ('2', '普通用户', '普通用户');
INSERT INTO "TEST_GS"."SYS_ROLE" VALUES ('0', '超级管理员', '超级管理员');

-- ----------------------------
-- Table structure for SYS_ROLE_MODULE
-- ----------------------------
DROP TABLE "TEST_GS"."SYS_ROLE_MODULE";
CREATE TABLE "TEST_GS"."SYS_ROLE_MODULE" (
"ROLE_ID" VARCHAR2(11 BYTE) NULL ,
"MODULE_ID" NVARCHAR2(255) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "TEST_GS"."SYS_ROLE_MODULE"."ROLE_ID" IS '角色id';
COMMENT ON COLUMN "TEST_GS"."SYS_ROLE_MODULE"."MODULE_ID" IS '模块id';

-- ----------------------------
-- Records of SYS_ROLE_MODULE
-- ----------------------------
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('1', '2');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('1', '3');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('1', '1');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('1', '4');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('1', '5');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('1', '6');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('1', '17');

-- ----------------------------
-- Table structure for SYS_USER
-- ----------------------------
DROP TABLE "TEST_GS"."SYS_USER";
CREATE TABLE "TEST_GS"."SYS_USER" (
"ID" NUMBER(11) NOT NULL ,
"USER_NAME" NVARCHAR2(128) NULL ,
"USER_NICK" NVARCHAR2(128) NULL ,
"PASSWORD" NVARCHAR2(64) NULL ,
"LAST_LOGIN_COMPUTER" NVARCHAR2(128) NULL ,
"LAST_LOGIN_TIME" DATE NULL ,
"CREATE_TIME" DATE NULL ,
"MODIFY_TIME" DATE NULL ,
"ENABLED" NVARCHAR2(4) NULL ,
"ROLE_ID" NUMBER(11) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TEST_GS"."SYS_USER" IS '用户表';
COMMENT ON COLUMN "TEST_GS"."SYS_USER"."USER_NAME" IS '用户名';
COMMENT ON COLUMN "TEST_GS"."SYS_USER"."PASSWORD" IS '密码';
COMMENT ON COLUMN "TEST_GS"."SYS_USER"."LAST_LOGIN_COMPUTER" IS '上次登录电脑名';
COMMENT ON COLUMN "TEST_GS"."SYS_USER"."LAST_LOGIN_TIME" IS '上次登录时间';
COMMENT ON COLUMN "TEST_GS"."SYS_USER"."ENABLED" IS '是否启用';
COMMENT ON COLUMN "TEST_GS"."SYS_USER"."ROLE_ID" IS '角色id';

-- ----------------------------
-- Records of SYS_USER
-- ----------------------------
INSERT INTO "TEST_GS"."SYS_USER" VALUES ('1', 'admin', '管理员', 'admin', 'DESKTOP-VTDU3JD:10.1.92.8', TO_DATE('2018-05-13 19:00:07', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-05-10 17:48:39', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-05-10 17:48:46', 'YYYY-MM-DD HH24:MI:SS'), '1', '0');
INSERT INTO "TEST_GS"."SYS_USER" VALUES ('2', 'www', '管理员', 'admin', 'DESKTOP-VTDU3JD:10.1.92.8', TO_DATE('2018-05-12 19:26:42', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-05-10 17:48:42', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-05-10 17:48:48', 'YYYY-MM-DD HH24:MI:SS'), '1', '1');
INSERT INTO "TEST_GS"."SYS_USER" VALUES ('3', 'wwww', 'ww1', '111111', null, null, TO_DATE('2018-05-10 19:06:14', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-05-10 19:12:45', 'YYYY-MM-DD HH24:MI:SS'), null, '1');

-- ----------------------------
-- Indexes structure for table ACCOMMODATION_RECORD
-- ----------------------------

-- ----------------------------
-- Checks structure for table ACCOMMODATION_RECORD
-- ----------------------------
ALTER TABLE "TEST_GS"."ACCOMMODATION_RECORD" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table ACCOMMODATION_RECORD
-- ----------------------------
ALTER TABLE "TEST_GS"."ACCOMMODATION_RECORD" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table CONFERENCE_INFO
-- ----------------------------

-- ----------------------------
-- Checks structure for table CONFERENCE_INFO
-- ----------------------------
ALTER TABLE "TEST_GS"."CONFERENCE_INFO" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table CONFERENCE_INFO
-- ----------------------------
ALTER TABLE "TEST_GS"."CONFERENCE_INFO" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table CONFERENCE_RECORD
-- ----------------------------

-- ----------------------------
-- Checks structure for table CONFERENCE_RECORD
-- ----------------------------
ALTER TABLE "TEST_GS"."CONFERENCE_RECORD" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table CONFERENCE_RECORD
-- ----------------------------
ALTER TABLE "TEST_GS"."CONFERENCE_RECORD" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table FOOD_INFO
-- ----------------------------

-- ----------------------------
-- Checks structure for table FOOD_INFO
-- ----------------------------
ALTER TABLE "TEST_GS"."FOOD_INFO" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table FOOD_INFO
-- ----------------------------
ALTER TABLE "TEST_GS"."FOOD_INFO" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table GUEST_INFO
-- ----------------------------

-- ----------------------------
-- Checks structure for table GUEST_INFO
-- ----------------------------
ALTER TABLE "TEST_GS"."GUEST_INFO" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table GUEST_INFO
-- ----------------------------
ALTER TABLE "TEST_GS"."GUEST_INFO" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table HOTEL_INFO
-- ----------------------------

-- ----------------------------
-- Checks structure for table HOTEL_INFO
-- ----------------------------
ALTER TABLE "TEST_GS"."HOTEL_INFO" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table HOTEL_INFO
-- ----------------------------
ALTER TABLE "TEST_GS"."HOTEL_INFO" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table MEALS_RECORD
-- ----------------------------

-- ----------------------------
-- Checks structure for table MEALS_RECORD
-- ----------------------------
ALTER TABLE "TEST_GS"."MEALS_RECORD" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table MEALS_RECORD
-- ----------------------------
ALTER TABLE "TEST_GS"."MEALS_RECORD" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table MENU_INFO
-- ----------------------------

-- ----------------------------
-- Checks structure for table MENU_INFO
-- ----------------------------
ALTER TABLE "TEST_GS"."MENU_INFO" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table MENU_INFO
-- ----------------------------
ALTER TABLE "TEST_GS"."MENU_INFO" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table RECEPTION_RECORD
-- ----------------------------

-- ----------------------------
-- Checks structure for table RECEPTION_RECORD
-- ----------------------------
ALTER TABLE "TEST_GS"."RECEPTION_RECORD" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TEST_GS"."RECEPTION_RECORD" ADD CHECK ("RECEPTION_NUMBER" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table RECEPTION_RECORD
-- ----------------------------
ALTER TABLE "TEST_GS"."RECEPTION_RECORD" ADD PRIMARY KEY ("ID", "RECEPTION_NUMBER");

-- ----------------------------
-- Indexes structure for table RESTAURANT_INFO
-- ----------------------------

-- ----------------------------
-- Checks structure for table RESTAURANT_INFO
-- ----------------------------
ALTER TABLE "TEST_GS"."RESTAURANT_INFO" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table RESTAURANT_INFO
-- ----------------------------
ALTER TABLE "TEST_GS"."RESTAURANT_INFO" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table ROOM_INFO
-- ----------------------------

-- ----------------------------
-- Checks structure for table ROOM_INFO
-- ----------------------------
ALTER TABLE "TEST_GS"."ROOM_INFO" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table ROOM_INFO
-- ----------------------------
ALTER TABLE "TEST_GS"."ROOM_INFO" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table ROOM_TYPE
-- ----------------------------

-- ----------------------------
-- Checks structure for table ROOM_TYPE
-- ----------------------------
ALTER TABLE "TEST_GS"."ROOM_TYPE" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table ROOM_TYPE
-- ----------------------------
ALTER TABLE "TEST_GS"."ROOM_TYPE" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table SYS_MODULE
-- ----------------------------

-- ----------------------------
-- Checks structure for table SYS_MODULE
-- ----------------------------
ALTER TABLE "TEST_GS"."SYS_MODULE" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_MODULE
-- ----------------------------
ALTER TABLE "TEST_GS"."SYS_MODULE" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table SYS_OPERATION_LOG
-- ----------------------------

-- ----------------------------
-- Checks structure for table SYS_OPERATION_LOG
-- ----------------------------
ALTER TABLE "TEST_GS"."SYS_OPERATION_LOG" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_OPERATION_LOG
-- ----------------------------
ALTER TABLE "TEST_GS"."SYS_OPERATION_LOG" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table SYS_ROLE
-- ----------------------------

-- ----------------------------
-- Checks structure for table SYS_ROLE
-- ----------------------------
ALTER TABLE "TEST_GS"."SYS_ROLE" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_ROLE
-- ----------------------------
ALTER TABLE "TEST_GS"."SYS_ROLE" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table SYS_USER
-- ----------------------------

-- ----------------------------
-- Checks structure for table SYS_USER
-- ----------------------------
ALTER TABLE "TEST_GS"."SYS_USER" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_USER
-- ----------------------------
ALTER TABLE "TEST_GS"."SYS_USER" ADD PRIMARY KEY ("ID");
