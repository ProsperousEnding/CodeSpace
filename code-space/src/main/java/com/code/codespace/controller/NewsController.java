package com.code.codespace.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.code.codespace.common.JSONUtil;
import com.code.codespace.constant.Result;
import com.code.codespace.constant.SysCode;
import com.code.codespace.dao.CodeWebNewsMapper;
import com.code.codespace.pojo.po.CodeWebNews;
import com.code.codespace.service.ICodeWebNewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName: NewsController
 * @Description: 新闻Controller
 * @Author hlfang4
 * @Date: 2022/08/08 10:08
 */
@Api(value = "获取新闻列表接口")
@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    ICodeWebNewsService codeWebNewsService;

    /**
     * 获取新闻list
     * @return
     */
    @ApiOperation(value = "获取新闻列表（不分页）")
    @RequestMapping("/getNewsList")
    public Result<List> getNewsList() {
        return Result.success(JSON.toJSON(codeWebNewsService.getNewsList()));
    }


    /**
     * 定时获取新闻并存储到数据库中
     *
     * @throws IOException
     */
    @ApiOperation(value = "定时获取新闻并存储到数据库")
    @Scheduled(cron = "0 0/1 8-18 * * ?")
    @RequestMapping("/doTask")
    @Transactional(rollbackFor = Exception.class)
    public void doTask() throws IOException {

        //获取网页url的Document并设置超时时间
        Document document = Jsoup.parse(new URL(SysCode.NEWS.NEWS_URL), SysCode.NEWS.TIMEOUT);
        //新闻list
        List<CodeWebNews> newsList = new ArrayList<>();
        {
            //先清空表
            codeWebNewsService.deleteNewsTable();
         addNewsList(document,newsList,SysCode.NEWS.HOT_NEWS.WEI_BO,SysCode.NEWS.HOT_NEWS.WEI_BO_ID);
         addNewsList(document,newsList,SysCode.NEWS.HOT_NEWS.ZHI_HU,SysCode.NEWS.HOT_NEWS.ZHI_HU_ID);
         addNewsList(document,newsList,SysCode.NEWS.HOT_NEWS.WEI_XIN,SysCode.NEWS.HOT_NEWS.WEI_XIN_ID);
         addNewsList(document,newsList,SysCode.NEWS.HOT_NEWS.BAI_DU,SysCode.NEWS.HOT_NEWS.BAI_DU_ID);
         addNewsList(document,newsList,SysCode.NEWS.HOT_NEWS.KE_36,SysCode.NEWS.HOT_NEWS.KE_36_ID);
         addNewsList(document,newsList,SysCode.NEWS.HOT_NEWS.SHAO_SHU_PAI,SysCode.NEWS.HOT_NEWS.SHAO_SHU_PAI_ID);
         addNewsList(document,newsList,SysCode.NEWS.HOT_NEWS.HU_XIU,SysCode.NEWS.HOT_NEWS.HU_XIU_ID);
         addNewsList(document,newsList,SysCode.NEWS.HOT_NEWS.IT,SysCode.NEWS.HOT_NEWS.IT_ID);
         codeWebNewsService.saveNewsList(newsList);

        }

  //{
        //    // 豆瓣电影Top250
        //    String url = "https://movie.douban.com/top250";
        //
        //    // 获取页面
        //    Document document = Jsoup.connect(url).get();
        //
        //    // 根据class获取元素集合
        //    Elements titles = document.getElementsByClass("title");
        //    int index = 1;
        //    for (Element title : titles) {
        //        String text = title.text();
        //        // 过滤掉电影的其他名称
        //        if (!text.contains("/")) {
        //            System.out.println("No." + index + " " + text);
        //            index++;
        //        }
        //    }
        //}
        //{
        //    //配置url
        //    String url="https://tophub.today/";
        //      Jsoup.parse(new URL(url), 10000);
        //    //获取页面
        //    Document document=Jsoup.connect(url).get();
        //    Elements names = document.getElementsByClass("cc-cd-cb-l nano-content").tagName();
        //    Elements links = names.select("a[href]");
        //    int index=1;
        //    for (Element link:links ){
        //        System.out.println(link.attr("abs:href"));
        //        index++;
        //    }
        //}
        //{
        //    String url="https://tophub.today/";
        //    Document document = Jsoup.parse(new URL(url), 10000);
        //    Elements content=document.getElementsByClass("nano-content");
        //    Elements urls = content.first().getElementsByTag("a");
        //    int index=0;
        //    for (Element urljson:urls
        //         ) {
        //        String hrefjson= urljson.attr("href");
        //        System.out.println(hrefjson);
        //        //获取输入流
        //  }
        //}
    }


    /**
     * 添加热榜到list
     * @param document
     * @param newsList
     * @param hotCoding
     * @param hotTag
     */
    private void addNewsList(Document document,List<CodeWebNews> newsList,String hotCoding,String hotTag) {
        Element contents = document.getElementById(hotTag);
        Elements div = contents.getElementsByClass(SysCode.NEWS.NEWS_BASE.ELEMENT_CLASS);
        Elements a = div.first().getElementsByTag(SysCode.NEWS.NEWS_BASE.ELEMENT_TAG);
        for (Element href : a
        ) {
        String hrefUrl = href.attr(SysCode.NEWS.NEWS_BASE.ATTR_HREF);
        String title = href.getElementsByClass(SysCode.NEWS.NEWS_BASE.CLASS_NAME_T).text();
        String likes = href.getElementsByClass(SysCode.NEWS.NEWS_BASE.CLASS_NAME_E).text();
        CodeWebNews codeWebNews = new CodeWebNews();
        codeWebNews.setNewsId(String.valueOf(UUID.randomUUID()));
        codeWebNews.setNewsTitle(title);
        codeWebNews.setNewsUrl(hrefUrl);
        codeWebNews.setNewsLikes(likes);
        codeWebNews.setNewsTypeId(hotCoding);
        newsList.add(codeWebNews);
        }
    }
}
