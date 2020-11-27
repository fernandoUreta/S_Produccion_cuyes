
--Calcula edad de cuyes
CREATE PROCEDURE SP_calcular_edadCuy
@FechaNacimiento as Date
AS
declare @valor int
declare @fechahoy DATE
set @fechahoy=(GETDATE())
set @valor = DATEDIFF (DAY, @FechaNacimiento , @fechahoy )
print @valor

GO



--Consultar cuyes de determinada categoría en determinada poza y su edad máxima
CREATE PROCEDURE SP_C_CuyesEdadMax
@idCat as CHAR(2),
@tipoPoza as CHAR(15),
@edadMaxima as int
as
declare @fechahoy DATE=(GETDATE())
SELECT ID_Cuy,cuyGenero,DATEDIFF (DAY,cuyFechaNaci,@fechahoy)AS Edad,ID_Pozas,ID_Categoria INTO #Lista FROM tblCuyes WHERE ID_Categoria=@idCat and ID_Pozas in (SELECT ID_Pozas FROM tblPozas WHERE pozClasificacion=@tipoPoza);
SELECT ID_Pozas,ID_Cuy,edad,cuyGenero,ID_Categoria AS CategoriaCuy FROM #Lista WHERE Edad>=@edadMaxima
DROP TABLE #Lista 

GO

--Consultar reporte de entrada o salida 
CREATE PROCEDURE SP_ConsultarReporte
@TipoIngreso as char(10)
AS
SELECT fecha,Razon,ID_Pozas FROM tblTransacciones 
INNER JOIN tblDetalleTransaccion ON tblTransacciones.ID_Transaccion=tblDetalleTransaccion.ID_Transaccion 
INNER JOIN tblCuyes ON tblDetalleTransaccion.ID_Cuyes=tblCuyes.ID_Cuy
INNER JOIN tblTipoMovimiento ON tblDetalleTransaccion.ID_TipoMovi=tblTipoMovimiento.ID_TipoMovi WHERE tblTipoMovimiento.Tipo=@TipoIngreso

GO

--Cantidad de cuyes que salen por tipo
CREATE PROCEDURE SP_CANTIDAD_MP
@motivo AS CHAR(9),
@tipo AS CHAR(2),
@cat AS CHAR(2),
@gen AS CHAR(7)
AS
SELECT COUNT(tblCuyes.ID_Cuy) AS cantidad FROM tblDetalleTransaccion INNER JOIN tblTipoMovimiento 
ON tblDetalleTransaccion.ID_TipoMovi=tblTipoMovimiento.ID_TipoMovi and tblTipoMovimiento.ID_TipoMovi=@tipo INNER JOIN tblCuyes	
ON tblDetalleTransaccion.ID_Cuyes = tblCuyes.ID_Cuy AND tblCuyes.cuyGenero=@gen AND tblCuyes.ID_Categoria=@cat AND tblTipoMovimiento.Tipo=@motivo

GO

--Obtener id_máximo de determinado tipo de poza
CREATE PROCEDURE SP_Obtener_Max_ID_Poza
@identificador AS CHAR
AS
SELECT MAX(convert(int,SUBSTRING(ID_Pozas,2, 1) + SUBSTRING(ID_Pozas,3,1)))
FROM tblPozas WHERE ID_Pozas like @identificador+'%'

 

--Salida de cuy por rotación
CREATE PROCEDURE sp_salidaCuy_rotacion
@idCuy as char(16),
@idPozadestino as varchar(4)
AS
UPDATE tblCuyes set ID_Pozas=@idPozadestino WHERE ID_Cuy=@idCuy

--Salida de cuy con estado
CREATE PROCEDURE SP_salidaCuy
@idCuy AS VARCHAR(16),
@estado AS NCHAR(15)
AS
UPDATE tblCuyes set ID_Pozas=null,estado=@estado where ID_Cuy=@idCuy


--Elimina transaccion sin datos
CREATE PROCEDURE SP_limpiarTransaccion
@idTransaccion as int
AS
DECLARE @a AS INT
set @a=(SELECT COUNT(ID_Transaccion) FROM tblDetalleTransaccion WHERE ID_Transaccion=@idTransaccion)
if @a=0
delete from tblTransacciones where ID_Transaccion=@idTransaccion