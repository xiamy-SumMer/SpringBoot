package com.example.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author SumMer
 * @version V1.0
 * @Title: ErrorInfo
 * @Package com.example.dto
 * @Description: 异常处理对象
 * @date 2018-08-20 10:57
 */
@Getter
@Setter
@ToString
public class ErrorInfo<T> {

    private Integer code;

    private String message;

    private String url;

    private T data;
}
