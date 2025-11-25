# 📚 Biblioteca API

API REST desarrollada con **Spring Boot**, **Maven** y **H2 Database** para gestionar el catálogo de libros de una biblioteca.  
Implementa un patrón **CSR (Controller–Service–Repository)**, validaciones con **Jakarta Validation**, documentación con **Swagger/OpenAPI** y persistencia local mediante **H2 en modo archivo**.

---

## 🚀 Características principales

- CRUD completo de la entidad **Libro** (`GET`, `POST`, `PUT`, `DELETE`).
- Persistencia local con **H2 Database** (archivo `./data/biblioteca.mv.db`).
- Documentación interactiva con **Swagger UI**.
- Patrón arquitectónico **CSR** (separación clara de capas).
- Validaciones con anotaciones (`@NotBlank`, `@Min`, `@Pattern`, etc.).
- Control global de excepciones con `@RestControllerAdvice`.
- Ejemplo de datos iniciales (`data.sql`) o carga automática por código.

---

## 🧱 Estructura del proyecto
```bash
src/
└─ main/
├─ java/com/proferoberto/biblioteca
│ ├─ controller/ → Endpoints REST
│ ├─ service/ → Lógica de negocio
│ │ └─ impl/ → Implementaciones concretas
│ ├─ repository/ → Acceso a datos con JPA
│ ├─ model/ → Entidades JPA
│ ├─ exception/ → Manejadores y clases de error
│ └─ config/ → Configuración Swagger/OpenAPI
└─ resources/
├─ application.properties
├─ data.sql → Datos iniciales (opcional)
└─ static/ → Recursos estáticos (si aplica)
```
## ⚙️ Configuración del entorno

### Requisitos previos
- **Java 17** o superior  
- **Maven 3.9+**
- **Git** (opcional, para control de versiones)

### Dependencias principales
- `spring-boot-starter-web`
- `spring-boot-starter-data-jpa`
- `spring-boot-starter-validation`
- `com.h2database:h2`
- `org.springdoc:springdoc-openapi-starter-webmvc-ui`
- `org.projectlombok:lombok`

---

## 🧩 Configuración de la base de datos

Archivo: `src/main/resources/application.properties`

```properties

# H2 Database
spring.datasource.url=jdbc:h2:file:./data/biblioteca;AUTO_SERVER=TRUE
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.defer-datasource-initialization=true
spring.sql.init.mode=always

# Consola H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Swagger
springdoc.swagger-ui.display-request-duration=true
springdoc.swagger-ui.tags-sorter=alpha
springdoc.swagger-ui.operations-sorter=alpha

## 📂 Los datos se guardan en:
bash```
/data/biblioteca.mv.db
```
