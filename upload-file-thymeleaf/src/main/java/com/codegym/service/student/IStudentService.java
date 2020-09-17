package com.codegym.c0320h1.service.student;

import com.codegym.c0320h1.model.Classess;
import com.codegym.c0320h1.model.Student;
import com.codegym.c0320h1.service.IService;

public interface IStudentService extends IService<Student> {
    Iterable<Student> listFindByName (String name);
    Iterable<Student> findAllByClassess(Classess classes);
}
