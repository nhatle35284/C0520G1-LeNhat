package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
    @GetMapping("/display")
    public String getCalculator(){
        return "calculator";
    }

    @PostMapping("/add")
    public ModelAndView getCalculatorAdd(@RequestParam Double number1,Double number2){
        ModelAndView modelAndView = new ModelAndView("calculator");
        double result = number1+number2;
        modelAndView.addObject("number1",number1);
        modelAndView.addObject("number2",number2);
        modelAndView.addObject("result",result);
        return modelAndView;
    }

    @PostMapping("/sub")
    public ModelAndView getCalculatorSub(@RequestParam Double number1,Double number2){
        ModelAndView modelAndView = new ModelAndView("calculator");
        double result = number1-number2;
        modelAndView.addObject("number1",number1);
        modelAndView.addObject("number2",number2);
        modelAndView.addObject("result",result);
        return modelAndView;
    }

    @PostMapping("/mul")
    public ModelAndView getCalculatorMul(@RequestParam Double number1,Double number2){
        ModelAndView modelAndView = new ModelAndView("calculator");
        double result = number1*number2;
        modelAndView.addObject("number1",number1);
        modelAndView.addObject("number2",number2);
        modelAndView.addObject("result",result);
        return modelAndView;
    }

    @PostMapping("/dis")
    public ModelAndView getCalculatorDis(@RequestParam Double number1,Double number2){
        ModelAndView modelAndView = new ModelAndView("calculator");
        double result = number1/number2;
        modelAndView.addObject("number1",number1);
        modelAndView.addObject("number2",number2);
        modelAndView.addObject("result",result);
        return modelAndView;
    }
}
