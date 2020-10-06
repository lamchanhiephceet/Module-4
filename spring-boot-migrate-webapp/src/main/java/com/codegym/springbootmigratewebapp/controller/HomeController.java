package com.codegym.controller;

import com.codegym.models.MyUser;
import com.codegym.services.IMyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @GetMapping("/regis")
    public ModelAndView register(){
        return new ModelAndView("regis", "user", new MyUser());
    }

    @PostMapping("/regis")
    public String save(MyUser user){
        iMyUserService.saveUser(user);
        return "redirect:/";
    }
}
