package com.code.codespace.pojo.po;

import java.io.Serializable;
import lombok.Data;

/**
 * website_type
 * @author 
 */
@Data
public class WebsiteType implements Serializable {
    /**
     * 网站类型主键
     */
    private String id;

    /**
     * 网站类型编码code
     */
    private String code;

    /**
     * 网站类型名称
     */
    private String name;

    private static final long serialVersionUID = 1L;
}