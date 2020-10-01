package nhat.coder.date_image_repository.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(Exception.class)
    public ModelAndView showErrPage(){
        System.err.println("Loi");
        return new ModelAndView("error");
    }
}
