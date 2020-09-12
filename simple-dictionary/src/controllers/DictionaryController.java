package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    @GetMapping("/translate")
    public String showTranslate(){
        return "index";
    }
    @RequestMapping(value="/translate", method= RequestMethod.POST)
    public String translate(@RequestParam String english, Model model) {

        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "xin chào");
        dictionary.put("developer", "nhà phát triển");
        dictionary.put("coder", "lập trình viên");
        dictionary.put("information", "thông tin");
        dictionary.put("techonology", "công nghệ");
        dictionary.put("computer", "máy tính");
        dictionary.put("IT", "công nghệ thông tin");
String result = dictionary.get(english);
if(result != null) {
    model.addAttribute("english",english);
    model.addAttribute("vietnamese",result);
} else {
    model.addAttribute("vietnamese","database not found");
}
return "index";
    }
}
