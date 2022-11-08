package com.example.CreatedAPI_swaggerUI_postman.service;

import java.util.HashMap;
import com.example.CreatedAPI_swaggerUI_postman.model.Faculty;
import com.example.CreatedAPI_swaggerUI_postman.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyService {
//    private final HashMap<Long, Faculty> faculties = new HashMap<>();
//    private long count = 0;
@Autowired
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
        return facultyRepository.findById(id).get();
    }

    public Faculty editFaculty(long id, Faculty faculty) {
//        if (!faculties.containsKey(id)) {
//            return null;
//        }
//        faculties.put(id, faculty);
//        return faculty;
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) {
//      return faculties.remove(id);
        facultyRepository.deleteById(id);
    }
}
