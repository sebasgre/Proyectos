-- Tarea 7
-- Obtener todos los empleados que tienen un sueldo mayor al promedio

select * from empleados e2 
where salario > (select avg(salario) from empleados e) order by salario desc 

-- Obtener los tres primeros departamentos con mayor costo en salarios

select d.numero_id, d.nombre, sum(e.salario) from departamentos d
join empleados e on e.dpto_id = d.numero_id
group by d.numero_id order by 3 desc limit 3 

-- Obtener el segundo departamento con mayor costo en salarios

select d.numero_id, d.nombre, sum(e.salario) from departamentos d
join empleados e on e.dpto_id = d.numero_id
group by d.numero_id order by 3 desc limit 1 offset 1


-- Obtener el total de ingresos de empleados con familiares y empleados sin familiares, mostrando la diferencia de montos entre ambos grupos

select *,ABS(A.familiares - B.sin_familiares) as diferencia from (
	select sum(salario) as familiares from empleados e 
	where ci_id in (select empleado_id from familiares f)
	) A, (select sum(salario) as sin_familiares from empleados e 
where not exists (select * from familiares f where f.empleado_id = e.ci_id)) B


select A.familiares,B.sin_familiares,ABS(A.familiares - B.sin_familiares) as diferencia from (
	select 'A'::text as pegamento,sum(salario) as familiares from empleados e 
	where ci_id in (select empleado_id from familiares f)
	) A
	JOIN (select 'A'::text as pegamento, sum(salario) as sin_familiares from empleados e 
where not exists (select * from familiares f where f.empleado_id = e.ci_id)) B ON A.pegamento=B.pegamento

 


-- Si la hora trabajada por proyecto es de 55 Bs., ¿cuál sería el ingreso total de cada empleado?

select e.ci_id, concat(e.nombre, ' ', e.appaterno) as empleado,
salario, COALESCE(bono,0), salario + COALESCE(bono,0) as ingreso_total
from empleados e 
left JOIN (
	select empleado_id ,sum(horas) * 55 as bono from trabajos t
	group by empleado_id ) t ON e.ci_id =t.empleado_id 
	order by ingreso_total DESC

