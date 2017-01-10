package com.kevin.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/12/25 0025.
 */
@Controller
@RequestMapping(value = "/view")
public class ViewController {

    @RequestMapping(value = "/first")
    public String first() {
        return "first";
    }
}