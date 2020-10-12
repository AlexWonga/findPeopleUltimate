package com.j2ee.homework.findPeople.controller;

import com.j2ee.homework.findPeople.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        sqlSession.hashCode();
        return "hello";
    }
}
