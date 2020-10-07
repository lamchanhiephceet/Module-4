package com.codegym.springbootmigratewebapp.controller;


import com.codegym.springbootmigratewebapp.models.MyUser;
import com.codegym.springbootmigratewebapp.services.IMyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    private IMyUserService iMyUserService;

    @GetMapping("/")
    public String getHomePage() {
        return "home";
    }

    @GetMapping("/admin")
    public String getAdminPage() {
        return "admin";
    }

    @GetMapping("/user")
    public String getUserPage() {
        return "user";
    }

    @GetMapping("/admin/test")
    public String getHiPage() {
        return "test";
    }

    @GetMapping("/registation")
    public ModelAndView register(){
        return new ModelAndView("registation", "user", new MyUser());
    }

    @PostMapping("/registation")
    public String save(MyUser user){
        iMyUserService.saveUser(user);
        return "redirect:/";
    }
}
