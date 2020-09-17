package controllers;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MoneyController {
    @GetMapping("/")
    public String getMoneyChange(){
        return "display";
    }
    @PostMapping ("/result")
    public ModelAndView postResult(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("display");
        double number=Double.parseDouble(request.getParameter("number"));
        double number1=Double.parseDouble(request.getParameter("number1"));
        double result = number*number1;
        modelAndView.addObject("number",number);
        modelAndView.addObject("number1",number1);
        modelAndView.addObject("result",result);
        return modelAndView;
    }
}
