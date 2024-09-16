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