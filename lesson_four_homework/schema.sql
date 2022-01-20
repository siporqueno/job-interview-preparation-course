CREATE SCHEMA `cinema` ;

CREATE TABLE `cinema`.`film_durations` (
  `id` INT NOT NULL,
  `duration` TIME NOT NULL,
  UNIQUE INDEX `duration_UNIQUE` (`duration` ASC) VISIBLE,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `cinema`.`films` (
  `id` INT NOT NULL,
  `title` VARCHAR(128) NOT NULL,
  `duration_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_films_duration_id_idx` (`duration_id` ASC) VISIBLE,
  CONSTRAINT `fk_films_duration_id`
    FOREIGN KEY (`duration_id`)
    REFERENCES `cinema`.`film_durations` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    CREATE TABLE `cinema`.`film_shows` (
  `id` INT NOT NULL,
  `film_id` INT NOT NULL,
  `start` DATETIME NOT NULL,
  `fee` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_films_shows_film_id_idx` (`film_id` ASC) VISIBLE,
  CONSTRAINT `fk_films_shows_film_id`
    FOREIGN KEY (`film_id`)
    REFERENCES `cinema`.`films` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    CREATE TABLE `cinema`.`tickets` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `film_show_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tickets_film_show_id_idx` (`film_show_id` ASC) VISIBLE,
  CONSTRAINT `fk_tickets_film_show_id`
    FOREIGN KEY (`film_show_id`)
    REFERENCES `cinema`.`film_shows` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    CREATE TABLE `cinema`.`time_ranges` (
  `id` INT NOT NULL,
  `range_label` VARCHAR(45) NOT NULL,
  `beginning` TIME NOT NULL,
  `end` TIME NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `beginning_UNIQUE` (`beginning` ASC) VISIBLE,
  UNIQUE INDEX `end_UNIQUE` (`end` ASC) VISIBLE);