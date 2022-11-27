
<script setup>
import { defineComponent, h, ref, computed, getCurrentInstance } from "vue";
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


</script>

<template>
  <!-- 第三部 -->
<n-alert style="width:96%;margin-left: 2%;">
<!-- 站长推荐标题 -->
<h2 style="display:flex;"><n-icon size="30" color="filter: invert(50%)" :component=" Contract"   style="display:inline"/><strong  style="display:inline">资源目录</strong></h2>
  <!-- 最新推荐网址 -->
    <div>   
      <n-space size="large" style="width: 100%;"  >
        <!-- v-for="(el, index) in Top10Website" -->
<div  padding="10px">
        <div style="margin-left: 10% ; padding-bottom:10px;" 
                       class="hvr-bob hvr-shrink ">
                       <!-- @click="redirectUrl(el.url)" -->
          <a>
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
                      <strong class="hvr-skew-forward">标题</strong>
                    </div>
                  </template>
                  <span>标题 </span>
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
                  描述
                  </div>
                </template>
                <span><div style="width:300px;height:100%; word-wrap: break-word">描述</div></span>
              </n-popover>
            </n-card>
          </a>
        </div>
      </div>

 
        
      </n-space>
    </div>
</n-alert>
</template>


<style>

</style>