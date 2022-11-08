package com.example.CreatedAPI_swaggerUI_postman.repository;

import com.example.CreatedAPI_swaggerUI_postman.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository <Student, Long> {
//    Student delete(long id);
}
