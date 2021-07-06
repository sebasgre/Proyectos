-- Comentarios
-- Mostrar informacion -- SHOW (MySQL)
SHOW DATABASES;
SHOW TABLES;
-- crear una DB
CREATE DATABASE nombre_db;
-- eliminar una DB
DROP DATABASE nombre_db;
-- acceder a una DB
USE nombre_db;
-- crear una tabla
CREATE TABLE empleados(
	ci_id INT PRIMARY KEY,
	nombre VARCHAR(20) NOT NULL,
	appaterno VARCHAR(30) NOT NULL,
	apmaterno VARCHAR(30),
	dtNaciemiento DATE NOT NULL,
	salario DECIMAL(8, 2),
	direccion VARCHAR(200),
	sexo CHAR(1) NOT NULL,
	dpto_id INT,
	supervisor_ID INT
);
CREATE TABLE departamentos(
	numero_id INT PRIMARY KEY,
	nombre VARCHAR(45) NOT NULL,
	admin_id INT,
	fecha_inicial DATE NOT NULL,
	FOREIGN KEY(admin_id) REFERENCES empleados(ci_id)
);
CREATE TABLE departamentos_ubicaciones(
	dpto_id INT,
	ubicacion VARCHAR(45),
	PRIMARY KEY(dpto_id, ubicacion)
);
CREATE TABLE proyectos(
	numero INT PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(45) NOT NULL,
	ubicacion VARCHAR(45),
	dpto_id INT
);
CREATE TABLE trabajos(
	empleado_id INT,
	proyecto_id INT,
	horas INT NOT NULL
);
CREATE TABLE familiares(
	empleado_id INT,
	nombre VARCHAR(45),
	dtNacimiento DATE,
	parentesco VARCHAR(20),
	PRIMARY KEY(empleado_id, nombre)
);
-- ver detalles de tabla
DESC nombre_tabla;
-- modificar una estructura ALTER
-- agregar una llave primaria
ALTER TABLE trabajos
ADD PRIMARY KEY(empleado_id, proyecto_id);
-- eliminar una llave primaria
ALTER TABLE departamento_ubicaciones DROP PRIMARY KEY;
--modificar columna
ALTER TABLE departamentos
MODIFY admin_id int null;
--eliminar una table 
DROP TABLE nombre_tabla;
-- aggregar llaves foraneas 
ALTER TABLE empleados
ADD FOREIGN KEY(dpto_id) REFERENCES departamentos(numero_id);
--show data
SELECT *
from departamentos;
--insertar datos
--total
INSERT INTO departamentos
VALUES (1, 'Sistemas', null, null);
--parcial
INSERT INTO departamentos(nombre, numero_id)
VALUES ("Gerencia", 2);
INSERT INTO empleados (
		ci_id,
		nombre,
		appaterno,
		direccion,
		salario,
		dtNaciemiento,
		dpto_id
	)
VALUES(
		1,
		'Juan',
		'Perez',
		'Av. Banzer, 2do anillo',
		1500.50,
		'1992-05-13',
		1
	);
--5 empleados y 5 dptos
--2 insert totales
--3 insert parciales
INSERT INTO departamentos(nombre, numero_id)
VALUES ("Obama", 3);
INSERT INTO empleados
VALUES (
		2,
		'Billy',
		'Bob',
		'Stevenson',
		'1998-03-22',
		1680.20,
		'1234 Burger St.',
		null,
		3,
		null
	);
INSERT INTO departamentos
VALUES(4, 'EquisDe', null, null);
INSERT INTO empleados(
		ci_id,
		nombre,
		appaterno,
		direccion,
		salario,
		dtNaciemiento,
		dpto_id
	)
VALUES (
		3,
		'Marcelo',
		'Agachate',
		'Av. Conocelo',
		6900.69,
		'1969-04-20',
		4
	);
INSERT INTO departamentos(nombre, numero_id)
VALUES("Quinto", 5);
INSERT INTO empleados(
		ci_id,
		nombre,
		appaterno,
		direccion,
		salario,
		dtNaciemiento,
		dpto_id
	)
VALUES (
		4,
		'Rodrigo',
		'ogirdoR',
		'Av. Avenida',
		1200.45,
		'1975-08-12',
		1
	);
INSERT INTO empleados(
		ci_id,
		nombre,
		appaterno,
		direccion,
		salario,
		dtNaciemiento,
		dpto_id
	)
VALUES (
		5,
		'Beter',
		'Grimfin',
		'Av. FamyGuy',
		100.00,
		'1999-09-09',
		5
	);
--Actualizar datos - UPDATE 
--DONT FORGET WHERE
UPDATE departamentos
SET nombre = "Baste"
WHERE numero_id = 5;
UPDATE empleados
SET apmaterno = "OwO"
WHERE ci_id = 4
	AND nombre = "Rodrigo";
