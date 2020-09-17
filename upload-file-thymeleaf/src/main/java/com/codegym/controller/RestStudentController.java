package com.codegym.c0320h1.controller;

import com.codegym.c0320h1.exception.NotFoundException;
import com.codegym.c0320h1.model.Student;
import com.codegym.c0320h1.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class RestStudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping()
    public ResponseEntity<Iterable<Student>> findAll(){
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Student> createNewStudent(@RequestBody Student student){
        studentService.update(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getOneStudent(@PathVariable Long id){
        Student student;
        try {
            student  = studentService.findById(id);
        } catch (NotFoundException notFoundException) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Student> editStudent(@PathVariable Long id, @RequestBody Student student){
        student.setId(id);
        studentService.update(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

}
