package com.code.codespace.dao;

import com.code.codespace.pojo.po.WebsiteType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WebsiteTypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(WebsiteType record);

    int insertSelective(WebsiteType record);

    WebsiteType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WebsiteType record);

    int updateByPrimaryKey(WebsiteType record);

    /**
     * 获取所有网址类型
     *
     * @return
     */
    List<WebsiteType> getAllWebType();
}