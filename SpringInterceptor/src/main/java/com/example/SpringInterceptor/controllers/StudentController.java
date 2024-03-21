package com.example.SpringInterceptor.controllers;

import com.example.SpringInterceptor.entities.Student;
import com.example.SpringInterceptor.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<Student> addnew(@RequestBody Student student) {
        Optional<Student> optionalStudent = studentService.aggiungi(student);
        if (optionalStudent.isPresent()) {
            return ResponseEntity.ok(optionalStudent.get());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
