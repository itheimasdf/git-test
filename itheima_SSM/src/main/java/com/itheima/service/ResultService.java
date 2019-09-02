package com.itheima.service;

import com.itheima.model.Result;

import java.util.List;

public interface ResultService {
    void save(Result result);

    List<Result> findByUserId(Integer id);
}
