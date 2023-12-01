use caja_ahorro_bd;

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
