  INSERT INTO `cinema`.`film_durations` (`id`, `duration`) VALUES ('1', '01:00:00');
  INSERT INTO `cinema`.`film_durations` (`id`, `duration`) VALUES ('2', '01:30:00');
  INSERT INTO `cinema`.`film_durations` (`id`, `duration`) VALUES ('3', '02:00:00');
  
  INSERT INTO `cinema`.`films` (id, `title`,`duration_id`) VALUES ('1', 'Matrix', '3');
  INSERT INTO `cinema`.`films` (id, `title`,`duration_id`) VALUES ('2', 'Pulp Fiction', '3');
  INSERT INTO `cinema`.`films` (id, `title`,`duration_id`) VALUES ('3', 'Eralash', '1');
  INSERT INTO `cinema`.`films` (id, `title`,`duration_id`) VALUES ('4', 'Nu pogodi!', '2');
  INSERT INTO `cinema`.`films` (id, `title`,`duration_id`) VALUES ('5', 'Alladin', '2');
  
  INSERT INTO `cinema`.`film_shows` (`id`, `film_id`,`start`, `fee`) VALUES ('1', '3', '2021-12-26 09:00:00', '100');
  INSERT INTO `cinema`.`film_shows` (`id`, `film_id`,`start`, `fee`) VALUES ('2', '1', '2021-12-26 10:15:00', '150');
  INSERT INTO `cinema`.`film_shows` (`id`, `film_id`,`start`, `fee`) VALUES ('3', '4', '2021-12-26 12:00:00', '150');
  INSERT INTO `cinema`.`film_shows` (`id`, `film_id`,`start`, `fee`) VALUES ('4', '2', '2021-12-26 14:15:00', '200');
  INSERT INTO `cinema`.`film_shows` (`id`, `film_id`,`start`, `fee`) VALUES ('5', '5', '2021-12-26 15:45:00', '200');
  INSERT INTO `cinema`.`film_shows` (`id`, `film_id`,`start`, `fee`) VALUES ('6', '1', '2021-12-26 17:50:00', '300');
  INSERT INTO `cinema`.`film_shows` (`id`, `film_id`,`start`, `fee`) VALUES ('7', '2', '2021-12-26 20:00:00', '300');
  INSERT INTO `cinema`.`film_shows` (`id`, `film_id`,`start`, `fee`) VALUES ('8', '5', '2021-12-26 21:40:00', '250');
  
  INSERT INTO `cinema`.`tickets` (`film_show_id`) VALUES ('1');
  INSERT INTO `cinema`.`tickets` (`film_show_id`) VALUES ('2');
  INSERT INTO `cinema`.`tickets` (`film_show_id`) VALUES ('3');
  INSERT INTO `cinema`.`tickets` (`film_show_id`) VALUES ('4');
  INSERT INTO `cinema`.`tickets` (`film_show_id`) VALUES ('5');
  INSERT INTO `cinema`.`tickets` (`film_show_id`) VALUES ('6');
  INSERT INTO `cinema`.`tickets` (`film_show_id`) VALUES ('7');
  INSERT INTO `cinema`.`tickets` (`film_show_id`) VALUES ('8');
  
  INSERT INTO `cinema`.`time_ranges` (`id`, `range_label`, `beginning`, `end`) VALUES ('1', '09-15', '09:00:00', '15:00:00');
  INSERT INTO `cinema`.`time_ranges` (`id`, `range_label`, `beginning`, `end`) VALUES ('2', '15-18', '15:00:00', '18:00:00');
  INSERT INTO `cinema`.`time_ranges` (`id`, `range_label`, `beginning`, `end`) VALUES ('3', '18-21', '18:00:00', '21:00:00');
  INSERT INTO `cinema`.`time_ranges` (`id`, `range_label`, `beginning`, `end`) VALUES ('4', '21-24', '21:00:00', '24:00:00');