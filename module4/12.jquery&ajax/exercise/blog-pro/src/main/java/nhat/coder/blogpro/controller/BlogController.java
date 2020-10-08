package nhat.coder.blogpro.controller;

import nhat.coder.blogpro.model.Blog;
import nhat.coder.blogpro.model.Category;
import nhat.coder.blogpro.service.AccountService;
import nhat.coder.blogpro.service.BlogService;;
import nhat.coder.blogpro.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping({"/","/blog"})
public class BlogController {
    @Autowired
    AccountService accountService;
    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;

    @ModelAttribute("category")
    public Iterable<Category> provinces(){
        return categoryService.getAll();
    }

    @GetMapping
    public ModelAndView listBog(@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("blog/list");
        Page<Blog> list = blogService.findAll(pageable);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        modelAndView.addObject("list",list);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView=new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }
    @PostMapping("/save")
    public String save(Blog blog, RedirectAttributes redirect) {
        blogService.save(blog);
        redirect.addFlashAttribute("success", "Saved blog successfully!");
        return "redirect:/blog";
    }

    @GetMapping("/update/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "blog/edit";
    }
    @PostMapping("/edit")
    public String update(Blog blog, RedirectAttributes redirect) {
        blogService.update(blog.getId(), blog);
        redirect.addFlashAttribute("success", "Modified blog successfully!");
        return "redirect:/blog";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "blog/delete";
    }
    @PostMapping("/delete")
    public String delete(Blog blog, RedirectAttributes redirect) {
        blogService.remove(blog);
        redirect.addFlashAttribute("success", "Removed blog successfully!");
        return "redirect:/blog";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "blog/view";
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam("query") String search,@PageableDefault(value = 5) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("blog/list");
        Page<Blog> list = blogService.findByTitleBlogContaining(search,pageable);
        modelAndView.addObject("list",list);
        return modelAndView;
    }

}
