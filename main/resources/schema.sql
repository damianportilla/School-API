insert into Red_Social(icono,nombre) values 
('iconoFB','Facebook'),
('iconoTW','Twitter'),
('iconoLN','LinkedIN');

insert into ALUMNO (dni,domicilio,email,nombre)values
('miDNI1 ','domicilio1','ccccc@gmail.com','Leandro'),
('miDNI2 ','domicilio2','mbritez@gmail.com','Matias'),
('miDNI3 ','domicilio3','valeria@gmail.com','Valeria'),
('miDNI4 ','domicilio4','mm@gmail.com','Mariano'),
('miDNI5 ','domicilio5','sofia@gmail.com','Sofia'),
('miDNI6 ','domicilio6','viviana@gmail.com','Viviana');

insert into CURSO(nombre_curso,descripcion) values 
('Java','Desarrollo de aplicaciones Java'),
('C#','Desarrollo de aplicaciones C#'),
('Javascript','Desarrollo de aplicaciones JS'),
('Python','Desarrollo de aplicaciones Python'),
('Java SE','Desarrollo de aplicaciones Java SE'),
('Java EE', 'Desarrollo de aplicaciones empresariales')
;

insert into Profesor (dni,domicilio,email,nombre) values
('profedni1 ','domicilio1','mail1@gmail.com','Profesor1'),
('profedni2 ','domicilio2','mail2@gmail.com','Profesor2'),
('profedni3 ','domicilio3','mail3@gmail.com','Profesor3'),
('profedni4 ','domicilio4','mail4@gmail.com','Profesor4');

insert into ALUMNO_CURSOS (ALUMNOS_ID_ALUMNO ,CURSOS_ID_CURSO)values 
(1,2);

INSERT INTO PROFESOR_CURSODICTADO (PROFESORES_ID_PROFESOR ,CURSODICTADO_ID_CURSO) VALUES 
(1,1),
(1,2);

insert into Alumno_Y_RRSS(ID_NICK ,NICKNAME ,ID_ALUMNO ,ID_RED_SOCIAL ) values 
(1,'carronerovegano',1,2); 

insert into Profesor_Y_RRSS(ID_NICK ,NICKNAME ,ID_PROFESOR ,ID_RED_SOCIAL ) values 
(1,'PROFESOCIAL',1,2); 
