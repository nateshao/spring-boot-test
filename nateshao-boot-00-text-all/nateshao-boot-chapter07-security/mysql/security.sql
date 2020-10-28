# 选择使用数据库
USE springbootdata;
# 创建表t_customer并插入相关数据
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `valid` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
INSERT INTO `t_customer` VALUES ('1', 'shitou', '$2a$10$5ooQI8dir8jv0/gCa1Six.GpzAdIPf6pMqdminZ/3ijYzivCyPlfK', '1');
INSERT INTO `t_customer` VALUES ('2', '李四', '$2a$10$5ooQI8dir8jv0/gCa1Six.GpzAdIPf6pMqdminZ/3ijYzivCyPlfK', '1');
# 创建表t_authority并插入相关数据
DROP TABLE IF EXISTS `t_authority`;
CREATE TABLE `t_authority` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `authority` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
INSERT INTO `t_authority` VALUES ('1', 'ROLE_common');
INSERT INTO `t_authority` VALUES ('2', 'ROLE_vip');
# 创建表t_customer_authority并插入相关数据
DROP TABLE IF EXISTS `t_customer_authority`;
CREATE TABLE `t_customer_authority` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `customer_id` int(20) DEFAULT NULL,
  `authority_id` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
INSERT INTO `t_customer_authority` VALUES ('1', '1', '1');
INSERT INTO `t_customer_authority` VALUES ('2', '2', '2');

# 记住我功能中创建持久化Token存储的数据表
create table persistent_logins (username varchar(64) not null,
								series varchar(64) primary key,
								token varchar(64) not null,
								last_used timestamp not null);




