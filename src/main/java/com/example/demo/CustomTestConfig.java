package com.example.demo;
import org.springframework.context.annotation.Bean;
//import org.springframework.boot.test.context.*;


public class CustomTestConfig {
    @Bean
    public MyService myService(){
        return new MyService("Test instance");
    }
}
