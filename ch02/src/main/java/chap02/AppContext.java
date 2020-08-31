package chap02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 설정 클래스로 지정
@Configuration
public class AppContext {

    // 빈 객체
    // 빈 객체로 등록되면 스프링 컨테이너가 생성, 초기화, 종료 등 관리
    @Bean
    public Greeter greeter(){
        Greeter g = new Greeter();
        g.setFormat("%s, 안녕하세요 !");
        return g;
    }
}
