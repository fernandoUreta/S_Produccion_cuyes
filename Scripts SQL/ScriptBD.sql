CREATE DATABASE BDProduccionCuyes
use BDProduccionCuyes
GO
CREATE TABLE tblCategoria --OK
(	
	ID_Categoria CHAR PRIMARY KEY NOT NULL,
	catNombre char(15), --Gazapos, Recria, Engorde, Primerisa, Madre adulta, Padrillo
	catImage varbinary(MAX)
)

CREATE TABLE tblPozas --OK
(
	ID_Pozas varchar(4) PRIMARY KEY,
	Dimen_L float,--LARGO
	Dimen_A float,--ANCHO
	pozClasificacion varchar(10),--Recria, empadre, padrillo y engorde
	pozCapacidadCuyes int  --Máximo Rec:20 , Emp:10 , Pad: 1 , Eng: 10
)

CREATE TABLE tblCuyes --OK
(
	ID_Cuy varchar(16) PRIMARY KEY,
	ID_Pozas varchar(4),
	ID_Categoria CHAR,
	cuyGenero char(6),
	cuyFechaNaci date,
	FOREIGN KEY (ID_Pozas) REFERENCES tblPozas(ID_Pozas),
	FOREIGN KEY (ID_Categoria) REFERENCES tblCategoria(ID_Categoria)
)

CREATE TABLE tblUsuario --Ok
(
	ID_Usuario CHAR(8) PRIMARY KEY,
	usuNombres CHAR(50),
	usuNumeroContacto CHAR(11),
	usuCorreo CHAR(40),
	usuClaveAcceso VARCHAR(8)
)

CREATE TABLE tblTipoMovimiento
(	
	ID_TipoMovi CHAR(2) PRIMARY KEY,
	Tipo CHAR(5), --ENTRADA O SALIDA
	Razon CHAR(15) --Razón
)

CREATE TABLE tblTransacciones
(
	ID_Transaccion VARCHAR(15) PRIMARY KEY,
	ID_Usuario CHAR(8),
	--ID_Cuy VARCHAR(16),
	--ID_Poza VARCHAR(4),
	fecha date,
	FOREIGN KEY (ID_Usuario) REFERENCES tblUsuario(ID_Usuario),
	--FOREIGN KEY (ID_Cuy) REFERENCES tblCuyes(ID_Cuy),
	--FOREIGN KEY (ID_Poza) REFERENCES tblPozas(ID_Pozas)
)


CREATE TABLE tblDetalleTransaccion
(
	ID_Transaccion VARCHAR(15),	
	ID_Cuyes VARCHAR(16),
	cantidad int,
	ID_TipoMovi CHAR(2),
	FOREIGN KEY (ID_TipoMovi) REFERENCES tblTipoMovimiento(ID_TipoMovi),
	FOREIGN KEY (ID_Transaccion) REFERENCES tblTransacciones(ID_Transaccion),
	FOREIGN KEY (ID_Cuyes) REFERENCES tblCuyes(ID_Cuy)
)	

CREATE TABLE tblNotificaciones
(
	ID_Poza VARCHAR(4),
	TipoNoti CHAR(10), --Parto, Retiro, Destete
	notiFecha date,
	notiEstado bit,
	FOREIGN KEY (ID_Poza) REFERENCES tblPozas(ID_Pozas)
)
