INSERT IGNORE INTO usuarios (nombre, edad, sexo, altura, peso, peso_deseado, clasificacion_imc, objetivo_personal, masa_corporal)
VALUES ('Pedro Ruiz', 40, 'Masculino', 1.75, 90.0, 85.0, 'Obesidad', 'Estar_Activo', 83.00);

INSERT IGNORE INTO usuarios (nombre, edad, sexo, altura, peso, peso_deseado, clasificacion_imc, objetivo_personal, masa_corporal)
VALUES ('Alessandro Zacarias', 17, 'Masculino', 1.75, 90.0, 85.0, 'Obesidad', 'Estar_Activo', 83.00);

INSERT IGNORE INTO Registro(id_usuario, correo, contrasena)
VALUES (1,'dlopez-@kina.edu.gt', 'pepito123');

INSERT IGNORE INTO Ejercicio(nombre_ejercicio, descripcion, grupo_muscular, tipo_ejercicio, dificultad)
VALUES ('Pushups', 'ejercicio con manos', 'PECHO', 'FUERZA', 'REGULAR');

INSERT IGNORE INTO Rutina(nombre_rutina, frecuencia, duracion, dificultad, clasificacion_imc)
VALUES ("Marcar brazos",7,"Semanal","REGULAR","Peso_Normal");

INSERT IGNORE INTO detalle_rutina(nombre_rutina, frecuencia, duracion, dificultad, clasificacion_imc, id_rutina, id_ejercicio)
VALUES ("Marcar brazos",7,"Semanal","REGULAR","Peso_Normal",1,1);