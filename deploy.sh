#!/bin/bash

echo "🎂 Cake Store Deployment Script"
echo "================================"

# Check if git is installed
if ! command -v git &> /dev/null; then
    echo "❌ Git is not installed. Please install Git first."
    exit 1
fi

# Check if Maven is available
if ! command -v mvn &> /dev/null; then
    echo "⚠️  Maven not found in PATH. Using local Maven..."
    export PATH=$PATH:$(pwd)/apache-maven-3.9.6/bin
    export JAVA_HOME=$(/usr/libexec/java_home)
fi

echo "🔨 Building the application..."
mvn clean package -DskipTests

if [ $? -eq 0 ]; then
    echo "✅ Build successful!"
    
    echo ""
    echo "🚀 Choose your deployment option:"
    echo "1. Heroku (Recommended - Free)"
    echo "2. Railway (Free)"
    echo "3. Render (Free)"
    echo "4. DigitalOcean App Platform"
    echo "5. Exit"
    
    read -p "Enter your choice (1-5): " choice
    
    case $choice in
        1)
            echo "🚀 Deploying to Heroku..."
            if ! command -v heroku &> /dev/null; then
                echo "❌ Heroku CLI not found. Please install it first:"
                echo "   brew tap heroku/brew && brew install heroku"
                exit 1
            fi
            
            echo "📝 Please login to Heroku when prompted..."
            heroku login
            
            read -p "Enter your Heroku app name (or press Enter for auto-generated): " app_name
            if [ -z "$app_name" ]; then
                heroku create
            else
                heroku create $app_name
            fi
            
            echo "📤 Deploying to Heroku..."
            git add .
            git commit -m "Deploy cake store to Heroku"
            git push heroku main
            
            echo "🌐 Opening your app..."
            heroku open
            ;;
        2)
            echo "🚀 Deploying to Railway..."
            echo "📝 Please visit https://railway.app and:"
            echo "   1. Connect your GitHub repository"
            echo "   2. Select this project"
            echo "   3. Deploy automatically"
            echo ""
            echo "🔗 Your app will be available at the provided URL"
            ;;
        3)
            echo "🚀 Deploying to Render..."
            echo "📝 Please visit https://render.com and:"
            echo "   1. Connect your GitHub repository"
            echo "   2. Select Java environment"
            echo "   3. Deploy"
            echo ""
            echo "🔗 Your app will be available at the provided URL"
            ;;
        4)
            echo "🚀 Deploying to DigitalOcean..."
            echo "📝 Please visit https://cloud.digitalocean.com/apps and:"
            echo "   1. Connect your GitHub repository"
            echo "   2. Select Java environment"
            echo "   3. Deploy"
            echo ""
            echo "🔗 Your app will be available at the provided URL"
            ;;
        5)
            echo "👋 Goodbye!"
            exit 0
            ;;
        *)
            echo "❌ Invalid choice. Please run the script again."
            exit 1
            ;;
    esac
    
else
    echo "❌ Build failed. Please check the error messages above."
    exit 1
fi

echo ""
echo "🎉 Deployment completed!"
echo "📖 For more details, see DEPLOYMENT.md" 