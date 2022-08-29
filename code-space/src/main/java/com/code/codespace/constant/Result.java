package com.code.codespace.constant;

import lombok.Data;

/**
 * @ClassName: Result
 * @Description: 返回值
 * @Author hlfang4
 * @Date: 2022/08/08 15:08
 */

@Data
public  class Result<T> {

    private Integer code;

    private String message;

    private  T data;
    private Result(){
        this.code = 200;
        this.message = "ok";
        this.data = null;
    }
    private Result(ResultCode resultCode,T data){
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }

    /**
     * 暴露外面静态方法. 成功
     */
    public static <E> Result success(E data){
        return new Result<E>(ResultCode.SUCCESS,data);
    }

    /**
     * 失败
     */
    public static <E> Result fail(E data){
        return new Result<E>(ResultCode.FAIL,data);
    }

}
