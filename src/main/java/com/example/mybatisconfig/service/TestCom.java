package com.example.mybatisconfig.service;

import com.example.mybatisconfig.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestCom {
    private UserMapper userMapper;

    public void print()
    {
        System.out.println("TestCom");
    }
}
