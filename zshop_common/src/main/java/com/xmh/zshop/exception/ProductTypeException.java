package com.xmh.zshop.exception;

/**
 * Author: 徐明皓
 * Date: 2021-08-03 18:15
 * Description: <描述>
 */
public class ProductTypeException extends Exception{
    public ProductTypeException() {
    }

    public ProductTypeException(String message) {
        super(message);
    }

    public ProductTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductTypeException(Throwable cause) {
        super(cause);
    }
}
