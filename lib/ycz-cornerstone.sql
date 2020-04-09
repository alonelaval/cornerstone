/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50623
 Source Host           : localhost:3306
 Source Schema         : ycz-cornerstone

 Target Server Type    : MySQL
 Target Server Version : 50623
 File Encoding         : 65001

 Date: 09/04/2020 12:28:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_area
-- ----------------------------
DROP TABLE IF EXISTS `tb_area`;
CREATE TABLE `tb_area` (
  `area_id` int(11) NOT NULL AUTO_INCREMENT,
  `area_name` varchar(128) NOT NULL,
  `level` tinyint(4) DEFAULT NULL,
  `zip_code` varchar(12) DEFAULT NULL,
  `area_code` varchar(24) DEFAULT NULL,
  `admin_division` tinyint(4) DEFAULT NULL,
  `parent_area_id` int(11) DEFAULT NULL,
  `parent_area_name` varchar(255) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`area_id`) USING BTREE,
  KEY `ix_area_name` (`area_name`) USING BTREE,
  KEY `ix_zip_cdoe` (`zip_code`) USING BTREE,
  KEY `ix_area_code` (`area_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_area
-- ----------------------------
BEGIN;
INSERT INTO `tb_area` VALUES (1, '湖北省', 1, '430000', '1', 0, NULL, NULL, 0, '2018-09-02 18:07:57', '2018-09-02 18:07:57');
INSERT INTO `tb_area` VALUES (4, '武汉市', 2, '434601', '1.4', 1, NULL, NULL, 0, '2018-09-02 18:13:04', '2018-09-02 18:13:04');
COMMIT;

-- ----------------------------
-- Table structure for tb_daily_org_totality_statistics
-- ----------------------------
DROP TABLE IF EXISTS `tb_daily_org_totality_statistics`;
CREATE TABLE `tb_daily_org_totality_statistics` (
  `dots_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `org_count` int(11) DEFAULT NULL,
  `sale_amount` int(11) DEFAULT NULL,
  `teacher_count` int(11) DEFAULT NULL,
  `course_count` int(11) DEFAULT NULL,
  `total_user_count` int(11) DEFAULT NULL,
  `current_service_user_count` int(11) DEFAULT NULL,
  `buy_user_count` int(11) DEFAULT NULL,
  `like_user_count` int(11) DEFAULT NULL,
  `cancel_order_user_count` int(11) DEFAULT NULL,
  `order_count` int(11) DEFAULT NULL,
  `cancel_order_count` int(11) DEFAULT NULL,
  `pv_count` int(11) DEFAULT NULL,
  `uv_count` int(11) DEFAULT NULL,
  `user_exponent` int(11) DEFAULT NULL,
  `class_count` int(11) DEFAULT '0',
  `place_count` int(11) DEFAULT '0',
  `daily_date` date DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`dots_id`) USING BTREE,
  KEY `ix_daily_date_org_id` (`daily_date`,`org_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_daily_totality_statistics
-- ----------------------------
DROP TABLE IF EXISTS `tb_daily_totality_statistics`;
CREATE TABLE `tb_daily_totality_statistics` (
  `dts_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `sale_amount` int(11) DEFAULT NULL,
  `org_count` int(11) DEFAULT NULL,
  `teacher_count` int(11) DEFAULT NULL,
  `course_count` int(11) DEFAULT NULL,
  `total_user_count` int(11) DEFAULT NULL,
  `current_service_user_count` int(11) DEFAULT NULL,
  `buy_user_count` int(11) DEFAULT NULL,
  `like_user_count` int(11) DEFAULT NULL,
  `cancel_order_user_count` int(11) DEFAULT NULL,
  `order_count` int(11) DEFAULT NULL,
  `cancel_order_count` int(11) DEFAULT NULL,
  `pv_count` int(11) DEFAULT NULL,
  `uv_count` int(11) DEFAULT NULL,
  `user_exponent` int(11) DEFAULT NULL,
  `class_count` int(11) DEFAULT '0',
  `place_count` int(11) DEFAULT '0',
  `daily_date` date DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`dts_id`) USING BTREE,
  KEY `ix_daily_date` (`daily_date`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_facility
-- ----------------------------
DROP TABLE IF EXISTS `tb_facility`;
CREATE TABLE `tb_facility` (
  `facility_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `facility_name` varchar(64) DEFAULT NULL,
  `first_category_id` int(11) DEFAULT NULL,
  `first_category_name` varchar(128) DEFAULT NULL,
  `second_category_id` int(11) DEFAULT NULL,
  `second_category_name` varchar(128) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`facility_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_facility
-- ----------------------------
BEGIN;
INSERT INTO `tb_facility` VALUES (1, '篮球', 2, '体育类', 5, '篮球', 0, '2018-09-26 22:56:43', '2018-09-28 20:39:58');
INSERT INTO `tb_facility` VALUES (2, '篮球馆', 2, '体育类', 5, '篮球', 0, '2018-09-26 23:17:07', '2018-09-28 20:39:59');
COMMIT;

-- ----------------------------
-- Table structure for tb_month_org_totality_statistics
-- ----------------------------
DROP TABLE IF EXISTS `tb_month_org_totality_statistics`;
CREATE TABLE `tb_month_org_totality_statistics` (
  `mots_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `org_count` int(11) DEFAULT NULL,
  `sale_amount` int(11) DEFAULT NULL,
  `teacher_count` int(11) DEFAULT NULL,
  `course_count` int(11) DEFAULT NULL,
  `total_user_count` int(11) DEFAULT NULL,
  `current_service_user_count` int(11) DEFAULT NULL,
  `buy_user_count` int(11) DEFAULT NULL,
  `like_user_count` int(11) DEFAULT NULL,
  `cancel_order_user_count` int(11) DEFAULT NULL,
  `order_count` int(11) DEFAULT NULL,
  `cancel_order_count` int(11) DEFAULT NULL,
  `pv_count` int(11) DEFAULT NULL,
  `uv_count` int(11) DEFAULT NULL,
  `user_exponent` int(11) DEFAULT NULL,
  `class_count` int(11) DEFAULT '0',
  `place_count` int(11) DEFAULT '0',
  `month_date` date DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`mots_id`) USING BTREE,
  KEY `ix_month_date_org_id` (`month_date`,`org_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_month_totality_statistics
-- ----------------------------
DROP TABLE IF EXISTS `tb_month_totality_statistics`;
CREATE TABLE `tb_month_totality_statistics` (
  `mts_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `sale_amount` int(11) DEFAULT NULL,
  `org_count` int(11) DEFAULT NULL,
  `teacher_count` int(11) DEFAULT NULL,
  `course_count` int(11) DEFAULT NULL,
  `total_user_count` int(11) DEFAULT NULL,
  `current_service_user_count` int(11) DEFAULT NULL,
  `buy_user_count` int(11) DEFAULT NULL,
  `like_user_count` int(11) DEFAULT NULL,
  `cancel_order_user_count` int(11) DEFAULT NULL,
  `order_count` int(11) DEFAULT NULL,
  `cancel_order_count` int(11) DEFAULT NULL,
  `pv_count` int(11) DEFAULT NULL,
  `uv_count` int(11) DEFAULT NULL,
  `user_exponent` int(11) DEFAULT NULL,
  `class_count` int(11) DEFAULT '0',
  `place_count` int(11) DEFAULT '0',
  `month_date` date DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`mts_id`) USING BTREE,
  KEY `ix_month_date` (`month_date`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_operation_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_operation_log`;
CREATE TABLE `tb_operation_log` (
  `ool_id` int(11) NOT NULL AUTO_INCREMENT,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `employe_id` int(11) DEFAULT NULL,
  `operation_type` tinyint(4) DEFAULT NULL,
  `operation_subject_name` varchar(64) DEFAULT NULL,
  `operation_subject` varchar(256) DEFAULT NULL,
  `operation_params` varchar(512) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ool_id`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE,
  KEY `ix_user_id` (`user_id`) USING BTREE,
  KEY `ix_employe_id` (`employe_id`) USING BTREE,
  KEY `ix_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_order_invoice_record
-- ----------------------------
DROP TABLE IF EXISTS `tb_order_invoice_record`;
CREATE TABLE `tb_order_invoice_record` (
  `oir_id` int(11) NOT NULL AUTO_INCREMENT,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `invoice_id` int(11) DEFAULT NULL,
  `invoice_title` varchar(256) DEFAULT NULL,
  `invoice_code` varchar(24) DEFAULT NULL,
  `addresseeId` int(11) DEFAULT NULL,
  `receive_user_name` varchar(32) DEFAULT NULL,
  `receive_user_phone` varchar(24) DEFAULT NULL,
  `order_type` tinyint(4) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`oir_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_order_invoice_record
-- ----------------------------
BEGIN;
INSERT INTO `tb_order_invoice_record` VALUES (9, 43, '手动添加机构', 100, '1212', 1, '杭州优成长', NULL, 1, 'hua', '121212121212', 1, 0, '2018-09-02 20:23:43', '2018-09-02 20:23:43');
COMMIT;

-- ----------------------------
-- Table structure for tb_org
-- ----------------------------
DROP TABLE IF EXISTS `tb_org`;
CREATE TABLE `tb_org` (
  `org_id` int(11) NOT NULL AUTO_INCREMENT,
  `org_name` varchar(256) DEFAULT NULL,
  `company_name` varchar(128) DEFAULT NULL,
  `usc_code` varchar(32) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `user_phone` varchar(24) DEFAULT NULL,
  `emergency_user_id` int(11) DEFAULT NULL,
  `emergency_user_name` varchar(32) DEFAULT NULL,
  `reg_capital` varchar(24) DEFAULT NULL,
  `establish_date` date DEFAULT NULL,
  `remark` varchar(512) DEFAULT NULL,
  `audit_state` tinyint(4) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `icon` varchar(256) DEFAULT NULL,
  `org_level` smallint(6) DEFAULT NULL,
  `org_code` varchar(64) DEFAULT NULL,
  `parent_org_id` int(11) DEFAULT NULL,
  `parent_org_name` varchar(256) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`org_id`) USING BTREE,
  KEY `ix_user_id` (`user_id`) USING BTREE,
  KEY `ix_create_time` (`create_time`) USING BTREE,
  KEY `ix_org_name` (`org_name`(32)) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_org
-- ----------------------------
BEGIN;
INSERT INTO `tb_org` VALUES (1, 'org', 'org', 'org', 2, 'huawei', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2018-07-21 10:58:36');
INSERT INTO `tb_org` VALUES (43, '手动添加机构', NULL, NULL, 100, '1212', '1212', NULL, NULL, NULL, NULL, NULL, 0, 0, '/data/ycz/20180812/QAzams8KmBCqVRBhBR.JPG', 1, '43', NULL, NULL, '2018-08-12 12:32:20', NULL);
INSERT INTO `tb_org` VALUES (46, '手动添加子机构', NULL, NULL, 102, '12123', '12123', NULL, NULL, NULL, NULL, NULL, 0, 0, NULL, 2, '43.46', 43, '手动添加机构', '2018-08-12 13:16:02', NULL);
COMMIT;

-- ----------------------------
-- Table structure for tb_org_class
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_class`;
CREATE TABLE `tb_org_class` (
  `class_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(128) DEFAULT NULL,
  `begin_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `main_coach_user_id` int(11) DEFAULT NULL,
  `main_coach_user_name` varchar(255) DEFAULT NULL,
  `main_coach_employe_id` int(11) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `course_type` tinyint(4) DEFAULT NULL,
  `course_name` varchar(128) DEFAULT NULL,
  `grade_type` tinyint(4) DEFAULT NULL,
  `cct_id` int(11) DEFAULT NULL,
  `class_type_name` varchar(128) DEFAULT NULL,
  `first_category_id` int(11) DEFAULT NULL,
  `first_category_name` varchar(128) DEFAULT NULL,
  `second_category_id` int(11) DEFAULT NULL,
  `second_category_name` varchar(128) DEFAULT NULL,
  `next_attend_date` date DEFAULT NULL,
  `checkin_exponent` int(11) DEFAULT NULL,
  `start_user_num` int(11) DEFAULT NULL,
  `join_user_num` int(11) DEFAULT NULL,
  `place_id` int(11) DEFAULT NULL,
  `place_name` varchar(32) DEFAULT NULL,
  `begin_time` time DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  `arrange_type` tinyint(4) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`class_id`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE,
  KEY `ix_man_coach_user_id` (`main_coach_user_id`) USING BTREE,
  KEY `ix_course_id` (`course_id`) USING BTREE,
  KEY `ix_cct_id` (`cct_id`) USING BTREE,
  KEY `ix_first_category_id` (`first_category_id`) USING BTREE,
  KEY `ix_second_category_id` (`second_category_id`) USING BTREE,
  KEY `ix_state` (`state`) USING BTREE,
  KEY `ix_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_org_class
-- ----------------------------
BEGIN;
INSERT INTO `tb_org_class` VALUES (1, '篮球课', NULL, NULL, 43, '手动添加机构', 105, '游泳教练', 58, 6, 1, '篮球', 0, 1, '小班（10人）', 2, '篮球', 5, '篮球', NULL, 0, 10, 1, 1, '杭州体育中心', '09:10:00', '11:10:00', 0, 0, '2018-09-03 21:26:54', '2018-09-03 21:26:54');
COMMIT;

-- ----------------------------
-- Table structure for tb_org_class_arrange_record
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_class_arrange_record`;
CREATE TABLE `tb_org_class_arrange_record` (
  `ca_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) DEFAULT NULL,
  `class_name` varchar(128) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `course_name` varchar(128) DEFAULT NULL,
  `user_id` int(11) NOT NULL DEFAULT '0',
  `user_name` varchar(32) DEFAULT NULL COMMENT '排课人名字',
  `employe_id` int(11) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `arrange_type` tinyint(4) DEFAULT NULL,
  `arrange_rule_id` int(11) DEFAULT NULL,
  `arrange_rule_name` varchar(256) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ca_id`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE,
  KEY `ix_user_id` (`user_id`) USING BTREE,
  KEY `ix_arrang_rule_id` (`arrange_rule_id`) USING BTREE,
  KEY `ix_create_time` (`create_time`) USING BTREE,
  KEY `ix_course_id` (`course_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_org_class_arrange_record
-- ----------------------------
BEGIN;
INSERT INTO `tb_org_class_arrange_record` VALUES (1, 1, '篮球课', 6, '篮球', 100, '1212', 50, 43, '手动添加机构', 0, NULL, NULL, 0, '2018-09-03 21:26:54', '2018-09-03 21:26:54');
COMMIT;

-- ----------------------------
-- Table structure for tb_org_class_arrange_rule
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_class_arrange_rule`;
CREATE TABLE `tb_org_class_arrange_rule` (
  `arrange_rule_id` int(11) NOT NULL AUTO_INCREMENT,
  `arrange_rule_name` varchar(256) DEFAULT NULL,
  `effect_object` tinyint(4) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`arrange_rule_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_org_class_coach
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_class_coach`;
CREATE TABLE `tb_org_class_coach` (
  `cc_id` int(11) NOT NULL AUTO_INCREMENT,
  `coach_type` tinyint(4) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `employe_id` int(11) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `course_name` varchar(128) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  `class_name` varchar(128) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`cc_id`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE,
  KEY `ix_user_id` (`user_id`) USING BTREE,
  KEY `ix_employe_id` (`employe_id`) USING BTREE,
  KEY `ix_class_id` (`class_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_org_class_coach
-- ----------------------------
BEGIN;
INSERT INTO `tb_org_class_coach` VALUES (1, 0, 105, '游泳教练', 58, 43, '手动添加机构', 6, '篮球', 1, '篮球课', '0', '2018-09-03 21:26:54', '2018-09-03 21:26:54');
INSERT INTO `tb_org_class_coach` VALUES (2, 1, 110, '篮球教练', 59, 43, '手动添加机构', 6, '篮球', 1, '篮球课', '2', '2018-09-04 21:42:11', '2018-11-15 21:44:17');
COMMIT;

-- ----------------------------
-- Table structure for tb_org_class_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_class_student`;
CREATE TABLE `tb_org_class_student` (
  `sc_id` int(11) NOT NULL AUTO_INCREMENT,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `org_student_id` int(11) DEFAULT NULL,
  `user_student_id` int(11) DEFAULT NULL,
  `student_user_id` int(11) DEFAULT NULL,
  `student_user_name` varchar(32) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `course_name` varchar(128) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  `class_name` varchar(128) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`sc_id`) USING BTREE,
  KEY `ix_student_id` (`org_student_id`) USING BTREE,
  KEY `ix_class_id` (`class_id`) USING BTREE,
  KEY `ix_course_id` (`course_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_org_class_student
-- ----------------------------
BEGIN;
INSERT INTO `tb_org_class_student` VALUES (1, 43, '手动添加机构', 2, NULL, 100, '1212', 6, '篮球', 1, '篮球课', 0, '2018-09-03 21:26:54', '2018-09-03 21:26:54');
INSERT INTO `tb_org_class_student` VALUES (2, 43, '手动添加机构', 2, NULL, 100, '1212', 6, '篮球', 1, '篮球课', 2, '2018-09-04 19:57:47', '2018-09-04 19:57:47');
COMMIT;

-- ----------------------------
-- Table structure for tb_org_course
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_course`;
CREATE TABLE `tb_org_course` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(128) DEFAULT NULL,
  `course_type` tinyint(4) DEFAULT NULL,
  `first_category_id` int(11) DEFAULT NULL,
  `first_category_name` varchar(128) DEFAULT NULL,
  `second_category_id` int(11) DEFAULT NULL,
  `second_category_name` varchar(128) DEFAULT NULL,
  `cct_id` int(11) DEFAULT NULL,
  `class_type_name` varchar(128) DEFAULT NULL,
  `start_type` tinyint(4) DEFAULT NULL,
  `begin_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `is_setting_time` tinyint(4) DEFAULT NULL,
  `start_user_num` int(11) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `remark` varchar(1024) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`course_id`) USING BTREE,
  KEY `ix_course_name` (`course_name`) USING BTREE,
  KEY `ix_first_category_id` (`first_category_id`) USING BTREE,
  KEY `ix_second_category_id` (`second_category_id`) USING BTREE,
  KEY `ix_cct_id` (`cct_id`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE,
  KEY `ix_state` (`state`) USING BTREE,
  KEY `ix_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='机构课程表';

-- ----------------------------
-- Records of tb_org_course
-- ----------------------------
BEGIN;
INSERT INTO `tb_org_course` VALUES (6, '篮球', 1, 2, '篮球', 5, '篮球', 1, '小班（10人）', 0, NULL, NULL, 0, 10, 43, '手动添加机构', '4', 0, '2018-08-13 10:56:49', '2018-08-13 10:56:49');
INSERT INTO `tb_org_course` VALUES (7, '大班篮球', 1, 2, '篮球', 5, '篮球', 1, '大班（20人）', 0, NULL, NULL, 0, 10, 43, '手动添加机构', '4', 0, '2018-09-25 20:49:24', '2018-09-25 20:49:24');
COMMIT;

-- ----------------------------
-- Table structure for tb_org_course_class_type
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_course_class_type`;
CREATE TABLE `tb_org_course_class_type` (
  `cct_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_type_name` varchar(128) DEFAULT NULL,
  `start_type` tinyint(4) DEFAULT NULL,
  `start_user_num` int(11) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`cct_id`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE,
  KEY `ix_class_type_name` (`class_type_name`) USING BTREE,
  KEY `ix_state` (`state`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_org_course_class_type
-- ----------------------------
BEGIN;
INSERT INTO `tb_org_course_class_type` VALUES (1, '小班（10人）', 0, 10, 43, '手动添加机构', 0, '2018-08-12 21:53:18', '2018-08-12 21:53:21');
COMMIT;

-- ----------------------------
-- Table structure for tb_org_course_period
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_course_period`;
CREATE TABLE `tb_org_course_period` (
  `cp_id` int(11) NOT NULL AUTO_INCREMENT,
  `begin_time` time DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  `time_type` tinyint(4) DEFAULT NULL,
  `day_type` tinyint(4) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `course_name` varchar(256) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`cp_id`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE,
  KEY `ix_course_id` (`course_id`) USING BTREE,
  KEY `ix_state` (`state`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_org_course_period
-- ----------------------------
BEGIN;
INSERT INTO `tb_org_course_period` VALUES (6, '09:10:00', '11:10:00', NULL, 0, 6, '篮球', 43, '手动添加机构', 0, '2018-08-13 10:56:49', '2018-08-13 10:56:49');
INSERT INTO `tb_org_course_period` VALUES (7, '08:00:00', '09:00:00', NULL, 0, 7, '大班篮球', 43, '手动添加机构', 0, '2018-09-25 20:49:24', '2018-09-25 20:49:24');
INSERT INTO `tb_org_course_period` VALUES (8, '09:30:00', '10:30:00', NULL, 1, 7, '大班篮球', 43, '手动添加机构', 0, '2018-09-25 20:49:24', '2018-09-25 20:49:24');
COMMIT;

-- ----------------------------
-- Table structure for tb_org_course_place
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_course_place`;
CREATE TABLE `tb_org_course_place` (
  `cp_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) DEFAULT NULL,
  `course_name` varchar(128) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `place_id` int(11) DEFAULT NULL,
  `place_name` varchar(32) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`cp_id`) USING BTREE,
  KEY `ix_course_id` (`course_id`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE,
  KEY `ix_state` (`state`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_org_course_place
-- ----------------------------
BEGIN;
INSERT INTO `tb_org_course_place` VALUES (4, 6, '篮球', 43, '手动添加机构', 1, '杭州体育中心', 0, '2018-08-13 10:56:49', '2018-08-13 10:56:49');
INSERT INTO `tb_org_course_place` VALUES (5, 7, '大班篮球', 43, '手动添加机构', 1, '杭州体育中心', 0, '2018-09-25 20:49:24', '2018-09-25 20:49:24');
COMMIT;

-- ----------------------------
-- Table structure for tb_org_course_price
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_course_price`;
CREATE TABLE `tb_org_course_price` (
  `cp_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_count` int(11) DEFAULT NULL,
  `course_time` int(11) DEFAULT NULL,
  `total_course_time` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `course_name` varchar(128) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`cp_id`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE,
  KEY `ix_course_id` (`course_id`) USING BTREE,
  KEY `ix_state` (`state`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_org_course_price
-- ----------------------------
BEGIN;
INSERT INTO `tb_org_course_price` VALUES (5, 12, 12, 112, 10000, 6, '篮球', 43, '手动添加机构', 0, '2018-08-13 10:56:49', '2018-08-13 10:56:49');
INSERT INTO `tb_org_course_price` VALUES (6, 12, 12, 112, 10000, 7, '大班篮球', 43, '手动添加机构', 0, '2018-09-25 20:49:24', '2018-09-25 20:49:24');
INSERT INTO `tb_org_course_price` VALUES (7, 111, 111, 111, 11100, 7, '大班篮球', 43, '手动添加机构', 0, '2018-09-25 20:49:24', '2018-09-25 20:49:24');
COMMIT;

-- ----------------------------
-- Table structure for tb_org_course_resource
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_course_resource`;
CREATE TABLE `tb_org_course_resource` (
  `cp_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) DEFAULT NULL,
  `course_name` varchar(128) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `resource_type` tinyint(4) DEFAULT NULL,
  `resource_path` varchar(256) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`cp_id`) USING BTREE,
  KEY `ix_course_id` (`course_id`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE,
  KEY `ix_state` (`state`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_org_course_resource
-- ----------------------------
BEGIN;
INSERT INTO `tb_org_course_resource` VALUES (2, 6, '篮球', 43, '手动添加机构', 0, '/data/ycz/20180813/RAmUJ5TEdaff6whWxS.JPG', 0, '2018-08-13 10:56:49', '2018-08-13 10:56:49');
COMMIT;

-- ----------------------------
-- Table structure for tb_org_department
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_department`;
CREATE TABLE `tb_org_department` (
  `department_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `department_name` varchar(64) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `employe_id` int(11) DEFAULT NULL,
  `org_Id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `level` tinyint(4) DEFAULT NULL,
  `parent_department_Id` int(11) DEFAULT NULL,
  `department_code` varchar(255) DEFAULT NULL,
  `parent_department_name` varchar(64) DEFAULT NULL,
  `remark` varchar(256) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`department_id`) USING BTREE,
  KEY `ix_org_id` (`org_Id`) USING BTREE,
  KEY `ix_department_code` (`department_code`) USING BTREE,
  KEY `ix_state` (`state`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_org_department
-- ----------------------------
BEGIN;
INSERT INTO `tb_org_department` VALUES (1, '优成长', 100, '1212', 50, 43, '手动添加机构', 1, NULL, '1', NULL, '优成长公司', 0, '2018-09-02 17:53:48', '2018-09-02 17:53:48');
INSERT INTO `tb_org_department` VALUES (2, '技术部', 100, '1212', 50, 43, '手动添加机构', 2, 1, '1.2', '优成长', '技术', 0, '2018-09-02 17:54:36', '2018-09-02 17:54:36');
COMMIT;

-- ----------------------------
-- Table structure for tb_org_dispose_appointment
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_dispose_appointment`;
CREATE TABLE `tb_org_dispose_appointment` (
  `dispose_id` int(11) NOT NULL AUTO_INCREMENT,
  `appointment_id` int(11) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `course_name` varchar(128) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  `class_name` varchar(128) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `phone` varchar(24) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `dispose_user_id` int(11) DEFAULT NULL,
  `dispose_user_name` varchar(32) DEFAULT NULL,
  `employe_id` int(11) DEFAULT NULL,
  `dispose_type` tinyint(4) DEFAULT NULL,
  `remark` varchar(256) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`dispose_id`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE,
  KEY `ix_user_id` (`user_id`) USING BTREE,
  KEY `ix_create_time` (`create_time`) USING BTREE,
  KEY `ix_course_id` (`course_id`) USING BTREE,
  KEY `ix_dispose_user_id` (`dispose_user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_org_employee
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_employee`;
CREATE TABLE `tb_org_employee` (
  `employe_id` int(11) NOT NULL AUTO_INCREMENT,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `idcard` varchar(24) DEFAULT NULL,
  `phone` varchar(24) DEFAULT NULL,
  `birthday` varchar(12) DEFAULT NULL,
  `ex_mail` varchar(32) DEFAULT NULL,
  `work_start_date` date DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  `department_name` varchar(64) DEFAULT NULL,
  `job_type` tinyint(4) DEFAULT NULL,
  `edu_background` tinyint(4) DEFAULT NULL,
  `employe_state` tinyint(4) DEFAULT NULL,
  `org_account_type` tinyint(4) DEFAULT NULL,
  `position` varchar(64) DEFAULT NULL,
  `is_coach` bit(1) DEFAULT NULL,
  `icon` varchar(128) DEFAULT NULL,
  `gender` tinyint(4) DEFAULT NULL,
  `remark` varchar(256) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`employe_id`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE,
  KEY `ix_user_id` (`user_id`) USING BTREE,
  KEY `ix_department_id` (`department_id`) USING BTREE,
  KEY `ix_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_org_employee
-- ----------------------------
BEGIN;
INSERT INTO `tb_org_employee` VALUES (1, 1, 'org', 2, 'org', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2018-07-21 10:52:16');
INSERT INTO `tb_org_employee` VALUES (50, 43, '手动添加机构', 100, '店主', NULL, '18616205697', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, NULL, b'1', '/data/ycz/20180910/528QyzkFsD9aNXf3NB.jpg', 1, '华卫测试', 0, '2018-08-12 12:32:20', '2018-08-12 12:32:20');
INSERT INTO `tb_org_employee` VALUES (53, 46, '手动添加子机构', 102, '12123', NULL, '12123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, NULL, b'1', NULL, NULL, NULL, 0, '2018-08-12 13:16:02', '2018-08-12 13:16:02');
INSERT INTO `tb_org_employee` VALUES (58, 43, '手动添加机构', 105, '华卫教练测试', NULL, '18616205698', '2000-12-12', NULL, '2017-12-12', NULL, NULL, 1, 1, 3, 1, NULL, b'0', '/data/ycz/20180910/e59D3q8dYhZ2xMB747.jpg', 1, '华卫测试', 0, '2018-08-12 14:26:05', '2018-08-12 14:26:05');
INSERT INTO `tb_org_employee` VALUES (59, 43, '手动添加机构', 110, '篮球教练', NULL, '110', '2000-12-12', NULL, '2017-12-12', NULL, NULL, 1, 1, 3, 1, NULL, b'0', NULL, 0, 'dddd', 0, '2018-09-04 20:04:05', '2018-09-04 20:04:05');
INSERT INTO `tb_org_employee` VALUES (60, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '2018-11-21 16:16:26', '2018-11-21 16:16:26');
COMMIT;

-- ----------------------------
-- Table structure for tb_org_employee_checkin
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_employee_checkin`;
CREATE TABLE `tb_org_employee_checkin` (
  `oec_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `employe_id` int(11) DEFAULT NULL,
  `begin_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `checkin_type` tinyint(4) DEFAULT NULL,
  `progress` int(11) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  `class_name` varchar(128) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `course_name` varchar(128) DEFAULT NULL,
  `second_category_name` varchar(128) DEFAULT NULL,
  `second_category_Id` int(11) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`oec_id`) USING BTREE,
  KEY `ix_user_id` (`user_id`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE,
  KEY `ix_employe_id` (`employe_id`) USING BTREE,
  KEY `ix_class_id` (`class_id`) USING BTREE,
  KEY `ix_create_time` (`create_time`) USING BTREE,
  KEY `ix_search` (`org_id`,`employe_id`,`course_id`,`class_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_org_employee_checkin
-- ----------------------------
BEGIN;
INSERT INTO `tb_org_employee_checkin` VALUES (1, 105, '游泳教练', 58, '2018-09-06 19:58:14', '2018-09-06 20:04:27', 2, NULL, 1, '篮球课', 43, '手动添加机构', 6, '篮球', '篮球', 5, 0, '2018-09-06 19:58:14', '2018-09-06 19:58:14');
COMMIT;

-- ----------------------------
-- Table structure for tb_org_employee_record
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_employee_record`;
CREATE TABLE `tb_org_employee_record` (
  `record_id` int(11) NOT NULL AUTO_INCREMENT,
  `employe_id` int(11) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `record_name` varchar(64) DEFAULT NULL,
  `begin_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`record_id`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE,
  KEY `ix_user_id` (`user_id`) USING BTREE,
  KEY `ix_employe_id` (`employe_id`) USING BTREE,
  KEY `ix_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_org_employee_record
-- ----------------------------
BEGIN;
INSERT INTO `tb_org_employee_record` VALUES (3, 58, 43, '手动添加机构', 105, '游泳教练', '游泳教练', '2017-12-12', '2018-12-12', 0, '2018-08-12 14:26:05', '2018-08-12 14:26:05');
INSERT INTO `tb_org_employee_record` VALUES (4, 59, 43, '手动添加机构', 110, '篮球教练', '游泳教练', '2017-12-12', '2018-12-12', 0, '2018-09-04 20:04:05', '2018-09-04 20:04:05');
COMMIT;

-- ----------------------------
-- Table structure for tb_org_employee_resource
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_employee_resource`;
CREATE TABLE `tb_org_employee_resource` (
  `oer_id` int(11) NOT NULL AUTO_INCREMENT,
  `employe_id` int(11) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `resource_type` tinyint(4) DEFAULT NULL,
  `resource_path` varchar(128) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`oer_id`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE,
  KEY `ix_user_id` (`user_id`) USING BTREE,
  KEY `ix_employe_id` (`employe_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_org_employee_skill
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_employee_skill`;
CREATE TABLE `tb_org_employee_skill` (
  `oes_id` int(11) NOT NULL AUTO_INCREMENT,
  `employe_id` int(11) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `first_category_id` int(11) DEFAULT NULL,
  `first_category_name` varchar(128) DEFAULT NULL,
  `second_category_id` int(11) DEFAULT NULL,
  `second_category_name` varchar(128) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`oes_id`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE,
  KEY `ix_user_id` (`user_id`) USING BTREE,
  KEY `ix_employe_id` (`employe_id`) USING BTREE,
  KEY `ix_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_org_employee_skill
-- ----------------------------
BEGIN;
INSERT INTO `tb_org_employee_skill` VALUES (5, 58, 43, '手动添加机构', 105, '游泳教练', 2, '体育类', 4, '足球', 0, '2018-08-12 14:26:05', '2018-08-12 14:26:05');
INSERT INTO `tb_org_employee_skill` VALUES (6, 58, 43, '手动添加机构', 105, '游泳教练', 2, '体育类', 5, '篮球', 0, '2018-08-12 14:26:05', '2018-08-12 14:26:05');
INSERT INTO `tb_org_employee_skill` VALUES (7, 59, 43, '手动添加机构', 110, '篮球教练', 2, '体育类', 4, '足球', 0, '2018-09-04 20:04:05', '2018-09-04 20:04:05');
INSERT INTO `tb_org_employee_skill` VALUES (8, 59, 43, '手动添加机构', 110, '篮球教练', 2, '体育类', 5, '篮球', 0, '2018-09-04 20:04:05', '2018-09-04 20:04:05');
COMMIT;

-- ----------------------------
-- Table structure for tb_org_employee_workday
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_employee_workday`;
CREATE TABLE `tb_org_employee_workday` (
  `workday_id` int(11) NOT NULL AUTO_INCREMENT,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `employe_id` int(11) DEFAULT NULL,
  `day_type` tinyint(4) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`workday_id`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE,
  KEY `ix_user_id` (`user_id`) USING BTREE,
  KEY `ix_create_time` (`create_time`) USING BTREE,
  KEY `ix_employe_id` (`employe_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_org_employee_workday
-- ----------------------------
BEGIN;
INSERT INTO `tb_org_employee_workday` VALUES (3, 43, '手动添加机构', 105, '游泳教练', 58, 4, 0, '2018-08-12 14:26:05', '2018-08-12 14:26:05');
INSERT INTO `tb_org_employee_workday` VALUES (4, 43, '手动添加机构', 110, '篮球教练', 59, 4, 0, '2018-09-04 20:04:05', '2018-09-04 20:04:05');
COMMIT;

-- ----------------------------
-- Table structure for tb_org_employee_worktime
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_employee_worktime`;
CREATE TABLE `tb_org_employee_worktime` (
  `oew_id` int(11) NOT NULL AUTO_INCREMENT,
  `employe_id` int(11) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `workday_id` int(11) DEFAULT NULL,
  `day_type` tinyint(4) DEFAULT NULL,
  `first_category_id` int(11) DEFAULT NULL,
  `first_category_name` varchar(128) DEFAULT NULL,
  `second_category_id` int(11) DEFAULT NULL,
  `second_category_name` varchar(128) DEFAULT NULL,
  `begin_time` time(6) DEFAULT NULL,
  `end_time` time(6) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`oew_id`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE,
  KEY `ix_user_id` (`user_id`) USING BTREE,
  KEY `ix_create_time` (`create_time`) USING BTREE,
  KEY `ix_employe_id` (`employe_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_org_employee_worktime
-- ----------------------------
BEGIN;
INSERT INTO `tb_org_employee_worktime` VALUES (4, 58, 43, '手动添加机构', 105, '游泳教练', 3, 4, 2, '体育类', 4, '足球', '09:00:00.000000', '10:00:00.000000', 0, '2018-08-12 14:26:05', '2018-08-12 14:26:05');
INSERT INTO `tb_org_employee_worktime` VALUES (5, 59, 43, '手动添加机构', 110, '篮球教练', 4, 4, 2, '体育类', 4, '足球', '13:00:00.000000', '14:00:00.000000', 0, '2018-09-04 20:04:05', '2018-09-04 20:04:05');
COMMIT;

-- ----------------------------
-- Table structure for tb_org_gift
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_gift`;
CREATE TABLE `tb_org_gift` (
  `gift_id` int(11) NOT NULL AUTO_INCREMENT,
  `gift_name` varchar(128) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `add_user_id` int(11) DEFAULT NULL,
  `add_employe_id` int(11) DEFAULT NULL,
  `add_user_name` varchar(32) DEFAULT NULL,
  `inventory` int(11) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`gift_id`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE,
  KEY `ix_add_user_id` (`add_user_id`) USING BTREE,
  KEY `ix_gift_name` (`gift_name`(30)) USING BTREE,
  KEY `ix_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_org_message_rule_type
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_message_rule_type`;
CREATE TABLE `tb_org_message_rule_type` (
  `omrt_id` int(11) NOT NULL AUTO_INCREMENT,
  `rule_type` tinyint(4) DEFAULT NULL,
  `rule_type_name` varchar(255) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`omrt_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_org_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_order`;
CREATE TABLE `tb_org_order` (
  `org_order_id` int(11) NOT NULL AUTO_INCREMENT,
  `deal_number` varchar(24) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `phone` varchar(24) DEFAULT NULL,
  `sell_user_id` int(11) DEFAULT NULL,
  `sell_user_name` varchar(32) DEFAULT NULL,
  `sell_employe_id` int(11) DEFAULT NULL,
  `is_invoiced` tinyint(4) DEFAULT NULL,
  `total_pay_amount` int(11) DEFAULT NULL,
  `order_time` date DEFAULT NULL,
  `remark` varchar(512) DEFAULT NULL,
  `oir_id` int(11) DEFAULT NULL,
  `refund_amount` int(11) DEFAULT NULL,
  `order_state` tinyint(4) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`org_order_id`) USING BTREE,
  KEY `ix_deal_number` (`deal_number`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE,
  KEY `ix_user_id` (`user_id`) USING BTREE,
  KEY `ix_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_org_order
-- ----------------------------
BEGIN;
INSERT INTO `tb_org_order` VALUES (9, '186801596720482304', 43, '手动添加机构', 100, '1212', '1212', NULL, NULL, NULL, 1, 10000, '2018-09-01', '用户下单', 9, NULL, 0, 0, '2018-09-01 22:10:42', '2018-09-01 22:10:42');
INSERT INTO `tb_org_order` VALUES (12, '186820288418154496', 43, '手动添加机构', 100, '1212', '1212', NULL, NULL, NULL, 1, 10000, '2018-09-01', '用户下单', 9, NULL, 0, 0, '2018-09-01 22:19:46', '2018-09-01 22:19:46');
INSERT INTO `tb_org_order` VALUES (13, '11', 1, 'ttt', 111, '12121', '11111111', 11, 'hua', 11, 2, 111, '2018-10-22', '111', NULL, NULL, NULL, 2, '2018-10-22 19:34:59', '2018-10-22 19:34:59');
COMMIT;

-- ----------------------------
-- Table structure for tb_org_order_course
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_order_course`;
CREATE TABLE `tb_org_order_course` (
  `ooc_id` int(11) NOT NULL AUTO_INCREMENT,
  `org_order_id` int(11) DEFAULT NULL,
  `deal_number` varchar(24) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `course_name` varchar(128) DEFAULT NULL,
  `course_type` tinyint(4) DEFAULT NULL,
  `org_student_id` int(11) DEFAULT NULL,
  `user_student_id` int(11) DEFAULT NULL,
  `attend_user_id` int(11) DEFAULT NULL,
  `attend_user_name` varchar(32) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `buy_course_time` int(11) DEFAULT NULL,
  `buy_course_count` int(11) DEFAULT NULL,
  `one_course_time` int(11) DEFAULT NULL,
  `total_amount` int(11) DEFAULT NULL,
  `place_id` int(11) DEFAULT NULL,
  `place_name` varchar(32) DEFAULT NULL,
  `is_arrange_class` bit(1) DEFAULT b'1',
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ooc_id`) USING BTREE,
  KEY `ix_org_order_id` (`org_order_id`) USING BTREE,
  KEY `ix_course_id` (`course_id`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE,
  KEY `ix_state` (`state`) USING BTREE,
  KEY `ix_create_time` (`create_time`) USING BTREE,
  KEY `ix_user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_org_order_course
-- ----------------------------
BEGIN;
INSERT INTO `tb_org_order_course` VALUES (1, 9, '186801596720482304', 43, '手动添加机构', 6, '篮球', 1, 1, 4, 109, '学员1', 100, '1212', 112, 12, 12, 10000, 1, '杭州体育中心', b'1', 0, '2018-09-01 22:10:42', '2018-09-01 22:10:42');
INSERT INTO `tb_org_order_course` VALUES (2, 12, '186820288418154496', 43, '手动添加机构', 6, '篮球', 1, 2, NULL, 100, '1212', 100, '1212', 112, 12, 12, 10000, 1, '杭州体育中心', b'1', 0, '2018-09-01 22:19:46', '2018-09-01 22:19:46');
COMMIT;

-- ----------------------------
-- Table structure for tb_org_order_course_coach
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_order_course_coach`;
CREATE TABLE `tb_org_order_course_coach` (
  `oocc_id` int(11) NOT NULL AUTO_INCREMENT,
  `org_order_id` int(11) DEFAULT NULL,
  `deal_number` varchar(24) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `course_name` varchar(128) DEFAULT NULL,
  `coach_user_id` int(11) DEFAULT NULL,
  `employe_id` int(11) DEFAULT NULL,
  `coach_user_name` varchar(32) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`oocc_id`) USING BTREE,
  KEY `ix_org_order_id` (`org_order_id`) USING BTREE,
  KEY `ix_course_id` (`course_id`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE,
  KEY `ix_state` (`state`) USING BTREE,
  KEY `ix_create_time` (`create_time`) USING BTREE,
  KEY `ix_user_id` (`user_id`) USING BTREE,
  KEY `ix_coach_user_id` (`coach_user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_org_order_course_coach
-- ----------------------------
BEGIN;
INSERT INTO `tb_org_order_course_coach` VALUES (1, 9, '186801596720482304', 43, '手动添加机构', 6, '篮球', 105, 58, '游泳教练', 100, '1212', 0, '2018-09-01 22:10:42', '2018-09-01 22:10:42');
INSERT INTO `tb_org_order_course_coach` VALUES (2, 12, '186820288418154496', 43, '手动添加机构', 6, '篮球', 105, 58, '游泳教练', 100, '1212', 0, '2018-09-01 22:19:46', '2018-09-01 22:19:46');
COMMIT;

-- ----------------------------
-- Table structure for tb_org_order_course_period
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_order_course_period`;
CREATE TABLE `tb_org_order_course_period` (
  `ocp_id` int(11) NOT NULL AUTO_INCREMENT,
  `org_order_id` int(11) DEFAULT NULL,
  `deal_number` varchar(24) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `course_name` varchar(128) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `time_type` tinyint(4) DEFAULT NULL,
  `begin_time` time DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  `cp_id` int(11) DEFAULT NULL,
  `day_type` tinyint(4) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ocp_id`) USING BTREE,
  KEY `ix_org_order_id` (`org_order_id`) USING BTREE,
  KEY `ix_course_id` (`course_id`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE,
  KEY `ix_state` (`state`) USING BTREE,
  KEY `ix_create_time` (`create_time`) USING BTREE,
  KEY `ix_user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_org_order_course_period
-- ----------------------------
BEGIN;
INSERT INTO `tb_org_order_course_period` VALUES (1, 9, '186801596720482304', 43, '手动添加机构', 6, '篮球', 100, '1212', NULL, '09:10:00', '11:10:00', 6, 0, 0, '2018-09-01 22:10:43', '2018-09-01 22:10:43');
INSERT INTO `tb_org_order_course_period` VALUES (2, 12, '186820288418154496', 43, '手动添加机构', 6, '篮球', 100, '1212', NULL, '09:10:00', '11:10:00', 6, 0, 0, '2018-09-01 22:19:46', '2018-09-01 22:19:46');
COMMIT;

-- ----------------------------
-- Table structure for tb_org_order_promotion
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_order_promotion`;
CREATE TABLE `tb_org_order_promotion` (
  `oop_id` int(11) NOT NULL AUTO_INCREMENT,
  `org_order_id` int(11) DEFAULT NULL,
  `deal_number` varchar(24) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `pr_id` int(11) DEFAULT NULL,
  `rule_name` varchar(128) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`oop_id`) USING BTREE,
  KEY `ix_user_id` (`user_id`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE,
  KEY `ix_pr_id` (`pr_id`) USING BTREE,
  KEY `ix_state` (`state`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_org_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_permission`;
CREATE TABLE `tb_org_permission` (
  `op_id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_id` int(11) DEFAULT NULL,
  `name` varchar(256) DEFAULT NULL,
  `value` varchar(256) DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL,
  `is_show` int(11) DEFAULT NULL,
  `rank` int(11) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `parent_permission_id` int(11) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`op_id`) USING BTREE,
  KEY `ix_permssion_id` (`permission_id`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_org_permission
-- ----------------------------
BEGIN;
INSERT INTO `tb_org_permission` VALUES (1, 2, 'org', '/api/org', 2, 0, 1, 1, 'test', NULL, 0, NULL, '2018-07-20 22:52:21');
INSERT INTO `tb_org_permission` VALUES (44, 2, 'org', '/api/org', 2, 0, 1, 43, '手动添加机构', NULL, 0, '2018-08-12 12:32:20', '2018-07-20 22:30:25');
INSERT INTO `tb_org_permission` VALUES (47, 2, 'org', '/api/org', 2, 0, 1, 46, '手动添加子机构', NULL, 0, '2018-08-12 13:16:02', '2018-07-20 22:30:25');
INSERT INTO `tb_org_permission` VALUES (48, 8, '机构签到', '/org/employee/checkin/add', 2, 0, 1, 43, '手动添加机构', NULL, 0, NULL, '2018-09-05 22:30:26');
COMMIT;

-- ----------------------------
-- Table structure for tb_org_place
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_place`;
CREATE TABLE `tb_org_place` (
  `place_id` int(11) NOT NULL AUTO_INCREMENT,
  `place_full_name` varchar(128) DEFAULT NULL,
  `place_name` varchar(32) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `province` varchar(24) DEFAULT NULL,
  `city` varchar(56) DEFAULT NULL,
  `county` varchar(56) DEFAULT NULL,
  `address` varchar(256) DEFAULT NULL,
  `x_coord` varchar(24) DEFAULT NULL,
  `y_coord` varchar(24) DEFAULT NULL,
  `own_type` tinyint(4) DEFAULT NULL,
  `area` int(24) DEFAULT '0',
  `begin_use_date` date DEFAULT NULL,
  `end_use_date` date DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`place_id`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE,
  KEY `ix_place_name` (`place_name`) USING BTREE,
  KEY `ix_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_org_place
-- ----------------------------
BEGIN;
INSERT INTO `tb_org_place` VALUES (1, '杭州体育中心', '杭州体育中心', 43, '手动添加机构', '浙江', '杭州', '临安区', '杭州市体育场路210号', NULL, NULL, 0, 111, '2018-08-05', '2018-09-29', NULL, 0, NULL, '2018-08-12 17:33:54');
INSERT INTO `tb_org_place` VALUES (6, '上海人民体育馆', '上海体育馆', 43, '手动添加机构', '上海', '上海', '黄浦区', '上海xxxxx地点', '1212', '121212', 1, 120, '2017-12-12', '2018-12-12', 'test', 0, '2018-09-27 20:43:08', '2018-09-27 20:43:08');
INSERT INTO `tb_org_place` VALUES (7, '上海人民体育馆2', '上海人民体育馆', 43, '手动添加机构', '上海', '上海', '黄浦区', '上海xxxxx地点', '1212', '121212', 1, 120, '2017-12-12', '2018-12-12', 'test', 0, '2018-09-28 20:35:49', '2018-09-28 20:35:49');
COMMIT;

-- ----------------------------
-- Table structure for tb_org_place_facility
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_place_facility`;
CREATE TABLE `tb_org_place_facility` (
  `opf_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `facility_id` int(10) DEFAULT '0',
  `facility_name` varchar(64) DEFAULT NULL,
  `first_category_id` int(11) DEFAULT NULL,
  `first_category_name` varchar(128) DEFAULT NULL,
  `second_category_id` int(11) DEFAULT NULL,
  `second_category_name` varchar(128) DEFAULT NULL,
  `place_id` int(11) DEFAULT '0',
  `place_name` varchar(32) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`opf_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_org_place_facility
-- ----------------------------
BEGIN;
INSERT INTO `tb_org_place_facility` VALUES (1, 2, '篮球馆', 2, '体育类', 5, '篮球', 5, '上海体育馆', 43, '手动添加机构', 0, '2018-09-27 20:41:42', '2018-09-28 20:40:12');
INSERT INTO `tb_org_place_facility` VALUES (2, 2, '篮球馆', 2, '体育类', 5, '篮球', 6, '上海体育馆', 43, '手动添加机构', 0, '2018-09-27 20:43:08', '2018-09-28 20:40:17');
INSERT INTO `tb_org_place_facility` VALUES (3, 1, '篮球', 2, '体育类', 5, '篮球', 7, '上海人民体育馆', 43, '手动添加机构', 0, '2018-09-28 20:35:50', '2018-09-28 20:40:18');
INSERT INTO `tb_org_place_facility` VALUES (4, 2, '篮球馆', 2, '体育类', 5, '篮球', 7, '上海人民体育馆', 43, '手动添加机构', 0, '2018-09-28 20:35:50', '2018-09-28 20:40:19');
INSERT INTO `tb_org_place_facility` VALUES (5, 2, '馆', 2, '体育类', 4, '篮球', 1, '杭州体育中心', 43, '手动添加机构', 0, '2018-09-28 20:35:50', '2018-09-28 21:17:43');
COMMIT;

-- ----------------------------
-- Table structure for tb_org_place_resource
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_place_resource`;
CREATE TABLE `tb_org_place_resource` (
  `sr_id` int(11) NOT NULL AUTO_INCREMENT,
  `place_id` int(11) DEFAULT NULL,
  `place_name` varchar(32) DEFAULT NULL,
  `resource_type` tinyint(4) DEFAULT NULL,
  `resource_path` varchar(128) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`sr_id`) USING BTREE,
  KEY `ix_place_id` (`place_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_org_promotion_condition
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_promotion_condition`;
CREATE TABLE `tb_org_promotion_condition` (
  `pc_id` int(11) NOT NULL AUTO_INCREMENT,
  `pr_id` int(11) DEFAULT NULL,
  `rule_name` varchar(128) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `effect_begin_scope` int(11) DEFAULT NULL,
  `effect_end_scope` int(11) DEFAULT NULL,
  `effect_value` varchar(32) DEFAULT NULL,
  `promotion_type` tinyint(4) DEFAULT NULL,
  `state` tinyint(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`pc_id`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE,
  KEY `ix_pr_id` (`pr_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_org_promotion_rule
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_promotion_rule`;
CREATE TABLE `tb_org_promotion_rule` (
  `pr_id` int(11) NOT NULL AUTO_INCREMENT,
  `rule_name` varchar(128) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `promotion_type` tinyint(4) DEFAULT NULL,
  `effect_object` tinyint(4) DEFAULT NULL,
  `effect_type` tinyint(4) DEFAULT NULL,
  `begin_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `audit_state` tinyint(4) DEFAULT NULL,
  `audit_user_id` int(11) DEFAULT NULL,
  `audit_employe_id` int(11) DEFAULT NULL,
  `audit_user_name` varchar(32) DEFAULT NULL,
  `add_user_id` tinyint(4) DEFAULT NULL,
  `add_user_name` tinyint(4) DEFAULT NULL,
  `add_employe_id` int(11) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `remark` varchar(512) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`pr_id`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE,
  KEY `ix_audit_user_id` (`audit_user_id`) USING BTREE,
  KEY `ix_add_user_id` (`add_user_id`) USING BTREE,
  KEY `ix_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_org_relation
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_relation`;
CREATE TABLE `tb_org_relation` (
  `or_id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_org_id` int(11) DEFAULT NULL,
  `parent_org_name` varchar(256) DEFAULT NULL,
  `sub_org_id` int(11) DEFAULT NULL,
  `sub_org_name` varchar(256) DEFAULT NULL,
  `org_level` int(11) DEFAULT NULL,
  `org_code` varchar(24) DEFAULT NULL,
  `relation_type` tinyint(4) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`or_id`) USING BTREE,
  KEY `ix_parent_org_id` (`parent_org_id`) USING BTREE,
  KEY `ix_sub_org_id` (`sub_org_id`) USING BTREE,
  KEY `ix_org_code` (`org_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_org_resource
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_resource`;
CREATE TABLE `tb_org_resource` (
  `resource_id` int(11) NOT NULL AUTO_INCREMENT,
  `org_id` int(11) DEFAULT NULL,
  `resource_type` tinyint(4) DEFAULT NULL,
  `resource_name` varchar(32) DEFAULT NULL,
  `resource_path` varchar(128) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`resource_id`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_org_resource
-- ----------------------------
BEGIN;
INSERT INTO `tb_org_resource` VALUES (13, 46, 0, '营业执照', '/data/ycz/20180812/sEpFsDtHw2E3aQDt9C.JPG', 0, '2018-08-12 13:16:02', '2018-08-12 13:16:02');
INSERT INTO `tb_org_resource` VALUES (14, 43, 0, '营业执照', '/data/ycz/20180910/73L6phe5t8jr7hscJE.jpg', 2, '2018-09-10 22:15:28', '2018-09-10 22:25:12');
INSERT INTO `tb_org_resource` VALUES (15, 43, 0, '营业执照', '/data/ycz/20180910/FuxepgMZYZEeWzU1xn.jpg', 0, '2018-09-10 22:25:13', '2018-09-10 22:25:13');
COMMIT;

-- ----------------------------
-- Table structure for tb_org_return_visit
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_return_visit`;
CREATE TABLE `tb_org_return_visit` (
  `orv_id` int(11) NOT NULL AUTO_INCREMENT,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `user_phone` varchar(24) DEFAULT NULL,
  `visit_user_id` int(11) DEFAULT NULL,
  `visit_user_name` varchar(32) DEFAULT NULL,
  `visit_employe_id` int(11) DEFAULT NULL,
  `visit_time` datetime DEFAULT NULL,
  `visit_type` tinyint(4) DEFAULT NULL,
  `visit_content` varchar(256) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`orv_id`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE,
  KEY `ix_user_id` (`user_id`) USING BTREE,
  KEY `ix_visit_user_id` (`visit_user_id`) USING BTREE,
  KEY `ix_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_org_return_visit
-- ----------------------------
BEGIN;
INSERT INTO `tb_org_return_visit` VALUES (1, 24, '版本测试1', 80, '18616205696', '18616205696', 78, NULL, 28, '2018-08-05 11:30:35', 0, NULL, 0, '2018-08-05 11:30:35', '2018-08-05 11:30:35');
INSERT INTO `tb_org_return_visit` VALUES (2, 24, '版本测试1', 80, '18616205696', '18616205696', 78, NULL, 28, '2018-05-01 18:30:30', 0, '回访结束', 0, '2018-08-05 11:31:38', '2018-08-05 11:31:38');
INSERT INTO `tb_org_return_visit` VALUES (3, 24, '版本测试1', 80, '18616205696', '18616205696', 78, NULL, 28, '2018-08-05 11:34:54', 0, '回访结束', 0, '2018-08-05 11:34:54', '2018-08-05 11:34:54');
INSERT INTO `tb_org_return_visit` VALUES (4, 24, '版本测试1', 80, '18616205696', '18616205696', 78, NULL, 28, '2018-08-05 11:41:04', 0, '回访', 0, '2018-08-05 11:41:04', '2018-08-05 11:41:04');
INSERT INTO `tb_org_return_visit` VALUES (5, 24, '版本测试1', 80, '18616205696', '18616205696', 78, NULL, 28, '2018-08-05 11:47:18', 0, '回访', 0, '2018-08-05 11:47:18', '2018-08-05 11:47:18');
INSERT INTO `tb_org_return_visit` VALUES (6, 24, '版本测试1', 80, '18616205696', '18616205696', 78, 'huawei', 28, '2018-05-01 18:30:30', 0, '回访', 0, '2018-08-05 11:50:33', '2018-08-05 11:50:33');
COMMIT;

-- ----------------------------
-- Table structure for tb_org_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_student`;
CREATE TABLE `tb_org_student` (
  `org_student_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_student_id` int(11) DEFAULT NULL,
  `guardian_user_id` int(11) DEFAULT NULL,
  `guardian_user_name` varchar(32) DEFAULT NULL,
  `student_user_id` int(11) DEFAULT NULL,
  `student_user_name` varchar(32) DEFAULT NULL,
  `total_join_num` int(11) DEFAULT NULL,
  `current_course_num` int(11) DEFAULT NULL,
  `phone` varchar(24) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `gender` tinyint(4) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`org_student_id`) USING BTREE,
  KEY `ix_guardian_user_id` (`guardian_user_id`) USING BTREE,
  KEY `ix_student_user_id` (`student_user_id`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE,
  KEY `ix_state` (`state`) USING BTREE,
  KEY `ix_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_org_student
-- ----------------------------
BEGIN;
INSERT INTO `tb_org_student` VALUES (1, 4, 100, '1212', 109, '学员1', 1, 1, '1212', 43, '手动添加机构', NULL, 0, '2018-09-01 22:10:42', '2018-09-01 22:10:42');
INSERT INTO `tb_org_student` VALUES (2, NULL, NULL, NULL, 100, '1212', 1, 1, '1212', 43, '手动添加机构', NULL, 0, '2018-09-01 22:19:46', '2018-09-01 22:19:46');
COMMIT;

-- ----------------------------
-- Table structure for tb_org_user_appointment
-- ----------------------------
DROP TABLE IF EXISTS `tb_org_user_appointment`;
CREATE TABLE `tb_org_user_appointment` (
  `appointment_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) DEFAULT NULL,
  `course_name` varchar(128) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  `class_name` varchar(128) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `phone` varchar(24) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `appointment_date` datetime DEFAULT NULL,
  `sate` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`appointment_id`) USING BTREE,
  KEY `ix_user_id` (`user_id`) USING BTREE,
  KEY `ix_course_id` (`course_id`) USING BTREE,
  KEY `ix_class_id` (`class_id`) USING BTREE,
  KEY `ix_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_platform_course_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_platform_course_category`;
CREATE TABLE `tb_platform_course_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(128) DEFAULT NULL,
  `category_code` varchar(32) DEFAULT NULL,
  `level` tinyint(4) DEFAULT NULL,
  `parent_category_id` int(11) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`category_id`) USING BTREE,
  KEY `ix_parent_category_id` (`parent_category_id`) USING BTREE,
  KEY `ix_category_name` (`category_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_platform_course_category
-- ----------------------------
BEGIN;
INSERT INTO `tb_platform_course_category` VALUES (1, '文化类', '1', 1, NULL, 0, '2018-08-10 21:09:47', '2018-08-10 21:09:51');
INSERT INTO `tb_platform_course_category` VALUES (2, '体育类', '2', 1, NULL, 0, '2018-08-10 21:10:36', '2018-08-10 21:10:38');
INSERT INTO `tb_platform_course_category` VALUES (3, '艺术类', '3', 1, NULL, NULL, '2018-08-10 21:10:30', '2018-08-10 21:10:32');
INSERT INTO `tb_platform_course_category` VALUES (4, '足球', '2.4', 2, 2, 0, '2018-08-10 21:11:24', '2018-08-10 21:11:28');
INSERT INTO `tb_platform_course_category` VALUES (5, '篮球', '2.5', 2, 2, 0, '2018-08-10 21:11:46', '2018-08-10 21:11:49');
COMMIT;

-- ----------------------------
-- Table structure for tb_platform_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_platform_order`;
CREATE TABLE `tb_platform_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `deal_number` varchar(24) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `phone` varchar(24) DEFAULT NULL,
  `deal_date` date DEFAULT NULL,
  `deal_type` tinyint(4) DEFAULT NULL,
  `effect_begin_date` date DEFAULT NULL,
  `effect_end_date` date DEFAULT NULL,
  `deal_amount` int(11) DEFAULT NULL,
  `product_version` tinyint(4) DEFAULT NULL,
  `buy_content` varchar(32) DEFAULT NULL,
  `pay_type` tinyint(4) DEFAULT NULL,
  `is_invoiced` tinyint(4) DEFAULT NULL,
  `add_user_id` int(11) DEFAULT NULL,
  `add_user_name` varchar(32) DEFAULT NULL,
  `oir_id` int(11) DEFAULT NULL,
  `order_state` tinyint(4) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`order_id`) USING BTREE,
  KEY `ix_deal_number` (`deal_number`) USING BTREE,
  KEY `ix_user_id` (`user_id`) USING BTREE,
  KEY `ix_product_version` (`product_version`) USING BTREE,
  KEY `ix_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_platform_order
-- ----------------------------
BEGIN;
INSERT INTO `tb_platform_order` VALUES (1, '106614660383377408', 24, '测试版本1', 78, 'huawei', '18616206598', '2018-08-18', 0, NULL, NULL, 12121200, 0, '测试版本', NULL, 0, 3, 'platform', 8, 0, 0, '2018-08-05 21:54:56', '2018-09-02 19:13:17');
INSERT INTO `tb_platform_order` VALUES (2, '106619127149365248', 24, '测试版本1', 78, 'huawei', '18616206598', '2018-08-18', 0, NULL, NULL, 12121200, 0, '测试版本', NULL, 0, 3, 'platform', 8, 0, 0, '2018-08-05 21:57:05', '2018-09-02 19:13:18');
COMMIT;

-- ----------------------------
-- Table structure for tb_platform_shopkeeper
-- ----------------------------
DROP TABLE IF EXISTS `tb_platform_shopkeeper`;
CREATE TABLE `tb_platform_shopkeeper` (
  `ps_id` int(11) NOT NULL AUTO_INCREMENT,
  `org_count` smallint(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `phone` varchar(24) DEFAULT NULL,
  `effect_begin_date` date DEFAULT NULL,
  `effect_end_date` date DEFAULT NULL,
  `duration_month` smallint(6) DEFAULT NULL,
  `product_version` tinyint(4) DEFAULT NULL,
  `add_user_id` int(11) DEFAULT NULL,
  `add_user_name` varchar(32) DEFAULT NULL,
  `employe_id` int(11) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `audit_state` tinyint(4) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ps_id`) USING BTREE,
  KEY `ix_user_id` (`user_id`) USING BTREE,
  KEY `ix_product_version` (`product_version`) USING BTREE,
  KEY `ix_create_time` (`create_time`) USING BTREE,
  KEY `ix_state` (`state`) USING BTREE,
  KEY `ix_phone` (`phone`) USING BTREE,
  KEY `ix_audit_state` (`audit_state`) USING BTREE,
  KEY `ix_user_name` (`user_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_platform_shopkeeper
-- ----------------------------
BEGIN;
INSERT INTO `tb_platform_shopkeeper` VALUES (20, 1, 100, '1212', '1212', NULL, NULL, NULL, 0, NULL, NULL, 50, 43, '手动添加机构', 0, 0, '2018-08-12 12:32:20', '2018-08-12 12:32:20');
INSERT INTO `tb_platform_shopkeeper` VALUES (23, 1, 102, '12123', '12123', NULL, NULL, NULL, 0, NULL, NULL, 53, 46, '手动添加子机构', 0, 0, '2018-08-12 13:16:02', '2018-08-12 13:16:02');
COMMIT;

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(32) DEFAULT NULL,
  `role_desc` varchar(256) DEFAULT NULL,
  `role_code` varchar(32) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(128) DEFAULT NULL,
  `from_role_id` int(11) DEFAULT NULL,
  `add_user_id` int(11) DEFAULT NULL,
  `add_employ_id` int(11) DEFAULT NULL,
  `add_user_name` varchar(32) DEFAULT NULL,
  `own_type` tinyint(4) DEFAULT NULL,
  `create_type` tinyint(4) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`role_id`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE,
  KEY `ix_own_type` (`own_type`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
BEGIN;
INSERT INTO `tb_role` VALUES (1, 'user', 'user', 'ROLE_USER', NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, 0, NULL, '2018-07-22 00:03:05');
INSERT INTO `tb_role` VALUES (2, 'org', 'org', 'ROLE_ORG', 2, 'org', NULL, NULL, NULL, NULL, 1, NULL, 0, '2018-07-21 23:23:27', '2018-07-22 00:03:00');
INSERT INTO `tb_role` VALUES (3, 'platform', 'platform', 'ROLE_PLATFORM', NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, '2018-07-22 00:02:58');
INSERT INTO `tb_role` VALUES (61, 'org', 'org', 'ROLE_ORG', 43, '手动添加机构', 2, 100, 50, '1212', 1, 0, 0, '2018-08-12 12:32:20', NULL);
INSERT INTO `tb_role` VALUES (64, 'org', 'org', 'ROLE_ORG', 46, '手动添加子机构', 2, 102, 53, '12123', 1, 0, 0, '2018-08-12 13:16:02', NULL);
INSERT INTO `tb_role` VALUES (65, '教练角色', '机构自定义角色', '教练', 43, '手动添加机构', NULL, 100, 50, '1212', 1, 1, 0, '2018-09-05 22:13:36', '2018-09-05 22:13:36');
INSERT INTO `tb_role` VALUES (68, 'dd', '', 'dd', NULL, NULL, NULL, 3, NULL, 'platform', 0, 2, 0, '2018-11-17 12:45:38', '2018-11-17 12:45:38');
INSERT INTO `tb_role` VALUES (69, 'asdf', '', 'd', NULL, NULL, NULL, 3, NULL, 'platform', 0, 2, 0, '2018-11-17 12:49:25', '2018-11-17 12:49:25');
INSERT INTO `tb_role` VALUES (74, 'dsa', '', 'asd', NULL, NULL, NULL, 3, NULL, 'platform', 0, 2, 0, '2018-11-17 12:58:13', '2018-11-17 12:58:13');
INSERT INTO `tb_role` VALUES (75, 'asdf', '', 'asdf', NULL, NULL, NULL, 3, NULL, 'platform', 0, 2, 0, '2018-11-17 12:58:25', '2018-11-17 12:58:25');
INSERT INTO `tb_role` VALUES (76, 'asdasdffasdf', '', 'asdf', NULL, NULL, NULL, 3, NULL, 'platform', 0, 2, 0, '2018-11-17 12:58:59', '2018-11-17 12:58:59');
INSERT INTO `tb_role` VALUES (110, '阿强', '', '666', NULL, NULL, NULL, 3, NULL, 'platform', 0, 2, 0, '2018-11-22 17:40:50', '2018-11-22 17:40:50');
INSERT INTO `tb_role` VALUES (111, '外语1', '', '森森森', NULL, NULL, NULL, 3, NULL, 'platform', 0, 2, 0, '2018-12-07 20:07:47', '2018-12-07 20:07:47');
COMMIT;

-- ----------------------------
-- Table structure for tb_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_permission`;
CREATE TABLE `tb_role_permission` (
  `rp_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `op_id` int(11) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`rp_id`) USING BTREE,
  KEY `ix_role_id` (`role_id`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role_permission
-- ----------------------------
BEGIN;
INSERT INTO `tb_role_permission` VALUES (1, 1, 1, NULL, NULL, NULL, 0, NULL, '2018-07-21 11:17:31');
INSERT INTO `tb_role_permission` VALUES (2, 2, 2, 1, 'org', 1, 0, NULL, '2018-07-21 11:17:30');
INSERT INTO `tb_role_permission` VALUES (3, 3, 3, NULL, NULL, NULL, 0, '2018-08-02 23:25:46', '2018-08-12 10:00:40');
INSERT INTO `tb_role_permission` VALUES (49, 55, 2, 37, '机构版本测试', 38, 0, '2018-08-12 10:11:25', '2018-08-12 10:11:25');
INSERT INTO `tb_role_permission` VALUES (57, 61, 2, 43, '手动添加机构', 46, 0, '2018-08-12 12:44:42', '2018-09-05 22:33:45');
INSERT INTO `tb_role_permission` VALUES (58, 64, 2, 46, '手动添加子机构', 47, 0, '2018-08-12 13:16:02', '2018-08-12 13:16:02');
INSERT INTO `tb_role_permission` VALUES (59, 65, 8, 43, '手动添加机构', 48, 0, NULL, '2018-09-05 22:35:06');
COMMIT;

-- ----------------------------
-- Table structure for tb_secret_key
-- ----------------------------
DROP TABLE IF EXISTS `tb_secret_key`;
CREATE TABLE `tb_secret_key` (
  `key_id` int(11) NOT NULL AUTO_INCREMENT,
  `key_value` varchar(2048) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`key_id`) USING BTREE,
  KEY `ix_key_value` (`key_value`(255)) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_sys_message
-- ----------------------------
DROP TABLE IF EXISTS `tb_sys_message`;
CREATE TABLE `tb_sys_message` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `message_content` varchar(256) DEFAULT NULL,
  `sender_org_id` int(11) DEFAULT NULL,
  `sender_org_name` varchar(256) DEFAULT NULL,
  `receiver_user_id` int(11) DEFAULT NULL,
  `receiver_user_name` varchar(32) DEFAULT NULL,
  `receiver_phone` varchar(24) DEFAULT NULL,
  `rule_id` int(11) DEFAULT NULL,
  `rule_name` varchar(64) DEFAULT NULL,
  `rule_type` tinyint(4) DEFAULT NULL,
  `msg_send_channel` tinyint(4) DEFAULT NULL,
  `send_time` datetime DEFAULT NULL,
  `message_type` tinyint(4) DEFAULT '0',
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`message_id`) USING BTREE,
  KEY `ix_sender_org_id` (`sender_org_id`) USING BTREE,
  KEY `ix_receiver_user_id` (`receiver_user_id`) USING BTREE,
  KEY `ix_rule_id` (`rule_id`) USING BTREE,
  KEY `ix_rule_type` (`rule_type`) USING BTREE,
  KEY `ix_msg_send_channel` (`msg_send_channel`) USING BTREE,
  KEY `ix_create_time` (`create_time`) USING BTREE,
  KEY `ix_state` (`state`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_sys_message_rule
-- ----------------------------
DROP TABLE IF EXISTS `tb_sys_message_rule`;
CREATE TABLE `tb_sys_message_rule` (
  `omr_id` int(11) NOT NULL AUTO_INCREMENT,
  `rule_name` varchar(64) DEFAULT NULL,
  `msg_content_template` varchar(256) DEFAULT NULL,
  `rule_type` tinyint(4) DEFAULT NULL,
  `msg_send_channel` tinyint(4) DEFAULT NULL,
  `send_type` tinyint(4) DEFAULT NULL,
  `send_crontab` varchar(12) DEFAULT NULL,
  `send_time` datetime DEFAULT NULL,
  `platform_audit_state` tinyint(4) DEFAULT NULL,
  `add_user_Id` int(11) DEFAULT NULL,
  `employe_id` int(11) DEFAULT NULL,
  `add_user_name` varchar(32) DEFAULT NULL,
  `audit_user_id` int(11) DEFAULT NULL,
  `audit_user_name` varchar(32) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `remark` varchar(256) DEFAULT NULL,
  `message_type` tinyint(4) DEFAULT '0',
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`omr_id`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE,
  KEY `ix_audit_user_id` (`audit_user_id`) USING BTREE,
  KEY `ix_add_user_id` (`add_user_Id`) USING BTREE,
  KEY `ix_create_time` (`create_time`) USING BTREE,
  KEY `ix_state` (`state`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_sys_message_rule
-- ----------------------------
BEGIN;
INSERT INTO `tb_sys_message_rule` VALUES (1, '到期预警', '【优成长】xxx您在XXX机构的课程xxx快到期了，请尽快完成续费，以便我们更好的为您提供服务。', 0, 2, 0, '* * * * *', '2018-12-12 02:02:02', 2, 105, 58, '游泳教练', 3, 'platform', 43, '手动添加机构', '优成长到期预警', 1, 0, '2018-09-09 21:47:24', '2018-09-09 21:47:24');
COMMIT;

-- ----------------------------
-- Table structure for tb_sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_sys_permission`;
CREATE TABLE `tb_sys_permission` (
  `permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `value` varchar(256) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL,
  `own_type` tinyint(4) DEFAULT NULL,
  `rank` int(11) DEFAULT NULL,
  `is_show` tinyint(4) DEFAULT NULL,
  `parent_permission_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`permission_id`) USING BTREE,
  KEY `ix_type` (`type`) USING BTREE,
  KEY `ix_own_type` (`own_type`) USING BTREE,
  KEY `ix_name` (`name`(30)) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_sys_permission
-- ----------------------------
BEGIN;
INSERT INTO `tb_sys_permission` VALUES (1, 'user', '/api/user', 0, 0, 2, 1, 1, NULL, '2018-07-20 22:25:01', '2018-08-02 22:04:44');
INSERT INTO `tb_sys_permission` VALUES (2, 'org', '/api/org', 0, 2, 1, 1, 0, NULL, '2018-07-20 22:30:22', '2018-07-20 22:30:25');
INSERT INTO `tb_sys_permission` VALUES (3, 'platform', '/api/platform', 0, 0, 0, 1, 0, NULL, '2018-08-02 22:03:46', '2018-08-02 22:03:49');
INSERT INTO `tb_sys_permission` VALUES (4, 'testuser', '/test/user', 0, 0, 2, 1, 1, NULL, '2018-07-20 22:25:01', '2018-07-20 23:24:50');
INSERT INTO `tb_sys_permission` VALUES (5, 'product1', '/test/org/product1', 0, 2, 1, 1, 0, NULL, '2018-07-20 22:30:22', '2018-07-20 22:30:25');
INSERT INTO `tb_sys_permission` VALUES (6, 'product2', '/test/org/product2', 0, 2, 1, 1, 0, NULL, '2018-07-20 22:30:22', '2018-07-20 22:30:25');
INSERT INTO `tb_sys_permission` VALUES (7, 'testplatform', '/test/platform', 0, 0, 0, 1, 0, NULL, '2018-08-02 22:03:46', '2018-08-02 22:31:56');
INSERT INTO `tb_sys_permission` VALUES (8, '机构签到', '/org/employee/checkin/add', 0, 2, 1, 1, 0, NULL, NULL, '2018-09-05 22:17:01');
COMMIT;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(32) NOT NULL,
  `login_password` varchar(64) NOT NULL,
  `phone` varchar(24) NOT NULL,
  `user_real_name` varchar(32) DEFAULT NULL,
  `idcard` varchar(18) DEFAULT NULL,
  `age` smallint(6) DEFAULT NULL,
  `birthday` varchar(12) DEFAULT NULL,
  `gender` tinyint(4) DEFAULT NULL,
  `reg_source` tinyint(4) DEFAULT NULL,
  `reg_terminal` varchar(32) DEFAULT NULL,
  `province` varchar(24) DEFAULT NULL,
  `city` varchar(56) DEFAULT NULL,
  `icon` varchar(128) DEFAULT NULL,
  `county` varchar(56) DEFAULT NULL,
  `address` varchar(256) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  `consume_count` int(11) DEFAULT '0',
  `state` tinyint(4) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`) USING BTREE,
  KEY `ix_login_name` (`login_name`) USING BTREE,
  KEY `ix_phone` (`phone`) USING BTREE,
  KEY `ix_email` (`email`) USING BTREE,
  KEY `ix_state` (`state`) USING BTREE,
  KEY `ix_consume_count` (`consume_count`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
BEGIN;
INSERT INTO `tb_user` VALUES (1, 'huawei', '$2a$10$0cT.6EZWqgQyfOmob2OtXOTcp1cRXov5b3sfQPuugpW.vHe8MZa4.', '111', 'huawei', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, NULL, '2018-07-21 10:47:49');
INSERT INTO `tb_user` VALUES (2, 'org', '$2a$10$0cT.6EZWqgQyfOmob2OtXOTcp1cRXov5b3sfQPuugpW.vHe8MZa4.', '111', 'org', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, NULL, '2018-07-30 22:10:15');
INSERT INTO `tb_user` VALUES (3, 'platform', '$2a$10$.1DZE68HBhh9ZdmY4oSoC.YC.6TcSxXJRWxuSBpvOCtuHg5vUsnvy', '111', 'platform', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, NULL, '2018-08-02 23:23:09');
INSERT INTO `tb_user` VALUES (100, '1212', '$2a$10$.1DZE68HBhh9ZdmY4oSoC.YC.6TcSxXJRWxuSBpvOCtuHg5vUsnvy', '1212', '1212', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '', 0, 0, '2018-08-12 12:32:20', '2018-09-11 21:15:50');
INSERT INTO `tb_user` VALUES (102, '12123', '$2a$10$.1DZE68HBhh9ZdmY4oSoC.YC.6TcSxXJRWxuSBpvOCtuHg5vUsnvy', '12123', '12123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '', 0, 0, '2018-08-12 13:16:02', '2018-09-05 22:11:23');
INSERT INTO `tb_user` VALUES (105, '1234', '$2a$10$.1DZE68HBhh9ZdmY4oSoC.YC.6TcSxXJRWxuSBpvOCtuHg5vUsnvy', '1234', '游泳教练', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '', 0, 0, '2018-08-12 14:17:23', '2018-09-05 22:11:27');
INSERT INTO `tb_user` VALUES (109, '12456', '$2a$10$.1DZE68HBhh9ZdmY4oSoC.YC.6TcSxXJRWxuSBpvOCtuHg5vUsnvy', '12456', '学员1', NULL, NULL, '2010-12-05', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '', 0, 0, '2018-08-13 22:14:57', '2018-09-05 22:11:29');
INSERT INTO `tb_user` VALUES (110, '110', '$2a$10$.1DZE68HBhh9ZdmY4oSoC.YC.6TcSxXJRWxuSBpvOCtuHg5vUsnvy', '110', '篮球教练', NULL, NULL, '2000-12-12', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '', 0, 0, '2018-09-04 20:04:05', '2018-09-05 22:11:30');
INSERT INTO `tb_user` VALUES (111, '11', '11', '111', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for tb_user_addressee
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_addressee`;
CREATE TABLE `tb_user_addressee` (
  `addressee_id` int(11) NOT NULL AUTO_INCREMENT,
  `province` varchar(24) DEFAULT NULL,
  `city` varchar(32) DEFAULT NULL,
  `county` varchar(32) DEFAULT NULL,
  `address` varchar(256) DEFAULT NULL,
  `receive_user_name` varchar(32) DEFAULT NULL,
  `receive_user_phone` varchar(24) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`addressee_id`) USING BTREE,
  KEY `ix_user_id` (`user_id`) USING BTREE,
  KEY `ix_state` (`state`) USING BTREE,
  KEY `ix_receive_user_phone` (`receive_user_phone`) USING BTREE,
  KEY `ix_receive_user_name` (`receive_user_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user_addressee
-- ----------------------------
BEGIN;
INSERT INTO `tb_user_addressee` VALUES (1, '湖北', '咸宁', '通山县', '洪港镇xxx', 'hua', '121212121212', 61, NULL, 0, '2018-07-30 22:09:21', '2018-07-30 22:09:21');
INSERT INTO `tb_user_addressee` VALUES (2, '湖北', '咸宁', '通山县', '洪港镇车田', 'hua', '121212121212', 61, 'huawei', 0, '2018-07-30 22:25:03', '2018-07-30 22:25:03');
INSERT INTO `tb_user_addressee` VALUES (3, '湖北', '咸宁', '通山县', '洪港镇xxx', 'hua', '121212121212', 100, '1212', 0, '2018-09-12 19:28:48', '2018-09-12 19:28:48');
COMMIT;

-- ----------------------------
-- Table structure for tb_user_addressee_tag
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_addressee_tag`;
CREATE TABLE `tb_user_addressee_tag` (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT,
  `addressee_id` int(11) DEFAULT NULL,
  `tag_name` varchar(32) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`tag_id`) USING BTREE,
  KEY `ix_addressee_id` (`addressee_id`) USING BTREE,
  KEY `ix_user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user_addressee_tag
-- ----------------------------
BEGIN;
INSERT INTO `tb_user_addressee_tag` VALUES (1, 1, '家', 61, NULL, 0, '2018-07-30 22:09:21', '2018-07-30 22:09:21');
INSERT INTO `tb_user_addressee_tag` VALUES (2, 1, '老乡', 61, NULL, 0, '2018-07-30 22:09:21', '2018-07-30 22:09:21');
INSERT INTO `tb_user_addressee_tag` VALUES (3, 2, '家', 61, 'huawei', 2, '2018-07-30 22:25:03', '2018-07-30 22:31:37');
INSERT INTO `tb_user_addressee_tag` VALUES (4, 2, '老乡', 61, 'huawei', 2, '2018-07-30 22:25:03', '2018-07-30 22:31:37');
INSERT INTO `tb_user_addressee_tag` VALUES (5, 2, '学校', 61, 'huawei', 2, '2018-07-30 22:25:03', '2018-07-30 22:31:37');
INSERT INTO `tb_user_addressee_tag` VALUES (6, 2, '家', 61, 'huawei', 2, '2018-07-30 22:31:37', '2018-07-30 22:32:18');
INSERT INTO `tb_user_addressee_tag` VALUES (7, 2, '老乡', 61, 'huawei', 2, '2018-07-30 22:31:37', '2018-07-30 22:32:18');
INSERT INTO `tb_user_addressee_tag` VALUES (8, 2, '学校', 61, 'huawei', 2, '2018-07-30 22:31:37', '2018-07-30 22:32:18');
INSERT INTO `tb_user_addressee_tag` VALUES (9, 2, '公司', 61, 'huawei', 2, '2018-07-30 22:31:37', '2018-07-30 22:32:18');
INSERT INTO `tb_user_addressee_tag` VALUES (10, 2, '家', 61, 'huawei', 2, '2018-07-30 22:32:19', '2018-07-30 22:32:41');
INSERT INTO `tb_user_addressee_tag` VALUES (11, 2, '老乡', 61, 'huawei', 2, '2018-07-30 22:32:19', '2018-07-30 22:32:41');
INSERT INTO `tb_user_addressee_tag` VALUES (12, 2, '学校', 61, 'huawei', 2, '2018-07-30 22:32:19', '2018-07-30 22:32:41');
INSERT INTO `tb_user_addressee_tag` VALUES (13, 2, '公司', 61, 'huawei', 2, '2018-07-30 22:32:19', '2018-07-30 22:32:41');
INSERT INTO `tb_user_addressee_tag` VALUES (14, 2, '家', 61, 'huawei', 0, '2018-07-30 22:32:42', '2018-07-30 22:32:42');
INSERT INTO `tb_user_addressee_tag` VALUES (15, 2, '老乡', 61, 'huawei', 0, '2018-07-30 22:32:42', '2018-07-30 22:32:42');
INSERT INTO `tb_user_addressee_tag` VALUES (16, 2, '学校', 61, 'huawei', 0, '2018-07-30 22:32:42', '2018-07-30 22:32:42');
INSERT INTO `tb_user_addressee_tag` VALUES (17, 2, '公司', 61, 'huawei', 0, '2018-07-30 22:32:42', '2018-07-30 22:32:42');
INSERT INTO `tb_user_addressee_tag` VALUES (18, 3, '家', 100, '1212', 0, '2018-09-12 19:28:48', '2018-09-12 19:28:48');
INSERT INTO `tb_user_addressee_tag` VALUES (19, 3, '老乡', 100, '1212', 0, '2018-09-12 19:28:48', '2018-09-12 19:28:48');
INSERT INTO `tb_user_addressee_tag` VALUES (20, 3, '学校', 100, '1212', 0, '2018-09-12 19:28:48', '2018-09-12 19:28:48');
COMMIT;

-- ----------------------------
-- Table structure for tb_user_attend_class_record
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_attend_class_record`;
CREATE TABLE `tb_user_attend_class_record` (
  `uacr_id` int(11) NOT NULL AUTO_INCREMENT,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `checkin_type` tinyint(4) DEFAULT NULL,
  `begin_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `course_name` varchar(128) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  `class_name` varchar(128) DEFAULT NULL,
  `man_coach_employe_id` int(11) DEFAULT NULL,
  `man_coach_user_id` int(11) DEFAULT NULL,
  `man_coach_user_name` varchar(32) DEFAULT NULL,
  `second_category_name` varchar(128) DEFAULT NULL,
  `second_category_id` int(11) DEFAULT NULL,
  `progress` int(11) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`uacr_id`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE,
  KEY `ix_user_id` (`user_id`) USING BTREE,
  KEY `ix_course_id` (`course_id`) USING BTREE,
  KEY `ix_class_id` (`class_id`) USING BTREE,
  KEY `ix_course_name` (`course_name`(30)) USING BTREE,
  KEY `ix_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user_attend_class_record
-- ----------------------------
BEGIN;
INSERT INTO `tb_user_attend_class_record` VALUES (1, 43, '手动添加机构', 100, '1212', 3, '2018-09-06 21:42:21', '2018-09-06 22:05:35', 6, '篮球', 1, '篮球课', 58, 105, '游泳教练', '篮球', 5, NULL, 0, '2018-09-06 21:42:21', '2018-09-06 21:42:21');
COMMIT;

-- ----------------------------
-- Table structure for tb_user_evaluate
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_evaluate`;
CREATE TABLE `tb_user_evaluate` (
  `evaluate_id` int(11) NOT NULL AUTO_INCREMENT,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `evaluate_type` tinyint(4) DEFAULT NULL,
  `evaluate_content` varchar(256) DEFAULT NULL,
  `evaluate_subject` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `liked` tinyint(4) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`evaluate_id`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE,
  KEY `ix_state` (`state`) USING BTREE,
  KEY `ix_create_time` (`create_time`) USING BTREE,
  KEY `ix_user_id` (`user_id`) USING BTREE,
  KEY `ix_evaluate_type` (`evaluate_type`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_user_invoice
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_invoice`;
CREATE TABLE `tb_user_invoice` (
  `invoice_id` int(11) NOT NULL AUTO_INCREMENT,
  `invoice_title` varchar(256) DEFAULT NULL,
  `issued_type` tinyint(4) DEFAULT NULL,
  `invoice_type` tinyint(4) DEFAULT NULL,
  `tax_no` varchar(32) DEFAULT NULL,
  `bank_name` varchar(64) DEFAULT NULL,
  `back_account` varchar(32) DEFAULT NULL,
  `reg_address` varchar(128) DEFAULT NULL,
  `company_phone` varchar(32) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`invoice_id`) USING BTREE,
  KEY `ix_user_id` (`user_id`) USING BTREE,
  KEY `ix_state` (`state`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user_invoice
-- ----------------------------
BEGIN;
INSERT INTO `tb_user_invoice` VALUES (1, '杭州优成长', 1, 0, '12121212', '招商', '121212121212', '深圳', '110', 78, 'huawei', 0, '2018-08-05 12:11:33', '2018-09-11 21:15:55');
INSERT INTO `tb_user_invoice` VALUES (2, '优成长111', 1, 0, '12121212', '招商', '121212121212', '深圳', '110', 78, 'huawei', 0, '2018-08-05 12:13:19', '2018-09-11 21:15:57');
INSERT INTO `tb_user_invoice` VALUES (3, '优成长111', 1, 0, '12121212', '招商', '121212121212', '深圳', '110', 100, '1212', 0, '2018-09-11 21:12:36', '2018-09-11 21:15:58');
COMMIT;

-- ----------------------------
-- Table structure for tb_user_relation
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_relation`;
CREATE TABLE `tb_user_relation` (
  `relation_id` int(11) NOT NULL AUTO_INCREMENT,
  `current_user_id` int(11) DEFAULT NULL,
  `relation_user_id` int(11) DEFAULT NULL,
  `relation_type` tinyint(4) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`relation_id`) USING BTREE,
  KEY `ix_current_user_id` (`current_user_id`) USING BTREE,
  KEY `ix_relation_user_id` (`relation_user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role` (
  `ur_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_Id` int(11) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(128) DEFAULT NULL,
  `own_type` tinyint(4) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ur_id`) USING BTREE,
  KEY `ix_user_id` (`user_id`) USING BTREE,
  KEY `ix_org_id` (`org_id`) USING BTREE,
  KEY `ix_own_type` (`own_type`) USING BTREE,
  KEY `ix_role_id` (`role_Id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user_role
-- ----------------------------
BEGIN;
INSERT INTO `tb_user_role` VALUES (1, 2, 2, 1, 'org', 1, 0, '2018-07-14 11:53:57', '2018-07-21 23:19:35');
INSERT INTO `tb_user_role` VALUES (2, 1, 1, NULL, NULL, 2, 0, NULL, '2018-07-21 10:48:53');
INSERT INTO `tb_user_role` VALUES (3, 3, 3, NULL, NULL, 0, 0, '2018-08-02 23:24:40', '2018-08-12 10:02:25');
INSERT INTO `tb_user_role` VALUES (97, 100, 1, NULL, NULL, 2, 0, '2018-08-12 12:32:20', NULL);
INSERT INTO `tb_user_role` VALUES (98, 100, 61, 43, '手动添加机构', 1, 0, '2018-08-12 12:32:20', NULL);
INSERT INTO `tb_user_role` VALUES (102, 102, 1, NULL, NULL, 2, 0, '2018-08-12 13:16:02', NULL);
INSERT INTO `tb_user_role` VALUES (103, 102, 64, 46, '手动添加子机构', 1, 0, '2018-08-12 13:16:02', NULL);
INSERT INTO `tb_user_role` VALUES (110, 109, 1, NULL, NULL, 2, 0, '2018-08-13 22:14:57', NULL);
INSERT INTO `tb_user_role` VALUES (111, 110, 1, NULL, NULL, 2, 0, '2018-09-04 20:04:05', NULL);
INSERT INTO `tb_user_role` VALUES (112, 105, 65, 43, '手动添加机构', 1, 0, '2018-09-05 22:41:21', '2018-09-05 22:41:21');
COMMIT;

-- ----------------------------
-- Table structure for tb_user_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_student`;
CREATE TABLE `tb_user_student` (
  `user_student_id` int(11) NOT NULL AUTO_INCREMENT,
  `guardian_user_id` int(11) DEFAULT NULL,
  `guardian_user_name` varchar(32) DEFAULT NULL,
  `student_user_id` int(11) DEFAULT NULL,
  `student_user_name` varchar(32) DEFAULT NULL,
  `total_join_num` int(11) DEFAULT NULL,
  `current_course_num` int(11) DEFAULT NULL,
  `gender` tinyint(4) DEFAULT NULL,
  `relation_type` tinyint(4) DEFAULT NULL,
  `phone` varchar(24) DEFAULT NULL,
  `birthday` varchar(12) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_student_id`) USING BTREE,
  KEY `ix_guardian_user_id` (`guardian_user_id`) USING BTREE,
  KEY `ix_student_user_id` (`student_user_id`) USING BTREE,
  KEY `ix_state` (`state`) USING BTREE,
  KEY `ix_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user_student
-- ----------------------------
BEGIN;
INSERT INTO `tb_user_student` VALUES (4, 100, '1212', 109, '学员1', NULL, NULL, 1, 0, '12456', '2010-12-05', 0, '2018-08-13 22:14:57', '2018-08-13 22:14:57');
COMMIT;

-- ----------------------------
-- Table structure for tb_week_org_totality_statistics
-- ----------------------------
DROP TABLE IF EXISTS `tb_week_org_totality_statistics`;
CREATE TABLE `tb_week_org_totality_statistics` (
  `wots_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `org_id` int(11) DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `org_count` int(11) DEFAULT NULL,
  `sale_amount` int(11) DEFAULT NULL,
  `teacher_count` int(11) DEFAULT NULL,
  `course_count` int(11) DEFAULT NULL,
  `total_user_count` int(11) DEFAULT NULL,
  `current_service_user_count` int(11) DEFAULT NULL,
  `buy_user_count` int(11) DEFAULT NULL,
  `like_user_count` int(11) DEFAULT NULL,
  `cancel_order_user_count` int(11) DEFAULT NULL,
  `order_count` int(11) DEFAULT NULL,
  `cancel_order_count` int(11) DEFAULT NULL,
  `pv_count` int(11) DEFAULT NULL,
  `uv_count` int(11) DEFAULT NULL,
  `user_exponent` int(11) DEFAULT NULL,
  `class_count` int(11) DEFAULT '0',
  `place_count` int(11) DEFAULT '0',
  `week_date` date DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`wots_id`) USING BTREE,
  KEY `ix_week_date_org_id` (`week_date`,`org_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_week_totality_statistics
-- ----------------------------
DROP TABLE IF EXISTS `tb_week_totality_statistics`;
CREATE TABLE `tb_week_totality_statistics` (
  `wts_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `sale_amount` int(11) DEFAULT NULL,
  `org_count` int(11) DEFAULT NULL,
  `teacher_count` int(11) DEFAULT NULL,
  `course_count` int(11) DEFAULT NULL,
  `total_user_count` int(11) DEFAULT NULL,
  `current_service_user_count` int(11) DEFAULT NULL,
  `buy_user_count` int(11) DEFAULT NULL,
  `like_user_count` int(11) DEFAULT NULL,
  `cancel_order_user_count` int(11) DEFAULT NULL,
  `order_count` int(11) DEFAULT NULL,
  `cancel_order_count` int(11) DEFAULT NULL,
  `pv_count` int(11) DEFAULT NULL,
  `uv_count` int(11) DEFAULT NULL,
  `user_exponent` int(11) DEFAULT NULL,
  `class_count` int(11) DEFAULT '0',
  `place_count` int(11) DEFAULT '0',
  `week_date` date DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`wts_id`) USING BTREE,
  KEY `ix_week_date` (`week_date`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- View structure for vm_org_coach
-- ----------------------------
DROP VIEW IF EXISTS `vm_org_coach`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`127.0.0.1` SQL SECURITY DEFINER VIEW `vm_org_coach` AS select `tb_org_employee`.`org_id` AS `org_id`,`tb_org_employee`.`org_name` AS `org_name`,`tb_org_employee`.`user_id` AS `user_id`,`tb_org_employee`.`user_name` AS `user_name`,`tb_org_employee`.`phone` AS `phone`,`tb_org_employee`.`work_start_date` AS `work_start_date`,`tb_org_employee`.`gender` AS `gender`,`tb_org_employee`.`state` AS `state`,`tb_org_employee`.`create_time` AS `create_time`,`tb_org_employee_skill`.`second_category_id` AS `second_category_id`,`tb_org_employee_skill`.`second_category_name` AS `second_category_name`,`tb_org_employee_skill`.`first_category_id` AS `first_category_id`,`tb_org_employee_skill`.`first_category_name` AS `first_category_name`,`tb_org_employee`.`employe_state` AS `employe_state`,`tb_org_employee`.`edu_background` AS `edu_background`,`tb_org_employee`.`job_type` AS `job_type`,`tb_org_employee`.`department_name` AS `department_name`,`tb_org_employee`.`department_id` AS `department_id`,`tb_org_employee`.`ex_mail` AS `ex_mail`,`tb_org_employee`.`birthday` AS `birthday`,`tb_org_employee`.`idcard` AS `idcard`,`tb_org_employee`.`is_coach` AS `is_coach`,`tb_org_employee`.`position` AS `position`,`tb_org_employee`.`org_account_type` AS `org_account_type`,`tb_org_employee`.`icon` AS `icon`,`tb_org_employee`.`remark` AS `remark`,`tb_org_employee`.`last_update_time` AS `last_update_time`,`tb_org_employee`.`employe_id` AS `employe_id`,`tb_org_employee_skill`.`oes_id` AS `oes_id` from (`tb_org_employee` left join `tb_org_employee_skill` on((`tb_org_employee_skill`.`employe_id` = `tb_org_employee`.`employe_id`))) where (`tb_org_employee`.`is_coach` = 0);

-- ----------------------------
-- View structure for vm_org_course
-- ----------------------------
DROP VIEW IF EXISTS `vm_org_course`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`127.0.0.1` SQL SECURITY DEFINER VIEW `vm_org_course` AS select `tb_org_course`.`course_id` AS `course_id`,`tb_org_course`.`course_name` AS `course_name`,`tb_org_course`.`course_type` AS `course_type`,`tb_org_course`.`first_category_id` AS `first_category_id`,`tb_org_course`.`first_category_name` AS `first_category_name`,`tb_org_course`.`second_category_id` AS `second_category_id`,`tb_org_course`.`second_category_name` AS `second_category_name`,`tb_org_course`.`cct_id` AS `cct_id`,`tb_org_course`.`class_type_name` AS `class_type_name`,`tb_org_course`.`start_type` AS `start_type`,`tb_org_course`.`begin_date` AS `begin_date`,`tb_org_course`.`end_date` AS `end_date`,`tb_org_course`.`is_setting_time` AS `is_setting_time`,`tb_org_course`.`start_user_num` AS `start_user_num`,`tb_org_course`.`org_id` AS `org_id`,`tb_org_course`.`org_name` AS `org_name`,`tb_org_course`.`remark` AS `remark`,`tb_org_course`.`state` AS `state`,`tb_org_course`.`create_time` AS `create_time`,`tb_org_course`.`last_update_time` AS `last_update_time`,`tb_org_course_price`.`price` AS `price`,`tb_org_course_price`.`cp_id` AS `cp_id`,`tb_org_course_price`.`course_time` AS `course_time`,`tb_org_course_price`.`total_course_time` AS `total_course_time`,`tb_org_course_price`.`course_count` AS `course_count` from (`tb_org_course` left join `tb_org_course_price` on((`tb_org_course`.`course_id` = `tb_org_course_price`.`course_id`)));

-- ----------------------------
-- View structure for vm_org_place
-- ----------------------------
DROP VIEW IF EXISTS `vm_org_place`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`127.0.0.1` SQL SECURITY DEFINER VIEW `vm_org_place` AS select `tb_org_place`.`place_id` AS `place_id`,`tb_org_place`.`place_full_name` AS `place_full_name`,`tb_org_place`.`place_name` AS `place_name`,`tb_org_place`.`org_id` AS `org_id`,`tb_org_place`.`org_name` AS `org_name`,`tb_org_place`.`province` AS `province`,`tb_org_place`.`city` AS `city`,`tb_org_place`.`county` AS `county`,`tb_org_place`.`address` AS `address`,`tb_org_place`.`x_coord` AS `x_coord`,`tb_org_place`.`y_coord` AS `y_coord`,`tb_org_place`.`own_type` AS `own_type`,`tb_org_place`.`area` AS `area`,`tb_org_place`.`begin_use_date` AS `begin_use_date`,`tb_org_place`.`end_use_date` AS `end_use_date`,`tb_org_place`.`remark` AS `remark`,`tb_org_place`.`state` AS `state`,`tb_org_place`.`create_time` AS `create_time`,`tb_org_place`.`last_update_time` AS `last_update_time`,`tb_org_place_facility`.`opf_id` AS `opf_id`,`tb_org_place_facility`.`facility_id` AS `facility_id`,`tb_org_place_facility`.`facility_name` AS `facility_name`,`tb_org_place_facility`.`first_category_id` AS `first_category_id`,`tb_org_place_facility`.`first_category_name` AS `first_category_name`,`tb_org_place_facility`.`second_category_id` AS `second_category_id`,`tb_org_place_facility`.`second_category_name` AS `second_category_name` from (`tb_org_place` left join `tb_org_place_facility` on((`tb_org_place`.`place_id` = `tb_org_place_facility`.`place_id`)));

SET FOREIGN_KEY_CHECKS = 1;
