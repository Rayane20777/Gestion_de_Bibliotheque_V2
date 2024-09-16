# Library Management System - Console Application

## Overview

This project enhances an existing console-based library management application by integrating a relational database and implementing advanced Java concepts. The goal is to improve data persistence, extend functionality, and optimize performance using advanced Java features.

## Learning Objectives

- Deepen understanding of Object-Oriented Programming (OOP) concepts in Java, including polymorphism and inheritance.
- Design and implement a simple relational database.
- Apply software design principles.

## Application Structure

### Presentation Layer

- **ConsoleUI**: Enhanced console interface with a customizable menu.

### Business Layer

- Updated business logic integration.

### Persistence Layer

- **DAO (Data Access Objects)**: Handles data access operations.

### Utility Layer

- **Generators**: Automatic isbn generation.
- **InputValidator**: Enhanced user input validation.

## Class Structure

### Document Hierarchy

- **Document**: Abstract base class.
- **Book**: Subclass of `Document`.
- **Magazine**: Subclass of `Document`.
- **ScientificJournal**: Subclass of `Document` (Attributes: `researchField`).
- **UniversityThesis**: Subclass of `Document` (Attributes: `university`, `fieldOfStudy`).
- **Library**: Manages document operations.
- **Borrowable**: Interface with methods `borrow()` and `return()`.
- **Reservable**: Interface with methods `reserve()` and `cancelReservation()`.

### User Hierarchy

- **User**: Abstract base class.
- **Student**: Subclass of `User`.
- **Professor**: Subclass of `User`.

## Core Features

### Document Management

- CRUD operations for all document types.
- Advanced search functionality.

### User Management

- CRUD operations for both user types.
- Manage borrowing rights based on user type.

### Borrowing Management

- Borrow and return documents.

### Reservation Management

- Reserve and cancel reservations for documents.

## Technical Specifications

### Java 8

- **Reference Methods**
- **Stream API**: Collection processing.
- **Functional Interfaces and Lambda Expressions**

### Database

- **PostgreSQL**: Chosen RDBMS due to its support for table inheritance, simplifying class hierarchy implementation.
- Design a relational schema in PostgreSQL.
- Use JDBC for database connectivity and operations.
- Implement SQL queries tailored for PostgreSQL.

### Collections and Hashmaps

- Optimize document search using Hashmaps.

### Garbage Collection

- **Memory Management**: Use the "try-with-resources" pattern for PostgreSQL connections and explicitly close connections in DAO methods.

## 🛠️ How to Use ShelfMaster

### Prerequisites

Ensure you have the following installed on your machine:

- **Java 8** or later
- **PostgreSQL** database with the necessary tables and schema (setup instructions below)
- **JDBC Driver** for PostgreSQL
- A console or terminal to run the application

### Installation

1. Clone this repository to your local machine:
   ```bash
   git clone https://github.com/Rayane20777/Gestion_de_Bibliotheque_V2.git
   cd Gestion_de_Bibliotheque_V2
    ```

2. Create a PostgreSQL database and run the SQL script to set up the necessary tables:
    ```bash
    psql -U yourusername -d yourdatabase -f resources/example.sql
    ```
    Replace `yourusername` and `yourdatabase` with your PostgreSQL username and database name.

3. Update the database connection details in the `DatabaseConnection` class:
    ```java
    private static final String URL = "jdbc:postgresql://localhost:5432/yourdatabase";
    private static final String USER = "yourusername";
    private static final String PASSWORD = "yourpassword";
    ```
### Running the JAR File
To run the application, execute the following command:
```bash
     cd out/artifacts/Library_jar
     java -jar Library.jar
```