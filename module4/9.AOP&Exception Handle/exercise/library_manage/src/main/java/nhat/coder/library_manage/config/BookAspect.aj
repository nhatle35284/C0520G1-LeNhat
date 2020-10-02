package nhat.coder.library_manage.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@Aspect
public class BookAspect {
    @Pointcut("execution(* nhat.coder.library_manage.controller.BookController.*(..))")
    public void bookControllerMethod(){}

    @Before("bookControllerMethod()")
    public void beforeCallMethod(JoinPoint joinPoint){
        System.err.println("Start method name "+joinPoint.getSignature().getName() +" Time "+ LocalTime.now());
    }
    @After("bookControllerMethod()")
    public void afterCallMethod(JoinPoint joinPoint){
        System.err.println("Start method name "+ joinPoint.getSignature().getName() +" Time "+ LocalTime.now());
    }
}
