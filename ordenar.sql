USE empresa;
select ci_id,
    CONCAT(snombre, ' ', sappaterno) as empleado,
    nsalario,
    dtNacimiento
from empleados
order by snombre ASC,
    nsalario DESC;
select *
from empleados
where snombre = 'ana';
select *
from empleados
where snombre like '%%a_';
select *
from empleados
where snombre like 'P__ro';
select *
from empleados
where supervisor_id IS NOT NULL AND sdireccion like '%anillo';
select *
from empleados
where dpto_id = 1 AND sappaterno like '%E%';
SELECT CONCAT(e.snombre, ' ', e.sappaterno) as empleado, CONCAT(e2.snombre, ' ', e2.sappaterno) as supervisor
FROM empleados e
JOIN empleados e2 ON e.supervisor_id = e2.ci_id;