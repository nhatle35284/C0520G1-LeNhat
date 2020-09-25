package nhat.coder.controller;

import nhat.coder.model.Comment;
import nhat.coder.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping("/")
    public ModelAndView getAllComment(){
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("comment",new Comment());
        modelAndView.addObject("comments",commentService.getAll());
        return modelAndView;
    }
    @PostMapping("/comment/save")
    public String save(Comment comment, RedirectAttributes redirect) {
        commentService.save(comment);
        redirect.addFlashAttribute("success", "Saved customer successfully!");
        return "redirect:/";
    }
    @GetMapping("/update-like/{id}")
    public ModelAndView updateLike(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("view");

        Comment comment = commentService.findById(id);
        comment.setLikes(comment.getLikes()+1);
        commentService.update(id,comment);
        modelAndView.addObject("comment",new Comment());
        modelAndView.addObject("comments",commentService.getAll());

        return modelAndView;
    }
}
