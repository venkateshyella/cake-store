# Installation Guide

This guide will help you set up the development environment for the Spring Boot Static Web Application.

## Prerequisites

### 1. Java (Required)
The application requires Java 11 or higher. You can check your current Java version with:
```bash
java -version
```

**Installation Options:**
- **macOS**: Download from [Oracle](https://www.oracle.com/java/technologies/downloads/) or use Homebrew: `brew install openjdk@17`
- **Windows**: Download from [Oracle](https://www.oracle.com/java/technologies/downloads/)
- **Linux**: Use your package manager or download from Oracle

### 2. Maven (Required)
Maven is used for building and managing the project dependencies.

**Installation Options:**

#### Option A: Using Homebrew (macOS)
```bash
brew install maven
```

#### Option B: Manual Installation
1. Download Maven from [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi)
2. Extract the archive to a directory (e.g., `/usr/local/maven`)
3. Add Maven to your PATH:
   ```bash
   export PATH=$PATH:/usr/local/maven/bin
   ```
4. Add the above line to your shell profile (`.bashrc`, `.zshrc`, etc.)

#### Option C: Using SDKMAN (Linux/macOS)
```bash
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk install maven
```

### 3. Docker (Optional)
For containerized deployment, install Docker:
- **macOS**: Download from [Docker Desktop](https://www.docker.com/products/docker-desktop)
- **Windows**: Download from [Docker Desktop](https://www.docker.com/products/docker-desktop)
- **Linux**: Follow instructions at [https://docs.docker.com/engine/install/](https://docs.docker.com/engine/install/)

## Verification

After installation, verify that everything is working:

```bash
# Check Java
java -version

# Check Maven
mvn -version

# Check Docker (if installed)
docker --version
```

## Quick Start

Once you have Java and Maven installed, you can run the application:

```bash
# Navigate to the project directory
cd spring-boot-static-webapp

# Run the application
./run.sh
```

Or manually:
```bash
mvn spring-boot:run
```

## Troubleshooting

### Maven Installation Issues
If you encounter issues installing Maven:

1. **macOS with Xcode issues**: Install Xcode from the App Store first
2. **Permission issues**: Use `sudo` or fix permissions
3. **PATH issues**: Ensure Maven is in your system PATH

### Java Version Issues
If you have multiple Java versions installed:

```bash
# List installed Java versions
/usr/libexec/java_home -V

# Set JAVA_HOME
export JAVA_HOME=$(/usr/libexec/java_home -v 17)
```

### Port Already in Use
If port 8080 is already in use:
1. Change the port in `src/main/resources/application.properties`
2. Or kill the process using port 8080:
   ```bash
   lsof -ti:8080 | xargs kill -9
   ```

## Next Steps

After successful installation:
1. Run the application using `./run.sh`
2. Open your browser to `http://localhost:8080`
3. Explore the application features
4. Check out the API endpoints at `/api/status`, `/api/info`, and `/api/health`

## Support

If you encounter any issues:
1. Check the troubleshooting section above
2. Verify all prerequisites are installed correctly
3. Check the application logs for error messages
4. Create an issue in the project repository 