package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/calculator")
    public String showCalculator() {
        return "index";
    }
    @RequestMapping(value = "/calculator", method = RequestMethod.POST)
    public String calculator(@RequestParam float FirstNum,float SecondNum,char operator, Model model) {
        float result = calculate(FirstNum,SecondNum,operator);
        model.addAttribute("Result:",result);
        return "index";
    }

    public static float calculate(float FirstNum, float SecondNum, char operator) {
        switch (operator) {
            case '+':
                return FirstNum + SecondNum;
            case '-':
                return FirstNum - SecondNum;
            case '*':
                return FirstNum * SecondNum;
            case '/':
                if (SecondNum != 0)
                    return FirstNum / SecondNum;
                else
                    throw new RuntimeException("không chia được cho 0 ");
            default:
                throw new RuntimeException("Invalid operation");
        }
    }
}