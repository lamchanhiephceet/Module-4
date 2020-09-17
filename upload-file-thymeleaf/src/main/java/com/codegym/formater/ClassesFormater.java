package com.codegym.c0320h1.formater;

import com.codegym.c0320h1.exception.NotFoundException;
import com.codegym.c0320h1.model.Classess;
import com.codegym.c0320h1.model.Student;
import com.codegym.c0320h1.service.classes.IClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class ClassesFormater implements Formatter<Classess> {
    private IClassesService classesService;

    @Autowired
    public ClassesFormater(IClassesService classesService){
        this.classesService = classesService;
    }

    @Override
    public Classess parse(String text, Locale locale) throws ParseException {
        Classess classess = new Classess();
        try {
            classess = classesService.findById(Long.parseLong(text));
        } catch (NotFoundException notFoundException) {
            notFoundException.printStackTrace();
        }
        return classess;
    }

    @Override
    public String print(Classess object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
