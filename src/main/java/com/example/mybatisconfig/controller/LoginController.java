package com.example.mybatisconfig.controller;

import com.example.mybatisconfig.domain.User;
import com.example.mybatisconfig.mapper.UserMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.Map;

@Slf4j
@Controller
//@RequiredArgsConstructor
public class LoginController {

//    @Autowired
//    private UserMapper userMapper;


    @PostMapping("/users")
    public void index2(@RequestBody User user, ModelAndView modelAndView)
    {
        System.out.println("username:"+user.getUserName());
        System.out.println("password:"+user.getPassword());
        modelAndView.setViewName("index4");
    //    return modelAndView;
    }


    @GetMapping("/users/{username}/{password}")
    @ResponseBody
    public String index(@PathVariable String username,@PathVariable String password)
    {

        System.out.println("username:"+username);
        System.out.println("password:"+password);
        return "index";
    }

    @GetMapping("/usert")
    @ResponseBody
    public String index1(@PathParam("username") String username, @PathParam("password") String password,HttpServletRequest req)
    {
        System.out.println("username:"+username);
        System.out.println("password:"+password);
      //  modelAndView.setViewName("index5");
        int i = 2/0;
        req.setAttribute("name","good");
        return "indexfdf";
    }


//    @RequestMapping("/user/login")
//    public String doLogin(@ModelAttribute User user, Map<String, Object> map, HttpSession session) {
//
//
//        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        requestAttributes.getRequest();
//
//      //  SpringContext
//
//        //从数据库中查询用户信息
//        User loginUser = userMapper.getByUserNameAndPassword(user);
//        if (loginUser != null) {
//            session.setAttribute("loginUser", loginUser);
//            log.info("登陆成功，用户名：" + loginUser.getUserName());
//            //防止重复提交使用重定向
//            return "redirect:/main.html";
//        } else {
//            map.put("msg", "用户名或密码错误");
//            log.error("登陆失败");
//            return "login";
//        }
//    }

//    @GetMapping("/")
//    @ResponseBody
//    public String index()
//    {
//        PageHelper.startPage(1,3);
//        Page<User> userList = userMapper.getUserList();
//        for(User user:userList)
//        {
//            System.out.println(user.getUserName());
//        }
//        return "ddddd";
//    }
}