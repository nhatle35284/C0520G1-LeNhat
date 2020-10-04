package nhat.coder.blogrestfulreal.controller;

import nhat.coder.blogrestfulreal.model.Blog;
import nhat.coder.blogrestfulreal.model.Category;
import nhat.coder.blogrestfulreal.service.BlogService;
import nhat.coder.blogrestfulreal.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

;import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/blog")
    public ResponseEntity<List<Blog>> getListBlog(){
        List<Blog> blogList = blogService.getAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(blogList,HttpStatus.OK);
        }
    }
    @PostMapping("/blog")
    public ResponseEntity addBlog(@RequestBody Blog blog){
        blogService.save(blog);
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> findStudentById(@PathVariable Long id){
        Blog blog = blogService.findById(id);
        if(blog==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
    @PutMapping("/blog/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Long id, @RequestBody Blog blog){
        Blog currentBlog = blogService.findById(id);
        if(currentBlog==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentBlog.setTitleBlog(blog.getTitleBlog());
        currentBlog.setContentBlog(blog.getContentBlog());
        currentBlog.setCategory(blog.getCategory());

        blogService.save(currentBlog);

        return new ResponseEntity<>(currentBlog, HttpStatus.OK);
    }
    @DeleteMapping("/blog/{id}")
    public ResponseEntity deleteBlog(@PathVariable Long id){
        Blog blog=blogService.findById(id);
       blogService.remove(blog);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
