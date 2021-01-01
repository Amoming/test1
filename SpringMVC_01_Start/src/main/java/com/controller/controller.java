package com.controller;

import com.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;

/**
 * 1.进行IOC
 * 2.让@RequestMapping 注解生效 接收对应请求
 *      配置DispatcherServlet 接收并分发请求
 *      1. value path都是一样的 映射路径可以不写斜杠
 *      2. method属性 指定当前方法只能处理什么请求 get,post,delete等请求
 *          我们可以使用getMapping PostMapping DeleteMapping 代替
 * 3.return "success"生效 跳转到 success.jsp
 *   在spring的核心容器中配置视图解析器 让success-->视图地址/WEB-INF/pages/success.jsp
 */
@Controller
@RequestMapping("/hello")
public class controller {

    @RequestMapping(value = "/sayHello",method = RequestMethod.GET)
    public String sayHello(){
        System.out.println("Hello world");
        //请求转发到成功页面 --->/WEB-INF/pages/success.jsp
        return "success";
    }

    @PostMapping("/add")
    public String addUser(User user){
        System.out.println("执行添加操作");
        return "success";
    }
}
