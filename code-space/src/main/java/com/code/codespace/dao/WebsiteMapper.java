package com.code.codespace.dao;

import com.code.codespace.pojo.po.Website;
import com.code.codespace.pojo.po.WebsiteType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WebsiteMapper {
    int insertSelective(Website record);

    Website selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Website record);

    /**
     * 查询数据库中存在的url
     * @param url
     * @return
     */
    int queryUrl(@Param("url") String url);

    /**
     * 查询所有网址类型
     * @return
     */
    List<WebsiteType> getAllWebType();
}