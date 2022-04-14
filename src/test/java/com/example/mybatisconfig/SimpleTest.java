package com.example.mybatisconfig;

//import org.junit.Assert;
//import org.junit.Test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisconfig.mybatis.entity.User;
import com.example.mybatisconfig.mybatis.mapper.UserMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
public class SimpleTest {
    @Autowired
    UserMapper userMapper;
    @Test
    public void doTest() {
        int num = new Integer(1);
  //      Assert.assertEquals(num,2);
      //  Assert.assertEquals(num, 1);
        PageHelper.startPage(1,4);
        List<User> userList = userMapper.selectList(new QueryWrapper<>());
        for(User user:userList)
        {
            System.out.println(user.getUserName());
        }


    }
}
