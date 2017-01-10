package com.kevin.boot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by Administrator on 2017/1/5 0005.
 */
public class CustomUserDetailService implements UserDetailsService {



    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("username", "password", null);
    }
}