# Biblioteca Decroly

API REST para gestionar las categorías y los libros de la biblioteca del
centro. Los datos se guardan en memoria, así que se pierden al parar la
aplicación. Proyecto de Desarrollo Web en Entorno Servidor (Fase 1).

## Requisitos

- Java 21 o superior
- Maven (o el wrapper `mvnw` incluido en el proyecto)
- Puerto 8080 libre

## Cómo arrancar la aplicación

1. Clona el repositorio:

   ```bash
   git clone <url-del-repositorio>
   cd biblioteca-decroly
   ```

2. Arranca la aplicación:

   ```bash
   ./mvnw spring-boot:run
   ```

   En Windows:

   ```bash
   mvnw.cmd spring-boot:run
   ```

3. La API queda disponible en `http://localhost:8080`.

## Documentación

- Swagger UI: `http://localhost:8080/swagger-ui/index.html`
- Definición OpenAPI: `docs/openapi.json`
- Colección de Postman: carpeta `postman/`

## Configuración

Las propiedades están en `src/main/resources/application.properties`:

| Propiedad | Valor |
|---|---|
| `biblioteca.nombre` | Biblioteca Decroly |
| `biblioteca.max-prestamos` | 3 |
| `biblioteca.dias-prestamo` | 15 |

## Endpoints

| Método | Ruta | Descripción | Respuestas |
|---|---|---|---|
| GET | `/api/categorias` | Lista las categorías | 200 |
| GET | `/api/categorias/{id}` | Devuelve una categoría | 200, 404 |
| POST | `/api/categorias` | Crea una categoría | 201, 400, 409 |
| PUT | `/api/categorias/{id}` | Modifica una categoría | 200, 400, 404, 409 |
| DELETE | `/api/categorias/{id}` | Borra una categoría | 204, 404 |
| GET | `/api/libros` | Lista los libros (`?autor=` filtra por autor) | 200 |
| GET | `/api/libros/disponibles` | Libros con algún ejemplar disponible | 200 |
| GET | `/api/libros/{id}` | Devuelve un libro | 200, 404 |
| POST | `/api/libros` | Crea un libro | 201, 400, 409 |
| PUT | `/api/libros/{id}` | Modifica un libro | 200, 400, 404, 409 |
| DELETE | `/api/libros/{id}` | Borra un libro | 204, 404 |
| GET | `/api/biblioteca/info` | Nombre de la biblioteca, máximo de préstamos y días de préstamo | 200 |

## Errores

Todos los errores se devuelven como `ProblemDetail`:

- **400**: datos no válidos.
- **404**: recurso no encontrado.
- **409**: conflicto (nombre de categoría o ISBN repetido).