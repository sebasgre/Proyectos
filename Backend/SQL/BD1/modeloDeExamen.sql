create database Paradise_Music;
use Paradise_Music;
CREATE TABLE tblProducto (
  codigo_producto INT NOT NULL,
  precio numeric,
  PRIMARY KEY(codigo_producto)
);
CREATE TABLE tblCd (
  codigo_cd INT NOT NULL,
  interprete varchar(45) NOT NULL,
  productor varchar(45) NOT NULL,
  nombre_cd varchar(45) NOT NULL,
  a ñ o year not null,
  PRIMARY KEY (codigo_cd),
  FOREIGN KEY (codigo_cd) REFERENCES tblProducto (codigo_producto)
);
create table tblInstrumento (
  codigo_ins INT NOT NULL,
  instrumento varchar(45) NOT NULL,
  tipo varchar(45) NOT NULL,
  marca varchar(45) NOT NULL,
  modelo varchar(45) NOT NULL,
  PRIMARY KEY (codigo_ins),
  FOREIGN KEY (codigo_ins) REFERENCES tblProducto (codigo_producto)
);
create table tblCanciones (
  codigo_song INT NOT NULL,
  autor varchar(45) NOT NULL,
  titulo varchar(45) NOT NULL,
  numero_pista int(3) NOT NULL,
  FOREIGN KEY (codigo_song) REFERENCES tblCd (codigo_cd)
);
create table tblEmpleado (
  ci_id int not null,
  snombre varchar(45) not null,
  sapellido varchar(45) not null,
  edireccion varchar(200),
  dtNacimiento date,
  activo varchar(1) not null,
  a ñ o_ingreso year not null,
  primary key (ci_id)
);
create table tblCliente (
  nit_id int not null,
  nombre varchar(45) not null,
  sexo varchar(1),
  fecha_nacimiento date,
  cdireccion varchar(200),
  correoE varchar(100),
  telf int(14) not null,
  primary key (nit_id)
);
create table tblVenta_Compra (
  codigo_venta INT NOT NULL,
  tipo_pago varchar(45) NOT NULL,
  fecha date NOT NULL,
  hora time NOT NULL,
  cliente int not null,
  empleado int not null,
  PRIMARY KEY (codigo_venta),
  FOREIGN KEY (cliente) REFERENCES tblCliente (nit_id),
  FOREIGN KEY (empleado) REFERENCES tblEmpleado (ci_id)
);
create table tblProducto_venta (
  codigo_venta INT NOT NULL,
  codigo_producto INT NOT NULL,
  PRIMARY KEY (codigo_venta, codigo_producto),
  FOREIGN KEY (codigo_venta) REFERENCES tblVenta_Compra (codigo_venta),
  FOREIGN KEY (codigo_producto) REFERENCES tblProducto (codigo_producto)
);
insert into
  tblProducto
values
  (20150101, 250);
insert into
  tblProducto
values
  (20150102, 150);
insert into
  tblProducto
values
  (20150103, 450);
insert into
  tblProducto
values
  (20150104, 750);
insert into
  tblProducto
values
  (20150105, 120);
insert into
  tblProducto
values
  (20150106, 850);
insert into
  tblProducto
values
  (20150107, 1250);
insert into
  tblProducto
values
  (20150201, 10);
insert into
  tblProducto
values
  (20150202, 9);
insert into
  tblProducto
values
  (20150203, 15);
insert into
  tblProducto
values
  (20150204, 25);
insert into
  tblProducto
values
  (20150205, 10);
insert into
  tblProducto
values
  (20150206, 40);
insert into
  tblProducto
values
  (20150207, 65);
insert into
  tblInstrumento
values
  (
    20150101,
    'Guitarra',
    'cuerdas',
    'Ibanez',
    'Aeg10'
  );
insert into
  tblInstrumento
values
  (20150102, 'Bajo', 'cuerdas', 'SD', '1420');
