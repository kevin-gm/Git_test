package com.kevin.blog;

import com.kevin.blog.web.domain.user.User;
import com.kevin.blog.web.mapper.user.UserMapper;
import com.kevin.blog.web.repository.user.UserRepository;
import com.kevin.blog.web.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	@Test
	public void contextLoads() {
		int i = userService.getAllUsers();
		System.out.println(i);
	}

	@Test
	public void testJpa() {
		List<User> users = userRepository.findAll();
		System.out.println(users.size());
	}

	@Test
	public void testMybatis() {
		User u = userMapper.findByName("");
		System.out.println(1);
	}
}
