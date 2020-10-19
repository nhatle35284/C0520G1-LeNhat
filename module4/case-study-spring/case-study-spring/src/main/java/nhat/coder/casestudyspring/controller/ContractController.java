package nhat.coder.casestudyspring.controller;

import nhat.coder.casestudyspring.model.Contract;
import nhat.coder.casestudyspring.model.Customer;
import nhat.coder.casestudyspring.model.Employee;
import nhat.coder.casestudyspring.model.Service;
import nhat.coder.casestudyspring.service.ContractService;
import nhat.coder.casestudyspring.service.CustomerService;
import nhat.coder.casestudyspring.service.EmployeeService;
import nhat.coder.casestudyspring.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    ContractService contractService;
    @Autowired
    CustomerService customerService;
    @ModelAttribute("listCustomer")
    public List<Customer> listCustomer(){
        return customerService.findAll();
    }
    @Autowired
    EmployeeService employeeService;
    @ModelAttribute("listEmployee")
    public List<Employee> listEmployee(){
        return employeeService.findAll();
    }
    @Autowired
    ServiceService serviceService;
    @ModelAttribute("listService")
    public List<Service> listService(){
        return serviceService.findAll();
    }
    @GetMapping
    public ModelAndView getListContract(){
        ModelAndView modelAndView = new ModelAndView("/contract/list");
        modelAndView.addObject("listContract",contractService.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView=new ModelAndView("contract/create");
        modelAndView.addObject("contract", new Contract());
        return modelAndView;
    }
    @PostMapping("/save")
    public String save(Contract contract, RedirectAttributes redirect) {
        contractService.save(contract);
        redirect.addFlashAttribute("success", "Saved Contract successfully!");
        return "redirect:/contract";
    }
    @GetMapping("/update/{id}")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("contract", contractService.findById(id));
        return "contract/edit";
    }
    @PostMapping("/edit")
    public String update(Contract contract, RedirectAttributes redirect) {
        contractService.update(contract);
        redirect.addFlashAttribute("success", "Modified Contract successfully!");
        return "redirect:/contract";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id, Model model) {
        contractService.remove(id);
        return "redirect:/contract";
    }
}
