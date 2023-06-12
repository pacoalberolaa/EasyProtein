# <em>Script de Easy Protein</em>

-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema EasyProtein
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `EasyProtein` ;

-- -----------------------------------------------------
-- Schema EasyProtein
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `EasyProtein` DEFAULT CHARACTER SET utf8 ;
USE `EasyProtein` ;

-- -----------------------------------------------------
-- Table `EasyProtein`.`Productos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EasyProtein`.`Productos` ;

CREATE TABLE IF NOT EXISTS `EasyProtein`.`Productos` (
`id` INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EasyProtein`.`Creatina`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EasyProtein`.`Creatina` ;

CREATE TABLE IF NOT EXISTS `EasyProtein`.`Creatina` (
`id` INT NOT NULL AUTO_INCREMENT,
`nombre` VARCHAR(45) NULL,
`marca` VARCHAR(45) NOT NULL,
`precio` DOUBLE NOT NULL,
`cantidad1` DOUBLE NULL,
`cantidad2` DOUBLE NULL,
`cantidad3` DOUBLE NULL,
`creapure` TINYINT NOT NULL,
`sabor1` VARCHAR(45) NULL,
`sabor2` VARCHAR(45) NULL,
`sabor3` VARCHAR(45) NULL,
`sabor4` VARCHAR(45) NULL,
`sabor5` VARCHAR(45) NULL,
`descripcion` VARCHAR(400) NULL,
`imagen_url` VARCHAR(250) NOT NULL,
`Productos_id` INT NOT NULL,
PRIMARY KEY (`id`),
INDEX `fk_Creatina_Cesta1_idx` (`Productos_id` ASC) VISIBLE,
CONSTRAINT `fk_Creatina_Cesta1`
FOREIGN KEY (`Productos_id`)
REFERENCES `EasyProtein`.`Productos` (`id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EasyProtein`.`Proteina`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EasyProtein`.`Proteina` ;

CREATE TABLE IF NOT EXISTS `EasyProtein`.`Proteina` (
`id` INT NOT NULL AUTO_INCREMENT,
`nombre` VARCHAR(45) NOT NULL,
`marca` VARCHAR(45) NOT NULL,
`precio` DOUBLE NOT NULL,
`cantidad1` DOUBLE NULL,
`cantidad2` DOUBLE NULL,
`cantidad3` DOUBLE NULL,
`tipo` VARCHAR(45) NOT NULL,
`sabor1` VARCHAR(45) NULL,
`sabor2` VARCHAR(45) NULL,
`sabor3` VARCHAR(45) NULL,
`sabor4` VARCHAR(45) NULL,
`sabor5` VARCHAR(45) NULL,
`descripcion` VARCHAR(200) NULL,
`imagen_url` VARCHAR(250) NOT NULL,
`Productos_id` INT NOT NULL,
PRIMARY KEY (`id`),
INDEX `fk_Proteina_Cesta1_idx` (`Productos_id` ASC) VISIBLE,
CONSTRAINT `fk_Proteina_Cesta1`
FOREIGN KEY (`Productos_id`)
REFERENCES `EasyProtein`.`Productos` (`id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EasyProtein`.`Vitaminas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EasyProtein`.`Vitaminas` ;

CREATE TABLE IF NOT EXISTS `EasyProtein`.`Vitaminas` (
`id` INT NOT NULL AUTO_INCREMENT,
`nombre` VARCHAR(45) NOT NULL,
`marca` VARCHAR(45) NOT NULL,
`precio` VARCHAR(45) NOT NULL,
`cantidad1` VARCHAR(45) NULL,
`cantidad2` VARCHAR(45) NULL,
`cantidad3` VARCHAR(45) NULL,
`tipo` VARCHAR(45) NOT NULL,
`descripcion` VARCHAR(300) NULL,
`imagen_url` VARCHAR(250) NOT NULL,
`Productos_id` INT NOT NULL,
PRIMARY KEY (`id`),
INDEX `fk_Vitaminas_Cesta1_idx` (`Productos_id` ASC) VISIBLE,
CONSTRAINT `fk_Vitaminas_Cesta1`
FOREIGN KEY (`Productos_id`)
REFERENCES `EasyProtein`.`Productos` (`id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EasyProtein`.`Barritas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EasyProtein`.`Barritas` ;

CREATE TABLE IF NOT EXISTS `EasyProtein`.`Barritas` (
`id` INT NOT NULL AUTO_INCREMENT,
`nombre` VARCHAR(45) NOT NULL,
`marca` VARCHAR(45) NOT NULL,
`precio` VARCHAR(45) NOT NULL,
`sabor1` VARCHAR(45) NULL,
`sabor2` VARCHAR(45) NULL,
`sabor3` VARCHAR(45) NULL,
`contenido1` VARCHAR(45) NULL,
`contenido2` VARCHAR(45) NULL,
`contenido3` VARCHAR(45) NULL,
`descripcion` VARCHAR(300) NULL,
`imagen_url` VARCHAR(250) NOT NULL,
`Productos_id` INT NOT NULL,
PRIMARY KEY (`id`),
INDEX `fk_Vitaminas_Cesta1_idx` (`Productos_id` ASC) VISIBLE,
CONSTRAINT `fk_Vitaminas_Cesta10`
FOREIGN KEY (`Productos_id`)
REFERENCES `EasyProtein`.`Productos` (`id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EasyProtein`.`Otros`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EasyProtein`.`Otros` ;

CREATE TABLE IF NOT EXISTS `EasyProtein`.`Otros` (
`id` INT NOT NULL AUTO_INCREMENT,
`tipos` VARCHAR(45) NOT NULL,
`precio` VARCHAR(45) NOT NULL,
`descripcion` VARCHAR(45) NULL,
`imagen_url` VARCHAR(250) NOT NULL,
`Productos_id` INT NOT NULL,
PRIMARY KEY (`id`),
INDEX `fk_Otros_Cesta1_idx` (`Productos_id` ASC) VISIBLE,
CONSTRAINT `fk_Otros_Cesta1`
FOREIGN KEY (`Productos_id`)
REFERENCES `EasyProtein`.`Productos` (`id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EasyProtein`.`Usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EasyProtein`.`Usuario` ;

CREATE TABLE IF NOT EXISTS `EasyProtein`.`Usuario` (
`id` INT NOT NULL AUTO_INCREMENT,
`usuario` VARCHAR(45) NOT NULL,
`contraseña` VARCHAR(64) NOT NULL,
PRIMARY KEY (`id`),
UNIQUE INDEX `usuario_UNIQUE` (`usuario` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EasyProtein`.`Cesta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EasyProtein`.`Cesta` ;

CREATE TABLE IF NOT EXISTS `EasyProtein`.`Cesta` (
`id` INT NOT NULL AUTO_INCREMENT,
`Usuario_id` INT NOT NULL,
PRIMARY KEY (`id`),
INDEX `fk_Cesta_Usuario1_idx` (`Usuario_id` ASC) VISIBLE,
CONSTRAINT `fk_Cesta_Usuario1`
FOREIGN KEY (`Usuario_id`)
REFERENCES `EasyProtein`.`Usuario` (`id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EasyProtein`.`Carbohidratos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EasyProtein`.`Carbohidratos` ;

CREATE TABLE IF NOT EXISTS `EasyProtein`.`Carbohidratos` (
`id` INT NOT NULL AUTO_INCREMENT,
`nombre` VARCHAR(45) NOT NULL,
`marca` VARCHAR(45) NOT NULL,
`precio` DOUBLE NOT NULL,
`cantidad1` DOUBLE NULL,
`cantidad2` DOUBLE NULL,
`cantidad3` DOUBLE NULL,
`tipo` VARCHAR(45) NOT NULL,
`sabor1` VARCHAR(45) NULL,
`sabor2` VARCHAR(45) NULL,
`sabor3` VARCHAR(45) NULL,
`sabor4` VARCHAR(45) NULL,
`sabor5` VARCHAR(45) NULL,
`descripcion` VARCHAR(300) NULL,
`imagen_url` VARCHAR(250) NOT NULL,
`Productos_id` INT NOT NULL,
PRIMARY KEY (`id`),
INDEX `fk_Proteina_Cesta1_idx` (`Productos_id` ASC) VISIBLE,
CONSTRAINT `fk_Proteina_Cesta10`
FOREIGN KEY (`Productos_id`)
REFERENCES `EasyProtein`.`Productos` (`id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EasyProtein`.`Aminoacidos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EasyProtein`.`Aminoacidos` ;

CREATE TABLE IF NOT EXISTS `EasyProtein`.`Aminoacidos` (
`id` INT NOT NULL AUTO_INCREMENT,
`nombre` VARCHAR(45) NOT NULL,
`marca` VARCHAR(45) NOT NULL,
`precio` DOUBLE NOT NULL,
`cantidad1` DOUBLE NULL,
`cantidad2` DOUBLE NULL,
`cantidad3` DOUBLE NULL,
`tipo` VARCHAR(45) NOT NULL,
`sabor1` VARCHAR(45) NULL,
`sabor2` VARCHAR(45) NULL,
`sabor3` VARCHAR(45) NULL,
`sabor4` VARCHAR(45) NULL,
`sabor5` VARCHAR(45) NULL,
`descripcion` VARCHAR(400) NULL,
`imagen_url` VARCHAR(250) NOT NULL,
`Productos_id` INT NOT NULL,
PRIMARY KEY (`id`),
INDEX `fk_Proteina_Cesta1_idx` (`Productos_id` ASC) VISIBLE,
CONSTRAINT `fk_Proteina_Cesta11`
FOREIGN KEY (`Productos_id`)
REFERENCES `EasyProtein`.`Productos` (`id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EasyProtein`.`Cesta_has_Productos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EasyProtein`.`Cesta_has_Productos` ;

CREATE TABLE IF NOT EXISTS `EasyProtein`.`Cesta_has_Productos` (
`Cesta_id` INT NOT NULL,
`Productos_id` INT NOT NULL,
PRIMARY KEY (`Cesta_id`, `Productos_id`),
INDEX `fk_Cesta_has_Productos_Productos1_idx` (`Productos_id` ASC) VISIBLE,
INDEX `fk_Cesta_has_Productos_Cesta1_idx` (`Cesta_id` ASC) VISIBLE,
CONSTRAINT `fk_Cesta_has_Productos_Cesta1`
FOREIGN KEY (`Cesta_id`)
REFERENCES `EasyProtein`.`Cesta` (`id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT `fk_Cesta_has_Productos_Productos1`
FOREIGN KEY (`Productos_id`)
REFERENCES `EasyProtein`.`Productos` (`id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

# <em>Insercion de Datos</em>

use easyProtein;

insert into productos values (1);
insert into productos values (2);
insert into productos values (3);
insert into productos values (4);
insert into productos values (5);
insert into productos values (6);
insert into productos values (7);
insert into productos values (8);
insert into productos values (9);
insert into productos values (10);
insert into productos values (11);
insert into productos values (12);
insert into productos values (13);
insert into productos values (14);
insert into productos values (15);
insert into productos values (16);
insert into productos values (17);
insert into productos values (18);
insert into productos values (19);
insert into productos values (20);
insert into productos values (21);
insert into productos values (22);
insert into productos values (23);
insert into productos values (24);
insert into productos values (25);
insert into productos values (26);
insert into productos values (27);
insert into productos values (28);
insert into productos values (29);
insert into productos values (30);


insert into proteina (nombre, marca, precio, cantidad1, cantidad2, cantidad3, tipo, sabor1, sabor2, sabor3, sabor4, sabor5, descripcion, imagen_url, Productos_id) values('Isolate Protein', 'prozis', 33.3, 1, 2, 3, 'isolate', 'Chocolate', 'Platano', 'Vainilla', 'Cafe', 'Caramelo', 'Este suero de alta calidad incluye 21 g de proteina por racion, toda la proteina que necesitas. El producto se filtra y seca unicamente por aspersion para ofrecer solo nutrientes naturales.', '/source/index/recomendados/wheyProtein_MP.png', 1);
insert into proteina (nombre, marca, precio, cantidad1, cantidad2, cantidad3, tipo, sabor1, sabor2, sabor3, sabor4, sabor5, descripcion, imagen_url, Productos_id) values('Whey Protein', 'prozis', 33.3, 1, 2, 3, 'whey', 'Chocolate', 'Platano', 'Vainilla', 'Cookies', 'Caramelo', 'Este suero de alta calidad incluye 21 g de proteina por racion, toda la proteina que necesitas. El producto se filtra y seca unicamente por aspersion para ofrecer solo nutrientes naturales.', '/source/index/recomendados/wheyProtein_MP.png', 2);
insert into proteina (nombre, marca, precio, cantidad1, cantidad2, cantidad3, tipo, sabor1, sabor2, sabor3, sabor4, sabor5, descripcion, imagen_url, Productos_id) values('Clear Whey', 'MyProtein', 33.3, 1, 2, 3, 'hidrolizada', 'Fresa', 'Platano', 'Mango', 'Arandanos', 'Coco', 'Este suero de alta calidad incluye 21 g de proteina por racion, toda la proteina que necesitas. El producto se filtra y seca unicamente por aspersion para ofrecer solo nutrientes naturales.', '/source/index/clear_Whey_MP.png', 3);
insert into proteina (nombre, marca, precio, cantidad1, cantidad2, cantidad3, tipo, sabor1, sabor2, sabor3, sabor4, sabor5, descripcion, imagen_url, Productos_id) values('Whey Protein', 'hsn', 33.3, 1, 2, 3, 'vegan', 'Chocolate', 'Platano', 'Vainilla', 'Cookies', 'Caramelo', 'Este suero de alta calidad incluye 21 g de proteina por racion, toda la proteina que necesitas. El producto se filtra y seca unicamente por aspersion para ofrecer solo nutrientes naturales.', '/source/index/recomendados/wheyProtein_MP.png', 4);
insert into proteina (nombre, marca, precio, cantidad1, cantidad2, cantidad3, tipo, sabor1, sabor2, sabor3, sabor4, sabor5, descripcion, imagen_url, Productos_id) values('Pee Protein', 'hsn', 33.3, 1, 2, 3, 'vegan', 'Chocolate', 'Platano', 'Vainilla', 'Cookies', 'Caramelo', 'Este suero de alta calidad incluye 21 g de proteina por racion, toda la proteina que necesitas. El producto se filtra y seca unicamente por aspersion para ofrecer solo nutrientes naturales.', '/source/index/recomendados/wheyProtein_MP.png', 30);


insert into carbohidratos (nombre, marca, precio, cantidad1, cantidad2, cantidad3, tipo, sabor1, sabor2, sabor3, sabor4, sabor5, descripcion, imagen_url, Productos_id) values('Carbohidrato', 'hsn', 40, 1, 2, 3, 'Ciclodextrina', 'Chocolate', 'Platano', 'Vainilla', 'Cookies', 'Caramelo', 'Su capacidad para formar complejos de inclusión con compuestos hidrofóbicos permite mejorar la solubilidad y biodisponibilidad de nutrientes y sustancias activas, como vitaminas, minerales y compuestos energéticos.', '/source/index/recomendados/wheyProtein_MP.png', 5);
insert into carbohidratos (nombre, marca, precio, cantidad1, cantidad2, cantidad3, tipo, sabor1, sabor2, sabor3, sabor4, sabor5, descripcion, imagen_url, Productos_id) values('Carbohidrato', 'hsn', 40, 1, 2, 3, 'Ciclodextrina', 'Chocolate', 'Platano', 'Vainilla', 'Cookies', 'Caramelo', 'Su capacidad para formar complejos de inclusión con compuestos hidrofóbicos permite mejorar la solubilidad y biodisponibilidad de nutrientes y sustancias activas, como vitaminas, minerales y compuestos energéticos.', '/source/index/recomendados/wheyProtein_MP.png', 26);
insert into carbohidratos (nombre, marca, precio, cantidad1, cantidad2, cantidad3, tipo, sabor1, sabor2, sabor3, sabor4, sabor5, descripcion, imagen_url, Productos_id) values('Carbohidrato', 'hsn', 40, 1, 2, 3, 'Ciclodextrina', 'Chocolate', 'Platano', 'Vainilla', 'Cookies', 'Caramelo', 'Su capacidad para formar complejos de inclusión con compuestos hidrofóbicos permite mejorar la solubilidad y biodisponibilidad de nutrientes y sustancias activas, como vitaminas, minerales y compuestos energéticos.', '/source/index/recomendados/wheyProtein_MP.png', 27);
insert into carbohidratos (nombre, marca, precio, cantidad1, cantidad2, cantidad3, tipo, sabor1, sabor2, sabor3, sabor4, sabor5, descripcion, imagen_url, Productos_id) values('Carbohidrato', 'hsn', 40, 1, 2, 3, 'Ciclodextrina', 'Chocolate', 'Platano', 'Vainilla', 'Cookies', 'Caramelo', 'Su capacidad para formar complejos de inclusión con compuestos hidrofóbicos permite mejorar la solubilidad y biodisponibilidad de nutrientes y sustancias activas, como vitaminas, minerales y compuestos energéticos.', '/source/index/recomendados/wheyProtein_MP.png', 28);
insert into carbohidratos (nombre, marca, precio, cantidad1, cantidad2, cantidad3, tipo, sabor1, sabor2, sabor3, sabor4, sabor5, descripcion, imagen_url, Productos_id) values('Carbohidrato', 'hsn', 40, 1, 2, 3, 'Ciclodextrina', 'Chocolate', 'Platano', 'Vainilla', 'Cookies', 'Caramelo', 'Su capacidad para formar complejos de inclusión con compuestos hidrofóbicos permite mejorar la solubilidad y biodisponibilidad de nutrientes y sustancias activas, como vitaminas, minerales y compuestos energéticos.', '/source/index/recomendados/wheyProtein_MP.png', 29);

insert into creatina (nombre, marca, precio, cantidad1, cantidad2, cantidad3, creapure, sabor1, sabor2, sabor3, sabor4, sabor5, descripcion, imagen_url, Productos_id) values('Creatina Monohidratada', 'hsn', 24, 250, 0.5, 1, 1, 'Chocolate', 'Platano', 'Vainilla', 'Cookies', 'Caramelo', 'La creatina es un compuesto natural que se encuentra en el cuerpo y se utiliza como fuente de energía rápida durante ejercicios intensos y de corta duración. Se ha demostrado que la suplementación con creatina aumenta la capacidad de trabajo muscular, mejora el rendimiento atlético y promueve la ganancia de masa muscular. ', '/source/index/recomendados/creatina_Hsn.png', 6);
insert into creatina (nombre, marca, precio, cantidad1, cantidad2, cantidad3, creapure, sabor1, sabor2, sabor3, sabor4, sabor5, descripcion, imagen_url, Productos_id) values('Creatina Monohidratada', 'hsn', 24, 250, 0.5, 1, 0, 'Chocolate', 'Platano', 'Vainilla', 'Cookies', 'Caramelo', 'La creatina es un compuesto natural que se encuentra en el cuerpo y se utiliza como fuente de energía rápida durante ejercicios intensos y de corta duración. Se ha demostrado que la suplementación con creatina aumenta la capacidad de trabajo muscular, mejora el rendimiento atlético y promueve la ganancia de masa muscular. ', '/source/index/recomendados/creatina_Hsn.png', 11);
insert into creatina (nombre, marca, precio, cantidad1, cantidad2, cantidad3, creapure, sabor1, sabor2, sabor3, sabor4, sabor5, descripcion, imagen_url, Productos_id) values('Creatina Monohidratada', 'hsn', 24, 250, 0.5, 1, 0, 'Chocolate', 'Platano', 'Vainilla', 'Cookies', 'Caramelo', 'La creatina es un compuesto natural que se encuentra en el cuerpo y se utiliza como fuente de energía rápida durante ejercicios intensos y de corta duración. Se ha demostrado que la suplementación con creatina aumenta la capacidad de trabajo muscular, mejora el rendimiento atlético y promueve la ganancia de masa muscular. ', '/source/index/recomendados/creatina_Hsn.png', 23);
insert into creatina (nombre, marca, precio, cantidad1, cantidad2, cantidad3, creapure, sabor1, sabor2, sabor3, sabor4, sabor5, descripcion, imagen_url, Productos_id) values('Creatina Monohidratada', 'hsn', 24, 250, 0.5, 1, 0, 'Chocolate', 'Platano', 'Vainilla', 'Cookies', 'Caramelo', 'La creatina es un compuesto natural que se encuentra en el cuerpo y se utiliza como fuente de energía rápida durante ejercicios intensos y de corta duración. Se ha demostrado que la suplementación con creatina aumenta la capacidad de trabajo muscular, mejora el rendimiento atlético y promueve la ganancia de masa muscular. ', '/source/index/recomendados/creatina_Hsn.png', 24);
insert into creatina (nombre, marca, precio, cantidad1, cantidad2, cantidad3, creapure, sabor1, sabor2, sabor3, sabor4, sabor5, descripcion, imagen_url, Productos_id) values('Creatina Monohidratada', 'hsn', 24, 250, 0.5, 1, 0, 'Chocolate', 'Platano', 'Vainilla', 'Cookies', 'Caramelo', 'La creatina es un compuesto natural que se encuentra en el cuerpo y se utiliza como fuente de energía rápida durante ejercicios intensos y de corta duración. Se ha demostrado que la suplementación con creatina aumenta la capacidad de trabajo muscular, mejora el rendimiento atlético y promueve la ganancia de masa muscular. ', '/source/index/recomendados/creatina_Hsn.png', 25);


insert into aminoacidos (nombre, marca, precio, cantidad1, cantidad2, cantidad3, tipo, sabor1, sabor2, sabor3, sabor4, sabor5, descripcion, imagen_url, Productos_id) values('BCAA 2:1:1', 'hsn', 21.30, 250, 0.5, 1, 'BCAA', 'Chocolate', 'Platano', 'Vainilla', 'Cookies', 'Caramelo', 'Son fundamentales para la síntesis de proteínas y desempeñan un papel crucial en el crecimiento y reparación muscular. Además, los BCAA se utilizan como fuente de energía durante el ejercicio intenso y pueden ayudar a reducir la fatiga muscular.', '/source/index/recomendados/wheyProtein_MP.png', 7);
insert into aminoacidos (nombre, marca, precio, cantidad1, cantidad2, cantidad3, tipo, sabor1, sabor2, sabor3, sabor4, sabor5, descripcion, imagen_url, Productos_id) values('Glutamina', 'Amix', 21.30, 250, 0.5, 1, 'Aminoacido Esencial', 'Chocolate', 'Platano', 'Vainilla', 'Cookies', 'Caramelo', 'Son fundamentales para la síntesis de proteínas y desempeñan un papel crucial en el crecimiento y reparación muscular. Además, los BCAA se utilizan como fuente de energía durante el ejercicio intenso y pueden ayudar a reducir la fatiga muscular.', '/source/index/recomendados/glutamina_Amix.png', 10);
insert into aminoacidos (nombre, marca, precio, cantidad1, cantidad2, cantidad3, tipo, sabor1, sabor2, sabor3, sabor4, sabor5, descripcion, imagen_url, Productos_id) values('Glutamina', 'Amix', 21.30, 250, 0.5, 1, 'Aminoacido Esencial', 'Chocolate', 'Platano', 'Vainilla', 'Cookies', 'Caramelo', 'Son fundamentales para la síntesis de proteínas y desempeñan un papel crucial en el crecimiento y reparación muscular. Además, los BCAA se utilizan como fuente de energía durante el ejercicio intenso y pueden ayudar a reducir la fatiga muscular.', '/source/index/recomendados/glutamina_Amix.png', 20);
insert into aminoacidos (nombre, marca, precio, cantidad1, cantidad2, cantidad3, tipo, sabor1, sabor2, sabor3, sabor4, sabor5, descripcion, imagen_url, Productos_id) values('Glutamina', 'Amix', 21.30, 250, 0.5, 1, 'Aminoacido Esencial', 'Chocolate', 'Platano', 'Vainilla', 'Cookies', 'Caramelo', 'Son fundamentales para la síntesis de proteínas y desempeñan un papel crucial en el crecimiento y reparación muscular. Además, los BCAA se utilizan como fuente de energía durante el ejercicio intenso y pueden ayudar a reducir la fatiga muscular.', '/source/index/recomendados/glutamina_Amix.png', 21);
insert into aminoacidos (nombre, marca, precio, cantidad1, cantidad2, cantidad3, tipo, sabor1, sabor2, sabor3, sabor4, sabor5, descripcion, imagen_url, Productos_id) values('Glutamina', 'Amix', 21.30, 250, 0.5, 1, 'Aminoacido Esencial', 'Chocolate', 'Platano', 'Vainilla', 'Cookies', 'Caramelo', 'Son fundamentales para la síntesis de proteínas y desempeñan un papel crucial en el crecimiento y reparación muscular. Además, los BCAA se utilizan como fuente de energía durante el ejercicio intenso y pueden ayudar a reducir la fatiga muscular.', '/source/index/recomendados/glutamina_Amix.png', 22);


insert into vitaminas (nombre, marca, precio, cantidad1, cantidad2, cantidad3, tipo, descripcion, imagen_url, Productos_id) values('Multivitaminico', 'hsn', 21.30, 50, 70, 100, 'Capsulas', 'El zinc desempeña un papel importante en la cicatrización de heridas y la salud de la piel. El magnesio, por su parte, es necesario para más de 300 reacciones enzimáticas en el cuerpo, incluyendo la producción de energía, la función muscular y nerviosa, y la formación de huesos y dientes.', '/source/index/recomendados/multivitaminico_Hsn.png', 8);
insert into vitaminas (nombre, marca, precio, cantidad1, cantidad2, cantidad3, tipo, descripcion, imagen_url, Productos_id) values('Multivitaminico', 'hsn', 21.30, 50, 70, 100, 'Capsulas', 'El zinc desempeña un papel importante en la cicatrización de heridas y la salud de la piel. El magnesio, por su parte, es necesario para más de 300 reacciones enzimáticas en el cuerpo, incluyendo la producción de energía, la función muscular y nerviosa, y la formación de huesos y dientes.', '/source/index/recomendados/multivitaminico_Hsn.png', 16);
insert into vitaminas (nombre, marca, precio, cantidad1, cantidad2, cantidad3, tipo, descripcion, imagen_url, Productos_id) values('Multivitaminico', 'hsn', 21.30, 50, 70, 100, 'Capsulas', 'El zinc desempeña un papel importante en la cicatrización de heridas y la salud de la piel. El magnesio, por su parte, es necesario para más de 300 reacciones enzimáticas en el cuerpo, incluyendo la producción de energía, la función muscular y nerviosa, y la formación de huesos y dientes.', '/source/index/recomendados/multivitaminico_Hsn.png', 17);
insert into vitaminas (nombre, marca, precio, cantidad1, cantidad2, cantidad3, tipo, descripcion, imagen_url, Productos_id) values('Multivitaminico', 'hsn', 21.30, 50, 70, 100, 'Capsulas', 'El zinc desempeña un papel importante en la cicatrización de heridas y la salud de la piel. El magnesio, por su parte, es necesario para más de 300 reacciones enzimáticas en el cuerpo, incluyendo la producción de energía, la función muscular y nerviosa, y la formación de huesos y dientes.', '/source/index/recomendados/multivitaminico_Hsn.png', 18);
insert into vitaminas (nombre, marca, precio, cantidad1, cantidad2, cantidad3, tipo, descripcion, imagen_url, Productos_id) values('Multivitaminico', 'hsn', 21.30, 50, 70, 100, 'Capsulas', 'El zinc desempeña un papel importante en la cicatrización de heridas y la salud de la piel. El magnesio, por su parte, es necesario para más de 300 reacciones enzimáticas en el cuerpo, incluyendo la producción de energía, la función muscular y nerviosa, y la formación de huesos y dientes.', '/source/index/recomendados/multivitaminico_Hsn.png', 19);

insert into barritas (nombre, marca, precio, sabor1, sabor2, sabor3, descripcion, contenido1, contenido2, contenido3, imagen_url, Productos_id) values('Impact Protein', 'MyProtein', '4.50', 'chocolate', 'fresa', 'caramelo', 'Están hechas con una mezcla de proteínas de alta calidad, como suero de leche y proteína de guisante, y suelen contener alrededor de 20 gramos de proteína por barrita. ', '5', '7', '10', '/source/index/recomendados/wheyProtein_MP.png', 9);
insert into barritas (nombre, marca, precio, sabor1, sabor2, sabor3, descripcion, contenido1, contenido2, contenido3, imagen_url, Productos_id) values('Impact Protein', 'MyProtein', '4.50', 'chocolate', 'fresa', 'caramelo', 'Están hechas con una mezcla de proteínas de alta calidad, como suero de leche y proteína de guisante, y suelen contener alrededor de 20 gramos de proteína por barrita. ', '5', '7', '10', '/source/index/recomendados/wheyProtein_MP.png', 12);
insert into barritas (nombre, marca, precio, sabor1, sabor2, sabor3, descripcion, contenido1, contenido2, contenido3, imagen_url, Productos_id) values('Impact Protein', 'MyProtein', '4.50', 'chocolate', 'fresa', 'caramelo', 'Están hechas con una mezcla de proteínas de alta calidad, como suero de leche y proteína de guisante, y suelen contener alrededor de 20 gramos de proteína por barrita. ', '5', '7', '10', '/source/index/recomendados/wheyProtein_MP.png', 13);
insert into barritas (nombre, marca, precio, sabor1, sabor2, sabor3, descripcion, contenido1, contenido2, contenido3, imagen_url, Productos_id) values('Impact Protein', 'MyProtein', '4.50', 'chocolate', 'fresa', 'caramelo', 'Están hechas con una mezcla de proteínas de alta calidad, como suero de leche y proteína de guisante, y suelen contener alrededor de 20 gramos de proteína por barrita. ', '5', '7', '10', '/source/index/recomendados/wheyProtein_MP.png', 14);
insert into barritas (nombre, marca, precio, sabor1, sabor2, sabor3, descripcion, contenido1, contenido2, contenido3, imagen_url, Productos_id) values('Impact Protein', 'MyProtein', '4.50', 'chocolate', 'fresa', 'caramelo', 'Están hechas con una mezcla de proteínas de alta calidad, como suero de leche y proteína de guisante, y suelen contener alrededor de 20 gramos de proteína por barrita. ', '5', '7', '10', '/source/index/recomendados/wheyProtein_MP.png', 15);







