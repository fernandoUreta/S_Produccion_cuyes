
--Calcula edad de cuyes
CREATE PROCEDURE SP_calcular_edadCuy
@FechaNacimiento as Date
AS
declare @valor int
declare @fechahoy DATE
set @fechahoy=(GETDATE())
set @valor = DATEDIFF (DAY, @FechaNacimiento , @fechahoy )
print @valor

DROP PROCEDURE SP_calcular_edadCuy

CREATE PROCEDURE SP_C_CuyesEdadMax
@tipoPoza as CHAR(15),
@edadMaxima as int
as
declare @fechahoy DATE=(GETDATE())
SELECT ID_Cuy,DATEDIFF (DAY, @fechahoy , cuyFechaNaci )AS Edad,ID_Pozas INTO #Lista FROM tblCuyes WHERE ID_Pozas in (SELECT ID_Pozas FROM tblPozas WHERE pozClasificacion='Recría');
SELECT ID_Cuy,ID_Pozas, edad FROM #Lista WHERE Edad>@edadMaxima
DROP TABLE #Lista 