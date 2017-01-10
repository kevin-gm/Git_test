package com.kevin.blog.web.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/15 0015.
 */
@Controller
//@RequestMapping(value = "/index")
public class IndexController {

    @RequestMapping(value = "/index")
    public String index(ModelMap map) {
        map.put("nav_type", "navbar-default");
        return "index";
    }

    @RequestMapping(value = "/article/{id}")
    public String article(ModelMap map, @PathVariable("id") String id) {
        map.put("nav_type", "navbar-default");
        map.put("content", "<div>Nihao</div><div>The First Article</div><div>" + id + "</div>");
        return "article";
    }

    public static void main(String[] args) {
        List<String> lists = new ArrayList<>();
    }
}
