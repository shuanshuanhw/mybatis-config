package com.example.mybatisconfig;

import com.example.mybatisconfig.config.BaseFactory;
import com.example.mybatisconfig.config.ResourceBean;
import com.example.mybatisconfig.config.SpringContextHolder;
import com.example.mybatisconfig.config.TestBeanName;
import com.example.mybatisconfig.domain.User;
import com.example.mybatisconfig.eventpublisher.UserRegisterEvent;
import com.example.mybatisconfig.eventpublisher.UserRegisterService;
import com.example.mybatisconfig.mapper.UserMapper;
import com.example.mybatisconfig.service.TestCom;
import com.example.mybatisconfig.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@SpringBootTest
class MybatisConfigApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    private BaseFactory baseFactory;

    @Autowired
    private Environment environment;

    @Autowired
    ResourceBean resourceBean;

    @Autowired
    TestBeanName testBeanName;

    @Autowired
    UserRegisterService userRegisterService;

    @Value("${shuanshuan.name}")
    private String userName;
    @Test
    void contextLoads() {
        User user = new User();
        user.setUserName("admin");
        user.setPassword("admin");
        User byUserNameAndPassword = userMapper.getByUserNameAndPassword(user);
        System.out.println(byUserNameAndPassword.toString());

        // 各种ware接口
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        System.out.println(request.getParameterMap());

        System.out.println("上下文：");

        SpringContextHolder.getApplicationContext().getBean(TestService.class).pring();

        TestService testService = (TestService) baseFactory.getService("testService");
        testService.pring();
        TestCom testCom = (TestCom) baseFactory.getService("testCom");
        testCom.print();

        System.out.println(environment.getProperty("spring.datasource.url"));

        Resource resource = resourceBean.getResourceLoader().getResource("classpath*:/mc.sql");
        String filename = resource.getFilename();
        System.out.println("文件名"+filename);

        System.out.println("感知的beanName:"+testBeanName.getBeanName());

        userRegisterService.getApplicationEventPublisher().publishEvent(new UserRegisterEvent(this, user));
        userRegisterService.getApplicationEventPublisher().publishEvent(new UserRegisterEvent(user));

        System.out.println("userName:"+userName);
    }

}
