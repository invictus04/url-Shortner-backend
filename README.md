# URL Shortener Project

This project is a simple URL shortener application that converts long URLs into short, easy-to-share URLs. It is built using Spring Boot and PostgreSQL as the database. The project is deployed and available to use with the provided endpoints.

## Features

- Convert long URLs into short URLs.
- Retrieve the original URL using the short URL.
- Uses PostgreSQL for persistent storage.
- Deployed online for testing and production use.

## Endpoints

### 1. Shorten a URL (POST request)

**Endpoint**: `/url`

**Description**: Converts a long URL into a shortened URL.

**Request Parameters**:
- `url`: The long URL you want to shorten.

**Example**:

```bash
POST /url
Content-Type: application/json

{
    "url": "https://www.example.com/some/very/long/url"
}
```

**Response**:

```json
{
    "shortUrl": "https://short.url/abc123"
}
```

### 2. Retrieve Original URL (GET request)

**Endpoint**: `/url/{value}`

**Description**: Retrieves the original long URL using the short URL's identifier (`value`).

**Request Parameters**:
- `value`: The short URL identifier (the part after the domain, e.g., `abc123`).

**Example**:

```bash
GET /url/abc123
```

**Response**:

```json
{
    "longUrl": "https://www.example.com/some/very/long/url"
}
```

## Setup Instructions

To run this project locally, follow these steps:

### Prerequisites

- Java 17 or higher
- Maven
- PostgreSQL database

### Clone the Repository

```bash
git clone https://github.com/your-username/url-shortener.git
cd url-shortener
```

### Database Setup

1. Make sure PostgreSQL is installed and running.
2. Create a new PostgreSQL database:

```sql
CREATE DATABASE urldb;
```

3. Update the database URL in the `application.properties` file or through environment variables.

Example configuration in `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://your-database-url/urldb?user=your-username&password=your-password&sslmode=require
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

Alternatively, you can set these values as environment variables in your deployment environment.

### Build and Run the Project

1. Use Maven to clean and package the project:

```bash
./mvnw clean package
```

2. Run the Spring Boot application:

```bash
java -jar target/urlShortner-0.0.1-SNAPSHOT.jar
```

The application will start on `http://localhost:8080`.

### Using the Application

You can interact with the application using any HTTP client (Postman, curl, etc.).

- **Shorten a URL**: Send a POST request to `/url` with the long URL.
- **Retrieve the Original URL**: Send a GET request to `/url/{short-url-id}`.

### Deployed Project and Database

The project is deployed and can be accessed using the following URLs:

- **Deployed Application URL**: https://successful-adena-invictus04-e0d9f500.koyeb.app/

Make sure to replace the placeholder with actual URLs for your deployed application and database.

## Technologies Used

- Spring Boot
- PostgreSQL
- Maven
- Java 21
