CREATE SCHEMA IF NOT EXISTS `phoneBook` DEFAULT CHARACTER SET utf8 ;
USE `phoneBook` ;

-- -----------------------------------------------------
-- Table `group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `group` (
                                                    `id` BIGINT NOT NULL AUTO_INCREMENT,
                                                    `name` VARCHAR(50) NOT NULL,
                                                    PRIMARY KEY (`id`)
                                               )
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `contact`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contact` (
                                                   `id` BIGINT NOT NULL AUTO_INCREMENT,
                                                   `first_name` VARCHAR(50) NULL,
                                                   `last_name` VARCHAR(50) NOT NULL,
                                                   `email` VARCHAR(50) NULL,
                                                   `phones` VARCHAR(200) NOT NULL,
                                                   PRIMARY KEY (`id`)
                                          )
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `contact_has_group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contact_has_group` (
                                                        `contact_id` BIGINT NOT NULL,
                                                        `group_id` BIGINT NOT NULL,
                                                        PRIMARY KEY (`book_id`, `author_id`),
                                                        CONSTRAINT `fk_contact_id`
                                                            FOREIGN KEY (`contact_id`)
                                                                REFERENCES `contact` (`id`)
                                                                ON DELETE NO ACTION
                                                                ON UPDATE NO ACTION,
                                                        CONSTRAINT `fk_group_id`
                                                            FOREIGN KEY (`group_id`)
                                                                REFERENCES `group` (`id`)
                                                                ON DELETE NO ACTION
                                                                ON UPDATE NO ACTION)
    ENGINE = InnoDB;