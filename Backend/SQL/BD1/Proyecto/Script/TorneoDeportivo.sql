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

insert into directoresAdmins (dni, nombre) values (1, 'Shawnee');
insert into directoresAdmins (dni, nombre) values (2, 'Glynis');
insert into directoresAdmins (dni, nombre) values (3, 'Fabio');
insert into directoresAdmins (dni, nombre) values (4, 'El Bicho');
insert into directoresAdmins (dni, nombre) values (5, 'Alcalde Diamante');

insert into etapas (numEtapa, nombreEtapa, directoresAdmins_id) values (1, 'Fase de grupos', 1);
insert into etapas (numEtapa, nombreEtapa, directoresAdmins_id) values (2, 'Cuartos de final', 2);
insert into etapas (numEtapa, nombreEtapa, directoresAdmins_id) values (3, 'Semifinal', 3);
insert into etapas (numEtapa, nombreEtapa, directoresAdmins_id) values (4, 'Final', 4);
insert into etapas (numEtapa, nombreEtapa, directoresAdmins_id) values (5, 'Campeon', 5);

insert into presidentes (dni, nombre) values (1, 'Melosa');
insert into presidentes (dni, nombre) values (2, 'Andreas');
insert into presidentes (dni, nombre) values (3, 'Terra');
insert into presidentes (dni, nombre) values (4, 'Warren');
insert into presidentes (dni, nombre) values (5, 'Marc');
insert into presidentes (dni, nombre) values (6, 'Madel');
insert into presidentes (dni, nombre) values (7, 'Jerrine');
insert into presidentes (dni, nombre) values (8, 'Dode');
insert into presidentes (dni, nombre) values (9, 'Ailina');
insert into presidentes (dni, nombre) values (10, 'Coriss');
insert into presidentes (dni, nombre) values (11, 'Anthia');
insert into presidentes (dni, nombre) values (12, 'Tyson');
insert into presidentes (dni, nombre) values (13, 'Bernardine');
insert into presidentes (dni, nombre) values (14, 'Parry');
insert into presidentes (dni, nombre) values (15, 'Fabiano');
insert into presidentes (dni, nombre) values (16, 'Nicolas');

insert into directoresTecnicos (dni, nombre) values (1, 'Dody');
insert into directoresTecnicos (dni, nombre) values (2, 'Deloris');
insert into directoresTecnicos (dni, nombre) values (3, 'Barclay');
insert into directoresTecnicos (dni, nombre) values (4, 'Bettye');
insert into directoresTecnicos (dni, nombre) values (5, 'Nicol');
insert into directoresTecnicos (dni, nombre) values (6, 'Jacqueline');
insert into directoresTecnicos (dni, nombre) values (7, 'Marje');
insert into directoresTecnicos (dni, nombre) values (8, 'Melvin');
insert into directoresTecnicos (dni, nombre) values (9, 'Yetty');
insert into directoresTecnicos (dni, nombre) values (10, 'Clim');
insert into directoresTecnicos (dni, nombre) values (11, 'Brade');
insert into directoresTecnicos (dni, nombre) values (12, 'Mordecai');
insert into directoresTecnicos (dni, nombre) values (13, 'Kass');
insert into directoresTecnicos (dni, nombre) values (14, 'Cherilynn');
insert into directoresTecnicos (dni, nombre) values (15, 'Minnaminnie');
insert into directoresTecnicos (dni, nombre) values (16, 'Mavra');

insert into equipos (codigo, nombre, pais, presidente_id, directoresTecnicos_id) values (1, 'Villarreal', 'España', 1, 1);
insert into equipos (codigo, nombre, pais, presidente_id, directoresTecnicos_id) values (2, 'Atlético de Madrid', 'España', 2, 2);
insert into equipos (codigo, nombre, pais, presidente_id, directoresTecnicos_id) values (3, 'Barcelona', 'España', 3, 3);
insert into equipos (codigo, nombre, pais, presidente_id, directoresTecnicos_id) values (4, 'Real Madrid', 'España', 4, 4);

insert into equipos (codigo, nombre, pais, presidente_id, directoresTecnicos_id) values (5, 'Sevilla', 'España', 5, 5);
insert into equipos (codigo, nombre, pais, presidente_id, directoresTecnicos_id) values (6, 'Manchester City', 'Inglaterra', 6, 6);
insert into equipos (codigo, nombre, pais, presidente_id, directoresTecnicos_id) values (7, 'Manchester United', 'Inglaterra', 7, 7);
insert into equipos (codigo, nombre, pais, presidente_id, directoresTecnicos_id) values (8, 'Chelsea', 'Inglaterra', 8, 8);

insert into equipos (codigo, nombre, pais, presidente_id, directoresTecnicos_id) values (9, 'Liverpool', 'Inglaterra', 9, 9);
insert into equipos (codigo, nombre, pais, presidente_id, directoresTecnicos_id) values (10, 'Bayern de Múnich', 'Alemania', 10, 10);
insert into equipos (codigo, nombre, pais, presidente_id, directoresTecnicos_id) values (11, 'RB Leipzig', 'Alemania', 11, 11);
insert into equipos (codigo, nombre, pais, presidente_id, directoresTecnicos_id) values (12, 'Borussia Dortmund', 'Alemania', 12, 12);

insert into equipos (codigo, nombre, pais, presidente_id, directoresTecnicos_id) values (13, 'PSG', 'Francia', 13, 13);
insert into equipos (codigo, nombre, pais, presidente_id, directoresTecnicos_id) values (14, 'Inter de Milán', 'Italia', 14, 14);
insert into equipos (codigo, nombre, pais, presidente_id, directoresTecnicos_id) values (15, 'Atalanta, Milan', 'Italia', 15, 15);
insert into equipos (codigo, nombre, pais, presidente_id, directoresTecnicos_id) values (16, 'Milan', 'Italia', 16, 16);