insert into
  tblInstrumento
values
  (
    20150103,
    'Guitarra',
    'cuerdas',
    'Squirt',
    'Stratocaster'
  );
insert into
  tblInstrumento
values
  (
    20150104,
    'Teclado',
    'Electronico',
    'Korg',
    'Kronos'
  );
insert into
  tblInstrumento
values
  (20150105, 'Bajo', 'cuerdas', 'Memphis', 'me128');
insert into
  tblInstrumento
values
  (
    20150106,
    'Guitarra',
    'cuerdas',
    'Fender',
    'Stratocaster Mx'
  );
insert into
  tblInstrumento
values
  (
    20150107,
    'Teclado',
    'Electronico',
    'Motif',
    'Xf8'
  );
insert into
  tblCd
values
  (20150201, 'Creed', 'pepito', 'Human Clay', 1999);
insert into
  tblCd
values
  (
    20150202,
    'Guns -n- Roses',
    'chuwaka',
    'Appetite for Destruction',
    1987
  );
insert into
  tblCd
values
  (20150203, 'Metallica', 'Luke', 'St. Angel', 2006);
insert into
  tblCd
values
  (
    20150204,
    'Nickelback',
    'Obama',
    'Dark hourse',
    2008
  );
insert into
  tblCd
values
  (
    20150205,
    'Aerosmith',
    'Steve T',
    ' Get A Grip',
    1993
  );
insert into
  tblCd
values
  (
    20150206,
    'AC/DC',
    'pepito',
    'Highway to hell',
    1979
  );
insert into
  tblCd
values
  (
    20150207,
    'Black Sabbath',
    'Ozzy',
    'Paranoid',
    1970
  );
insert into
  tblCanciones
values
  (20150201, 'Creed', 'What if', 8);
insert into
  tblCanciones
values
  (20150201, 'Creed', 'With arms Wide Open', 5);
insert into
  tblCanciones
values
  (
    20150202,
    'Guns -n- Roses',
    'Welcome to the Jungle',
    1
  );
insert into
  tblCanciones
values
  (20150202, 'Guns -n- Roses', 'Paradice City', 7);
insert into
  tblCanciones
values
  (20150203, 'Metallica', 'St. Angel', 1);
insert into
  tblCanciones
values
  (20150203, 'Metallica', 'Frantic', 2);
insert into
  tblCanciones
values
  (
    20150204,
    'Nickelback',
    'Burn It To The Ground',
    1
  );
insert into
  tblCanciones
values
  (20150204, 'Nickelback', 'I d Come For You', 5);
insert into
  tblCanciones
values
  (20150205, 'Aerosmith', 'Crazy', 1);
insert into
  tblCanciones
values
  (20150205, 'Aerosmith', 'Cryin', 5);
insert into
  tblCanciones
values
  (20150205, 'Aerosmith', 'Amazing', 8);
insert into
  tblCanciones
values
  (20150206, 'AC/DC', 'Highway To Hell', 1);
insert into
  tblCanciones
values
  (20150206, 'AC/DC', 'Girls Got Rhythm', 3);
insert into
  tblCanciones
values
  (20150206, 'AC/DC', 'Touch Too Much', 5);
insert into
  tblCanciones
values
  (20150207, 'Black Sabbath', 'Paranoid', 1);
insert into
  tblCanciones
values
  (20150207, 'Black Sabbath', 'Iron Man', 3);
insert into
  tblCanciones
values
  (20150207, 'Black Sabbath', 'Electric Funeral', 4);
insert into
  tblEmpleado
values
  (
    1,
    'Armando',
    'Guerra',
    'Barrio Ende Calle#1',
    19941011,
    'V',
    2010
  );
insert into
  tblEmpleado
values
  (
    2,
    'Aquiles',
    'Bailo',
    'Barrio Ende Calle#2',
    19940112,
    'V',
    2011
  );
insert into
  tblEmpleado
