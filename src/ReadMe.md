# Hotel Booking Integration

This project is a hotel booking integration system that communicates with a backend via REST API endpoints. It allows users to search, create, update, view, and cancel hotel bookings. The system is designed to handle up to 3 million booking requests per hour.

## Features

- **Search Bookings**: Retrieve a list of all bookings.
- **Create Booking**: Create a new hotel booking.
- **Update Booking**: Update an existing hotel booking.
- **View Booking**: View details of a specific booking.
- **Cancel Booking**: Cancel an existing booking.

## Technologies Used

- **Spring Boot**: Framework for building the application.
- **Spring Data JPA**: For data persistence.
- **PostgreSQL**: Relational database for storing user and hotel data.
- **Spring Boot Actuator**: For monitoring and managing the application.
- **Swagger**: For API documentation.
- **JUnit**: For unit testing.

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven
- PostgreSQL

### Installation

1. **Clone the repository**:

   ```sh
   git clone https://github.com/yourusername/hotel-booking-integration.git
   cd hotel-booking-integration

2. Configure the database:
    spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.datasource.driver-class-name=org.postgresql.Driver
    spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
    spring.jpa.hibernate.ddl-auto=update
    spring.datasource.initialization-mode=always

    #to visit database
    psql -h localhost -U username -d databasename


3. Run the application:
    ./mvnw spring-boot:run
4. Access the application:

The application will be available at http://localhost:8080.
API Endpoints
    GET /api/bookings: Retrieve all bookings.
    POST /api/bookings: Create a new booking.
    PUT /api/bookings/{id}: Update an existing booking.
    GET /api/bookings/{id}: View a specific booking.
    DELETE /api/bookings/{id}: Cancel a booking.

5, Running Tests
    To run the tests, use the following command:
    ./mvnw test

6. Monitoring and Management
The application includes Spring Boot Actuator for monitoring and management. This can be accessed with the actuator endpoints at http://localhost:8080/actuator.

Sample Data
The application includes a data.sql file that inserts sample data into the database. This file is located in the src/main/resources directory and will be executed automatically when the application starts.


