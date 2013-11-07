/*
Navicat MySQL Data Transfer

Source Server         : MYSQL
Source Server Version : 50614
Source Host           : localhost:3306
Source Database       : restaurant

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2013-11-05 19:18:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `feedback`
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `idfeedback` int(11) NOT NULL AUTO_INCREMENT,
  `iduser` int(11) NOT NULL,
  `content` longtext NOT NULL,
  `datecreated` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`idfeedback`,`iduser`),
  KEY `iduser` (`iduser`),
  CONSTRAINT `iduser` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feedback
-- ----------------------------

-- ----------------------------
-- Table structure for `invoice`
-- ----------------------------
DROP TABLE IF EXISTS `invoice`;
CREATE TABLE `invoice` (
  `idinvoice` int(11) NOT NULL AUTO_INCREMENT,
  `datecreated` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `iduser` int(11) NOT NULL,
  `npeople` int(11) NOT NULL,
  `timetomeet` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `amount` double NOT NULL,
  PRIMARY KEY (`iduser`,`idinvoice`),
  KEY `idinvoice` (`idinvoice`),
  CONSTRAINT `iduserinvoice` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of invoice
-- ----------------------------
INSERT INTO `invoice` VALUES ('1', '2013-11-03 12:38:03', '1', '2', '2013-11-03 12:38:03', '500');

-- ----------------------------
-- Table structure for `invoicedetail`
-- ----------------------------
DROP TABLE IF EXISTS `invoicedetail`;
CREATE TABLE `invoicedetail` (
  `idinvoice` int(11) NOT NULL,
  `idmeal` int(11) NOT NULL,
  PRIMARY KEY (`idinvoice`,`idmeal`),
  KEY `idmdt` (`idmeal`),
  CONSTRAINT `idivdt` FOREIGN KEY (`idinvoice`) REFERENCES `invoice` (`idinvoice`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idmdt` FOREIGN KEY (`idmeal`) REFERENCES `meal` (`idmeal`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of invoicedetail
-- ----------------------------
INSERT INTO `invoicedetail` VALUES ('1', '1');
INSERT INTO `invoicedetail` VALUES ('1', '3');
INSERT INTO `invoicedetail` VALUES ('1', '15');

-- ----------------------------
-- Table structure for `meal`
-- ----------------------------
DROP TABLE IF EXISTS `meal`;
CREATE TABLE `meal` (
  `idmeal` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `datecreated` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `picture` varchar(255) NOT NULL,
  `idmealtype` int(11) NOT NULL,
  `idmealkind` int(11) NOT NULL,
  `intro` longtext,
  `price` double NOT NULL,
  PRIMARY KEY (`idmeal`),
  KEY `mealtype` (`idmealtype`),
  KEY `mealkind` (`idmealkind`),
  CONSTRAINT `mealkind` FOREIGN KEY (`idmealkind`) REFERENCES `mealkind` (`idmealkind`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `mealtype` FOREIGN KEY (`idmealtype`) REFERENCES `mealtype` (`idmealtype`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of meal
-- ----------------------------
INSERT INTO `meal` VALUES ('1', 'Canh Hải Sản', '2013-11-03 11:56:20', 'canhhaisan', '1', '1', 'Sau những bữa ăn ngày tết tràn ngập với các món ăn truyền thống thì món \"Canh Hải Sản\" sẽ mang đến bữa cơm sau tết thêm hấp dẫn và lạ miệng.', '60');
INSERT INTO `meal` VALUES ('2', 'Canh Súp Lơ Thịt Bò', '2013-11-03 11:59:58', 'canhsuplothitbo', '1', '1', 'Món canh ngon bổ mà lại dễ nấu và nhanh gọn, thích hợp cho trời chiều lạnh mùa đông này.', '80');
INSERT INTO `meal` VALUES ('3', 'Bào Ngư Xào Nấm', '2013-11-03 12:04:39', 'baonguxaonam', '2', '1', 'Dùng nóng với cơm và kèm nước tương', '110');
INSERT INTO `meal` VALUES ('5', 'Bào Ngư Sốt Dầu Hào Nguyên Con', '2013-11-03 12:05:16', 'baongusotdauhao', '2', '1', 'Đây là món ăn ngon và bổ dưỡng, chế biến món ăn tốn khá nhiều thời gian cho khâu sơ chế và khâu nấu nướng.', '200');
INSERT INTO `meal` VALUES ('7', 'Bào Ngư Om Cải Xanh', '2013-11-03 12:08:25', 'baonguomcaixanh', '2', '1', 'Thơm ngon, nước trong mà vẫn ngọt đặc trưng. Có thể thêm nấm hương để tăng thêm độ hấp dẫn. Món này được dùng làm món khai vị.', '150');
INSERT INTO `meal` VALUES ('8', 'Salat Tôm Trái Thơm', '2013-11-03 12:10:52', 'salattomtraithom', '4', '1', null, '200');
INSERT INTO `meal` VALUES ('9', 'Salat Gỏi Sen Tôm', '2013-11-03 12:11:59', 'salatgoisentom', '4', '1', 'Món ăn có vị chua ngọt, thơm mùi ngó sen và các nguyên liệu đi kèm.', '170');
INSERT INTO `meal` VALUES ('11', 'Salat Cà Chua Dưa Chuột', '2013-11-03 12:13:23', 'salatcachuduachuot', '4', '1', null, '80');
INSERT INTO `meal` VALUES ('12', 'Salat Phù Đổng', '2013-11-03 12:14:29', 'salatphudong', '4', '1', 'Đây là một món ăn được nhiều người Việt Nam thích ăn. Có 2 nguyên liệu tạo nên hương vị đặc trưng cho món sa lát Nga. Đó là Sause Mayonnaise (có thể mua ở các siêu thị) và Jambon (mua ở các cửa hàng bán thực phẩm chín), còn các nguyên liệu khác là rau quả củ rất sẵn', '250');
INSERT INTO `meal` VALUES ('13', 'Gỏi Mướp Đắng Ruốc', '2013-11-03 12:15:23', 'goimuopdangruoc', '3', '1', 'Mướp đắng ướp đá ruốc không chỉ là món ăn đơn giản, ngon miệng mà còn rất tốt cho sức khỏe.', '90');
INSERT INTO `meal` VALUES ('14', 'Nộm Bò Rau Muống', '2013-11-03 12:16:38', 'nomboraumuong', '3', '1', 'Món này ăn rau muống giòn cực như ăn rau sống ý. Mùa hè ăn thế này thấy mát mát và mát mắt nữa vì đủ màu, xanh, đỏ, nâu, trắng. Thịt bò cũng chua chua ngọt ngọt.', '150');
INSERT INTO `meal` VALUES ('15', 'Nộm Gà Hoa Chuối', '2013-11-03 12:17:59', 'nomgahoachuoi', '3', '1', null, '190');

-- ----------------------------
-- Table structure for `mealkind`
-- ----------------------------
DROP TABLE IF EXISTS `mealkind`;
CREATE TABLE `mealkind` (
  `idmealkind` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`idmealkind`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mealkind
-- ----------------------------
INSERT INTO `mealkind` VALUES ('1', 'food');
INSERT INTO `mealkind` VALUES ('2', 'drink');

-- ----------------------------
-- Table structure for `mealtype`
-- ----------------------------
DROP TABLE IF EXISTS `mealtype`;
CREATE TABLE `mealtype` (
  `idmealtype` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `decription` longtext NOT NULL,
  `datecreated` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`idmealtype`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mealtype
-- ----------------------------
INSERT INTO `mealtype` VALUES ('1', 'Canh', '', '2013-11-03 11:14:50');
INSERT INTO `mealtype` VALUES ('2', 'Bào Ngư', '', '2013-11-03 12:01:49');
INSERT INTO `mealtype` VALUES ('3', 'Nộm', '', '2013-11-03 12:02:02');
INSERT INTO `mealtype` VALUES ('4', 'Salat', '', '2013-11-03 12:02:12');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `iduser` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `datecreated` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `phonenumber` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `permission` int(11) NOT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'bcthuan07', '123456789', 'Bùi', 'Thuần', '20', 'Biên Hòa', '2013-11-03 12:34:25', '01655096976', 'bcthuan07@gmail.com', '1');
