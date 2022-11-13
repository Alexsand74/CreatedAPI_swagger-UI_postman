package com.example.CreatedAPI_swaggerUI_postman.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.CreatedAPI_swaggerUI_postman.model.Faculty;
import com.example.CreatedAPI_swaggerUI_postman.service.FacultyService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Faculty> getFacultyInfo(@PathVariable Long id) {
        Faculty faculty = facultyService.findFaculty(id);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.addFaculty(faculty);
    }

    @GetMapping(value = "color")
    public ResponseEntity<Collection<Faculty>> findFacultyByColor (@RequestParam(required = false) String color){
        if(color != null && !color.isBlank()){
            return ResponseEntity.ok(facultyService.findFacultyByColor(color));
        }
        return ResponseEntity.notFound().build();// не найдено
    }
    @PutMapping
    public ResponseEntity<Faculty> editFaculty(@RequestBody Faculty faculty) {
        Faculty foundFaculty = facultyService.editFaculty(faculty.getId(),faculty);

        if (foundFaculty == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundFaculty);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Faculty> deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/color/{color}")
    public List<Faculty> getStudents(@PathVariable String color) {
        return facultyService.getFacultyColor(color);
    }
    @GetMapping
    public ResponseEntity<Collection<Faculty>> findByNameOrColorIgnoreCase(@RequestParam (required = false) String name,
                                                                           @RequestParam (required = false) String color){
        if(name != null && !name.isBlank()){
            return ResponseEntity.ok(facultyService.findByNameIgnoreCase(name));
        }
        if(color != null && !color.isBlank()){
            return ResponseEntity.ok(facultyService.findByColorIgnoreCase(color));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
