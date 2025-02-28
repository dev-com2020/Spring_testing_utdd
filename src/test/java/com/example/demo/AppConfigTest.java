package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Import(CustomTestConfig.class)
public class AppConfigTest {

    @Autowired
    private MyService myService;

    @Test
    void shouldLoadServiceFromContext(){
        assertThat(myService).isNotNull();
    }
}
