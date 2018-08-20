package com.example.exception;

/**
 * @author SumMer
 * @version V1.0
 * @Title: MyException
 * @Package com.example.exception
 * @Description: 自定义异常类
 * @date 2018-08-20 11:08
 */
public class MyException extends Exception {

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public MyException(String message) {

        super(message);
    }
}
