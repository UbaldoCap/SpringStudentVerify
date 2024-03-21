package com.example.SpringInterceptor.repositories;

import com.example.SpringInterceptor.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    List<Student> findByNomeAndCognome(String nome, String cognome);
}
