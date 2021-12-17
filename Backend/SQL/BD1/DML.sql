USE empresa;

INSERT INTO empleados
VALUES
    (14, 'Pablo', 'Presidente', NULL, 'Universidad NUR', null, 50000, '19900423', null, 5);

INSERT INTO departamentos
VALUES(6, 'Diseño Grafico', 14, '20210614');

INSERT INTO empleados
VALUES
    (15, 'Diego', 'El Crack', NULL, 'Plan 3000', null, 20000, '20010908', 14, 6);

INSERT INTO empleados
VALUES
    (16, 'Ngolo', 'Kante', NULL, 'Africa', null, 10000, '20011102', 14, 6);

INSERT INTO empleados
VALUES
    (17, 'Kyliam', 'Mbappe', NULL, 'Francia', null, 40000, '19951102', null, 6);

INSERT INTO departamentos
VALUES(7, 'Administracion', 17, '20210614');

INSERT INTO empleados
VALUES
    (18, 'Paul', 'Pogba', NULL, 'Francia', null, 30000, '20051106', 17, 7);

INSERT INTO empleados
VALUES
    (19, 'Cristiano', 'Ronaldo', NULL, 'Portugal', null, 35000, '19941106', 17, 7);

INSERT INTO empleados
VALUES
    (20, 'Lionel', 'Messi', NULL, 'Argentina', null, 20000, '19941102', null, 7);

INSERT INTO departamentos
VALUES(8, 'Finanzas', 20, '20210614');

INSERT INTO empleados
VALUES
    (21, 'Juanito', 'Perez', NULL, 'Bolivia', null, 1000, '19901102', 20, 8);

INSERT INTO empleados
VALUES
    (22, 'Batman', 'Al rescate', NULL, 'Bolivia', null, 2000, '19941102', 20, 8);

INSERT INTO empleados
VALUES
    (23, 'Nose', 'Sin apellido', NULL, 'Bolivia', null, 5000, '19941102', 20, 8);


UPDATE empleados
SET dpto_id = 8
WHERE ci_id = 2;

UPDATE empleados
SET dpto_id = 8
WHERE ci_id = 3;

UPDATE empleados
SET dpto_id = 8
WHERE ci_id = 4;

UPDATE empleados
SET dpto_id = 8
WHERE ci_id = 5;

UPDATE empleados
SET dpto_id = 8
WHERE ci_id = 6;

SELECT *
FROM empleados
WHERE nsalario < 500;

UPDATE empleados
SET supervisor_id = NULL
WHERE supervisor_id = 1 || supervisor_id = 3 || supervisor_id = 9 || supervisor_id = 10; 


UPDATE departamentos
SET admin_id = NULL
WHERE admin_id = 1 || admin_id = 3 || admin_id = 9 || admin_id = 10; 

DELETE FROM familiares
WHERE empleado_id = 1 || empleado_id = 3 || empleado_id = 9 || empleado_id = 10; 

DELETE FROM trabajos
WHERE empleado_id = 1 || empleado_id = 3 || empleado_id = 9 || empleado_id = 10;

DELETE FROM empleados
WHERE nsalario < 500;

UPDATE empleados
SET nsalario = nsalario * 1.2
WHERE supervisor_id IS NOT NULL;

SELECT * 
FROM empleados
WHERE dtNacimiento > 19941231 AND dtNacimiento < 20030101; 





