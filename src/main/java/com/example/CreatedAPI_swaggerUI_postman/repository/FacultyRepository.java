package com.example.CreatedAPI_swaggerUI_postman.repository;

import com.example.CreatedAPI_swaggerUI_postman.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository <Faculty,Long>{
//    Faculty delete(long id);
}
