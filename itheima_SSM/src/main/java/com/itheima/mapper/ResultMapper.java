package com.itheima.mapper;


import com.itheima.model.Result;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ResultMapper {

  /*  private Integer id;
    private int userId;
    private String prize;*/


    @Select("select * from result where userId = #{userId}")
    public List<Result> selectByUserId(int userId);

    @Insert("insert into result values (#{id},#{userId},#{prize})")
    public void save(Result result);

}
