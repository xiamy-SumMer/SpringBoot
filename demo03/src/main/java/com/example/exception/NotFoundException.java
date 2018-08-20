package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author SumMer
 * @version V1.0
 * @Title: NotFoundException
 * @Package com.example.exception
 * @Description: 在自定义的异常上添加@ResponseStatus注解，将其映射为一个HTTP状态码
 * @date 2018-08-20 11:39
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "资源不存在")
public class NotFoundException extends RuntimeException {

}
