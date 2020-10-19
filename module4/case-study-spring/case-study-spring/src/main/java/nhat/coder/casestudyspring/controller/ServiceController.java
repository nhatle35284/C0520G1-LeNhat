package nhat.coder.casestudyspring.controller;

import nhat.coder.casestudyspring.model.Employee;
import nhat.coder.casestudyspring.model.Service;
import nhat.coder.casestudyspring.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    ServiceService serviceService;
    @GetMapping
    public String getListService(Model model){
        model.addAttribute("serviceList",serviceService.findAll());
        return "service/list";
    }
    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView=new ModelAndView("service/create");
        modelAndView.addObject("service", new Service());
        return modelAndView;
    }
    @PostMapping("/save")
    public String save(@Validated Service service, BindingResult bindingResult, RedirectAttributes redirect) {
        new Service().validate(service,bindingResult);
        if (bindingResult.hasErrors()){
            return "service/create";
        }else {
            serviceService.save(service);
            redirect.addFlashAttribute("success", "Saved Service successfully!");
            return "redirect:/service";
        }

    }
    @GetMapping("/update/{id}")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("service", serviceService.findById(id));
        return "service/edit";
    }
    @PostMapping("/edit")
    public String update(Service service, RedirectAttributes redirect) {
        serviceService.update(service);
        redirect.addFlashAttribute("success", "Modified Service successfully!");
        return "redirect:/service";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id, Model model) {
        serviceService.remove(id);
        return "redirect:/service";
    }
}

