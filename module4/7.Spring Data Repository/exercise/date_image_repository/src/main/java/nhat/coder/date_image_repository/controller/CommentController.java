package nhat.coder.date_image_repository.controller;

import nhat.coder.date_image_repository.model.Comment;
import nhat.coder.date_image_repository.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.Format;
import java.util.DuplicateFormatFlagsException;
import java.util.Formatter;

import static nhat.coder.date_image_repository.service.CommentServiceImpl.listErr;


@Controller
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping("/")
    public ModelAndView getAllComment(@PageableDefault(value = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("comment",new Comment());
        modelAndView.addObject("comments",commentService.findAll(pageable));
        return modelAndView;
    }
    @PostMapping("/comment/save")
    public String save(Comment comment, RedirectAttributes redirect) {
        for (int i = 0;i<listErr.size();i++){
            if (comment.getFeedback().contains(listErr.get(i)))
                throw new DuplicateFormatFlagsException("Err");
        }
        commentService.save(comment);
        redirect.addFlashAttribute("success", "Saved customer successfully!");
        return "redirect:/";
    }
    @GetMapping("/update-like/{id}")
    public ModelAndView updateLike(@PathVariable Long id,@PageableDefault(value = 2) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("view");
        Comment comment = commentService.findById(id);
        comment.setLikes(comment.getLikes()+1);
        commentService.update(id,comment);
        modelAndView.addObject("comment",new Comment());
        modelAndView.addObject("comments",commentService.findAll(pageable));
        return modelAndView;
    }
}