insert into clasifican (equipos_id, etapas_id, fecha) values (1, 1, '2021-01-01');
insert into clasifican (equipos_id, etapas_id, fecha) values (2, 1, '2021-01-01');
insert into clasifican (equipos_id, etapas_id, fecha) values (3, 1, '2021-01-01');
insert into clasifican (equipos_id, etapas_id, fecha) values (4, 1, '2021-01-01');
insert into clasifican (equipos_id, etapas_id, fecha) values (5, 1, '2021-01-01');
insert into clasifican (equipos_id, etapas_id, fecha) values (6, 1, '2021-01-01');
insert into clasifican (equipos_id, etapas_id, fecha) values (7, 1, '2021-01-01');
insert into clasifican (equipos_id, etapas_id, fecha) values (8, 1, '2021-01-01');
insert into clasifican (equipos_id, etapas_id, fecha) values (9, 1, '2021-01-01');
insert into clasifican (equipos_id, etapas_id, fecha) values (10, 1, '2021-01-01');
insert into clasifican (equipos_id, etapas_id, fecha) values (11, 1, '2021-01-01');
insert into clasifican (equipos_id, etapas_id, fecha) values (12, 1, '2021-01-01');
insert into clasifican (equipos_id, etapas_id, fecha) values (13, 1, '2021-01-01');
insert into clasifican (equipos_id, etapas_id, fecha) values (14, 1, '2021-01-01');
insert into clasifican (equipos_id, etapas_id, fecha) values (15, 1, '2021-01-01');
insert into clasifican (equipos_id, etapas_id, fecha) values (16, 1, '2021-01-01');

insert into estadios (nombreEstadio, centroDeportivo) values ('Englebert', 'Ella');
insert into estadios (nombreEstadio, centroDeportivo) values ('Bastian', 'Virgie');
insert into estadios (nombreEstadio, centroDeportivo) values ('Robb', 'Salomon');
insert into estadios (nombreEstadio, centroDeportivo) values ('Pauline', 'Foster');
insert into estadios (nombreEstadio, centroDeportivo) values ('Kaylee', 'Lenard');
insert into estadios (nombreEstadio, centroDeportivo) values ('Emmy', 'Giacinta');
insert into estadios (nombreEstadio, centroDeportivo) values ('Gabriello', 'Pammy');
insert into estadios (nombreEstadio, centroDeportivo) values ('Ricki', 'Karie');
insert into estadios (nombreEstadio, centroDeportivo) values ('Bambie', 'Cass');
insert into estadios (nombreEstadio, centroDeportivo) values ('Kelly', 'Brietta');
insert into estadios (nombreEstadio, centroDeportivo) values ('Zsazsa', 'Julee');
insert into estadios (nombreEstadio, centroDeportivo) values ('Isadore', 'Christie');
insert into estadios (nombreEstadio, centroDeportivo) values ('Marilin', 'Polly');
insert into estadios (nombreEstadio, centroDeportivo) values ('Gram', 'Dave');
insert into estadios (nombreEstadio, centroDeportivo) values ('Maxwell', 'Merlina');
insert into estadios (nombreEstadio, centroDeportivo) values ('Chariot', 'Camilla');
insert into estadios (nombreEstadio, centroDeportivo) values ('Estrella', 'Darcy');

insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (1, '2021-01-22', 1, 2, 'Englebert');
insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (2, '2021-01-29', 2, 1, 'Bastian');

insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (3, '2021-01-27', 3, 4, 'Robb');
insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (4, '2021-01-27', 4, 3, 'Pauline');

insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (5, '2021-01-28', 5, 6, 'Kaylee');
insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (6, '2021-01-06', 6, 5, 'Emmy');

insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (7, '2021-01-15', 7, 8, 'Gabriello');
insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (8, '2021-02-01', 8, 7, 'Ricki');

insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (9, '2021-01-08', 9, 10, 'Bambie');
insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (10, '2021-01-09', 10, 9, 'Gram');

insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (11, '2021-01-26', 11, 12, 'Kelly');
insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (12, '2021-01-11', 12, 11, 'Zsazsa');

insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (13, '2021-01-30', 13, 14, 'Isadore');
insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (14, '2021-02-02', 14, 13, 'Marilin');

insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (15, '2021-01-11', 15, 16, 'Maxwell');
insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (16, '2021-01-29', 16, 15, 'Pauline');

insert into clasifican (equipos_id, etapas_id, fecha) values (1, 2, '2021-01-29');
insert into clasifican (equipos_id, etapas_id, fecha) values (3, 2, '2021-01-27');
insert into clasifican (equipos_id, etapas_id, fecha) values (5, 2, '2021-01-06');
insert into clasifican (equipos_id, etapas_id, fecha) values (8, 2, '2021-02-01');
insert into clasifican (equipos_id, etapas_id, fecha) values (9, 2, '2021-01-09');
insert into clasifican (equipos_id, etapas_id, fecha) values (11, 2, '2021-01-11');
insert into clasifican (equipos_id, etapas_id, fecha) values (14, 2, '2021-02-02');
insert into clasifican (equipos_id, etapas_id, fecha) values (16, 2, '2021-01-29');

insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (17, '2021-01-17', 1, 3, 'Chariot');
insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (18, '2021-01-12', 3, 1, 'Bambie');

insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (19, '2021-01-22', 5, 8, 'Ricki');
insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (20, '2021-01-19', 8, 5, 'Pauline');

insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (21, '2021-01-17', 9, 11, 'Bastian');
insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (22, '2021-01-12', 11, 9, 'Gabriello');

insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (23, '2021-01-22', 14, 16, 'Maxwell');
insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (24, '2021-01-19', 16, 14, 'Estrella');

insert into clasifican (equipos_id, etapas_id, fecha) values (3, 3, '2021-01-12');
insert into clasifican (equipos_id, etapas_id, fecha) values (8, 3, '2021-01-19');
insert into clasifican (equipos_id, etapas_id, fecha) values (9, 3, '2021-01-12');
insert into clasifican (equipos_id, etapas_id, fecha) values (14, 3, '2021-01-19');

insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (25, '2021-01-28', 3, 8, 'Zsazsa');
insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (26, '2021-01-06', 8, 3, 'Pauline');

insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (27, '2021-01-15', 9, 14, 'Chariot');
insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (28, '2021-02-01', 14, 9, 'Robb');

insert into clasifican (equipos_id, etapas_id, fecha) values (8, 4, '2021-01-06');
insert into clasifican (equipos_id, etapas_id, fecha) values (14, 4, '2021-02-01');

insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (29, '2021-01-08', 8, 14, 'Estrella');

insert into clasifican (equipos_id, etapas_id, fecha) values (14, 5, '2021-01-08');

insert into arbitros (dni, nombre, sueldo, sexo, f_nacimiento) values (1, 'Mirella', 8932, 'M', '1991-07-26');
insert into arbitros (dni, nombre, sueldo, sexo, f_nacimiento) values (2, 'Keven', 8201, 'M', '1993-10-10');
insert into arbitros (dni, nombre, sueldo, sexo, f_nacimiento) values (3, 'Normand', 8603, 'M', '1997-04-20');
insert into arbitros (dni, nombre, sueldo, sexo, f_nacimiento) values (4, 'Bradly', 9037, 'M', '1997-10-28');
insert into arbitros (dni, nombre, sueldo, sexo, f_nacimiento) values (5, 'Zollie', 9347, 'M', '1994-03-02');
insert into arbitros (dni, nombre, sueldo, sexo, f_nacimiento) values (6, 'Talbert', 8546, 'M', '1998-07-25');
insert into arbitros (dni, nombre, sueldo, sexo, f_nacimiento) values (7, 'Royall', 9850, 'M', '1995-05-07');
insert into arbitros (dni, nombre, sueldo, sexo, f_nacimiento) values (8, 'Vaughan', 9765, 'M', '1999-04-16');
insert into arbitros (dni, nombre, sueldo, sexo, f_nacimiento) values (9, 'Keven', 9850, 'M', '1995-05-07');
insert into arbitros (dni, nombre, sueldo, sexo, f_nacimiento) values (10, 'Talbert', 9765, 'M', '1999-04-16');


insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (1, 1, 'ida');
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (2, 2, 'vuelta');
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (3, 3, 'ida');
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (4, 4, 'vuelta');
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (5, 5, 'ida');
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (6, 6, 'vuelta');
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (7, 7, 'ida');
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (8, 8, 'vuelta');
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (9, 9, 'ida');
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (10, 10, 'vuelta');
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (11, 1, 'ida');
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (12, 2, 'vuelta');
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (13, 3, 'ida');
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (14, 4, 'vuelta');
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (15, 5, 'ida');
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (16, 6, 'vuelta');
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (17, 7, 'ida');
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (18, 8, 'vuelta');
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (19, 9, 'ida');
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (20, 10, 'vuelta');
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (21, 1, 'ida');
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (22, 2, 'vuelta');
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (23, 3, 'ida');
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (24, 4, 'vuelta');
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (25, 5, 'ida');
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (26, 6, 'vuelta');
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (27, 7, 'ida');
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (28, 8, 'vuelta');
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (29, 9, 'Final');

