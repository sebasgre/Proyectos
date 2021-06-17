USE empresa;
-- OBTENER TODOS LOS EMPLEADOS NACIDOS ENTRE 1990 y 1992
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