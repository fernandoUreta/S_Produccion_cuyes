--Agregar Poza
CREATE PROCEDURE SP_A_tblPozas
@id_poza as varchar(4),
@largo as float,
@ancho as float,
@clasificacion as varchar(10),
@capacidad as int
as
insert into tblPozas values(@id_poza,@largo,@ancho,@clasificacion,@capacidad,'T');

GO
--Consultar Poza

CREATE PROCEDURE SP_C_tblPozas
@id_Poza as varchar(4)
as
select * from tblPozas WHERE ID_Pozas=@id_Poza and disponible='T'

GO
--Eliminar Poza
CREATE PROCEDURE SP_E_tblPozas
@id_Poza as varchar(4)
as
update tblPozas set disponible='F' WHERE ID_Pozas=@id_Poza

GO
--Actualizar Poza
CREATE PROCEDURE SP_M_tblPozas
@id_Poza as varchar(4),
@nLargo as float,
@nAncho as float,
@nClasificacion as varchar(10),
@nCapacidad as int
as
update tblPozas set Dimen_L=@nLargo, Dimen_A=@nAncho,pozClasificacion=@nClasificacion,pozCapacidadCuyes=@nCapacidad where ID_Pozas=@id_Poza

GO
CREATE PROCEDURE SP_MostrarTotalPozas
AS
SELECT COUNT(*) FROM tblPozas

GO
--Consultar cuyes por poza y categoria
CREATE PROCEDURE SP_C_CantiCuyes_Poza_Tipo_tblPozas
@IdPoza as VARCHAR(4),
@IdCat as CHAR(2)
AS
SELECT COUNT(ID_Cuy) FROM tblCuyes where ID_Pozas=@IdPoza and ID_Categoria=@IdCat





