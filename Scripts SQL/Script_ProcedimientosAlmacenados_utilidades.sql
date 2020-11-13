
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



--Consultar cuyes de determinada categor�a en determinada poza y su edad m�xima
CREATE PROCEDURE SP_C_CuyesEdadMax
@idCat as CHAR(2),
@tipoPoza as CHAR(15),
@edadMaxima as int
as
declare @fechahoy DATE=(GETDATE())
SELECT ID_Cuy,cuyGenero,DATEDIFF (DAY,cuyFechaNaci,@fechahoy)AS Edad,ID_Pozas,ID_Categoria INTO #Lista FROM tblCuyes WHERE ID_Categoria=@idCat and ID_Pozas in (SELECT ID_Pozas FROM tblPozas WHERE pozClasificacion=@tipoPoza);
SELECT ID_Pozas,ID_Cuy,edad,cuyGenero,ID_Categoria AS CategoriaCuy FROM #Lista WHERE Edad>=@edadMaxima
DROP TABLE #Lista 

--Consultar reporte de entrada o salida 
CREATE PROCEDURE SP_ConsultarReporte
@TipoIngreso as char(10)
AS
SELECT fecha,Razon,ID_Pozas FROM tblTransacciones 
INNER JOIN tblDetalleTransaccion ON tblTransacciones.ID_Transaccion=tblDetalleTransaccion.ID_Transaccion 
INNER JOIN tblCuyes ON tblDetalleTransaccion.ID_Cuyes=tblCuyes.ID_Cuy
INNER JOIN tblTipoMovimiento ON tblDetalleTransaccion.ID_TipoMovi=tblTipoMovimiento.ID_TipoMovi WHERE tblTipoMovimiento.Tipo=@TipoIngreso

 

