package com.example.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SumMer
 * @version V1.0
 * @Title: BaseErrorController
 * @Package com.example.controller
 * @Description:
 * @date 2018-08-16 14:35
 */
@RestController
public class BaseErrorController extends AbstractMethodError {

    @RequestMapping(value = "/ex")
    public String error() {

        int i = 5 / 0;
        return "error";
    }

    /**
     * 局部异常处理
     */
    @ExceptionHandler(Exception.class)
    public String exHandler(Exception e) {
        // 判断发生异常的类型是除0异常则做出响应
        if (e instanceof ArithmeticException) {
            return "发生了除0异常";
        }
        // 未知的异常做出响应
        return "发生了未知异常";
    }
}
