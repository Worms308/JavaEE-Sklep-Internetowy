-- MySQL Script generated by MySQL Workbench
-- Sat May 11 17:41:55 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema phone_store
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `phone_store` ;

-- -----------------------------------------------------
-- Schema phone_store
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `phone_store` DEFAULT CHARACTER SET utf8 ;
USE `phone_store` ;

-- -----------------------------------------------------
-- Table `phone_store`.`usertype`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `phone_store`.`usertype` ;

CREATE TABLE IF NOT EXISTS `phone_store`.`usertype` (
  `usertype_id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NOT NULL,
  `login` VARCHAR(45) NULL,
  PRIMARY KEY (`usertype_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `phone_store`.`address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `phone_store`.`address` ;

CREATE TABLE IF NOT EXISTS `phone_store`.`address` (
  `address_id` INT NOT NULL AUTO_INCREMENT,
  `country` VARCHAR(100) NOT NULL,
  `city` VARCHAR(100) NOT NULL,
  `street` VARCHAR(100) NOT NULL,
  `street_number` VARCHAR(10) NOT NULL,
  `home_number` VARCHAR(10) NULL,
  `postal_code` CHAR(6) NOT NULL,
  PRIMARY KEY (`address_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `phone_store`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `phone_store`.`user` ;

CREATE TABLE IF NOT EXISTS `phone_store`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(60) NOT NULL,
  `phone` VARCHAR(11) NULL,
  `login` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `user_usertype_id` INT NOT NULL,
  `user_address_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `user_usertype_id`, `user_address_id`),
  INDEX `fk_user_usertype_idx` (`user_usertype_id` ASC),
  INDEX `fk_user_address_idx` (`user_address_id` ASC),
  CONSTRAINT `fk_user_usertype`
    FOREIGN KEY (`user_usertype_id`)
    REFERENCES `phone_store`.`usertype` (`usertype_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_address`
    FOREIGN KEY (`user_address_id`)
    REFERENCES `phone_store`.`address` (`address_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `phone_store`.`phone`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `phone_store`.`phone` ;

CREATE TABLE IF NOT EXISTS `phone_store`.`phone` (
  `phone_id` INT NOT NULL AUTO_INCREMENT,
  `manufacturer` VARCHAR(45) NOT NULL,
  `model` VARCHAR(45) NOT NULL,
  `processor` VARCHAR(45) NOT NULL,
  `system` VARCHAR(45) NOT NULL,
  `screen_size` VARCHAR(6) NOT NULL,
  `ram` VARCHAR(5) NOT NULL,
  `storage` VARCHAR(5) NOT NULL,
  `camera` VARCHAR(25) NULL,
  `price` DECIMAL(7,2) NOT NULL,
  `rating` DECIMAL(3,2) NULL,
  `rating_count` INT NULL,
  `discount` DECIMAL(3,2) NULL,
  `quantity` INT NULL,
  PRIMARY KEY (`phone_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `phone_store`.`sale`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `phone_store`.`sale` ;

CREATE TABLE IF NOT EXISTS `phone_store`.`sale` (
  `sale_id` INT NOT NULL AUTO_INCREMENT,
  `quantity` INT NOT NULL,
  `date_order` DATE NOT NULL,
  `date_completed` DATE NULL,
  `sale_user_id` INT NOT NULL,
  `sale_phone_id` INT NOT NULL,
  PRIMARY KEY (`sale_id`, `sale_user_id`, `sale_phone_id`),
  INDEX `fk_sale_user_idx` (`sale_user_id` ASC),
  INDEX `fk_sale_phone_idx` (`sale_phone_id` ASC),
  CONSTRAINT `fk_sale_user`
    FOREIGN KEY (`sale_user_id`)
    REFERENCES `phone_store`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sale_phone`
    FOREIGN KEY (`sale_phone_id`)
    REFERENCES `phone_store`.`phone` (`phone_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
