package com.example.mybatisconfig.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


//@SpringBootTest
public class TestServiceTest {

    @DisplayName("测试断言equals")
    @Test
    public void pring() {
        Assertions.assertTrue(3<2);

    }
}