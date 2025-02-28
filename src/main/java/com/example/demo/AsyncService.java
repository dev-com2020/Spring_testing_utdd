package com.example.demo;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Service
public class AsyncService {

    @Async
    public void asyncMethod(CountDownLatch latch){
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Async method completed");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            latch.countDown();
        }
    }
}