--comando updata para actualizar a todo el personal
--que tengo menos de un salario minimo (2100)
--con 5 veces el sueldo que tengan
UPDATE empleados
SET salario = salario * 5
WHERE salario < 2100;
-- SHOW EXACT TIME XD
SELECT NOW();
-- SET time to now
UPDATE departamentos
set dtInicio = now();
-- SELECT BEFORE DELETE TO KNOW WHAT YOU ARE GOING TO DELETE
-- UNDO 
rollback();
SELECT *
FROM empleados
WHERE dtNacimiento >= '1990-01-01'
	AND dtNacimiento < '1993-01-01';
SELECT *
FROM empleados
WHERE dtNacimiento BETWEEN '1990-01-01' AND '1993-01-01';
SELECT ci_id,
	CONCAT(snombre, ' ', sappaterno) as empleado,
	dtNacimiento
FROM empleados
WHERE nsalario > 2100
ORDER BY 3 ASC,
	2 DESC;
-- TODOS LOS EMPLEADOS, ORDENADOS POR NOMBRE DE MANERA ASCENDENTE, Y SALARIO DESCENDIENTE
- - FILTRAR TEXTO -->LIKE -- wildcards 
-->"%" - -->0...N Caracteres cualquiera -->"_" - -->1 caracter cualquiera
SELECT *
FROM empleados
WHERE snombre LIKE 'A%';
SELECT *
FROM empleados
WHERE snombre LIKE '%A';
SELECT *
FROM empleados
WHERE snombre LIKE '%A%';
-- OBTENER TODOS LOS JEFES QUE VIVEN EN UN ANILLO
SELECT *
FROM EMPLEADOS
where supervisor_id IS NULL
	AND sdireccion like '%Anillo';
-- OBTENER TODOS LOS EMPLEADOS DE SISTEMAS QUE CONTENGAN EN SU APELLIDO LA LETRA 'E'
SELECT *
FROM empleados
WHERE dpto_id = 1
	AND sappaterno LIKE '%E%';
SELECT ci_id,
	e.snombre,
	e.sappaterno,
	e.dpto_id,
	d.numero_id,
	d.snombre
FROM empleados e,
	departamentos d
WHERE e.dpto_id = d.numero_id;
SELECT e.*
FROM empleados e,
	departamentos d
WHERE d.snombre = "Sistemas"
	AND e.dpto_id = d.numero_id;
-- JOIN
SELECT e.*
FROM empleados e
	JOIN departamentos d ON e.dpto_id = d.numero_id
WHERE d.snombre = "Sistemas";
SELECT D.snombre as departamento,
	E.*
FROM EMPLEADOS E
	JOIN departamentos D ON E.dpto_id = D.numero_id
where supervisor_id IS NULL
	AND sdireccion like '%Anillo';
SELECT ci_id,
	CONCAT(E.snombre, ' ', sappaterno) as empleado,
	dtNacimiento,
	D.snombre as departamento
FROM empleados E
	JOIN departamentos D ON E.dpto_id = D.numero_id
WHERE nsalario > 2100
ORDER BY 3 ASC,
	2 DESC;
-- Obtener el nombre de todos los empleados junto al nombre de sus supervisores
SELECT CONCAT(e.snombre, ' ', e.sappaterno) as empleado,
	CONCAT(e2.snombre, ' ', e2.sappaterno) as supervisor
FROM empleados e
	JOIN empleados e2 ON e.supervisor_id = e2.ci_id;
-- Obtener todos los empleados que tienen familiares    
SELECT e.ci_id,
	CONCAT(e.snombre, ' ', e.sappaterno) as empleados,
	e.dtNacimiento,
	f.snombre as familiares
FROM empleados e
	JOIN familiares f ON e.ci_id = f.empleado_id;
-- Obtener todos los empleados de sistemas que tienen familiares
SELECT e.ci_id,
	CONCAT(e.snombre, ' ', e.sappaterno) as empleados,
	e.dtNacimiento,
	f.snombre as familiares
FROM empleados e
	JOIN familiares f ON e.ci_id = f.empleado_id
	JOIN departamentos d on e.dpto_id = d.numero_id
WHERE d.snombre = "Sistemas";
--Obtener todos los empleados que trabajan en contabilidad y participan en algun proyecto
SELECT *
FROM empleados e
	JOIN departamentos d ON e.dpto_id = d.numero_id
	JOIN trabajos t ON e.ci_id = t.empleado_id
	JOIN proyectos p ON p.dpto_id = d.numero_id
