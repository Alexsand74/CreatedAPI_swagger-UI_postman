package com.example.CreatedAPI_swaggerUI_postman.repository;

import com.example.CreatedAPI_swaggerUI_postman.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface StudentRepository extends JpaRepository <Student, Long> {
    Collection<Student> findByAge(int age);

    Collection<Student> findByAgeBetween(int from, int to);
}
