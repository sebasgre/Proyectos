-- 1) OBTENER EL TOTAL DE HORAS TRABAJADAS DE CADA EMPLEADO EN PROYECTOS
-- 2) SE PLANTEA PAGAR COMO BONO ADICIONAL AL SALARIO LAS HORAS TRABAJADAS EN CADA PROYECTO, SI LA HORA TIENE UN COSTO DE 57 Bs.
--    DISEÑAR UNA CONSULTA QUE DETERMINE CUANTO SE DEBERÁ PAGAR EN BONOS A LOS EMPLEADOS, Y UNA CONSULTA QUE MUESTRE LA PLANILLA 
--    DE SUELDOS INCLUYENDO EN EL SALARIO BASE EL BONO DE HORAS DE PROYECTODE
use empresa;
--1.)
SELECT CONCAT(e.snombre, ' ', e.sappaterno) as Empleado,
    sum(t.ihoras)
FROM empleados e
    JOIN trabajos t ON e.ci_id = t.empleado_id
GROUP BY e.ci_id;
--2.) 
SELECT CONCAT(e.snombre, ' ', e.sappaterno) as Empleado,
    (sum(t.ihoras) * 57) as Horas
FROM empleados e
    JOIN trabajos t ON e.ci_id = t.empleado_id
GROUP BY e.ci_id;
SELECT CONCAT(e.snombre, ' ', e.sappaterno) as Empleado,
    (e.nsalario + COALESCE(sum(t.ihoras) * 57, 0)) as Salario
FROM empleados e
    JOIN trabajos t ON e.ci_id = t.empleado_id
GROUP BY e.ci_id;