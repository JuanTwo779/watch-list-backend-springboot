# Movie Watchlist REST API

## **Overview**
This project provides a RESTful API for managing a movie watchlist. It connects to a MySQL database and is deployed on Azure Web App Service. Built with Java 17, it allows users to manage movies and their associated awards securely.

---

## **Features**
- REST API for managing movies and awards.
- Secured using **JWT-based authentication**.
- Connects to an **Azure Database for MySQL flexible server**.
- Deployed on **Azure Web App**.
- **GitHub Actions** for Continuous Integration and Continuous Deployment (CI/CD).

---

## **System Requirements**
- **Java Version**: 17
- **Maven**: Installed for build and dependency management.

---

## **How It Works**
1. **User Authentication**:
    - Access is secured with Spring Security and JWT.
2. **Movie Management**:
    - Add, update, and delete movies in the watchlist.
3. **Award Management**:
    - Manage awards associated with movies.
4. **Database**:
    - Data is stored in a MySQL flexible server.

---

## **Dependencies**

This project uses the following Maven dependencies:

### **Core Dependencies**
- `spring-boot-starter-web`: Provides the foundation for building web applications.
- `spring-boot-starter-actuator`: Adds production-ready features like metrics and monitoring.
- `spring-boot-starter-hateoas`: Simplifies working with Hypermedia as the Engine of Application State (HATEOAS).
- `spring-boot-starter-security`: Implements Spring Security for securing applications.
- `spring-boot-starter-validation`: For validating beans and request parameters.
- `spring-boot-starter-data-jpa`: Integrates Spring Data JPA for database operations.
- `spring-boot-starter-oauth2-resource-server`: Configures OAuth2-based resource servers.
- `mysql-connector-j`: JDBC driver for MySQL integration.

### **Testing Dependencies**
- `spring-boot-starter-test`: Provides testing utilities for Spring Boot applications.
- `spring-security-test`: Adds testing support for Spring Security.
- `mockwebserver`: Used for mocking HTTP servers during tests.

### **Development Dependencies**
- `spring-boot-devtools`: Enables hot-swapping and live reload during development.

### **Azure Dependencies**
- `spring-cloud-azure-dependencies`: Dependency management for Azure Spring Cloud.
- `spring-cloud-azure-starter-jdbc-mysql`: Adds Azure JDBC MySQL starter integration.

### **Third-Party Utilities**
- `okhttp`: For HTTP/REST client features.
- `mockwebserver`: Used to mock HTTP endpoints for testing purposes.

### **Plugin**
- `spring-boot-maven-plugin`: Facilitates building Spring Boot applications using Maven.

---

## **Beans**
### **Movie Bean**
Represents a movie entity with attributes like:
- `title`
- `director`
- `year`
- `rating`

### **Award Bean**
Represents awards associated with movies.

### **Demo Bean**
Used for testing and verifying AWS health checks.

---

## **Authentication**
The API uses **JWT-based authentication** to ensure secure access.

### **Default Credentials**
- `username`: `<username>`
- `password`: `<password>`

---

## **Example JSON**
### **User Login**
```json
{
  "username": "juan",
  "password": "password123"
}
```
### **Movie Entity**
```json
{
  "id": 1,
  "username": "juan",
  "title": "Scarface",
  "year": "1983",
  "director": "Brian De Palma",
  "country": "USA",
  "rating": 79,
  "watched": true,
  "awards": []
}
```
### **Award Entity**
```json
{
  "awardId": 1,
  "year": "1976",
  "organisation": "BAFTA Film Awards",
  "description": "Best Actor (Al Pacino)"
}
```
---

## **Local Setup**
### **Docker Config**
docker run --detach \
  --env MYSQL_ROOT_PASSWORD=<password> \
  --env MYSQL_USER=<username> \
  --env MYSQL_PASSWORD=<password> \
  --env MYSQL_DATABASE=<database-name> \
  --name <container-name> \
  --publish 3309:3306 \
  mysql:8-oracle

### **MySQL Connection**
\connect watchlist-user@localhost:3309
Password: <password>
Database: <database-name>


