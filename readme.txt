# Movie Watchlist REST API

## **Overview**
This project provides a RESTful API for managing a movie watchlist. It connects to an RDS/MySQL database and is deployed on AWS Elastic Beanstalk. Built with JDK Corretto 17, it allows users to manage movies and their associated awards securely.

---

## **Features**
- REST API for managing movies and awards.
- Secured using **JWT-based authentication**.
- Connects to an **Azure Database for MySQL flexible server**.
- Deployed on **Azure Web App**.

---

## **System Requirements**
- **JDK**: Corretto 17
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
- **Spring Boot Starter Web**: Simplifies API creation.
- **Spring Boot Actuator**: Provides operational insights.
- **Spring HATEOAS**: Adds hypermedia links to API responses.
- **Spring Security**: Secures the API endpoints.
- **OAuth2 Resource Server**: Enables OAuth2-based authentication.
- **Spring Boot DevTools**: Enables hot reload during development.
- **MySQL Connector/J**: Connects to the MySQL database.
- **Spring Data JPA**: Simplifies data access with JPA.
- **Spring Boot Starter Test**: Provides testing utilities.

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

### **Movie Entity**
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

### **Award Entity**
{
  "awardId": 1,
  "year": "1976",
  "organisation": "BAFTA Film Awards",
  "description": "Best Actor (Al Pacino)"
}

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


