package com.ananda.labjackson.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(MockitoJUnitRunner.class)
public class HomeControllerMockMvcStandaloneTest {

    /*
    mvn -Dtest=HomeControllerMockMvcStandaloneTest test
    */

    private MockMvc mvc;

    @InjectMocks
    private HomeController homeController;

//    private JacksonTester<SuperHero> jsonSuperHero;

    @Before
    public void setUp(){
        System.out.println("----- Before run ----");
        mvc = MockMvcBuilders.standaloneSetup(homeController)
//                .setControllerAdvice(new SuperHeroExceptionHandler())
//                .addFilters(new SuperHeroFilter())
                .build();
    }

    @Test
    public void testGetServiceStatus() throws Exception {
        System.out.println("---- Test method HomeControllerMockMvcStandaloneTest.testGetServiceStatus()");

        MockHttpServletResponse response = mvc.perform(
                get("/home/status")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        System.out.println("------------ "+ response.getContentAsString());
        System.out.println("------------ "+ response.getStatus());

    }

}