-- equipo 1
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (1, 'Mbappe', 1293955, 'M', 17, 64.5, 166.2, '1995-09-19', 1);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (2, 'Ronaldinho', 4305819, 'M', 26, 63.9, 154.9, '1991-10-07', 1);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (3, 'Zidane', 2668690, 'M', 24, 87.3, 184.5, '1993-10-22', 1);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (4, 'Maradona', 9271759, 'M', 25, 86.1, 199.9, '1996-05-10', 1);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (5, 'Pele', 6854832, 'M', 14, 80.2, 164.0, '1999-08-21', 1);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (6, 'Luka Modric', 3679253, 'M', 17, 75.6, 179.9, '1999-06-05', 1);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (7, 'Xavi', 7645901, 'M', 28, 69.1, 178.1, '1999-03-10', 1);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (8, 'Iniesta', 9354040, 'M', 8, 80.8, 158.4, '1996-01-20', 1);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (9, 'Pique', 4383135, 'M', 8, 72.9, 191.6, '1999-01-15', 1);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (10, 'Ibrahomivich', 4837365, 'M', 20, 82.8, 198.8, '1999-05-18', 1);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (11, 'Brahim', 4604525, 'M', 13, 62.5, 188.0, '1999-08-08', 1);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (12, 'Joao Felix', 4604469, 'M', 20, 78.0, 186.7, '1991-07-29', 1);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (13, 'Werner', 6127401, 'M', 26, 73.8, 170.9, '1994-11-11', 1);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (14, 'Ramos', 1215840, 'M', 17, 62.8, 163.1, '1999-08-30', 1);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (15, 'Pablo presidente', 2552040, 'M', 13, 69.2, 196.2, '1991-01-04', 1);
-- equipo 2
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (16, 'Enrique', 3475432, 'M', 10, 75.1, 185.4, '1995-01-27', 2);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (17, 'Sebastian', 7018964, 'M', 30, 63.4, 174.0, '1990-05-15', 2);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (18, 'Laporte', 3275881, 'M', 1, 66.4, 195.8, '1995-02-17', 2);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (19, 'Griezman', 9725884, 'M', 27, 79.2, 157.0, '1991-11-20', 2);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (20, 'Sancho', 2338065, 'M', 2, 78.0, 187.1, '1995-10-16', 2);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (21, 'Halland', 9658256, 'M', 7, 85.3, 166.5, '1992-03-20', 2);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (22, 'Kimbeppe', 5272060, 'M', 19, 77.8, 191.4, '1993-05-11', 2);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (23, 'Chelsy', 9416618, 'M', 13, 62.4, 174.0, '1990-01-30', 2);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (24, 'Rodrigo', 8453259, 'M', 11, 61.5, 187.4, '1992-06-19', 2);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (25, 'Lewandoski', 6612835, 'M', 28, 64.2, 171.1, '1990-09-17', 2);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (26, 'Valverde', 3002687, 'M', 15, 67.8, 160.6, '1993-10-13', 2);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (27, 'Courtois', 7684537, 'M', 14, 73.9, 190.4, '1991-02-23', 2);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (28, 'Terstegen', 9478098, 'M', 16, 89.9, 180.1, '1998-09-29', 2);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (29, 'Neur', 7277061, 'M', 9, 86.5, 197.6, '1992-07-06', 2);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (30, 'Haily', 3495027, 'M', 20, 65.1, 180.6, '1993-10-27', 2);
-- equipo 3
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (31, 'Patrizio', 3710870, 'M', 18, 87.0, 199.2, '1993-02-08', 3);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (32, 'Roz', 6165636, 'M', 7, 63.3, 152.6, '1990-11-17', 3);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (33, 'Bren', 5121177, 'M', 5, 78.3, 161.5, '1990-06-12', 3);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (34, 'Kaleb', 4855859, 'M', 29, 71.3, 192.2, '1995-07-15', 3);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (35, 'Eve', 6351281, 'M', 2, 87.8, 168.4, '1998-10-12', 3);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (36, 'Rianon', 1781998, 'M', 13, 76.9, 182.6, '1992-06-14', 3);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (37, 'Darcie', 8436901, 'M', 12, 71.5, 185.7, '1990-10-10', 3);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (38, 'Huey', 1821560, 'M', 11, 82.4, 156.9, '1993-03-07', 3);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (39, 'Lydon', 7173175, 'M', 15, 73.4, 150.7, '1991-11-01', 3);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (40, 'Beaufort', 5728383, 'M', 18, 86.3, 189.9, '1994-06-03', 3);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (41, 'Petr', 2283821, 'M', 3, 65.2, 192.5, '1990-04-18', 3);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (42, 'Eda', 221297, 'M', 10, 63.0, 181.1, '1991-03-29', 3);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (43, 'Delphine', 1241176, 'M', 22, 86.8, 199.5, '1995-12-11', 3);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (44, 'Kippy', 3703198, 'M', 18, 74.3, 187.0, '1997-11-23', 3);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (45, 'Clair', 7864388, 'M', 20, 75.2, 196.6, '1993-03-02', 3);
-- equipo 4
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (46, 'Jorrie', 5863369, 'M', 15, 83.5, 172.4, '1997-06-03', 4);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (47, 'Reggie', 8084121, 'M', 24, 80.9, 166.0, '1998-11-09', 4);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (48, 'Basile', 1903738, 'M', 26, 82.0, 188.0, '1996-09-30', 4);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (49, 'Vail', 6823484, 'M', 2, 76.3, 152.0, '1991-05-12', 4);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (50, 'Rudiger', 5494943, 'M', 7, 78.5, 171.9, '1999-09-04', 4);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (51, 'Kerrin', 6402765, 'M', 20, 65.0, 177.4, '1996-09-06', 4);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (52, 'Gustaf', 6980431, 'M', 30, 70.8, 195.7, '1990-11-28', 4);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (53, 'Murial', 1540782, 'M', 5, 64.9, 159.1, '1994-06-10', 4);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (54, 'Mariska', 5456387, 'M', 5, 84.8, 157.2, '1999-05-25', 4);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (55, 'Kristofer', 1999399, 'M', 10, 63.2, 156.7, '1994-02-03', 4);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (56, 'Stanly', 2292253, 'M', 27, 72.5, 191.9, '1998-05-12', 4);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (57, 'Ade', 8266236, 'M', 18, 73.8, 199.9, '1999-07-19', 4);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (58, 'Lauri', 5162770, 'M', 10, 83.5, 181.9, '1990-08-05', 4);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (59, 'Janie', 7500562, 'M', 26, 70.0, 181.5, '1995-01-16', 4);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (60, 'Jennine', 7572236, 'M', 15, 85.1, 181.4, '1994-01-11', 4);
-- equipo 5
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (61, 'Tye', 9829100, 'M', 23, 63.9, 187.7, '1995-05-21', 5);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (62, 'Winni', 5661124, 'M', 9, 86.8, 180.6, '1993-05-26', 5);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (63, 'Cherlyn', 9502733, 'M', 8, 89.4, 159.4, '1992-02-03', 5);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (64, 'Loni', 6203588, 'M', 25, 81.2, 162.1, '1990-08-09', 5);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (65, 'Bunnie', 6496518, 'M', 5, 61.8, 192.7, '1998-05-05', 5);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (66, 'Magdalene', 3685105, 'M', 23, 73.1, 162.7, '1992-03-24', 5);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (67, 'Vasily', 698718, 'M', 11, 70.2, 169.0, '1998-09-26', 5);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (68, 'Ferdinande', 8616613, 'M', 4, 86.6, 179.4, '1994-04-24', 5);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (69, 'Abbey', 1381406, 'M', 11, 80.4, 171.2, '1992-04-21', 5);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (70, 'Lyda', 9019835, 'M', 14, 67.1, 179.1, '1991-11-06', 5);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (71, 'Issie', 3330626, 'M', 15, 61.8, 193.8, '1999-10-09', 5);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (72, 'Andre', 9880473, 'M', 15, 65.3, 184.0, '1997-08-26', 5);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (73, 'Bethena', 1008271, 'M', 3, 79.2, 173.6, '1991-07-14', 5);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (74, 'Doralin', 7733951, 'M', 2, 86.4, 169.6, '1994-06-12', 5);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (75, 'Aggi', 9120558, 'M', 9, 88.8, 180.1, '1999-03-23', 5);
-- equipo 6
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (76, 'Rivkah', 601710, 'M', 26, 74.8, 194.1, '1995-09-28', 6);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (77, 'Mollie', 6100573, 'M', 12, 64.8, 195.3, '1992-12-09', 6);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (78, 'Corinne', 5606758, 'M', 4, 61.2, 175.3, '1997-11-27', 6);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (79, 'Amelia', 8777318, 'M', 13, 89.1, 167.0, '1999-07-18', 6);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (80, 'Keefer', 5517725, 'M', 25, 73.1, 186.9, '1997-09-21', 6);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (81, 'Art', 9186137, 'M', 18, 60.8, 173.1, '1995-06-08', 6);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (82, 'Patty', 2057756, 'M', 9, 86.1, 181.0, '1999-02-02', 6);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (83, 'Onfre', 8414628, 'M', 11, 68.7, 178.0, '1998-01-14', 6);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (84, 'Eddie', 7856384, 'M', 6, 70.2, 164.7, '1994-08-14', 6);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (85, 'Alikee', 1585137, 'M', 26, 88.7, 166.7, '1992-02-17', 6);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (86, 'Briney', 7098829, 'M', 25, 70.5, 186.2, '1994-09-03', 6);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (87, 'Larissa', 9491158, 'M', 27, 80.8, 199.0, '1997-08-31', 6);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (88, 'Henderson', 5483477, 'M', 7, 74.1, 168.6, '1999-11-21', 6);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (89, 'Inglis', 2677482, 'M', 5, 60.7, 179.3, '1998-04-23', 6);
-- equipo 7
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (90, 'Neall', 4831150, 'M', 9, 78.7, 179.5, '1990-06-26', 7);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (91, 'Jacques', 2458486, 'M', 4, 80.9, 157.7, '1990-11-15', 7);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (92, 'Lauraine', 6631248, 'M', 28, 83.6, 166.4, '1991-03-02', 7);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (93, 'Garvy', 2442847, 'M', 16, 71.6, 190.3, '1992-07-26', 7);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (94, 'Portie', 5515178, 'M', 29, 89.7, 195.5, '1993-08-08', 7);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (95, 'Adan', 6782579, 'M', 24, 82.9, 157.8, '1992-07-10', 7);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (96, 'Molli', 2188098, 'M', 11, 61.5, 150.6, '1998-08-07', 7);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (97, 'Jon', 5544482, 'M', 2, 66.1, 186.9, '1994-07-04', 7);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (98, 'Jud', 7103161, 'M', 30, 65.9, 163.6, '1997-07-26', 7);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (99, 'Charles', 2711656, 'M', 9, 68.5, 151.8, '1995-12-25', 7);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (100, 'Tate', 2700070, 'M', 15, 78.9, 157.7, '1995-12-29', 7);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (101, 'Jon', 5544482, 'M', 2, 66.1, 186.9, '1994-07-04', 7);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (102, 'Jud', 7103161, 'M', 30, 65.9, 163.6, '1997-07-26', 7);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (103, 'Charles', 2711656, 'M', 9, 68.5, 151.8, '1995-12-25', 7);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (104, 'Tate', 2700070, 'M', 15, 78.9, 157.7, '1995-12-29', 7);
-- equipo 8
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (105, 'Ikey', 7091367, 'M', 27, 88, 167, '2000/02/12', 8);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (106, 'Tracie', 3455587, 'M', 24, 65, 197, '1990/01/02', 8);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (107, 'Hill', 2566090, 'M', 24, 74, 198, '1997/05/17', 8);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (108, 'Anette', 7775399, 'M', 3, 77, 191, '1996/12/15', 8);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (109, 'Courtenay', 1455355, 'M', 15, 70, 183, '1997/05/26', 8);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (110, 'Arie', 5904040, 'M', 11, 74, 173, '1990/04/19', 8);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (111, 'Mendel', 5717066, 'M', 27, 85, 195, '1992/04/05', 8);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (112, 'Lodovico', 2700265, 'M', 21, 76, 167, '1996/08/24', 8);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (113, 'Ricky', 1791077, 'M', 12, 84, 183, '1998/12/26', 8);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (114, 'Sonny', 1641130, 'M', 6, 80, 168, '1991/03/29', 8);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (115, 'Theodor', 8846198, 'M', 2, 66, 185, '2000/11/03', 8);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (116, 'Cointon', 1404062, 'M', 26, 89, 181, '1992/12/21', 8);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (117, 'Judon', 1889097, 'M', 1, 79, 189, '2000/04/06', 8);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (118, 'Cchaddie', 7248019, 'M', 4, 65, 167, '2000/04/05', 8);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (119, 'Paulita', 4886502, 'M', 27, 80, 191, '1999/09/26', 8);
-- equipo 9 
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (120, 'Shirline', 3882806, 'M', 19, 81, 161, '1993/12/04', 9);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (121, 'Josephina', 6827460, 'M', 22, 88, 194, '1990/07/02', 9);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (122, 'Jacqui', 3712971, 'M', 10, 65, 173, '2000/12/24', 9);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (123, 'Gwenny', 1356439, 'M', 18, 81, 199, '1994/04/18', 9);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (124, 'Thornton', 2924806, 'M', 20, 82, 178, '1991/08/21', 9);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (125, 'Delia', 5580601, 'M', 21, 86, 161, '2000/12/17', 9);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (126, 'Georgy', 3795738, 'M', 3, 86, 191, '1993/07/09', 9);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (127, 'Kinny', 2217328, 'M', 1, 87, 170, '1990/07/09', 9);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (128, 'Janet', 2996991, 'M', 2, 74, 193, '1992/04/28', 9);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (129, 'Bruno', 5230544, 'M', 11, 70, 188, '2000/02/03', 9);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (130, 'Gilda', 1484868, 'M', 18, 65, 172, '1990/12/07', 9);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (131, 'Caril', 1182944, 'M', 25, 63, 186, '1994/08/08', 9);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (132, 'Kermie', 6200387, 'M', 14, 79, 179, '1997/06/17', 9);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (133, 'Rene', 3929701, 'M', 18, 86, 166, '2000/04/29', 9);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (134, 'Wallie', 7597202, 'M', 4, 68, 186, '1996/10/28', 9);
-- equipo 10
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (135, 'Francoise', 1096098, 'M', 15, 64, 166, '2000/02/26', 10);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (136, 'Jesselyn', 6039849, 'M', 21, 86, 188, '1992/10/26', 10);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (137, 'Trixie', 8247860, 'M', 2, 73, 198, '1993/09/02', 10);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (138, 'Barnebas', 2712946, 'M', 18, 66, 181, '1992/12/30', 10);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (139, 'Shanan', 2758081, 'M', 29, 86, 189, '1996/03/19', 10);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (140, 'Bink', 3707479, 'M', 2, 78, 194, '1997/02/13', 10);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (141, 'Vail', 1120866, 'M', 13, 61, 187, '1997/03/26', 10);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (142, 'Domenic', 8897501, 'M', 10, 84, 190, '1993/01/16', 10);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (143, 'Marty', 1674787, 'M', 21, 68, 196, '1994/03/06', 10);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (144, 'Bibby', 7432564, 'M', 29, 82, 194, '1997/07/04', 10);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (145, 'Jinny', 6963093, 'M', 23, 80, 167, '1995/12/31', 10);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (146, 'Diane-marie', 1418504, 'M', 23, 83, 166, '1998/07/13', 10);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (147, 'Shelley', 7864824, 'M', 27, 85, 196, '1995/06/10', 10);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (148, 'Lammond', 2943476, 'M', 19, 78, 183, '1995/01/05', 10);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (149, 'Carlen', 6191341, 'M', 20, 70, 172, '1992/04/01', 10);
-- equipo 11
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (150, 'Pepe', 4933600, 'M', 21, 81, 200, '1998/09/18', 11);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (151, 'Lisa', 3715661, 'M', 7, 68, 179, '1995/06/10', 11);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (152, 'Demetria', 5003722, 'M', 8, 76, 177, '1997/06/01', 11);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (153, 'Jone', 8898601, 'M', 1, 68, 193, '1994/01/22', 11);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (154, 'Tabatha', 6389764, 'M', 19, 75, 164, '1992/07/23', 11);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (155, 'Eran', 7981373, 'M', 10, 79, 192, '1990/01/04', 11);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (156, 'Kippie', 4299767, 'M', 9, 77, 178, '1991/01/28', 11);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (157, 'Clint', 2529978, 'M', 20, 69, 166, '1997/04/03', 11);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (158, 'Butch', 3712076, 'M', 4, 84, 182, '1990/07/08', 11);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (159, 'Theresina', 4644241, 'M', 28, 62, 169, '1991/04/01', 11);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (160, 'Kerwin', 2707247, 'M', 1, 70, 160, '2000/07/20', 11);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (161, 'Lemuel', 1739925, 'M', 9, 69, 182, '2000/08/22', 11);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (162, 'Cad', 4728672, 'M', 23, 77, 175, '1990/11/05', 11);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (163, 'Ameline', 1443894, 'M', 4, 77, 200, '1995/09/09', 11);
-- equipo 12
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (164, 'Alfredo', 3941772, 'M', 17, 86, 168, '1993/12/08', 12);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (165, 'Kellsie', 1271647, 'M', 30, 68, 187, '1992/01/04', 12);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (166, 'Bradney', 5030393, 'M', 28, 72, 176, '1995/12/28', 12);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (167, 'Adeline', 7806292, 'M', 26, 87, 187, '1998/10/10', 12);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (168, 'Ede', 5017035, 'M', 16, 78, 172, '1996/02/05', 12);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (169, 'Ofilia', 4735314, 'M', 6, 84, 166, '1992/03/09', 12);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (170, 'Glynnis', 7509129, 'M', 14, 72, 188, '1992/07/21', 12);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (171, 'Dur', 4555840, 'M', 7, 79, 172, '1996/05/21', 12);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (172, 'Gayel', 3702993, 'M', 2, 73, 183, '1997/03/12', 12);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (173, 'Jasen', 7059683, 'M', 23, 80, 188, '1997/10/12', 12);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (174, 'Shanon', 7910022, 'M', 13, 62, 161, '1995/06/03', 12);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (175, 'Reinhard', 3533990, 'M', 6, 88, 180, '1995/06/17', 12);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (176, 'Somerset', 3204496, 'M', 16, 85, 175, '2000/02/26', 12);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (177, 'Cleve', 8738959, 'M', 6, 73, 161, '1999/01/25', 12);
-- equipo 13
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (178, 'Korry', 1965942, 'M', 5, 68, 179, '1996/03/04', 13);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (179, 'Barbette', 7935773, 'M', 28, 63, 184, '1990/10/17', 13);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (180, 'Charlie', 2593211, 'M', 1, 64, 185, '1992/02/06', 13);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (181, 'Sam', 4551606, 'M', 17, 87, 173, '1999/03/13', 13);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (182, 'Franciska', 3026930, 'M', 18, 85, 182, '1992/07/31', 13);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (183, 'Rurik', 6490844, 'M', 29, 63, 188, '1990/02/28', 13);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (184, 'Romona', 2267103, 'M', 28, 68, 187, '1999/05/17', 13);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (185, 'Tressa', 6060250, 'M', 7, 88, 179, '1993/01/11', 13);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (186, 'Donielle', 3359502, 'M', 3, 63, 176, '1997/01/02', 13);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (187, 'Grange', 2730601, 'M', 18, 76, 195, '1993/12/21', 13);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (188, 'Nara', 5791318, 'M', 1, 79, 188, '1994/06/13', 13);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (189, 'Marcos', 5201021, 'M', 3, 66, 171, '1995/11/02', 13);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (190, 'Tiler', 3036522, 'M', 18, 71, 174, '1993/04/17', 13);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (191, 'Mike', 1769830, 'M', 11, 77, 163, '1994/03/18', 13);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (192, 'Clifford', 3882288, 'M', 20, 77, 191, '1995/05/17', 13);
-- equipo 14
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (193, 'Yehudit', 5389904, 'M', 10, 85, 200, '1993/01/23', 14);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (194, 'Pace', 2018182, 'M', 22, 79, 181, '2000/02/28', 14);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (195, 'Alasdair', 3097452, 'M', 19, 87, 181, '1995/03/11', 14);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (196, 'Mano', 2700996, 'M', 19, 80, 188, '1995/05/29', 14);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (197, 'Pete', 4658648, 'M', 20, 83, 176, '1991/12/24', 14);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (198, 'Johnathan', 8135852, 'M', 14, 80, 165, '1994/07/27', 14);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (199, 'Noel', 3938564, 'M', 9, 64, 171, '1994/10/28', 14);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (200, 'Vic', 4111073, 'M', 3, 84, 180, '1990/09/01', 14);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (201, 'Alfredo', 5199822, 'M', 27, 71, 163, '1996/04/27', 14);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (202, 'Putnem', 5968686, 'M', 1, 65, 191, '1990/06/05', 14);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (203, 'Jonah', 3733281, 'M', 27, 61, 182, '2000/06/07', 14);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (204, 'Camile', 7211712, 'M', 9, 68, 161, '2000/10/30', 14);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (205, 'Archy', 6837053, 'M', 23, 65, 172, '1991/10/06',14);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (206, 'Babara', 7021368, 'M', 22, 77, 166, '1994/01/26',14);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (207, 'Reginald', 2849176, 'M', 23, 90, 167, '1999/12/25',14);
-- equipo 15
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (208, 'Julieta', 1549707, 'M', 7, 70, 188, '1992/12/13',15);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (209, 'Justino', 8535651, 'M', 1, 70, 190, '1999/08/29',15);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (210, 'Fanechka', 1271597, 'M', 2, 75, 168, '1991/12/25',15);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (211, 'Stanislaw', 6857454, 'M', 15, 85, 166, '1991/05/11',15);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (212, 'Charity', 7345378, 'M', 24, 80, 187, '1994/03/08',15);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (213, 'Fionnula', 6100705, 'M', 10, 85, 161, '1992/02/13',15);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (214, 'Dud', 5567822, 'M', 16, 88, 193, '1991/01/13', 15);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (215, 'Johnathan', 4877481, 'M', 10, 70, 198, '1998/04/27', 15);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (216, 'Latrena', 8782920, 'M', 17, 65, 176, '1996/02/09', 15);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (217, 'Ros', 3159210, 'M', 6, 67, 195, '1990/05/03', 15);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (218, 'Riva', 7460457, 'M', 26, 76, 168, '1994/07/05', 15);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (219, 'Joline', 1983914, 'M', 8, 87, 167, '1990/09/30', 15);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (220, 'Julita', 6622031, 'M', 22, 67, 178, '1993/01/22', 15);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (221, 'Concordia', 2081775, 'M', 10, 68, 171, '1999/11/01', 15);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (222, 'Cilka', 5118621, 'M', 19, 84, 197, '1993/06/20', 15);
-- equipo 16
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (223, 'Sascha', 7835438, 'M', 8, 82, 173, '1990/05/30', 16);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (224, 'Urbanus', 2772787, 'M', 9, 87, 189, '1996/04/03', 16);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (225, 'Piggy', 8573577, 'M', 11, 69, 195, '1998/03/21', 16);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (226, 'Inessa', 1996609, 'M', 25, 74, 168, '2000/06/17', 16);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (227, 'Zak', 6498362, 'M', 25, 62, 191, '1998/03/12', 16);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (228, 'Karissa', 4078111, 'M', 9, 79, 173, '1995/08/09', 16);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (229, 'Rebe', 8266473, 'M', 29, 88, 196, '2000/06/30', 16);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (230, 'Hamlen', 5175296, 'M', 21, 65, 183, '1997/11/15', 16);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (231, 'Riki', 8210854, 'M', 21, 83, 186, '1991/12/26', 16);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (232, 'Leta', 4714922, 'M', 26, 72, 198, '1999/05/10', 16);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (233, 'Antons', 2455465, 'M', 1, 63, 190, '2000/06/22', 16);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (234, 'Kirsteni', 3792198, 'M', 2, 81, 184, '1997/03/17', 16);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (235, 'George', 2273694, 'M', 5, 67, 197, '1997/11/12', 16);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (236, 'Vivi', 6568883, 'M', 6, 82, 176, '1993/07/24', 16);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (237, 'Wyatan', 1773649, 'M', 9, 83, 177, '1990/08/24', 16);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (238, 'Messi', 2273694, 'M', 5, 67, 197, '1997/11/12', 16);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (239, 'Cristiano Ronaldo', 6568883, 'M', 6, 82, 176, '1993/07/24', 16);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (240, 'Vinicius Jr', 1773649, 'M', 9, 83, 177, '1990/08/24', 16);


insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (3, 1, 'Mediocampista', 2, 1, null, null, 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (20, 1, 'Delantero', 1, 2, null, null, 78);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (3, 2, 'Mediocampista', 3, 0, 64, 'Amarilla', 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (20, 2, 'Delantero', 2, 0, 67, 'Roja', 67);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (38, 3, 'Delantero', 1, 0, null, null, 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (58, 3, 'Defensor', 0, 1, 80, null, 75);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (38, 4, 'Delantero', 3, 0, null, null, 71);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (58, 4, 'Defensor', 1, 0, 79, null, 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (72, 5, 'Mediocampista', 0, 0, null, null, 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (83, 5, 'Delantero', 0, 1, null, 'Amarilla', 80);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (72, 6, 'Mediocampista', 1, 0, null, null, 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (83, 6, 'Delantero', 0, 1, 91, 'Roja', 91);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (100, 7, 'Delantero', 2, 0, 91, null, 91);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (105, 7, 'Mediocampista', 3, 2, 50, 'Amarilla', 60);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (100, 8, 'Delantero', 1, 1, 80, 'Amarilla', 75);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (105, 8, 'Mediocampista', 2, 0, null, null, 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (127, 9, 'Delantero', 1, 1, null, null, 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (140, 9, 'Delantero', 0, 1, 80, 'Amarilla', 75);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (127, 10, 'Delantero', 2, 1, 50, 'Amarilla', 60);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (140, 10, 'Delantero', 0, 1, 45, 'Amarilla', 80);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (160, 11, 'Delantero', 2, 2, null, null, 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (170, 11, 'Mediocampista', 0, 0, null, null, 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (160, 12, 'Delantero', 1, 1, null, null, 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (170, 12, 'Mediocampista', 0, 1, null, null, 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (190, 13, 'Mediocampista', 0, 1, null, null, 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (200, 13, 'Delantero', 0, 0, null, null, 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (190, 14, 'Mediocampista', 1, 2, 69, 'Amarilla', 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (200, 14, 'Delantero', 2, 1, null, null, 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (218, 15, 'Delantero', 1, 2, null, null, 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (240, 15, 'Delantero', 1, 2, null, null, 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (218, 16, 'Delantero', 1, 2, 91, 'Roja', 91);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (240, 16, 'Delantero', 2, 0, 50, 'Amarilla', 90);

insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (3, 17, 'Mediocampista', 0, 1, 91, null, 91);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (38, 17, 'Delantero', 1, 2, null, null, 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (3, 18, 'Mediocampista', 2, 2, 75, 'Amarilla', 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (38, 18, 'Delantero', 3, 3, 45, 'Amarilla', 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (72, 19, 'Mediocampista', 1, 1, 50, 'Amarilla', 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (105, 19, 'Mediocampista', 2, 0, null, null, 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (72, 20, 'Mediocampista', 0, 1, null, null, 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (105, 20, 'Mediocampista', 1, 2, null, null, 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (127, 21, 'Delantero', 1, 3, null, null, 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (160, 21, 'Delantero', 0, 0,  91, 'Roja', 91);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (127, 22, 'Delantero', 2, 1, 45, 'Amarilla', 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (160, 22, 'Delantero', 2, 0, 15, 'Amarilla', 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (200, 23, 'Delantero', 2, 2, 10, 'Amarilla', 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (240, 23, 'Delantero', 0, 3, 90, 'Amarilla', 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (200, 24, 'Delantero', 3, 2, null, null, 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (240, 24, 'Delantero', 1, 0, null, null, 90);


insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (38, 25, 'Delantero', 0, 1, null, null, 65);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (105, 25, 'Mediocampista', 1, 2, null, null, 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (38, 26, 'Delantero', 0, 0, 63, 'Amarilla', 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (105, 26, 'Mediocampista', 1, 1, 74, 'Amarilla', 62);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (127, 27, 'Delantero', 0, 1, null, null, 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (200, 27, 'Delantero', 0, 2, null, null, 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (127, 28, 'Delantero', 0, 1, 80, null, 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (200, 28, 'Delantero', 1, 0, 21, 'Amarilla', 70);


insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (105, 29, 'Mediocampista', 0, 3, 86, 'Amarilla', 90);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (200, 29, 'Delantero', 1, 0, 69, 'Roja', 90);