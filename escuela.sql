
drop database if exists escuela;
create database escuela;
use escuela;

create table alumnos (
id_alumno int not null auto_increment,
nombre varchar(50) not null,
apellido varchar(50) not null,
fecha_nacimiento date not null,
DNI int unique not null,
primary key (id_alumno)
);

create table profesores (
id_profesor int not null auto_increment,
nombre varchar(50) not null,
apellido varchar(50) not null,
primary key (id_profesor)
);

create table asignaturas (
id_asignatura int unique not null auto_increment,
nombre varchar(50) not null,
profesor int,
foreign key (profesor) references profesores (id_profesor),
primary key (id_asignatura)
);

create table matriculas (
alumno int not null,
asignatura int not null,
fecha date not null,
foreign key (alumno) references alumnos (id_alumno),
foreign key (asignatura) references asignaturas (id_asignatura)
);
