package controllers;

import model.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import service.ISettingService;
import service.SettingService;
;

import java.util.List;

@Controller
public class SettingController {
     ISettingService iSettingService = new SettingService();
    @GetMapping("/form")
    public String showForm(@ModelAttribute("setting")Setting setting, Model model){
        List<String> listLanguage = iSettingService.getLanguage();
        List<String> listPageSize = iSettingService.getPageSize();
        model.addAttribute("listLanguage",listLanguage);
        model.addAttribute("listPageSize",listPageSize);

        return "form";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("setting")Setting setting,Model model){
        model.addAttribute("language",setting.getLanguage());
        model.addAttribute("pageSize",setting.getPageSize());
        model.addAttribute("spamsFilter",setting.getSpamsFilter());
        model.addAttribute("signature",setting.getSignature());
        return "setting";
    }
}
