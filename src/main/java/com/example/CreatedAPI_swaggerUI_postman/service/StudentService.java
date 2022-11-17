package com.example.CreatedAPI_swaggerUI_postman.service;

import java.awt.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

import com.example.CreatedAPI_swaggerUI_postman.model.Faculty;
import com.example.CreatedAPI_swaggerUI_postman.model.Student;
import com.example.CreatedAPI_swaggerUI_postman.repository.StudentRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
//private final Map<Long, Student> mapStudents = new HashMap<>();
//    private long lastId = 0;

private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student editStudent(long id, Student student) {

        Optional<Student> optional =  studentRepository.findById(id);
        if(!optional.isPresent()) {
            return null;
        }
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
      studentRepository.deleteById(id);
        }

     public void deleteAllStudent(){
        studentRepository.deleteAll();
    }

    public Collection<Student> findByAge(int age) {
        return studentRepository.findByAge(age);
    }
    public Collection<Student> findByAgeBetween(int from, int to) {
        return studentRepository.findByAgeBetween(from, to);
    }
    public Faculty getFacultyByStudentId(long id){
        return studentRepository.getFacultyByStudentId(id);
    }
    public List<Student> getStudentbyAge(int age) {
        return studentRepository.findByAge(age);
    }
}
