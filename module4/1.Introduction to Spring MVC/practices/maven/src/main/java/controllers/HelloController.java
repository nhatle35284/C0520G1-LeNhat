package controllers;

import model.Student;
import org.apache.taglibs.standard.lang.jstl.ArraySuffix;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    @GetMapping( "/test")
    public String getHello() {
        return "index";
    }
    @GetMapping( "/test1")
    public ModelAndView getHello1() {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Nhat",21));
        list.add(new Student("Hoang",21));
        list.add(new Student("Hải",21));
        return new ModelAndView("index" ,"list", list);
    }
}
