# Parcial Recuperatorio 3K1

<br />

<img src="./assets/Images/logo_utn_frc.png" alt="Imagen UTN FRC" />

<br />

* Carrera: Ingenieria en Sistemas de Información
* Materia: BackEnd de Aplicaciones
* Alumno: Garzón Sergio Gabriel

## Tecnologias:

* Java
* Maven
* Motor de base de datos embebido H2

## Pasos para la ejecución del proyecto

* Abrir terminal de VSCode (Ctrl+Shift-ñ)
* Ejecutar comando: 
  
  ~~~MAVEN
  mvn clean compile exec:java
  ~~~

* Generación del archivo .jar con el comando:
  
  ~~~MAVEN
  mvn clean compile package
  ~~~

* Ejecución del .jar es con el comando 
* 
  ~~~JAVA
  java -jar ./target/recuperatorio-parcial-3k1-garzon-sergio-54330
  ~~~