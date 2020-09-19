CREATE DATABASE BDProduccionCuyes

CREATE TABLE tblCuyes
(
	ID_Cuy varchar(16),
	cuyCantidad int,
	cuyTipo char(16),
	cuyEdad date,
	cuyGenero char(1)
)

CREATE TABLE tblPozas
{
	ID_Pozas varchar(16),
	ID_Cuy varchar(16), 
	pozDimension double(3),
	pozNombres varchar(15),
	pozClasificacion varchar(10),
	pozMSNM double,
	pozCapacidad int,
}