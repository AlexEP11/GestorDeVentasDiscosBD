--create database GestorVentasDiscos
--use GestorVentasDiscos

--create table Discos (
--	idDisco char (6) not null primary key,
--	Genero varchar (15),
--	Formato char (1),
--	Artista varchar (20),
--	NAlbum varchar (20),
--	DiaL int,
--	MesL int,
--	AñoL int,
--	Exist int,
--	Costo float
--)

--create table Proveedores (
--	IdProv char (6) not null primary key,
--	NomP varchar (40),
--	Calle varchar (30),
--	NExterior int,
--	TelPC char(10),
--	TelPF char(10)
--)

--create table Compras (
--	idCompras char (6) not null primary key,
--	idProv char (6) not null,
--	FechaC varchar (10),
--	Total float,
--	foreign key (idProv) references Proveedores(idProv)
--)
select * from Proveedores
select * from Discos
select * from Compras