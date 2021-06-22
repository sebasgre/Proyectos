DROP DATABASE proyecto;
CREATE DATABASE proyecto;
USE proyecto;
CREATE TABLE directoresAdmins (
    dni INT PRIMARY KEY,
    nombre VARCHAR(20)
);
CREATE TABLE etapas(
    numEtapa INT PRIMARY KEY,
    nombreEtapa VARCHAR(50),
    directoresAdmins_id INT,
    FOREIGN KEY (directoresAdmins_id) REFERENCES directoresAdmins(dni)
);
CREATE TABLE presidentes (
    dni INT PRIMARY KEY,
    nombre VARCHAR(20)
);
CREATE TABLE directoresTecnicos (
    dni INT PRIMARY KEY,
    nombre VARCHAR(20)
);
CREATE TABLE equipos (
    codigo INT PRIMARY KEY,
    nombre VARCHAR(20),
    pais VARCHAR(20),
    presidente_id INT,
    directoresTecnicos_id INT,
    FOREIGN KEY(presidente_id) REFERENCES presidentes(dni),
    FOREIGN KEY(directoresTecnicos_id) REFERENCES directoresTecnicos(dni)
);
CREATE TABLE jugadores(
    dni INT PRIMARY KEY,
    nombre VARCHAR(20),
    sueldo NUMERIC(10, 2) NOT NULL,
    sexo VARCHAR(1),
    numDorsal VARCHAR(2),
    peso INT,
    altura INT,
    f_nacimiento DATE,
    equipos_id INT,
    FOREIGN KEY (equipos_id) REFERENCES equipos (codigo)
);
CREATE TABLE arbitros(
    dni INT PRIMARY KEY,
    nombre VARCHAR(20),
    sueldo NUMERIC(10, 2),
    sexo VARCHAR(1),
    peso INT,
    f_nacimiento DATE,
    altura INT
);
CREATE TABLE estadios(
    nombreEstadio VARCHAR(200) PRIMARY KEY,
    centroDeportivo VARCHAR(200)
);
CREATE TABLE partidos (
    numPartido INT PRIMARY KEY,
    f_partido DATE,
    equiposVisitantes_id INT,
    equiposLocales_id INT,
    estadios_id VARCHAR(200),
    FOREIGN KEY (estadios_id) REFERENCES estadios(nombreEstadio),
    FOREIGN KEY (equiposVisitantes_id) REFERENCES equipos(codigo),
    FOREIGN KEY (equiposLocales_id) REFERENCES equipos(codigo)
);
CREATE TABLE partidosArbitros(
    partidos_id INT,
    arbitros_id INT,
    rolPartido VARCHAR(200),
    PRIMARY KEY (partidos_id, arbitros_id),
    FOREIGN KEY (partidos_id) REFERENCES partidos(numPartido),
    FOREIGN KEY (arbitros_id) REFERENCES arbitros(dni)
);
CREATE TABLE clasifican (
    equipos_id INT,
    etapas_id INT,
    fecha DATE,
    PRIMARY KEY(equipos_id, etapas_id),
    FOREIGN KEY (equipos_id) REFERENCES equipos (codigo),
    FOREIGN KEY (etapas_id) REFERENCES etapas (numEtapa)
);
CREATE TABLE tipoRegistro (
    jugadores_id INT,
    partidos_id INT,
    posicion VARCHAR(20),
    numGoles INT,
    numAsistencias INT,
    minutoIncidente INT,
    tipoTarjeta VARCHAR(20),
    minutosJugados INT,
    PRIMARY KEY (jugadores_id, partidos_id),
    FOREIGN KEY (jugadores_id) REFERENCES jugadores (dni),
    FOREIGN KEY (partidos_id) REFERENCES partidos (numPartido)
);