package com.example.SpringInterceptor.services;

import com.example.SpringInterceptor.entities.Student;
import com.example.SpringInterceptor.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;


    public List<Student> getAll() {
        return studentRepo.findAll();
    }

    public Optional<Student> getById(Long id) {
        Optional<Student> studentOptional = studentRepo.findById(id);
        if (studentOptional.isPresent()) {
            return studentOptional;
        } else {
            return Optional.empty();
        }
    }

    public Optional<Student> update(Student student, Long id) {
        Optional<Student> studentOptional = studentRepo.findById(id);
        if (studentOptional.isPresent()) {
            studentOptional.get().setNome(student.getNome());
            studentOptional.get().setCognome(student.getCognome());
            Student student1 = studentRepo.save(studentOptional.get());
            return Optional.of(student1);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Student> delete(Long id) {
        Optional<Student> studentOptional = studentRepo.findById(id);
        if (studentOptional.isPresent()) {
            studentRepo.deleteById(id);
            return studentOptional;
        } else {
            return Optional.empty();
        }
    }

    public Optional<Student> aggiungi(Student student) {
        List<Student> studentList = studentRepo.findByNomeAndCognome(student.getNome(), student.getCognome());
        if (studentList.isEmpty()) {
            return Optional.of(studentRepo.save(student));
        } else {
            return Optional.empty();
        }
    }
}
