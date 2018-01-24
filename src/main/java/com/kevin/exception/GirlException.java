package com.kevin.exception;

/**
 * Created by kevin on 2018/1/21.
 */
public class GirlException extends RuntimeException {
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public GirlException(Integer code,String message) {
        super(message);
        this.code = code;
    }
}
