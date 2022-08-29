package com.code.codespace.dao;

import com.code.codespace.pojo.po.Website;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface WebsiteMapper {
    int deleteByPrimaryKey(String id);

    int insert(Website record);

    int insertSelective(Website record);

    Website selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Website record);

    int updateByPrimaryKey(Website record);
}