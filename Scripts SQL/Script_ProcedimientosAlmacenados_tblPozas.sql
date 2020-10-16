--Agregar Poza
CREATE PROCEDURE SP_A_tblPozas
@id_poza as varchar(4),
@largo as float,
@ancho as float,
@clasificacion as varchar(10),
@capacidad as int
as
insert into tblPozas values(@id_poza,@largo,@ancho,@clasificacion,@capacidad);

--Consultar Poza

CREATE PROCEDURE SP_C_tblPozas
@id_Poza as varchar(4)
as
select * from tblPozas WHERE ID_Pozas=@id_Poza

--Eliminar Poza
CREATE PROCEDURE SP_E_tblPozas
@id_Poza as varchar(4)
as
delete from tblPozas where ID_Pozas=@id_Poza

--Actualizar Poza
CREATE PROCEDURE SP_M_tblPozas
@id_Poza as varchar(4),
@nLargo as float,
@nAncho as float,
@nClasificacion as varchar(10),
@nCapacidad as int
as
update tblPozas set Dimen_L=@nLargo, Dimen_A=@nAncho,pozClasificacion=@nClasificacion,pozCapacidadCuyes=@nCapacidad where ID_Pozas=@id_Poza
