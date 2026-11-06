package com.deca.api.Controllers;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController 
public class UserController {
    private final DataSource dataSource;
    public UserController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // GET http://localhost:8080/xx
    @GetMapping ("/")
    public Map<String, Object> index() {
        Boolean connected = false;
        try (Connection connection = dataSource.getConnection()) {
            connected = connection.isValid(2);
        } catch (Exception e) {
            connected = false;
        }

        String date = LocalDateTime.now().format(
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        );

        return Map.of(
            "message", "Greetings from Spring Boot! AAA", 
            "connected", connected,
            "date", date
        );
    }
}
