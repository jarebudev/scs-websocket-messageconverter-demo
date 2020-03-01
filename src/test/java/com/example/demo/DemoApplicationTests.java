package com.example.demo;

import com.example.demo.app.DemoApplication;
import com.example.demo.service.DemoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.stream.binder.test.InputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.messaging.support.GenericMessage;

import static org.mockito.ArgumentMatchers.any;

class DemoApplicationTests {

	public static final String CUSTOM_OBJECT_JSON = "{\"commonValue\":\"something\", \"customValue\":\"hello\", \"anotherValue\":\"world\"}";


	@Test
	public void testThatProblemConfigNeverCallsDemoService() {

		try (ConfigurableApplicationContext context = new SpringApplicationBuilder(
				TestChannelBinderConfiguration.getCompleteConfiguration(
						DemoApplication.class))
				.sources(ProblemTestConfig.class)
				.run()) {

			DemoService demoService = context.getBean(DemoService.class);

			InputDestination source = context.getBean(InputDestination.class);

			source.send(new GenericMessage<byte[]>(CUSTOM_OBJECT_JSON.getBytes()));

			Mockito.verify(demoService, Mockito.times(1)).handle(any());
		}
	}
}