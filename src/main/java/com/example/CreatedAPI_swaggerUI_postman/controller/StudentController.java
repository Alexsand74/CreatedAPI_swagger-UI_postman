package com.example.CreatedAPI_swaggerUI_postman.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.CreatedAPI_swaggerUI_postman.model.Student;
import com.example.CreatedAPI_swaggerUI_postman.service.StudentService;

import java.util.Collection;

@RequestMapping("/student")
@RestController
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentInfo(@PathVariable Long id) {
        Student student = studentService.findStudent(id);
        if (id <= 0 || student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping
    public ResponseEntity<Student> editStudent(@RequestBody Student student) {
        Student foundStudent = studentService.editStudent(student.getId(),student);
        if (foundStudent == null ) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundStudent);
    }
    @GetMapping(value = "from, to")
    public ResponseEntity<Collection<Student>> findByAgeBetween (@RequestParam int from,
                                                                 @RequestParam int to){
        return ResponseEntity.ok(studentService.findByAgeBetween(from, to));
    }

    @DeleteMapping("{id}")
    public ResponseEntity <Student> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping()
    public ResponseEntity <Student>deleteStudent() {
        studentService.deleteAllStudent();
        return ResponseEntity.ok().build();
    }

}
