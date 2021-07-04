USE proyecto;
--1 resultado de cada partido de como finalizo
-- partido, equipo local, equipido visitante nombre resultado del partido termino 2-0/5-0
-- nombre equipo local, visitante, resultado partido
select p.numPartido, l.nombre as EquipoLocal, v.nombre as EquipoVisitante, sum(jL.numGoles) as golesLocal, sum(jV.numGoles) as golesVisitante
FROM partidos p
join jugadores jL on jL.equipos_id = p.numPartido
join jugadores jV on jV.equipos_id = p.numPartido
join equipos e on e.codigo = p.equiposLocales_id
join equipos e on e.codigo = p.equiposVisitantes_id
join tipoRegistro t on t.partidos_id = p.numPartido



--2 jugador que recibio mas tarjetas sin importar roja o amarilla solo el jugador que recibio mas tarjetas
select j.nombre as nombre, count(j.dni) as tarjetas
from jugadores j
join tipoRegistro t on j.dni = t.jugadores_id
group by j.dni;

--3 todos los equipos que no llegaron a cuartos de final nunca
select e.nombre as equipos 
from equipos e
join clasifican c on e.codigo = c.equipos_id
where c.etapas_id < 2;
