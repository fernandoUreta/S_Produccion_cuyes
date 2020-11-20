CREATE DATABASE BDProduccionCuyes
GO
use BDProduccionCuyes
GO
CREATE TABLE tblCategoria --OK
(	
	ID_Categoria CHAR(2) PRIMARY KEY NOT NULL,
	catNombre char(25), --Gazapos, Recria, Engorde, Primerisa, Madre adulta, Padrillo
	catImage varbinary(MAX)
)

CREATE TABLE tblPozas --OK
(
	ID_Pozas varchar(4) PRIMARY KEY,
	Dimen_L float,--LARGO
	Dimen_A float,--ANCHO
	pozClasificacion varchar(10),--Recria, empadre, padrillo y engorde
	pozCapacidadCuyes int,--Máximo Rec:20 , Emp:10 , Pad: 1 , Eng: 10
	disponible char(1) -- T-> disponible F->no disponible o eliminado
)


CREATE TABLE tblCuyes --OK
(
	ID_Cuy varchar(16) PRIMARY KEY,
	ID_Pozas varchar(4),
	ID_Categoria CHAR(2),
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
	Tipo CHAR(7), --ENTRADA O SALIDA
	Razon CHAR(10) --Razón
)

CREATE TABLE tblTransacciones
(
	ID_Transaccion INT PRIMARY KEY,
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
	ID_Transaccion INT,	
	ID_Cuyes VARCHAR(16),
	ID_TipoMovi CHAR(2),
	FOREIGN KEY (ID_TipoMovi) REFERENCES tblTipoMovimiento(ID_TipoMovi),
	FOREIGN KEY (ID_Transaccion) REFERENCES tblTransacciones(ID_Transaccion),
)	


CREATE TABLE tblNotificaciones
(
	ID_Poza VARCHAR(4),
	TipoNoti CHAR(10), --Parto, Retiro, Destete
	notiFecha date,
	notiEstado bit,
	FOREIGN KEY (ID_Poza) REFERENCES tblPozas(ID_Pozas)
)

GO
--Inserción de datos fijos

--Tabla categoria
	INSERT INTO tblCategoria VALUES ('MM','Madre madura',null);
	INSERT INTO tblCategoria VALUES ('MP','Madre primeriza',null);
	INSERT INTO tblCategoria VALUES ('PD','Padrillo',null);
	INSERT INTO tblCategoria VALUES ('EG','Engorde',null);
	INSERT INTO tblCategoria VALUES ('RC','Recria',null);
	INSERT INTO tblCategoria VALUES ('LC','Lactante',null);

--Tabla TipoMovimiento

	--Ingresos
		INSERT INTO tblTipoMovimiento VALUES('IC','Ingreso','Compra');
		INSERT INTO tblTipoMovimiento VALUES('IN','Ingreso','Nacimiento');
		INSERT INTO tblTipoMovimiento VALUES('IR','Ingreso','Rotacion');
		INSERT INTO tblTipoMovimiento VALUES('IO','Ingreso','Otros');
	--Salidas
		INSERT INTO tblTipoMovimiento VALUES('SM','Salida','Muerte');
		INSERT INTO tblTipoMovimiento VALUES('SV','Salida','Venta');
		INSERT INTO tblTipoMovimiento VALUES('SC','Salida','Consumo');
		INSERT INTO tblTipoMovimiento VALUES('SR','Salida','Rotacion');
		INSERT INTO tblTipoMovimiento VALUES('SO','Salida','Otros');





