package com.deca.api.Controllers;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deca.api.Models.JavaUser;
import com.deca.api.Repositories.JavaUserRepository;


@RestController 
public class UserController {
    private final DataSource dataSource;
    private final JavaUserRepository javaUserRepository;
    public UserController(DataSource dataSource, JavaUserRepository javaUserRepository) {
        this.dataSource = dataSource;
        this.javaUserRepository = javaUserRepository;
    }

    

    // GET http://localhost:8080/
    @GetMapping (value = "/", produces = "application/json")
    public Map<String, Object> index() {
        Boolean connected = false;
        try (Connection connection = dataSource.getConnection()) {
            connected = connection.isValid(2);
        } catch (Exception exception) {
            connected = false;
        }

        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // Tipos primitivos: byte, short, int, long, float, double, boolean, char.
        byte age   = 44;                // 1 byte
        short year = 2024;              // 2 bytes
        int salary = 100000;            // 4 bytes
        long population = 8000000000L;  // 8 bytes
        // Decimal types
        float pi = 3.14f;               // 4 bytes
        double e = 2.718281828459045;   // 8 bytes
        // Boolean type
        boolean isActive = true;        // 1 bit
        // Character type
        char initial = 'A';             // 2 bytes
        
        // Tipos de referencia (objetos): String, Integer.
        Integer ageObj = 44;            // Variable length
        String name = "John Doe";       // Variable length
        int[] numbers2 = {1, 2, 3, 4, 5}; // Array of integers    PRIMITIVOS !!!
        Integer[] numbers = {1, 2, 3, 4, 5}; // Array of integers OBJETOS !!!

        // List, Map, Set y Queue son interfaces de colecciones en Java que permiten almacenar y manipular grupos de objetos.
        // ArrayList, HashMap, HashSet y ArrayDeque son implementaciones concretas de estas interfaces que proporcionan funcionalidades específicas para trabajar con colecciones de datos.
        Map<Integer, String> users1 = new HashMap<>();
        users1.put(1, "Alice");
        users1.put(2, "Bob");
        users1.put(3, "Charlie");

        List<Map<String, Object>> users = List.of(
            Map.of("id", 1, "name", "Alice", "x", "y"),
            Map.of("id", 2, "name", "Bob", "x", "z"),
            Map.of("id", 3, "name", "Charlie", "x", "w")
        );

        // A. List — listas
        List<String> names = new ArrayList<String>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.remove("Bob");

        // B. Map — clave y valor
        /*  HashMap	La más habitual. Sin orden garantizado.
            LinkedHashMap	Mantiene el orden de inserción por defecto.
            TreeMap	Ordena las claves.
            Hashtable	Antigua y sincronizada. 
            ConcurrentHashMap	Diseñada para acceso concurrente.
        */
       Map<String, Object> user = new HashMap<>();
        user.put("name", "John");
        user.put("age", 44);
        user.put("city", "Santander");

        /* C. Set — elementos únicos
            HashSet	No permite duplicados, sin orden garantizado.
            LinkedHashSet	No permite duplicados y conserva el orden de inserción.
            TreeSet	No permite duplicados y mantiene los elementos ordenados.
            EnumSet	Especializado para valores de tipo enum.
        */
       Set<String> emails = new HashSet<>();
        emails.add("john@gmail.com_");
        emails.add("maria@gmail.com");
        emails.add("john@gmail.com");

        /* D. Queue — cola (Una cola normal sigue el principio FIFO: First In, First Out.)
        ArrayDeque	    Cola o doble cola eficiente.
        LinkedList	    También implementa Queue y Deque.
        PriorityQueue	Procesa elementos según su prioridad.
        */
        ArrayDeque<String> tasks = new ArrayDeque<>();
        tasks.offer("Enviar email");
        tasks.offer("Generar informe");
        tasks.offer("Procesar pedido");

        /*
        E. Deque — cola por ambos extremos
        permite añadir y quitar elementos tanto por delante como por detrás.
        */
        Deque<String> tasksX = new ArrayDeque<>();
        tasksX.addFirst("Tarea urgente");
        tasksX.addLast("Tarea normal");

        System.out.println(tasksX.removeFirst());

        /*
        save(user)	Guarda o actualiza un usuario
        findAll()	Recupera todos los usuarios
        findById(id)	Busca por ID
        findByEmail(email)	No existe automáticamente; podemos declararlo
        deleteById(id)	Elimina por ID
        count()	Cuenta los registros
        existsById(id)	Comprueba si existe
        */

        JavaUser user1 = new JavaUser();
        user1.setEmail("john@gmail.com_" + date);
        user1.setPassword("123456");
        user1.setSalary(1000.0f);
        user1.setVisits(10);
        javaUserRepository.save(user1);
        
        int count = javaUserRepository.findAll().size();

        return Map.of(
            "count", String.valueOf(count)
        );
                //    "connected", connected,
        //    "date", date,
        //    "user", user,
        //    "users", users,
        //    "users1", users1,
        //    "names", names,
        //    "emails", emails,
        //    "user1", user1
    }
}
