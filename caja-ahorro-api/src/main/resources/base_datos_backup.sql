SET NAMES 'UTF8MB4';
DROP DATABASE IF EXISTS caja_ahorro_bd;
CREATE DATABASE IF NOT EXISTS caja_ahorro_bd DEFAULT CHARACTER SET UTF8MB4;

use caja_ahorro_bd;

create table if not exists ESTATUS_CUENTA
(
    ESTATUS_CUENTA_ID int auto_increment
    primary key,
    NOMBRE            varchar(40) not null,
    DESCRIPCION       text        not null
    );

create table if not exists CUENTA
(
    CUENTA_ID         int auto_increment
    primary key,
    SALDO             int default 0 not null,
    FECHA_APERTURA    datetime      not null,
    USUARIO_ID        int           not null,
    ESTATUS_CUENTA_ID int           null,
    constraint RefESTATUS_CUENTA18
    foreign key (ESTATUS_CUENTA_ID) references ESTATUS_CUENTA (ESTATUS_CUENTA_ID)
    );

create table if not exists ESTATUS_PRESTAMOS
(
    ESTATUS_PRESTAMOS_ID int auto_increment
    primary key,
    NOMBRE               varchar(40) not null,
    DESCRIPCION          text        not null
    );

create table if not exists ESTATUS_TRANSACCION
(
    ESTATUS_TRANSACCION_ID int auto_increment
    primary key,
    NOMBRE                 varchar(40) not null,
    DESCRIPCION            text not null
    );

create table if not exists HISTORICO_ESTATUS_CUENTA
(
    HISTORICO_ESTATUS_CUENTA_ID int auto_increment
    primary key,
    FECHA                       date not null,
    CUENTA_ID                   int  not null,
    ESTATUS_CUENTA_ID           int  not null,
    constraint RefCUENTA16
    foreign key (CUENTA_ID) references CUENTA (CUENTA_ID),
    constraint RefESTATUS_CUENTA17
    foreign key (ESTATUS_CUENTA_ID) references ESTATUS_CUENTA (ESTATUS_CUENTA_ID)
    );

create table if not exists PRESTAMO
(
    PRESTAMO_ID          int auto_increment
    primary key,
    MENSUALIDADES        int default 1 not null
    check (`MENSUALIDADES` > 0),
    INTERES              int           not null,
    MONTO_PAGAR          int           not null,
    MONTO_ORIGINAL       int           not null
    check (`MONTO_ORIGINAL` > 0),
    FECHA_PETICION       datetime      not null,
    USUARIO_ID           int           null,
    ESTATUS_PRESTAMOS_ID int           not null,
    constraint RefESTATUS_PRESTAMOS8
    foreign key (ESTATUS_PRESTAMOS_ID) references ESTATUS_PRESTAMOS (ESTATUS_PRESTAMOS_ID)
    );

create table if not exists HISTORICO_ESTATUS_PRESTAMOS
(
    HISTORICO_ESTATUS_PRESTAMOS_ID int auto_increment
    primary key,
    DEUDA                          int      not null,
    FECHA_ACTUALIZACION            datetime not null,
    ESTATUS_PRESTAMOS_ID           int      not null,
    PRESTAMO_ID                    int      not null,
    constraint RefESTATUS_PRESTAMOS9
    foreign key (ESTATUS_PRESTAMOS_ID) references ESTATUS_PRESTAMOS (ESTATUS_PRESTAMOS_ID),
    constraint RefPRESTAMO10
    foreign key (PRESTAMO_ID) references PRESTAMO (PRESTAMO_ID)
    );

create table if not exists ROL
(
    ROL_ID      tinyint auto_increment
    primary key,
    NOMBRE      varchar(40) not null,
    DESCRIPCION varchar(40) not null
    );

create table if not exists TIPO_TRANSACCION
(
    TIPO_TRANSACCION_ID tinyint auto_increment
    primary key,
    NOMBRE              varchar(40) not null,
    DESCRIPCION         text        not null
    );

create table if not exists TRANSACCION
(
    TRANSACCION_ID         int auto_increment
    primary key,
    MONTO                  int      not null,
    FECHA                  datetime not null,
    CUENTA_ID              int      not null,
    TIPO_TRANSACCION_ID    tinyint  null,
    ESTATUS_TRANSACCION_ID int      null,
    constraint RefESTATUS_TRANSACCION21
    foreign key (ESTATUS_TRANSACCION_ID) references ESTATUS_TRANSACCION (ESTATUS_TRANSACCION_ID),
    constraint RefTIPO_TRANSACCION15
    foreign key (TIPO_TRANSACCION_ID) references TIPO_TRANSACCION (TIPO_TRANSACCION_ID)
    );

