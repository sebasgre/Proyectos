
CREATE TABLE empleados
(
	ci_id INT NOT NULL PRIMARY KEY,
	snombre VARCHAR(30) NOT NULL,
	sappaterno VARCHAR(30) NOT NULL,
	sapmaterno VARCHAR(30),
	sdireccion VARCHAR(150) NOT NULL,
	stelefono VARCHAR(10),
	nsalario NUMERIC(10,2) NOT NULL,
	dtNacimiento DATE NOT NULL,
	supervisor_id INT,
    dpto_id INT NOT NULL
);

CREATE TABLE departamentos
(
	numero_id INT NOT NULL PRIMARY KEY,
	nombre VARCHAR(30) NOT NULL,
	admin_id INT NULL,
	dtInicio DATE NULL
);

CREATE TABLE dpto_ubicaciones
(
	dpto_id	 INT NOT NULL,
	subicacion VARCHAR NOT NULL,
	PRIMARY KEY (dpto_id,subicacion)
);

CREATE TABLE trabajos
(
	empleado_id INT NOT NULL,
	proyecto_id INT NOT NULL,
	ihoras INT NOT NULL,
	PRIMARY KEY(empleado_id,proyecto_id)			-- PRIMARY KEY MULTIPLE
);

CREATE TABLE proyectos
(
	numero_id SERIAL NOT NULL PRIMARY KEY,
	nombre VARCHAR(45),
	ubicacion VARCHAR(45),
	dpto_id INT,
	FOREIGN KEY (dpto_id) REFERENCES departamentos(numero_id)		-- LLAVE FORANEA DIRECTA
);

CREATE TABLE familiares
(
  empleado_id INT NOT NULL,
  snombre varchar(50) not null,
  csexo char(1) not null,
  srelacion varchar(15) not null,
  PRIMARY KEY(empleado_id,snombre)
);

-- INSERT TOTAL
INSERT INTO departamentos VALUES(1,'Sistemas',1,'20150307');
INSERT INTO departamentos VALUES(2,'Contabilidad',12,'20150207');
INSERT INTO departamentos VALUES(3,'Marketing',5,'20150517');
INSERT INTO departamentos VALUES(4,'Gerencia',3,'20150627');
INSERT INTO departamentos VALUES(5,'Operaciones',4,'20160101');

INSERT INTO dpto_ubicaciones VALUES(1,'La Paz');
INSERT INTO dpto_ubicaciones VALUES(2,'La Paz');
INSERT INTO dpto_ubicaciones VALUES(3,'La Paz');
INSERT INTO dpto_ubicaciones VALUES(1,'Santa Cruz');
INSERT INTO dpto_ubicaciones VALUES(2,'Santa Cruz');
INSERT INTO dpto_ubicaciones VALUES(5,'Santa Cruz');
INSERT INTO dpto_ubicaciones VALUES(4,'Cochabamba');
INSERT INTO dpto_ubicaciones VALUES(3,'Cochabamba');

INSERT INTO empleados VALUES (1,'Juan','Perez',NULL,'Universidad NUR',null,'19850115',150.12,'M',null,1);
INSERT INTO empleados VALUES (2,'Ana','Mendez',NULL,'Universidad NUR',null,'19891115',950.26,'M',1,1);
INSERT INTO empleados VALUES (3,'Pedro','Moreno',NULL,'Av. Cristo',null,'19921015',15.15,'M',1,3);
INSERT INTO empleados VALUES (4,'Luisa','Lannister',NULL,'2do Anillo',null,'19950718',3500.2,'M',2,4);
INSERT INTO empleados VALUES (5,'Ana','Cadima',NULL,'Av. Beni',null,'19980804',3430.2,'M',null,5);
INSERT INTO empleados VALUES (6,'Andrea','Paz',NULL,'3er Anillo',null,'19920202',2100.0,'M',3,4);
INSERT INTO empleados VALUES (7,'Gabriel','Gusman',NULL,'4to Anillo',null,'19900511',6400.22,'M',null,4);
INSERT INTO empleados VALUES (8,'Beatriz','Lopez',NULL,'Universidad NUR',null,'19890420',2100.7,'M',5,3);
INSERT INTO empleados VALUES (9,'David','Justiniano',NULL,'Universidad NUR',null,'19860309',1840.12,'M',4,2);
INSERT INTO empleados VALUES (10,'Marcelo','Martinez',NULL,'Universidad NUR',null,'19940317',720.9,'M',5,1);
INSERT INTO empleados VALUES (11,'Alberto','Aguilar',NULL,'Universidad NUR',null,'19960904',500.4,'M',5,1);
INSERT INTO empleados VALUES (12,'Luis','Landivar',NULL,'Universidad NUR',null,'19921122',1503.5,'M',null,5);


