package com.code.codespace.service.impl;

import com.code.codespace.dao.CodeWebNewsMapper;
import com.code.codespace.pojo.po.CodeWebNews;
import com.code.codespace.service.ICodeWebNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: CodeWebNewsServiceImpl
 * @Description: 新闻
 * @Author hlfang4
 * @Date: 2022/08/08 10:08
 */
@Service
@Primary
public class CodeWebNewsServiceImpl implements ICodeWebNewsService {

    @Autowired
    CodeWebNewsMapper codeWebNewsMapper;

    /**
     * 保存新闻列表
     * @param newsList
     */
    @Override
    public void saveNewsList(List newsList) {
        codeWebNewsMapper.saveNewsList(newsList);
    }

    /**
     * 清空新闻表
     * @return
     */
    @Override
    public void deleteNewsTable() {
        codeWebNewsMapper.deleteNewsTable();
    }

    @Override
    public List<CodeWebNews> getNewsList() {
        return codeWebNewsMapper.getNewsList();
    }

}
