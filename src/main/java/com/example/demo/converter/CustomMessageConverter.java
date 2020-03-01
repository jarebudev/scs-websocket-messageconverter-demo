package com.example.demo.converter;

import com.example.demo.dto.AbstractObject;
import com.example.demo.dto.CustomObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConversionException;

import java.io.IOException;

public class CustomMessageConverter extends MappingJackson2MessageConverter {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    protected boolean supports(Class<?> clazz) {
        return (AbstractObject.class.equals(clazz));
    }

    @Override
    protected Object convertFromInternal(Message<?> message, Class<?> targetClass, Object conversionHint) {
        System.out.println("Expect to see me in the output......... " + targetClass.getName());
        try {
            return objectMapper.readValue((byte[])message.getPayload(), CustomObject.class);
        } catch (IOException e) {
            throw new MessageConversionException("couldnt convert", e);
        }
    }
}