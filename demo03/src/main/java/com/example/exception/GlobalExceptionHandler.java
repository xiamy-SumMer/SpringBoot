package com.example.exception;

import com.example.dto.ErrorInfo;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author SumMer
 * @version V1.0
 * @Title: defaultErrorHandler
 * @Package com.example.controller
 * @Description: 统一处理的异常类
 * @date 2018-08-20 10:23
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 创建全局异常处理类：通过使用@ControllerAdvice定义统一的异常处理类，
     * 而不是在每个Controller中逐个定义。@ExceptionHandler用来定义函数针对的异常类型，
     * 最后将Exception对象和请求URL映射到error.html中
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", e.getMessage());
        modelAndView.addObject("requestUrl", req.getRequestURL());
        modelAndView.setViewName("error");
        return modelAndView;
    }


    /**
     * 异常信息返回json格式。
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, MyException e) {

        ErrorInfo<String> err = new ErrorInfo<>();
        err.setCode(500);
        err.setMessage(e.getMessage());
        err.setUrl(req.getRequestURI());
        err.setData("异常错误信息");
        return err;
    }

}
