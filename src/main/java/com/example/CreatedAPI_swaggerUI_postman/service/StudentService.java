package com.example.CreatedAPI_swaggerUI_postman.service;

import java.util.Collection;
import java.util.Optional;
//import java.util.HashMap;
import com.example.CreatedAPI_swaggerUI_postman.model.Student;
import com.example.CreatedAPI_swaggerUI_postman.repository.StudentRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

//    private final HashMap<Long, Student> students = new HashMap<>();
//    private long count = 0;
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
        return studentRepository.findById(id).orElse(null);
    }

    public Student editStudent(long id, Student student) {
//        if (!students.containsKey(id)) {
//            return null;
//        }
//        students.put(id, student);
//        return student;
//          if (!(studentRepository.findById(id) == null)) {
//              return studentRepository.save(student);
//          }
//          return studentRepository.findById(id).orElse( null);
//  findById возвращает Optional и он не будет наллом никогда. Здесь лучше вот так сделать:
        Optional<Student> optional =  studentRepository.findById(id);
        if(!optional.isPresent()) {
            return null;
        }
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
//        return students.remove(id);
        if ( studentRepository.existsById(id)){
        Student studentOld = studentRepository.getReferenceById(id);
        studentOld.setAge(0);
        studentOld.setName(null);
        studentRepository.save(studentOld);
        }
//      studentRepository.deleteById(id);
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

}
