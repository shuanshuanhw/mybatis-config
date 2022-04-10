package com.example.mybatisconfig.threadpoolexecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExecutorController {
    @Autowired
    private AsyncService asyncService;

    @GetMapping("/async")
    @ResponseBody
    public String async(){
        asyncService.executeAsync();


        asyncService.myExecute();
        return "async";
    }

}
