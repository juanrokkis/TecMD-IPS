# API de tu Aplicación

Esta API proporciona servicios para gestionar citas médicas, doctores y usuarios. Puedes utilizar estos endpoints para acceder a diversas funcionalidades de la aplicación.

## Endpoints Disponibles

### Cita Controller

#### Obtener Citas por ID de Usuario

- **Método**: GET
- **Endpoint**: `/citas/usuario/{id}`
- **Descripción**: Obtiene todas las citas asociadas a un usuario por su ID.
- **Respuesta Exitosa**: 200 OK
- **Respuesta Fallida**: 404 Not Found si el usuario no se encuentra.

#### Cancelar Cita por ID

- **Método**: GET
- **Endpoint**: `/citas/cancel/{id}`
- **Descripción**: Cancela una cita por su ID.
- **Respuesta Exitosa**: 200 OK
- **Respuesta Fallida**: 404 Not Found si la cita no se encuentra o no se pudo cancelar.

#### Guardar Nueva Cita

- **Método**: POST
- **Endpoint**: `/citas/save`
- **Descripción**: Guarda una nueva cita con la fecha, ID de usuario e ID de doctor proporcionados.
- **Parámetros**:
    - `fecha` (formato ISO-8601)
    - `idUsuario` (ID del usuario)
    - `idDoctor` (ID del doctor)
- **Respuesta Exitosa**: 200 OK con los detalles de la cita guardada.
- **Respuesta Fallida**: 500 Internal Server Error si no se pudo guardar la cita.

### Doctor Controller

#### Obtener Todos los Doctores

- **Método**: GET
- **Endpoint**: `/doctores/all`
- **Descripción**: Obtiene una lista de todos los doctores registrados en el sistema.
- **Respuesta Exitosa**: 200 OK con la lista de doctores.

### Usuario Controller

#### Registrar un Nuevo Usuario

- **Método**: POST
- **Endpoint**: `/usuarios/registro`
- **Descripción**: Registra un nuevo usuario con los datos proporcionados.
- **Parámetros**:
    - `nombre`
    - `apellido`
    - `correo`
    - `contrasena`
    - `telefono`
    - `direccion`
- **Respuesta Exitosa**: 200 OK si el usuario se registró con éxito.
- **Respuesta Fallida**: 409 Conflict si el correo ya está en uso.

#### Iniciar Sesión

- **Método**: POST
- **Endpoint**: `/usuarios/login`
- **Descripción**: Permite a un usuario iniciar sesión con su correo y contraseña.
- **Parámetros**:
    - `correo`
    - `contrasena`
- **Respuesta Exitosa**: 200 OK si las credenciales son válidas.
- **Respuesta Fallida**: 401 Unauthorized si las credenciales son inválidas.

#### Obtener Usuario por ID

- **Método**: GET
- **Endpoint**: `/usuarios/user/{id}`
- **Descripción**: Obtiene los detalles de un usuario por su ID.
- **Respuesta Exitosa**: 200 OK con los detalles del usuario.
- **Respuesta Fallida**: 404 Not Found si el usuario no se encuentra.

## Uso

Para utilizar esta API, puedes hacer peticiones a los endpoints mencionados utilizando un cliente HTTP o herramientas como cURL. Asegúrate de incluir los parámetros necesarios en las peticiones POST y respetar el formato de fecha ISO-8601 para las citas.

Ejemplo de solicitud GET para obtener citas de un usuario:

GET http://localhost:puerto/citas/usuario/1

Ejemplo de solicitud POST para guardar una nueva cita:

POST http://localhost:puerto/citas/save

Body:
```json
{
"fecha": "2023-10-10T10:00:00",
"idUsuario": 1,
"idDoctor": 2
}
```

## Configuración de Swagger

La documentación de esta API se genera automáticamente con Swagger. Puedes acceder a la documentación en `http://localhost:puerto/swagger-ui.html` para explorar y probar los endpoints de la API.

## Requisitos

- Java 11
- Maven
- Spring Boot

## Contribuir

Si deseas contribuir a esta API, siéntete libre de hacerlo a través de pull requests. También puedes informar de problemas abriendo un issue en el repositorio.

## Licencia

Este proyecto está bajo la licencia [Licencia MIT](LICENSE).

