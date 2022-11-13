package com.example.CreatedAPI_swaggerUI_postman.repository;

import com.example.CreatedAPI_swaggerUI_postman.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;
import java.util.Collection;
import java.util.List;

public interface FacultyRepository extends JpaRepository <Faculty,Long>{
    List<Faculty> findByColor(String color);
    List<Faculty> findByNameIgnoreCase (String name);
    List<Faculty> findByColorIgnoreCase(String color);

}
