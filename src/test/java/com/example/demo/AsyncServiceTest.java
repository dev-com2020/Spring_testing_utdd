package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AsyncServiceTest {
    @Autowired
    private AsyncService asyncService;

    @Test
    void shouldWaitForAsync() throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(1);

        asyncService.asyncMethod(latch);

        boolean completed = latch.await(3, TimeUnit.SECONDS);

        assertThat(completed).isTrue();
    }
}
