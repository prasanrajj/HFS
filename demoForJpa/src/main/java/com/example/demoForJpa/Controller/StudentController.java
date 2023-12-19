package com.example.demoForJpa.Controller;


import com.example.demoForJpa.Entities.Student;
import com.example.demoForJpa.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {


    @Autowired
    StudentRepository studentRepository;

    @PostMapping("/api/saveStudent")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentRepository.save(student), HttpStatus.CREATED);
    }

    @GetMapping("/api/allStudents")
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/api/StudentById/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable long id){
        Optional<Student> s = studentRepository.findById(id);
        if(s.isPresent()){
            return new ResponseEntity<>(s.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/api/UpdateStudent/{id}")
    public ResponseEntity<Student>updateStudentById(@PathVariable long id, @RequestBody Student student){
        Optional<Student> s = studentRepository.findById(id);
        if(s.isPresent()){
            s.get().setAddress(student.getAddress());
            s.get().setEmail(student.getEmail());
            s.get().setStudentName(student.getStudentName());
            s.get().setMobile(student.getMobile());
            return new ResponseEntity<Student>(studentRepository.save(s.get()), HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/api/DeleteStudent/{id}")
    public ResponseEntity<Void>DeleteStudentBy(@PathVariable long id){
        Optional<Student> s = studentRepository.findById(id);
        if(s.isPresent()){
            studentRepository.deleteById(id);
            return new ResponseEntity<>( HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

