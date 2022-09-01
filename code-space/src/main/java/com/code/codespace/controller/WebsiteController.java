package com.code.codespace.controller;

import com.code.codespace.constant.Result;
import com.code.codespace.pojo.po.WebsiteType;
import com.code.codespace.pojo.vo.WebsiteVo;
import com.code.codespace.service.IWebsiteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: WebsiteController
 * @Description: 网址操作Controller
 * @Author hlfang4
 * @Date: 2022/08/30 13:08
 */
@Api(value = "网址操作接口")
@RestController
@RequestMapping("/website")
public class WebsiteController {

    /**
     * 网址操作Service
     */
    @Autowired
    @Qualifier("websiteServiceImpl")
    private IWebsiteService websiteService;

    /**
     * 添加网址
     *
     * @return
     */
    @ApiOperation(value = "添加网址")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "url", value = "网址url", required = true),
            @ApiImplicitParam(name = "title", value = "网址标题", required = true),
            @ApiImplicitParam(name = "describe", value = "网址描述", required = true),
            @ApiImplicitParam(name = "cover", value = "网址封面图", required = true),
            @ApiImplicitParam(name = "type", value = "网址类型", required = true)
    })
    @PutMapping("/web")
    @Transactional
    public Result addWebsite(WebsiteVo websiteVo) {
        return websiteService.addWebsite(websiteVo);
    }


    @ApiOperation(value = "获取所有网站类型")
    @GetMapping("/getAllWebType")
    public Result getAllWebType() {
        List<WebsiteType> websiteTypeList = websiteService.getAllWebType();
        return Result.success(websiteTypeList);
    }


}