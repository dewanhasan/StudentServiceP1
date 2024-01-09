Welcome to the Student Registration Hub! This Java microservices-based application orchestrates a seamless registration process. Using three interconnected microservices,
this system operates as a centralized registration hub for students. Each microservice communicates effectively, ensuring a smooth flow of data and processes. Upon receiving 
a POST request for student registration, this system orchestrates the necessary actions across services, culminating in a confirmation message that signifies successful student 
registration. Utilizing Docker Hub, the microservices are containerized for efficient deployment and scalability, providing a robust and flexible architecture. Powered by an H2
database, our system offers a comprehensive range of functionalities. From registering new students, storing their details securely, to performing operations like finding 
students by their names, deleting entries by ID, and updating student details using their date of birth, our system simplifies the management of student data.


database: http://localhost:8081/h2-console
Driver class: org.h2.Driver
jdbcURL:jdbc:h2:mem:StudentApp
username: dewan
password: password

The youtube link demonstrating the working of this application:
https://www.youtube.com/watch?v=4jjgOjEcnJs

