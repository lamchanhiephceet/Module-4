package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {

    @GetMapping("/*")
    public String home(Model model, @RequestParam(value = "condiment", defaultValue = "") String[] comdiment){
        String string = "";
        for (String a : comdiment){
            string += a ;
        }
        model.addAttribute("message", string);
        return "home";
    }
}