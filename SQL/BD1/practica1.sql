CREATE DATABASE pedidosYa;
USE pedidosYa;

CREATE TABLE cliente
(
    numeroCliente INT PRIMARY KEY,
    nombreCliente VARCHAR (20) NOT NULL,
    ciudad VARCHAR (20)
);

CREATE TABLE pedido
(
    numeroPedido INT PRIMARY KEY,
    fechaPedido DATE,
    numeroCliente INT,
    totalBruto INT NOT NULL
);

CREATE TABLE producto
(
    numeroProducto INT PRIMARY KEY,
    precioUnitario INT
);

CREATE TABLE lineaPedido
(
    numeroPedido INT,
    numeroProducto INT,
    cantidad INT,
    PRIMARY KEY (numeroPedido, numeroProducto)
);

CREATE TABLE almacen
(
    numeroAlmacen INT PRIMARY KEY,
    numeroPedido int,
    ciudad VARCHAR (20)
);

CREATE TABLE entrega
(
    numeroEntrega INT,
    numeroAlmacen INT,
    fechaSalida DATE,
    PRIMARY KEY (numeroEntrega, numeroAlmacen)
);

ALTER TABLE pedido ADD FOREIGN KEY (numeroCliente) REFERENCES cliente (numeroCliente);
ALTER TABLE lineaPedido ADD FOREIGN KEY (numeroPedido) REFERENCES pedido (numeroPedido);
ALTER TABLE lineaPedido ADD FOREIGN KEY (numeroProducto) REFERENCES producto (numeroProducto);
ALTER TABLE almacen ADD FOREIGN KEY (numeroPedido) REFERENCES pedido (numeroPedido);
ALTER TABLE entrega ADD FOREIGN KEY (numeroAlmacen) REFERENCES almacen (numeroAlmacen);
-- TOTAL
INSERT INTO cliente
VALUES
    (1, 'Enrique', 'Madrid');
INSERT INTO cliente
VALUES
    (2, 'Maradona', 'Buenos Aires');
INSERT INTO cliente
VALUES
    (3, 'Lourdes', 'Cuchila');
INSERT INTO cliente
VALUES
    (4, 'Trump', 'New York');
INSERT INTO cliente
VALUES
    (5, 'Lisa', 'Springfield');
-- PARCIAL
INSERT INTO pedido
    (numeroPedido, fechaPedido, numeroCliente, totalBruto)
VALUES
    (10, '2021-04-4', 5, 100);
INSERT INTO pedido
    (numeroPedido, fechaPedido, numeroCliente, totalBruto)
VALUES
    (20, '2021-05-4', 3, 300);
INSERT INTO pedido
    (numeroPedido, fechaPedido, numeroCliente, totalBruto)
VALUES
    (50, '2021-06-4', 2, 40);
INSERT INTO pedido
    (numeroPedido, fechaPedido, numeroCliente, totalBruto)
VALUES
    (40, '2021-07-4', 1, 180);
INSERT INTO pedido
    (numeroPedido, fechaPedido, numeroCliente, totalBruto)
VALUES
    (30, '2021-08-4', 4, 520);

UPDATE pedido
SET totalBruto = ((totalBruto * 3) / 100) + totalBruto 
WHERE totalBruto <= 200;