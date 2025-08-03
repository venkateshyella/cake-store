#!/bin/bash

echo "🚀 Spring Boot Static Web Application"
echo "======================================"

# Check if Java is installed
if ! command -v java &> /dev/null; then
    echo "❌ Java is not installed. Please install Java 17 or higher."
    exit 1
fi

# Check Java version
JAVA_VERSION=$(java -version 2>&1 | head -n 1 | cut -d'"' -f2 | cut -d'.' -f1)
if [ "$JAVA_VERSION" -lt "11" ]; then
    echo "❌ Java version $JAVA_VERSION is too old. Please install Java 11 or higher."
    exit 1
fi

echo "✅ Java version: $(java -version 2>&1 | head -n 1)"

# Check if Maven is installed
if ! command -v mvn &> /dev/null; then
    echo "⚠️  Maven is not installed. Attempting to install..."
    
    # Try to install Maven using Homebrew
    if command -v brew &> /dev/null; then
        echo "📦 Installing Maven using Homebrew..."
        brew install maven
    else
        echo "❌ Homebrew not found. Please install Maven manually:"
        echo "   Visit: https://maven.apache.org/download.cgi"
        echo "   Or install Homebrew first: https://brew.sh"
        exit 1
    fi
fi

echo "✅ Maven version: $(mvn -version 2>&1 | head -n 1)"

# Build the application
echo "🔨 Building the application..."
mvn clean compile

if [ $? -eq 0 ]; then
    echo "✅ Build successful!"
    
    # Run the application
    echo "🚀 Starting the application..."
    echo "📱 Open your browser and go to: http://localhost:8080"
    echo "📄 About page: http://localhost:8080/about.html"
    echo "🔌 API endpoints:"
    echo "   - http://localhost:8080/api/status"
    echo "   - http://localhost:8080/api/info"
    echo "   - http://localhost:8080/api/health"
    echo ""
    echo "Press Ctrl+C to stop the application"
    
    mvn spring-boot:run
else
    echo "❌ Build failed. Please check the error messages above."
    exit 1
fi 