package com.kevin.blog.web.service.impl;

import com.kevin.blog.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/11/25 0025.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from blog_user", Integer.class);
    }
}
