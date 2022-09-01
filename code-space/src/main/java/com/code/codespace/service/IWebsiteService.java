package com.code.codespace.service;

import com.code.codespace.constant.Result;
import com.code.codespace.pojo.po.WebsiteType;
import com.code.codespace.pojo.vo.WebsiteVo;

import java.util.List;

/**
 * 网址操作Service
 */
public interface IWebsiteService {

    /**
     * 添加网站网址
     *
     * @param websiteVo
     */
    Result addWebsite(WebsiteVo websiteVo);


    /**
     * 获取所有网站类型
     *
     * @return
     */
    List<WebsiteType> getAllWebType();
}
