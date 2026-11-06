package com.deca.api.Controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class UserController {
    // GET http://localhost:8080/
    @GetMapping ("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
