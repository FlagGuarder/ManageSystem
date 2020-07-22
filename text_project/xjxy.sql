/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 50623
 Source Host           : localhost:3306
 Source Schema         : xjxy

 Target Server Type    : MySQL
 Target Server Version : 50623
 File Encoding         : 65001

 Date: 02/09/2019 16:24:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dept_inf
-- ----------------------------
DROP TABLE IF EXISTS `dept_inf`;
CREATE TABLE `dept_inf`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dept_inf
-- ----------------------------
INSERT INTO `dept_inf` VALUES (1, '默认', '无');
INSERT INTO `dept_inf` VALUES (2, '财务部', '无');
INSERT INTO `dept_inf` VALUES (3, '学术部', '无');
INSERT INTO `dept_inf` VALUES (4, '教学部', '优秀部门');
INSERT INTO `dept_inf` VALUES (5, '技术部', '无');
INSERT INTO `dept_inf` VALUES (6, '人事部', '垃圾部门');
INSERT INTO `dept_inf` VALUES (7, '网络部', '牛逼部门');

-- ----------------------------
-- Table structure for employee_inf
-- ----------------------------
DROP TABLE IF EXISTS `employee_inf`;
CREATE TABLE `employee_inf`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DEPT_ID` int(11) NOT NULL,
  `JOB_ID` int(11) NOT NULL,
  `NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CARD_ID` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ADDRESS` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `POST_CODE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TEL` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PHONE` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `QQ_NUM` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EMAIL` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `SEX` int(11) NOT NULL DEFAULT 1,
  `PARTY` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BIRTHDAY` datetime(0) NULL DEFAULT NULL,
  `RACE` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EDUCATION` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SPECIALITY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `HOBBY` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `REMARK` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATE_DATE` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `FK_EMP_DEPT`(`DEPT_ID`) USING BTREE,
  INDEX `FK_EMP_JOB`(`JOB_ID`) USING BTREE,
  CONSTRAINT `FK_EMP_DEPT` FOREIGN KEY (`DEPT_ID`) REFERENCES `dept_inf` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_EMP_JOB` FOREIGN KEY (`JOB_ID`) REFERENCES `job_inf` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of employee_inf
-- ----------------------------
INSERT INTO `employee_inf` VALUES (2, 3, 2, '小明', '123456789012345678', '广东省深圳', '234242', '23424333', '13610561160', '324234', '54555@qq.cn', 1, '群众', '1980-07-07 00:00:00', '汉', '本科', '计算机', '无', '无', '2019-02-19 15:32:44');
INSERT INTO `employee_inf` VALUES (3, 2, 2, '旺财', '123456789012345670', '广东省深圳', '23424', '23424333', '13610561161', '324234', 'dsafasfd@dsa.com', 1, '群众', '1980-07-07 00:00:00', '汉', '本科', '计算机', '无', '无', '2019-02-19 15:37:20');
INSERT INTO `employee_inf` VALUES (4, 3, 2, '欧阳锋', '123456789012345678', '广东省深圳', '234242', '23424333', '13610561160', '324234', '54555@qq.cn', 1, '群众', '1980-07-07 00:00:00', '汉', '本科', '计算机', '无', '无', '2019-02-19 15:32:44');
INSERT INTO `employee_inf` VALUES (5, 7, 2, '欧阳娜娜', '123456789012345678', '广东省深圳', '234242', '23424333', '13610561160', '324234', '54555@qq.cn', 1, '群众', '1980-07-07 00:00:00', '汉', '本科', '计算机', '无', '无', '2019-02-19 15:32:44');

