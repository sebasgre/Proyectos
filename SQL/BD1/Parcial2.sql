CREATE DATABASE naval;

USE naval;

CREATE TABLE barco
(
    nombre VARCHAR(20) PRIMARY KEY,
    propietario VARCHAR(20) NOT NULL
);

CREATE TABLE tipo_barco
(
    nombre_barco VARCHAR(20),
    tipo VARCHAR(20),
    casco VARCHAR(45),
    tonelaje INT,
    PRIMARY KEY(nombre_barco, tipo),
    FOREIGN KEY(nombre_barco) REFERENCES barco(nombre)
);

CREATE TABLE mov_barco
(
    nombre_barco VARCHAR(20) PRIMARY KEY,
    latitud INT,
    longitud INT,
    FOREIGN KEY(nombre_barco) REFERENCES barco(nombre)
);

CREATE TABLE marca_tiempo
(
    nombre_barco VARCHAR(20) PRIMARY KEY,
    fecha DATE NOT NULL,
    hora INT,
    FOREIGN KEY(nombre_barco) REFERENCES mov_barco(nombre_barco)
);


CREATE TABLE puerto
(
    nombre_barco VARCHAR(20),
    nombreP VARCHAR(20),
    PRIMARY KEY(nombreP,nombre_barco),
    FOREIGN KEY(nombre_barco) REFERENCES barco(nombre)
);

CREATE TABLE visita_puerto
(
    nombre_barco VARCHAR(20),
    nombrePuerto VARCHAR(20),
    dtInicio DATE NOT NULL,
    dtFin DATE NOT NULL,
    PRIMARY KEY(nombre_barco, nombrePuerto),
    FOREIGN KEY(nombre_barco) REFERENCES barco(nombre)
);

CREATE TABLE estado
(
    nombrePuerto VARCHAR(20) PRIMARY KEY,
    continente VARCHAR(20),
    nombrePais VARCHAR(20) NOT NULL,
    FOREIGN KEY (nombrePuerto) REFERENCES puerto(nombreP)
);

CREATE TABLE mar
(
    nombrePuerto VARCHAR(20) PRIMARY KEY,
    nombreMar VARCHAR(20),
    FOREIGN KEY (nombrePuerto) REFERENCES puerto(nombreP)
);



ALTER TABLE visita_puerto
ADD FOREIGN KEY (nombrePuerto) REFERENCES puerto(nombreP);

INSERT INTO barco
VALUES
    ('Fragata', 'N.B.J');

INSERT INTO puerto
VALUES
    ('Fragata', 'cualquier cosa');

INSERT INTO estado
VALUES
    ('cualquier cosa', 'America', 'Chile');

SELECT *
from barco;

SELECT *
from puerto;

SELECT *
from estado;


UPDATE barco
SET propietario = 'N.O.V'
WHERE propietario = 'N.B.J';

SELECT *
from barco;
