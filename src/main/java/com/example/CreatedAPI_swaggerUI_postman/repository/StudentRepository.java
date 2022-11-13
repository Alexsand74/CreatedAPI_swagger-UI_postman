package com.example.CreatedAPI_swaggerUI_postman.repository;

import com.example.CreatedAPI_swaggerUI_postman.model.Faculty;
import com.example.CreatedAPI_swaggerUI_postman.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface StudentRepository extends JpaRepository <Student, Long> {
    List <Student> findByAge(int age);
    List <Student> findByAgeBetween(int from, int to);
    Faculty getFacultyByStudentId(long id);
}
