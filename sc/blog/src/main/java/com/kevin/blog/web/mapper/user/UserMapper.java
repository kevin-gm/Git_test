package com.kevin.blog.web.mapper.user;

import com.kevin.blog.web.domain.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2016/11/25 0025.
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM blog_user WHERE user_name = #{name}")
    User findByName(@Param("name") String name);
}