-- ----------------------------
-- Table structure for job_inf
-- ----------------------------
DROP TABLE IF EXISTS `job_inf`;
CREATE TABLE `job_inf`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of job_inf
-- ----------------------------
INSERT INTO `job_inf` VALUES (1, '默认', '无');
INSERT INTO `job_inf` VALUES (2, '工程师', '无');
INSERT INTO `job_inf` VALUES (3, '会计师', '无');
INSERT INTO `job_inf` VALUES (4, '普通职员', '无');
INSERT INTO `job_inf` VALUES (5, 'Java程序员', '');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `noticename` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `title` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stuname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (3, '会议通知', '校团委会议', '2019-07-16 10:01:54', '管理员', '<h1 style=\"font-size: 32px; font-weight: bold; border-bottom: 2px solid rgb(204, 204, 204); padding: 0px 4px 0px 0px; text-align: center; margin: 0px 0px 20px;\">会议通知</h1><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;今天下午在科研楼4楼开会！<br/></p>');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `classinfo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1702',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `number`(`number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (13, '170809011047', '蒋庚宇', '1234', '1702', NULL);
INSERT INTO `student` VALUES (17, '170809011055', '王奥博', '1234', '1702', NULL);
INSERT INTO `student` VALUES (18, '170809011056', '王瞾之', '1234', '1702', NULL);
INSERT INTO `student` VALUES (20, '170809011058', '王丽丽', 'mmmmmm', '1702', NULL);
INSERT INTO `student` VALUES (23, '170809011061', '王文瑞', '1234', '1702', NULL);
INSERT INTO `student` VALUES (24, '170809011062', '王子琦', '1234', '1702', NULL);
INSERT INTO `student` VALUES (25, '170809011063', '温伟杰', '1234', '1702', NULL);
INSERT INTO `student` VALUES (26, '170809011064', '吴文涛', '1234', '1702', NULL);
INSERT INTO `student` VALUES (27, '170809011065', '武文博', '1234', '1702', NULL);
INSERT INTO `student` VALUES (28, '170809011066', '辛鑫', '1234', '1702', NULL);
INSERT INTO `student` VALUES (30, '170809011069', '杨钰蓉', '1234', '1702', NULL);
INSERT INTO `student` VALUES (31, '170809011070', '姚姣姣', '1234', '1702', NULL);
INSERT INTO `student` VALUES (32, '170809011072', '张哲', '1234', '1702', NULL);
INSERT INTO `student` VALUES (33, '170809011073', '赵柯轩', '1234', '1702', NULL);
INSERT INTO `student` VALUES (34, '171209021043', '吴学礼', '1234', '1702', NULL);
INSERT INTO `student` VALUES (35, '170809011051', '马士尧', '1234', '1702', NULL);
INSERT INTO `student` VALUES (36, '170809011074', '赵宣亦', '1234', '1702', NULL);
INSERT INTO `student` VALUES (37, '170806011044', '杨子敬', '1234', '1702', NULL);
INSERT INTO `student` VALUES (38, '171011011132', '王刚', '1234', '1702', NULL);
INSERT INTO `student` VALUES (39, '170806011049', '刘瑞', '1234', '1702', NULL);
INSERT INTO `student` VALUES (40, '170803011050', '曾子晓', '1234', '1702', NULL);
INSERT INTO `student` VALUES (41, '170809011043', '陈皓妍', '1234', '1702', NULL);
INSERT INTO `student` VALUES (42, '170809011147', '赵伟航', '1234', '1702', NULL);
INSERT INTO `student` VALUES (43, '170809011144', '张高奎', '1234', '1702', NULL);
INSERT INTO `student` VALUES (44, '170809011140', '杨海龙', '1234', '1702', NULL);
INSERT INTO `student` VALUES (45, '170809011134', '王延英', '1234', '1702', NULL);
INSERT INTO `student` VALUES (46, '170809011136', '肖坤山', '1234', '1702', NULL);
INSERT INTO `student` VALUES (47, '170809011121', '李天强', '1234', '1702', NULL);
INSERT INTO `student` VALUES (48, '170808011006', '丁昌勇', '1234', '1702', NULL);
INSERT INTO `student` VALUES (49, '170809011143', '袁荣', '1234', '1702', NULL);
INSERT INTO `student` VALUES (50, '170809011125', '刘昱雯', '1234', '1702', NULL);
INSERT INTO `student` VALUES (51, '170809011112', '陈圆', '1234', '1702', NULL);
INSERT INTO `student` VALUES (52, 'admin', '管理员', '123', '1702', NULL);

SET FOREIGN_KEY_CHECKS = 1;

DROP TABLE IF EXISTS `education`;
CREATE TABLE `education` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

insert into education(name) value('小学');
insert into education(name) value('初中');
insert into education(name) value('高中');
insert into education(name) value('中专');
insert into education(name) value('本科');
insert into education(name) value('大专');
insert into education(name) value('研究生');
insert into education(name) value('博士');

DROP TABLE IF EXISTS `party`;
 CREATE TABLE `party` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

insert into party(name) value('群众');
insert into party(name) value('共青团员');
insert into party(name) value('党员');

DROP TABLE IF EXISTS `file`;
 CREATE TABLE `file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(70) DEFAULT NULL,
  `custom_name` varchar(40) DEFAULT NULL,
  `uploader` varchar(40) DEFAULT NULL,
  `time` datetime,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;