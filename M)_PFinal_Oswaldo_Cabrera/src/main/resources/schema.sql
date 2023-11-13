DROP TABLE IF EXISTS alumnos;
create table alumnos (
    matricula varchar(10),
    nombre_alumno varchar(25),
    paterno varchar(25),
    fnac date,
    estatura decimal(10,2),
    PRIMARY KEY (matricula)
);
