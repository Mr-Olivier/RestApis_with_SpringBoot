# Spring Boot REST APIs

A modern RESTful API built with Spring Boot that provides comprehensive CRUD operations for managing employee data.

## 🚀 Features

- **Complete CRUD Operations**: Create, read, update, and delete employee records
- **RESTful Design**: Follows REST architecture principles
- **Data Validation**: Input validation for all API requests
- **Error Handling**: Comprehensive error responses with appropriate HTTP status codes
- **Swagger Documentation**: Interactive API documentation
- **Unit & Integration Tests**: Ensuring reliability and correctness

## 📋 API Endpoints

| Method | URL | Description | Request Body | Response |
|--------|-----|-------------|--------------|----------|
| GET | `/api/employees` | Get all employees | - | Array of Employee objects |
| GET | `/api/employees/{id}` | Get employee by ID | - | Employee object |
| POST | `/api/employees` | Create new employee | Employee data | Created Employee object |
| PUT | `/api/employees/{id}` | Update employee | Employee data | Updated Employee object |
| DELETE | `/api/employees/{id}` | Delete employee | - | Success message |

## 🛠️ Technologies

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **MySQL** (Database)
- **Maven** (Build tool)
- **Swagger/OpenAPI** (API Documentation)
- **JUnit & Mockito** (Testing)

## ⚙️ Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6+
- MySQL

### Installation & Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/Mr-Olivier/RestApis_with_SpringBoot.git
   cd RestApis_with_SpringBoot
   ```

2. **Configure database**
    - Update `src/main/resources/application.properties` with your database credentials

3. **Build the application**
   ```bash
   mvn clean install
   ```

4. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

5. **Access the API**
    - The API will be available at `http://localhost:8080`
    - Swagger documentation available at `http://localhost:8080/swagger-ui.html`

## 📝 Usage Examples

### Create a new employee

```bash
curl -X POST http://localhost:8080/api/employees \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "department": "Engineering"
  }'
```

### Get all employees

```bash
curl -X GET http://localhost:8080/api/employees
```

### Update an employee

```bash
curl -X PUT http://localhost:8080/api/employees/1 \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.updated@example.com",
    "department": "Management"
  }'
```

### Delete an employee

```bash
curl -X DELETE http://localhost:8080/api/employees/1
```

## 🧪 Running Tests

```bash
# Run all tests
mvn test

# Run only unit tests
mvn test -Dtest=*UnitTest

# Run only integration tests
mvn test -Dtest=*IntegrationTest
```

## 📚 API Documentation

Full API documentation is available through Swagger UI when the application is running:
- Access at: `http://localhost:8080/swagger-ui.html`

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

- **Olivier** - [Mr-Olivier](https://github.com/Mr-Olivier)

## 🙏 Acknowledgments

- Spring Boot Documentation
- Java EE Community
- All contributors who participate in this project