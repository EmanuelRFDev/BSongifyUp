# BSongifyUp
Codigo Backend SongifyUp

# SongifyUp
Permite gestionar mediante Java-Spring Boot, el registro y administración de canciones a través de una API REST. Permitiendo a los usuarios reproducir sus canciones favoritas, almacenando la descripción de cada canción en una base de datos en servidor de la nube MySQl. 

## Tecnologías
- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Junit / Mockito
- Swagger
- SonarQube
- HTML
- CSS
- JavaScript, Swiper
- Docker

- Frontend : <a href="https://github.com/EmanuelRFDev/SongifyUp">Codigo Fronted</a>

## Estructura Proyecto Backend Clean Code
```
apirestsongifyup/
│
├── src/
│   └── main/
│       ├── java/com/apirestsongifyup/
│       │   ├── configuration/
│       │   │   ├── App/
│       │   │   └── Security/
│       │   ├── presentation/
│       │   │   ├── dtos/
│       │   │   └── controllers/
│       │   ├── services/
│       │   │       ├── impl/
│       │   │       └── interfaces/
│       │   ├── persistence/
│       │   │   ├── dao/
│       │   │   ├── repository/
│       │   │   └── security/
│       │   └── ApirestsongifyupApplication.java
│       |
│       └── test/
│           ├── persistence/
│           │   └── impl/
│           ├── presentation/
│           │   ├── controller/
│           │   └── dto/
│           └── service/
│               └── impl/
│
├── resources/
│   ├── application.properties
│   ├── banner.txt 
│   └── import.sql 
|
├── DockerCompose.yml
├── Dockerfile
├── .gitignore
├── help.md
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```
## Estructura Proyecto Fronted 
```
songifyup/
│
│
├── assets/
│       |
│       ├── css/
│       │      
│       ├── js/
│       │     
│       ├── images/
│       │          
│       └── songs/
│       
│
|
├── index.html
├── table.html
└── README.md
```

## Relaciones JPA
 - Relacion de Spring JPA
 - OneToOne
 - OneToMany
 - ManyToOne
 - ManyToMany
 
![Imagen relaciones JPA](https://github.com/EmanuelRFDev/PBackend/blob/ba832a39759a505df5c3d7ec79bf8790b6ed8a7f/songify/RelacionesJPA.jpg)

## Analisis de calidad codigo SonarQube

 - Clasificacion "A" el código cumple con altos estándares de calidad, errores no
 - Cobertura del 97.3% de test Unitarios Junit y Mockito
 
 ![Imagen Sonarqube](https://github.com/EmanuelRFDev/PBackend/blob/ba832a39759a505df5c3d7ec79bf8790b6ed8a7f/songify/Sonarqube.jpg)

## Documentacion Swagger 

 - Descripcion de la Api
 - Metodos Controllers 
 
 - Documentacion<a href="https://apirestsongifyup.onrender.com/swagger-ui/index.html">Swagger</a> 

![Imagen documentación con swagger](https://github.com/EmanuelRFDev/PBackend/blob/ba832a39759a505df5c3d7ec79bf8790b6ed8a7f/songify/Swagger.jpg)

## Ejecucion Api

- Clonar repositorio
- Configurar las variables de entorno conexion Mysql
- DB_PASSWORD , DB_URL y DB_USER_NAME
- BD_URL debe contener tu base de datos creada en mysql u online 

- Compilar las dependencias 
```
    mvn clean install
```
- Ejecutar la aplicación Spring Boot
```
    mvn clean install
```
## Ejecucion Docker 

- Opciones de ejecutar docker 

- Dockerfile (Sola la api) 
```
    docker 
```
- Descarga la imagen desde docker hub (Api) para linux amd64
```
    docker pull emanuelrdocker/apirestsongifyup:latest
```
- Ejecutar Docker Compose (Api+ integracion SQL)
```
    docker-compose up
```

## Recursos y Menciones

 * https://docs.spring.io/spring-framework/reference/index.html
 * https://hibernate.org/
 * https://docs.sonarsource.com/sonarqube/latest/
 * https://junit.org/junit5/
 * https://site.mockito.org/
 * https://swagger.io/docs/
 * https://docs.docker.com/
 * https://developer.mozilla.org/es/
 * https://swiperjs.com/get-started
 * https://devdocs.io/
 
 * Gracias por sus videos explicativos
 * He aprendido mucho de Spring con @UnProgramadorNace y sobre libreria Js Swiper con @Ecem.


## Contacto
- Correo electrónico : EmanuelRFdev@gmail.com
- Linkedin : <a href="https://www.linkedin.com/in/emanuel-reyes-0283b6305/">Emanuel Reyes</a>

