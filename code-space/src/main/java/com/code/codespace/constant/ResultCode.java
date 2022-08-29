package com.code.codespace.constant;

import lombok.Getter;

/**
 * @ClassName: ResultCode
 * @Description: 返回类型
 * @Author hlfang4
 * @Date: 2022/08/08 15:08
 */
@Getter
public enum ResultCode {
    /** 成功*/
    SUCCESS(200,"成功"),
    FAIL(1000,"失败"),
    /** 错误参数*/
    PARAM_IS_INVALID(1001,"参数无效"),
    PARAM_IS_BLANK(1002,"参为空"),
    PARAM_TYPE_ERROR(1003,"参数类型错误"),
    PARAM_NOT_COMPLETE(1004,"参数缺失"),
    /** 用户错误*/
    USER_NOT_LOGIN_IN(2001,"用户未登录"),
    USER_LOGIN_ERROR(2002,"账号不存在或者密码错误"),
    USER_ACCOUNT_FORBIDDEN(2003,"账户被禁用"),
    USER_NOT_EXISTS(2004,"用户不存在"),
    USER_HAS_EXISTED(2005,"用户已存在");

    /** 错误代码*/
    private Integer code;
    /** 提示信息*/
    private String message;

    private ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
