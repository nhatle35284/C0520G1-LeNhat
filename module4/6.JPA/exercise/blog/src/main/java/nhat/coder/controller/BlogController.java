package nhat.coder.controller;

import nhat.coder.model.Blog;
import nhat.coder.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/")
    public ModelAndView listBog() {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Blog> list = blogService.getAll();
        modelAndView.addObject("list",list);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView=new ModelAndView("create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }
    @PostMapping("/save")
    public String save(Blog blog, RedirectAttributes redirect) {
        blogService.save(blog);
        redirect.addFlashAttribute("success", "Saved customer successfully!");
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "edit";
    }
    @PostMapping("/update")
    public String update(Blog blog, RedirectAttributes redirect) {
        blogService.update(blog.getId(), blog);
        redirect.addFlashAttribute("success", "Modified customer successfully!");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "delete";
    }
    @PostMapping("/delete")
    public String delete(Blog blog, RedirectAttributes redirect) {
        blogService.remove(blog);
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/view";
    }
}
