package nhat.coder.casestudyspring.controller;

import nhat.coder.casestudyspring.model.Customer;
import nhat.coder.casestudyspring.model.Employee;
import nhat.coder.casestudyspring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public String getListEmployee(Model model){
        model.addAttribute("employeeList",employeeService.findAll());
        return "employee/list";
    }
    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView=new ModelAndView("employee/create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }
    @PostMapping("/save")
    public String save(Employee employee, RedirectAttributes redirect) {
        employeeService.save(employee);
        redirect.addFlashAttribute("success", "Saved Employee successfully!");
        return "redirect:/employee";
    }
    @GetMapping("/update/{id}")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        return "employee/edit";
    }
    @PostMapping("/edit")
    public String update(Employee employee, RedirectAttributes redirect) {
        employeeService.update(employee);
        redirect.addFlashAttribute("success", "Modified Employee successfully!");
        return "redirect:/employee";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id, Model model) {
        employeeService.remove(id);
        return "redirect:/employee";
    }
}
