package com.kevin.blog.web.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/11/23 0023.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = "/login")
    public void login(HttpServletRequest request) {
        System.out.println(request.getParameter("username"));
    }
}