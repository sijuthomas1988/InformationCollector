package com.skr.kramphub.informationapi.controller;

import com.skr.kramphub.informationapi.configuration.ApiConnectionConfiguration;
import com.skr.kramphub.informationapi.configuration.ApiJsonConfiguration;
import com.skr.kramphub.informationapi.service.ItemService;
import com.skr.kramphub.informationapi.service.implementation.ApiServiceImpl;
import com.skr.kramphub.informationapi.service.implementation.ItemServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApiController.class)
@WebAppConfiguration
@EnableWebMvc
@ContextConfiguration(classes = {ApiConnectionConfiguration.class, ApiJsonConfiguration.class, ItemServiceImpl.class,
                                 ApiServiceImpl.class})
public class ApiControllerTest {

    protected MockMvc mockMvc;

    @Autowired
    private ItemService itemService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void findItems_success() throws Exception {
        String uri = "/v1/getInfo/{input}";
        MvcResult result = mockMvc.perform(get(uri, "da")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].kind").value("BOOK"))
                .andReturn();
    }

    @Test
    public void findItems_failure() throws Exception {
        String uri = "/v1/getInfo";
        MvcResult result = mockMvc.perform(get(uri)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is4xxClientError())
                .andReturn();
    }
}