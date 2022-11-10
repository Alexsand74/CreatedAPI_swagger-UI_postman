package com.example.CreatedAPI_swaggerUI_postman.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

import com.example.CreatedAPI_swaggerUI_postman.model.Faculty;
import com.example.CreatedAPI_swaggerUI_postman.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyService {
//    private final HashMap<Long, Faculty> faculties = new HashMap<>();
//    private long count = 0;
private final FacultyRepository facultyRepository;
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty addFaculty(Faculty faculty) {
//        faculty.setId(count++);
//        faculties.put(faculty.getId(), faculty);
//        return faculty;
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id) {
//        return faculties.get(id);
        return facultyRepository.findById(id).orElse(null);
    }

    public Faculty editFaculty(long id, Faculty faculty) {
//        if (!faculties.containsKey(id)) {
//            return null;
//        }
//        faculties.put(id, faculty);
//        return faculty;
//        if (!(facultyRepository.findById(id) == null)) {
//            return facultyRepository.save(faculty);
//        } return facultyRepository.findById(id).orElse(null);
//  findById возвращает Optional и он не будет наллом никогда. Здесь лучше вот так сделать:
        Optional<Faculty> optional = facultyRepository.findById(id);
        if(!optional.isPresent()) {
            return null;
        }
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) {
//      return faculties.remove(id);
        facultyRepository.deleteById(id);
    }
    public Collection<Faculty> findFacultyByColor(String color) {
        return facultyRepository.findByColor(color);
    }
}
