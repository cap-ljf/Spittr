package controller;

import com.jifang.spittr.web.HomeController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * author: jifang
 * date: 18-4-6 下午2:14
 */

public class HomeControllerTest {

    @Test
    public void testHomePage() throws Exception {
        HomeController homeController = new HomeController();

        //搭建MockMvc
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
        //对"/"执行GET请求
        MockHttpServletRequestBuilder requestBuilder = get("/");
        mockMvc.perform(requestBuilder)
                .andExpect(view().name("home")); //预期得到home视图
    }
}
