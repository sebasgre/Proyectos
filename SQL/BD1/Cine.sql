CREATE DATABASE cine;

USE cine;

CREATE TABLE personas(
    dni_id INT PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    apellidoP VARCHAR(30) NOT NULL,
    apellidoM VARCHAR(30),
    dtNacimiento DATE
);

CREATE TABLE productoras(
    nombre_id VARCHAR(30) PRIMARY KEY,
    direccion VARCHAR(200)
);

CREATE TABLE peliculas(
    titulo_id VARCHAR(40) PRIMARY KEY,
    añoproyeccion INT,
    duracion TIME,
    resumen TEXT,
    productora_id VARCHAR(30),
    FOREIGN KEY(productora_id) REFERENCES productoras(nombre_id)
);

CREATE TABLE peliculas_generos(
    titulo_id VARCHAR(40),
    genero VARCHAR(30),
    PRIMARY KEY (titulo_id,genero),
    FOREIGN KEY (titulo_id) REFERENCES peliculas(titulo_id)
);

CREATE TABLE actuar(
    actor_id INT,
    pelicula_id VARCHAR(40),
    papel VARCHAR(30),
    PRIMARY KEY (actor_id,pelicula_id),
    FOREIGN KEY (actor_id) REFERENCES Personas(dni_id),
    FOREIGN KEY (pelicula_id) REFERENCES peliculas(titulo_id)
);

CREATE TABLE actuar_citas(
    actor_id INT,
    pelicula_id VARCHAR(40),
    cita VARCHAR(200),
    PRIMARY KEY(actor_id, pelicula_id, cita),
    FOREIGN KEY (actor_id, pelicula_id) REFERENCES actuar(actor_id, pelicula_id)
);

CREATE TABLE dirigir(
    director_id INT,
    pelicula_id VARCHAR(40),
    PRIMARY KEY (director_id,pelicula_id),
    FOREIGN KEY (director_id) REFERENCES Personas(dni_id),
    FOREIGN KEY (pelicula_id) REFERENCES peliculas(titulo_id)
);

/*
-- insertar datos
-- total
INSERT INTO departamentos VALUES (1,'Sistemas', null, null);

-- "parcial"
INSERT INTO departamentos(snombre,numero_id) VALUES ('Gerencia',2);

INSERT INTO empleados (ci_id,snombre,sappaterno,sdireccion,nsalario,dtnacimiento,dpto_id) VALUES (
    2,'Pedro','Perez','Av. Banzer, 2do anillo',1500.50,
    '1992-05-13',1
);

--EXTRA
--modificar columna
ALTER TABLE departamentos
MODIFY admin_id int null


--Actualizar datos - UPDATE
UPDATE tabla
SET [col=valor, .....]
WHERE [condicion]

UPDATE empleados
SET supervisor_id = null, sdireccion = 'Av. Beni, 3er anillo', stelefono = '77011511'
WHERE ci_id = 2;

UPDATE empleados
SET nsalario = 3500

UPDATE empleados
SET nsalario = 500
WHERE ci_id = 1 OR ci_id = 2;

update empleados
set dpto_id = 3
where dpto_id = 1;
*/
