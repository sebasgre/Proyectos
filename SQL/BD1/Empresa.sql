CREATE DATABASE empresa; USE empresa;

CREATE TABLE empleados ( ci_id INT NOT NULL PRIMARY KEY, snombre VARCHAR(30) NOT NULL, sappaterno VARCHAR(30) NOT NULL, sapmaterno VARCHAR(30), sdireccion VARCHAR(150) NOT NULL, stelefono VARCHAR(10), nsalario NUMERIC(10, 2) NOT NULL, dtNacimiento DATE NOT NULL, supervisor_id INT, dpto_id INT NOT NULL );

CREATE TABLE departamentos ( numero_id INT NOT NULL PRIMARY KEY, snombre VARCHAR(30) NOT NULL, admin_id INT NULL, dtInicio DATE NULL );

CREATE TABLE dpto_ubicaciones ( dpto_id INT NOT NULL, subicacion VARCHAR(40) NOT NULL, PRIMARY KEY (dpto_id, subicacion) );

CREATE TABLE trabajos ( empleado_id INT NOT NULL, proyecto_id INT NOT NULL, ihoras INT NOT NULL, PRIMARY KEY(empleado_id, proyecto_id) );

CREATE TABLE proyectos ( numero_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, snombre VARCHAR (45), subicacion VARCHAR (45), dpto_id INT, FOREIGN KEY (dpto_id) REFERENCES departamentos (numero_id) );

CREATE TABLE familiares ( empleado_id INT NOT NULL, snombre varchar(50) not null, csexo char(1) not null, srelacion varchar(15) not null, PRIMARY KEY(empleado_id, snombre) );
--

INSERT TOTAL

INSERT INTO departamentos VALUES(1, 'Sistemas', 1, '20150307');

INSERT INTO departamentos VALUES(2, 'Contabilidad', 12, '20150207');

INSERT INTO departamentos VALUES(3, 'Marketing', 5, '20150517');

INSERT INTO departamentos VALUES(4, 'Gerencia', 3, '20150627');

INSERT INTO departamentos VALUES(5, 'Operaciones', 8, '20160101');

INSERT INTO dpto_ubicaciones VALUES(1, 'La Paz');

INSERT INTO dpto_ubicaciones VALUES(2, 'La Paz');

INSERT INTO dpto_ubicaciones VALUES(3, 'La Paz');

INSERT INTO dpto_ubicaciones VALUES(1, 'Santa Cruz');

INSERT INTO dpto_ubicaciones VALUES(2, 'Santa Cruz');

INSERT INTO dpto_ubicaciones VALUES(5, 'Santa Cruz');

INSERT INTO dpto_ubicaciones VALUES(4, 'Cochabamba');

INSERT INTO dpto_ubicaciones VALUES(3, 'Cochabamba');

INSERT INTO empleados VALUES (1, 'Juan', 'Perez', NULL, 'Universidad NUR', null, 150.12, '19850115', null, 1);

INSERT INTO empleados VALUES (2, 'Ana', 'Mendez', NULL, 'Universidad NUR', null, 950.26, '19891115', 1, 2);

INSERT INTO empleados VALUES (3, 'Pedro', 'Moreno', NULL, 'Av. Cristo', null, 15.15, '19921015', 1, 3);

INSERT INTO empleados VALUES (4, 'Luisa', 'Lannister', NULL, '2do Anillo', null, 3500.2, '19950718', 2, 4);

INSERT INTO empleados VALUES (5, 'Ana', 'Cadima', NULL, 'Av. Beni', null, 3430.2, '19980804', null, 5);

INSERT INTO empleados VALUES (6, 'Andrea', 'Paz', NULL, '3er Anillo', null, 2100.0, '19920202', 3, 4);

INSERT INTO empleados VALUES (7, 'Gabriel', 'Gusman', NULL, '4to Anillo', null, 6400.22, '19900511', null, 4);

INSERT INTO empleados VALUES (8, 'Beatriz', 'Lopez', NULL, 'Universidad NUR', null, 2100.7, '19890420', 5, 3);

INSERT INTO empleados VALUES (9, 'David', 'Justiniano', NULL, 'Universidad NUR', null, 200, '19860309', 5, 2);

INSERT INTO empleados VALUES (10, 'Marcelo', 'Martinez', NULL, 'Universidad NUR', null, 385, '19940317', 8, 1);

INSERT INTO empleados VALUES (11, 'Alberto', 'Aguilar', NULL, 'Universidad NUR', null, 499, '19960904', 9, 1);

