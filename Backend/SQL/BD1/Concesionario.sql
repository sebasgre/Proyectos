CREATE DATABASE concesionario;
USE concesionario;
CREATE TABLE Clientes (
    ciID INT PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    apellido VARCHAR(20) NOT NULL,
    telf INT NOT NULL,
    direccion VARCHAR(20)
);
CREATE TABLE Autos (
    matriculaID INT PRIMARY KEY NOT NULL,
    clienteID INT,
    marca VARCHAR(20) NOT NULL,
    modelo VARCHAR(20) NOT NULL,
    tipo BOOLEAN,
    color VARCHAR(20),
    kilometraje INT
);
CREATE TABLE Mecanicos (
    ciID INT PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    apellido VARCHAR(20) NOT NULL,
    salario INT,
    dtContrato DATE
);
CREATE TABLE Repara (
    matriculaID INT,
    mecanicoID INT,
    dtReparacion DATE,
    horas INT,
    PRIMARY KEY(matriculaID, mecanicoID)
);
CREATE TABLE Respuestos (
    matriculaID INT,
    mecanicoID INT,
    respuesto INT,
    PRIMARY KEY(matriculaID, mecanicoID, respuesto)
);
ALTER TABLE Autos
ADD FOREIGN KEY(clienteID) REFERENCES Clientes(ciID);
ALTER TABLE Repara
ADD FOREIGN KEY(matriculaID) REFERENCES Autos(matriculaID);
ALTER TABLE Repara
ADD FOREIGN KEY(mecanicoID) REFERENCES Mecanicos(ciID);
ALTER TABLE Respuestos
ADD FOREIGN KEY(matriculaID, mecanicoID) REFERENCES Repara(matriculaID, mecanicoID);
INSERT INTO clientes
VALUES(
        12845531,
        'Zinedine',
        'Zidane',
        445556689,
        'Palmasola'
    );
INSERT INTO clientes
VALUES(
        12805530,
        'Mayte',
        'Flores',
        78756689,
        'Alto San Pedro'
    );
INSERT INTO clientes
VALUES(
        5085100,
        'Freddy',
        'Mercury',
        124657567,
        'Chonchocoro'
    );
INSERT INTO clientes
VALUES(
        1231243,
        'David',
        'Guetta',
        456456,
        'Los Pozitos'
    );
INSERT INTO clientes
VALUES(5560100, 'Steve', 'Aoki', 8946100, 'Plan 4000');
INSERT INTO autos
VALUES(
        1313,
        12845531,
        'Audi',
        'Batimóvil',
        1,
        'Negro',
        12333
    );
INSERT INTO autos
VALUES(
        1212,
        12805530,
        'Toyota',
        'Corolla',
        3,
        'Despintado',
        000333
    );
INSERT INTO autos
VALUES(
        1111,
        5085100,
        'Jeep',
        'AX56S',
        6,
        'Camuflado',
        01134
    );
INSERT INTO autos
VALUES(
        0101,
        1231243,
        'Roll Royce',
        'El Último',
        0,
        'Gris',
        909087
    );
INSERT INTO autos
VALUES(1001, 5560100, 'BMW', 'Q7', 8, 'Rosado', 4355);
INSERT INTO mecanicos
VALUES(001, 'El Crack', 'Me Dicen', 100, '20001001');
INSERT INTO mecanicos
VALUES(002, 'Yony', 'Fernandes', 99, '20001010');
INSERT INTO mecanicos
VALUES(003, 'El Bicho', 'Soy Yo', 10, '20021001');
INSERT INTO mecanicos
VALUES(004, 'San', 'Piwi', 8, '19911001');
INSERT INTO mecanicos
VALUES(005, 'Piter', 'Pan', 1001, '20001001');
INSERT INTO repara
VALUES(101, 1, null, 10);
INSERT INTO repara
VALUES(1001, 2, null, 100);
INSERT INTO repara
VALUES(1111, 3, null, 10009);
INSERT INTO repara
VALUES(1212, 4, null, 4);
INSERT INTO repara
VALUES(1313, 5, null, 32);
INSERT INTO respuestos
VALUES(101, 1, 3);
INSERT INTO respuestos
VALUES(1001, 2, 13);
INSERT INTO respuestos
VALUES(1111, 3, 32);
INSERT INTO respuestos
VALUES(1212, 4, 4);
INSERT INTO respuestos
VALUES(1313, 5, 33);
select *
from autos;
UPDATE Autos
SET tipo = 1
WHERE kilometraje IS NOT NULL
    AND kilometraje > 0;
DELETE FROM Repara
WHERE matriculaID = 1001;
DELETE FROM Autos
WHERE color = 'rosado';
select *
from autos;
SELECT nombre,
    salario *
FROM mecanicos;