package com.codegym.phonemanage.controller;


    import com.codegym.phonemanage.model.SmartPhone;
        import com.codegym.phonemanage.service.SmartPhoneService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.beans.factory.annotation.Qualifier;
        import org.springframework.http.MediaType;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/smartphones")
public class SmartPhoneController {

    @Autowired
    private SmartPhoneService smartPhoneService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createSmartphonePage() {
        ModelAndView mav = new ModelAndView("phones/new-phone");
        mav.addObject("sPhone", new SmartPhone());
        return mav;
    }

    @RequestMapping(value = "/createnewPhone", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SmartPhone createSmartphone(@RequestBody SmartPhone smartphone) {
        return smartPhoneService.save(smartphone);
    }
    @GetMapping("")
    public ModelAndView allPhonesPage() {
        ModelAndView modelAndView = new ModelAndView("phones/all-phones");

        modelAndView.addObject("allphones", smartPhoneService.findAll());
        return modelAndView;
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SmartPhone deleteSmartPhone(@PathVariable Integer id){
        return smartPhoneService.remove(id);
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editSmartphonePage(@PathVariable Integer id){
        SmartPhone smartphone = smartPhoneService.findById(id);
        if(smartphone != null) {
            ModelAndView modelAndView = new ModelAndView("phones/edit-phone");
            modelAndView.addObject("sPhone",smartphone);
            return modelAndView;
        }
        return null;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SmartPhone editSmartphone(@PathVariable Integer id, @RequestBody SmartPhone smartPhone){
        smartPhone.setId(id);
        return smartPhoneService.save(smartPhone);
    }

}
