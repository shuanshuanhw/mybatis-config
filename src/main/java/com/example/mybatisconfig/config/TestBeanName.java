package com.example.mybatisconfig.config;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class TestBeanName implements BeanNameAware, BeanClassLoaderAware {
    private String beanName;
    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }

    public String getBeanName()
    {
        return beanName;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {

    }
}
