package vn.codegym.controllers;

import vn.codegym.controllers.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class EmployeeController {

    @GetMapping
    public String getHomePage(){
        return "index";
    }

    @RequestMapping("/employee/create")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("el", new Employee());

        return modelAndView;
    }

    @PostMapping("/employee/create")
    public String submit(@ModelAttribute("employee") Employee employee, BindingResult result, ModelMap model) {
        model.addAttribute("name", employee.getName());
        model.addAttribute("contactNumber", employee.getContactNumber());
        model.addAttribute("id", employee.getId());
        return "employee/info";
    }
}
