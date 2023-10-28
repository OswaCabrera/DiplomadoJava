DROP TABLE IF EXISTS Calificaciones;
create table calificaciones (id int not null primary key, materia varchar(30), calificacion integer, alumnos_matricula varchar(10));

DROP TABLE IF EXISTS alumnos;
create table alumnos (matricula varchar(10), nombre_alumno varchar(25), paterno varchar(25), fnac date, estatura decimal(10,2), PRIMARY KEY (matricula));
