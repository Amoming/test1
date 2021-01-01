package com.controller;

import com.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 获取请求参数：
 * 1.参数名 = 参数值&参数名=参数值 -->参数类型form-data(get请求)                         --->都是用pojo类型直接进行封装
 *   参数名 = 参数值&参数名=参数值 -->参数类型 x-www-form-urlencoded(表单提交) 请求体当中   --->都是用pojo类型直接进行封装
 *      1.1以单个参数接收：在处理请求方法上，保证参数名与请求参数名一致即可
 *      SpringMVC内置类型转换器
 *      1.2以对象接收 pojo对象 在处理请求的方法中添加一个POJO类型的参数 保证POJO中的参数名和对应的参数名保持一致
 *                  map对象 用于接收请求参数 map的key是参数名 map的value是参数值 但是参数值是String类型
 *                  List对象 接收多个同名对象 List @RequestParam注解
 *
 * 2.{参数名:参数值,参数名:参数值} -->Json类型 content-type：application-json(Vue的post postman中 Content-Type为application-json)
 *      1.封装到pojo中 无法实现自动封装
 *         1.1 pojo中的属性和请求参数要对应
 *         1.2 必须在方法中的pojo类型的参数添加@RequestBody注解
 *         1.3 必须引入JackSon依赖
 *
 *
 * 常用注解:
 * 1. RequestParam注解：
 *   1.1 用在获取请求参数，封装到List或着Map对象，一定要用RequestParam注解
 *   1.2 当请求参数名和方法的参数名不一致时，可使用RequestParam指定获取哪个请求参数进行赋值
 *
 * 2. RequestBody
 *   2.1 获取请求体信息
 *   2.2 获取Json类型数据 (content—Type:application-json)封装到pojo中
 *
 * 3. RequestHeader注解
 *
 * 4.SessionAttributes注解
 *
 * Controller中的方法返回类型
 * 1. 返回String类型
 *
 * 2，返回ModelAndView
 */
@RestController  //响应Json
//@Controller
@RequestMapping("/user")
@ResponseBody//加载在类上就不用在方法上单独加
public class UserController {
    @RequestMapping("/sayHello")
    public String sayHello(){
        System.out.println("用户");
        //请求转发到成功页面 --->/WEB-INF/pages/success.jsp
        return "success";
    }

    @RequestMapping("/add")
    public String addUser(@RequestParam("name")String username){
        System.out.println("获取的参数为"+username);
        System.out.println("执行添加操作");
        return "success";
    }

    @PostMapping("register")
    public String regist(User user){
        System.out.println(user);
        return "success";
    }

    @RequestMapping("deleteAll")
    public String deleteAll(@RequestParam List<Integer> id){
        System.out.println(id);
        return "success";
    }

    /**
     * 封装到map中 map参数名没有要求
     * @return
     */
    @RequestMapping("paramToMap")
    public String ParamTpMap(@RequestParam Map<String,Object> map){
        System.out.println(map);
        return "success";
    }

    @RequestMapping("useServletApi")
    public String userServletAoi(HttpSession session, HttpServletRequest request){
        //我们想使用response对象进行重定向
        String header = request.getHeader("User-Agent");
        System.out.println(header);
        //session对象存值 HttpSession session = request.getSession();
        session.setAttribute("username","zhangsan");
        return "success";
    }

    @PostMapping("getRequestBody")
    public String getRequestBody(@RequestBody String body){
        System.out.println(body);
        return "success";
    }
    //**************************************************

    /**
     * 获取Json类型参数
     * @param user
     * @return
     */
    @PostMapping("getUserInfo")
    public String getUserInfo(@RequestBody User user){
        //requestBody自动解析 User
        System.out.println(user);
        return "success";
    }
    //**************************************************
    //**************************************************
    @DeleteMapping("/{id}/{cardNumber}")
    public String deleteById(@PathVariable("id") int a,@PathVariable("cardNumber") String cardNum){
        System.out.println("要删除的id:"+a+"身份证号为："+cardNum);
        return "success";
    }
    //**************************************************
    @GetMapping("/{id}")
    public String findById(@PathVariable("id") int a){
        System.out.println("要查询的id"+a);
        return "success";
    }

    @RequestMapping("/getUserAgent")
    public String getUserAgent(@RequestHeader("user-Agent") String userAgent){
        System.out.println(userAgent);
        return "success";
    }

    @RequestMapping("/getCookieValue")
    public String getCookieValue(@CookieValue("JSESSIONID") String cookieValue){
        /**
         * 用户的简单信息存储到客户端
         */
        System.out.println(cookieValue);
        return "success";
    }

    //@ModelAttribute 注解
    //查到用户进行返回
//    @ModelAttribute
//    public User getUser(int id){
//        User user = new User();
//        return user;
//    }

    @RequestMapping("msg")
    public String msg(Model model){
        //model代表数据模型 往域对象中存数据
        model.addAttribute("msg","我是域对象中的数据");
        return "success";
    }

    @RequestMapping("modelAndView")
    public ModelAndView modelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("obj","我是modelAndView值");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("testRedirect")
    public String redirect(){
        return "redirect:http://www.baidu.com";
//        return "forward:/WEB-INF/pages/success.jsp";
    }

    //**************************************************
    @RequestMapping("/responseJson")
    @ResponseBody
    public User responseJson(){
        User user = new User();
        user.setName("张三");
        user.setAge(12);
        user.setAddress("召唤师峡谷");
        user.setBirthday(new Date());
        return user;
    }
    //**************************************************
}
