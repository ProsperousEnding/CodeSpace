package com.code.codespace.pojo.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 网址存储表
 * @author ProsperousEnding-fhl
 * @create 2022-08-29-21:23
 */
@ApiModel(value="com.code.codespace.pojo.po.Website")
@Data
public class Website implements Serializable {

    private String id;

    /**
     * 网站url
     */
    @ApiModelProperty(value="网站url")
    private String url;

    /**
     * 网址标题
     */
    @ApiModelProperty(value="网址标题")
    private String title;

    /**
     * 网址描述
     */
    @ApiModelProperty(value="网址描述")
    private String describe;

    /**
     * 网址点击量
     */
    @ApiModelProperty(value="网址点击量")
    private String click;

    /**
     * 网址封面
     */
    @ApiModelProperty(value="网址封面")
    private String cover;

    /**
     * 网址类型
     */
    @ApiModelProperty(value="网址类型")
    private String type;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value="修改时间")
    private Date updateTime;

    /**
     * 删除标识（0正常，1已删除）
     */
    @ApiModelProperty(value="删除标识（0正常，1已删除）")
    private String delTag;

    private static final long serialVersionUID = 1L;
}