INSERT INTO proyectos VALUES (1, 'Arboles','dpto sist', 1);
INSERT INTO proyectos VALUES (2, 'Sockets','dpto sist', 1);
INSERT INTO proyectos VALUES (3, 'Mandelbrot','dpto sist', 1);
INSERT INTO proyectos VALUES (4, 'Recursividad','dpto sist', 1);
INSERT INTO proyectos VALUES (5, 'Slideshow','dpto sist', 1);

INSERT INTO proyectos VALUES (6, 'Expresiones Regulares','dpto sist', 1);
INSERT INTO proyectos VALUES (7, 'Arboles-Link','dpto sist', 1);
INSERT INTO proyectos VALUES (8, 'Reloj','dpto sist', 1);
INSERT INTO proyectos VALUES (9, 'Calculadora','dpto sist', 1);
INSERT INTO proyectos VALUES (10, 'Laberinto','dpto sist', 1);

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

INSERT INTO familiares VALUES (1, 'Juan Lopez Quiroz', '19850425','hijo');
INSERT INTO familiares VALUES (2, 'Luz Perez aldunater', '19860621','hijo');
INSERT INTO familiares VALUES (2, 'Lucio Perez aldunater', '19991224','hijo');
INSERT INTO familiares VALUES (3, 'Maria Dias Ponce', '20010822','hijo');
INSERT INTO familiares VALUES (4, 'Pablo Perez Soliz', '20020408','hijo');
INSERT INTO familiares VALUES (5, 'Erick Perez Etcheverry', '199960910','hijo');

select * from empleados;
select * from departamentos;
select * from dpto_ubicaciones;
select * from proyectos;
select * from trabajos;
select * from familiares;
-- 1 Obtener el total de proyectos y horas trabajadas en las
-- que participa cada empleado.
select concat(e.nombre,' ', e.appatrno) as nombre, count(t.proyecto_id) as proyecto, sum(t.horas) as horas 
from empleados e
join trabajos t on t.empleado_id = e.ci_id
group by e.ci_id
order by e.nombre asc;
-- 2 Obtener todos los proyectos controlados por departamentos
-- que tienen mas de dos ubicaciones
select p.numero_id, p.nombre, du.dpto_id as departamento, count(du.dpto_id) as ubicaciones
from proyectos p 
join dpto_ubicaciones du on p.dpto_id = du.dpto_id
group by p.numero_id, du.dpto_id
HAVING count(du.dpto_id) > 1; 
-- 3 Obtener la lista de empleados que nacieron en el mes de marzo
select *
from empleados 
where extract (month from dtNacimiento) = 3;
-- 4 Obtener todos los departamentos que tienen un costo mayor
-- al promedio de todos los departamentos
SELECT d.numero_id, d.nombre, sum(e.salario) as costo
FROM departamentos d
JOIN empleados e ON d.numero_id = e.dpto_id
GROUP BY d.numero_id
HAVING sum(e.salario) > (SELECT avg(X.costo)
                            FROM (SELECT sum(e.salario) as costo
                                    FROM departamentos d
                                    JOIN empleados e ON d.numero_id = e.dpto_id
                                    GROUP BY d.numero_id) as X);
-- 5 Mostrar todos los administradores que no participan
-- en un proyecto
select e.ci_id, e.nombre 
from empleados e
join departamentos d on e.ci_id = d.admin_id
left join trabajos t on e.ci_id = t.empleado_id
where t.empleado_id is null;


