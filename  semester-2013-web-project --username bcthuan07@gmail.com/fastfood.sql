/*
Navicat MySQL Data Transfer

Source Server         : MYSQL
Source Server Version : 50614
Source Host           : localhost:3306
Source Database       : fastfood

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2013-12-01 19:32:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `address`
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `street` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL,
  `building_number` int(11) NOT NULL,
  `city` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL,
  `zip_code` int(11) NOT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('1', 'Bùi Trọng Nghĩa', '327', 'Biên Hòa', '71');

-- ----------------------------
-- Table structure for `feedback`
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `feedback_id` int(11) NOT NULL AUTO_INCREMENT,
  `content` longtext COLLATE utf8_vietnamese_ci NOT NULL,
  `user_id` int(11) NOT NULL,
  `date_created` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`feedback_id`),
  KEY `fb_user` (`user_id`),
  CONSTRAINT `fb_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- ----------------------------
-- Records of feedback
-- ----------------------------

-- ----------------------------
-- Table structure for `order_item`
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item` (
  `order_item_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_order_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `order_quantity` int(11) NOT NULL,
  PRIMARY KEY (`order_item_id`),
  KEY `product_id_fk` (`product_id`),
  KEY `user_order_id_fk` (`user_order_id`),
  CONSTRAINT `product_id_fk` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_order_id_fk` FOREIGN KEY (`user_order_id`) REFERENCES `user_order` (`user_order_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- ----------------------------
-- Records of order_item
-- ----------------------------

-- ----------------------------
-- Table structure for `order_status`
-- ----------------------------
DROP TABLE IF EXISTS `order_status`;
CREATE TABLE `order_status` (
  `order_status_id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL,
  PRIMARY KEY (`order_status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- ----------------------------
-- Records of order_status
-- ----------------------------
INSERT INTO `order_status` VALUES ('1', 'Chưa Thanh Toán');
INSERT INTO `order_status` VALUES ('2', 'Đã Thanh Toán 50%');
INSERT INTO `order_status` VALUES ('3', 'Nợ');

-- ----------------------------
-- Table structure for `payment_method`
-- ----------------------------
DROP TABLE IF EXISTS `payment_method`;
CREATE TABLE `payment_method` (
  `payment_method_id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL,
  PRIMARY KEY (`payment_method_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- ----------------------------
-- Records of payment_method
-- ----------------------------
INSERT INTO `payment_method` VALUES ('1', 'Credit Card');
INSERT INTO `payment_method` VALUES ('2', 'Tiền Mặt');
INSERT INTO `payment_method` VALUES ('3', 'Chuyển Khoản');
INSERT INTO `payment_method` VALUES ('4', 'Nợ');

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL,
  `description` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL,
  `price` double NOT NULL,
  `product_type_id` int(11) NOT NULL,
  `image_path` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL,
  PRIMARY KEY (`product_id`),
  KEY `product_type_fk` (`product_type_id`),
  CONSTRAINT `product_type_fk` FOREIGN KEY (`product_type_id`) REFERENCES `product_type` (`product_type_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('2', 'Thịt bò xông khói', 'Thịt bò xông khói', '30', '1', 'images/food/thitboxongkhoi.jpg');

-- ----------------------------
-- Table structure for `product_type`
-- ----------------------------
DROP TABLE IF EXISTS `product_type`;
CREATE TABLE `product_type` (
  `product_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL,
  PRIMARY KEY (`product_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- ----------------------------
-- Records of product_type
-- ----------------------------
INSERT INTO `product_type` VALUES ('1', 'Món Ăn');
INSERT INTO `product_type` VALUES ('2', 'Thức Uống');
INSERT INTO `product_type` VALUES ('3', 'Tráng Miệng');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL,
  `password` varbinary(255) NOT NULL,
  `payment_method_id` int(11) NOT NULL,
  `phone_number` int(11) NOT NULL,
  `first_name` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL,
  `last_name` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL,
  `permission` bit(4) NOT NULL,
  `gender` bit(4) NOT NULL,
  `datecreated` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `salt` varbinary(255) NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `payment_method_fk` (`payment_method_id`),
  CONSTRAINT `payment_method_fk` FOREIGN KEY (`payment_method_id`) REFERENCES `payment_method` (`payment_method_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('6', 'testps', 0x45B505D7F66780AEC4774D8677A4CF05059B7614, '1', '14562', 'Mau', 'kajg', 'kjagk', '', '', '2013-11-30 20:56:18', 0x03EE2ACBEA2CA99E);

-- ----------------------------
-- Table structure for `user_address_history`
-- ----------------------------
DROP TABLE IF EXISTS `user_address_history`;
CREATE TABLE `user_address_history` (
  `user_id` int(11) NOT NULL,
  `address_id` int(11) NOT NULL,
  `date_from` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`,`address_id`,`date_from`),
  KEY `address_id_fk` (`address_id`),
  CONSTRAINT `address_id_fk` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_id_address_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- ----------------------------
-- Records of user_address_history
-- ----------------------------

-- ----------------------------
-- Table structure for `user_order`
-- ----------------------------
DROP TABLE IF EXISTS `user_order`;
CREATE TABLE `user_order` (
  `user_order_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `order_status_id` int(11) NOT NULL,
  `order_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_order_id`),
  KEY `order_status_fk` (`order_status_id`),
  KEY `user_id_fk` (`user_id`),
  CONSTRAINT `order_status_fk` FOREIGN KEY (`order_status_id`) REFERENCES `order_status` (`order_status_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- ----------------------------
-- Records of user_order
-- ----------------------------
