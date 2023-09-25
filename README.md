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
 
## Vistas
#### Home 
La página de inicio de nuestro sitio web presenta un navbar que facilita la navegación por todo el sitio, con la adición de una función de búsqueda de vehículos por nombre para una experiencia más eficiente. Un atractivo banner en la parte superior visualmente captura la esencia de nuestra plataforma. Justo debajo, destacamos seis vehículos de manera aleatoria en tarjetas informativas que proporcionan detalles esenciales.

 ![home](https://github.com/mariquenaallosa/proyectoFinal-poloTIC/assets/99567012/d05afd3a-de32-4a7c-ba15-581e091c9e86)
  
#### Vehículos
En nuestra sección de vehículos, se pueden explorar todos los vehículos almacenados en nuestra base de datos de manera detallada y personalizada. Encuentra información técnica, imágenes y datos esenciales para tomar decisiones informadas sobre los vehículos.

![vista vehiculos](https://github.com/mariquenaallosa/proyectoFinal-poloTIC/assets/99567012/0632e02d-b9ab-4f5c-8dc5-03e5ce849ec0)

#### Registro
Registro de un usuario con validación de datos
![Registro](https://github.com/mariquenaallosa/proyectoFinal-poloTIC/assets/99567012/3680c2a6-58a9-4017-9c28-60f2a259cb48)

#### Panel para administradores
Panel de administración que permite gestionar de manera eficiente todos los vehículos almacenados en nuestra base de datos. Desde este panel, se pueden realizar diversas acciones, como agregar nuevos vehículos, actualizar información existente o eliminar registros, garantizando un control total sobre la información de la flota de vehículos.

![Panel admin](https://github.com/mariquenaallosa/proyectoFinal-poloTIC/assets/99567012/cb38366a-6f7b-4bf9-bd72-94e53aeecdeb)


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


