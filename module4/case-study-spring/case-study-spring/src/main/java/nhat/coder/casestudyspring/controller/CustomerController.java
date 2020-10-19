package nhat.coder.casestudyspring.controller;

import nhat.coder.casestudyspring.model.Customer;
import nhat.coder.casestudyspring.model.CustomerType;
import nhat.coder.casestudyspring.service.CustomerService;
import nhat.coder.casestudyspring.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerTypeService customerTypeService;

    @ModelAttribute("listCustomerType")
    public List<CustomerType> listCustomerType() {
        return customerTypeService.findAll();
    }


    @GetMapping
    public ModelAndView getListCustomer(@PageableDefault(value = 3)
                                        @SortDefault(sort = "customerId", direction = Sort.Direction.DESC) Pageable pageable,
                                        @RequestParam(value = "inputSearch", defaultValue = "") String inputSearch,
                                        @RequestParam(value = "choose",defaultValue = "-1") int choose) {
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        if ("".equals(inputSearch)) {
            modelAndView.addObject("listCustomer", customerService.findAllTrue(pageable));
        } else {
            switch (choose) {
                case 1: {
                    modelAndView.addObject("listCustomer", customerService.findAllName(inputSearch,pageable));
                }
                break;
                case 2: {
                    modelAndView.addObject("listCustomer", customerService.findCustomerByCustomerTypeCustomerTypeName(inputSearch,pageable));

                }
            }

        }
//            modelAndView.addObject("listCustomer",customerService.findName(inputSearch,pageable));
            modelAndView.addObject("listCustomer",customerService.findAllTrue(pageable));
            modelAndView.addObject("inputSearch",inputSearch);
            modelAndView.addObject("choose",choose);
            modelAndView.addObject("customer",new Customer());

        return modelAndView;
    }


    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("customer/list");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@Validated Customer customer, BindingResult bindingResult, RedirectAttributes redirect,Model model,@PageableDefault(value = 3)
    @SortDefault(sort = "customerId", direction = Sort.Direction.DESC) Pageable pageable) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("listCustomer",customerService.findAllTrue(pageable));
            model.addAttribute("customer",new Customer());
            return "customer/list";
        } else {
            customerService.save(customer);
//            redirect.addFlashAttribute("success", "Saved customer successfully!");
            return "redirect:/customer";
        }
    }

    @GetMapping("/update/{id}")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "customer/edit";
    }

    @PostMapping("/edit")
    public String update(@Validated Customer customer, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "customer/edit";
        } else {
            customerService.update(customer);
            redirect.addFlashAttribute("success", "Modified Customer successfully!");
            return "redirect:/customer";
        }
    }
}
