# AppBanco Demo

Welcome to the **AppBanco Demo** project!  
This is a demonstration banking application built with **Spring Boot**, designed to illustrate:

- RESTful API fundamentals  
- JWT (JSON Web Tokens) security  
- Data persistence with JPA/Hibernate  
- Clean architecture principles  

---

## Key Features

- **Client Registration:** Allows registration of new clients with validations and password encryption using BCrypt.  
- **Account Management:** Each registered client automatically receives a bank account with generated details (account number, CBU, alias).  
- **JWT Security:** Implements a secure authentication flow where users obtain a JWT token upon login, which they must use to access protected resources.  
- **Role-Based Authorization:** Spring Security configuration to authorize access to different endpoints based on user roles (currently, a basic `USER` role).  
- **H2 In-Memory Database:** Uses H2 Database for fast and easy development, complete with a web console for data inspection.  

---

## Technologies Used

- **Spring Boot:** Framework for building robust and scalable Java applications.  
- **Spring Security:** For authentication and authorization.  
- **JWT (JSON Web Tokens):** For token-based security.  
- **Spring Data JPA / Hibernate:** For data persistence and database interaction.  
- **H2 Database:** In-memory database for development.  
- **Lombok:** To reduce boilerplate code (getters, setters, constructors, etc.).  
- **Maven:** Project and dependency management tool.  

---

## How to Run the Project

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/your-repository-name.git
cd your-repository-name
```

### 2. Database Configuration (optional if using H2 in-memory)
Ensure your src/main/resources/application.properties file contains the H2 Database configuration:
```bash
spring.datasource.url=jdbc:h2:mem:bancodb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

### 3. Run the Application
```bash
mvn spring-boot:run
```

### 4. Access H2 Console (Optional)
Once the application is running, access the H2 console in your browser:
http://localhost:8080/h2-console
Use the JDBC URL shown in your application logs (usually jdbc:h2:mem:GENERATED-ID if you didn't specify a fixed name).

---

## API Endpoints

### 1. Register a Client (Public)
- **URL:** `/api/clientes/registrar`  
- **Method:** `POST`  
- **Headers:** `Content-Type: application/json`  
- **Body:**
```json
{
  "cuil": "20-12345678-9",
  "dni": "12345678",
  "sexo": "MASCULINO",
  "apellido": "Perez",
  "nombre": "Juan",
  "direccion": {
    "calle": "Av. Siempre Viva",
    "altura": "742",
    "ciudad": "Springfield",
    "provincia": "Buenos Aires",
    "codigoPostal": "1234"
  },
  "email": "juan.perez@example.com",
  "telefono": "1122334455",
  "usuario": "juanperez",
  "clave": "MiClaveSegura123"
}
```

### 2. Log In and Get JWT (Public)
- **URL:** `/loginr`  
- **Method:** `POST`  
- **Headers:** `Content-Type: application/json`  
- **Body:**
```json
{
  "usuario": "juanperez",
  "clave": "MiClaveSegura123"
}
```

### 3. Access Accounts (Protected - Requires JWT)
- **URL:** `/api/cuentas`  
- **Method:** `GET`  
- **Headers:**
```http
Authorization: Bearer <YOUR_JWT_TOKEN>
```


