package com.itheima.service.impl;

import com.itheima.mapper.ResultMapper;
import com.itheima.model.Result;
import com.itheima.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultMapper resultMapper;


    @Override
    public void save(Result result) {
        resultMapper.save(result);
    }

    @Override
    public List<Result> findByUserId(Integer userId) {
        List<Result> results = resultMapper.selectByUserId(userId);
        return results;
    }
}
