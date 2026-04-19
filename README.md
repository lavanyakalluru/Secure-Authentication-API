# 🔐 Secure Authentication API (Spring Boot + JWT)

## Overview
This project is a secure authentication API built using Spring Boot and Spring Security, implementing JWT (JSON Web Token) for stateless authentication.

It provides:
- User Registration (Signup)
- User Login (Authentication)
- JWT Token Generation
- Secure endpoint protection using JWT

---

## Tech Stack
- Backend: Spring Boot
- Security: Spring Security
- Authentication: JWT (JSON Web Token)
- Database: MySQL
- ORM: Spring Data JPA
- Build Tool: Maven

---

## Features
- Secure user registration with BCrypt password hashing
- Login using AuthenticationManager
- JWT token generation on successful login
- Stateless authentication (no sessions)
- Custom JWT filter for request validation
- Protected endpoints (only accessible with valid token)

---

## 📂 Project Structure
src/main/java/com/example/authsystem
- config (Security configuration)
- controller (Auth APIs)
- dto (Request/Response models)
- entity (User entity)
- repository (Database access)
- security (JWT filter)
- service (Business logic)

---

## Setup Instructions

### 1. Clone the repository
git clone https://github.com/your-username/auth-system.git  
cd auth-system  

### 2. Configure Database (application.properties)
spring.datasource.url=jdbc:mysql://localhost:3306/authdb  
spring.datasource.username=root  
spring.datasource.password=your_password  

spring.jpa.hibernate.ddl-auto=update  
spring.jpa.show-sql=true  

### 3. Run the Application
mvn spring-boot:run  

---

## 🔑 API Endpoints

### Signup
POST /auth/signup  
Body:
{
  "username": "lavanya",
  "password": "1234"
}

---

### Login
POST /auth/login  
Body:
{
  "username": "lavanya",
  "password": "1234"
}

Response:
{
  "token": "eyJhbGciOiJIUzI1NiIs..."
}

---

### Protected Endpoint
GET /secure  

Header:
Authorization: Bearer <your_token>

---

## Authentication Flow
Signup → password encrypted and stored  
Login → AuthenticationManager validates credentials  
JWT token generated  
Client sends token in Authorization header  
Server validates token using filter → access granted  

---

## Security Details
- CSRF disabled (API-based system)
- Stateless authentication (no sessions)
- JWT used instead of cookies
- Public endpoints: /auth/**
- All other endpoints require authentication

---

## Key Concepts Used
- AuthenticationManager
- UserDetailsService
- PasswordEncoder (BCrypt)
- OncePerRequestFilter
- JWT (Token generation and validation)

---

## Future Improvements
- Refresh Tokens
- Email Verification
- Password Reset
- OAuth2 Login (Google)
- Role-based authorization

---

## 🧑‍💻 Author
Lavanya Kalluru

---

## ⭐ If you found this useful
Give it a ⭐ on GitHub!
