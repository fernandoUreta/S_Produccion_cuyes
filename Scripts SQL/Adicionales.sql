--Consultar usuario por correo
CREATE PROCEDURE SP_C_tblUsuario_byCorreo
@correo AS CHAR(40)
as
SELECT * FROM tblUsuario where usuCorreo=@correo

//determinar tipo poza
CREATE PROCEDURE SP_validar_tipoPoza
@idcategoria AS CHAR(2),
@genero AS CHAR(6),
@idPoza AS VARCHAR(4)
AS
select count(ID_Cuy) from tblCuyes INNER JOIN tblPozas on tblCuyes.ID_Pozas=tblPozas.ID_Pozas and
tblCuyes.ID_Categoria=@idcategoria and cuyGenero=@genero and tblCuyes.ID_Pozas=@idPoza
