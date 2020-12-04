--Consultar usuario por correo
CREATE PROCEDURE SP_C_tblUsuario_byCorreo
@correo AS CHAR(40)
as
SELECT * FROM tblUsuario where usuCorreo=@correo


