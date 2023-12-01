SET NAMES 'UTF8MB4';
DROP DATABASE IF EXISTS reservaciones;
CREATE DATABASE IF NOT EXISTS reservaciones DEFAULT CHARACTER SET UTF8MB4;
USE reservaciones;

CREATE TABLE cliente(
id_cte  					INTEGER NOT NULL AUTO_INCREMENT,
nombre						VARCHAR(30) NOT NULL,
apellido_paterno			VARCHAR(30) NOT NULL,
tarjeta_credito				VARCHAR(20) NOT NULL,
correo						VARCHAR(40) NOT NULL UNIQUE,
telefono					VARCHAR(10) NOT NULL UNIQUE,
PRIMARY KEY(id_cte)
)DEFAULT CHARACTER SET UTF8MB4;

CREATE TABLE hotel(
id_htl	 					INTEGER NOT NULL AUTO_INCREMENT,
nombre						VARCHAR(50) NOT NULL,
direccion					VARCHAR(100) NOT NULL,
clasificacion				SMALLINT NOT NULL,
correo						VARCHAR(40) NOT NULL UNIQUE,
telefono					VARCHAR(10) NOT NULL UNIQUE,
imagen						VARCHAR(100) DEFAULT 'Sin_imagen_disponible.jpg',
PRIMARY KEY(id_htl)
)DEFAULT CHARACTER SET UTF8MB4;

CREATE TABLE habitacion(
id_hbt	 					INTEGER NOT NULL AUTO_INCREMENT,
nombre						VARCHAR(50) NOT NULL,
refrigerador				BOOLEAN DEFAULT FALSE,
numero_camas				SMALLINT NOT NULL,
precio						FLOAT(7,2),
imagen						VARCHAR(100) DEFAULT 'Sin_imagen_disponible.jpg',
id_htl	 					INTEGER NOT NULL,
PRIMARY KEY(id_hbt),
FOREIGN KEY(id_htl) REFERENCES hotel(id_htl) ON DELETE CASCADE
)DEFAULT CHARACTER SET UTF8MB4;

CREATE TABLE reservacion(
id_rsv	 					INTEGER NOT NULL AUTO_INCREMENT,
fecha_reservacion			DATE NOT NULL,
fecha_inicio				DATE NOT NULL,
fecha_termino				DATE NOT NULL,
total_dias					SMALLINT,
id_cte	 					INTEGER,
id_hbt	 					INTEGER,
PRIMARY KEY(id_rsv),
FOREIGN KEY(id_cte) REFERENCES cliente(id_cte) ON DELETE SET NULL,
FOREIGN KEY(id_hbt) REFERENCES habitacion(id_hbt) ON DELETE SET NULL
)DEFAULT CHARACTER SET UTF8MB4;

DELIMITER $$
create trigger dias_contar before insert on reservacion for each row 
begin
	set new.total_dias=datediff(new.fecha_termino,new.fecha_inicio);
end $$
delimiter ;

DELETE FROM cliente;
DELETE FROM hotel;
DELETE FROM habitacion;
DELETE FROM reservacion;

alter table cliente auto_increment=1;
alter table hotel auto_increment=1;
alter table habitacion auto_increment=1;
alter table reservacion auto_increment=1;

INSERT INTO cliente(nombre,apellido_paterno,tarjeta_credito,correo,telefono) VALUES 
					("Roberto","Trejo",1233342154,"roberto@gmail.com",1234567891),
					("Mario","Delgado",1143342154,"mario@gmail.com",9234567891),
					("Rebeca","Hernandez",11466762154,"rebeca@gmail.com",5233456789);
INSERT INTO hotel(nombre,direccion,clasificacion,correo,telefono,imagen) VALUES
					("Hotel 1","Dirección 1",5,"hotel_1@gmail.com",2234567891,'Sin_imagen_disponible.jpg'),
					("Hotel 2","Dirección 2",4,"hotel_2@gmail.com",3234567891,'Sin_imagen_disponible.jpg'),
					("Hotel 3","Dirección 3",2,"hotel_3@gmail.com",4234567891,'Sin_imagen_disponible.jpg');
INSERT INTO habitacion(nombre,refrigerador,numero_camas,precio,id_htl) VALUES
					("Habitacion 1_1",false,2,850.99,1),
					("Habitacion 1_2",true,1,450.99,1),
					("Habitacion 1_3",true,2,1850.99,1),
					("Habitacion 2_1",false,3,1850.99,2),
					("Habitacion 2_2",true,2,750.99,2),
					("Habitacion 2_3",true,1,2850.99,2),
					("Habitacion 3_1",false,2,150.99,3),
					("Habitacion 3_2",true,2,250.99,3),
					("Habitacion 3_3",true,2,850.99,3);
INSERT INTO reservacion(fecha_reservacion,fecha_inicio,fecha_termino,id_cte,id_hbt) VALUES
					(NOW(),"2023-10-20","2023-10-24",1,2),
					(NOW(),"2023-10-10","2023-10-24",2,6),
					(NOW(),"2023-9-20","2023-10-24",2,7),
					(NOW(),"2023-05-20","2023-05-24",1,9);
					
					
					
					
					




