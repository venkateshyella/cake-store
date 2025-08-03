#!/bin/bash

echo "🎂 CAKE STORE - LIVE LAUNCH SCRIPT"
echo "=================================="
echo ""

echo "📋 STEP 1: GitHub Repository Setup"
echo "----------------------------------"
echo "1. Go to https://github.com"
echo "2. Click 'New repository'"
echo "3. Name: cake-store"
echo "4. Make it Public"
echo "5. Click 'Create repository'"
echo ""

read -p "Enter your GitHub username: " github_username

if [ -z "$github_username" ]; then
    echo "❌ Please enter your GitHub username"
    exit 1
fi

echo ""
echo "🔧 Updating remote URL..."
git remote set-url origin https://github.com/$github_username/cake-store.git

echo ""
echo "📤 Pushing to GitHub..."
git push -u origin main

if [ $? -eq 0 ]; then
    echo "✅ Successfully pushed to GitHub!"
    echo ""
    echo "🚀 STEP 2: Deploy on Railway"
    echo "----------------------------"
    echo "1. Visit: https://railway.app"
    echo "2. Click 'Start a New Project'"
    echo "3. Select 'Deploy from GitHub repo'"
    echo "4. Choose your cake-store repository"
    echo "5. Railway will automatically deploy!"
    echo ""
    echo "⏱️  Your site will be live in 2-3 minutes!"
    echo ""
    echo "🌐 Your live URL will be: https://your-cake-store.railway.app"
    echo ""
    echo "🎉 CONGRATULATIONS! Your cake store is going live!"
    echo ""
    echo "📱 What you'll get:"
    echo "   ✅ Professional e-commerce website"
    echo "   ✅ Real cake images from Unsplash"
    echo "   ✅ Mobile-responsive design"
    echo "   ✅ HTTPS security"
    echo "   ✅ Global CDN"
    echo "   ✅ REST API backend"
    echo ""
    echo "🔗 Alternative deployment options:"
    echo "   • Render: https://render.com"
    echo "   • DigitalOcean: https://cloud.digitalocean.com/apps"
    echo ""
else
    echo "❌ Failed to push to GitHub. Please check your repository URL."
    echo "Make sure you've created the repository at: https://github.com/$github_username/cake-store"
fi 