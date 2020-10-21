
--Procedimientos almacenados tbl Transaccion

--A
CREATE PROCEDURE SP_A_tblTransaccion
@id as VARCHAR(15),
@idUsuario as CHAR(8),
@fecha as date
AS
INSERT INTO tblTransacciones VALUES (@id,@idUsuario,@fecha)

go
--C
CREATE PROCEDURE SP_C_tblTransaccion
@id as VARCHAR(15)
AS
SELECT * FROM tblTransacciones WHERE ID_Transaccion=@id

GO
--M
CREATE PROCEDURE SP_M_tblTransaccion
@id as VARCHAR(15),
@idUsuario as CHAR(8),
@fecha as date
AS
UPDATE tblTransacciones SET ID_Usuario=@idUsuario,fecha=@fecha WHERE ID_Transaccion=@id

GO
--E
CREATE PROCEDURE SP_E_tblTransaccion
@id as VARCHAR(15)
AS
DELETE FROM tblTransacciones WHERE ID_Transaccion=@id 
