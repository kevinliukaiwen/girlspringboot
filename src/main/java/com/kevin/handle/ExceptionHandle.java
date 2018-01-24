package com.kevin.handle;

import com.kevin.domain.Result;
import com.kevin.exception.GirlException;
import com.kevin.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by kevin on 2018/1/21.
 */
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof GirlException) {
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(), girlException.getMessage());
        } else {
            return ResultUtil.error(-1, "未知错误");
        }
    }
}
