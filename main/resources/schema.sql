insert into CURSO(nombre_curso) values ('Java'),('C#'),('Javascript'),('Python');
insert into ALUMNO (dni,domicilio,email,nombre)values
('miDNI1 ','domicilio1','ccccc@gmail.com','Leandro'),
('miDNI2 ','domicilio2','mbritez@gmail.com','Matias'),
('miDNI3 ','domicilio3','vburman@gmail.com','Vanesa'),
('miDNI4 ','domicilio4','mm@gmail.com','Mariano'),
('miDNI5 ','domicilio5','sofia@gmail.com','Sofia'),
('miDNI6 ','domicilio6','viviana@gmail.com','Viviana');

SELECT
NOMBRE,email, NOMBRE_CURSO
FROM
    ALUMNO_CURSO ac
INNER JOIN ALUMNO a ON ac.id_alumno = a.id_Alumno
INNER JOIN CURSO c ON ac.id_alumno = c.id_Curso
where nombre='Leandro'
