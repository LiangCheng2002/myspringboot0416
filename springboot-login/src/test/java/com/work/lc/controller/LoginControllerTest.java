package com.work.lc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
//
//@SpringBootTest
//@WebMvcTest(controllers = LoginController.class)
//public class LoginControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//
//    @Test
//    public void testLogin() {
//
//        // 发起 GET 请求，传入 URL 地址
//        mockMvc.perform(get("/users/{userId}", 1L))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.id", is(1)))
//                .andExpect(jsonPath("$.name", is("John")));
//    }
//}