values
  (
    3,
    'Soyla',
    'Cerda',
    'Barrio Ende Calle#3',
    19940914,
    'F',
    2000
  );
insert into
  tblEmpleado
values
  (
    4,
    'Jhonny',
    'Brinco',
    'Barrio Ende Calle#4',
    19941215,
    'V',
    2014
  );
insert into
  tblCliente
values
  (
    1,
    'Mario',
    'M',
    19940111,
    'Barrio Ende Calle#1',
    'mario@falsemail.com',
    72145896
  );
insert into
  tblCliente
values
  (
    2,
    'Antonio',
    'M',
    19940212,
    'Barrio Ende Calle#2',
    'mario@falsemail.com',
    72145826
  );
insert into
  tblCliente
values
  (
    3,
    'Ericka',
    'F',
    19940513,
    'Barrio Ende Calle#3',
    'mario@falsemail.com',
    72145894
  );
insert into
  tblCliente
values
  (
    4,
    'Juan',
    'M',
    19941014,
    'Barrio Ende Calle#2',
    'mario@falsemail.com',
    72145856
  );
insert into
  tblCliente
values
  (
    5,
    'Luis',
    'M',
    19941115,
    'Barrio Ende Calle#4',
    'mario@falsemail.com',
    72145836
  );
insert into
  tblCliente
values
  (
    6,
    'Lucia',
    'F',
    19941216,
    'Barrio Ende Calle#4',
    'mario@falsemail.com',
    72145897
  );
insert into
  tblCliente
values
  (
    7,
    'Pedro',
    'M',
    19940517,
    'Barrio Ende Calle#1',
    'mario@falsemail.com',
    72145899
  );
insert into
  tblCliente
values
  (
    8,
    'Fernanda',
    'F',
    19941018,
    'Barrio Ende Calle#4',
    'mario@falsemail.com',
    72149896
  );
insert into
  tblCliente
values
  (
    9,
    'Marcelo',
    'M',
    19940919,
    'Barrio Ende Calle#3',
    'mario@falsemail.com',
    72145890
  );
insert into
  tblVenta_Compra
values
  (1001, 'Efectivo', 20001011, 1530, 1, 1);
insert into
  tblVenta_Compra
values
  (1002, 'Targeta', 20000811, 1630, 2, 2);
insert into
  tblVenta_Compra
values
  (1003, 'Efectivo', 20000712, 1730, 3, 3);
insert into
  tblVenta_Compra
values
  (1004, 'Efectivo', 20001011, 1930, 4, 4);
insert into
  tblVenta_Compra
values
  (1005, 'Efectivo', 20000111, 1030, 5, 4);
insert into
  tblVenta_Compra
values
  (1006, 'Efectivo', 20001011, 1130, 6, 3);
insert into
  tblVenta_Compra
values
  (1007, 'Efectivo', 20001011, 1730, 7, 2);
insert into
  tblVenta_Compra
values
  (1008, 'Targeta', 20000511, 1545, 8, 2);
insert into
  tblVenta_Compra
values
  (1009, 'Efectivo', 20001011, 1530, 9, 1);
insert into
  tblVenta_Compra
values
  (1010, 'Efectivo', 20001111, 1630, 1, 1);
insert into
  tblVenta_Compra
values
  (1011, 'Efectivo', 20000211, 1630, 3, 1);
insert into
  tblVenta_Compra
values
  (1012, 'Targeta', 20001011, 1730, 4, 2);
insert into
  tblVenta_Compra
values
  (1013, 'Efectivo', 20001211, 1030, 1, 3);
insert into
  tblVenta_Compra
values
  (1014, 'Efectivo', 20000911, 1130, 5, 4);
insert into
  tblVenta_Compra
values
  (1015, 'Efectivo', 20000911, 1930, 9, 2);
insert into
  tblProducto_venta
values
  (1001, 20150101);
insert into
  tblProducto_venta
