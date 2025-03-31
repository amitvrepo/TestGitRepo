package com.example.sampleweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SampleWebApplication { 
    public static void main(String[] args) {
        SpringApplication.run(SampleWebApplication.class, args);
    }
    
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Azure Kubernetes!";
    }
}
