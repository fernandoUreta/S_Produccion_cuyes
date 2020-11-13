	
select * from tblUsuario
select * from tblCategoria

select * from tblCuyes

EXEC SP_E_tblCuyes D6

insert into tblPozas values('P1','123','122','PADRILLO','1')


SELECT * FROM tblDetalleTransaccion

SELECT * FROM tblTipoMovimiento


SELECT count(ID_Cuyes) AS Cantidad_Cuyes FROM tblDetalleTransaccion INNER JOIN tblTipoMovimiento 
ON tblDetalleTransaccion.ID_TipoMovi=tblTipoMovimiento.ID_TipoMovi and tblTipoMovimiento.ID_TipoMovi='IN'

--Mov Poblacional

	--Lactantes machos
	SELECT * FROM tblDetalleTransaccion INNER JOIN tblTipoMovimiento 
	ON tblDetalleTransaccion.ID_TipoMovi=tblTipoMovimiento.ID_TipoMovi and tblTipoMovimiento.ID_TipoMovi='IN' INNER JOIN tblCuyes 
	ON tblDetalleTransaccion.ID_Cuyes = tblCuyes.ID_Cuy AND tblCuyes.cuyGenero='MACHO'

	--Lactantes hembras
	SELECT * FROM tblDetalleTransaccion INNER JOIN tblTipoMovimiento 
	ON tblDetalleTransaccion.ID_TipoMovi=tblTipoMovimiento.ID_TipoMovi and tblTipoMovimiento.ID_TipoMovi='IN' INNER JOIN tblCuyes 
	ON tblDetalleTransaccion.ID_Cuyes = tblCuyes.ID_Cuy AND tblCuyes.cuyGenero='HEMBRA'
	
	--Compras
	SELECT * FROM tblDetalleTransaccion INNER JOIN tblTipoMovimiento 
	ON tblDetalleTransaccion.ID_TipoMovi=tblTipoMovimiento.ID_TipoMovi and tblTipoMovimiento.ID_TipoMovi='IC' INNER JOIN tblCuyes	
	ON tblDetalleTransaccion.ID_Cuyes = tblCuyes.ID_Cuy AND tblCuyes.cuyGenero='MACHO'



SELECT * FROM tblTransacciones
