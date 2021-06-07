--- SQL
-- DDL -> Lenguaje de Definicion de Datos
-- Crear DB
-- CREATE DATABASE empresa;

-- Mostrar todas las DB's disponibles
SHOW DATABASES;

-- Eliminar una DB
DROP DATABASE empresa;

-- Utilizar o seleccionar una DB
USE empresa;

-- mostrar todas las tablas de la DB seleccionada
SHOW TABLES;


-- ver detalle de una tabla
DESC empleados;

-- crear una tabla
CREATE TABLE empleados (
    ci_id INT, 
    nombre VARCHAR(20) NOT NULL, 
    appaterno VARCHAR(30) NOT NULL,
    apmaterno VARCHAR(30),
    dtnacimiento DATE NOT NULL,
    salario NUMERIC(8,2) NOT NULL,
    direccion VARCHAR(150),
    sexo VARCHAR(1),
    dpto_id INT,
    supervisor_id INT,
    PRIMARY KEY(ci_id)
    );

CREATE TABLE departamentos(
    numero_id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(20) NOT NULL UNIQUE,
    admin_id INT,
    dtInicio DATE
);

CREATE TABLE dpto_ubicaciones(
    dpto_id INT,
    ubicacion VARCHAR(50),
    PRIMARY KEY (dpto_id, ubicacion)
);

-- Modificar la estructura de una tabla
-- ALTER
ALTER TABLE dpto_ubicaciones 
ADD PRIMARY KEY(dpto_id, ubicacion);

-- AGREGAR LLAVES FORANEAS
ALTER TABLE dpto_ubicaciones
ADD FOREIGN KEY (dpto_id) REFERENCES departamentos(numero_id);

ALTER TABLE empleados
ADD FOREIGN KEY (supervisor_id) REFERENCES empleados(ci_id);

-- FIN DDL

-- DML --> Lenguaje de Manipulacion de Datos
-- Insertar datos en una tabla
-- total
INSERT INTO empleados VALUES(1,'Juan','Perez','Perez','1990-05-22',1500, 'Av. Banzer 2do anillo','M',null,null);

--parcial
INSERT INTO empleados(appaterno,nombre,ci_id,salario,dtnacimiento) VALUES('Mendez','Luis',2,2000.52,'1998-09-04');
INSERT INTO empleados(ci_id) VALUES (3);

--Actualizar los datos
-- UPDATE
UPDATE departamentos SET admin_id = 2, dtInicio = now() WHERE numero_id = 1;

-- Eliminar datos
-- DELETE
DELETE FROM dpto_ubicaciones;
SELECT * FROM departamentos WHERE numero_id > 99;

-- VER LOS DATOS DE UNA TABLA
-- SELECT
SELECT * FROM empleados;

-- CONSULTAS SQL

-- SELECT -- columnas 
-- FROM -- tabla(s)
-- WHERE  -- filas

-- ver el salario de empleados
SELECT ci_id, snombre, sappaterno, nsalario
FROM empleados
WHERE dpto_id = 1;

-- Ordenar los resultados agregamos ORDER BY nombre [ASC | DESC]

SELECT ci_id, snombre, sappaterno, nsalario
FROM empleados
WHERE dpto_id = 1
ORDER BY nsalario DESC;


-- ver el salario de empleados de Sistemas mayor a 1000 Bs.
SELECT ci_id, snombre, sappaterno, nsalario, dpto_id
FROM empleados
WHERE dpto_id = 4 OR (nsalario > 1000 AND nsalario < 2000);


-- UPDATE - Aumentar un 20% al salario de todos los empleados que son controlados por algun supervisor
UPDATE empleados
SET nsalario = nsalario + (nsalario  * 0.2) 
WHERE supervisor_id IS NOT NULL;

-- VISUALIZAR EL INCREMENTO DEL 20% - RENOMBRAR COLUMNAS
SELECT ci_id, snombre, sappaterno, nsalario, (nsalario * 0.2) AS incremento ,nsalario * 1.2 AS total
FROM empleados
WHERE supervisor_id IS NOT NULL;


-- SQL - Obtener todos los empleados nacidos entre 1995 y 2002
select ci_id, snombre, sappaterno, dtNacimiento
 from empleados
 where dtNacimiento >= '1995-01-01' and dtNacimiento < '2003-01-01';

select ci_id, snombre, sappaterno, dtNacimiento
 from empleados
 where dtNacimiento BETWEEN '1995-01-01' AND '2003-01-01';


-- LIKE -- BUSCAR FRAGMENTOS EN TEXTO
SELECT * FROM empleados WHERE sappaterno LIKE 'A%';
SELECT * FROM empleados WHERE sappaterno LIKE '%A%';
SELECT * FROM empleados WHERE sappaterno NOT LIKE '%A%';


-- COMBINACION DE TABLAS
-- 1) Producto cartesiano
SELECT empleados.ci_id, empleados.snombre, empleados.dpto_id, departamentos.numero_id ,departamentos.snombre
FROM empleados, departamentos
WHERE empleados.dpto_id = departamentos.numero_id;

SELECT E.ci_id, E.snombre, E.dpto_id, D.numero_id ,D.snombre
FROM empleados E, departamentos D
WHERE E.dpto_id = D.numero_id;

SELECT E.ci_id, E.snombre, E.dpto_id, D.numero_id ,D.snombre
FROM empleados E JOIN departamentos D ON E.dpto_id = D.numero_id;

-- Obtener todos los empleados que pertenecen al departamento de 'Sistemas'
SELECT E.ci_id, E.snombre, E.dpto_id, D.numero_id ,D.snombre
FROM empleados E, departamentos D
WHERE E.dpto_id = D.numero_id AND D.snombre = 'sistemas';

SELECT E.ci_id, E.snombre, E.dpto_id, D.numero_id ,D.snombre
FROM empleados E JOIN departamentos D ON E.dpto_id = D.numero_id
WHERE D.snombre = 'Sistemas';