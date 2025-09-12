drop database if exists fitBodyDB;
create database fitBodyDB;
use fitBodyDB;

create table Usuarios(
	idUsuario integer auto_increment,
    nombre varchar(64) not null,
    edad integer not null,
    sexo enum("Masculino","Femenino") not null,
    altura decimal(10,2) not null,
    peso decimal(10,2) not null,
    pesoDeseado decimal(10,2) not null,
    clasificacionImc enum("Bajo peso","Peso normal","Sobrepeso","Obesidad") not null,
    objetivoPersonal enum("Ganar musculo","Tonificar","Estar Activo") not null,
    masaCorporal decimal(10,2) not null,
    constraint pk_usuarios primary key (idUsuario)
);

create table Ejercicio(
	idEjercicio integer auto_increment,
    nombre varchar(32) not null,
    descripcion varchar(255) not null,
    grupoMuscular enum("Piernas","Pecho","Espalda","Brazos","Hombros","Abdomen") not null,
    tipoEjercicio enum("Fuerza","Flexibilidad","Mixto","Cardiovascular","Resistencia") not null,
    dificultad enum("Basico","Regular","Avanzado") not null,
    constraint pk_ejercicio primary key (idEjercicio)
);

create table Rutina(
	idRutina integer auto_increment,
    nombreRutina varchar(64) not null,
    dificultad enum("Basico","Regular","Avanzado") not null,
    duracion enum("Semanal","Mensual") not null,
    frecuencia integer,
    clasificacionImc enum("Bajo peso","Peso normal","Sobrepeso","Obesidad") not null,
    constraint pk_rutina primary key (idRutina)
);

create table Registro(
	idRegistro integer auto_increment,
    idUsuario integer not null,
    correo varchar(64) not null unique,
    contrasena varchar(12) not null unique,
    constraint pk_registro primary key (idRegistro),
    constraint fk_registro_usuarios foreign key (idUsuario)
		references Usuarios (idUsuario)
);

create table DetalleRutina(
	idDetalleRutina integer auto_increment,
    idEjercicio integer not null,
    idRutina integer not null,
    nombreRutina varchar(64) not null,
    dificultad enum("Basico","Regular","Avanzado") not null,
    duracion enum("Semanal","Mensual") not null,
    frecuencia integer,
    clasificacionImc enum("Bajo peso","Peso normal","Sobrepeso","Obesidad") not null,
    constraint pk_detalle_rutina primary key (idDetalleRutina),
    constraint fk_detalle_rutina_ejercicio foreign key (idEjercicio)
		references Ejercicio (idEjercicio),
	constraint fk_detalle_rutina_rutina foreign key (idRutina)
		references Rutina (idRutina)
);