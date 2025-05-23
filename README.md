# Task Management System API

## Features

- User Registration and Login (JWT-secured)
- Role-based Authorization (USER, ADMIN)
- CRUD operations for Tasks
- Admin Dashboard (user + task stats)
- Task filtering by status, priority, due date (optional)
- Email reminders (optional)
- Unit and Integration Testing
- API documentation with Swagger UI

## 🛠Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Security + JWT
- Spring Data JPA
- MySQL / H2 (for testing)
- Swagger (OpenAPI)
- JUnit + Mockito
- Spring Boot Actuator
- 
## Setup Instructions

### 1. Clone the Repository
git clone https://github.com/your-username/task-management-system.git
cd task-management-system

### 2. Configure the Database
- Edit src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/task_db

spring.datasource.username=root

spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true

- Create task_db database in MySQL Or switch to H2 for local testing.:

  CREATE DATABASE task_db;

### 3. Build and Run
With Maven: 

./mvnw clean install

./mvnw spring-boot:run

### 4. Access API Docs
Visit: http://localhost:8080/swagger-ui.html
