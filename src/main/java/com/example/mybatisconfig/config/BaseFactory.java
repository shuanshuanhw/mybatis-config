package com.example.mybatisconfig.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

@Component("baseFactory")
public class BaseFactory implements BeanFactoryAware {
    private BeanFactory beanFactory;

    public Object getService(String code) {
        return beanFactory.getBean(code);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

}