create database final;
use final;

CREATE TABLE Personas(
	codigo_id VARCHAR(12) NOT NULL PRIMARY KEY,
	snombre VARCHAR(20) NOT NULL,
	sapellido VARCHAR(20) NOT NULL,
	stelefono VARCHAR(12),
	sdireccion VARCHAR(80)
	);

CREATE TABLE Pacientes(
	codigo_id VARCHAR(11) NOT NULL PRIMARY KEY,
	gsangre VARCHAR(3) NOT NULL,
	FOREIGN KEY (codigo_id) REFERENCES Personas(codigo_id)
	);

CREATE TABLE Doctores(
	codigo_id VARCHAR(11) NOT NULL PRIMARY KEY,
	sespecialidad VARCHAR(20) NOT NULL,
	nsalario NUMERIC(15,2),
	bactivo BOOLEAN NOT NULL,
	FOREIGN KEY (codigo_id) REFERENCES Personas(codigo_id)
	);

CREATE TABLE Clinicas(
	codigo_id INT NOT NULL PRIMARY KEY,
	snombre VARCHAR(30) NOT NULL,
	inivel INT,
	stelefono VARCHAR(12),
	sdireccion VARCHAR(40)
	);

CREATE TABLE Consultas(
	codigo_id INT NOT NULL PRIMARY KEY,
	clinica_id INT NOT NULL,
	doctor_id VARCHAR(11),
	paciente_id VARCHAR(11),
	dtfecha DATE NOT NULL,
	UNIQUE (clinica_id,doctor_id,paciente_id),
	FOREIGN KEY (doctor_id) REFERENCES Doctores(codigo_id),
	FOREIGN KEY (paciente_id) REFERENCES Pacientes(codigo_id),
    FOREIGN KEY (clinica_id) REFERENCES Clinicas (codigo_id)
);

CREATE TABLE Medicamentos ( 
    codigo_id int primary key,
    nombre varchar(20),
    dosis VARCHAR(20),
    tipo VARCHAR (20)
);

CREATE TABLE Recetas (
    cantidad int,
    consulta_id int,
    medicamentos_id int,
    PRIMARY KEY (consulta_id, medicamentos_id),
    FOREIGN KEY (consulta_id) REFERENCES Consultas (codigo_id),
    FOREIGN KEY (medicamentos_id) REFERENCES Medicamentos (codigo_id)
); 
    

INSERT INTO Personas VALUES('19905130-AF','Alejandro','Fernandez','72658162','Av. Banzer');
INSERT INTO Personas VALUES('19861224-EG','Ernesto','Gonzales','775627162','Av. Beni');
INSERT INTO Personas VALUES('19791001-JQ','Javier','Quino','79875211','Calle Tordo #3');
INSERT INTO Personas VALUES('19870827-RS','Ramon','Solares','678963','Santos Dumont');
INSERT INTO Personas VALUES('19821109-MC','Maria','Cardenas','65748291','Barrio Sirari');
INSERT INTO Personas VALUES('20020202-MZ','Martin','Zabala','79654',NULL);
INSERT INTO Personas VALUES('20060513-EP','Eugenia','Paniagua','3651544','4to Anillo');
INSERT INTO Personas VALUES('19800405-IR','Isabel','Rosales','7234012',NULL);
INSERT INTO Personas VALUES('19760402-VG','Victor','Gutierrez','72819462','Av. Las Americas #21');
INSERT INTO Personas VALUES('19990619-CS','Camila','Suarez','68710541','Av. Beni 3er Anillo');
INSERT INTO Personas VALUES('19920809-PP','Pedro','Perez','36571105','Entre 5to y 4to Anillo, Av. Banzer');
INSERT INTO Personas VALUES('19960311-PG','Paco','Guerra','3471751',NULL);
INSERT INTO Personas VALUES('19900415-LT','Luis','Trujillo','584781','Calle 1, #7');
INSERT INTO Personas VALUES('19810721-AR','Antonio','Rendon','6518157','Calle 7');
INSERT INTO Personas VALUES('19891231-JF','Juan','Fernandz','70000001',NULL);
INSERT INTO Personas VALUES('19931001-AT','Andrea','Tejerina','33215',NULL);


INSERT INTO Pacientes VALUES('19791001-JQ','O+');
INSERT INTO Pacientes VALUES('19800405-IR','B+');
INSERT INTO Pacientes VALUES('19990619-CS','A-');
INSERT INTO Pacientes VALUES('19861224-EG','AB-');
INSERT INTO Pacientes VALUES('19905130-AF','AB+');
INSERT INTO Pacientes VALUES('19821109-MC','A+');
INSERT INTO Pacientes VALUES('20060513-EP','A+');
INSERT INTO Pacientes VALUES('19870827-RS','O+');
INSERT INTO Pacientes VALUES('19810721-AR','O+');
INSERT INTO Pacientes VALUES('19900415-LT','B+');

