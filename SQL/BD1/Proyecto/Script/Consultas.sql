USE proyecto;
--1 resultado de cada partido de como finalizo
-- partido equipo local equipido visitante nombre resultado del partido termino 2-0/5-0
-- nombre equipo local visitante resultado partido
SELECT  p.numPartido
       ,l.nombre         AS EquipoLocal
       ,v.nombre         AS EquipoVisitante
       ,SUM(jL.numGoles) AS golesLocal
       ,SUM(jV.numGoles) AS golesVisitante
FROM partidos p
JOIN jugadores jL
ON jL.equipos_id = p.numPartido
JOIN jugadores jV
ON jV.equipos_id = p.numPartido
JOIN equipos e
ON e.codigo = p.equiposLocales_id
JOIN equipos e
ON e.codigo = p.equiposVisitantes_id
JOIN tipoRegistro t
ON t.partidos_id = p.numPartido
--2 jugador que recibio mas tarjetas sin importar roja o amarilla solo el jugador que recibio mas tarjetas
SELECT  j.nombre             AS nombre
       ,COUNT(t.tipoTarjeta) AS tarjetas
FROM jugadores j
JOIN tipoRegistro t
ON j.dni = t.jugadores_id
GROUP BY  j.dni
ORDER BY tarjetas desc
LIMIT 2;
--3 todos los equipos que no llegaron a cuartos de final nunca
SELECT  e.nombre AS equipos
FROM equipos e
JOIN clasifican c
ON e.codigo = c.equipos_id
WHERE c.etapas_id < 2;  