package ru.sbrf.jschool.springmvc;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ContextConfiguration("classpath:applicationContext.xml")
@WebAppConfiguration
public class ControllerExampleTest extends AbstractTestNGSpringContextTests {

    private MockMvc mockMvc;

    @org.testng.annotations.Test
    public void testGetMethodExample() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.status().is(200));
    }
}