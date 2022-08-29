package com.code.codespace.service;


import com.code.codespace.pojo.po.CodeWebNews;

import java.util.List;

public interface ICodeWebNewsService {

    /**
     * 保存新闻列表
     */
    void saveNewsList(List newsList);

    /**
     * 清空新闻表
     */
    void deleteNewsTable();

    /**
     * 获取新闻list
     * @return
     */
    List<CodeWebNews> getNewsList();


}
