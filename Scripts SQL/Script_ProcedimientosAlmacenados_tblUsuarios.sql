--Agregar 
CREATE PROCEDURE SP_A_tblUsuario
@id as char(8),
@nombres char(50),
@numeroContacto char(11),
@correo char(40),
@clave char(8)
as
INSERT INTO tblUsuario VALUES (@id,@nombres,@numeroContacto,@correo,@clave)

GO
--Consultar
CREATE PROCEDURE SP_C_tblUsuario
@id as char(8)
as
SELECT * FROM tblUsuario WHERE ID_Usuario=@id


GO
--Modificar
CREATE PROCEDURE SP_M_tblUsuario
@id as char(8),
@nombres char(50),
@numeroContacto char(11),
@correo char(40),
@clave char(8)
as
UPDATE tblUsuario SET usuNombres=@nombres,usuNumeroContacto=@numeroContacto,usuCorreo=@correo,usuClaveAcceso=@clave WHERE ID_Usuario=@id


GO
--Eliminar
CREATE PROCEDURE SP_E_tblEliminar
@id as char(8)
as
DELETE FROM tblUsuario WHERE ID_Usuario=@id


