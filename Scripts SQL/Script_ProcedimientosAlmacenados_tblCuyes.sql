CREATE PROCEDURE SP_A_tblCuyes
@id_Cuy as varchar(4),
@id_Pozas as varchar(4),
@id_Categoria as char(1),
@genero as char(6),
@fecha_naci as date
as
insert into tblCuyes values(@id_Cuy,@id_Pozas,@id_Categoria,@genero,@fecha_naci)

GO

CREATE PROCEDURE SP_C_tblCuyes
@id_Cuy as varchar(4)
as
select *from tblCuyes

GO

CREATE PROCEDURE SP_M_tblCuyes
@id_Cuy as varchar(4),
@id_Pozas as varchar(4),
@id_Categoria as char(1),
@genero as char(6),
@fecha_naci as date
as
UPDATE tblCuyes set ID_Pozas=@id_Pozas,ID_Categoria=@id_Categoria,cuyGenero=@genero,cuyFechaNaci=@fecha_naci

GO 

CREATE PROCEDURE SP_E_tblCuyes
@id_Cuy as varchar(4)
as
delete from tblCuyes where ID_Cuy=@id_Cuy


