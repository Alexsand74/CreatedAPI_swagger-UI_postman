package com.example.CreatedAPI_swaggerUI_postman.service;

import java.util.*;

import com.example.CreatedAPI_swaggerUI_postman.model.Faculty;
import com.example.CreatedAPI_swaggerUI_postman.repository.FacultyRepository;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

@Service
public class FacultyService {

private final FacultyRepository facultyRepository;
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty addFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id) {
        return facultyRepository.findById(id).orElse(null);
    }

    public Faculty editFaculty(long id, Faculty faculty) {

        Optional<Faculty> optional = facultyRepository.findById(id);
        if(!optional.isPresent()) {
            return null;
        }
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) {
        facultyRepository.deleteById(id);
    }
    public Collection<Faculty> findFacultyByColor(String color) {
        return facultyRepository.findByColor(color);
    }

    public List<Faculty> getFacultyColor(String color) {
        return facultyRepository.findByColor(color);
    }
    public Collection<Faculty> findByNameIgnoreCase(String name) {
        return facultyRepository.findByNameIgnoreCase(name);
    }
    public Collection <Faculty> findByColorIgnoreCase(String color) {
          return facultyRepository.findByColorIgnoreCase(color);


    }
}
