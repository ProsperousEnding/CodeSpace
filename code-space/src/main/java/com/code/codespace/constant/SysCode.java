package com.code.codespace.constant;

/**
 * @ClassName: SysCode
 * @Description: TODO
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
            String IT="8";

            //微博id
            String WEI_BO_ID = "node-1";
            //知乎id
            String ZHI_HU_ID= "node-6";
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



        interface NEWS_BASE{
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

}
