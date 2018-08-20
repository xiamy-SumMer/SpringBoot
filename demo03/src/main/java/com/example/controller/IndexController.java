package com.example.controller;

import com.example.exception.MyException;
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
public class IndexController {

    @RequestMapping("index")
    public String index() throws Exception {

        throw new Exception("发生未知错误");
    }

    @RequestMapping("json")
    public String json() throws Exception {

        throw new MyException("json发生未知错误");
    }
}