create table if not exists HISTORICO_ESTATUS_TRANSACCION
(
    HISTORICO_ESTATUS_TRANSACCION_ID int auto_increment
    primary key,
    FECHA                            date not null,
    ESTATUS_TRANSACCION_ID           int  not null,
    TRANSACCION_ID                   int  not null,
    constraint RefESTATUS_TRANSACCION20
    foreign key (ESTATUS_TRANSACCION_ID) references ESTATUS_TRANSACCION (ESTATUS_TRANSACCION_ID),
    constraint RefTRANSACCION24
    foreign key (TRANSACCION_ID) references TRANSACCION (TRANSACCION_ID)
    );

create table if not exists TRANSACCION_ABONO_AHORRO
(
    TRANSACCION_ID int auto_increment
    primary key,
    DIAS_ATRASO    tinyint default 0 not null,
    constraint RefTRANSACCION13
    foreign key (TRANSACCION_ID) references TRANSACCION (TRANSACCION_ID)
    );

create table if not exists TRANSACCION_PAGO_PRESTAMO
(
    TRANSACCION_ID int auto_increment
    primary key,
    PRESTAMO_ID    int not null,
    constraint RefPRESTAMO14
    foreign key (PRESTAMO_ID) references PRESTAMO (PRESTAMO_ID),
    constraint RefTRANSACCION12
    foreign key (TRANSACCION_ID) references TRANSACCION (TRANSACCION_ID)
    );

create table if not exists USUARIO
(
    USUARIO_ID        int auto_increment
    primary key,
    EMAIL             varchar(100) not null,
    CONTRASENA        varchar(250) not null,
    APELLIDO_MATERNO  varchar(40)  not null,
    NUMERO_TELEFONICO varchar(12)  not null,
    NOMBRE            varchar(40)  not null,
    APELLIDO_PATERNO  varchar(40)  not null,
    ROL_ID            tinyint      not null,
    constraint RefROL11
    foreign key (ROL_ID) references ROL (ROL_ID)
    );


INSERT INTO ESTATUS_CUENTA (NOMBRE, DESCRIPCION) VALUES
                                                     ('Activa', 'La cuenta está activa y en buen estado.'),
                                                     ('Inactiva', 'La cuenta ha sido desactivada temporalmente.'),
                                                     ('Pendiente', 'La cuenta está pendiente de aprobación.'),
                                                     ('Bloqueada', 'La cuenta ha sido bloqueada debido a actividades sospechosas.'),
                                                     ('Cerrada', 'La cuenta ha sido cerrada permanentemente.');

INSERT INTO ESTATUS_PRESTAMOS (NOMBRE, DESCRIPCION) VALUES
                                                        ('Pendiente', 'El préstamo está pendiente de aprobación.'),
                                                        ('Aprobado', 'El préstamo ha sido aprobado y está activo.'),
                                                        ('Rechazado', 'El préstamo ha sido rechazado.'),
                                                        ('Pagado', 'El préstamo ha sido completamente pagado.'),
                                                        ('Vencido', 'El préstamo está vencido y pendiente de pago.');

INSERT INTO ESTATUS_TRANSACCION (NOMBRE, DESCRIPCION) VALUES
                                                          ('Exitosa', 'La transacción se ha completado con éxito.'),
                                                          ('Pendiente', 'La transacción está pendiente de procesamiento.'),
                                                          ('Rechazada', 'La transacción ha sido rechazada.'),
                                                          ('Cancelada', 'La transacción ha sido cancelada por el usuario.'),
                                                          ('Error', 'La transacción ha experimentado un error');

INSERT INTO TIPO_TRANSACCION (NOMBRE, DESCRIPCION) VALUES
                                                       ('Pago', 'Transacción para pagar un prestamo'),
                                                       ('Abono', 'Transaccion para abonar a cuenta');


INSERT INTO ROL (NOMBRE, DESCRIPCION) VALUES
                                          ('Admin', 'Rol de administrador.'),
                                          ('Usuario', 'Usuarios registrados.'),
                                          ('Moderador', 'Rol con permisos moderados.'),
                                          ('Editor', 'Editar contenido.'),
                                          ('Invitado', 'Usuarios no registrados o invitados.');


INSERT INTO USUARIO (EMAIL, CONTRASENA, APELLIDO_MATERNO, NUMERO_TELEFONICO, NOMBRE, APELLIDO_PATERNO, ROL_ID) VALUES
                                                                                                                   ('usuario1@example.com', 'contrasena123', 'Gómez', '5534567890', 'Ana', 'Pérez', 2),
                                                                                                                   ('usuario2@example.com', 'password456', 'López', '5576543210', 'Juan', 'Sánchez', 3),
                                                                                                                   ('usuario3@example.com', 'pass789', 'Martínez', '5543210987', 'Laura', 'García', 1);

