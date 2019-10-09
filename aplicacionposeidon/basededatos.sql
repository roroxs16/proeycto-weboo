-- MySQL Script generated by MySQL Workbench
-- Mon Oct  7 19:24:11 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `rcifuent` DEFAULT CHARACTER SET utf8 ;
USE `rcifuent` ;

-- -----------------------------------------------------
-- Table `mydb`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rcifuent`.`usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(55) NULL,
  `apellidos` VARCHAR(70) NULL,
  `password` TEXT NULL,
  `correo` VARCHAR(60) NULL,
  `direccion` VARCHAR(100) NULL,
  `fecha_nacimiento` DATE NULL,
  `run` VARCHAR(13) NULL,
  `ciudad` VARCHAR(45) NULL,
  `telefono` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rcifuent`.`rol` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `autoridad` VARCHAR(45) NULL,
  `usuario_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_rol_usuario_idx` (`usuario_id` ASC) ,
  CONSTRAINT `fk_rol_usuario`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `rcifuent`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`categoria_producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rcifuent`.`categoria_producto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(55) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rcifuent`.`producto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(55) NULL,
  `cantidad` INT NULL,
  `valor` INT NULL,
  `descripcion` VARCHAR(100) NULL,
  `img` TEXT NULL,
  `categoria_producto_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_producto_categoria_producto1_idx` (`categoria_producto_id` ASC) ,
  CONSTRAINT `fk_producto_categoria_producto1`
    FOREIGN KEY (`categoria_producto_id`)
    REFERENCES `rcifuent`.`categoria_producto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`detalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rcifuent`.`detalle` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NULL,
  `valor_total` INT NULL,
  `usuario_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_detalle_usuario1_idx` (`usuario_id` ASC) ,
  CONSTRAINT `fk_detalle_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `rcifuent`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`detalle_producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rcifuent`.`detalle_producto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `producto_id` INT NOT NULL,
  `detalle_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_carrito_producto_producto1_idx` (`producto_id` ASC) ,
  INDEX `fk_carrito_producto_detalle1_idx` (`detalle_id` ASC) ,
  CONSTRAINT `fk_carrito_producto_producto1`
    FOREIGN KEY (`producto_id`)
    REFERENCES `rcifuent`.`producto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_carrito_producto_detalle1`
    FOREIGN KEY (`detalle_id`)
    REFERENCES `rcifuent`.`detalle` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
