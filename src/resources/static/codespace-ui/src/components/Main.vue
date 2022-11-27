
<script setup>
    
import CodeHeader from "./CodeHeader.vue"
import CodeSider from "./CodeSider.vue"

import { defineComponent, h, ref } from "vue";
import { RouterLink,RouterView,useRoute, useRouter } from 'vue-router'
// 在组件中引入
import {
  NGlobalStyle,
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
  lightTheme,
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
  LogoWebComponent,
  ApertureOutline,
  ApertureSharp,
} from "@vicons/ionicons5";
// 侧边栏主题
let inverted = ref(false);

//侧边栏收缩工具
let collapsed=ref(false)

// 设置整体主题
let theme = ref(null);





</script>
<template>
    <n-config-provider :theme="theme">
    
    <n-space vertical size="large">
        <!-- 页面布局 -->
        <n-layout embedded>
            <!-- 头部 start -->
            <code-header></code-header>
            <!-- 头部end -->
            <!-- 侧边栏 -->
            <code-sider></code-sider>
            <!-- 正文 -->

        </n-layout>
     </n-space>
</n-config-provider>

</template>
<style>

</style>