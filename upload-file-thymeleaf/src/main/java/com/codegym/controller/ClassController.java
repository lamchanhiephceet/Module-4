package com.codegym.c0320h1.controller;


import com.codegym.c0320h1.model.Classess;
import com.codegym.c0320h1.service.classes.IClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Iterator;

@Controller
@RequestMapping("/classes")
public class ClassController {

    @Autowired
    private IClassesService classesService;

    @GetMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView("classes/index");
        modelAndView.addObject("list", classesService.findAll());
        return modelAndView;
    }

    @GetMapping()
    public ResponseEntity<Iterable<Classess>> getAll(){
        return new ResponseEntity<>(classesService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Classess> create(@RequestBody Classess classess){
        classesService.save(classess);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Classess> edit(@PathVariable Long id, @RequestBody Classess classess){
        classess.setId(id);
        classesService.save(classess);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Classess> delete(@PathVariable Long id){
        classesService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/demo")
    public ResponseEntity<Classess> demo(@RequestBody Classess classess){
        classesService.save(classess);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
