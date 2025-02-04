# Student Grade Management System

This project is a simple Java application that uses MySQL to manage student grades for individual assignments and compute aggregate scores.

## Prerequisites

- **Java 8** or higher installed.
- **Maven** installed.
- **MySQL Server** installed.

## Setup

1. **Create the Database and Tables:**

   - Open a terminal and log in to your MySQL server.
   - Run the provided SQL script to create the database and tables:
     
     ```bash
     mysql -u your_username -p < schema.sql
     ```
     
     *(Make sure to replace `your_username` with your actual MySQL username.)*

2. **Configure Database Connection:**

   - In the `Database.java` file, adjust the connection URL, username, and password as needed:
     
     ```java
     private static final String URL = "jdbc:mysql://localhost:3306/grade_management?serverTimezone=UTC";
     private static final String USER = "root";
     private static final String PASSWORD = "your_password";
     ```
     
3. **Build the Project:**

   In the project root directory, run:
   
   ```bash
   mvn clean package
