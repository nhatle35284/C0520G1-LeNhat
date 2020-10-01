package vn.codegym.customlog.formatter;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Logger {
    public void error() {
        System.out.println("[CMS] ERROR!");
    }
    @AfterThrowing(pointcut = "execution(public * vn.codegym.customlog.service.CustomerService.*(..))")
    public void log() {}
    @AfterThrowing(pointcut = "execution(public * vn.codegym.customlog.service.CustomerService.*(..))", throwing = "e")
    public void log(Exception e) {
        System.out.println("[CMS] co loi xay ra: " + e.getMessage());
    }
}
