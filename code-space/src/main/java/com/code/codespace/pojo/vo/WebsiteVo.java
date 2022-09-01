package com.code.codespace.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: WebsiteVo
 * @Description: 网址Vo
 * @Author hlfang4
 * @Date: 2022/08/30 15:08
 */
@ApiModel(value="com.code.codespace.pojo.vo.WebsiteVo")
@Data
public class WebsiteVo {

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
     * 网址封面
     */
    @ApiModelProperty(value="网址封面")
    private String cover;

    /**
     * 网址类型
     */
    @ApiModelProperty(value="网址类型")
    private String type;
}
