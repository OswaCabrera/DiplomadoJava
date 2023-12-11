use basedgtic;
DROP TABLE IF EXISTS propietarios;
DROP TABLE IF EXISTS automoviles;

CREATE TABLE automoviles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    anio INT,
    matricula VARCHAR(20)
);


CREATE TABLE propietarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    direccion VARCHAR(100),
    telefono VARCHAR(20),
    email VARCHAR(50),
    automovil_id INT,
    FOREIGN KEY (automovil_id) REFERENCES automoviles(id)
);

SELECT 
* from automoviles;
SELECT* from propietarios;
