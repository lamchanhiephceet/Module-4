package com.codegym.c0320h1.service.classes;

import com.codegym.c0320h1.model.Classess;
import com.codegym.c0320h1.repository.ClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ClassesService implements IClassesService {
    @Autowired
    private ClassesRepository classesRepository;

    @Override
    public Iterable<Classess> findAll() {
        return classesRepository.findAll();
    }

    @Override
    public Classess findById(Long id) {
        return classesRepository.findOne(id);
    }

    @Override
    public void update(Classess model) {

    }

    @Override
    public void save(Classess model) {
        classesRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        classesRepository.delete(id);
    }

    @Override
    public Classess findByName(String name) {
        return classesRepository.findByName(name);
    }
}
