package com.example.demo.app;


import com.example.demo.dto.AbstractObject;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private DemoService demoService;


	@StreamListener(Sink.INPUT)
	public void handle(AbstractObject message) {

		System.out.println("received message, commonValue = " + message.getCommonValue() + ", message = " + message.toString());

		// service that will send message into websocket...
		demoService.handle(message);
	}

}
