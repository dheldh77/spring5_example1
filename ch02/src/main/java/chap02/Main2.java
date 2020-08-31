package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
    public static void main(String[] args){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
        Greeter g1 = ctx.getBean("greeter", Greeter.class);
        Greeter g2 = ctx.getBean("greeter", Greeter.class);

        // 스프링은 기본적으로 싱글톤 객체이기 때문에 결과값으로 true를 반환, 프로토타입객체로 지정할 수도 있음.
        System.out.println("(g1 == g2) = " + (g1 == g2));
        ctx.close();
    }
}
