package com.code.codespace.constant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @ClassName: Result
 * @Description: 返回值处理
 * @Author hlfang4
 * @Date: 2022/08/08 15:08
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "响应信息体")
@Data
public  class Result<T> {

    @Getter
    @Setter
    @ApiModelProperty(value = "返回标记：成功标记=0,失败1")
    private Integer code;

    @Getter
    @Setter
    @ApiModelProperty(value = "返回信息")
    private String message;

    @Getter
    @Setter
    @ApiModelProperty(value = "返回数据")
    private  T data;

    @Getter
    @Setter
    @ApiModelProperty(value = "返回状态")
    private boolean status;
    private Result(ResultCode resultCode,T data){
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }


    /**
     * 无数据成功返回
     *
     * @param
     * @return
     */
    public static  Result success(){
        return new Result(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),"",true);
    }
    /**
     * 带数据返回
     */
    public static <E> Result success(E data){
        return new Result<E>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),data,true);
    }

    /**
     * 失败
     */
    public static  Result fail(){
        return new Result(ResultCode.FAIL.getCode(),ResultCode.FAIL.getMessage(), " ",false);
    }
    /**
     * 失败
     */
    public static <E> Result fail(E data){
        return new Result<E>(ResultCode.FAIL.getCode(),ResultCode.FAIL.getMessage(), data,false);
    }


}
