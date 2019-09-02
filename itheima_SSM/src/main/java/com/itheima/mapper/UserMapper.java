package com.itheima.mapper;

import com.itheima.model.User;
import org.apache.ibatis.annotations.*;


import java.util.List;

public interface UserMapper {
/*
    private Integer id;
    private String username;
    private String password;
    //所有的抽奖结果  1 对 多
    private List<Result> resultList;*/

    @Select("select * from user where username = #{username} and password = #{password}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "resultList",column = "id",
                javaType = List.class,
                    many = @Many(select = "com.itheima.mapper.ResultMapper.selectByUserId")
            )
    })
//    public User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    public User findByUsernameAndPassword(User user);
}
