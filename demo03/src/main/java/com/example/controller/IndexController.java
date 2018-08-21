package com.example.controller;

import com.example.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SumMer
 * @version V1.0
 * @Title: IndexController
 * @Package com.example.controller
 * @Description:
 * @date 2018-08-20 10:28
 */
@RestController
@Slf4j
public class IndexController {

    @RequestMapping("index")
    public String index() {

        int j = 1 / 0;
        return String.valueOf(j);
    }

    @RequestMapping("json")
    public String json() throws Exception {

        throw new MyException("json发生未知错误");
    }

    @RequestMapping("aop")
    public String aop() {

        return "success1";
    }
}
