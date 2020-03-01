package com.example.demo.config;

import com.example.demo.converter.CustomMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MessageConverter;

@Configuration
public class ScsConfig {

    @Bean
    public MessageConverter customMessageConverter() {
        return new CustomMessageConverter();
    }
}
