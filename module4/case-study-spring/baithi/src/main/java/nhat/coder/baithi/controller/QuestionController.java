package nhat.coder.baithi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class QuestionController {
@GetMapping
    public ModelAndView getList(){
    ModelAndView modelAndView = new ModelAndView("list");

    return modelAndView;
}

}
