package com.example.staticwebapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

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
        
        try {
            // Read CSV file from resources
            Resource resource = new ClassPathResource("static/products.csv");
            List<String> lines = Files.readAllLines(resource.getFile().toPath());
            
            // Skip header line
            for (int i = 1; i < lines.size(); i++) {
                String line = lines.get(i);
                String[] values = line.split(",");
                
                if (values.length >= 14) {
                    Map<String, Object> product = new HashMap<>();
                    product.put("id", Integer.parseInt(values[0]));
                    product.put("name", values[1]);
                    product.put("price", Integer.parseInt(values[2]));
                    product.put("category", values[3]);
                    product.put("image", values[4]);
                    product.put("description", values[5]);
                    product.put("rating", Double.parseDouble(values[6]));
                    product.put("reviews", Integer.parseInt(values[7]));
                    product.put("badge", values[8]);
                    product.put("weight", values[9]);
                    product.put("flavor", values[10]);
                    product.put("ingredients", values[11]);
                    product.put("deliveryTime", values[12]);
                    product.put("location", values[13]);
                    
                    products.add(product);
                }
            }
        } catch (Exception e) {
            // Fallback to hardcoded data if CSV reading fails
            Map<String, Object> product1 = new HashMap<>();
            product1.put("id", 1);
            product1.put("name", "Chocolate Truffle Delight");
            product1.put("price", 2499);
            product1.put("category", "Chocolate");
            product1.put("image", "https://images.unsplash.com/photo-1578985545062-69928b1d9587?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2070&q=80");
            product1.put("description", "Rich chocolate layers with ganache and gold leaf decoration");
            product1.put("rating", 4.9);
            product1.put("reviews", 127);
            product1.put("badge", "Bestseller");
            product1.put("weight", "1.5 kg");
            product1.put("flavor", "Chocolate");
            product1.put("ingredients", "Dark chocolate, cream, butter, eggs, flour, sugar");
            product1.put("deliveryTime", "4 hours");
            product1.put("location", "Hyderabad");
            products.add(product1);

            Map<String, Object> product2 = new HashMap<>();
            product2.put("id", 2);
            product2.put("name", "Vanilla Dream Wedding Cake");
            product2.put("price", 5999);
            product2.put("category", "Wedding");
            product2.put("image", "https://images.unsplash.com/photo-1565958011703-44f9829ba187?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2070&q=80");
            product2.put("description", "Elegant white cake with fresh flowers and pearl accents");
            product2.put("rating", 5.0);
            product2.put("reviews", 89);
            product2.put("badge", "Premium");
            product2.put("weight", "3 kg");
            product2.put("flavor", "Vanilla");
            product2.put("ingredients", "Vanilla bean, butter, eggs, flour, sugar, fresh flowers");
            product2.put("deliveryTime", "6 hours");
            product2.put("location", "Hyderabad");
            products.add(product2);
        }
        
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