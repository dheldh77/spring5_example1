package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args){
        // 스프링 컨테이너 생성
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);

        // 스프링 컨테이너에서 빈 객체를 구함. 매개변수로 해당하는 빈객체의 이름, 데이터 타입 전달
        Greeter g = ctx.getBean("greeter", Greeter.class);
        String msg = g.greet("스프링 ");
        System.out.println(msg);
        ctx.close();
    }
}
