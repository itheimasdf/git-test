package com.itheima.model;

import lombok.Data;

import java.util.List;

@Data
public class User {

    private Integer id;
    private String username;
    private String password;
    //所有的抽奖结果  1 对 多
    private List<Result> resultList;

}
