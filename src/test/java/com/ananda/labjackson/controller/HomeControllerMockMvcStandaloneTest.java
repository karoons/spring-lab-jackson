package com.ananda.labjackson.controller;

import com.ananda.labjackson.service.MemberService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(MockitoJUnitRunner.class)
public class HomeControllerMockMvcStandaloneTest {

    /*
    mvn -Dtest=HomeControllerMockMvcStandaloneTest#testGetServiceStatusByInstanceId test
    */

    private MockMvc mvc;

    @Mock
    private MemberService memberService;

    @InjectMocks
    private HomeController homeController;

//    private JacksonTester<SuperHero> jsonSuperHero;

    @Before
    public void setUp() throws Exception {
        System.out.println("----- Before run ----");
        mvc = MockMvcBuilders.standaloneSetup(homeController)
//                .setControllerAdvice(new SuperHeroExceptionHandler())
//                .addFilters(new SuperHeroFilter())
                .build();
    }

    @Test
    public void testGetServiceStatus() throws Exception {
        System.out.println("---- Test method HomeControllerMockMvcStandaloneTest.testGetServiceStatus()");

//        Mockito.when(memberService.getProfile("001")).thenReturn("karoons");
        MockHttpServletResponse response = mvc.perform(
                get("/home/status")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        System.out.println("------------ "+ response.getContentAsString());
        System.out.println("------------ "+ response.getStatus());

    }

    @Test
    public void testGetServiceStatusByInstanceId() throws Exception {
        System.out.println("---- Test method HomeControllerMockMvcStandaloneTest.testGetServiceStatusByInstanceId()");
        Mockito.when(memberService.getProfile("1")).thenReturn("karoons_mock");
        MockHttpServletResponse response = mvc.perform(
                get("/home/status/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        System.out.println("------------ "+ response.getContentAsString());
        System.out.println("------------ "+ response.getStatus());

    }

    @Test
    public void testGetServiceStatusByInstanceIdByBDDMockito() throws Exception {
        System.out.println("---- Test method HomeControllerMockMvcStandaloneTest.testGetServiceStatusByInstanceIdByBDDMockito()");
//        Mockito.when(memberService.getProfile("1")).thenReturn("karoons_mock");
        //mvn -Dtest=HomeControllerMockMvcStandaloneTest#testGetServiceStatusByInstanceIdByBDDMockito test
        given(memberService.getProfile("1"))
                .willReturn("karoons_mockBdd");

        MockHttpServletResponse response = mvc.perform(
                get("/home/status/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        System.out.println("------------ "+ response.getContentAsString());
        System.out.println("------------ "+ response.getStatus());

    }

}
