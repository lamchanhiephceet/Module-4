package com.codegym.controller;

import com.codegym.model.FormRegister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import javax.validation.Valid;

@Controller
public class FormRegisterController {
    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("formRegister", new FormRegister());
        model.addAttribute("formRegister", new FormRegister());
        model.addAttribute("formRegister", new FormRegister());
        model.addAttribute("formRegister", new FormRegister());
        return "index";
    }
    @PostMapping("/")
    public String checkValidation (@Valid @ModelAttribute("formRegister")FormRegister formRegister, BindingResult bindingResult, Model model){
        new FormRegister().validate(formRegister, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "index";
        }
        else {
            model.addAttribute("formRegister", formRegister.getNumber());
            model.addAttribute("formRegister", formRegister.getFirstName());
            model.addAttribute("formRegister", formRegister.getLastName());
            model.addAttribute("formRegister", formRegister.getEmail());
            return "result";
        }
    }
}
