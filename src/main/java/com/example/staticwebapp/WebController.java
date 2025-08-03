package com.example.staticwebapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@CrossOrigin(origins = "*")
public class WebController {

    @GetMapping("/api/status")
    public Map<String, Object> getStatus() {
        Map<String, Object> status = new HashMap<>();
        status.put("status", "running");
        status.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        status.put("application", "Spring Boot Static Webapp");
        status.put("version", "1.0.0");
        return status;
    }

    @GetMapping("/api/info")
    public Map<String, Object> getInfo() {
        Map<String, Object> info = new HashMap<>();
        info.put("name", "Spring Boot Static Web Application");
        info.put("description", "A beautiful, modern web application built with Spring Boot");
        info.put("features", new String[]{
            "Static HTML serving",
            "Modern CSS with animations",
            "Responsive design",
            "JavaScript interactivity",
            "REST API endpoints"
        });
        info.put("technologies", new String[]{
            "Spring Boot 2.7.18",
            "Java 11",
            "HTML5",
            "CSS3",
            "JavaScript"
        });
        return info;
    }

    @GetMapping("/api/health")
    public Map<String, String> getHealth() {
        Map<String, String> health = new HashMap<>();
        health.put("status", "UP");
        health.put("message", "Application is healthy and running");
        return health;
    }

    @GetMapping("/api/products")
    public List<Map<String, Object>> getProducts() {
        List<Map<String, Object>> products = new ArrayList<>();
        
        Map<String, Object> product1 = new HashMap<>();
        product1.put("id", 1);
        product1.put("name", "Chocolate Truffle Cake");
        product1.put("price", 599);
        product1.put("category", "Chocolate");
        product1.put("image", "🍰");
        product1.put("description", "Rich chocolate truffle cake with chocolate ganache");
        products.add(product1);

        Map<String, Object> product2 = new HashMap<>();
        product2.put("id", 2);
        product2.put("name", "Red Velvet Cake");
        product2.put("price", 799);
        product2.put("category", "Red Velvet");
        product2.put("image", "🎂");
        product2.put("description", "Classic red velvet cake with cream cheese frosting");
        products.add(product2);

        Map<String, Object> product3 = new HashMap<>();
        product3.put("id", 3);
        product3.put("name", "Black Forest Cake");
        product3.put("price", 699);
        product3.put("category", "Chocolate");
        product3.put("image", "🧁");
        product3.put("description", "German chocolate cake with cherries and whipped cream");
        products.add(product3);

        Map<String, Object> product4 = new HashMap<>();
        product4.put("id", 4);
        product4.put("name", "Vanilla Cream Cake");
        product4.put("price", 499);
        product4.put("category", "Vanilla");
        product4.put("image", "🍰");
        product4.put("description", "Light vanilla sponge with vanilla cream");
        products.add(product4);

        Map<String, Object> product5 = new HashMap<>();
        product5.put("id", 5);
        product5.put("name", "Butterscotch Cake");
        product5.put("price", 649);
        product5.put("category", "Butterscotch");
        product5.put("image", "🎂");
        product5.put("description", "Delicious butterscotch flavored cake");
        products.add(product5);

        Map<String, Object> product6 = new HashMap<>();
        product6.put("id", 6);
        product6.put("name", "Pineapple Cake");
        product6.put("price", 549);
        product6.put("category", "Fruit");
        product6.put("image", "🧁");
        product6.put("description", "Fresh pineapple cake with tropical flavors");
        products.add(product6);

        return products;
    }

    @GetMapping("/api/categories")
    public List<Map<String, Object>> getCategories() {
        List<Map<String, Object>> categories = new ArrayList<>();
        
        Map<String, Object> category1 = new HashMap<>();
        category1.put("id", 1);
        category1.put("name", "Trending Cakes");
        category1.put("items", Arrays.asList("Gourmet Cakes", "Bento Cakes", "Labubu Cakes", "Cricket Cakes", "Pinata Cakes", "Drip Cakes", "Bomb Cakes", "Pull Me Up Cakes"));
        categories.add(category1);

        Map<String, Object> category2 = new HashMap<>();
        category2.put("id", 2);
        category2.put("name", "By Type");
        category2.put("items", Arrays.asList("Bestsellers", "Eggless Cakes", "Photo Cakes", "Cheese Cakes", "Half Cakes", "Heart Shaped Cakes", "Rose Cakes", "All Cakes"));
        categories.add(category2);

        Map<String, Object> category3 = new HashMap<>();
        category3.put("id", 3);
        category3.put("name", "By Flavours");
        category3.put("items", Arrays.asList("Chocolate Cakes", "Butterscotch Cakes", "Pineapple Cakes", "Kit Kat Cakes", "Black Forest Cakes", "Red Velvet Cakes", "Vanilla Cakes", "Fruit Cakes", "Blueberry Cakes"));
        categories.add(category3);

        Map<String, Object> category4 = new HashMap<>();
        category4.put("id", 4);
        category4.put("name", "Delivery Cities");
        category4.put("items", Arrays.asList("Cakes To Bangalore", "Cakes To Delhi", "Cakes To Gurgaon", "Cakes To Hyderabad", "Cakes To Noida", "Cakes To Mumbai", "Cakes To Jaipur", "Cakes To Pune", "Cakes To Chandigarh", "Cakes To Chennai"));
        categories.add(category4);

        return categories;
    }

    @PostMapping("/api/cart/add")
    public Map<String, Object> addToCart(@RequestBody Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Product added to cart successfully");
        response.put("productId", request.get("productId"));
        response.put("productName", request.get("productName"));
        response.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        return response;
    }

    @GetMapping("/api/dashboard/stats")
    public Map<String, Object> getDashboardStats() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("totalProducts", 6);
        stats.put("totalCategories", 4);
        stats.put("totalOrders", 25);
        stats.put("revenue", 15450);
        stats.put("activeUsers", 12);
        stats.put("lastUpdated", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        return stats;
    }
} 