WHERE d.snombre = "contabilidad";
-- obtener todos los empleados que no tiene familiares
SELECT *
FROM empleados e
	LEFT JOIN familiares f ON e.ci_id = f.empleado_id
WHERE f.empleado_id IS NULL;
-- Mostras las horas trabajadas de cada empleado en sus proyectos asignados, la consulta debera mostras tres columnas nombre completo del empleado | nombre del proyecto | horas trabajadas
SELECT CONCAT(e.snombre, ' ', e.sappaterno) as Empleado,
	p.snombre as Proyecto,
	t.ihoras as Horas
FROM empleados e
	JOIN trabajos t ON e.ci_id = t.empleado_id
	JOIN proyectos p ON t.proyecto_id = p.numero_id;
-- NOT IN
SELECT *
FROM empleados
WHERE snombre NOT IN ('Pedro', 'David', 'Luis', 'Alberto');
SELECT *
FROM empleados
WHERE ci_id NOT IN (
		SELECT empleado_id
		FROM familiares f
	);
SELECT CONCAT(e.snombre, ' ', e.sappaterno) as Empleado,
	u.subicacion
FROM empleados e
	JOIN dpto_ubicaciones u ON e.dpto_id = u.dpto_id
WHERE u.subicacion = "La Paz";
SELECT *
FROM empleados
WHERE ci_id NOT IN (
		SELECT empleado_id
		FROM trabajos t
	);
select dpto_id,
	count(*)
from empleados
group by dpto_id;
SELECT e.dpto_id,
	d.snombre,
	count(*)
FROM empleados e
	JOIN departamentos d on e.dpto_id = d.numero_id
GROUP BY d.snombre;
select concat (e.snombre, ' ', e.sappaterno) as empleado,
	count(*)
from empleados e
	join trabajos t on e.ci_id = t.empleado_id
GROUP BY e.ci_id
order by 2 DESC;
SELECT d.snombre,
	sum(e.nsalario)
FROM departamentos d
	JOIN empleados e on e.dpto_id = d.numero_id
GROUP BY d.snombre
ORDER BY 2 desc;
select 'familiares' sum(numero_id)
union
select 'sin familiares' -- Obtener todos los empleados que trabajan en mas de 1 proyecto  (de 2 en adelante)
select e.ci_id,
	Concat (e.snombre, ' ', e.sappaterno) as nombre_completo,
	count(t.proyecto_id)
from empleados e
	join trabajos t on t.empleado_id = e.ci_id
GROUP by e.ci_id;
-- FUNCIONES (COUNT, SUM, MAX, MIN, AVG)
-- COUNT
SELECT COUNT(*) FROM empleados;


-- Mostrar el total de empleados por departamento ( formato: nombre_dpto, total_empleados)
SELECT dpto_id, COUNT(*) 
FROM empleados
GROUP BY dpto_id;

SELECT D.snombre as nombre_dpto, COUNT(*) as total_empleados
FROM empleados E LEFT JOIN departamentos D ON E.dpto_id = D.numero_id
GROUP BY D.numero_id;

SELECT COALESCE(D.snombre,'- -ninguno- -') as nombre_dpto, COUNT(*) as total_empleados
FROM empleados E LEFT JOIN departamentos D ON E.dpto_id = D.numero_id
GROUP BY D.numero_id;


-- Obtener el total de sueldos por departamento, el formato debe indicar el codigo del departamento,
-- el nombre de departamento y el total de salarios pagados. 

SELECT D.snombre as departamento, SUM(nsalario)
FROM empleados E JOIN departamentos D ON E.dpto_id=D.numero_id
GROUP BY D.numero_id

SELECT D.snombre, X.total
FROM departamentos D JOIN (
    SELECT dpto_id,SUM(nsalario) as total
    FROM empleados
    GROUP BY dpto_id ) X
ON D.numero_id = X.dpto_id

-- TOTAL DE SUELDOS POR DEPARTAMENTO ENTRE 3000 y 7000 Bs.

SELECT D.snombre as departamento, SUM(nsalario)
FROM empleados E JOIN departamentos D ON E.dpto_id=D.numero_id
GROUP BY D.numero_id
HAVING SUM(nsalario) BETWEEN 3000 AND 7000


SELECT D.snombre, X.total
FROM departamentos D JOIN (
    SELECT dpto_id,SUM(nsalario) as total
    FROM empleados
    GROUP BY dpto_id ) X
ON D.numero_id = X.dpto_id
WHERE X.total > 3000 AND X.total < 7000

-- Obtener el nombre y apellido de cada empleado, e indicar el total de empleados a su cargo.

SELECT CONCAT(S.snombre,' ',S.sappaterno) as supervisor, CONCAT(E.snombre,' ',E.sappaterno) as empleado
FROM empleados S JOIN empleados E ON S.ci_id = E.supervisor_id;

