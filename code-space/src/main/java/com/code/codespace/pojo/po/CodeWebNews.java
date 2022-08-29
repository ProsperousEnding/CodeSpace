package com.code.codespace.pojo.po;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: CodeWebNews
 * @Description: 新闻表
 * @Author hlfang4
 * @Date: 2022/08/08 10:08
 */
@Data
@ApiModel(value="com.code.codespace.pojo.po.CodeWebNews")
public class CodeWebNews implements Serializable {

    /**
     * 主键
     */
    private String newsId;

    /**
     * 新闻标题
     */
    private String newsTitle;

    /**
     * 新闻类别关联news_type表
     */
    private String newsTypeId;

    /**
     * 新闻url
     */
    private String newsUrl;

    /**
     * 点赞数
     */
    private String newsLikes;
}
