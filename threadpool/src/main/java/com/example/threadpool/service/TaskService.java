package com.example.threadpool.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Async("myExecutor")
    public void longTask(int id) {

        System.out.println("Started Task " + id +
                " | Thread: " + Thread.currentThread().getName());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Finished Task " + id);
    }
}
