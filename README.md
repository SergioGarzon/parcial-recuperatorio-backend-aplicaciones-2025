# Parcial Recuperatorio 3K1

<br />

<img src="./assets/Images/logo_utn_frc.png" alt="Imagen UTN FRC" />

* Carrera: Ingenieria en Sistemas de Información
* Materia: BackEnd de Aplicaciones
* Alumno: Garzón Sergio Gabriel

## Repositorio de GitHub

<img src="./assets/Images/github_logo.png" alt="Logotipo de GitHub" width="100" height="100" />

~~~GITHUB
  git clone https://github.com/SergioGarzon/parcial-recuperatorio-backend-aplicaciones-2025.git
~~~

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