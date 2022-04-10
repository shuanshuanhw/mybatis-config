package com.example.mybatisconfig.asynctack;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component //开启扫描
@Async  //异步。如果没有就是普通类，就不能完成并行执行动作。
public class AsyncTack {
    public void task1(){
        try{
            Thread.sleep(4000);

        }catch (Exception e){

        }
        System.out.println("task1...");
    }
    public void task2(){
        try{
            Thread.sleep(4000);

        }catch (Exception e){

        }
        System.out.println("task2....");
    }
    public void task3(){
        try{
            Thread.sleep(4000);

        }catch (Exception e){

        }
        System.out.println("task3....");
    }
    //可以在处理异步请求的时候，返回一些对象
    public Future<String> task4(){
        try {
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task4........ ");

        return new AsyncResult<String>("task4");
    }
    //可以在处理异步请求的时候，返回一些对象
    public Future<String> task5(){
        try{
            Thread.sleep(4000);

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("task5....");
        return new AsyncResult<String>("task5");
    }

}
