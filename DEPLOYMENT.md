# 🎂 Cake Store - Deployment Guide

## 🚀 Quick Deploy Options

### Option 1: Heroku (Recommended - Free)

#### Prerequisites:
- Heroku account (free)
- Git installed
- Heroku CLI installed

#### Steps:
1. **Install Heroku CLI:**
   ```bash
   # macOS
   brew tap heroku/brew && brew install heroku
   
   # Windows
   # Download from: https://devcenter.heroku.com/articles/heroku-cli
   ```

2. **Login to Heroku:**
   ```bash
   heroku login
   ```

3. **Create Heroku App:**
   ```bash
   heroku create your-cake-store-name
   ```

4. **Deploy:**
   ```bash
   git add .
   git commit -m "Deploy cake store to Heroku"
   git push heroku main
   ```

5. **Open Your App:**
   ```bash
   heroku open
   ```

### Option 2: Railway (Free Tier)

1. **Visit:** https://railway.app
2. **Connect GitHub repository**
3. **Deploy automatically**

### Option 3: Render (Free Tier)

1. **Visit:** https://render.com
2. **Connect GitHub repository**
3. **Select Java environment**
4. **Deploy**

### Option 4: DigitalOcean App Platform

1. **Visit:** https://cloud.digitalocean.com/apps
2. **Connect GitHub repository**
3. **Select Java environment**
4. **Deploy**

## 🔧 Local Build & Test

### Build the Application:
```bash
mvn clean package -DskipTests
```

### Test Locally:
```bash
java -jar target/static-webapp-0.0.1-SNAPSHOT.jar
```

### Access:
- Main Page: http://localhost:8080
- Dashboard: http://localhost:8080/dashboard.html
- API Status: http://localhost:8080/api/status

## 📁 Project Structure

```
spring-boot-static-webapp/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/staticwebapp/
│   │   │       ├── StaticWebappApplication.java
│   │   │       └── WebController.java
│   │   └── resources/
│   │       ├── static/
│   │       │   ├── index.html
│   │       │   ├── dashboard.html
│   │       │   └── about.html
│   │       └── application.properties
├── pom.xml
├── Procfile (Heroku)
├── system.properties (Heroku)
└── README.md
```

## 🌐 Environment Variables

### For Production:
- `PORT`: Server port (auto-set by cloud platforms)
- `SPRING_PROFILES_ACTIVE`: Set to 'prod'

### Optional:
- `DATABASE_URL`: If adding database later
- `REDIS_URL`: If adding caching later

## 🔒 Security Considerations

### For Production:
1. **HTTPS**: All cloud platforms provide SSL
2. **CORS**: Configured for all origins (customize as needed)
3. **Rate Limiting**: Consider adding for API endpoints
4. **Input Validation**: Add validation for API inputs

## 📊 Monitoring

### Health Check Endpoints:
- `/api/health` - Application health
- `/api/status` - Application status
- `/api/info` - Application information

## 🚀 Performance Optimization

### Current Optimizations:
- Static resource caching (1 hour)
- Optimized images from Unsplash
- Minified CSS and JavaScript
- Responsive design

### Future Enhancements:
- CDN for images
- Database integration
- Redis caching
- Load balancing

## 📞 Support

### Issues:
1. Check application logs: `heroku logs --tail`
2. Verify environment variables
3. Test locally first

### Contact:
- GitHub Issues: [Your Repository]
- Email: [Your Email]

## 🎯 Next Steps

1. **Deploy to chosen platform**
2. **Set up custom domain** (optional)
3. **Add analytics** (Google Analytics)
4. **Set up monitoring** (Uptime Robot)
5. **Add database** for real orders
6. **Implement payment gateway**

---

**Happy Deploying! 🎂✨** 