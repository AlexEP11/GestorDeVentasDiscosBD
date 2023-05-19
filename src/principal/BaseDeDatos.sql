--create database GestorVentasDiscos
--use GestorVentasDiscos

--Discos
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

--Proveedores
--create table Proveedores (
--	IdProv char (6) not null primary key,
--	NomP varchar (40),
--	Calle varchar (30),
--	NExterior int,
--	TelPC char(10),
--	TelPF char(10)
--)

--Compras
--create table Compras (
--	idCompras char (6) not null primary key,
--	idProv char (6) not null,
--	FechaC varchar (10),
--	Total float,
--	foreign key (idProv) references Proveedores(idProv)
--)

--DetallesCompras
--create table DetallesCompras (
--	idCompra char (6) not null,
--	idDisco char (6) not null,
--	Cant int,
--	SubTotal float,
--	primary key (idCompra,idDisco),
--	foreign key (idDisco) references Discos(idDisco)
--)

--Empleados
--create table Empleados (
--	idEmp char (6) not null primary key,
--	AP varchar (10),
--	AM varchar (10),
--	NOM varchar (20),
--	NPuesto varchar (20) not null,
--	Turno varchar (1),
--	TelEC char(10),
--	TelEF char(10)
--	foreign key (NPuesto) references Puestos(NPuesto)
--)

--Puestos
--create table Puestos (
--	NPuesto varchar (20) not null primary key,
--	Salario float
--)

--Ventas
--create table Ventas(
--	idVenta char(6) not null primary key,
--	idEmp char(6) not null,
--	FechaV char(10),
--	Total float,
--	foreign key (idEmp) references Empleados(idEmp)
--)

--Detalles Ventas
--create table DetallesVentas (
--	idVenta char (6) not null,
--	idDisco char (6) not null,
--	Cant int,
--	Subtotal float,
--	primary key (idVenta,idDisco),
--	foreign key (idDisco) references Discos(idDisco)
--)

select * from Proveedores
select * from Discos
select * from Compras
select * from DetallesCompras
select * from puestos
select * from Empleados
select * from Ventas
select * from DetallesVentas