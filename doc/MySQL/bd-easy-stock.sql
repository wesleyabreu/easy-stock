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
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`usuario` (
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `cpf` VARCHAR(14) NOT NULL,
  `endereco` VARCHAR(100) NOT NULL,
  `tipo_conta` ENUM("Cliente", "Vendedor") NOT NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`produto` (
  `id_produto` INT NOT NULL auto_increment,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(100) NOT NULL,
  `preco` FLOAT(8,2) NOT NULL,
  `quantidade` INT NOT NULL,
  PRIMARY KEY (`id_produto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`pedido` (
  `id_pedido` INT NOT NULL auto_increment,
  `comprador_username` VARCHAR(45) NOT NULL,
  `pagamento_status` ENUM("Pago", "Pendente") NOT NULL,
  `orcamento` FLOAT(8,2) NOT NULL,
  `id_nota_fiscal` INT NULL,
  `lista_itens_pedido` VARCHAR(3000) NOT NULL,
  `comprador_nome` VARCHAR(100) NOT NULL,
  `comprador_cpf` VARCHAR(14) NOT NULL,
  `comprador_endereco` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_pedido`),
  UNIQUE INDEX `id_nota_fiscal_UNIQUE` (`id_nota_fiscal` ASC))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

