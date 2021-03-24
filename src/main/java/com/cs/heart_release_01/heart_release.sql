/*
 Navicat MySQL Data Transfer

 Source Server         : qi
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : heart_release

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 04/02/2021 20:40:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for collections
-- ----------------------------
DROP TABLE IF EXISTS `collections`;
CREATE TABLE `collections`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `master_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `master_id`(`master_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collections
-- ----------------------------
INSERT INTO `collections` VALUES (3, 2, 2);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `comment_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `mood_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `mood_id`(`mood_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, '这个头像好好看啊！！！', 1, '2021-02-03 21:41:07', 1);
INSERT INTO `comment` VALUES (2, '师弟', 2, '2021-02-04 19:49:35', 1);

-- ----------------------------
-- Table structure for cord
-- ----------------------------
DROP TABLE IF EXISTS `cord`;
CREATE TABLE `cord`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `time` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `grade` bit(1) NULL DEFAULT NULL,
  `text` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cord
-- ----------------------------

-- ----------------------------
-- Table structure for master
-- ----------------------------
DROP TABLE IF EXISTS `master`;
CREATE TABLE `master`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `sex` bit(1) NULL DEFAULT NULL,
  `birthday` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `brief_introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `day_count` int(11) NULL DEFAULT NULL,
  `object_count` int(11) NULL DEFAULT NULL,
  `order_count` int(11) NULL DEFAULT NULL,
  `open_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of master
-- ----------------------------
INSERT INTO `master` VALUES (1, '天空之城', b'1', '1984-05-08', '欢迎大家来咨询我', 1, 1, 1, '3333');
INSERT INTO `master` VALUES (2, '安抚', b'1', '2020-02-03', 'afasd', 2, 2, 2, '4444');
INSERT INTO `master` VALUES (3, 'jack', b'0', '1982-02-03', '你好', 4, 4, 4, '5555');
INSERT INTO `master` VALUES (4, 'hi', b'1', '1977-02-06', '我是咨询师', 2, 3, 4, '6666');
INSERT INTO `master` VALUES (5, 'sdfg', b'1', '2020/2/2', '阿斯蒂芬', 1, 1, 1, '7777');

-- ----------------------------
-- Table structure for mood
-- ----------------------------
DROP TABLE IF EXISTS `mood`;
CREATE TABLE `mood`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `is_anonymous` bit(1) NULL DEFAULT NULL,
  `publish_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mood
-- ----------------------------
INSERT INTO `mood` VALUES (1, 'qq', 'http://heart123.oss-cn-beijing.aliyuncs.com/2021/02/03/9fe8b32379184668b8ab8187f8048c5d.jpg', b'1', '2021-02-03 20:18:50', 1);
INSERT INTO `mood` VALUES (2, '好好看！！！', 'http://heart123.oss-cn-beijing.aliyuncs.com/2021/02/03/9b89f1283f7e4e419ecd7393dcf5fb31.jpg', b'1', '2021-02-03 20:19:52', 2);
INSERT INTO `mood` VALUES (8, NULL, NULL, NULL, NULL, 1);
INSERT INTO `mood` VALUES (9, NULL, NULL, NULL, NULL, 4);
INSERT INTO `mood` VALUES (10, NULL, NULL, NULL, NULL, 1);
INSERT INTO `mood` VALUES (11, '规划局', 'http://heart123.oss-cn-beijing.aliyuncs.com/2021/02/04/0a536ba2f6164bee8546a6afb1a7f698.jpg', b'1', '2021-02-04 18:19:21', 4);
INSERT INTO `mood` VALUES (12, '大法师', 'http://heart123.oss-cn-beijing.aliyuncs.com/2021/02/04/669fb36478094212baf48bbcabfdde51.jpg', b'0', '2021-02-04 18:19:55', 4);
INSERT INTO `mood` VALUES (13, 'sdf', 'http://heart123.oss-cn-beijing.aliyuncs.com/2021/02/04/e8f343fb55a54d6b834a9f27aa503fda.jpg', b'1', '2021-02-04 19:34:59', 2);
INSERT INTO `mood` VALUES (14, 'sdf', 'http://heart123.oss-cn-beijing.aliyuncs.com/2021/02/04/b4924301c2304959864931b657c6f815.jpg', b'1', '2021-02-04 19:34:59', 2);
INSERT INTO `mood` VALUES (15, 'sdf', 'http://heart123.oss-cn-beijing.aliyuncs.com/2021/02/04/35b5c25f18024d7398762390c377ce94.jpg', b'1', '2021-02-04 19:35:17', 2);
INSERT INTO `mood` VALUES (16, 'sdf', 'http://heart123.oss-cn-beijing.aliyuncs.com/2021/02/04/cfaafcb983654dc1b7dd6b6b93602022.jpg', b'0', '2021-02-04 19:35:25', 2);
INSERT INTO `mood` VALUES (17, 'asdf', 'http://heart123.oss-cn-beijing.aliyuncs.com/2021/02/04/782164a93bed4aa49e5aeb1990ffa591.jpg', b'1', '2021-02-04 19:42:03', 2);

-- ----------------------------
-- Table structure for music
-- ----------------------------
DROP TABLE IF EXISTS `music`;
CREATE TABLE `music`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mp_three_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of music
-- ----------------------------
INSERT INTO `music` VALUES (1, 'http://heart123.oss-cn-beijing.aliyuncs.com/music/qingtian.mp3', '周杰伦', '晴天');
INSERT INTO `music` VALUES (2, 'http://heart123.oss-cn-beijing.aliyuncs.com/music/renshengkuduan.mp3', 'Jsore', '人生苦短');
INSERT INTO `music` VALUES (3, 'http://heart123.oss-cn-beijing.aliyuncs.com/music/zhizu.mp3', '五月天', '知足');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `appointment_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `pay_money` double(11, 0) NULL DEFAULT NULL,
  `consult_way` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `appointment_place` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `order_state` int(1) NULL DEFAULT NULL,
  `time` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `master_id` int(11) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `master_id`(`master_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (1, '2020-10-01', 25, '线上咨询', '海大', 1, '2021-02-03 20:49:55', 1, 2);
INSERT INTO `order` VALUES (2, '2020-02-03', 123, '线下咨询', '汕头', -1, '2021-02-03 21:30:13', 1, 1);
INSERT INTO `order` VALUES (3, '2020-05-07', 232, '阿道夫', '安抚', -2, '2021-02-03 21:31:03', 2, 1);
INSERT INTO `order` VALUES (4, '2021-02-07', 123, '阿斯蒂芬', '水电费', 1, '2021-02-03 21:47:34', 1, 1);
INSERT INTO `order` VALUES (5, '2020-03-05', 234, 'asdf', 'afd', 1, '2021-02-04 13:37:37', 1, 2);
INSERT INTO `order` VALUES (6, '2020/2/2', 11, '阿斯蒂芬', '阿萨德', -1, '2021-02-04 19:44:45', 1, 1);
INSERT INTO `order` VALUES (7, '2020/2/2', 22, '豆腐', '爱上', -2, '2021-02-04 19:46:32', 1, 1);

-- ----------------------------
-- Table structure for personal_label
-- ----------------------------
DROP TABLE IF EXISTS `personal_label`;
CREATE TABLE `personal_label`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `master_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `master_id`(`master_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of personal_label
-- ----------------------------
INSERT INTO `personal_label` VALUES (3, '阿斯蒂芬', 2);

-- ----------------------------
-- Table structure for photo
-- ----------------------------
DROP TABLE IF EXISTS `photo`;
CREATE TABLE `photo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `card_z` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `card_f` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `prove_book` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `master_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `master_id`(`master_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of photo
-- ----------------------------

-- ----------------------------
-- Table structure for thumb_up
-- ----------------------------
DROP TABLE IF EXISTS `thumb_up`;
CREATE TABLE `thumb_up`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `thumbs_up_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `mood_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `mood_id`(`mood_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of thumb_up
-- ----------------------------
INSERT INTO `thumb_up` VALUES (2, '2021-02-04 19:49:00', 2, 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sex` bit(1) NULL DEFAULT NULL,
  `birthday` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `brief_introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `open_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, b'0', '2000-09-19', '请求', '1111');
INSERT INTO `user` VALUES (2, b'1', '2020/2/3', 'asdfasd', '2222');
INSERT INTO `user` VALUES (3, b'0', '2000-04-05', '阿斯顿', '3333');
INSERT INTO `user` VALUES (4, b'1', '1998/3/4', '阿道夫', '4444');

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mp_four_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `text` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES (1, 'http://heart123.oss-cn-beijing.aliyuncs.com/videos/1.mp4', '测试视频1', '测试1');
INSERT INTO `video` VALUES (2, 'http://heart123.oss-cn-beijing.aliyuncs.com/videos/2.mp4', '测试视频2', '测试2');

SET FOREIGN_KEY_CHECKS = 1;
