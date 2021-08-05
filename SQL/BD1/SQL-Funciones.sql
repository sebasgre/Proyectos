-- FUNCIONES (COUNT, SUM, MAX, MIN, AVG)
-- COUNT
SELECT
  COUNT(*)
FROM
  empleados;
-- Mostrar el total de empleados por departamento ( formato: nombre_dpto, total_empleados)
SELECT
  dpto_id,
  COUNT(*)
FROM
  empleados
GROUP BY
  dpto_id;
SELECT
  D.snombre as nombre_dpto,
  COUNT(*) as total_empleados
FROM
  empleados E
  LEFT JOIN departamentos D ON E.dpto_id = D.numero_id
GROUP BY
  D.numero_id;
SELECT
  COALESCE(D.snombre, '- -ninguno- -') as nombre_dpto,
  COUNT(*) as total_empleados
FROM
  empleados E
  LEFT JOIN departamentos D ON E.dpto_id = D.numero_id
GROUP BY
  D.numero_id;
-- Obtener el total de sueldos por departamento, el formato debe indicar el codigo del departamento,
  -- el nombre de departamento y el total de salarios pagados.
SELECT
  D.snombre as departamento,
  SUM(nsalario)
FROM
  empleados E
  JOIN departamentos D ON E.dpto_id = D.numero_id
GROUP BY
  D.numero_id
SELECT
  D.snombre,
  X.total
FROM
  departamentos D
  JOIN (
    SELECT
      dpto_id,
      SUM(nsalario) as total
    FROM
      empleados
    GROUP BY
      dpto_id
  ) X ON D.numero_id = X.dpto_id -- TOTAL DE SUELDOS POR DEPARTAMENTO ENTRE 3000 y 7000 Bs.
SELECT
  D.snombre as departamento,
  SUM(nsalario)
FROM
  empleados E
  JOIN departamentos D ON E.dpto_id = D.numero_id
GROUP BY
  D.numero_id
HAVING
  SUM(nsalario) BETWEEN 3000
  AND 7000
SELECT
  D.snombre,
  X.total
FROM
  departamentos D
  JOIN (
    SELECT
      dpto_id,
      SUM(nsalario) as total
    FROM
      empleados
    GROUP BY
      dpto_id
  ) X ON D.numero_id = X.dpto_id
WHERE
  X.total > 3000
  AND X.total < 7000 -- Obtener el nombre y apellido de cada empleado, e indicar el total de empleados a su cargo.
SELECT
  CONCAT(S.snombre, ' ', S.sappaterno) as supervisor,
  CONCAT(E.snombre, ' ', E.sappaterno) as empleado
FROM
  empleados S
  JOIN empleados E ON S.ci_id = E.supervisor_id;
-- Cuenta los registros, incluidos los que no supervisan a nadie
SELECT
  CONCAT(S.snombre, ' ', S.sappaterno) as supervisor,
  COUNT(*)
FROM
  empleados S LEFTJOIN empleados E ON S.ci_id = E.supervisor_id
GROUP BY
  CONCAT(S.snombre, ' ', S.sappaterno);
-- Al hacer la funcion COUNT en una columna, si encuentra valores nulos, los contará como 0
SELECT
  CONCAT(S.snombre, ' ', S.sappaterno) as supervisor,
  COUNT(E.ci_id)
FROM
  empleados S
  LEFT JOIN empleados E ON S.ci_id = E.supervisor_id
GROUP BY
  CONCAT(S.snombre, ' ', S.sappaterno);
SELECT
  CONCAT(S.snombre, ' ', S.sappaterno) as supervisor,
  COUNT(E.ci_id)
FROM
  empleados S
  LEFT JOIN empleados E ON S.ci_id = E.supervisor_id
GROUP BY
  CONCAT(S.snombre, ' ', S.sappaterno)
HAVING
  COUNT(E.ci_id) >= 2;
-- MAX, MIX, AVG
SELECT
  MAX(nsalario)
FROM
  empleados;
-- Obtener los datos del empleado con el salario máximo
SELECT
  *
FROM
  empleados
WHERE
  nsalario = (
    SELECT
      MAX(nsalario)
    FROM
      empleados
  );
-- Saber los empleados que tienen un sueldo mayor al promedio
SELECT
  *
FROM
  empleados
WHERE
  nsalario > (
    SELECT
      AVG(nsalario)
    FROM
      empleados
  );