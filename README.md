<!DOCTYPE html>
<html>
<head>
    <title>Project README</title>
</head>
<body>
    <h1>Project README</h1>
    
    <h2>Overview</h2>
    <p>This README provides an overview of my project, showcasing my skills and knowledge in developing a system that leverages an API to fetch data about heroes from the popular Dota game. The project utilizes a stack of technologies, including Spring, Java, MySQL, Spring JPA, Kafka with ZooKeeper for user registration flows, and Docker for seamless deployment.</p>
    
    <h2>Project Details</h2>
    
    <h3>Technology Stack</h3>
    <p>The project makes use of the following key technologies:</p>
    <ul>
        <li><strong>Spring Framework:</strong> Leveraged for its robustness and versatility, Spring provides a solid foundation for building enterprise-grade applications.</li>
        <li><strong>Java:</strong> The primary programming language used in the project, known for its portability and extensive libraries.</li>
        <li><strong>MySQL:</strong> The chosen relational database management system for efficient data storage and management.</li>
        <li><strong>Spring JPA:</strong> This simplifies database interactions, making data access more efficient and maintainable.</li>
        <li><strong>Kafka with ZooKeeper:</strong> Kafka, in conjunction with ZooKeeper, handles real-time data streaming and processing, demonstrating my capabilities in managing data events effectively.</li>
        <li><strong>Docker:</strong> Docker is employed for containerization, ensuring consistency across different environments and facilitating automatic deployment.</li>
    </ul>
    
    <h3>Deployment</h3>
    <p>The deployment process is streamlined using Docker Compose. By simply executing the <code>build-and-deploy.yml</code> file, all the necessary components are automatically deployed. This highlights my ability to set up a hassle-free deployment pipeline.</p>
    
    <h3>API Endpoints</h3>
    <p>The application exposes Swagger documentation for the following key endpoints:</p>
    <ul>
        <li><strong>Main API Swagger:</strong> Access the Swagger documentation for the main API at <a href="http://localhost:8080/principal/swagger-ui/index.html">http://localhost:8080/principal/swagger-ui/index.html</a>.</li>
        <li><strong>Registration API Swagger:</strong> Find the Swagger documentation for the registration API at <a href="http://localhost:8080/register/swagger-ui/index.html">http://localhost:8080/register/swagger-ui/index.html</a>.</li>
    </ul>
    
    <h3>Key Features</h3>
    <ul>
        <li><strong>ETag and Caching:</strong> The application incorporates ETag and caching mechanisms to optimize API calls to the primary API, enhancing performance and reducing redundant requests.</li>
        <li><strong>Rate Limiting with Kong:</strong> Kong is utilized to enforce rate limiting on the primary API, ensuring that excessive traffic does not overwhelm the system.</li>
    </ul>
    
    <h2>Getting Started</h2>
    <p>To explore the project locally and interact with its functionality, follow these steps:</p>
    <ol>
        <li>Clone the project repository to your local machine.</li>
        <li>Navigate to the project directory.</li>
        <li>Execute the <code>build-and-deploy.yml</code> file to set up the application using Docker Compose.</li>
        <li>Access the Swagger endpoints to interact with the APIs.</li>
    </ol>
    
    <h2>Conclusion</h2>
    <p>This project serves as a comprehensive showcase of my skills and knowledge, spanning from data consumption to automated deployment. By utilizing Spring, Java, MySQL, Kafka, Docker, and implementing ETag, caching, and rate limiting, I've demonstrated my ability to create robust and efficient systems. The Swagger endpoints provide a clear overview of the APIs and their capabilities, emphasizing my commitment to delivering well-documented and user-friendly solutions.</p>
    
    <p>For inquiries or potential collaborations, please feel free to contact me at <a href="mailto:your-email@example.com">your-email@example.com</a>.</p>
</body>
</html>
