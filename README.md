## :car: Amazing Cars
Es una web desarrollada como proyecto final para el curso de Desarrollo Full Stack con JAVA del PoloTIC de Misiones.

### :clipboard: Características
 - Incorporar un usuario Administrador quien pueda cargar los vehículos que aparecerán en el sitio para los usuarios navegantes.
 - El Administrador tendrá un abm de Marca, de Tipo de Vehiculo y de Vehiculos.
 - Actualizar la información de los vehiculos existentes, como el nombre, la descripción y la fotografía.
 - Eliminar vehiculos que ya no se encuentren disponibles.
 - Implementa un buscador para todos los usuarios, para que puedan buscar vehiculos por su nombre.

## :computer: Tecnologías utilizadas
 - Java
 - Spring Boot
 - Thymeleaf(vistas)
 - MariaDB(base de datos)
 

## ⌨🖱 Instalación
- Si queremos correr la aplicación en un entorno local debemos tener en cuenta lo siguiente: 

1. Clonar el repositorio utilizando GIT o descargando el archivo ZIP:

    `https://github.com/mariquenaallosa/proyectoFinal-poloTIC.git`

2. Instalar las dependencias de Maven utilizando nuestro IDE preferido o a través del comando:

    `mvn install`

3. Crear/Configurar el archivo _application.properties_ en src/main/resources/

```properties
spring.datasource.url=jdbc:mariadb://<host_DB>:<puerto_DB>/concesionaria
spring.datasource.username=<usuario>
spring.datasource.password=<contraseña>
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
```
NOTA: Reemplazar los valores borrando los <>.

4. Ejecutar nuestra aplicación ejecutando el siguiente comando:
    `mvn spring-boot:run`

### ✨ Contributors

[![Contributors](https://contrib.rocks/image?repo=mariquenaallosa/proyectoFinal-poloTIC)](https://github.com/mariquenaallosa/proyectoFinal-poloTIC/graphs/contributors)


