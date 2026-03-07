# Job Tracker API

A Spring Boot REST API for tracking job applications.

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven

## Architecture

The project follows layered architecture:

Controller → Service → Repository → Database

Entities represent database tables.  
DTOs are used to control API responses.  
Global exception handling provides consistent error responses.

## Features

- Create job applications
- Update applications
- Delete applications
- Retrieve all applications
- Retrieve application by ID
- Validation using Jakarta Validation
- Global exception handling
- DTO-based API responses

## Entities

User  
Company  
JobApplication

Each job application belongs to a user and a company.

## Example Endpoint

GET /applications

Example response:

```json
[
  {
    "id": 1,
    "role": "Backend Engineer",
    "status": "APPLIED",
    "appliedDate": "2026-03-07",
    "userId": 1,
    "companyId": 1
  }
]