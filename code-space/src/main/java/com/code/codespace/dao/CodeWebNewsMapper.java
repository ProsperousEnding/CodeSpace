package com.code.codespace.dao;

import com.code.codespace.pojo.po.CodeWebNews;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName: CodeWebNewsMapper
 * @Description: 新闻mapper
 * @Author hlfang4
 * @Date: 2022/08/08 10:08
 */
@Mapper
@Repository
public interface CodeWebNewsMapper {

    /**
     * 保存新闻列表
     */
    void saveNewsList(List newsList);

    /**
     * 清空新闻表
     */
    void deleteNewsTable();

    /**
     * 获取新闻列表
     * @return
     */
    List<CodeWebNews> getNewsList();
}