INSERT INTO empleados VALUES (12, 'Luis', 'Landivar', NULL, 'Universidad NUR', null, 1503.5, '19921122', null, 5);
--

INSERT PARCIAL

INSERT INTO empleados (ci_id, snombre, sappaterno, nsalario, dpto_id, sdireccion, dtNacimiento) VALUES (13, 'Pedro', 'Roca', 1542, 1, 'Centro', '19920824');

INSERT INTO proyectos VALUES (DEFAULT, 'Arboles', 'dpto sist', 4);

INSERT INTO proyectos VALUES (DEFAULT, 'Sockets', 'dpto sist', 4);

INSERT INTO proyectos VALUES (DEFAULT, 'Mandelbrot', 'dpto sist', 4);

INSERT INTO proyectos VALUES (DEFAULT, 'Recursividad', 'dpto sist', 4);

INSERT INTO proyectos VALUES (DEFAULT, 'Slideshow', 'dpto sist', 4);

INSERT INTO proyectos VALUES (DEFAULT, 'Expresiones Regulares', 'dpto sist', 4);

INSERT INTO proyectos VALUES (DEFAULT, 'Arboles-Link', 'dpto sist', 4);

INSERT INTO proyectos VALUES (DEFAULT, 'Reloj', 'dpto sist', 4);

INSERT INTO proyectos VALUES (DEFAULT, 'Calculadora', 'dpto sist', 4);

INSERT INTO proyectos VALUES (DEFAULT, 'Laberinto', 'dpto sist', 4);

INSERT INTO trabajos VALUES (1, 1, 21);

INSERT INTO trabajos VALUES (2, 2, 14);

INSERT INTO trabajos VALUES (3, 3, 22);

INSERT INTO trabajos VALUES (1, 4, 20);

INSERT INTO trabajos VALUES (5, 5, 24);

INSERT INTO trabajos VALUES (1, 5, 15);

INSERT INTO trabajos VALUES (4, 1, 17);

INSERT INTO trabajos VALUES (5, 4, 18);

INSERT INTO trabajos VALUES (8, 7, 7);

INSERT INTO trabajos VALUES (2, 8, 6);

INSERT INTO trabajos VALUES (6, 5, 12);

INSERT INTO trabajos VALUES (7, 9, 21);

INSERT INTO trabajos VALUES (8, 1, 26);

INSERT INTO trabajos VALUES (9, 2, 25);

INSERT INTO trabajos VALUES (10, 1, 20);

INSERT INTO familiares VALUES (1, 'Juan Lopez Quiroz', 'F', 'hijo');

INSERT INTO familiares VALUES (2, 'Luz Perez aldunater', 'M', 'hijo');

INSERT INTO familiares VALUES (2, 'Lucio Perez aldunater', 'M', 'hijo');

INSERT INTO familiares VALUES (3, 'Maria Dias Ponce', 'F', 'hijo');

INSERT INTO familiares VALUES (4, 'Pablo Perez Soliz', 'M', 'hijo');

INSERT INTO familiares VALUES (5, 'Erick Perez Etcheverry', 'M', 'hijo');
-- AGREGAR LLAVES FORANEAS A TRAVES DE ALTER ALTER TABLE departamentos ADD FOREIGN KEY (admin_id) REFERENCES empleados(ci_id); ALTER TABLE empleados ADD FOREIGN KEY (dpto_id) REFERENCES departamentos(numero_id); ALTER TABLE empleados ADD FOREIGN KEY (supervisor_id) REFERENCES empleados(ci_id); ALTER TABLE trabajos ADD FOREIGN KEY (empleado_id) REFERENCES empleados(ci_id); ALTER TABLE trabajos ADD FOREIGN KEY (proyecto_id) REFERENCES proyectos(numero_id); ALTER TABLE familiares ADD FOREIGN KEY (empleado_id) REFERENCES empleados(ci_id);
-- AGREGAR UNA COLUMNA A empleados
-- ALTER TABLE empleados ADD COLUMN scorreo varchar（70）; UPDATE empleados

SET nsalario = nsalario + (nsalario * (20 / 100))
WHERE dpto_id = 1; UPDATE departamentos 

SET admin_id = 9, dtInicio = NOW()
WHERE numero_id = 5; 

INSERT INTO proyectos VALUES (DEFAULT, 'Ciencia', 'dpto operaciones', 5); UPDATE trabajos

SET ihoras = 20
WHERE proyecto_id = 5;  