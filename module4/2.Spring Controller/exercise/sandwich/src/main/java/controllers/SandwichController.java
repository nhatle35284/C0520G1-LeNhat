package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.Map;

@Controller
public class SandwichController {
    @GetMapping("/sandwich")
    public String getSandwich(){
        return "sandwich";
    }

    @RequestMapping("/save")
    public String save(@RequestParam("condiment") String[] condiment,Model model) {
        model.addAttribute("condiment",condiment);
        return "condiment";
    }

}
