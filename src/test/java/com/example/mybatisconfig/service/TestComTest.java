package com.example.mybatisconfig.service;

import com.alibaba.fastjson.JSONObject;
import com.example.mybatisconfig.controller.LoginController;
import com.example.mybatisconfig.domain.User;
import com.example.mybatisconfig.mapper.UserMapper;
import javafx.application.Application;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = LoginController.class)
class TestComTest extends MockMvcRequestBuilders {
  //  private UserMapper userMapper = Mockito.mock(UserMapper.class);
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        System.out.println("测试前");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void print() throws Exception {
        System.out.println("正在测试");
        User user = new User();
        user.setUserName("admin");
        user.setPassword("admin");

        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(user);
        String s = jsonObject.toJSONString();
        MvcResult mvcResult = mockMvc.perform(get("/usert").param("username", "shuanshuan").param("password", "huangwei"))

                .andExpect(MockMvcResultMatchers.status().isOk())
            //    .andExpect(MockMvcResultMatchers.view().name("index"))
                .andDo(MockMvcResultHandlers.print()).andReturn();


        System.out.println(mvcResult.getRequest().getAttribute("name"));
        System.out.println("mvcResult:"+mvcResult.getResponse().getContentAsString());
        //   ResultActions perform3 = mockMvc.perform(post("/users").param("userName","3shuanshuan").param("password","3huangwei").contentType(MediaType.APPLICATION_JSON)).andDo(MockMvcResultHandlers.print());
    //    ResultActions perform3 = mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(s)).andDo(MockMvcResultHandlers.print());
    //    ResultActions perform2 = mockMvc.perform(get("/users/{username}/{password}","2shuanshuan","2huangwei")).andDo(MockMvcResultHandlers.print());


//        when(userMapper.getByUserNameAndPassword(any(User.class))).then(returnsFirstArg());
//        User byUserNameAndPassword = userMapper.getByUserNameAndPassword(user);
//        System.out.println(byUserNameAndPassword.toString());
    }
}