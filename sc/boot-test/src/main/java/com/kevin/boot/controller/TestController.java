package com.kevin.boot.controller;

import com.kevin.boot.entity.Department;
import com.kevin.boot.entity.Role;
import com.kevin.boot.entity.User;
import com.kevin.boot.repository.DepartmentRepository;
import com.kevin.boot.repository.RoleRepository;
import com.kevin.boot.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/19 0019.
 */
@RestController
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping(value = "/test")
    public String test() {
        userRepository.deleteAll();
        roleRepository.deleteAll();
        departmentRepository.deleteAll();
        Department department = new Department();
        department.setName("开发部");
        departmentRepository.save(department);
        Assert.notNull(department.getId());

        Role role = new Role();
        role.setName("admin");
        roleRepository.save(role);
        Assert.notNull(role.getId());

        User user = new User();
        user.setName("user");
        user.setCreatedate(new Date());
        user.setDepartment(department);
        List<Role> roles = roleRepository.findAll();
        Assert.notNull(roles);
        user.setRoles(roles);

        userRepository.save(user);
        Assert.notNull(user.getId());

        return "success";
    }

    @RequestMapping(value = "/findPage")
    public Page<User> findPage() {
        Pageable pageable = new PageRequest(0, 10, new Sort(Sort.Direction.ASC, "id"));
        Page<User> page = userRepository.findAll(pageable);
        Assert.notNull(page);

        for(User user : page.getContent()) {
            logger.info("===user===, user name:{}, department name:{}, role name:{}",
                    user.getName(), user.getDepartment().getName(), user.getRoles().get(0).getName());
        }

        return page;
    }

    @RequestMapping(value = "/testSpace")
    public void testSpace(String a, String b) {
        logger.info(a);
        logger.info(b);
    }

    @RequestMapping(value = "/returnXml", produces = "application/xml;charset=UTF-8")
    public String returnXml() {
        return "xml";
    }
}