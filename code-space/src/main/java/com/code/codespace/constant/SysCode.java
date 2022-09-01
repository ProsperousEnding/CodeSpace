package com.code.codespace.constant;

import sun.net.www.content.image.png;

/**
 * @ClassName: SysCode
 * @Description: 常用code
 * @Author hlfang4
 * @Date: 2022/08/08 13:08
 */
public class SysCode {

    public interface NEWS {
        String NEWS_URL = "https://tophub.today/";
        int TIMEOUT = 50000;

        /**
         * 热榜标签
         */
        interface HOT_NEWS {
            //微博
            String WEI_BO = "1";
            //知乎
            String ZHI_HU = "2";
            //微信
            String WEI_XIN = "3";
            //百度
            String BAI_DU = "4";
            //36氪
            String KE_36 = "5";
            //少数派
            String SHAO_SHU_PAI = "6";
            //虎嗅
            String HU_XIU = "7";
            //IT之家
            String IT = "8";

            //微博id
            String WEI_BO_ID = "node-1";
            //知乎id
            String ZHI_HU_ID = "node-6";
            //微信id
            String WEI_XIN_ID = "node-5";
            //百度id
            String BAI_DU_ID = "node-2";
            //36氪id
            String KE_36_ID = "node-11";
            //少数派id
            String SHAO_SHU_PAI_ID = "node-137";
            //虎嗅id
            String HU_XIU_ID = "node-32";
            //IT之家id
            String IT_ID = "node-119";
        }

        interface NEWS_BASE {
            //class
            String ELEMENT_CLASS = "nano-content";
            //a标签
            String ELEMENT_TAG = "a";

            //href属性
            String ATTR_HREF = "href";

            //标签类名-t
            String CLASS_NAME_T = "t";

            //标签类名-e
            String CLASS_NAME_E = "e";
        }

    }

    public interface NUMS {

        //数字0
        String ZERO = "0";
        //数字1
        String ONE = "1";
        //数字2
        String TWO = "2";
        //数字3
        String THREE = "3";
        //数字4
        String FOUR = "4";
        //数字5
        String FIVE = "5";
        //数字6
        String SIX = "6";
        //数字7
        String SEVEN = "7";
        //数字8
        String EIGHT = "8";
        //数字9
        String NINE = "9";
        //数字10
        String TEN = "10";
    }
    public interface IMG_NAME{
        //默认网址封面
        String DEFAULT_COVER="defaultCover.png";
    }

    public interface WEB_TYPE {
        //编程类
        String CODE = "CODE";
        //工具类
        String UTILS = "UTILS";
        //导航类
        String NAV = "NAV";
        //应用类
        String APP = "APP";
        //影音类
        String AV = "AV";
        //书籍类
        String BOOK = "BOOK";
        //学习类
        String LEARN = "LEARN";
        //未分类
        String UNKNOW = "UNKNOW";
    }

}
