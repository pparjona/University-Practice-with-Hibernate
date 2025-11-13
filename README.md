# Programación contra bases de datos

## Hibernate

University project done during the 2024 - 2025 Database course.

Java, Hibernate ORM, SQL, Apache Commons CSV – Team Project
Developed a Java application using Hibernate ORM to manage relational data via entity mapping. Implemented entities for passengers, entertainment, and expenses, and programmed transactional persistence using Hibernate Sessions. Extended functionality to read external CSV data using Apache Commons CSV, parsing rows to dynamically create and associate entities with proper relationships, then storing all records in the database. Focused on robust file handling, error management, and efficient batch data insertion. All with the help of my classmates.

To run and check:

First you will have to run both sql scripts. And then run the code.

Username: root
Password: 12345

In case of errors you can modify these lines of "hibernate.cfg.xml":

<property name="connection.username">root</property>
<property name="connection.password">12345</property>




Proyecto de la universidad hecho durante el curso 2024 - 2025 de Bases de datos.

Java, Hibernate ORM, SQL, Apache Commons CSV – Proyecto en Equipo
Desarrollé una aplicación en Java utilizando Hibernate ORM para gestionar datos relacionales a través del mapeo de entidades. Implementé entidades para pasajeros, entretenimiento y gastos, y programé la persistencia transaccional usando Hibernate Sessions. Amplié la funcionalidad para leer datos externos desde CSV utilizando Apache Commons CSV, analizando filas para crear y asociar entidades dinámicamente con las relaciones adecuadas, y luego almacenando todos los registros en la base de datos. Me enfoqué en un manejo robusto de archivos, gestión de errores y una inserción eficiente de datos por lotes. Todo con ayuda de mis compañeros.

Para ejecutar y comprobar:

Primero tienes que ejecutar las dos consultas sql. Luego ejecutar el código.

Username: root
Password: 12345

En caso de errores puedes modificar las líneas de "hibernate.cfg.xml":

<property name="connection.username">root</property>
<property name="connection.password">12345</property>
