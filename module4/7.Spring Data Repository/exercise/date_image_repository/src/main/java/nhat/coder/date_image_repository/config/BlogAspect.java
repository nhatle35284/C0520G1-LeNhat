package nhat.coder.date_image_repository.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Arrays;

@Component
@Aspect
public class BlogAspect {
    @Pointcut("execution(* nhat.coder..CommentController.*(..))")
    public void studentControllerMethod() {}

    @Before("studentControllerMethod()")
    public void beforeCallMethod(JoinPoint joinPoint){
        System.err.println("Start method name "+joinPoint.getSignature().getName() +" Time "+ LocalTime.now());
    }
    @After("studentControllerMethod()")
    public void afterCallMethod(JoinPoint joinPoint){
        System.err.println("Start method name "+ Arrays.toString(joinPoint.getArgs()) +" Time "+ LocalTime.now());
    }
}
