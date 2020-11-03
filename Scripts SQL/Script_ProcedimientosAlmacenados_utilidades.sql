
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

--Rec
CREATE PROCEDURE SP_C_CuyesEdadMax
@tipoPoza as CHAR(15),
@edadMaxima as int
as
declare @fechahoy DATE=(GETDATE())
SELECT ID_Cuy,DATEDIFF (DAY,cuyFechaNaci,@fechahoy)AS Edad,ID_Pozas INTO #Lista FROM tblCuyes WHERE ID_Pozas in (SELECT ID_Pozas FROM tblPozas WHERE pozClasificacion=@tipoPoza);
SELECT ID_Cuy,ID_Pozas, edad FROM #Lista WHERE Edad>=@edadMaxima
DROP TABLE #Lista 

--2 Parametros
CREATE PROCEDURE SP_C_CuyesEdadMax_cat
@tipoPoza as CHAR(15),
@edadMaxima as int
as
declare @fechahoy DATE=(GETDATE())
SELECT ID_Cuy,DATEDIFF (DAY,cuyFechaNaci,@fechahoy)AS Edad,ID_Pozas,ID_Categoria INTO #Lista FROM tblCuyes WHERE ID_Pozas in (SELECT ID_Pozas FROM tblPozas WHERE pozClasificacion=@tipoPoza);
SELECT ID_Cuy,ID_Pozas,ID_Categoria AS CategoriaCuy,edad FROM #Lista WHERE Edad>=@edadMaxima
DROP TABLE #Lista 


---3 Parametros


EXEC SP_C_CuyesEdadMax 'Recría',20

EXEC SP_C_CuyesEdadMax_cat 'Recría',20








--
CREATE PROCEDURE SP_C_CuyesEdadMax_categoria
@tipoPoza as CHAR(15),
@edadMaxima as int,
@idCat as CHAR(2)
as
declare @fechahoy DATE=(GETDATE())
SELECT ID_Cuy,DATEDIFF (DAY,cuyFechaNaci,@fechahoy)AS Edad,ID_Pozas,ID_Categoria INTO #Lista FROM tblCuyes WHERE ID_Pozas in (SELECT ID_Pozas FROM tblPozas WHERE pozClasificacion=@tipoPoza);
SELECT ID_Cuy,ID_Pozas, edad ,ID_Categoria,FROM #Lista WHERE Edad>=@edadMaxima
DROP TABLE #Lista 



--
SELECT *FROM tblCuyes WHERE ID_Pozas in (SELECT ID_Pozas FROM tblPozas WHERE pozClasificacion='Recría')

SELECT * from tblCategoria
select * from tblCuyes
select * from #Lista
