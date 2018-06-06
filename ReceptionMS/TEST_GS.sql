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

Date: 2018-06-06 14:49:02
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
INSERT INTO "TEST_GS"."ACCOMMODATION_RECORD" VALUES ('248dc3388ae9493d807bdbecf5aad8fa', 'JD20180514030518', '东方国际大酒店', '111', '2018-05-14', '2018-05-15', '无', TO_DATE('2018-05-17 14:14:40', 'YYYY-MM-DD HH24:MI:SS'), '空');
INSERT INTO "TEST_GS"."ACCOMMODATION_RECORD" VALUES ('75e60b04f2844b098d5e4cb661112585', 'JD20180513100501', '东方国际大酒店', '201', '2018-05-16', '2018-05-24', '没有', TO_DATE('2018-05-13 11:06:23', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "TEST_GS"."ACCOMMODATION_RECORD" VALUES ('5cef71f52176468382172f9a8689ccdb', 'JD20180513100501', '光明大酒店', '201', '2018-05-09', '2018-05-22', '没有', TO_DATE('2018-05-13 11:06:35', 'YYYY-MM-DD HH24:MI:SS'), null);

-- ----------------------------
-- Table structure for CONFERENCE_INFO
-- ----------------------------
DROP TABLE "TEST_GS"."CONFERENCE_INFO";
CREATE TABLE "TEST_GS"."CONFERENCE_INFO" (
"ID" NUMBER(15) NOT NULL ,
"CONFERENCE_NAME" NVARCHAR2(255) NULL ,
"HOTEL" NVARCHAR2(255) NULL ,
"TYPE" NVARCHAR2(128) NULL ,
"POSITION" NVARCHAR2(128) NULL ,
"CAPACITY_NUM" NVARCHAR2(128) NULL ,
"REMARK" NVARCHAR2(255) NULL ,
"PRICE" NVARCHAR2(10) NULL ,
"DETAILEDINFO" NVARCHAR2(128) NULL 
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
COMMENT ON COLUMN "TEST_GS"."CONFERENCE_INFO"."CAPACITY_NUM" IS '容纳人数';
COMMENT ON COLUMN "TEST_GS"."CONFERENCE_INFO"."REMARK" IS '备注';
COMMENT ON COLUMN "TEST_GS"."CONFERENCE_INFO"."PRICE" IS '价格';
COMMENT ON COLUMN "TEST_GS"."CONFERENCE_INFO"."DETAILEDINFO" IS '详细信息';

-- ----------------------------
-- Records of CONFERENCE_INFO
-- ----------------------------
INSERT INTO "TEST_GS"."CONFERENCE_INFO" VALUES ('1527733482050', '大厅', '东方国际大酒店', null, '五号楼', '100', '1', '200', '11');

-- ----------------------------
-- Table structure for CONFERENCE_RECORD
-- ----------------------------
DROP TABLE "TEST_GS"."CONFERENCE_RECORD";
CREATE TABLE "TEST_GS"."CONFERENCE_RECORD" (
"ID" NUMBER(15) NOT NULL ,
"USE_NUMBER" NVARCHAR2(128) NULL ,
"CONFERENCE_NAME" NVARCHAR2(255) NULL ,
"HOTEL" NVARCHAR2(255) NULL ,
"USE_DATE" DATE NULL ,
"START_TIME" NVARCHAR2(255) NULL ,
"END_TIME" NVARCHAR2(255) NULL ,
"PURPOSE" NVARCHAR2(255) NULL ,
"GUEST_NUM" NUMBER(11) NULL ,
"REMARK" NVARCHAR2(255) NULL ,
"CREATEDATE" DATE NULL ,
"UPDATEDATE" DATE NULL 
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
COMMENT ON COLUMN "TEST_GS"."CONFERENCE_RECORD"."CREATEDATE" IS '创建时间';
COMMENT ON COLUMN "TEST_GS"."CONFERENCE_RECORD"."UPDATEDATE" IS '更新时间';

-- ----------------------------
-- Records of CONFERENCE_RECORD
-- ----------------------------
INSERT INTO "TEST_GS"."CONFERENCE_RECORD" VALUES ('1526375326644', 'H20180515001', '侯见厅', '东方国际大酒店', TO_DATE('2018-05-15 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '18:00', '19:00', '开会', '5', '无', TO_DATE('2018-05-15 17:08:32', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-05-15 17:08:32', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "TEST_GS"."CONFERENCE_RECORD" VALUES ('1528185589426', 'H20180605001', '大厅', '东方国际大酒店', TO_DATE('2018-06-05 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '15:00', '19:00', 'kaihui', '1', null, TO_DATE('2018-06-05 15:58:41', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-06-05 15:58:41', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "TEST_GS"."CONFERENCE_RECORD" VALUES ('1527930811500', 'H20180515002', '大厅', '东方国际大酒店', TO_DATE('2018-06-02 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '18:00', '20:05', 'aqew', '3', null, TO_DATE('2018-06-02 17:12:46', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-06-02 17:12:46', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "TEST_GS"."CONFERENCE_RECORD" VALUES ('1527930814293', 'H20180515003', '大厅', '东方国际大酒店', TO_DATE('2018-06-02 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '18:00', '20:05', 'aqew', '3', null, TO_DATE('2018-06-02 17:12:49', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-06-02 17:12:49', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "TEST_GS"."CONFERENCE_RECORD" VALUES ('1527930816557', 'H20180515004', '大厅', '东方国际大酒店', TO_DATE('2018-06-02 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '18:00', '20:05', 'aqew', '3', null, TO_DATE('2018-06-02 17:12:51', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-06-02 17:12:51', 'YYYY-MM-DD HH24:MI:SS'));

-- ----------------------------
-- Table structure for DM_AREA
-- ----------------------------
DROP TABLE "TEST_GS"."DM_AREA";
CREATE TABLE "TEST_GS"."DM_AREA" (
"NAME" NVARCHAR2(255) NULL ,
"VALUE" NVARCHAR2(255) NULL ,
"REMARK" NVARCHAR2(255) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "TEST_GS"."DM_AREA"."NAME" IS '地区名称';
COMMENT ON COLUMN "TEST_GS"."DM_AREA"."VALUE" IS '值';
COMMENT ON COLUMN "TEST_GS"."DM_AREA"."REMARK" IS '描述';

-- ----------------------------
-- Records of DM_AREA
-- ----------------------------
INSERT INTO "TEST_GS"."DM_AREA" VALUES ('西南', '5', '四川');
INSERT INTO "TEST_GS"."DM_AREA" VALUES ('华东', '1', '上海、江苏、浙江、安徽、江西');
INSERT INTO "TEST_GS"."DM_AREA" VALUES ('华南', '2', '广东、福建、广西、海南');
INSERT INTO "TEST_GS"."DM_AREA" VALUES ('华北', '3', '北京、天津、河北、山东、河南、山西、内蒙古');
INSERT INTO "TEST_GS"."DM_AREA" VALUES ('华中', '4', '湖北、湖南');
INSERT INTO "TEST_GS"."DM_AREA" VALUES ('西北', '7', '陕西、甘肃、宁夏、青海、新疆');

-- ----------------------------
-- Table structure for DM_CONFERENCE_TYPE
-- ----------------------------
DROP TABLE "TEST_GS"."DM_CONFERENCE_TYPE";
CREATE TABLE "TEST_GS"."DM_CONFERENCE_TYPE" (
"NAME" NVARCHAR2(255) NULL ,
"VALUE" NVARCHAR2(255) NULL ,
"REMARK" VARCHAR2(255 BYTE) NULL 
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
INSERT INTO "TEST_GS"."DM_CONFERENCE_TYPE" VALUES ('会议室', '1', null);
INSERT INTO "TEST_GS"."DM_CONFERENCE_TYPE" VALUES ('讲座室', '2', null);
INSERT INTO "TEST_GS"."DM_CONFERENCE_TYPE" VALUES ('演播室', '3', null);

-- ----------------------------
-- Table structure for DM_DISTRICT
-- ----------------------------
DROP TABLE "TEST_GS"."DM_DISTRICT";
CREATE TABLE "TEST_GS"."DM_DISTRICT" (
"NAME" NVARCHAR2(255) NULL ,
"VALUE" NVARCHAR2(255) NULL ,
"REMARK" VARCHAR2(255 BYTE) NULL 
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
INSERT INTO "TEST_GS"."DM_DISTRICT" VALUES ('敦煌', '1', null);
INSERT INTO "TEST_GS"."DM_DISTRICT" VALUES ('肃州区', '2', null);
INSERT INTO "TEST_GS"."DM_DISTRICT" VALUES ('金塔县', '3', null);
INSERT INTO "TEST_GS"."DM_DISTRICT" VALUES ('玉门市', '4', null);

-- ----------------------------
-- Table structure for DM_EDUCATION
-- ----------------------------
DROP TABLE "TEST_GS"."DM_EDUCATION";
CREATE TABLE "TEST_GS"."DM_EDUCATION" (
"NAME" NVARCHAR2(128) NULL ,
"VALUE" NVARCHAR2(64) NULL ,
"REMARK" VARCHAR2(255 BYTE) NULL 
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
INSERT INTO "TEST_GS"."DM_EDUCATION" VALUES ('高中及以下', '1', null);
INSERT INTO "TEST_GS"."DM_EDUCATION" VALUES ('大专', '2', null);
INSERT INTO "TEST_GS"."DM_EDUCATION" VALUES ('本科', '3', null);
INSERT INTO "TEST_GS"."DM_EDUCATION" VALUES ('硕士', '4', null);
INSERT INTO "TEST_GS"."DM_EDUCATION" VALUES ('博士', '5', null);

-- ----------------------------
-- Table structure for DM_MEALS_STANDARD
-- ----------------------------
DROP TABLE "TEST_GS"."DM_MEALS_STANDARD";
CREATE TABLE "TEST_GS"."DM_MEALS_STANDARD" (
"NAME" NVARCHAR2(255) NULL ,
"VALUE" NVARCHAR2(255) NULL ,
"REMARK" VARCHAR2(255 BYTE) NULL 
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
INSERT INTO "TEST_GS"."DM_MEALS_STANDARD" VALUES ('30', '1', null);
INSERT INTO "TEST_GS"."DM_MEALS_STANDARD" VALUES ('50', '2', null);
INSERT INTO "TEST_GS"."DM_MEALS_STANDARD" VALUES ('120', '3', null);

-- ----------------------------
-- Table structure for DM_MEALS_TIME
-- ----------------------------
DROP TABLE "TEST_GS"."DM_MEALS_TIME";
CREATE TABLE "TEST_GS"."DM_MEALS_TIME" (
"NAME" NVARCHAR2(255) NULL ,
"VALUE" NVARCHAR2(255) NULL ,
"REMARK" VARCHAR2(255 BYTE) NULL 
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
INSERT INTO "TEST_GS"."DM_MEALS_TIME" VALUES ('早餐', '1', null);
INSERT INTO "TEST_GS"."DM_MEALS_TIME" VALUES ('正餐', '2', null);
INSERT INTO "TEST_GS"."DM_MEALS_TIME" VALUES ('晚餐', '3', null);

-- ----------------------------
-- Table structure for DM_MEALS_TYPE
-- ----------------------------
DROP TABLE "TEST_GS"."DM_MEALS_TYPE";
CREATE TABLE "TEST_GS"."DM_MEALS_TYPE" (
"NAME" NVARCHAR2(255) NULL ,
"VALUE" NVARCHAR2(255) NULL ,
"REMARK" VARCHAR2(255 BYTE) NULL 
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
INSERT INTO "TEST_GS"."DM_MEALS_TYPE" VALUES ('餐桌', '1', null);
INSERT INTO "TEST_GS"."DM_MEALS_TYPE" VALUES ('自助餐', '2', null);
INSERT INTO "TEST_GS"."DM_MEALS_TYPE" VALUES ('工作餐', '3', null);

-- ----------------------------
-- Table structure for DM_MENU_TYPE
-- ----------------------------
DROP TABLE "TEST_GS"."DM_MENU_TYPE";
CREATE TABLE "TEST_GS"."DM_MENU_TYPE" (
"NAME" NVARCHAR2(255) NULL ,
"VALUE" NVARCHAR2(255) NULL ,
"REMARK" VARCHAR2(255 BYTE) NULL 
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
INSERT INTO "TEST_GS"."DM_MENU_TYPE" VALUES ('一般套餐', '1', null);
INSERT INTO "TEST_GS"."DM_MENU_TYPE" VALUES ('贵宾套餐', '2', null);

-- ----------------------------
-- Table structure for DM_NATION
-- ----------------------------
DROP TABLE "TEST_GS"."DM_NATION";
CREATE TABLE "TEST_GS"."DM_NATION" (
"NAME" NVARCHAR2(255) NULL ,
"VALUE" NVARCHAR2(255) NULL ,
"REMARK" VARCHAR2(255 BYTE) NULL 
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
INSERT INTO "TEST_GS"."DM_NATION" VALUES ('汉族', '1', null);
INSERT INTO "TEST_GS"."DM_NATION" VALUES ('回族', '2', null);
INSERT INTO "TEST_GS"."DM_NATION" VALUES ('蒙古族', '3', null);
INSERT INTO "TEST_GS"."DM_NATION" VALUES ('藏族', '4', null);

-- ----------------------------
-- Table structure for DM_RESTAURANT_TYPE
-- ----------------------------
DROP TABLE "TEST_GS"."DM_RESTAURANT_TYPE";
CREATE TABLE "TEST_GS"."DM_RESTAURANT_TYPE" (
"NAME" VARCHAR2(20 BYTE) NULL ,
"VALUE" VARCHAR2(5 BYTE) NULL ,
"REMARK" VARCHAR2(255 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TEST_GS"."DM_RESTAURANT_TYPE" IS '餐厅类型';
COMMENT ON COLUMN "TEST_GS"."DM_RESTAURANT_TYPE"."NAME" IS '名称';
COMMENT ON COLUMN "TEST_GS"."DM_RESTAURANT_TYPE"."VALUE" IS '代码';

-- ----------------------------
-- Records of DM_RESTAURANT_TYPE
-- ----------------------------
INSERT INTO "TEST_GS"."DM_RESTAURANT_TYPE" VALUES ('自助餐厅', '1', null);
INSERT INTO "TEST_GS"."DM_RESTAURANT_TYPE" VALUES ('火锅', '2', null);
INSERT INTO "TEST_GS"."DM_RESTAURANT_TYPE" VALUES ('海鲜', '3', null);

-- ----------------------------
-- Table structure for DM_ROOM_SPECIAL_TYPE
-- ----------------------------
DROP TABLE "TEST_GS"."DM_ROOM_SPECIAL_TYPE";
CREATE TABLE "TEST_GS"."DM_ROOM_SPECIAL_TYPE" (
"NAME" NVARCHAR2(255) NULL ,
"VALUE" NVARCHAR2(255) NULL ,
"REMARK" VARCHAR2(255 BYTE) NULL 
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
INSERT INTO "TEST_GS"."DM_ROOM_SPECIAL_TYPE" VALUES ('有柱子', '1', null);
INSERT INTO "TEST_GS"."DM_ROOM_SPECIAL_TYPE" VALUES ('噪音大', '2', null);

-- ----------------------------
-- Table structure for DM_ROOM_TYPE
-- ----------------------------
DROP TABLE "TEST_GS"."DM_ROOM_TYPE";
CREATE TABLE "TEST_GS"."DM_ROOM_TYPE" (
"NAME" NVARCHAR2(255) NULL ,
"VALUE" NVARCHAR2(255) NULL ,
"REMARK" VARCHAR2(255 BYTE) NULL 
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
INSERT INTO "TEST_GS"."DM_ROOM_TYPE" VALUES ('普通标间', '1', null);
INSERT INTO "TEST_GS"."DM_ROOM_TYPE" VALUES ('商务标间', '2', null);
INSERT INTO "TEST_GS"."DM_ROOM_TYPE" VALUES ('商务单间', '3', null);
INSERT INTO "TEST_GS"."DM_ROOM_TYPE" VALUES ('豪华套间', '4', null);

-- ----------------------------
-- Table structure for DM_SEX
-- ----------------------------
DROP TABLE "TEST_GS"."DM_SEX";
CREATE TABLE "TEST_GS"."DM_SEX" (
"NAME" NVARCHAR2(8) NULL ,
"VALUE" NUMBER(11) NULL ,
"REMARK" VARCHAR2(255 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of DM_SEX
-- ----------------------------
INSERT INTO "TEST_GS"."DM_SEX" VALUES ('男', '1', null);
INSERT INTO "TEST_GS"."DM_SEX" VALUES ('女', '2', null);
INSERT INTO "TEST_GS"."DM_SEX" VALUES ('其他', '0', null);

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
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('120', 'T00005', 'sacads', null, '20', null, null, null);
INSERT INTO "TEST_GS"."FOOD_INFO" VALUES ('121', 'T00005', 'asdfas', null, '50', null, null, null);
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
"BIRTH_DATE" VARCHAR2(20 BYTE) NULL ,
"NATION" VARCHAR2(11 BYTE) NULL ,
"MENU" VARCHAR2(128 BYTE) NULL ,
"DRINK" VARCHAR2(128 BYTE) NULL ,
"FLAVOR" VARCHAR2(128 BYTE) NULL ,
"SLEEP" VARCHAR2(128 BYTE) NULL ,
"ORIGIN_PLACE" NVARCHAR2(255) NULL ,
"URL" VARCHAR2(128 CHAR) NULL ,
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
COMMENT ON COLUMN "TEST_GS"."GUEST_INFO"."BIRTH_DATE" IS '出生日期';
COMMENT ON COLUMN "TEST_GS"."GUEST_INFO"."NATION" IS '民族';
COMMENT ON COLUMN "TEST_GS"."GUEST_INFO"."MENU" IS '菜品';
COMMENT ON COLUMN "TEST_GS"."GUEST_INFO"."DRINK" IS '饮品';
COMMENT ON COLUMN "TEST_GS"."GUEST_INFO"."FLAVOR" IS '口味';
COMMENT ON COLUMN "TEST_GS"."GUEST_INFO"."SLEEP" IS '住宿';
COMMENT ON COLUMN "TEST_GS"."GUEST_INFO"."ORIGIN_PLACE" IS '籍贯';
COMMENT ON COLUMN "TEST_GS"."GUEST_INFO"."REMARK" IS '备注';

-- ----------------------------
-- Records of GUEST_INFO
-- ----------------------------
INSERT INTO "TEST_GS"."GUEST_INFO" VALUES ('1', '张三', '经理', '主管', '阿斯突然有吗', '男', '2018-05-14', '蒙古族', '发生', '地方', '发多少', '阿斯顿发我让育儿', '阿斯顿发', '../../guest/img/1527922017842_109.png', null);
INSERT INTO "TEST_GS"."GUEST_INFO" VALUES ('8', '李四', '发', '阿斯顿发', '儿童椅', '女', '2018-05-07', '蒙古族', '阿斯顿发', '撒旦法', '阿尔亲爱的师傅', '为二位', '发送到', null, null);
INSERT INTO "TEST_GS"."GUEST_INFO" VALUES ('7', '张三', '经理', '主管', '阿斯突然有吗', '男', '2018-05-14', '蒙古族', '发生', '地方', '发多少', '阿斯顿发我让育儿', '阿斯顿发', '../../guest/img/1527921710478_476.png', null);
INSERT INTO "TEST_GS"."GUEST_INFO" VALUES ('10', '嘉佳', '发', '阿斯顿发', '儿童椅', '女', '2018-05-07', '蒙古族', '阿斯顿发', '撒旦法', '阿尔亲爱的师傅', '为二位', '发送到', null, null);
INSERT INTO "TEST_GS"."GUEST_INFO" VALUES ('11', '张三', '经理', '主管', '阿斯突然有吗', '男', '2018-05-14', '蒙古族', '发生', '地方', '发多少', '阿斯顿发我让育儿', '阿斯顿发', null, null);
INSERT INTO "TEST_GS"."GUEST_INFO" VALUES ('12', '李四', '发', '阿斯顿发', '儿童椅', '女', '2018-05-07', '蒙古族', '阿斯顿发', '撒旦法', '阿尔亲爱的师傅', '为二位', '发送到', null, null);
INSERT INTO "TEST_GS"."GUEST_INFO" VALUES ('13', '张三', '经理', '主管', '阿斯突然有吗', '男', '2018-05-14', '蒙古族', '发生', '地方', '发多少', '阿斯顿发我让育儿', '阿斯顿发', null, null);
INSERT INTO "TEST_GS"."GUEST_INFO" VALUES ('14', '张三', '经理', '主管', '阿斯突然有吗', '男', '2018-05-14', '蒙古族', '发生', '地方', '发多少', '阿斯顿发我让育儿', '阿斯顿发', null, null);
INSERT INTO "TEST_GS"."GUEST_INFO" VALUES ('15', '嘉佳', '发', '阿斯顿发', '儿童椅', '女', '2018-05-07', '蒙古族', '阿斯顿发', '撒旦法', '阿尔亲爱的师傅', '为二位', '发送到', null, null);
INSERT INTO "TEST_GS"."GUEST_INFO" VALUES ('16', '李四', '发', '阿斯顿发', '儿童椅', '女', '2018-05-07', '蒙古族', '阿斯顿发', '撒旦法', '阿尔亲爱的师傅', '为二位', '发送到', null, null);
INSERT INTO "TEST_GS"."GUEST_INFO" VALUES ('17', '张三', '经理', '主管', '阿斯突然有吗', '男', '2018-05-14', '蒙古族', '发生', '地方', '发多少', '阿斯顿发我让育儿', '阿斯顿发', null, null);
INSERT INTO "TEST_GS"."GUEST_INFO" VALUES ('18', '嘉佳', '发', '阿斯顿发', '儿童椅', '女', '2018-05-07', '蒙古族', '阿斯顿发', '撒旦法', '阿尔亲爱的师傅', '为二位', '发送到', null, null);
INSERT INTO "TEST_GS"."GUEST_INFO" VALUES ('4', '李四', '发', '阿斯顿发', '儿童椅', '女', '2018-05-07', '蒙古族', '阿斯顿发', '撒旦法', '阿尔亲爱的师傅', '为二位', '发送到', '../../guest/img/1527910949483_892.png', null);
INSERT INTO "TEST_GS"."GUEST_INFO" VALUES ('5', '张三', '经理', '主管', '阿斯突然有吗', '男', '2018-05-14', '蒙古族', '发生', '地方', '发多少', '阿斯顿发我让育儿', '阿斯顿发', '../../guest/img/1527921670951_207.png', null);
INSERT INTO "TEST_GS"."GUEST_INFO" VALUES ('6', '嘉佳', '发', '阿斯顿发', '儿童椅', '女', '2018-05-07', '蒙古族', '阿斯顿发', '撒旦法', '阿尔亲爱的师傅', '为二位', '发送到', null, null);

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
INSERT INTO "TEST_GS"."HOTEL_INFO" VALUES ('2', '光明大酒店', '王海锋', '18919375595', '0937-2807777', '肃州区', '甘肃省酒泉市肃州区盘旋中路18号', null, null);
INSERT INTO "TEST_GS"."HOTEL_INFO" VALUES ('3', '宏兴大酒店', '陈浩', '18919427777', '0937-2802222', '肃州区', '甘肃省酒泉市肃州区盘旋西路7号', null, null);
INSERT INTO "TEST_GS"."HOTEL_INFO" VALUES ('1', '东方国际大酒店', '马艳玲', '18193748166', '0937-2699999', '敦煌', '酒泉市肃州区仓门街6号', null, '11111');
INSERT INTO "TEST_GS"."HOTEL_INFO" VALUES ('4', '惠城大酒店', '马春梅', '18093729288', '0937-2671616', '玉门市', '酒泉市新城区莫高路16号', null, null);
INSERT INTO "TEST_GS"."HOTEL_INFO" VALUES ('5', '敦煌华夏国际大酒店', '侯红林', '13519375666', '0937-8887110', '敦煌', '甘肃省酒泉市敦煌市敦月公路中端888号', null, null);
INSERT INTO "TEST_GS"."HOTEL_INFO" VALUES ('6', '敦煌国际大酒店', '叶彦萍', '13993722999', '0397-8821821', '敦煌', '甘肃省酒泉市敦煌市鸣山北路827号', null, null);
INSERT INTO "TEST_GS"."HOTEL_INFO" VALUES ('7', '敦煌天润大酒店', '权玉霞', '18993732897', '0937-8819501', '敦煌', '甘肃省酒泉市敦煌市鸣山路309号', null, null);
INSERT INTO "TEST_GS"."HOTEL_INFO" VALUES ('8', '敦煌太阳大酒店', '张春艳', '13893726729', '0937-8841858', '敦煌', null, null, null);

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
COMMENT ON COLUMN "TEST_GS"."HOTEL_PLANE_GRAPH"."FLOOR" IS '所属酒店';
COMMENT ON COLUMN "TEST_GS"."HOTEL_PLANE_GRAPH"."HOTEL" IS '所属酒店';

-- ----------------------------
-- Records of HOTEL_PLANE_GRAPH
-- ----------------------------
INSERT INTO "TEST_GS"."HOTEL_PLANE_GRAPH" VALUES ('4', '七楼平面图', '1527669881124_526.png', '7', '1');
INSERT INTO "TEST_GS"."HOTEL_PLANE_GRAPH" VALUES ('3', '光明大酒店', '1527666905654_786.png', '2', '1');
INSERT INTO "TEST_GS"."HOTEL_PLANE_GRAPH" VALUES ('5', '{3B07188B-5C96-4120-81DE-AC5631EA9DDB}_光明大酒店', '1527908529290_705.png', null, '2');
INSERT INTO "TEST_GS"."HOTEL_PLANE_GRAPH" VALUES ('6', '{3B07188B-5C96-4120-81DE-AC5631EA9DDB}_光明大酒店', '1527909922561_994.png', null, '2');
INSERT INTO "TEST_GS"."HOTEL_PLANE_GRAPH" VALUES ('7', '{3B07188B-5C96-4120-81DE-AC5631EA9DDB}_光明大酒店', '1527910122898_290.png', null, '2');
INSERT INTO "TEST_GS"."HOTEL_PLANE_GRAPH" VALUES ('2', '五楼会议室平面图', '1527473064725_506.png', '5', '1');

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
INSERT INTO "TEST_GS"."MEALS_RECORD" VALUES ('3727bf7de3d94c0886c5cf4d2598ff32', 'JD20180514030518', 'B单', '东方国际大酒店', '2', '无', TO_DATE('2018-05-14 15:16:18', 'YYYY-MM-DD HH24:MI:SS'), '空');
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
INSERT INTO "TEST_GS"."MENU_INFO" VALUES ('2', 'T00005', 'A单', '一般套餐', '东方国际大酒店', '正餐', '自助餐', '30', null);
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
INSERT INTO "TEST_GS"."RECEPTION_RECORD" VALUES ('5', 'JD20180514030518', '接待', '2018-05-14', '等等', '等等', '天天', '等等', '1', '1', '1', '东方国际大酒店', '等等', TO_DATE('2018-05-14 15:16:18', 'YYYY-MM-DD HH24:MI:SS'), '等等');
INSERT INTO "TEST_GS"."RECEPTION_RECORD" VALUES ('6', 'JD20180515090513', '接待一号', '2018-05-17', '很多人', null, '刘东', '没有', '5', '5', '5', '东方国际大酒店', null, TO_DATE('2018-05-15 09:58:13', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "TEST_GS"."RECEPTION_RECORD" VALUES ('4', 'JD20180513100501', '领导视察', '2018-05-13', '10', '李丹丹', '嘉佳', '某哦某', '10', '12', '5', '东方国际大酒店', '没有', TO_DATE('2018-05-13 10:56:01', 'YYYY-MM-DD HH24:MI:SS'), '无');

-- ----------------------------
-- Table structure for RESTAURANT_INFO
-- ----------------------------
DROP TABLE "TEST_GS"."RESTAURANT_INFO";
CREATE TABLE "TEST_GS"."RESTAURANT_INFO" (
"ID" NUMBER(20) NOT NULL ,
"RESTAURANT_NUMBER" NUMBER(20) NULL ,
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
INSERT INTO "TEST_GS"."RESTAURANT_INFO" VALUES ('1528266322493', '1', '自助擦你体内', '自助餐厅', '东方国际大酒店', '南', '1', '12', '开放', null);

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
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('118', '101', '东方国际大酒店', '1', '商务单间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '是', '空闲', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('119', '102', '东方国际大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '没有', '没有', '没有', '111', '111', '是', '空闲', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('120', '102', '东方国际大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '没有', '没有', '没有', '111', '111', '是', '空闲', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('128', '201', '东方国际大酒店', '2', '普通标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('129', '202', '东方国际大酒店', '2', '普通标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('130', '202', '东方国际大酒店', '2', '普通标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('131', '301', '东方国际大酒店', '3', '普通标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', null, '111', '否', '空闲', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('132', '301', '东方国际大酒店', '3', '普通标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', null, '111', '否', '空闲', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('133', '303', '东方国际大酒店', '3', '普通标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', null, '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('134', '303', '东方国际大酒店', '3', '普通标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', null, '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('135', '303', '东方国际大酒店', '3', '普通标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', null, '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('136', '303', '东方国际大酒店', '3', '普通标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', null, '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('137', '303', '东方国际大酒店', '3', '普通标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', null, '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('138', '303', '东方国际大酒店', '3', '普通标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', null, '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('139', '303', '东方国际大酒店', '3', '普通标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', null, '111', '否', '空闲', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('140', '303', '东方国际大酒店', '3', '普通标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', null, '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('141', '102', '光明大酒店', '1', '商务标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '222', '222', '否', '空闲', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('142', '102', '光明大酒店', '1', '商务标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '222', '222', '否', '空闲', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('143', '102', '光明大酒店', '1', '商务标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '222', '222', '否', '空闲', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('144', '102', '光明大酒店', '1', '商务标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '222', '222', '否', '空闲', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('145', '102', '光明大酒店', '1', '商务标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '222', '222', '否', '空闲', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('146', '102', '光明大酒店', '1', '商务标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '222', '222', '否', '空闲', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('147', '102', '光明大酒店', '1', '商务标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '222', '222', '否', '空闲', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('148', '102', '光明大酒店', '1', '商务标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '222', '222', '否', '空闲', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('149', '102', '光明大酒店', '1', '商务标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '222', '222', '否', '空闲', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('150', '102', '光明大酒店', '1', '商务标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '222', '222', '否', '空闲', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('151', '111', '光明大酒店', '1', '商务单间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('152', '111', '光明大酒店', '1', '商务单间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('153', '111', '光明大酒店', '1', '商务单间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('154', '111', '光明大酒店', '1', '商务单间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('155', '111', '光明大酒店', '1', '商务单间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('156', '111', '光明大酒店', '1', '商务单间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('157', '111', '光明大酒店', '1', '商务单间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('158', '111', '光明大酒店', '1', '商务单间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('159', '112', '光明大酒店', '1', '商务单间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('160', '112', '光明大酒店', '1', '商务单间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('161', '202', '光明大酒店', '2', '商务单间', '有噪音', '南', '电脑', '没有', '123456323', null, '我', null, null, '否', '预定', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('162', '202', '光明大酒店', '2', '商务单间', '有噪音', '南', '电脑', '没有', '123456323', null, '我', null, null, '否', '预定', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('163', '202', '光明大酒店', '2', '商务单间', '有噪音', '南', '电脑', '没有', '123456323', null, '我', null, null, '否', '预定', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('164', '202', '光明大酒店', '2', '商务单间', '有噪音', '南', '电脑', '没有', '123456323', null, '我', null, null, '否', '预定', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('165', '202', '光明大酒店', '2', '商务单间', '有噪音', '南', '电脑', '没有', '123456323', null, '我', null, null, '否', '预定', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('166', '202', '光明大酒店', '2', '商务单间', '有噪音', '南', '电脑', '没有', '123456323', null, '我', null, null, '否', '预定', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('167', '202', '光明大酒店', '2', '商务单间', '有噪音', '南', '电脑', '没有', '123456323', null, '我', null, null, '否', '预定', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('168', '202', '光明大酒店', '2', '商务单间', '有噪音', '南', '电脑', '没有', '123456323', null, '我', null, null, '否', '预定', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('169', '202', '光明大酒店', '2', '商务单间', '有噪音', '南', '电脑', '没有', '123456323', null, '我', null, null, '否', '预定', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('170', '202', '光明大酒店', '2', '商务单间', '有噪音', '南', '电脑', '没有', '123456323', null, '我', null, null, '否', '预定', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('171', '111', '宏兴大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '123', '123', '没有', '123', '1231', '否', '预定', '11');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('172', '111', '宏兴大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '123', '123', '没有', '123', '1231', '否', '预定', '11');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('173', '111', '宏兴大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '123', '123', '没有', '123', '1231', '否', '预定', '11');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('174', '111', '宏兴大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '123', '123', '没有', '123', '1231', '否', '预定', '11');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('175', '111', '宏兴大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '123', '123', '没有', '123', '1231', '否', '预定', '11');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('176', '111', '宏兴大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '123', '123', '没有', '123', '1231', '否', '预定', '11');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('177', '111', '宏兴大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '123', '123', '没有', '123', '1231', '否', '预定', '11');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('178', '111', '宏兴大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '123', '123', '没有', '123', '1231', '否', '预定', '11');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('179', '111', '宏兴大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '123', '123', '没有', '123', '1231', '否', '预定', '11');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('180', '111', '宏兴大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '123', '123', '没有', '123', '1231', '否', '预定', '11');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('181', '101', '敦煌国际大酒店', '1', '豪华套间', null, '南', null, null, '11111111', '22222222', '小波', '1212', '1232', '否', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('36', '111', '宏兴大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '123', '123', '没有', '123', '1231', '否', '预定', '11');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('47', '101', '东方国际大酒店', '1', '商务标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '是', '空闲', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('48', '201', '东方国际大酒店', '2', '普通标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('49', '303', '东方国际大酒店', '3', '普通标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', null, '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('50', '102', '光明大酒店', '1', '商务标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '222', '222', '否', '空闲', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('51', '111', '光明大酒店', '1', '商务单间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('52', '202', '光明大酒店', '2', '商务单间', '有噪音', '南', '电脑', '没有', '123456323', null, '我', null, null, '否', '预定', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('53', '111', '宏兴大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '123', '123', '没有', '123', '1231', '否', '预定', '11');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('54', '101', '敦煌国际大酒店', '1', '豪华套间', null, '南', null, null, '11111111', '22222222', '小波', '1212', '1232', '否', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('55', '101', '东方国际大酒店', '1', '商务标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '是', '空闲', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('56', '201', '东方国际大酒店', '2', '普通标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('57', '303', '东方国际大酒店', '3', '普通标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', null, '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('58', '102', '光明大酒店', '1', '商务标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '222', '222', '否', '空闲', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('59', '111', '光明大酒店', '1', '商务单间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('60', '202', '光明大酒店', '2', '商务单间', '有噪音', '南', '电脑', '没有', '123456323', null, '我', null, null, '否', '预定', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('61', '111', '宏兴大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '123', '123', '没有', '123', '1231', '否', '预定', '11');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('62', '101', '敦煌国际大酒店', '1', '豪华套间', null, '南', null, null, '11111111', '22222222', '小波', '1212', '1232', '否', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('63', '101', '东方国际大酒店', '1', '商务标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '是', '空闲', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('64', '201', '东方国际大酒店', '2', '普通标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('65', '303', '东方国际大酒店', '3', '普通标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', null, '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('66', '102', '光明大酒店', '1', '商务标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '222', '222', '否', '空闲', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('67', '111', '光明大酒店', '1', '商务单间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('68', '202', '光明大酒店', '2', '商务单间', '有噪音', '南', '电脑', '没有', '123456323', null, '我', null, null, '否', '预定', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('69', '111', '宏兴大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '123', '123', '没有', '123', '1231', '否', '预定', '11');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('70', '101', '敦煌国际大酒店', '1', '豪华套间', null, '南', null, null, '11111111', '22222222', '小波', '1212', '1232', '否', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('71', '101', '东方国际大酒店', '1', '商务标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '是', '空闲', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('72', '101', '东方国际大酒店', '1', '商务标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '是', '空闲', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('73', '101', '东方国际大酒店', '1', '商务单间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '是', '空闲', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('74', '101', '东方国际大酒店', '1', '商务标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '是', '空闲', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('75', '102', '东方国际大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '没有', '没有', '没有', '111', '111', '是', '空闲', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('76', '201', '东方国际大酒店', '2', '普通标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('77', '201', '东方国际大酒店', '2', '普通标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('78', '201', '东方国际大酒店', '2', '普通标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('79', '201', '东方国际大酒店', '2', '普通标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('80', '202', '东方国际大酒店', '2', '普通标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('81', '301', '东方国际大酒店', '3', '普通标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', null, '111', '否', '空闲', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('82', '303', '东方国际大酒店', '3', '普通标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', null, '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('83', '303', '东方国际大酒店', '3', '普通标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', null, '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('84', '303', '东方国际大酒店', '3', '普通标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', null, '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('85', '303', '东方国际大酒店', '3', '普通标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', null, '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('86', '102', '光明大酒店', '1', '商务标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '222', '222', '否', '空闲', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('87', '102', '光明大酒店', '1', '商务标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '222', '222', '否', '空闲', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('88', '102', '光明大酒店', '1', '商务标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '222', '222', '否', '空闲', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('89', '102', '光明大酒店', '1', '商务标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '222', '222', '否', '空闲', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('90', '102', '光明大酒店', '1', '商务标间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '222', '222', '否', '空闲', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('91', '111', '光明大酒店', '1', '商务单间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('92', '111', '光明大酒店', '1', '商务单间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('93', '111', '光明大酒店', '1', '商务单间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('94', '111', '光明大酒店', '1', '商务单间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('95', '112', '光明大酒店', '1', '商务单间', '没有', '南', '没有', '没有', '没有', '没有', '没有', '111', '111', '否', '预定', '没有');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('96', '202', '光明大酒店', '2', '商务单间', '有噪音', '南', '电脑', '没有', '123456323', null, '我', null, null, '否', '预定', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('97', '202', '光明大酒店', '2', '商务单间', '有噪音', '南', '电脑', '没有', '123456323', null, '我', null, null, '否', '预定', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('98', '202', '光明大酒店', '2', '商务单间', '有噪音', '南', '电脑', '没有', '123456323', null, '我', null, null, '否', '预定', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('99', '202', '光明大酒店', '2', '商务单间', '有噪音', '南', '电脑', '没有', '123456323', null, '我', null, null, '否', '预定', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('352', null, '敦煌太阳大酒店', '1', '普通标间', null, null, null, null, null, null, null, null, null, '是', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('353', null, '敦煌太阳大酒店', '1', '普通标间', null, null, null, null, null, null, null, null, null, '是', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('351', null, '敦煌太阳大酒店', '1', '普通标间', null, null, null, null, null, null, null, null, null, '是', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('354', null, '敦煌太阳大酒店', '1', '普通标间', null, null, null, null, null, null, null, null, null, '是', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('355', null, '敦煌太阳大酒店', '1', '普通标间', null, null, null, null, null, null, null, null, null, '是', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('366', null, '东方国际大酒店', '1', '普通标间', null, '东', null, null, null, null, null, null, null, '是', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('367', null, '东方国际大酒店', '1', '普通标间', null, '东', null, null, null, null, null, null, null, '是', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('368', null, '东方国际大酒店', '1', '普通标间', null, '东', null, null, null, null, null, null, null, '是', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('369', null, '东方国际大酒店', '1', '普通标间', null, '东', null, null, null, null, null, null, null, '是', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('370', null, '东方国际大酒店', '1', '普通标间', null, '东', null, null, null, null, null, null, null, '是', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('371', null, '东方国际大酒店', '1', '普通标间', null, '西', null, null, null, null, null, null, null, '是', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('372', null, '东方国际大酒店', '1', '普通标间', null, '西', null, null, null, null, null, null, null, '是', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('373', null, '东方国际大酒店', '1', '普通标间', null, '西', null, null, null, null, null, null, null, '是', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('374', null, '东方国际大酒店', '1', '普通标间', null, '西', null, null, null, null, null, null, null, '是', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('375', null, '东方国际大酒店', '1', '普通标间', null, '西', null, null, null, null, null, null, null, '是', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('376', null, '东方国际大酒店', '1', '普通标间', null, '西', null, null, null, null, null, null, null, '是', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('377', null, '东方国际大酒店', '1', '普通标间', null, '东', null, null, null, null, null, null, null, '是', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('357', null, '敦煌天润大酒店', '1', '普通标间', null, null, null, null, null, null, null, null, null, '是', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('358', null, '敦煌天润大酒店', '1', '普通标间', null, null, null, null, null, null, null, null, null, '是', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('356', null, '敦煌天润大酒店', '1', '普通标间', null, null, null, null, null, null, null, null, null, '是', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('359', null, '敦煌天润大酒店', '1', '普通标间', null, null, null, null, null, null, null, null, null, '是', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('360', null, '敦煌天润大酒店', '1', '普通标间', null, null, null, null, null, null, null, null, null, '是', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('361', null, '敦煌天润大酒店', '1', '普通标间', null, null, null, null, null, null, null, null, null, '是', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('362', null, '敦煌天润大酒店', '1', '普通标间', null, null, null, null, null, null, null, null, null, '是', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('363', null, '敦煌天润大酒店', '1', '普通标间', null, null, null, null, null, null, null, null, null, '是', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('364', null, '敦煌天润大酒店', '1', '普通标间', null, null, null, null, null, null, null, null, null, '是', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('365', null, '敦煌天润大酒店', '1', '普通标间', null, null, null, null, null, null, null, null, null, '是', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('306', '202', '光明大酒店', '2', '商务单间', '有噪音', '南', '电脑', '没有', '123456323', null, '我', null, null, '否', '预定', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('307', '202', '光明大酒店', '2', '商务单间', '有噪音', '南', '电脑', '没有', '123456323', null, '我', null, null, '否', '预定', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('308', '202', '光明大酒店', '2', '商务单间', '有噪音', '南', '电脑', '没有', '123456323', null, '我', null, null, '否', '预定', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('309', '202', '光明大酒店', '2', '商务单间', '有噪音', '南', '电脑', '没有', '123456323', null, '我', null, null, '否', '预定', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('310', '202', '光明大酒店', '2', '商务单间', '有噪音', '南', '电脑', '没有', '123456323', null, '我', null, null, '否', '预定', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('311', '111', '宏兴大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '123', '123', '没有', '123', '1231', '否', '预定', '11');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('312', '111', '宏兴大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '123', '123', '没有', '123', '1231', '否', '预定', '11');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('313', '111', '宏兴大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '123', '123', '没有', '123', '1231', '否', '预定', '11');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('314', '111', '宏兴大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '123', '123', '没有', '123', '1231', '否', '预定', '11');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('315', '111', '宏兴大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '123', '123', '没有', '123', '1231', '否', '预定', '11');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('316', '111', '宏兴大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '123', '123', '没有', '123', '1231', '否', '预定', '11');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('317', '111', '宏兴大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '123', '123', '没有', '123', '1231', '否', '预定', '11');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('318', '111', '宏兴大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '123', '123', '没有', '123', '1231', '否', '预定', '11');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('319', '111', '宏兴大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '123', '123', '没有', '123', '1231', '否', '预定', '11');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('320', '111', '宏兴大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '123', '123', '没有', '123', '1231', '否', '预定', '11');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('321', '111', '宏兴大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '123', '123', '没有', '123', '1231', '否', '预定', '11');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('322', '111', '宏兴大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '123', '123', '没有', '123', '1231', '否', '预定', '11');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('323', '111', '宏兴大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '123', '123', '没有', '123', '1231', '否', '预定', '11');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('324', '111', '宏兴大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '123', '123', '没有', '123', '1231', '否', '预定', '11');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('325', '111', '宏兴大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '123', '123', '没有', '123', '1231', '否', '预定', '11');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('326', '111', '宏兴大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '123', '123', '没有', '123', '1231', '否', '预定', '11');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('327', '111', '宏兴大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '123', '123', '没有', '123', '1231', '否', '预定', '11');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('328', '111', '宏兴大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '123', '123', '没有', '123', '1231', '否', '预定', '11');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('329', '111', '宏兴大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '123', '123', '没有', '123', '1231', '否', '预定', '11');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('330', '111', '宏兴大酒店', '1', '商务标间', '没有', '北', '没有', '没有', '123', '123', '没有', '123', '1231', '否', '预定', '11');
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('331', '101', '敦煌国际大酒店', '1', '豪华套间', null, '南', null, null, '11111111', '22222222', '小波', '1212', '1232', '否', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('332', '101', '敦煌国际大酒店', '1', '豪华套间', null, '南', null, null, '11111111', '22222222', '小波', '1212', '1232', '否', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('333', '101', '敦煌国际大酒店', '1', '豪华套间', null, '南', null, null, '11111111', '22222222', '小波', '1212', '1232', '否', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('334', '101', '敦煌国际大酒店', '1', '豪华套间', null, '南', null, null, '11111111', '22222222', '小波', '1212', '1232', '否', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('335', '101', '敦煌国际大酒店', '1', '豪华套间', null, '南', null, null, '11111111', '22222222', '小波', '1212', '1232', '否', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('336', '101', '敦煌国际大酒店', '1', '豪华套间', null, '南', null, null, '11111111', '22222222', '小波', '1212', '1232', '否', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('337', '101', '敦煌国际大酒店', '1', '豪华套间', null, '南', null, null, '11111111', '22222222', '小波', '1212', '1232', '否', '预定', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('338', '101', '敦煌国际大酒店', '1', '豪华套间', null, '南', null, null, '11111111', '22222222', '小波', '1212', '1232', '否', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('339', '101', '敦煌国际大酒店', '1', '豪华套间', null, '南', null, null, '11111111', '22222222', '小波', '1212', '1232', '否', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('340', '101', '敦煌国际大酒店', '1', '豪华套间', null, '南', null, null, '11111111', '22222222', '小波', '1212', '1232', '否', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('341', '101', '敦煌国际大酒店', '1', '豪华套间', null, '南', null, null, '11111111', '22222222', '小波', '1212', '1232', '否', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('342', '101', '敦煌国际大酒店', '1', '豪华套间', null, '南', null, null, '11111111', '22222222', '小波', '1212', '1232', '否', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('343', '101', '敦煌国际大酒店', '1', '豪华套间', null, '南', null, null, '11111111', '22222222', '小波', '1212', '1232', '否', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('344', '101', '敦煌国际大酒店', '1', '豪华套间', null, '南', null, null, '11111111', '22222222', '小波', '1212', '1232', '否', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('345', '101', '敦煌国际大酒店', '1', '豪华套间', null, '南', null, null, '11111111', '22222222', '小波', '1212', '1232', '否', '预定', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('346', '101', '敦煌国际大酒店', '1', '豪华套间', null, '南', null, null, '11111111', '22222222', '小波', '1212', '1232', '否', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('347', '101', '敦煌国际大酒店', '1', '豪华套间', null, '南', null, null, '11111111', '22222222', '小波', '1212', '1232', '否', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('348', '101', '敦煌国际大酒店', '1', '豪华套间', null, '南', null, null, '11111111', '22222222', '小波', '1212', '1232', '否', '空闲', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('349', '101', '敦煌国际大酒店', '1', '豪华套间', null, '南', null, null, '11111111', '22222222', '小波', '1212', '1232', '否', '预定', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('350', '101', '敦煌国际大酒店', '1', '豪华套间', null, '南', null, null, '11111111', '22222222', '小波', '1212', '1232', '否', '预定', null);
INSERT INTO "TEST_GS"."ROOM_INFO" VALUES ('378', '123', '东方国际大酒店', '1', '普通标间', null, '北', null, null, null, null, null, null, null, '是', '空闲', null);

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
"REMARK" NVARCHAR2(255) NULL ,
"DELETE_FLAG" VARCHAR2(10 BYTE) DEFAULT 1  NULL 
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
COMMENT ON COLUMN "TEST_GS"."SYS_MODULE"."DELETE_FLAG" IS '可删除标识  0为不可删除 1为可删除';

-- ----------------------------
-- Records of SYS_MODULE
-- ----------------------------
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('22', '会议室使用记录', '22', '7', '../conference/conferenceRecordInfo.html', '4', TO_DATE('2018-05-29 09:40:04', 'YYYY-MM-DD HH24:MI:SS'), 'hysxxgl', null, '0');
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('1', '系统管理', '1', '0', null, '4', TO_DATE('2018-05-17 16:44:17', 'YYYY-MM-DD HH24:MI:SS'), 'xtgl', null, '0');
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('2', '用户设置', '2', '1', '../system/userSheZhi.html', '1', TO_DATE('2018-05-17 16:44:17', 'YYYY-MM-DD HH24:MI:SS'), 'yhsz', null, '0');
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('3', '角色设置', '3', '1', '../system/roleSheZhi.html', '2', TO_DATE('2018-05-17 16:44:17', 'YYYY-MM-DD HH24:MI:SS'), 'jssz', null, '0');
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('4', '模块设置', '4', '1', '../system/module.html', '3', TO_DATE('2018-05-17 16:44:17', 'YYYY-MM-DD HH24:MI:SS'), 'mksz', null, '0');
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('5', '操作日志', '5', '1', '../log/operate_log.html', '4', TO_DATE('2018-05-17 16:44:17', 'YYYY-MM-DD HH24:MI:SS'), 'czrz', null, '0');
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('6', '数据库监控', '6', '1', '../../druid/index.html', '5', TO_DATE('2018-05-17 16:44:17', 'YYYY-MM-DD HH24:MI:SS'), 'sjkpz', '../system/configure.html', '0');
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('7', '接待管理', '7', '0', null, '1', TO_DATE('2018-05-17 16:44:17', 'YYYY-MM-DD HH24:MI:SS'), 'jdgl', null, '0');
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('8', '接待登记', '8', '7', '../reception/register.html', '1', TO_DATE('2018-05-17 16:44:17', 'YYYY-MM-DD HH24:MI:SS'), 'jddj', null, '0');
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('9', '接待信息', '9', '7', '../reception/receptionManage.html', '2', TO_DATE('2018-05-17 16:44:17', 'YYYY-MM-DD HH24:MI:SS'), 'jdxxgl', null, '0');
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('10', '酒店管理', '10', '0', null, '2', TO_DATE('2018-05-17 16:44:17', 'YYYY-MM-DD HH24:MI:SS'), 'Jdgl', null, '0');
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('11', '酒店信息设置', '11', '10', '../hotel/HotelManage.html', '1', TO_DATE('2018-05-17 16:44:17', 'YYYY-MM-DD HH24:MI:SS'), 'Jdxxgl', null, '0');
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('12', '房间信息设置', '12', '10', '../hotel/roomManage.html', '2', TO_DATE('2018-05-17 16:44:17', 'YYYY-MM-DD HH24:MI:SS'), 'fjxxgl', null, '0');
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('13', '会议室信息设置', '13', '10', '../conference/conferenceInfo.html', '3', TO_DATE('2018-05-17 16:44:17', 'YYYY-MM-DD HH24:MI:SS'), 'hysxxgl', null, '0');
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('14', '会议室使用登记', '14', '7', '../reception/boardroomManage.html', '3', TO_DATE('2018-05-17 16:44:17', 'YYYY-MM-DD HH24:MI:SS'), 'hyssyjl', null, '0');
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('15', '套餐菜品设置', '15', '10', '../menu/menuInformation.html', '4', TO_DATE('2018-05-17 16:44:17', 'YYYY-MM-DD HH24:MI:SS'), 'tccpxxgl', null, '0');
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('17', '数据字典维护', '17', '1', '../system/weiHu.html', '6', TO_DATE('2018-05-17 16:44:17', 'YYYY-MM-DD HH24:MI:SS'), 'sjzdwh', null, '0');
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('18', '宾客管理', '18', '0', null, '3', TO_DATE('2018-05-17 16:44:17', 'YYYY-MM-DD HH24:MI:SS'), 'bkxxgl', null, '0');
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('19', '宾客信息设置', '19', '18', '../guest/guestInformation.html', '1', TO_DATE('2018-05-17 16:44:17', 'YYYY-MM-DD HH24:MI:SS'), 'bkxxgl', null, '0');
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('20', '酒店对比', '20', '10', '../hotel/HotelContrasts.html', '6', TO_DATE('2018-05-17 16:44:17', 'YYYY-MM-DD HH24:MI:SS'), 'Jddb', null, '0');
INSERT INTO "TEST_GS"."SYS_MODULE" VALUES ('21', '餐厅(包厢)信息设置', '21', '10', '../conference/restaurantInfo.html', '5', TO_DATE('2018-05-17 16:44:17', 'YYYY-MM-DD HH24:MI:SS'), 'fjxxgl', null, '0');

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
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('19', 'admin', '查询个案信息', null, '2018-05-25 18:33:50', 'DESKTOP-VTDU3JD:10.1.92.8', null, '查询宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('20', 'admin', '查询个案信息', null, '2018-05-25 18:33:55', 'DESKTOP-VTDU3JD:10.1.92.8', null, '查询宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('18', 'admin', '查询信息', null, '2018-05-25 18:33:46', 'DESKTOP-VTDU3JD:10.1.92.8', null, '查询宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('21', 'admin', '酒店信息', null, '2018-05-28 10:50:35', 'DESKTOP-VTDU3JD:10.1.92.8', null, '删除酒店');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('22', 'admin', '宾客信息', null, '2018-05-28 11:05:25', 'B0IM0BCXLXU54ZS:10.1.92.7', null, '新增宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('37', 'admin', '宾客信息', null, '2018-05-28 15:16:13', 'DESKTOP-VTDU3JD:10.1.92.8', null, '导出宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('38', 'admin', '酒店信息', null, '2018-05-28 15:16:41', 'DESKTOP-VTDU3JD:10.1.92.8', null, '导入酒店信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('40', 'admin', '宾客信息', null, '2018-05-28 15:17:27', 'DESKTOP-VTDU3JD:10.1.92.8', null, '删除宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('45', 'admin', '房间信息', null, '2018-05-28 15:36:41', 'DESKTOP-VTDU3JD:10.1.92.8', null, '导入房间信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('46', 'admin', '房间信息', null, '2018-05-28 15:37:04', 'DESKTOP-VTDU3JD:10.1.92.8', null, '导入房间信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('49', 'admin', '宾客信息', null, '2018-06-02 11:02:46', 'DESKTOP-VTDU3JD:10.1.92.8', null, '修改宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('66', 'admin', '宾客信息', null, '2018-06-02 14:56:02', 'DESKTOP-VTDU3JD:10.1.92.8', null, '导出宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('67', 'admin', '酒店信息', null, '2018-06-05 17:32:14', 'DESKTOP-VTDU3JD:10.1.92.8', null, '添加酒店');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('68', 'admin', '酒店信息', null, '2018-06-05 17:32:36', 'DESKTOP-VTDU3JD:10.1.92.8', null, '添加酒店');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('69', 'admin', '酒店信息', null, '2018-06-05 17:33:37', 'DESKTOP-VTDU3JD:10.1.92.8', null, '添加酒店');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('70', 'admin', '酒店信息', null, '2018-06-05 17:34:19', 'DESKTOP-VTDU3JD:10.1.92.8', null, '添加酒店');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('72', 'admin', '酒店信息', null, '2018-06-05 17:39:37', 'DESKTOP-VTDU3JD:10.1.92.8', null, '删除酒店');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('73', 'admin', '酒店信息', null, '2018-06-05 17:39:44', 'DESKTOP-VTDU3JD:10.1.92.8', null, '导出酒店信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('31', 'admin', '宾客信息', null, '2018-05-28 14:22:19', 'B0IM0BCXLXU54ZS:10.1.92.7', null, '删除宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('32', 'admin', '宾客信息', null, '2018-05-28 14:22:30', 'B0IM0BCXLXU54ZS:10.1.92.7', null, '修改宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('11', 'admin', '用户设置', null, '2018-05-22 11:41:48', 'DESKTOP-VTDU3JD:10.1.92.8', null, '修改用户');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('33', 'admin', '宾客信息', null, '2018-05-28 14:23:29', 'B0IM0BCXLXU54ZS:10.1.92.7', null, '修改宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('34', 'admin', '宾客信息', null, '2018-05-28 14:47:55', 'B0IM0BCXLXU54ZS:10.1.92.7', null, '删除宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('35', 'admin', '宾客信息', null, '2018-05-28 14:57:54', 'B0IM0BCXLXU54ZS:10.1.92.7', null, '导出宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('36', 'admin', '宾客信息', null, '2018-05-28 15:06:20', 'B0IM0BCXLXU54ZS:10.1.92.7', null, '修改宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('39', 'admin', '宾客信息', null, '2018-05-28 15:17:13', 'DESKTOP-VTDU3JD:10.1.92.8', null, '修改宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('41', 'admin', '房间信息', null, '2018-05-28 15:31:42', 'DESKTOP-VTDU3JD:10.1.92.8', null, '导入房间信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('42', 'admin', '房间信息', null, '2018-05-28 15:31:59', 'DESKTOP-VTDU3JD:10.1.92.8', null, '导入房间信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('43', 'admin', '房间信息', null, '2018-05-28 15:33:15', 'DESKTOP-VTDU3JD:10.1.92.8', null, '导入房间信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('44', 'admin', '房间信息', null, '2018-05-28 15:33:30', 'DESKTOP-VTDU3JD:10.1.92.8', null, '导入房间信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('51', 'admin', '宾客信息', null, '2018-06-02 11:35:09', 'DESKTOP-VTDU3JD:10.1.92.8', null, '修改宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('52', 'admin', '宾客信息', null, '2018-06-02 11:42:31', 'DESKTOP-VTDU3JD:10.1.92.8', null, '修改宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('12', 'www', '修改密码', null, '2018-05-23 10:09:06', 'DESKTOP-VTDU3JD:10.1.92.8', null, '用户修改密码');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('13', 'www', '修改密码', null, '2018-05-23 10:09:56', 'DESKTOP-VTDU3JD:10.1.92.8', null, '用户修改密码');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('14', 'www', '修改密码', null, '2018-05-23 10:12:52', 'DESKTOP-VTDU3JD:10.1.92.8', null, '用户修改密码');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('15', 'admin', '模块设置', null, '2018-05-23 10:54:44', 'DESKTOP-VTDU3JD:10.1.92.8', null, '修改模块');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('16', 'admin', '模块设置', null, '2018-05-23 10:54:57', 'DESKTOP-VTDU3JD:10.1.92.8', null, '修改模块');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('29', 'admin', '宾客信息', null, '2018-05-28 13:10:43', 'B0IM0BCXLXU54ZS:10.1.92.7', null, '修改宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('30', 'admin', '宾客信息', null, '2018-05-28 13:12:24', 'B0IM0BCXLXU54ZS:10.1.92.7', null, '修改宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('47', 'admin', '模块设置', null, '2018-05-29 09:40:16', 'DESKTOP-VTDU3JD:10.1.92.8', null, '添加模块');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('53', 'admin', '宾客信息', null, '2018-06-02 14:39:19', 'DESKTOP-VTDU3JD:10.1.92.8', null, '修改宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('54', 'admin', '宾客信息', null, '2018-06-02 14:39:54', 'DESKTOP-VTDU3JD:10.1.92.8', null, '修改宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('55', 'admin', '宾客信息', null, '2018-06-02 14:40:30', 'DESKTOP-VTDU3JD:10.1.92.8', null, '修改宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('56', 'admin', '宾客信息', null, '2018-06-02 14:41:13', 'DESKTOP-VTDU3JD:10.1.92.8', null, '修改宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('57', 'admin', '宾客信息', null, '2018-06-02 14:41:36', 'DESKTOP-VTDU3JD:10.1.92.8', null, '修改宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('58', 'admin', '宾客信息', null, '2018-06-02 14:41:43', 'DESKTOP-VTDU3JD:10.1.92.8', null, '修改宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('59', 'admin', '宾客信息', null, '2018-06-02 14:41:51', 'DESKTOP-VTDU3JD:10.1.92.8', null, '修改宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('60', 'admin', '宾客信息', null, '2018-06-02 14:44:16', 'DESKTOP-VTDU3JD:10.1.92.8', null, '修改宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('61', 'admin', '宾客信息', null, '2018-06-02 14:45:26', 'DESKTOP-VTDU3JD:10.1.92.8', null, '修改宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('62', 'admin', '宾客信息', null, '2018-06-02 14:45:36', 'DESKTOP-VTDU3JD:10.1.92.8', null, '修改宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('63', 'admin', '宾客信息', null, '2018-06-02 14:45:51', 'DESKTOP-VTDU3JD:10.1.92.8', null, '修改宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('64', 'admin', '宾客信息', null, '2018-06-02 14:46:17', 'DESKTOP-VTDU3JD:10.1.92.8', null, '修改宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('65', 'admin', '宾客信息', null, '2018-06-02 14:47:06', 'DESKTOP-VTDU3JD:10.1.92.8', null, '修改宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('10', 'admin', '房间信息', null, '2018-05-22 11:07:17', 'DESKTOP-VTDU3JD:10.1.92.8', null, '导入房间信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('48', 'admin', '酒店信息', null, '2018-05-30 16:08:16', 'DESKTOP-VTDU3JD:10.1.92.8', null, '导出酒店信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('9', 'admin', '酒店信息', null, '2018-05-22 10:44:17', 'DESKTOP-VTDU3JD:10.1.92.8', null, '导出酒店信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('2', 'admin', '宾客信息', null, '2018-05-22 10:33:35', 'DESKTOP-VTDU3JD:10.1.92.8', null, '查询宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('3', 'admin', '宾客信息', null, '2018-05-22 10:34:05', 'DESKTOP-VTDU3JD:10.1.92.8', null, '新增宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('1', 'admin', '宾客信息', null, '2018-05-22 10:33:28', 'DESKTOP-VTDU3JD:10.1.92.8', null, '查询宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('4', 'admin', '宾客信息', null, '2018-05-22 10:34:06', 'DESKTOP-VTDU3JD:10.1.92.8', null, '查询宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('5', 'admin', '宾客信息', null, '2018-05-22 10:35:34', 'DESKTOP-VTDU3JD:10.1.92.8', null, '查询宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('6', 'admin', '宾客信息', null, '2018-05-22 10:35:37', 'DESKTOP-VTDU3JD:10.1.92.8', null, '查询宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('7', 'admin', '宾客信息', null, '2018-05-22 10:35:40', 'DESKTOP-VTDU3JD:10.1.92.8', null, '删除宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('8', 'admin', '宾客信息', null, '2018-05-22 10:35:41', 'DESKTOP-VTDU3JD:10.1.92.8', null, '查询宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('17', 'admin', '酒店信息', null, '2018-05-23 18:26:02', 'DESKTOP-VTDU3JD:10.1.92.8', null, '导入酒店信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('23', 'admin', '酒店信息', null, '2018-05-28 11:17:06', 'B0IM0BCXLXU54ZS:10.1.92.7', null, '导入酒店信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('24', 'admin', '酒店信息', null, '2018-05-28 11:18:08', 'B0IM0BCXLXU54ZS:10.1.92.7', null, '导入酒店信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('25', 'admin', '酒店信息', null, '2018-05-28 11:21:35', 'B0IM0BCXLXU54ZS:10.1.92.7', null, '导入酒店信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('26', 'admin', '宾客信息', null, '2018-05-28 11:21:43', 'B0IM0BCXLXU54ZS:10.1.92.7', null, '导出宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('27', 'admin', '宾客信息', null, '2018-05-28 11:22:55', 'B0IM0BCXLXU54ZS:10.1.92.7', null, '修改宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('28', 'admin', '宾客信息', null, '2018-05-28 11:23:12', 'B0IM0BCXLXU54ZS:10.1.92.7', null, '修改宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('50', 'admin', '宾客信息', null, '2018-06-02 11:10:14', 'DESKTOP-VTDU3JD:10.1.92.8', null, '修改宾客信息');
INSERT INTO "TEST_GS"."SYS_OPERATION_LOG" VALUES ('71', 'admin', '酒店信息', null, '2018-06-05 17:36:51', 'DESKTOP-VTDU3JD:10.1.92.8', null, '修改酒店信息');

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
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('1', '8');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('1', '9');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('1', '14');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('1', '7');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('1', '10');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('1', '11');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('1', '12');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('1', '13');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('1', '15');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('1', '21');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('1', '20');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('1', '18');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('1', '19');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('1', '1');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('1', '2');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('1', '3');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('1', '4');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('1', '5');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('1', '6');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('1', '17');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('0', '8');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('0', '9');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('0', '7');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('0', '14');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('0', '10');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('0', '11');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('0', '12');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('0', '13');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('0', '15');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('0', '21');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('0', '20');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('0', '18');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('0', '19');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('0', '1');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('0', '2');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('0', '3');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('0', '4');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('0', '5');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('0', '6');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('0', '17');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('2', '7');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('2', '8');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('2', '9');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('2', '14');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('2', '10');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('2', '11');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('2', '12');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('2', '13');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('2', '15');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('2', '21');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('2', '20');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('2', '18');
INSERT INTO "TEST_GS"."SYS_ROLE_MODULE" VALUES ('2', '19');

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
"ENABLED" NVARCHAR2(4) DEFAULT 1  NULL ,
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
COMMENT ON COLUMN "TEST_GS"."SYS_USER"."ENABLED" IS '是否启用  0为超级管理员';
COMMENT ON COLUMN "TEST_GS"."SYS_USER"."ROLE_ID" IS '角色id';

-- ----------------------------
-- Records of SYS_USER
-- ----------------------------
INSERT INTO "TEST_GS"."SYS_USER" VALUES ('1', 'admin', '超级管理员', 'ISMvKXpXpadDiUoOSoAfww==', 'DESKTOP-VTDU3JD:10.1.92.8', TO_DATE('2018-06-06 14:41:59', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-05-10 17:48:39', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-05-22 10:08:21', 'YYYY-MM-DD HH24:MI:SS'), '0', '0');
INSERT INTO "TEST_GS"."SYS_USER" VALUES ('2', 'www', '管理员', '4QrcOUm6Wau+VuBX8g+IPg==', 'DESKTOP-VTDU3JD:10.1.92.8', TO_DATE('2018-05-23 10:12:47', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-05-10 17:48:42', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-05-23 10:12:33', 'YYYY-MM-DD HH24:MI:SS'), '1', '1');
INSERT INTO "TEST_GS"."SYS_USER" VALUES ('4', 'wyb', '王艳波', '4QrcOUm6Wau+VuBX8g+IPg==', 'DESKTOP-VTDU3JD:10.1.92.8', TO_DATE('2018-05-22 11:42:55', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-05-21 15:39:04', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-05-21 15:40:22', 'YYYY-MM-DD HH24:MI:SS'), '1', '2');
INSERT INTO "TEST_GS"."SYS_USER" VALUES ('3', 'ww', '测试', '4QrcOUm6Wau+VuBX8g+IPg==', 'DESKTOP-VTDU3JD:10.1.92.8', TO_DATE('2018-05-22 11:41:56', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-05-10 19:06:14', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-05-22 11:41:36', 'YYYY-MM-DD HH24:MI:SS'), '1', '1');

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
-- Checks structure for table CONFERENCE_INFO
-- ----------------------------
ALTER TABLE "TEST_GS"."CONFERENCE_INFO" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Checks structure for table CONFERENCE_RECORD
-- ----------------------------
ALTER TABLE "TEST_GS"."CONFERENCE_RECORD" ADD CHECK ("ID" IS NOT NULL);

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
