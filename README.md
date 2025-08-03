# Spring Boot Static Web Application

A beautiful, modern web application built with Spring Boot that serves static HTML content with CSS animations and JavaScript interactivity.

## Features

- 🚀 **Spring Boot 3.2.0** - Latest version with Java 17
- 🎨 **Modern UI** - Beautiful gradients, animations, and responsive design
- 📱 **Mobile Responsive** - Works perfectly on all devices
- ⚡ **Fast Performance** - Optimized static resource serving
- 🔧 **Easy to Customize** - Clean, well-structured code

## Project Structure

```
spring-boot-static-webapp/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/staticwebapp/
│   │   │       └── StaticWebappApplication.java
│   │   └── resources/
│   │       ├── static/
│   │       │   ├── index.html
│   │       │   └── about.html
│   │       └── application.properties
├── pom.xml
└── README.md
```

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

## Getting Started

### 1. Clone or Download the Project

Navigate to the project directory:
```bash
cd spring-boot-static-webapp
```

### 2. Build the Application

```bash
mvn clean install
```

### 3. Run the Application

```bash
mvn spring-boot:run
```

Or run the JAR file:
```bash
java -jar target/static-webapp-0.0.1-SNAPSHOT.jar
```

### 4. Access the Application

Open your web browser and navigate to:
- **Homepage**: http://localhost:8080
- **About Page**: http://localhost:8080/about.html

## Application Features

### Homepage (`index.html`)
- Interactive buttons with hover effects
- Theme changing functionality
- Real-time clock display
- Status checking feature
- Responsive grid layout

### About Page (`about.html`)
- Detailed project information
- Technology stack overview
- Navigation back to homepage
- Consistent styling with main page

## Customization

### Adding New Pages
1. Create new HTML files in `src/main/resources/static/`
2. Follow the existing styling patterns
3. Add navigation links between pages

### Modifying Styles
- Edit the CSS in the `<style>` sections of HTML files
- Use the existing gradient and animation patterns
- Maintain responsive design principles

### Adding JavaScript Functionality
- Add new functions in the `<script>` sections
- Follow the existing naming conventions
- Test interactivity across different devices

## Configuration

The application can be configured through `src/main/resources/application.properties`:

- **Server Port**: Change `server.port` to use a different port
- **Static Resources**: Modify `spring.web.resources.static-locations` for custom static file locations
- **Caching**: Adjust `spring.web.resources.cache.period` for different caching strategies

## Deployment

### Local Development
```bash
mvn spring-boot:run
```

### Production Build
```bash
mvn clean package
java -jar target/static-webapp-0.0.1-SNAPSHOT.jar
```

### Docker Deployment
```bash
# Build Docker image
docker build -t static-webapp .

# Run container
docker run -p 8080:8080 static-webapp
```

## Technologies Used

- **Spring Boot 3.2.0** - Application framework
- **Java 17** - Programming language
- **Maven** - Build tool and dependency management
- **HTML5** - Markup language
- **CSS3** - Styling with modern features
- **JavaScript** - Client-side interactivity

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a pull request

## License

This project is open source and available under the [MIT License](LICENSE).

## Support

For questions or issues, please create an issue in the repository or contact the development team.

---

**Happy Coding! 🚀** 