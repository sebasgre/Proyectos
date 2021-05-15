CREATE DATABASE biblioteca;
USE biblioteca;

CREATE TABLE libros (
    isbnID INT PRIMARY KEY,
    encuadernacion VARCHAR(20),
    idioma VARCHAR (20),
    titulo VARCHAR (20),
    area VARCHAR (20),
    edicion INT NOT NULL,
    autor VARCHAR (20) NOT NULL
);

CREATE TABLE descriptoresLibros (
    isbnID INT,
    descriptor VARCHAR (200),
    PRIMARY KEY (isbnID, descriptor)
);

CREATE TABLE ejemplares (
    codigoEjemplares INT PRIMARY KEY,
    isbnID INT,
    numero INT,
    tipo VARCHAR(20)
);

CREATE TABLE bibliotecarios (
    codigoBibliotecarios INT PRIMARY KEY,
    nombre VARCHAR (20),
    tipo VARCHAR (20),
    telefono VARCHAR (20),
    direccion VARCHAR (20)
);

CREATE TABLE miembros (
    dni INT PRIMARY KEY,
    nroTarjeta INT NOT NULL,
    fechaVencimiento DATE,
    foto VARCHAR (200),
    email VARCHAR (50),
    codigoPostal INT
);

CREATE TABLE peticiones (
    isbnID INT,
    dni INT,
    fecha DATE,
    PRIMARY KEY (isbnID, dni)
);

CREATE TABLE telefonosMiembros (
    dni INT,
    telefono VARCHAR (20),
    PRIMARY KEY (dni, telefono)
);

CREATE TABLE prestamo (
    isbnID INT,
    codigoEjemplares INT,
    codigoBibliotecarios INT,
    dni INT,
    fechaPrestamo DATE,
    fechaDevolucion DATE,
    PRIMARY KEY (isbnID, codigoEjemplares, codigoBibliotecarios, dni)
);

CREATE TABLE centroEstudio (
    codigoEstudio INT PRIMARY KEY,
    nombre VARCHAR (20),
    direccion VARCHAR (50)
);

CREATE TABLE profesor (
    profesorID INT,
    dni INT,
    codigoEstudio INT,
    PRIMARY KEY (profesorID, dni)
);

ALTER TABLE descriptoresLibros ADD FOREIGN KEY (isbnID) REFERENCES libros (isbnID);
ALTER TABLE ejemplares ADD FOREIGN KEY (isbnID) REFERENCES libros (isbnID);
ALTER TABLE peticiones ADD FOREIGN KEY (isbnID) REFERENCES libros (isbnID);
ALTER TABLE peticiones ADD FOREIGN KEY (dni) REFERENCES miembros (dni);
ALTER TABLE telefonosMiembros ADD FOREIGN KEY (dni) REFERENCES miembros (dni);
ALTER TABLE prestamo ADD FOREIGN KEY (isbnID, codigoEjemplares) REFERENCES ejemplares (isbnID, codigoEjemplares);
ALTER TABLE prestamo ADD FOREIGN KEY (codigoBibliotecarios) REFERENCES bibliotecarios (codigoBibliotecarios);
ALTER TABLE prestamo ADD FOREIGN KEY (dni) REFERENCES miembros (dni);
ALTER TABLE profesor ADD FOREIGN KEY (codigoEstudio) REFERENCES centroEstudio (codigoEstudio);
ALTER TABLE profesor ADD FOREIGN KEY (dni) REFERENCES miembros (dni);
-- SHOW TABLES;