INSERT INTO CUENTA (SALDO, FECHA_APERTURA, USUARIO_ID, ESTATUS_CUENTA_ID) VALUES
                                                                              (1000, '2023-01-01 08:00:00', 1, 1),
                                                                              (500, '2023-02-15 10:30:00', 2, 1),
                                                                              (2000, '2023-03-20 15:45:00', 3, 2);

/*
INSERT INTO HISTORICO_ESTATUS_CUENTA (FECHA, CUENTA_ID, ESTATUS_CUENTA_ID) VALUES
('2023-01-15', 1, 2),
('2023-02-28', 2, 3),
('2023-03-10', 3, 1);


 */
INSERT INTO PRESTAMO (MENSUALIDADES, INTERES, MONTO_PAGAR, MONTO_ORIGINAL, FECHA_PETICION, USUARIO_ID, ESTATUS_PRESTAMOS_ID) VALUES
                                                                                                                                 (12, 5, 12000, 10000, '2023-01-05 14:30:00', 1, 1),
                                                                                                                                 (6, 8, 8000, 7000, '2023-02-10 10:15:00', 2, 2),
                                                                                                                                 (24, 10, 24000, 20000, '2023-03-15 16:45:00', 3, 1),
                                                                                                                                 (18, 6, 18000, 15000, '2023-04-20 12:00:00', 1, 3),
                                                                                                                                 (9, 7, 9000, 8000, '2023-05-25 09:30:00', 2, 2),
                                                                                                                                 (12, 4, 12000, 11000, '2023-06-30 13:45:00', 3, 1),
                                                                                                                                 (6, 9, 6000, 5000, '2023-07-05 11:00:00', 1, 3),
                                                                                                                                 (24, 12, 30000, 25000, '2023-08-10 15:15:00', 2, 2),
                                                                                                                                 (18, 8, 18000, 16000, '2023-09-15 17:30:00', 3, 1),
                                                                                                                                 (9, 5, 9000, 7500, '2023-10-20 14:45:00', 1, 3);

/*
INSERT INTO HISTORICO_ESTATUS_PRESTAMOS (DEUDA, FECHA_ACTUALIZACION, ESTATUS_PRESTAMOS_ID, PRESTAMO_ID) VALUES
(8000, '2023-01-10 12:30:00', 1, 1),
(5000, '2023-02-15 09:45:00', 2, 2),
(15000, '2023-03-20 14:15:00', 1, 3),
(12000, '2023-04-25 11:30:00', 3, 4),
(6000, '2023-05-30 10:00:00', 2, 5),
(7500, '2023-06-05 13:15:00', 1, 6),
(4000, '2023-07-10 15:45:00', 3, 7),
(18000, '2023-08-15 17:00:00', 2, 8),
(10000, '2023-09-20 14:30:00', 1, 9),
(3000, '2023-10-25 11:45:00', 3, 10);

 */

INSERT INTO TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID) VALUES
                                                                                                   (500, '2023-01-01 08:30:00', 1, 2, 1),
                                                                                                   (1000, '2023-02-15 10:45:00', 2, 1, 2),
                                                                                                   (1500, '2023-03-20 15:00:00', 3, 1, 3),
                                                                                                   (200, '2023-04-10 12:15:00', 1, 1, 1),
                                                                                                   (1200, '2023-05-05 09:30:00', 2, 1, 2),
                                                                                                   (800, '2023-06-20 11:45:00', 1, 2, 3),
                                                                                                   (2500, '2023-07-15 14:00:00', 2, 1, 1),
                                                                                                   (600, '2023-08-10 16:15:00', 3, 2, 2),
                                                                                                   (1800, '2023-09-25 13:30:00', 3, 1, 3),
                                                                                                   (300, '2023-10-30 10:45:00', 1, 2, 1);

/*
INSERT INTO HISTORICO_ESTATUS_TRANSACCION (FECHA, ESTATUS_TRANSACCION_ID, TRANSACCION_ID) VALUES
('2023-01-15', 1, 1),
('2023-02-28', 2, 2),
('2023-03-10', 3, 3),
('2023-04-05', 1, 4),
('2023-05-20', 2, 5),
('2023-06-15', 3, 6),
('2023-07-30', 1, 7),
('2023-08-25', 2, 8),
('2023-09-10', 3, 9),
('2023-10-15', 1, 10);


INSERT INTO TRANSACCION_ABONO_AHORRO (TRANSACCION_ID, DIAS_ATRASO) VALUES
(1,0),
(2,2),
(3,5),
(4,1),
(5,3);

INSERT INTO TRANSACCION_PAGO_PRESTAMO (TRANSACCION_ID, PRESTAMO_ID) VALUES
(6,1),
(7,2),
(8,3),
(9,4),
(10,5);

 */

