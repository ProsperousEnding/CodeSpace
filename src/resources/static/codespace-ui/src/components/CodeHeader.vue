<script setup>
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

//图标
function renderIcon(icon) {
  return () => h(NIcon, null, { default: () => h(icon) });
}

//头部菜单路由
const titles = [
  {
    label: () =>
      h(
        RouterLink,
        {
          to: {
            name: 'Page',
          }
        },
        { default: () => '首页' }
      ),
    key: "Home",
    icon: renderIcon(HomeOutline),  
  },
  {
    label: "资源",
    key: "Resource",
    icon: renderIcon(LibraryOutline),
  },
  {
    label: "世界",
    key: "World",
    icon: renderIcon(Earth),
  },
  {
    label: "个人",
    key: "Personal",
    icon: renderIcon(PersonOutline),
  },
];

</script>





<template>

            <!-- 页头 -->
        <n-layout-header
          :inverted="inverted"
          style="display: flex; align-items: center; height: 60px"
          bordered
        >
        <!-- Logo -->
        <n-image
            width="50"
            src="../public/Logo.png"
            preview-disabled
            style="margin-left: 20px"
          />
          <!-- 渐变色网站名 start -->
          <n-gradient-text
            type="info"
            size="20px"
            :gradient="{
              from: 'rgb(30, 40, 180)',
              to: 'rgb(170, 180, 170)',
            }"
            style="padding-left: 18px;padding-right: 18px;"
          >
            <span
              @click="
                inverted = !inverted;
                if (theme == null) {
                  theme = darkTheme;
                } else {
                  theme = null;
                }
              "
            >
              Code Space
            </span>
          </n-gradient-text>
            <!-- 渐变色网站名 end -->
            <!--顶部菜单-->
            <!-- 侧边栏开关按钮start -->
         <!-- <n-switch  v-model:value="collapsed">
         <template #unchecked-icon>
        <n-icon :component="ApertureOutline" />
         </template> 
         <template #checked-icon>
        <n-icon :component="ApertureSharp" />
         </template> 
         </n-switch> -->
         <!-- 侧边栏开关按钮end-->
         <!-- 头部菜单 start -->
         <n-menu mode="horizontal" :inverted="inverted" :options="titles" />
         <!-- 头部菜单 end -->
         <!-- 搜索框 start -->
         <n-input
            :style="{ width: '25%' }"
            type="text"
            placeholder="请输入搜索内容"
            style="margin-left: 8%"
          >
          <!-- 搜索框 -->
            <template #prefix>
              <n-icon :component="FlashOutline" />
            </template>
          </n-input>
          <n-button type="info" ghost> 搜索 </n-button>
           <!-- 搜索框 end -->
        <!-- 右侧默认头像 -->
        <n-avatar
        round
        :size="40"
        src="../public/codeSpaceLogoWhite.jpg"
        style="position:absolute;right:5%"
        class="hvr-pulse"
    />
        </n-layout-header>
       

</template>


<style scoped>
    /* 悬浮动画css */
    @import "hover.css";
    
    .carousel-img {
      margin: 0 auto;
      width: 100%;
      height: 100%;
      object-fit: cover;
    }
    </style>