-- Cuenta los registros, incluidos los que no supervisan a nadie
SELECT CONCAT(S.snombre,' ',S.sappaterno) as supervisor, COUNT(*)
FROM empleados S LEFTJOIN empleados E ON S.ci_id = E.supervisor_id
GROUP BY CONCAT(S.snombre,' ',S.sappaterno);

-- Al hacer la funcion COUNT en una columna, si encuentra valores nulos, los contará como 0
SELECT CONCAT(S.snombre,' ',S.sappaterno) as supervisor, COUNT(E.ci_id)
FROM empleados S LEFT JOIN empleados E ON S.ci_id = E.supervisor_id
GROUP BY CONCAT(S.snombre,' ',S.sappaterno);


SELECT CONCAT(S.snombre,' ',S.sappaterno) as supervisor, COUNT(E.ci_id)
FROM empleados S LEFT JOIN empleados E ON S.ci_id = E.supervisor_id
GROUP BY CONCAT(S.snombre,' ',S.sappaterno)
HAVING COUNT(E.ci_id) >= 2;

-- EXCLUIR DATOS --> NOT IN, NOT EXISTS, LEFT|RIGHT JOIN
-- Obtener todos los empleados que trabajan en algun proyecto que NO tienen familiares
-- con las siguientes cabeceras (CI, nombre, apellido, nombre_dpto, nombre_proyecto)

-- NOT IN --> eliminar registros en base a una lista

SELECT * FROM empleados WHERE ci_id NOT IN (2,4,5,7);

-- empleados que no tienen familiares
SELECT * FROM empleados
WHERE ci_id NOT IN (SELECT empleado_id FROM familiares)

select E.ci_id, CONCAT(E.snombre,' ', E.sappaterno) as empleado, P.snombre as proyecto
from empleados E 
Join trabajos T on E.ci_id = T.empleado_id
JOIN proyectos P ON P.numero_id=T.proyecto_id
WHERE E.ci_id NOT IN (SELECT empleado_id FROM familiares);

--EJEMPLO NOT IN
--  -- OBTENER TODOS LOS EMPLEADOS QUE NO TRABAJAN EN UN PROYECTO
SELECT * FROM empleados E
WHERE E.ci_id NOT IN (SELECT empleado_id FROM trabajos);

-- NOT EXISTS
SELECT * FROM empleados E
WHERE NOT EXISTS (SELECT * FROM trabajos WHERE empleado_id=E.ci_id);

-- JOINS
-- INNER JOIN
SELECT E.ci_id, CONCAT(E.snombre,' ',E.sappaterno) as empleado, E.dpto_id, D.numero_id, D.snombre as departamento
FROM empleados E JOIN departamentos D ON E.dpto_id = D.numero_id;

-- LEFT JOIN - RIGHT JOIN
SELECT E.ci_id, CONCAT(E.snombre,' ',E.sappaterno) as empleado, E.dpto_id, D.numero_id, D.snombre as departamento
FROM empleados E LEFT JOIN departamentos D ON E.dpto_id = D.numero_id;

SELECT E.ci_id, CONCAT(E.snombre,' ',E.sappaterno) as empleado, E.dpto_id, D.numero_id, D.snombre as departamento
FROM empleados E LEFT JOIN departamentos D ON E.dpto_id = D.numero_id
WHERE D.numero_id IS NULL;


-- DISTINCT - ELIMINAR DUPLICADOS
SELECT DISTINCT empleado_id FROM trabajos order by 1 asc;

-- FUNCIONES
-- COUNT
SELECT COUNT(*) FROM empleados;


-- Mostrar el total de empleados por departamento ( formato: nombre_dpto, total_empleados)
SELECT dpto_id, COUNT(*) 
FROM empleados
GROUP BY dpto_id;

SELECT D.snombre as nombre_dpto, COUNT(*) as total_empleados
FROM empleados E LEFT JOIN departamentos D ON E.dpto_id = D.numero_id
GROUP BY D.numero_id;

SELECT COALESCE(D.snombre,'- -ninguno- -') as nombre_dpto, COUNT(*) as total_empleados
FROM empleados E LEFT JOIN departamentos D ON E.dpto_id = D.numero_id
GROUP BY D.numero_id;

-- MAX, MIX, AVG

SELECT MAX(nsalario) FROM empleados;
-- Obtener los datos del empleado con el salario máximo

SELECT *
FROM empleados
WHERE nsalario = (SELECT MAX(nsalario) FROM empleados);

-- Saber los empleados que tienen un sueldo mayor al promedio

SELECT *
FROM empleados
WHERE nsalario > (SELECT AVG(nsalario) FROM empleados);
