package nhat.coder.userform.controller;

import nhat.coder.userform.model.User;
import nhat.coder.userform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public ModelAndView getListUser() {
        ModelAndView modelAndView = new ModelAndView("/user/list");
        modelAndView.addObject("users", userService.getAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createUser() {
        ModelAndView modelAndView = new ModelAndView("/user/view");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveUser(@Validated User user,BindingResult bindingResult, RedirectAttributes redirect) {
        new User().validate(user,bindingResult);
        if (bindingResult.hasErrors()) {
            return "/user/view";
        } else {
            userService.save(user);
            redirect.addFlashAttribute("success", "Save successfully!!");
            return "redirect:/";
        }
    }
}
