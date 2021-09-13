create extension postgres_fdw;

-- preparar un server (remoto)
create server empresa_remoto2
foreign data wrapper postgres_fdw
options(dbname 'empresa', host '26.161.16.242');

-- Realizamos el mapeo de usuarios
CREATE USER MAPPING FOR current_user
SERVER empresa_remoto2
OPTIONS(user 'remoto', password 'remoto');

-- creamos un esquema dentro de la DB
CREATE SCHEMA remoto;
insert into empleados (ci_id, nombre, appaterno, dtnacimiento, sexo)values(8063280, 'Calla', 'Chipi', '20091111', 'F');

-- Importamos las tablas requeridas
IMPORT FOREIGN SCHEMA public
FROM SERVER empresa_remoto2
INTO remoto;

-- podemos limitar la cantidad de tablas a importar
IMPORT FOREIGN SCHEMA public LIMIT TO(empleados,familiares)
FROM SERVER empresa_remoto 
INTO remoto;

-- O crear una tabla de columnas limitadas
CREATE FOREIGN TABLE tabla_remota (
    codigo      char(5) NOT NULL,
    titulo       varchar(40) NOT NULL,
    col3         integer NOT NULL,
    col6        varchar(10)
)
SERVER film_server;
select * from remoto.empleados;