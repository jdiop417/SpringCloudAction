package org.learning.springboot.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCircuitBreaker
@SpringBootApplication
@EnableFeignClients
public class HtystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(HtystrixApplication.class, args);
    }

}
