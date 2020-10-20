package nhat.coder.bai_thi_thuc_hanh.controller;

import nhat.coder.bai_thi_thuc_hanh.model.Question;
import nhat.coder.bai_thi_thuc_hanh.model.QuestionType;
import nhat.coder.bai_thi_thuc_hanh.service.QuestionService;
import nhat.coder.bai_thi_thuc_hanh.service.QuestionTypeService;
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

;import java.util.List;

@Controller
@RequestMapping({"","/question"})
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @Autowired
    QuestionTypeService questionTypeService;
    @ModelAttribute("listQuestionType")
    public List<QuestionType> listCustomerType() {
        return questionTypeService.findAll();
    }

    @GetMapping
    public ModelAndView getList(@PageableDefault(value = 4)
                                    @SortDefault(sort = "dateCreate",direction = Sort.Direction.ASC)
                                            Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("question/list");
        modelAndView.addObject("question", new Question());
        modelAndView.addObject("listQuestion", questionService.findAll(pageable));
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView=new ModelAndView("question/create");
        modelAndView.addObject("question", new Question());
        return modelAndView;
    }
    @PostMapping("/save")
    public String save(@Validated Question question, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasErrors()){
            return "/question/create";
        }else {
            question.setAnswer("Cau Hoi");
            question.setDateCreate("12-12/2000");
            question.setDateCreate("12-12/2000");
            question.setUserCreate("Nhat");
            question.setUserFeedback("La Sao");
        questionService.save(question);
        redirect.addFlashAttribute("success", "Saved Question successfully!");
        return "redirect:/question";
        }
    }
    @PostMapping("/edit")
    public String update(Question question, RedirectAttributes redirect) {
        questionService.update(question);
        redirect.addFlashAttribute("success", "Modified Product successfully!");
        return "redirect:/question";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        questionService.remove(id);
        return "redirect:/question";
    }

    @GetMapping("/search")
    public ModelAndView search(@PageableDefault(value = 4) Pageable pageable,
                               @RequestParam("inputSearch") String inputSearch)
//                               ,@RequestParam(value = "choose", defaultValue = "-1") int choose)
    {
        ModelAndView modelAndView = new ModelAndView("/question/list");
        modelAndView.addObject("listQuestion",questionService.findAllByTitleOrQuestionContextOrAnswer(inputSearch,pageable));
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
        modelAndView.addObject("inputSearch",inputSearch);
        return modelAndView;
    }

}
