package com.example.CreatedAPI_swaggerUI_postman.service;

import java.util.HashMap;
import com.example.CreatedAPI_swaggerUI_postman.model.Student;
import com.example.CreatedAPI_swaggerUI_postman.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

//    private final HashMap<Long, Student> students = new HashMap<>();
//    private long count = 0;
@Autowired
private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public Student addStudent(Student student) {
//        student.setId(count++);
//        students.put(student.getId(), student);
//        return student;
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
//        return students.get(id);
        return studentRepository.findById(id).get();
    }

    public Student editStudent(long id, Student student) {
//        if (!students.containsKey(id)) {
//            return null;
//        }
//        students.put(id, student);
//        return student;
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
//        return students.remove(id);
         studentRepository.deleteById(id);
    }
}
