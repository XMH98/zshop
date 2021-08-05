package com.xmh.zshop.exception;

/**
 * Author: 徐明皓
 * Date: 2021-08-05 21:34
 * Description: <描述>
 */
public class FileUploadException extends Exception{
    public FileUploadException() {
    }

    public FileUploadException(String message) {
        super(message);
    }

    public FileUploadException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileUploadException(Throwable cause) {
        super(cause);
    }
}
