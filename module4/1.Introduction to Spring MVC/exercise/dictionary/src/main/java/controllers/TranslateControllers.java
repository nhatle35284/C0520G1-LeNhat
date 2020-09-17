package controllers;

import com.sun.net.httpserver.spi.HttpServerProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ModelAndViewMethodReturnValueHandler;

import javax.servlet.http.HttpServletRequest;
import java.awt.image.ImageProducer;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class TranslateControllers {
    @GetMapping({"","/key"})
    public String displayTranslate() {
        return "translate";
    }

    @PostMapping("/translate")
    public ModelAndView keyTranslate(HttpServletRequest request) {
        Map<String, String> lib = new TreeMap<>();
        lib.put("xin chào", "hello");
        lib.put("nhà", "home");
        lib.put("bạn", "friend");
        lib.put("xin lỗi", "sorry");
        lib.put("hello", "xin chào");
        lib.put("home", "home");
        lib.put("friend", "bạn");
        lib.put("sorry", "xin lỗi");
        ModelAndView modelAndView = new ModelAndView("translate");
        String key = request.getParameter("key");
        String translate = lib.get(key);
        modelAndView.addObject("key", key);
        modelAndView.addObject("translate", translate);
        return modelAndView;
    }

}
