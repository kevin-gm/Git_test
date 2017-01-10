package com.kevin.boot.repository;

import com.kevin.boot.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/12/18 0018.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}