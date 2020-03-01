package com.example.demo;

import com.example.demo.service.DemoService;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@TestConfiguration
@ComponentScan(basePackages = {"com.example.demo.config", "com.example.demo.converter", "com.example.demo.service"})
public class ProblemTestConfig {

    @Bean
    public DemoService demoService() {
        return Mockito.mock(DemoService.class);
    }
}
