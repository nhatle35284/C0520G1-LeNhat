package nhat.coder.baithi.controller;

import nhat.coder.baithi.model.Category;
import nhat.coder.baithi.model.Product;
import nhat.coder.baithi.service.CategoryService;
import nhat.coder.baithi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping({"","/product"})
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @ModelAttribute("listCateGory")
    public List<Category> listCustomerType() {
        return categoryService.findAll();
    }

    @GetMapping
    public ModelAndView getList(@PageableDefault(value = 2) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("product/list");
        modelAndView.addObject("listProduct",productService.findAllByStatusTrue(pageable));
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("product2", new Product());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("product/list");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView save(@Validated Product product , BindingResult bindingResult, RedirectAttributes redirect,@PageableDefault(value = 2) Pageable pageable) {
        if (bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("/product/list");
            modelAndView.addObject("product2", new Product());
            modelAndView.addObject("listProduct", productService.findAllByStatusTrue(pageable));
            return modelAndView;
        }else {
        ModelAndView modelAndView = new ModelAndView("redirect:/product");
        redirect.addFlashAttribute("success","Save successfully!");
        product.setStatus(true);
        productService.save(product);
        return modelAndView;
        }
    }

    @GetMapping("/update/{id}")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("product2", productService.findById(id));
        return "product/list";
    }

    @PostMapping("/edit")
    public ModelAndView update(@Validated @ModelAttribute("product2") Product product, BindingResult bindingResult, RedirectAttributes redirect,@PageableDefault(value = 2) Pageable pageable) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("product/list");
            modelAndView.addObject("listProduct", productService.findAllByStatusTrue(pageable));
            modelAndView.addObject("product", new Product());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("redirect:/product");
            productService.update(product);
            redirect.addFlashAttribute("success", "Modified successfully!");
            return modelAndView;
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id, Model model) {
        productService.remove(id);
        return "redirect:/product";
    }
    @GetMapping("/deleteSelect")
    public String delete(@RequestParam String[] select, Model model) {
        for (int i = 0; i<select.length; i++){
        productService.remove(select[i]);
        }
        return "redirect:/product";
    }

    @GetMapping("/search")
    public ModelAndView search(@PageableDefault(value = 2) Pageable pageable,
                         @RequestParam(value = "inputSearch", defaultValue = "") String inputSearch,
                         @RequestParam(value = "choose", defaultValue = "-1") int choose,Model model) {
        ModelAndView modelAndView = new ModelAndView("/product/list");

        switch (choose){
            case 1:
                modelAndView.addObject("listProduct",productService.findAllByProductId(inputSearch,pageable));
                break;
            case 2:
                modelAndView.addObject("listProduct",productService.findAllByProductName(inputSearch,pageable));
                break;
            case 3:
                modelAndView.addObject("listProduct",productService.findAllByColor(inputSearch,pageable));
                break;
        }
        model.addAttribute("choose",choose);
        model.addAttribute("inputSearch",inputSearch);
        return modelAndView;
    }

//    BT

//    @GetMapping
//    public ModelAndView getList(@PageableDefault(value = 2) Pageable pageable){
//        ModelAndView modelAndView = new ModelAndView("/product/list");
//        modelAndView.addObject("listProduct",productService.findAllByStatusTrue(pageable));
//        return modelAndView;
//    }
//    @GetMapping("/create")
//    public ModelAndView create() {
//        ModelAndView modelAndView=new ModelAndView("product/create");
//        modelAndView.addObject("product", new Product());
//        return modelAndView;
//    }
//    @PostMapping("/save")
//    public String save(@Validated Product product,BindingResult bindingResult, RedirectAttributes redirect) {
//        if (bindingResult.hasErrors()){
//            return "/product/create";
//        }else {
//        product.setStatus(true);
//        productService.save(product);
//        redirect.addFlashAttribute("success", "Saved Product successfully!");
//        return "redirect:/product";
//        }
//    }
//    @GetMapping("/update/{id}")
//    public String edit(@PathVariable String id, Model model) {
//        model.addAttribute("product", productService.findById(id));
//        return "product/edit";
//    }
//    @PostMapping("/edit")
//    public String update(Product contract, RedirectAttributes redirect) {
//        productService.update(contract);
//        redirect.addFlashAttribute("success", "Modified Product successfully!");
//        return "redirect:/product";
//    }
}