values
  (1002, 20150102);
insert into
  tblProducto_venta
values
  (1003, 20150103);
insert into
  tblProducto_venta
values
  (1004, 20150104);
insert into
  tblProducto_venta
values
  (1005, 20150105);
insert into
  tblProducto_venta
values
  (1006, 20150106);
insert into
  tblProducto_venta
values
  (1007, 20150107);
insert into
  tblProducto_venta
values
  (1008, 20150201);
insert into
  tblProducto_venta
values
  (1009, 20150202);
insert into
  tblProducto_venta
values
  (1010, 20150203);
insert into
  tblProducto_venta
values
  (1011, 20150204);
insert into
  tblProducto_venta
values
  (1012, 20150205);
insert into
  tblProducto_venta
values
  (1013, 20150206);
insert into
  tblProducto_venta
values
  (1014, 20150207);
insert into
  tblProducto_venta
values
  (1015, 20150106);
-- 1
ALTER TABLE
  tblCanciones
ADD
  PRIMARY KEY (numero_pista, titulo);
desc tblcanciones;
-- 2
  desc tblCliente;
INSERT INTO
  tblCliente
VALUES
  (
    10,
    "juan",
    "M",
    "20050525",
    "Calle Avaroa cerca del lugar de alimentos",
    "cualquierCosa@gmail.com",
    78643214
  );
select
  *
from
  tblCliente;
-- 3
select
  *
from
  tblcanciones;
DELETE FROM
  tblcanciones
WHERE
  titulo = 'Electric Funeral';
select
  *
from
  tblcanciones;
-- 4
ALTER TABLE
  tblinstrumento
ADD
  COLUMN precio DECIMAL(6, 2);
update
  tblinstrumento
set
  precio = 195.82
where
  tipo = 'cuerdas';
select
  *
from
  tblinstrumento;
update
  tblinstrumento
set
  precio = 0
where
  tipo != 'cuerdas';
select
  *
from
  tblinstrumento;
select
  *,
  coalesce(precio, 0.00) as valoresNulos
from
  tblinstrumento
where
  tipo != 'cuerdas';
-- 5
select
  tipo,
  coalesce(sum(precio))
from
  tblinstrumento
group by
  tipo;
--6
select
  c.titulo,
  coalesce(count(*)) as cantidad
from
  tblcanciones c
  join tblcd cd on cd.codigo_cd = c.codigo_song
group by
  c.codigo_song
order by
  cantidad desc;
-- 7
select
  *
from
  tblCliente c
  left JOIN tblVenta_Compra co on co.cliente = c.nit_id
where
  co.cliente is null;
-- 8
select
  *,
  count(codigo_venta)
from
  tblproducto_venta
group by
  codigo_producto
order by
  3 desc;
-- otra forma de hacer es con:
SELECT
  i.modelo as PRODUCTO,
  count(pv.codigo_venta) as VENTAS
FROM
  tblproducto_venta pv
  JOIN tblinstrumento i ON i.codigo_ins = pv.codigo_producto
GROUP BY
  pv.codigo_producto
UNION
SELECT
  d.nombre_cd as PRODUCTO,
  count(pv.codigo_venta) as VENTAS
FROM
  tblproducto_venta pv
  JOIN tblcd d ON d.codigo_cd = pv.codigo_producto
GROUP BY
  pv.codigo_producto
ORDER BY
  VENTAS DESC;
-- 9
INSERT INTO
  tblproducto
VALUES(696969, 69.39);
INSERT INTO
  tblinstrumento
VALUES(
    696969,
    'Guitarra',
    'cuerdas',
    'XD',
    'LOL',
    69.69
  );
select
  i.*,
  count(codigo_venta) as VENTAS
from
  tblInstrumento i
  Left join tblProducto_venta pv on i.codigo_ins = pv.codigo_producto
GROUP BY
  pv.codigo_producto
having
  VENTAS < 1;