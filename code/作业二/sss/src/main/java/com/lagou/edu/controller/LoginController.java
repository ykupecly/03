package com.lagou.edu.controller;

import com.lagou.edu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;


@Controller
public class LoginController {

    /**
     * 跳转到登陆页面
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin() {
        return "login";
    }

    /**
     * 用户登录
     *
     * @param user
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, Model model, HttpSession session) {
        //获取用户名和密码
        String userName = user.getUserName();
        String passWord = user.getPassWord();
        //些处横板从数据库中获取对用户名和密码后进行判断
        if (userName != null && userName.equals("admin") && passWord != null && passWord.equals("admin")) {
            //将用户对象添加到Session中
            session.setAttribute("USER_SESSION", user);
            //重定向到列表页面的跳转方法
            return "redirect:resume";
        }
        model.addAttribute("msg", "用户名或密码错误，请重新登录！");
        return "login";
    }

    @RequestMapping(value = "/resume")
    public String toResume() {
        return "resume";
    }

    @RequestMapping(value = "/add")
    public String toAdd() {
        return "add";
    }
}
