# Prueba Técnica - API de Gestión Escolar

## Descripción
Esta API proporciona la funcionalidad para gestionar entidades de un colegio, incluyendo profesores, asignaturas, cursos y estudiantes. Permite obtener información sobre las asignaturas de cada profesor y los estudiantes inscritos.

---

## Tecnologías Utilizadas
- **Java 21**
- **Spring Boot 3**
- **Spring Data JPA**
- **H2 Database (en memoria)**
- **Lombok**
- **Maven**

---

## Ejecución de la Aplicación

1. **Clonar el Repositorio:**
   ```bash
   git clone https://github.com/nesvila90/everis-school-demo.git
   cd everis-school-demo
   ```

2. **Compilar y Ejecutar:**
   ```bash
   ./mvnw spring-boot:run
   ```

3. **Acceso a la Base de Datos H2:**
    - URL: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
    - JDBC URL: `jdbc:h2:mem:testdb`
    - Usuario: `sa`
    - Contraseña: *(vacío)*

4. **Acceso a la API:**
    - Base URL: `http://localhost:8080/api`

---

## Endpoints Disponibles

| Método | Endpoint                 | Descripción                                |
|--------|--------------------------|--------------------------------------------|
| GET    | `/api/professor`         | Obtiene la lista de todos los profesores.  |
| GET    | `/api/professor/{id}/subjects` | Obtiene las asignaturas de un profesor por ID. |

---

## Ejemplo de Respuesta

### **GET /api/professor**
```json
[
  {
    "id": 1,
    "name": "Némesis",
    "subjects": [
      { "id": 1, "name": "Matemáticas" },
      { "id": 2, "name": "Pre Icfes" }
    ]
  },
  {
    "id": 2,
    "name": "Príapo",
    "subjects": [
      { "id": 3, "name": "Español" }
    ]
  }
]
```

---

## Preguntas y Respuestas

1. **Ventajas de la Arquitectura en N-Capas:**
    - Separación de responsabilidades.
    - Curva de aprendizaje más sencilla.
    - Facilita el mantenimiento y las pruebas.
    - Escalabilidad.

2. **Desventajas del Modelo de Microservicios:**
    - Mayor complejidad en la implementación.
    - Necesidad de orquestación (por ejemplo, Kubernetes) o patrones de orquestación como SAGA.
    - Mayor latencia en red

3. **Implementación de Autenticación y Autorización:**
    - Uso de **Spring Security** con **JWT** para autenticación o alguna herramienta como proveedor de identidad (OAuth, KeyCloak o servicios en la nube para seguridad)

4. **Importancia de la Confidencialidad e Integridad:**
    - Protege los datos sensibles y asegura que no sean modificados de forma no autorizada.

5. **Cálculo de la Disponibilidad:**
    - Fórmula: Disponibilidad} = (Tiempo Activo\Tiempo Total) x 100 veces.

6. **Distribución de Tareas (3 Desarrolladores):**
    - Backend: 1 Desarrollador.
    - Frontend: 1 Desarrollador.
    - Base de Datos y Pruebas: 1 Desarrollador.

7. **Generación de Reportes:**
    - Uso de bibliotecas como **JasperReports** o exportación a **Excel** con Apache POI.

8. **Cifrado de Datos:**
    - Implementación de **AES** o **bcrypt** para contraseñas sensibles.

---

## Consideraciones Finales
- La aplicación utiliza **Lombok** para simplificar el código con anotaciones como `@Getter`, `@Setter`, y `@NoArgsConstructor`.
- La base de datos **H2** se carga automáticamente en memoria con un script SQL inicial.

---

## Contacto
Si necesitas más detalles o soporte, por favor contáctame en el repositorio o envía un mensaje.

---
