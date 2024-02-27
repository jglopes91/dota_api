Project Details
---------------

### Technology Stack

The project makes use of the following key technologies:

*   **Spring Framework:** Leveraged for its robustness and versatility, Spring provides a solid foundation for building enterprise-grade applications.
*   **Java:** The primary programming language used in the project, known for its portability and extensive libraries.
*   **MySQL:** The chosen relational database management system for efficient data storage and management.
*   **Spring JPA:** This simplifies database interactions, making data access more efficient and maintainable.
*   **Kafka with ZooKeeper:** Kafka, in conjunction with ZooKeeper, handles real-time data streaming and processing, demonstrating my capabilities in managing data events effectively.
*   **Docker:** Docker is employed for containerization, ensuring consistency across different environments and facilitating automatic deployment.

### Deployment

The deployment process is streamlined using Docker Compose. By simply executing the `build-and-deploy.yml` file, all the necessary components are automatically deployed. This highlights my ability to set up a hassle-free deployment pipeline.

### API Endpoints

The application exposes Swagger documentation for the following key endpoints:

*   **Main API Swagger:** Access the Swagger documentation for the main API at [http://localhost:8080/principal/swagger-ui/index.html](http://localhost:8080/principal/swagger-ui/index.html).
*   **Registration API Swagger:** Find the Swagger documentation for the registration API at [http://localhost:8080/register/swagger-ui/index.html](http://localhost:8080/register/swagger-ui/index.html).

### Key Features

*   **ETag and Caching:** The application incorporates ETag and caching mechanisms to optimize API calls to the primary API, enhancing performance and reducing redundant requests.
*   **Rate Limiting with Kong:** Kong is utilized to enforce rate limiting on the primary API, ensuring that excessive traffic does not overwhelm the system.

Getting Started
---------------

To explore the project locally and interact with its functionality, follow these steps:

1.  Clone the project repository to your local machine.
2.  Navigate to the project directory.
3.  Execute the `build-and-deploy.yml` file to set up the application using Docker Compose.
4.  Access the Swagger endpoints to interact with the APIs.

Conclusion
----------

This project serves as a comprehensive showcase of my skills and knowledge, spanning from data consumption to automated deployment. By utilizing Spring, Java, MySQL, Kafka, Docker, and implementing ETag, caching, and rate limiting, I've demonstrated my ability to create robust and efficient systems. The Swagger endpoints provide a clear overview of the APIs and their capabilities, emphasizing my commitment to delivering well-documented and user-friendly solutions.

For inquiries or potential collaborations, please feel free to contact me at [jglopes91@gmail.com](mailto:jglopes91@gmail.com).