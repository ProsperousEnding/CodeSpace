<script setup>
import { defineComponent, h, ref, computed, getCurrentInstance } from "vue";
import Page from "../pages/Page.vue";
import { RouterLink, RouterView } from "vue-router";

import {
  NAlert ,
  NPopover,
  NGrid,
  NGridItem,
  NTag,
  NTooltip,
  NScrollbar,
  NEllipsis,
  NLi,
  NOl,
  NH6,
  NCard,
  NAvatar,
  NInput,
  NIcon,
  NDivider,
  NGradientText,
  NH1,
  NText,
  NConfigProvider,
  darkTheme,
  NImage,
  NButton,
  NSpace,
  NLayout,
  NLayoutContent,
  NLayoutHeader,
  NLayoutSider,
  NLayoutFooter,
  NMenu,
  NSwitch,
  NRadioGroup,
  NRadioButton,
  NCarousel,
  NCarouselItem,
} from "naive-ui";

import {
  Contract,
  FlashOutline,
  BookOutline,
  HomeOutline,
  CodeSlash,
  Earth,
  GameControllerOutline,
  GlobeOutline,
  HourglassOutline,
  LibraryOutline,
  PersonOutline,
  AppsOutline,
  LogoElectron,
  ApertureOutline,
  ApertureSharp,
  ArrowForwardCircleOutline,
  ArrowForward,
  NavigateOutline,
} from "@vicons/ionicons5";

import "hover.css";
// 获取新闻api
import { getNewsList } from "../apis/news.js";
//获取站长推荐网址
import {getTop10Website} from "../apis/website.js"

import infiniteSlideBar from "../utils/vue-infinite-slide-bar.vue";
let list = ref([
  {
    title: "微博热榜",
    src: "https://file.ipadown.com/tophub/assets/images/media/s.weibo.com.png_50x50.png",
  },
  {
    title: "知乎热榜",
    src: "https://file.ipadown.com/tophub/assets/images/media/zhihu.com.png_50x50.png",
  },
  {
    title: "百度热搜",
    src: "https://file.ipadown.com/tophub/assets/images/media/baidu.com.png_50x50.png",
  },
]);

const { proxy } = getCurrentInstance(); //来获取全局 globalProperties 中配置的信息
let weibo = ref([]);
let zhihu = ref([]);
let baidu = ref([]);
// 获取新闻列表
getNewsList().then((res) => {
  res.data.forEach((e) => {
    if (e.newsTypeId == "1") {
      weibo.value.push(e);
    }
    if (e.newsTypeId == "2") {
      zhihu.value.push(e);
    }
    if (e.newsTypeId == "4") {
      baidu.value.push(e);
    }
  });
  return weibo, zhihu, baidu;
});

let listurl = ref("www.baidu.com");
// 跳转页面
function jump(e) {
  window.location.href = e;
}
// 创建一个新页面
function redirectUrl(e) {
  if (e.indexOf("http"))
    e = e.substr(0, 7).toLowerCase() == "http://" ? e : "http://" + e;
  window.open(e, "_blank");
}

