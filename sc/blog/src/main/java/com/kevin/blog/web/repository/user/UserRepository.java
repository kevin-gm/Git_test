package com.kevin.blog.web.repository.user;

import com.kevin.blog.web.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Administrator on 2016/11/25 0025.
 */
public interface UserRepository extends JpaRepository<User, Long> {


}
