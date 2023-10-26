CREATE TABLE productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(40),
    precio INT,
    stock INT
);

-- Insertar un producto con ID 1
INSERT INTO productos (descripcion, precio, stock) VALUES ('Refresco', 10, 100);

-- Insertar un producto con ID 2
INSERT INTO productos (descripcion, precio, stock) VALUES ('Chocolates', 15, 75);

-- Insertar un producto con ID 3
INSERT INTO productos (descripcion, precio, stock) VALUES ('Cloro', 20, 50);

-- Insertar un producto con ID 4
INSERT INTO productos (descripcion, precio, stock) VALUES ('Paletas', 30, 30);

-- Insertar un producto con ID 5
INSERT INTO productos (descripcion, precio, stock) VALUES ('Chetos', 25, 60);

SELECT * FROM productos;