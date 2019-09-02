package com.itheima.mapper;

import com.itheima.model.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ResultMapperTest {

    @Autowired
    private ResultMapper resultMapper;

    @Test
    public void testInsert(){
        Result result = new Result();
        result.setUserId(1);
        result.setPrize("999元");
        resultMapper.save(result);
    }



}
