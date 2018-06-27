package com.example.springlabjackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringLabJacksonApplicationTests {

	private MockMvc mvc;

	@InjectMocks
	private SpringLabJacksonApplication springLabJacksonApplication;

	@Before
	public void setup() {
		// We would need this line if we would not use MockitoJUnitRunner
		// MockitoAnnotations.initMocks(this);
		// Initializes the JacksonTester
		JacksonTester.initFields(this, new ObjectMapper());
		// MockMvc standalone approach
		mvc = MockMvcBuilders.standaloneSetup(springLabJacksonApplication).build();
//				.setControllerAdvice(new SuperHeroExceptionHandler())
//				.addFilters(new SuperHeroFilter())
//				.build();
	}


	@Test
	public void contextLoads() {

	}

}
