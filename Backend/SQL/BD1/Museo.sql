CREATE DATABASE museo;
USE museo;

CREATE TABLE paises (
    nombrePaises VARCHAR (20) PRIMARY KEY
);

CREATE TABLE epocas (
    nombreEpoca VARCHAR (20) PRIMARY KEY,
    anoInicio DATE NOT NULL,
    anoFIN DATE NOT NULL
);

CREATE TABLE colecciones (
    coleccionID INT PRIMARY KEY
);

CREATE TABLE objetosArte (
    id INT PRIMARY KEY,
    coleccionID INT,
    nombreEpoca VARCHAR (20),
    nombrePaises VARCHAR (20),
    anoCreacion INT NOT NULL,
    titulo VARCHAR (20) NOT NULL,
    descripcion VARCHAR (100)
);

CREATE TABLE artistas (
    artistaID INT PRIMARY KEY,
    nombreArtista VARCHAR (20),
    nombrePaises VARCHAR (20),
    descripcionArtista VARCHAR (100),
    estilo VARCHAR (20),
    fechaNac DATE,
    fechaFalle DATE
);

CREATE TABLE crea (
    id INT,
    artistaID INT,
    participacion VARCHAR (20),
    PRIMARY KEY (id, artistaID)
);

CREATE TABLE pintura (
    pinturaID INT,
    id INT,
    tipo VARCHAR (200),
    estilo VARCHAR (200),
    material VARCHAR (20),
    PRIMARY KEY (pinturaID, id)
);

CREATE TABLE escultura (
    esculturaID INT,
    id INT,
    ancho DECIMAL,
    alto DECIMAL,
    estilo VARCHAR (200),
    material VARCHAR (20),
    PRIMARY KEY (esculturaID, id)
);

CREATE TABLE monumento (
    monumento INT,
    id INT,
    ancho DECIMAL,
    alto DECIMAL,
    estilo VARCHAR (200),
    material VARCHAR (20),
    PRIMARY KEY (monumento, id)
);

CREATE TABLE otro (
    otro INT,
    id INT,
    tipo VARCHAR (200),
    estilo VARCHAR (200),
    PRIMARY KEY (otro, id)
);

CREATE TABLE exhibiciones (
    nombreExhibiciones VARCHAR (20) PRIMARY KEY,
    fechaNac DATE,
    fechaFin DATE
);

CREATE TABLE mostrar (
    id INT,
    nombreExhibiciones VARCHAR (20),
    PRIMARY KEY (id, nombreExhibiciones)
);

CREATE TABLE permanentes (
    permanenteID INT,
    coleccionID INT,
    costo INT,
    fechaAdquisicion DATE,
    PRIMARY KEY (permanenteID, coleccionID)
);

CREATE TABLE prestadas (
    prestadoID INT,
    coleccionID INT,
    propietario VARCHAR (20),
    fechaPrestamo DATE,
    fechaDevolucion DATE,
    PRIMARY KEY (prestadoID, coleccionID)
);

CREATE TABLE otras (
    otraID INT,
    coleccionID INT,
    PRIMARY KEY (otraID, coleccionID)
);

ALTER TABLE objetosArte ADD FOREIGN KEY (coleccionID) REFERENCES colecciones (coleccionID);
ALTER TABLE objetosArte ADD FOREIGN KEY (nombrePaises) REFERENCES paises (nombrePaises);
ALTER TABLE objetosArte ADD FOREIGN KEY (nombreEpoca) REFERENCES epocas (nombreEpoca);
ALTER TABLE artistas ADD FOREIGN KEY (nombrePaises) REFERENCES paises (nombrePaises);
ALTER TABLE crea ADD FOREIGN KEY (id) REFERENCES objetosArte (id);
ALTER TABLE crea ADD FOREIGN KEY (artistaID) REFERENCES artistas (artistaID);
ALTER TABLE pintura ADD FOREIGN KEY (id) REFERENCES objetosArte (id);
ALTER TABLE escultura ADD FOREIGN KEY (id) REFERENCES objetosArte (id);
ALTER TABLE monumento ADD FOREIGN KEY (id) REFERENCES objetosArte (id);
ALTER TABLE otro ADD FOREIGN KEY (id) REFERENCES objetosArte (id);
ALTER TABLE mostrar ADD FOREIGN KEY (id) REFERENCES objetosArte (id);
ALTER TABLE mostrar ADD FOREIGN KEY (nombreExhibiciones) REFERENCES exhibiciones (nombreExhibiciones);
ALTER TABLE permanentes ADD FOREIGN KEY (coleccionID) REFERENCES colecciones (coleccionID);
ALTER TABLE prestadas ADD FOREIGN KEY (coleccionID) REFERENCES colecciones (coleccionID);
ALTER TABLE otras ADD FOREIGN KEY (coleccionID) REFERENCES colecciones (coleccionID);