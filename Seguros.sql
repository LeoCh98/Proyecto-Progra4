CREATE DATABASE Seguros;

USE Seguros;

create table Marca (
  nombre varchar(10) not null,
  id integer AUTO_INCREMENT,
  Primary key(id)
);

create table Modelo (
  nombre varchar(10) not null,
  id integer AUTO_INCREMENT,
  marca integer not null,
  Primary key(id)
);

create table Usuario (
  cedula varchar(10) not null,
  clave varchar(10) not null,
  tipo integer not null,
  Primary key(cedula)
);

create table Poliza (
  nombre varchar(25) not null,
  id integer not null AUTO_INCREMENT,
  costo integer not null,
  cliente varchar(10),
  Primary key(id)
);

create table Cliente (
  nombre varchar(10) not null,
  cedula varchar(10) not null,
  placa varchar(6) not null,
  tarjeta integer not null,
  telefono varchar(8),
  correo varchar(15),
  usuario varchar(10) not null,
  Primary key(placa)
);

alter table Modelo add foreign key (marca) references Marca(id);
alter table Cliente add foreign key (usuario) references Usuario(cedula);
alter table Cliente add foreign key (poliza) references Poliza(id);

insert into Marca(nombre,id) values ('Toyota',id);
insert into Marca(nombre,id) values ('Nissan',id);
insert into Marca(nombre,id) values ('Mitsubishi',id);

insert into Modelo(nombre,id,marca) values ('Fortuner', id, 1);
insert into Modelo(nombre,id,marca) values ('Tercel', id, 1);
insert into Modelo(nombre,id,marca) values ('Hilux', id, 1);
insert into Modelo(nombre,id,marca) values ('Sentra', id, 2);
insert into Modelo(nombre,id,marca) values ('Pathfinder', id, 2);
insert into Modelo(nombre,id,marca) values ('Frontier', id, 2);
insert into Modelo(nombre,id,marca) values ('Montero', id, 3);
insert into Modelo(nombre,id,marca) values ('Eclipse', id, 3);
insert into Modelo(nombre,id,marca) values ('Outlander', id, 3);

insert into Usuario(cedula,clave,tipo) values ('111','111',1);
insert into Usuario(cedula,clave,tipo) values ('2222','2222',2);
insert into Usuario(cedula,clave,tipo) values ('3333','3333',2);

insert into Poliza(nombre,id,costo) values ('Responsabilidad Civil',id,200);
insert into Poliza(nombre,id,costo) values ('Danno a Personas',id,150);
insert into Poliza(nombre,id,costo) values ('Danno a Bienes',id,175);
insert into Poliza(nombre,id,costo) values ('Gastos Legales',id,100);

insert into Cliente(nombre,cedula,placa,tarjeta,telefono, correo, usuario) values ('Marcos','111','123456',123,null,null,'111');

Commit;