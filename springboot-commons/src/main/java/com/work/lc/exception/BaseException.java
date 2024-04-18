package com.work.lc.exception;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Data;

@Data
public class BaseException extends Exception {
    private Integer code;

    private String message;
    public BaseException() {
        super();
    }

    public BaseException(String message){
        super(message);
        this.message = message;
    }

    public BaseException(int code,String message){
        this.code = code;
        this.message = message;
    }
}
