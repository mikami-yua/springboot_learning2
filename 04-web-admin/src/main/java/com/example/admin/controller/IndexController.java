package com.example.admin.controller;

import com.example.admin.bean.User;import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpSession;

/**
 * 复制页面跳转的controller
 */
@Controller
public class IndexController {

    /**
     * 去登录页
     */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    /**
     * 处理登录请求，登录成功之后到main页面
     */
    @PostMapping("/login")//只有通过post请求的登录才是登录
    public String main(User user,HttpSession session,Model model){

        if(!StringUtils.isEmpty(user.getUserName())&& !StringUtils.isEmpty(user.getPassWord())){
            session.setAttribute("loginUser",user);//把登录成功的用户保持起来
            //登录成功重定向到main.html。之前存在的问题是登录到main页面之后，请求还是表单，刷新之后再次提交表单
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","账号密码错误");
            //回到登录页
            return "login";
        }


    }

    /**
     * 解决点击刷新键没有刷新页面而是重复提交了表单,真正的去main页面
     */
    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){

        //是否登录使用拦截器 过滤器
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null) {
            return "main";
        }else {
            model.addAttribute("msg","请重新登录");
            //回到登录页
            return "login";
        }


    }
}
