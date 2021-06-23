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
insert into directoresAdmins (dni, nombre) values (4, 'Erhard');
insert into directoresAdmins (dni, nombre) values (5, 'Violetta');


insert into etapas (numEtapa, nombreEtapa, directoresAdmins_id) values (1, 'Adair', null);
insert into etapas (numEtapa, nombreEtapa, directoresAdmins_id) values (2, 'Agathe', null);
insert into etapas (numEtapa, nombreEtapa, directoresAdmins_id) values (3, 'Jolene', null);
insert into etapas (numEtapa, nombreEtapa, directoresAdmins_id) values (4, 'Jonie', null);
insert into etapas (numEtapa, nombreEtapa, directoresAdmins_id) values (5, 'Rowe', null);

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

insert into equipos (codigo, nombre, pais, presidente_id, directoresTecnicos_id) values (1, 'Warden', 'Elenore', null, null);
insert into equipos (codigo, nombre, pais, presidente_id, directoresTecnicos_id) values (2, 'Deeann', 'Dasha', null, null);
insert into equipos (codigo, nombre, pais, presidente_id, directoresTecnicos_id) values (3, 'Antonie', 'Joseph', null, null);
insert into equipos (codigo, nombre, pais, presidente_id, directoresTecnicos_id) values (4, 'Sunny', 'Zia', null, null);
insert into equipos (codigo, nombre, pais, presidente_id, directoresTecnicos_id) values (5, 'Vallie', 'Cornela', null, null);
insert into equipos (codigo, nombre, pais, presidente_id, directoresTecnicos_id) values (6, 'Germaine', 'Shea', null, null);
insert into equipos (codigo, nombre, pais, presidente_id, directoresTecnicos_id) values (7, 'Rafferty', 'Britt', null, null);
insert into equipos (codigo, nombre, pais, presidente_id, directoresTecnicos_id) values (8, 'Avrom', 'Joachim', null, null);
insert into equipos (codigo, nombre, pais, presidente_id, directoresTecnicos_id) values (9, 'Harriett', 'Rory', null, null);
insert into equipos (codigo, nombre, pais, presidente_id, directoresTecnicos_id) values (10, 'Jaymee', 'Hakim', null, null);
insert into equipos (codigo, nombre, pais, presidente_id, directoresTecnicos_id) values (11, 'Homerus', 'Giselbert', null, null);
insert into equipos (codigo, nombre, pais, presidente_id, directoresTecnicos_id) values (12, 'Jessalyn', 'Essie', null, null);
insert into equipos (codigo, nombre, pais, presidente_id, directoresTecnicos_id) values (13, 'Isobel', 'Rubetta', null, null);
insert into equipos (codigo, nombre, pais, presidente_id, directoresTecnicos_id) values (14, 'Lorry', 'Terry', null, null);
insert into equipos (codigo, nombre, pais, presidente_id, directoresTecnicos_id) values (15, 'Freddi', 'Skylar', null, null);
insert into equipos (codigo, nombre, pais, presidente_id, directoresTecnicos_id) values (16, 'Dotti', 'Gaylord', null, null);

insert into arbitros (dni, nombre, sueldo, sexo, f_nacimiento, equipos_id) values (1, 'Mirella', 8932, 'M', '1991-07-26', null);
insert into arbitros (dni, nombre, sueldo, sexo, f_nacimiento, equipos_id) values (2, 'Keven', 8201, 'M', '1993-10-10', null);
insert into arbitros (dni, nombre, sueldo, sexo, f_nacimiento, equipos_id) values (3, 'Normand', 8603, 'M', '1997-04-20', null);
insert into arbitros (dni, nombre, sueldo, sexo, f_nacimiento, equipos_id) values (4, 'Bradly', 9037, 'M', '1997-10-28', null);
insert into arbitros (dni, nombre, sueldo, sexo, f_nacimiento, equipos_id) values (5, 'Zollie', 9347, 'M', '1994-03-02', null);
insert into arbitros (dni, nombre, sueldo, sexo, f_nacimiento, equipos_id) values (6, 'Talbert', 8546, 'M', '1998-07-25', null);
insert into arbitros (dni, nombre, sueldo, sexo, f_nacimiento, equipos_id) values (7, 'Royall', 9850, 'M', '1995-05-07', null);
insert into arbitros (dni, nombre, sueldo, sexo, f_nacimiento, equipos_id) values (8, 'Vaughan', 9765, 'M', '1999-04-16', null);

insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (1, 'Rosalie', 1293955, 'M', 17, 64.5, 166.2, '1995-09-19', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (2, 'Rivkah', 4305819, 'M', 26, 63.9, 154.9, '1991-10-07', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (3, 'York', 2668690, 'M', 24, 87.3, 184.5, '1993-10-22', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (4, 'Gretna', 9271759, 'M', 25, 86.1, 199.9, '1996-05-10', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (5, 'Kassie', 6854832, 'M', 14, 80.2, 164.0, '1999-08-21', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (6, 'Leonora', 3679253, 'M', 17, 75.6, 179.9, '1999-06-05', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (7, 'Forrester', 7645901, 'M', 28, 69.1, 178.1, '1999-03-10', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (8, 'Kristen', 9354040, 'M', 8, 80.8, 158.4, '1996-01-20', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (9, 'Florence', 4383135, 'M', 8, 72.9, 191.6, '1999-01-15', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (10, 'Hermione', 4837365, 'M', 20, 82.8, 198.8, '1999-05-18', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (11, 'Claresta', 4604525, 'M', 13, 62.5, 188.0, '1999-08-08', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (12, 'Kristoforo', 4604469, 'M', 20, 78.0, 186.7, '1991-07-29', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (13, 'Wernher', 6127401, 'M', 26, 73.8, 170.9, '1994-11-11', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (14, 'Colline', 1215840, 'M', 17, 62.8, 163.1, '1999-08-30', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (15, 'Blayne', 2552040, 'M', 13, 69.2, 196.2, '1991-01-04', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (16, 'Berty', 3475432, 'M', 10, 75.1, 185.4, '1995-01-27', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (17, 'Sigismundo', 7018964, 'M', 30, 63.4, 174.0, '1990-05-15', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (18, 'Lothaire', 3275881, 'M', 1, 66.4, 195.8, '1995-02-17', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (19, 'Ana', 9725884, 'M', 27, 79.2, 157.0, '1991-11-20', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (20, 'Wilt', 2338065, 'M', 2, 78.0, 187.1, '1995-10-16', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (21, 'Dorri', 9658256, 'M', 7, 85.3, 166.5, '1992-03-20', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (22, 'Cariotta', 5272060, 'M', 19, 77.8, 191.4, '1993-05-11', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (23, 'Chelsy', 9416618, 'M', 13, 62.4, 174.0, '1990-01-30', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (24, 'Avigdor', 8453259, 'M', 11, 61.5, 187.4, '1992-06-19', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (25, 'Gretchen', 6612835, 'M', 28, 64.2, 171.1, '1990-09-17', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (26, 'Silvana', 3002687, 'M', 15, 67.8, 160.6, '1993-10-13', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (27, 'Eula', 7684537, 'M', 14, 73.9, 190.4, '1991-02-23', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (28, 'Fabian', 9478098, 'M', 16, 89.9, 180.1, '1998-09-29', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (29, 'Kara', 7277061, 'M', 9, 86.5, 197.6, '1992-07-06', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (30, 'Haily', 3495027, 'M', 20, 65.1, 180.6, '1993-10-27', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (31, 'Patrizio', 3710870, 'M', 18, 87.0, 199.2, '1993-02-08', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (32, 'Roz', 6165636, 'M', 7, 63.3, 152.6, '1990-11-17', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (33, 'Bren', 5121177, 'M', 5, 78.3, 161.5, '1990-06-12', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (34, 'Kaleb', 4855859, 'M', 29, 71.3, 192.2, '1995-07-15', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (35, 'Eve', 6351281, 'M', 2, 87.8, 168.4, '1998-10-12', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (36, 'Rianon', 1781998, 'M', 13, 76.9, 182.6, '1992-06-14', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (37, 'Darcie', 8436901, 'M', 12, 71.5, 185.7, '1990-10-10', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (38, 'Huey', 1821560, 'M', 11, 82.4, 156.9, '1993-03-07', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (39, 'Lydon', 7173175, 'M', 15, 73.4, 150.7, '1991-11-01', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (40, 'Beaufort', 5728383, 'M', 18, 86.3, 189.9, '1994-06-03', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (41, 'Petr', 2283821, 'M', 3, 65.2, 192.5, '1990-04-18', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (42, 'Eda', 221297, 'M', 10, 63.0, 181.1, '1991-03-29', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (43, 'Delphine', 1241176, 'M', 22, 86.8, 199.5, '1995-12-11', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (44, 'Kippy', 3703198, 'M', 18, 74.3, 187.0, '1997-11-23', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (45, 'Clair', 7864388, 'M', 20, 75.2, 196.6, '1993-03-02', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (46, 'Jorrie', 5863369, 'M', 15, 83.5, 172.4, '1997-06-03', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (47, 'Reggie', 8084121, 'M', 24, 80.9, 166.0, '1998-11-09', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (48, 'Basile', 1903738, 'M', 26, 82.0, 188.0, '1996-09-30', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (49, 'Vail', 6823484, 'M', 2, 76.3, 152.0, '1991-05-12', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (50, 'Rudiger', 5494943, 'M', 7, 78.5, 171.9, '1999-09-04', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (51, 'Kerrin', 6402765, 'M', 20, 65.0, 177.4, '1996-09-06', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (52, 'Gustaf', 6980431, 'M', 30, 70.8, 195.7, '1990-11-28', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (53, 'Murial', 1540782, 'M', 5, 64.9, 159.1, '1994-06-10', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (54, 'Mariska', 5456387, 'M', 5, 84.8, 157.2, '1999-05-25', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (55, 'Kristofer', 1999399, 'M', 10, 63.2, 156.7, '1994-02-03', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (56, 'Stanly', 2292253, 'M', 27, 72.5, 191.9, '1998-05-12', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (57, 'Ade', 8266236, 'M', 18, 73.8, 199.9, '1999-07-19', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (58, 'Lauri', 5162770, 'M', 10, 83.5, 181.9, '1990-08-05', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (59, 'Janie', 7500562, 'M', 26, 70.0, 181.5, '1995-01-16', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (60, 'Jennine', 7572236, 'M', 15, 85.1, 181.4, '1994-01-11', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (61, 'Tye', 9829100, 'M', 23, 63.9, 187.7, '1995-05-21', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (62, 'Winni', 5661124, 'M', 9, 86.8, 180.6, '1993-05-26', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (63, 'Cherlyn', 9502733, 'M', 8, 89.4, 159.4, '1992-02-03', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (64, 'Loni', 6203588, 'M', 25, 81.2, 162.1, '1990-08-09', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (65, 'Bunnie', 6496518, 'M', 5, 61.8, 192.7, '1998-05-05', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (66, 'Magdalene', 3685105, 'M', 23, 73.1, 162.7, '1992-03-24', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (67, 'Vasily', 698718, 'M', 11, 70.2, 169.0, '1998-09-26', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (68, 'Ferdinande', 8616613, 'M', 4, 86.6, 179.4, '1994-04-24', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (69, 'Abbey', 1381406, 'M', 11, 80.4, 171.2, '1992-04-21', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (70, 'Lyda', 9019835, 'M', 14, 67.1, 179.1, '1991-11-06', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (71, 'Issie', 3330626, 'M', 15, 61.8, 193.8, '1999-10-09', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (72, 'Andre', 9880473, 'M', 15, 65.3, 184.0, '1997-08-26', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (73, 'Bethena', 1008271, 'M', 3, 79.2, 173.6, '1991-07-14', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (74, 'Doralin', 7733951, 'M', 2, 86.4, 169.6, '1994-06-12', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (75, 'Aggi', 9120558, 'M', 9, 88.8, 180.1, '1999-03-23', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (76, 'Rivkah', 601710, 'M', 26, 74.8, 194.1, '1995-09-28', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (77, 'Mollie', 6100573, 'M', 12, 64.8, 195.3, '1992-12-09', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (78, 'Corinne', 5606758, 'M', 4, 61.2, 175.3, '1997-11-27', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (79, 'Amelia', 8777318, 'M', 13, 89.1, 167.0, '1999-07-18', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (80, 'Keefer', 5517725, 'M', 25, 73.1, 186.9, '1997-09-21', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (81, 'Art', 9186137, 'M', 18, 60.8, 173.1, '1995-06-08', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (82, 'Patty', 2057756, 'M', 9, 86.1, 181.0, '1999-02-02', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (83, 'Onfre', 8414628, 'M', 11, 68.7, 178.0, '1998-01-14', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (84, 'Eddie', 7856384, 'M', 6, 70.2, 164.7, '1994-08-14', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (85, 'Alikee', 1585137, 'M', 26, 88.7, 166.7, '1992-02-17', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (86, 'Briney', 7098829, 'M', 25, 70.5, 186.2, '1994-09-03', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (87, 'Larissa', 9491158, 'M', 27, 80.8, 199.0, '1997-08-31', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (88, 'Henderson', 5483477, 'M', 7, 74.1, 168.6, '1999-11-21', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (89, 'Inglis', 2677482, 'M', 5, 60.7, 179.3, '1998-04-23', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (90, 'Neall', 4831150, 'M', 9, 78.7, 179.5, '1990-06-26', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (91, 'Jacques', 2458486, 'M', 4, 80.9, 157.7, '1990-11-15', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (92, 'Lauraine', 6631248, 'M', 28, 83.6, 166.4, '1991-03-02', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (93, 'Garvy', 2442847, 'M', 16, 71.6, 190.3, '1992-07-26', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (94, 'Portie', 5515178, 'M', 29, 89.7, 195.5, '1993-08-08', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (95, 'Adan', 6782579, 'M', 24, 82.9, 157.8, '1992-07-10', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (96, 'Molli', 2188098, 'M', 11, 61.5, 150.6, '1998-08-07', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (97, 'Jon', 5544482, 'M', 2, 66.1, 186.9, '1994-07-04', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (98, 'Jud', 7103161, 'M', 30, 65.9, 163.6, '1997-07-26', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (99, 'Charles', 2711656, 'M', 9, 68.5, 151.8, '1995-12-25', null);
insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, peso, altura, f_nacimiento, equipos_id) values (100, 'Tate', 2700070, 'M', 15, 78.9, 157.7, '1995-12-29', null);

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

insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (1, '2021-01-22', null, null, null);
insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (2, '2021-01-29', null, null, null);
insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (3, '2021-01-27', null, null, null);
insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (4, '2021-01-27', null, null, null);
insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (5, '2021-01-28', null, null, null);
insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (6, '2021-01-06', null, null, null);
insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (7, '2021-01-15', null, null, null);
insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (8, '2021-02-01', null, null, null);
insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (9, '2021-01-08', null, null, null);
insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (10, '2021-01-09', null, null, null);
insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (11, '2021-01-26', null, null, null);
insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (12, '2021-01-11', null, null, null);
insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (13, '2021-01-30', null, null, null);
insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (14, '2021-02-02', null, null, null);
insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (15, '2021-01-11', null, null, null);
insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (16, '2021-01-29', null, null, null);
insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (17, '2021-01-17', null, null, null);
insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (18, '2021-01-12', null, null, null);
insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (19, '2021-01-22', null, null, null);
insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values (20, '2021-01-19', null, null, null);

insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (null, null, null);
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (null, null, null);
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (null, null, null);
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (null, null, null);
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (null, null, null);
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (null, null, null);
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (null, null, null);
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (null, null, null);
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (null, null, null);
insert into partidosArbitros (partidos_id, arbitros_id, rolPartido) values (null, null, null);

insert into clasifican (equipos_id, etapas_id, fecha) values (null, null, '2022-04-21');
insert into clasifican (equipos_id, etapas_id, fecha) values (null, null, '2021-03-02');
insert into clasifican (equipos_id, etapas_id, fecha) values (null, null, '2021-08-19');
insert into clasifican (equipos_id, etapas_id, fecha) values (null, null, '2021-05-13');
insert into clasifican (equipos_id, etapas_id, fecha) values (null, null, '2021-03-21');
insert into clasifican (equipos_id, etapas_id, fecha) values (null, null, '2022-04-25');
insert into clasifican (equipos_id, etapas_id, fecha) values (null, null, '2021-09-21');
insert into clasifican (equipos_id, etapas_id, fecha) values (null, null, '2021-10-25');

insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (null, null, 'Filmore', 2, 1, null, null, null);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (null, null, 'Banky', 2, 1, null, null, null);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (null, null, 'Fairfax', 3, 1, null, null, null);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (null, null, 'Iorgos', 3, 2, null, null, null);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (null, null, 'Gustav', 1, 1, null, null, null);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (null, null, 'Gerik', 1, 1, 25, null, null);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (null, null, 'Byrom', 3, 2, null, null, null);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (null, null, 'Lemuel', 3, 2, null, null, null);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (null, null, 'Shawn', 3, 2, 11, null, null);
insert into tipoRegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values (null, null, 'Alvan', 2, 2, null, null, null);