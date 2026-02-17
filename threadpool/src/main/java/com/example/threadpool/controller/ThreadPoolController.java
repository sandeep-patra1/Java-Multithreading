package com.example.threadpool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.threadpool.service.TaskService;

@RestController
public class ThreadPoolController {
	
	@Autowired
    private TaskService taskService;

    
    @GetMapping("/start")
    public String startTasks() {
    	System.out.println("Thread Name - "+Thread.currentThread().getName()+" started ...");
    	/*
    	 * When a user calls:
			http://localhost:8080/start
			Spring Boot (using embedded Tomcat) assigns a request-handling thread.
			
			It looks like this in logs:
			http-nio-8080-exec-1
			
			That thread is called:
			The request thread (or controller thread)
			It is responsible for:
				Running your controller method
				Sending the HTTP response back
    	 */
        for (int i = 1; i <= 10; i++) {
            taskService.longTask(i);
        }
        System.out.println("Thread Name - "+Thread.currentThread().getName()+" ended.");
        return "Tasks submitted!";
    }
}
