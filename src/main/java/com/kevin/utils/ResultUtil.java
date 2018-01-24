package com.kevin.utils;

import com.kevin.domain.Result;

/**
 * Created by kevin on 2018/1/21.
 */
public class ResultUtil {
    /**
     * 成功返回方法
     * @param o
     * @return
     */
    public static Result success(Object o) {
        Result result = new Result();
        result.setMsg("成功");
        result.setCode(0);
        result.setData(o);
        return result;
    }
    public static Result success() {
        return success(null);
    }
    /**
     * 失败返回方法
     * @param code
     * @param msg
     * @return
     */
    public static Result error(Integer code,String msg) {
        Result result = new Result();
        result.setMsg(msg);
        result.setCode(code);
        return result;
    }
}
