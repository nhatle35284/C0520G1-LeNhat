package nhat.coder.library_manage.controller;

import nhat.coder.library_manage.exception.PayBookException;
import nhat.coder.library_manage.exception.RentBookException;
import nhat.coder.library_manage.model.Book;
import nhat.coder.library_manage.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Random;

import static nhat.coder.library_manage.service.BookServiceImpl.bookMap;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping()
    public String listBook(Model model){
        model.addAttribute("list",bookService.getAll());
        return "/list";
    }
    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView=new ModelAndView("/create");
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }
    @PostMapping("/save")
    public String save(Book book, RedirectAttributes redirect) {
        bookService.save(book);
        redirect.addFlashAttribute("success", "Saved blog successfully!");
        return "redirect:/book";
    }
    @GetMapping("/rentBook/{id}")
    public ModelAndView viewRentBook(@PathVariable Long id) {
        Book book = bookService.findById(id);
        Random rand = new Random();
        int random = rand.nextInt(89999) + 10000;
        if (book == null) {
            return new ModelAndView("error");
        }
        ModelAndView modelAndView = new ModelAndView("rent", "book", book);
        modelAndView.addObject("random", random);
        return modelAndView;
    }

    @PostMapping("/rentBook")
    public ModelAndView rentBook(@ModelAttribute Book book, @RequestParam Long code) throws RentBookException {
        if (bookService.rentBook(book)) {
            bookMap.put(code, book);
//            System.out.println(random);
            return new ModelAndView("list", "list", bookService.getAll());
        }
        throw new RentBookException();
    }


    @GetMapping("/pay")
    public ModelAndView viewGiveBookBack() {
        return new ModelAndView("pay", "random", new Integer("0"));
    }

    @PostMapping("/pay")
    public ModelAndView payBook(@RequestParam Long random) throws PayBookException {
        System.out.println(random);
        if (bookMap.containsKey(random)) {
            Book book = bookMap.get(random);
            bookService.payBook(book);
            bookMap.remove(random);
            return new ModelAndView("list", "list", bookService.getAll());
        }else {
            return new ModelAndView("error");
        }

    }
}
