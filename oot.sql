/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : oot

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2015-08-28 11:02:16
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `industry`
-- ----------------------------
DROP TABLE IF EXISTS `industry`;
CREATE TABLE `industry` (
  `id` int(255) NOT NULL auto_increment,
  `content` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of industry
-- ----------------------------
INSERT INTO `industry` VALUES ('1', 'a');
INSERT INTO `industry` VALUES ('2', '行业');
INSERT INTO `industry` VALUES ('3', '行业2');

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(255) NOT NULL auto_increment,
  `content` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', 'a');
INSERT INTO `product` VALUES ('2', '4');
INSERT INTO `product` VALUES ('3', '5');
INSERT INTO `product` VALUES ('4', 'adfadsfa');
INSERT INTO `product` VALUES ('5', '34555ffffffffffff');

-- ----------------------------
-- Table structure for `site`
-- ----------------------------
DROP TABLE IF EXISTS `site`;
CREATE TABLE `site` (
  `id` varchar(255) NOT NULL default '' COMMENT 'cookiemapping 的siteid ',
  `name` varchar(255) default NULL COMMENT 'cookiemapping 的名称',
  `mcookie` bigint(255) default NULL,
  `uid` bigint(255) default NULL,
  `uid_month` bigint(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of site
-- ----------------------------
INSERT INTO `site` VALUES ('010100', 't1', '0', '0', '0');
INSERT INTO `site` VALUES ('8600', 't2', '0', '0', '0');
