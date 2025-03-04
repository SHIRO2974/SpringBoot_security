package com.korit.springboot_security.mapper;

import com.korit.springboot_security.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User selectByUserName(String userName);
    int insertUser(User user);
    User selectById(int userId);
    List<User> selectAll();
    int updateUserById(User user);
    int deleteById(int userId);
}
