create database microservice_db;

use microservice_db;

CREATE TABLE IF NOT EXISTS `Customer`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `customerCode` VARCHAR(100) NOT NULL,
   `customerName` VARCHAR(100) NOT NULL,
   `description` VARCHAR(100) NOT NULL,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `Product`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `productCode` VARCHAR(100) NOT NULL,
   `productName` VARCHAR(100) NOT NULL,
   `description` VARCHAR(100) NOT NULL,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `UserOrder`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `createTime` DATE,
   `customerId` INT,
   `productCode` VARCHAR(100) NOT NULL,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

