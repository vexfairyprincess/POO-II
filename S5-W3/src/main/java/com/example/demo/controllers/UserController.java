package com.example.demo.controllers;

import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.models.UsersGlobal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/usuarios")
@RestController()
public class UserController {
    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        if (user.name == null || user.password == null || user.email == null || user.role == null) {
            return ResponseEntity.badRequest().body("Faltan datos");
        }

        if (UsersGlobal.users.containsKey(user.name)) {
            return ResponseEntity.badRequest().body("El usuario ya existe");
        }

        UsersGlobal.users.put(user.name, user);
        return ResponseEntity.ok("Usuario agregado correctamente");
    }

    @GetMapping("/getAllUsers")
    public Map<String, User> getAllUsers() {
        return UsersGlobal.users;
    }

    @GetMapping("/getAllTeachers")
    public Map<String, User> getAllTeachers() {
        return UsersGlobal.users.entrySet().stream()
                .filter(entry -> entry.getValue().role == Role.PROFESOR)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @GetMapping("/countTeachersandStudents")
    public ResponseEntity<String> countTeachersandStudents() {
        long teacherCount = UsersGlobal.users.values().stream()
                .filter(user -> user.role == Role.PROFESOR)
                .count();
        long studentCount = UsersGlobal.users.values().stream()
                .filter(user -> user.role == Role.ESTUDIANTE)
                .count();

        return ResponseEntity.ok("Total de profesores: " + teacherCount + ", Total de estudiantes: " + studentCount);
    }
}