package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chap07.Calculator;
import config.AppCtx;

public class MainAspect {
    public static void main(String[] args){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        Calculator cal = ctx.getBean("calculator", Calculator.class);
        long fact = cal.factorial(5);
        System.out.println("cal.factorial(5) = " + fact);
        System.out.println(cal.getClass().getName());
        ctx.close();
    }
}
