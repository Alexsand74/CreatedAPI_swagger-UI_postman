package com.example.CreatedAPI_swaggerUI_postman.controller;

import com.example.CreatedAPI_swaggerUI_postman.model.Faculty;
import com.example.CreatedAPI_swaggerUI_postman.service.FacultyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.CreatedAPI_swaggerUI_postman.model.Student;
import com.example.CreatedAPI_swaggerUI_postman.service.StudentService;

import java.awt.*;
import java.util.Collection;
import java.util.List;

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
    @DeleteMapping("{id}")
    public ResponseEntity <Student> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping()
    public void deleteAllStudent () {
        studentService.deleteAllStudent();
    }
    @GetMapping(value = "age")
        public ResponseEntity<Collection<Student>> findStudentByAge (@RequestParam(required = false) int age){
        if(age > 0){
                return ResponseEntity.ok(studentService.findByAge(age));
            }
            return ResponseEntity.noContent().build();
        }
    @GetMapping("/age/{age}")
    public List<Student> getStudents(@PathVariable int age) {
        return studentService.getStudentbyAge(age);
    }
    @GetMapping
    public ResponseEntity<Collection<Student>> findByAgeBetween (@RequestParam int from,
                                                                 @RequestParam int to){// задаем промежуток и ищем студентов
        return ResponseEntity.ok(studentService.findByAgeBetween(from, to));
    }
    @GetMapping(value = "id")
    public ResponseEntity<Faculty> getFacultyByStudentId(@RequestParam long id){
        return ResponseEntity.ok(studentService.getFacultyByStudentId(id));
    }
}
