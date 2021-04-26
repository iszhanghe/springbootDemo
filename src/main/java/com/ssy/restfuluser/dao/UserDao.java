package com.ssy.restfuluser.dao;

import com.ssy.restfuluser.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    User getUserbyToken(@Param("id") String id, @Param("pwd") String pwd);

}
