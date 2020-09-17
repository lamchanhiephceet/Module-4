package com.codegym.c0320h1.controller;

import com.codegym.c0320h1.model.Student;
import com.codegym.c0320h1.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping()
    public ModelAndView index(){

        ModelAndView mav = new ModelAndView("student/list");
        mav.addObject("list", studentService.findAll());
        return mav;
    }

//    @GetMapping("/edit/{id}")
//    public ModelAndView editForm(@PathVariable Long id){
//        ModelAndView mav = new ModelAndView("/student/edit");
//        mav.addObject("student", studentService.findById(id));
//        return mav;
//    }

    @PostMapping("/edit/{id}")
    public ModelAndView editStudent(@ModelAttribute Student student){
        ModelAndView modelAndView = new ModelAndView("/student/edit");
        modelAndView.addObject("student", student);
        studentService.save(student);
        modelAndView.addObject("mess", "done edit");
        return modelAndView;
    }
}
