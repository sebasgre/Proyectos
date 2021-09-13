select A.ci_id,B.ci_id from empleados A
 join remotob.empleados B ON A.ci_id=B.ci_id
 
 
 1. REALIZAR UNA CONSULTA QUE OBTENGA EL TOTAL DE EMPLEADOS POR BASE DE DATOS CON EL SIGUIENTE FORMATO

    +------------+----------------------------+
    |    DBMS    |       TOTAL EMPLEADOS      |
    +------------+----------------------------+
    | SERVER A(1)|              13            |
    +------------+----------------------------+
    | SERVER B(2)|              22            |
    +------------+----------------------------+
    | SERVER C(3)|              16            |
    +------------+----------------------------+
	
	SELECT 'Server A(1)' AS "DBMS",COUNT(*) AS "TOTAL EMPLEADOS" FROM empleados
	UNION
	SELECT 'Server B(2)',COUNT(*) FROM remotob.empleados
	UNION
	SELECT 'Server C(3)',COUNT(*) FROM remotoc.empleados order by 1 asc

-- 2. OBTENER LA LISTA DE TODOS LOS EMPLEADOS DE TODAS LAS BASES DE DATOS, SIN REPETIR EL REGISTRO DE EMPLEADOS
 SELECT ci_id, snombre, sappaterno, sapmaterno
 FROM empleados
 UNION 
 SELECT ci_id, snombre, sappaterno, sapmaterno FROM remotob.empleados
 UNION 
 SELECT ci_id, snombre, sappaterno, sapmaterno FROM remotoc.empleados order by 1 asc
 
 
 --JOIN
 --1) Obtienes todos los empleados que existen en A y B
	SELECT * FROM empleados A JOIN remotob.empleados B ON A.ci_id=B.ci_id
 
 --2)
 SELECT * FROM empleados A JOIN remotob.empleados B USING (ci_id)
 
 --3) disyuncion o solapamiento
 
 
 
 --1) Obtener todos los empleados que existen en A,B y C
 SELECT * FROM empleados re
	JOIN remotob.empleados r2e on re.ci_id = r2e.ci_id
	JOIN remotoc.empleados r3e on r2e.ci_id =r3e.ci_id
	where re.ci_id

SELECT ci_id, nombre, appaterno
 FROM empresa1.empleados
 INTERSECT 
 SELECT ci_id, nombre, appaterno FROM empresa2.empleados
 INTERSECT
 SELECT ci_id, nombre, appaterno FROM empresa3.empleados order by 1 asc
 
 --2) Obtener los empleados que son diferentes en A,B y C
 EXPLAIN ANASELECT ci_id, snombre, sappaterno
 FROM empleados
 EXCEPT 
 SELECT ci_id, snombre, sappaterno FROM remotob.empleados
 EXCEPT
 SELECT ci_id, snombre, sappaterno FROM remotoc.empleados order by 1 asc
 
 --3) Obtener todos los empleados que existen solo en A
 
explain analyze SELECT *
FROM empleados a
LEFT JOIN remotob.empleados b USING (ci_id)
LEFT JOIN remotoc.empleados c USING (ci_id)
WHERE b.ci_id IS NULL AND c.ci_id IS NULL;

explain analyze select *
from empleados e1
where e1.ci_id not in (select ci_id from remotob.empleados)
and e1.ci_id not in (select ci_id from remotoc.empleados);
 
explain analyze select *
from empleados e1
where e1.ci_id not in (select ci_id from remotob.empleados UNION select ci_id from remotoc.empleados); 
 
 
 
 -- A - 564
 -- B - 751
 -- C - 506
 
 -- R - 1821