# Social Media - API

## Overview
The Social Media - API project provides APIs for user management (CRUD operations) with Spring Security, as well as APIs for managing posts (CRUD operations). The project is built using the Spring / Spring Boot framework, with a MySQL database, and Hibernate for ORM.

## Features
- User APIs:
  - CRUD operations for user management.
  - Integration with Spring Security for authentication and authorization.
- Post APIs:
  - CRUD operations for managing posts.

## Technologies Used
- Spring / Spring Boot framework
- Spring Security
- Swagger Documentation
- Spring HATEOAS
- MySQL database
- Hibernate for ORM

## Installation
To install and run this project locally, follow these steps:

1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/social-media-api.git
   ```
2. Navigate to the project directory:
   ```sh
   cd social-media-api
   ```
3. Configure the MySQL database:
   - Option 1: **Direct Configuration**:
     - Ensure MySQL is installed and running on your machine.
     - Create a new database named `social_media_db`.
     - Update the database configurations in `application.properties`:
       ```
       spring.datasource.url=jdbc:mysql://localhost:3306/social_media_db
       spring.datasource.username=your_username
       spring.datasource.password=your_password
       ```
   - Option 2: **Using Docker** (if Docker is installed):
     - Run the MySQL Docker container:
       ```sh
       docker run -d -p 3306:3306 --name social-media-db -e MYSQL_ROOT_PASSWORD=your_password -e MYSQL_DATABASE=social_media_db mysql:latest
       ```
     - Update the database configurations in `application.properties`:
       ```
       spring.datasource.url=jdbc:mysql://localhost:3306/social_media_db
       spring.datasource.username=root
       spring.datasource.password=your_password
       ```

4. Build the project using Maven:
   ```sh
   mvn clean install
   ```
5. Run the application:
   ```sh
   java -jar target/social-media-api.jar
   ```
6. The API will be accessible at `http://localhost:8080`.

## Usage

### User Operations

#### Create User
- **Endpoint:** `POST /api/users`
- **Description:** Create a new user.
- **Request Body:**
  ```json
  {
    "username": "example_user",
    "email": "example@example.com",
    "password": "password123"
  }
  ```
- **Response:** Returns the newly created user object.

#### Read User
- **Endpoint:** `GET /api/users/{userId}`
- **Description:** Get details of a specific user.
- **Parameters:**
  - `{userId}`: ID of the user to retrieve.
- **Response:** Returns the user object.

#### Update User
- **Endpoint:** `PUT /api/users/{userId}`
- **Description:** Update details of a specific user.
- **Parameters:**
  - `{userId}`: ID of the user to update.
- **Request Body:**
  ```json
  {
    "username": "updated_user",
    "email": "updated@example.com"
  }
  ```
- **Response:** Returns the updated user object.

#### Delete User
- **Endpoint:** `DELETE /api/users/{userId}`
- **Description:** Delete a specific user.
- **Parameters:**
  - `{userId}`: ID of the user to delete.
- **Response:** Returns a success message.

### Post Operations

#### Create Post
- **Endpoint:** `POST /api/posts`
- **Description:** Create a new post.
- **Request Body:**
  ```json
  {
    "userId": "userId",
    "content": "This is a sample post."
  }
  ```
- **Response:** Returns the newly created post object.

#### Read Post
- **Endpoint:** `GET /api/posts/{postId}`
- **Description:** Get details of a specific post.
- **Parameters:**
  - `{postId}`: ID of the post to retrieve.
- **Response:** Returns the post object.

#### Update Post
- **Endpoint:** `PUT /api/posts/{postId}`
- **Description:** Update details of a specific post.
- **Parameters:**
  - `{postId}`: ID of the post to update.
- **Request Body:**
  ```json
  {
    "content": "Updated content."
  }
  ```
- **Response:** Returns the updated post object.

#### Delete Post
- **Endpoint:** `DELETE /api/posts/{postId}`
- **Description:** Delete a specific post.
- **Parameters:**
  - `{postId}`: ID of the post to delete.
- **Response:** Returns a success message.

## Contributing
Contributions are welcome! Please fork the repository and submit a pull request with your changes.

## License
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

## Acknowledgements
- [Spring](https://spring.io) for providing the powerful Spring framework.
- [Hibernate](https://hibernate.org) for ORM capabilities.
- [Swagger](https://swagger.io) for API documentation.
- [Spring HATEOAS](https://spring.io/projects/spring-hateoas) for hypermedia-driven REST APIs.
- [in28minutes](https://in28minutes.com) for helping to learn the concepts of Spring Boot and backend development.
