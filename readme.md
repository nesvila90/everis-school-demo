# Prueba Técnica - API de Gestión Escolar

## Descripción
Esta API proporciona la funcionalidad para gestionar entidades de un colegio, incluyendo profesores, asignaturas, cursos y estudiantes. Permite obtener información sobre las asignaturas de cada profesor, los cursos asociados y los estudiantes inscritos en cada asignatura.

La capa de presentación, construida con **Angular** y **TailwindCSS**, proporciona una experiencia moderna e interactiva.

---

## Tecnologías Utilizadas

### Backend
- **Java 21**
- **Spring Boot 3**
- **Spring Data JPA**
- **H2 Database (en memoria)**
- **Lombok**
- **Maven**

### Frontend
- **Angular**
- **TailwindCSS**
- **RxJS**
- **HttpClientModule**
- **FormsModule**

---

## Ejecución de la Aplicación

### Backend
1. **Clonar el Repositorio Backend:**
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

### Frontend
1. **Clonar el Repositorio Frontend:**
   ```bash
   git clone <URL_DEL_FRONTEND>
   cd nombre-del-proyecto-frontend
   ```

2. **Instalar Dependencias:**
   ```bash
   npm install
   ```

3. **Ejecutar la Aplicación:**
   ```bash
   ng serve
   ```
   Accede a la aplicación en [http://localhost:4200](http://localhost:4200).

---

## Endpoints Disponibles

### Backend

| Método | Endpoint                        | Descripción                                |
|--------|---------------------------------|--------------------------------------------|
| GET    | `/api/professor`                | Obtiene la lista de todos los profesores.  |
| GET    | `/api/professor/{id}/subjects`  | Obtiene las asignaturas de un profesor por ID. |
| GET    | `/api/subject/{id}/students`    | Obtiene los estudiantes de una asignatura por ID. |

---

## Ejemplo de Respuesta

### **GET /api/professor**
```json
[
  {
    "id": 1,
    "name": "Némesis",
    "subjects": [
      { "id": 1, "name": "Matemáticas", "course": "10A" },
      { "id": 2, "name": "Pre Icfes", "course": "11A" }
    ]
  },
  {
    "id": 2,
    "name": "Príapo",
    "subjects": [
      { "id": 3, "name": "Español", "course": "10B" }
    ]
  }
]
```

### **GET /api/subject/{id}/students**
```json
[
  { "id": 1, "name": "Hefesto" },
  { "id": 2, "name": "Hermes" },
  { "id": 3, "name": "Zeus" }
]
```

---

## Funcionalidades del Frontend

### 1. **Buscador de Profesores**
- Campo de búsqueda con filtrado dinámico (ignora caracteres especiales como acentos).
- Tabla interactiva para seleccionar un profesor.

### 2. **Asignaturas y Cursos**
- Al seleccionar un profesor, se muestra una tabla con las asignaturas y los cursos correspondientes.
- Botón para ver estudiantes inscritos en cada asignatura.

### 3. **Lista de Estudiantes en Modal**
- Modal interactivo que muestra los estudiantes inscritos en una asignatura seleccionada.
- Búsqueda dentro de la lista de estudiantes.

---

## Mejoras Implementadas
- **Filtro sin caracteres especiales:** La búsqueda funciona ignorando acentos y otros caracteres.
- **Tablas Modernas:** Uso de tablas para profesores y asignaturas con estilos modernos y responsivos.
- **Modal Interactivo:** Visualización de los estudiantes inscritos en una asignatura con buscador incorporado.
- **Estilo Responsivo:** TailwindCSS garantiza que el diseño se adapte a cualquier dispositivo.

---

## Capturas de Pantalla

1. **Dashboard de Profesores**
   - Campo de búsqueda y tabla de profesores.

2. **Tabla de Asignaturas y Cursos**
   - Información detallada de asignaturas con cursos asociados.

3. **Modal de Estudiantes**
   - Lista de estudiantes con buscador interactivo.

---

## Próximos Pasos
- Autenticación y autorización con **JWT**.
- Paginación y carga diferida en tablas.
- Generación de reportes en **PDF** o **Excel**.

---

## Preguntas y Respuestas

1. **Ventajas de la Arquitectura en N-Capas:**
   - Separación de responsabilidades.
   - Facilita mantenimiento y pruebas unitarias.
   - Permite escalabilidad del sistema.

2. **Desventajas del Modelo de Microservicios:**
   - Mayor complejidad en implementación y despliegue.
   - Aumento en la latencia de red.

3. **Implementación de Autenticación y Autorización:**
   - Integración de **Spring Security** con **JWT**.

4. **Importancia de Confidencialidad e Integridad:**
   - Protege la privacidad de los datos sensibles y evita modificaciones no autorizadas.

5. **Cálculo de Disponibilidad:**
   - Fórmula: `(Tiempo Activo / Tiempo Total) * 100`.

6. **Distribución de Tareas (3 Desarrolladores):**
   - Backend: 1 Desarrollador.
   - Frontend: 1 Desarrollador.
   - Base de Datos y Pruebas: 1 Desarrollador.

7. **Generación de Reportes:**
   - Uso de **JasperReports** o **Apache POI** para exportación a Excel.

8. **Cifrado de Datos:**
   - Implementación de **AES** para datos sensibles y **bcrypt** para contraseñas.

---