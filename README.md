Task Management API
This project is a simple Task Management RESTful API built using Spring Boot and MySQL. It provides functionality to create, update, delete, and retrieve tasks, and is ready to integrate with any frontend task management application.

Features
 - Create a new task
 - Update an existing task
 - Delete a task
 - Retrieve a specific task by ID
 - Retrieve all tasks

Technologies Used
 - Backend: Spring Boot
 - Database: MySQL
 - Persistence: Hibernate (JPA)
 - Testing: Postman
 - Dependency Management: Maven

Prerequisites
 - Java 17 or later
 - MySQL
 - Maven
 - Postman (for testing)

API Endpoints
 - Create Task
    - POST /taskApi/saveTask
    - JSON
      {
      "title": "Task title",
      "description": "Task description",
      "completed": false
      }
 - Update Task
    - PUT /taskApi/updateTask/{id}
    - JSON
      {
      "title": "Updated title",
      "description": "Updated description",
      "completed": true
      }

 - Delete Task
    - DELETE /taskApi/deleteTask/{id}

 - Get Task by ID
    - GET /taskApi/fetchTaskById/{id}

 - Get All Tasks
   - GET /taskApi/fetchAllTasks

Testing with Postman
You can use Postman to test the API by sending HTTP requests to the respective endpoints listed above.
