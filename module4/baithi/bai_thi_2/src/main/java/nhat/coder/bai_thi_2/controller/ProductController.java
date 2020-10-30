package nhat.coder.bai_thi_2.controller;

import nhat.coder.bai_thi_2.model.Category;

import nhat.coder.bai_thi_2.model.Product;
import nhat.coder.bai_thi_2.service.CategoryService;
import nhat.coder.bai_thi_2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    private ProductService productService;
    @Autowired
    CategoryService categoryService;

    @ModelAttribute("listCateGory")
    public List<Category> listCustomerType() {
        return categoryService.findAll();
    }

    @GetMapping
    public ModelAndView getList(@PageableDefault(value = 5  ) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("product/list");
        modelAndView.addObject("listProduct",productService.findAll(pageable));
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("product/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView save(@Validated Product product , BindingResult bindingResult, RedirectAttributes redirect,@PageableDefault(value = 5) Pageable pageable) {
        if (bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("/product/create");
//            modelAndView.addObject("listProduct", productService.findAllByStatusTrue(pageable));
            return modelAndView;
        }else {
        ModelAndView modelAndView = new ModelAndView("redirect:/product");
        redirect.addFlashAttribute("success","Save successfully!");
        productService.save(product);
        return modelAndView;
        }
    }
    @GetMapping("/deleteSelect")
    public String delete(@RequestParam String[] select, Model model) {
        for (int i = 0; i<select.length; i++){
        productService.remove(Long.valueOf(select[i]));
        }
        return "redirect:/product";
    }
//
    @GetMapping("/search")
    public ModelAndView search(@PageableDefault(value = 5) Pageable pageable,
                         @RequestParam(value = "inputSearch", defaultValue = "") String inputSearch,
                               @RequestParam(value = "priceSearch", defaultValue = "") String priceSearch
    ,@RequestParam(value = "category", defaultValue = "") String category){
//                         @RequestParam(value = "choose", defaultValue = "-1") int choose,Model model) {
        ModelAndView modelAndView = new ModelAndView("/product/list");

//        switch (choose){
//            case 1:
//                modelAndView.addObject("listProduct",productService.findAllByProductId(inputSearch,pageable));
//                break;
//            case 2:
//                modelAndView.addObject("listProduct",productService.findAllByProductName(inputSearch,pageable));
//                break;
//            case 3:
//                modelAndView.addObject("listProduct",productService.findAllByColor(inputSearch,pageable));
//                break;
//        }
//        model.addAttribute("choose",choose);
        modelAndView.addObject("listProduct",productService.findAllByProductNameContaining(inputSearch,pageable));
        modelAndView.addObject("listProduct",productService.findByPrice(priceSearch,pageable));

//            modelAndView.addObject("listProduct",productService.findAllByCategory(category,pageable));
        modelAndView.addObject("inputSearch",inputSearch);
        modelAndView.addObject("priceSearch",priceSearch);
        return modelAndView;
    }
}
