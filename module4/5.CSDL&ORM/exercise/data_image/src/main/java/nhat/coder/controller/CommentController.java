package nhat.coder.controller;

import nhat.coder.model.Test;
import nhat.coder.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping("/")
    public ModelAndView getAllComment(){
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("comment",new Test());
        modelAndView.addObject("comments",commentService.getAll());
        return modelAndView;
    }
    @PostMapping("/comment/save")
    public String save(Test comment, RedirectAttributes redirect) {
        commentService.save(comment);
        redirect.addFlashAttribute("success", "Saved customer successfully!");
        return "redirect:/";
    }

}