//获取点击前十的站长推荐网站
// 获取新闻列表
let Top10Website = ref([]);
getTop10Website().then((res) => {
  Top10Website.value=res.data
  console.log(Top10Website)
  return Top10Website;
});
</script>
<template>
  <div style="height: 1500px">
    <div style="width: 75%; margin-left: 12.5%; margin-top: 2%">
      <!-- 这是幻灯片 -->
      <n-carousel effect="card" prev-slide-style="transform: translateX(-150%) translateZ(-800px);"
        next-slide-style="transform: translateX(50%) translateZ(-800px);" style="height: 200px" :show-dots="true"
        draggable trigger="hover" autoplay>
        <n-carousel-item :style="{ width: '60%' }">
          <img class="carousel-img" src="https://naive-ui.oss-cn-beijing.aliyuncs.com/carousel-img/carousel1.jpeg" />
        </n-carousel-item>
        <n-carousel-item :style="{ width: '60%' }">
          <img class="carousel-img" src="https://naive-ui.oss-cn-beijing.aliyuncs.com/carousel-img/carousel2.jpeg" />
        </n-carousel-item>
        <n-carousel-item :style="{ width: '60%' }">
          <img class="carousel-img" src="https://naive-ui.oss-cn-beijing.aliyuncs.com/carousel-img/carousel3.jpeg" />
        </n-carousel-item>
        <n-carousel-item :style="{ width: '60%' }">
          <img class="carousel-img" src="https://naive-ui.oss-cn-beijing.aliyuncs.com/carousel-img/carousel4.jpeg" />
        </n-carousel-item>
      </n-carousel>
    </div>
    <div style="margin-top: 20px; margin-bottom: 20px">
      <infinite-slide-bar :barStyle="{ background: '#9584c3', padding: '5px 0' }">
        <span style="color: currentColor">聚集的祈愿将成为新生的闪耀之星，化作光芒闪耀的道路吧！同调召唤，飞翔吧，星尘龙！----------------</span>
        <span style="color: currentColor">驾驭连系未知世界的疾风吧!Link 4『访问码语者』!--------------</span>
        <span style="color: currentColor">我的战斗从这里开始！寄托希望的白色羽翼！出现吧No.39！光之使者，希望皇
          霍普！ --------------
        </span>
      </infinite-slide-bar>
    </div>
    <!-- 这是分割线
    <n-divider title-placement="left">
      <n-icon><logo-electron></logo-electron></n-icon>
    </n-divider> -->
    <!-- 新闻卡片start -->
    <div style="height: 300px; width: auto">
      <div v-for="(item, no) in list">
        <div style="
            width: 25%;
            height: auto;
            margin-left: 6.5%;
            margin-top: 5px;
            float: left;
          ">
          <n-card :title="item.title" hoverable :segmented="{
            content: true,
            footer: 'soft', 
          }">
            <!-- 卡片头右侧 -->
            <template #header-extra>
              <!-- <n-icon><arrow-forward-circle-outline /></n-icon> -->
              <n-tooltip :show-arrow="false" trigger="hover" style="background-color: currentColor">
                <template #trigger>
                  <n-button text style="font-size: 24px" @click="getNews">
                    <n-icon class="hvr-grow">
                      <navigate-outline />
                    </n-icon>
                  </n-button>
                </template>
                <label style="filter: invert(50%)">点击了解更多</label>
              </n-tooltip>
            </template>
            <!-- 滚动条 -->
            <n-scrollbar style="max-height: 250px; margin-bottom: 5px">
              <n-li v-if="item.title == list[0].title" align-text v-for="(el, index) in weibo"
                style="padding-bottom: 15px">
                <!-- 文本省略 -->
                <n-ellipsis style="max-width: 65%">
                  <a  class="hvr-backward"  @click="jump(el.newsUrl)" style="text-decoration: none; color: currentColor">
                    {{ index + 1 }} {{ el.newsTitle }}
                  </a>
                  <template #tooltip :delay="500">
                    <div style="text-align: center">
                      <span> {{ el.newsTitle }}</span>
                    </div>
                  </template>
                </n-ellipsis>
                <span>{{ el.newsLikes }}</span>
              </n-li>
              <n-li v-if="item.title == list[1].title" align-text v-for="(el, index) in zhihu"
                style="padding-bottom: 15px">
                <!-- 文本省略 -->
                <n-ellipsis style="max-width: 65%">
                  <a class="hvr-backward" @click="jump(el.newsUrl)" style="text-decoration: none; color: currentColor ">
                    {{ index + 1 }} {{ el.newsTitle }}
                  </a>
                  <template #tooltip :delay="500">
                    <div style="text-align: center">
                      <span> {{ el.newsTitle }}</span>
                    </div>
                  </template>
                </n-ellipsis>
                <span>{{ el.newsLikes }}</span>
              </n-li>
              <n-li v-if="item.title == list[2].title" align-text v-for="(el, index) in baidu"
                style="padding-bottom: 15px">
                <!-- 文本省略 -->
                <n-ellipsis style="max-width: 65%">
                  <a  class="hvr-backward"  @click="jump(el.newsUrl)" style="text-decoration: none; color: currentColor">
                    {{ index + 1 }} {{ el.newsTitle }}
                  </a>
                  <template #tooltip :delay="500">
                    <div style="text-align: center">
                      <span> {{ el.newsTitle }}</span>
                    </div>
                  </template>
                </n-ellipsis>
                <span>{{ el.newsLikes }}</span>
              </n-li>
            </n-scrollbar>
          </n-card>
        </div>
      </div>
    </div>
    <n-divider title-placement="left" style="margin-top: 10px">
      <n-icon>
        <logo-electron></logo-electron>
      </n-icon>
    </n-divider>
    
 
     
<!-- 第三部 -->
<n-alert style="width:96%;margin-left: 2%;">
<!-- 站长推荐标题 -->
<h2 style="display:flex;"><n-icon size="30" color="filter: invert(50%)" :component=" Contract"   style="display:inline"/><strong  style="display:inline">站长推荐</strong></h2>
  <!-- 最新推荐网址 -->
    <div>   
      <n-space size="large" style="width: 100%;"  >
<div  v-for="(el, index) in Top10Website" padding="10px">
        <div style="margin-left: 10% ; padding-bottom:10px;" 
                       class="hvr-bob hvr-shrink ">
          <a @click="redirectUrl(el.url)">
            <n-card hoverable style="width: 200px">
              <div >
                <img :src="el.cover" class="hvr-backward" style="
                    height: 30px;
                    width: 30px;
                    display: inline-block;
                    vertical-align: middle;
                    border-radius: 20%;
                  " />
                <n-popover trigger="hover" :keep-alive-on-hover="false">
                  <template #trigger>
                    <div style="
                        display: inline-block;
                        margin-left: 10px;
                        max-width: 100px;
                        overflow: hidden;
                        text-overflow: ellipsis;
                        white-space: nowrap;
                      ">
                      <strong class="hvr-skew-forward">{{el.title}}</strong>
                    </div>
                  </template>
                  <span>{{el.title}} </span>
                </n-popover>
              </div>
              <n-popover :overlap="overlap" placement="bottom" trigger="hover" :keep-alive-on-hover="false" >
                <template #trigger>
                  <div style="
                      overflow: hidden;
                      text-overflow: ellipsis;
                      white-space: nowrap;
                      /* color:#145ccd */
                      color: #a2a2a2;
                    ">
                    {{el.describe}}
                  </div>
                </template>
                <span><div style="width:300px;height:100%; word-wrap: break-word">{{el.describe}}</div></span>
              </n-popover>
            </n-card>
          </a>
        </div>
      </div>

 
        
      </n-space>
    </div>
</n-alert>



  </div>
</template>
<style >
/* 悬浮动画css */
@import "hover.css";

.carousel-img {
  margin: 0 auto;
  width: 100%;
  height: 100%;
  object-fit: cover;
}
</style>