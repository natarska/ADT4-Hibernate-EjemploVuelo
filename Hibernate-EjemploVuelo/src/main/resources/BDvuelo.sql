drop database if exists vuelos;

create database vuelos;

use vuelos; 

CREATE TABLE `Vuelo` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `numero` int unsigned NOT NULL UNIQUE,
  `longitud` int unsigned NOT NULL,
  `tipoVuelo` varchar(20) NOT NULL,
  `horaSalida` time NOT NULL,
  `codigo` Blob NOT NULL,  
  `texto` Blob NOT NULL,  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;