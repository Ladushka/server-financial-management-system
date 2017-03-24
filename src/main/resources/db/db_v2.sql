-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `finsystem` DEFAULT CHARACTER SET utf8 ;
USE `finsystem` ;

-- -----------------------------------------------------
-- Table `mydb`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finsystem`.`category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`subcategory`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finsystem`.`subcategory` (
  `name` VARCHAR(45) NOT NULL,
  `id_category` INT NOT NULL,
  `id` INT NOT NULL AUTO_INCREMENT,
  INDEX `id_category_idx` (`id_category` ASC),
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `subcategory`
    FOREIGN KEY (`id_category`)
    REFERENCES `finsystem`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`payment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finsystem`.`payment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_category` INT NOT NULL,
  `id_subcategory` INT NULL,
  `data` DATE NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `cost` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `id_category_idx` (`id_category` ASC),
  INDEX `subcat_idx` (`id_subcategory` ASC),
  CONSTRAINT `category`
    FOREIGN KEY (`id_category`)
    REFERENCES `finsystem`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `subcat`
    FOREIGN KEY (`id_subcategory`)
    REFERENCES `finsystem`.`subcategory` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`money`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finsystem`.`money` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `sum` DECIMAL(10,2) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`receipt`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finsystem`.`receipt` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `sum` DECIMAL(10,2) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `comment` VARCHAR(100) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