INSERT INTO Doctores VALUES('19760402-VG','Oftalmologo',2300,true);
INSERT INTO Doctores VALUES('20020202-MZ','Cardiologo',5600,true);
INSERT INTO Doctores VALUES('19821109-MC','Cirujano',10350,false);
INSERT INTO Doctores VALUES('19791001-JQ','Pediatra',1850,true);
INSERT INTO Doctores VALUES('19931001-AT','Pediatra',1999,true);
INSERT INTO Doctores VALUES('19960311-PG','Cardiologo',2000,true);

INSERT INTO Clinicas VALUES(1,'Clinica Sirari',3,'3384283','Barrio Sirari');
INSERT INTO Clinicas VALUES(2,'Clinica Nuclear',5,'3647382','Calle Junin');
INSERT INTO Clinicas VALUES(3,'Caja Petrolera',3,'3476352','Calle España');
INSERT INTO Clinicas VALUES(4,'Caja Nacional',1,'3327183','Calle Irala');
INSERT INTO Clinicas VALUES(5,'ProSalud',2,'3342718','Av. Alemana');

INSERT INTO Consultas VALUES(1,1,'19760402-VG','19821109-MC','20150520');
INSERT INTO Consultas VALUES(2,3,'20020202-MZ','19861224-EG','20150428');
INSERT INTO Consultas VALUES(3,3,'19760402-VG','19870827-RS','20150426');
INSERT INTO Consultas VALUES(4,4,'20020202-MZ','19905130-AF','20150520');
INSERT INTO Consultas VALUES(5,5,'19791001-JQ','19800405-IR','20150512');
INSERT INTO Consultas VALUES(6,1,'19760402-VG','19990619-CS','20150519');
INSERT INTO Consultas VALUES(7,4,'19791001-JQ','20060513-EP','20150520');
INSERT INTO Consultas VALUES(8,1,'19821109-MC','19800405-IR','20150514');
INSERT INTO Consultas VALUES(9,3,'19821109-MC','19990619-CS','20150419');
INSERT INTO Consultas VALUES(10,4,'19791001-JQ','19900415-LT','20150323');
INSERT INTO Consultas VALUES(11,5,'19821109-MC','19800405-IR','20150623');
INSERT INTO Consultas VALUES(12,5,'19821109-MC','19791001-JQ','20150502');
INSERT INTO Consultas VALUES(13,1,'19960311-PG','19800405-IR','20150614');
INSERT INTO Consultas VALUES(14,3,'19931001-AT','19990619-CS','20150410');
INSERT INTO Consultas VALUES(15,4,'19931001-AT','19900415-LT','20150223');
INSERT INTO Consultas VALUES(16,5,'19821109-MC','19900415-LT','20150723');


INSERT INTO Medicamentos VALUES(1, 'paracetamol', '500 mg', 'analgesico');
INSERT INTO Medicamentos VALUES(2, 'nastizon', '250 mg', 'antitusigeno');
INSERT INTO Medicamentos VALUES(3, 'dineumobron', '100 mg', 'antigripal');
INSERT INTO Medicamentos VALUES(4, 'amoxicilina', '500 mg', 'antibiotico');
INSERT INTO Medicamentos VALUES(5, 'omeprazol', '500 mg', 'analgesico');

INSERT INTO Recetas VALUES(200, 2, 5);
INSERT INTO Recetas VALUES(150, 6, 3);
INSERT INTO Recetas VALUES(300, 8, 2);
INSERT INTO Recetas VALUES(320, 14, 4);
INSERT INTO Recetas VALUES(180, 3, 1);

-- 4
select *
from Personas
where stelefono like '3%';

-- 5
select p.*
from Personas p
left join Pacientes pa on pa.codigo_id = p.codigo_id
left join Doctores d on d.codigo_id = p.codigo_id
where pa.codigo_id is null and d.codigo_id is null;

-- 6

select p.*
from Pacientes p
join Consultas c on c.codigo_id = p.codigo_id
where c.codigo_id is null;

-- 7

select p.snombre as nombre, COUNT(*) as Total_De_Pacientes
from Doctores d
join Personas p on p.codigo_id = d.codigo_id
join Consultas c on c.paciente_id = p.codigo_id 
group by c.paciente_id;

-- 8

select d.*
from Doctores d
join Personas p on p.codigo_id = d.codigo_id
join Pacientes pa on pa.codigo_id = d.codigo_id;

-- 9




-- 10
 select pa.gsangre as grupo_sanguineo, count(*) as numero_pacientes 
 from Personas p
 join Pacientes pa on p.codigo_id = pa.codigo_id
 group by pa.gsangre
 order by 2 desc;