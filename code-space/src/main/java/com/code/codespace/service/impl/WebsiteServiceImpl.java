package com.code.codespace.service.impl;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.code.codespace.constant.Result;
import com.code.codespace.constant.SysCode;
import com.code.codespace.dao.WebsiteMapper;
import com.code.codespace.dao.WebsiteTypeMapper;
import com.code.codespace.pojo.po.Website;
import com.code.codespace.pojo.po.WebsiteType;
import com.code.codespace.pojo.vo.WebsiteVo;
import com.code.codespace.service.IWebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

/**
 * @ClassName: WebsiteService
 * @Description: 网址操作Service
 * @Author hlfang4
 * @Date: 2022/08/30 13:08
 */
@Service("websiteServiceImpl")
public class WebsiteServiceImpl implements IWebsiteService {

    /**
     * 网址Mapper
     */
    @Autowired
    private WebsiteMapper websiteMapper;

    /**
     * 网址类型mapper
     */
    @Autowired
    private WebsiteTypeMapper websiteTypeMapper;

    /**
     * 添加网址
     */
    @Override
    public Result addWebsite(WebsiteVo websiteVo) {
        //确保传入数据非空
        if (ObjectUtils.isNotEmpty(websiteVo)) {
            //查询数据库中是否存在该网址,如果存在则返回给前端
            int urlNum = websiteMapper.queryUrl(websiteVo.getUrl());
            if (urlNum > 0) {
                return Result.fail("该网址已存在,请重新添加！");
            }
            Website website = new Website();
            website.setId(String.valueOf(UUID.randomUUID()));
            website.setUrl(websiteVo.getUrl());
            website.setTitle(websiteVo.getTitle());
            website.setClick(SysCode.NUMS.ZERO);
            website.setCreateTime(new Date());
            website.setUpdateTime(new Date());
            website.setDescribe(websiteVo.getDescribe());
            if (StringUtils.isNotBlank(websiteVo.getType())) {
                website.setType(websiteVo.getType());
            } else {
                //未传入网址类别自动分到未分类模块
                website.setType(SysCode.WEB_TYPE.UNKNOW);
            }
            if (StringUtils.isNotBlank(websiteVo.getCover())) {
                website.setCover(websiteVo.getCover());
            } else {
                //未传入网址封面自动分配网址封面
                website.setCover(SysCode.IMG_NAME.DEFAULT_COVER);
            }
            websiteMapper.insertSelective(website);
            return Result.success();
        } else {
            return Result.fail("添加网址出现问题,请重新添加！");
        }
    }

    /**
     * 获取排名前十的网站
     *
     * @return
     */
    @Override
    public List<Website> getTop10Website() {
        return websiteMapper.getTop10Website();
    }

    /**
     * 通过网址类型获取网址
     *
     * @param type 网址类型
     * @return
     */
    @Override
    public List<Website> getWebsiteByType(String type) {
        return websiteMapper.getWebsiteByType(type);
    }

    /**
     * 获取所有网址类型
     *
     * @return
     */
    @Override
    public List<WebsiteType> getAllWebType() {
        return websiteTypeMapper.getAllWebType();
    }
}
