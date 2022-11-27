<script setup>
import { defineComponent, h, ref ,computed } from "vue";
import Page from '../pages/Page.vue'
import { RouterLink,RouterView } from 'vue-router'
import {
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
} from "@vicons/ionicons5";

 let list=ref([1,2,3,4])
 
</script>
<template>
<div style="width:75% ;margin-left: 12.5%; margin-top:2%" >
  <n-carousel
    effect="card"
    prev-slide-style="transform: translateX(-150%) translateZ(-800px);"
    next-slide-style="transform: translateX(50%) translateZ(-800px);"
    style="height: 200px"
    :show-dots="true"
    draggable
    trigger="hover"
    :effect="fade"
    autoplay

  >
    <n-carousel-item :style="{ width: '60%' }" >
      <img
        class="carousel-img"
        src="https://naive-ui.oss-cn-beijing.aliyuncs.com/carousel-img/carousel1.jpeg"
      >
    </n-carousel-item>
    <n-carousel-item :style="{ width: '60%' }">
      <img
        class="carousel-img"
        src="https://naive-ui.oss-cn-beijing.aliyuncs.com/carousel-img/carousel2.jpeg"
      >
    </n-carousel-item>
    <n-carousel-item :style="{ width: '60%' }">
      <img
        class="carousel-img"
        src="https://naive-ui.oss-cn-beijing.aliyuncs.com/carousel-img/carousel3.jpeg"
      >
    </n-carousel-item>
    <n-carousel-item :style="{ width: '60%' }">
      <img
        class="carousel-img"
        src="https://naive-ui.oss-cn-beijing.aliyuncs.com/carousel-img/carousel4.jpeg"
      >
    </n-carousel-item>
  </n-carousel>
  </div>
   <n-divider title-placement="left">
  
    <n-icon><logo-electron></logo-electron></n-icon>
  </n-divider>
  <div style="width:25% ;height:auto;margin-left: 5%;margin-top:50px ;float: left;">
    <n-card title="卡片" 
    hoverable

    >
    卡片内容
  </n-card>
  </div>
   <div style="width:25% ;height:500px;margin-bottom: 200px;margin-left: 5%;margin-top:50px;float:left" >
    <n-card title="卡片" 
    hoverable
    >
    卡片内容
  </n-card>
  </div>
     <div style="width:25% ;height:500px;margin-bottom: 200px;margin-left: 5%;margin-top:50px;float:left" >
    <n-card title="卡片" 
    hoverable
    >
    卡片内容
  </n-card>
  </div>
</template>
<style scoped>

.soft-shadow{
width:100%;
height:auto;
border-radius: 20px;
background: #ffffff;
box-shadow:  -20px -20px 60px #dbd8f29f,
             20px 20px 60px #ffffff;
}
.carousel-img {
  margin: 0 auto;
  width: 100%;
  height: 100%;
  object-fit: cover;
}

</style>