package com.zhx.help.controller;

import com.zhx.help.dao.GirlRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by 11 on 2017/3/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class GirlControllerTest extends MockMvcResultHandlers {

    private static Logger log = LoggerFactory.getLogger(GirlControllerTest.class);

    //模拟对象
    private MockMvc mvc;

    @InjectMocks
    private GirlController girlController;

    @Mock
    private GirlRepository girlRepository;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(girlController).build();
    }

    @Test
    public void girlList() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/girls");
        mvc.perform(request).andExpect(status().isOk());
    }

    @Test
    public void girlAdd() throws Exception {

    }

    @Test
    public void girlFindOne() throws Exception {
        RequestBuilder request =  MockMvcRequestBuilders.get("/girls/1");
        mvc.perform(request).andExpect(content().string("{\"id\":1,\"cupSize\":1,\"age\":1"));
    }

    @Test
    public void girlUpdate() throws Exception {

    }

    @Test
    public void girlDelete() throws Exception {

    }

    @Test
    public void girlListByAge() throws Exception {

    }

}