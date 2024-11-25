# employee-tax-deduction
This project is a Spring Boot application that provides REST APIs for managing employee details and calculating tax deductions.

Features
Add Employee Details: API to store employee information with validation.
Calculate Tax Deductions: API to calculate yearly tax based on salary and applicable tax slabs.
Technologies Used
Java 21
Spring Boot
MySQL
Swagger (for API documentation)
Setup Instructions
Prerequisites
Java Development Kit (JDK 21) installed
MySQL database installed and running
Git installed for version control


Steps to Run the Application
Clone the repository:
git clone https://github.com/likithaDevi/employee-tax-deduction.git
cd employee-tax-deduction

Configure the database:

Create a database named employee_db.
Update the application.properties file with your MySQL username and password:

spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password


Build and run the application.

Access the APIs:

Swagger documentation: http://localhost:8080/swagger-ui.html

API Endpoints
POST /api/employees: Add employee details.
GET /api/employees/{employeeId}/tax-deductions: Get tax deductions for an employee.




