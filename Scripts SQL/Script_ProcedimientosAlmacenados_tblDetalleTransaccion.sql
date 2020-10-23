--Procedimientos almacenados tblTdetalleTransaccion
--A
CREATE PROCEDURE SP_A_tblDetalleTransaccion
@idTransaccion AS CHAR(15),
@idCuy AS VARCHAR(16),
@tipoMovi CHAR(2)
AS
INSERT INTO tblDetalleTransaccion VALUES (@idTransaccion,@idCuy,@tipoMovi)

--C
CREATE PROCEDURE SP_C_tblDetalleTransaccion
@idTransaccion AS CHAR(15)
AS
SELECT * FROM tblDetalleTransaccion WHERE ID_Transaccion=@idTransaccion


--M
CREATE PROCEDURE SP_M_tblDetalleTransaccion
AS

--E
CREATE PROCEDURE SP_E_tblDetalleTransaccion
@idTransaccion AS CHAR(15)
AS
DELETE FROM tblDetalleTransaccion WHERE ID_Transaccion=@idTransaccion
