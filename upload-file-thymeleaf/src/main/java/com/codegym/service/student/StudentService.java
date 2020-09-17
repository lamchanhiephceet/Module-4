package com.codegym.c0320h1.service.student;

import com.codegym.c0320h1.exception.NotFoundException;
import com.codegym.c0320h1.model.Classess;
import com.codegym.c0320h1.model.Student;
import com.codegym.c0320h1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) throws NotFoundException{
        Student student = studentRepository.findOne(id);
        if (student != null){
            return student;
        }
        else throw new NotFoundException();
    }

    @Override
    public void update(Student model) {
        studentRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        studentRepository.delete(id);
    }

    @Override
    public void save(Student model) {

    }

    @Override
    public Iterable<Student> findAllByClassess(Classess classes) {
        return studentRepository.findAllByClassess(classes);
    }

    @Override
    public Iterable<Student> listFindByName(String name) {
        return studentRepository.findAllByNameContaining(name);
    }
}
