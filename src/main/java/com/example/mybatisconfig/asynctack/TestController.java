package com.example.mybatisconfig.asynctack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
@RequestMapping("/api/v1/test")
//@PropertySource("classpath:pay1.properties")
public class TestController {
    @Autowired
    private AsyncTack asyncTack;
    @GetMapping("/async")
    public String testAsync(){
        long begin=System.currentTimeMillis();
         /*
         asyncTack.task1();
         asyncTack.task2();
         asyncTack.task3();
          */
        Future<String> task4 = asyncTack.task4();
        Future<String> task5 = asyncTack.task5();
        while (true){
            if (task4.isDone() && task5.isDone()){//是否完成
                try {
                    String s4 = task4.get();
                    System.out.println("我是s4:"+s4);
                    String s5 = task5.get();
                    System.out.println("我是s5:"+s5);
                }catch (Exception e){

                }finally {
                    break;
                }
            }

        }
        long end=System.currentTimeMillis();
        return String.valueOf(end-begin);//可以计算一下执行了多少毫秒

    }
}