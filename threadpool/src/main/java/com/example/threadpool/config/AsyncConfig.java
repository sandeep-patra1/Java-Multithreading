package com.example.threadpool.config;

import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
//@EnableAsync
public class AsyncConfig {

	 @Bean("myExecutor")
	    public ThreadPoolTaskExecutor taskExecutor() {

	        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

	        executor.setCorePoolSize(2);
	        executor.setMaxPoolSize(4);
	        executor.setQueueCapacity(5);
	        executor.setThreadNamePrefix("my-thread-");

	        executor.setWaitForTasksToCompleteOnShutdown(true);
	        executor.setAwaitTerminationSeconds(20);
	        
	        /*
	         * 2 running immediately
				+ 5 waiting in queue
				+ 2 extra threads (maxPoolSize - corePoolSize)
				= 9 tasks total
	         */
	        
	        //when the max capacity exceeds 
//	        executor.setRejectedExecutionHandler((r, ex) -> {
//	            System.out.println("Task Rejected: " + r.toString());
//	            throw new RuntimeException("System overloaded. Try again later.");
//	        	logger.error("Task rejected due to overload");
//	        });
	        
	        // Important part - Controller thread executes the task itself.
	        executor.setRejectedExecutionHandler(
	                new ThreadPoolExecutor.CallerRunsPolicy()
	        );
	        /*
	         * You have 4 workers (thread pool).
				All are busy.
				Queue is full.
				
				A new customer comes.
				Instead of rejecting the customer:
				The manager (controller thread) says:
				“Okay, I will handle this one myself.”
				
				That’s CallerRunsPolicy
	         */

	        executor.initialize();

	        return executor;
	    }
}
