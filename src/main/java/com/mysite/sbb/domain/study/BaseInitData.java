package com.mysite.sbb.domain.study;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BaseInitData {
    // Configuration은 클래스레벨, Bean은 메소드레벨에 설정한다.
    @Bean
    public List<Integer> ages(){
        return List.of(10,20,30,40,50);
    }

    @Bean
    public ApplicationRunner baseInitRunner(){
        // ApplicationRunner 타입의 빈은 시작시 돌아간다!
        // 샘플 만들 때 주로 쓴다
        return ApplicationRunner ->{
            System.out.println("리턴 양식");
        };
    }
}
