/*
Navicat MySQL Data Transfer

Source Server         : koupigu
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : blogsdb

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2020-01-01 18:30:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for about
-- ----------------------------
DROP TABLE IF EXISTS `about`;
CREATE TABLE `about` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `a_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章id,主键',
  `a_user_id` int(11) NOT NULL COMMENT '作者id 外键',
  `a_title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文章标题',
  `a_context` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文章正文',
  `a_page_view` int(11) NOT NULL DEFAULT '0' COMMENT '浏览数',
  `a_comment` int(11) NOT NULL DEFAULT '0' COMMENT '评论数',
  `a_publish_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `a_cover_picture` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '封面图url',
  `a_preview_text` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '预览正文(70个字)',
  `a_diff` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '时间差(db不保存此字段)',
  `a_category_id` int(11) NOT NULL,
  PRIMARY KEY (`a_id`),
  KEY `a_user_id` (`a_user_id`),
  KEY `article_ibfk_2` (`a_category_id`),
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`a_user_id`) REFERENCES `user` (`u_id`),
  CONSTRAINT `article_ibfk_2` FOREIGN KEY (`a_category_id`) REFERENCES `category` (`c_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20190101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='文章表';

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `c_name` varchar(50) NOT NULL COMMENT '分类名称',
  `c_count` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20190021 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='文章分类表';

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_article_id` int(11) NOT NULL,
  `c_user_id` int(11) NOT NULL,
  `c_context` varchar(255) NOT NULL,
  `c_discuss_date` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `c_comment_num` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`c_id`),
  KEY `c_user_id` (`c_user_id`),
  KEY `c_article_id` (`c_article_id`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`c_user_id`) REFERENCES `user` (`u_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`c_article_id`) REFERENCES `article` (`a_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '名字',
  `url` varchar(255) DEFAULT NULL COMMENT 'url地址',
  `type` int(11) DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='文件表';

-- ----------------------------
-- Table structure for slide
-- ----------------------------
DROP TABLE IF EXISTS `slide`;
CREATE TABLE `slide` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_url` varchar(100) NOT NULL,
  `s_article_id` int(11) NOT NULL,
  `s_publish_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=420190004 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_name` varchar(50) NOT NULL,
  `t_count` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for tag_relationship
-- ----------------------------
DROP TABLE IF EXISTS `tag_relationship`;
CREATE TABLE `tag_relationship` (
  `relationship_a_id` int(11) NOT NULL,
  `relationship_t_id` int(11) NOT NULL,
  KEY `tag_relationship_ibfk_1` (`relationship_a_id`),
  KEY `tag_relationship_ibfk_2` (`relationship_t_id`),
  CONSTRAINT `tag_relationship_ibfk_1` FOREIGN KEY (`relationship_a_id`) REFERENCES `article` (`a_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `tag_relationship_ibfk_2` FOREIGN KEY (`relationship_t_id`) REFERENCES `tag` (`t_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(50) NOT NULL,
  `u_password` varchar(18) NOT NULL,
  `u_email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `u_photo` varchar(100) NOT NULL DEFAULT 'http://localhost:8080/image/user/photo.jpg',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2019826 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
