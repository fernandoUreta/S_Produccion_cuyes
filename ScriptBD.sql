CREATE DATABASE BDProduccionCuyes
use BDProduccionCuyes

CREATE TABLE tblCuyes
(
	ID_Cuy varchar(16) PRIMARY KEY,
	cuyCantidad int,
	cuyTipo char(16),
	cuyEdad date,
	cuyGenero char(1)
)

CREATE TABLE tblPozas
(
	ID_Pozas varchar(16) PRIMARY KEY,
	ID_Cuy varchar(16), 
	Dimen_L float,
	Dimen_A float,
	Dimen_H float,
	pozNombres varchar(15),
	pozClasificacion varchar(10),
	pozMSNM float,
	pozCapacidad int
)

CREATE TABLE tblUsuario
(
	ID_Usuario CHAR(8) PRIMARY KEY,
	usuNombres CHAR(50),
	usuNumeroContacto CHAR(11)
)

CREATE TABLE tblTransacciones
(
	ID_Transaccion VARCHAR(15) PRIMARY KEY,
	ID_Usuario CHAR(8),
	ID_Cuyes VARCHAR(16),
	FOREIGN KEY (ID_Usuario) REFERENCES tblUsuario(ID_Usuario),
	FOREIGN KEY (ID_Cuyes) REFERENCES tblCuyes(ID_Cuy)
)

CREATE TABLE tblDetalleTransaccion
(
	ID_Transaccion VARCHAR(15),	
	ID_Ingreso BIT,
	ID_Salida BIT,
	cantidad int,
	fecha date,
	razon char(50)
	FOREIGN KEY (ID_Transaccion) REFERENCES tblTransacciones(ID_Transaccion)
)	
DROP TABLE tblDetalleTransaccion

CREATE TABLE tblNotificaciones
(
	ID_Poza VARCHAR(16),
	notiFecha date,
	notiEstado bit,
	FOREIGN KEY (ID_Poza) REFERENCES tblPozas(ID_Pozas)
)

DROP TABLE tblNotificaciones


