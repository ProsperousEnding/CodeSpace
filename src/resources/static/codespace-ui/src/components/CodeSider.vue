
<script setup>

import { defineComponent, h, ref } from "vue";
import Page from '../pages/Page.vue'
import { RouterLink,RouterView } from 'vue-router'
import {
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
// 侧边栏图标使用
function renderIcon(icon) {
  return () => h(NIcon, null, { default: () => h(icon) });
}
// 侧边栏菜单路由
const menuOptions = [
  {
     label: () =>
      h(
        RouterLink,
        {
          to: {
            name: 'Book',
          }
        },
        { default: () => '书山有路' }
      ),
    key: "hear-the-wind-sing",
    icon: renderIcon(BookOutline),
  },
  {
    label: "代码有道",
    key: "pinball-1973",
    icon: renderIcon(CodeSlash),
    children: [
      {
        label: "Java",
        key: "Java",
      },
       {
        label: "Vue",
        key: "Vue",
      },
    ],
  },
  {
    label: "寻羊冒险记",
    key: "a-wild-sheep-chase",
  },
  {
    label: "舞，舞，舞",
    key: "dance-dance-dance",
    children: [
      {
        type: "group",
        label: "人物",
        key: "people",
      },
      {
        label: "饮品",
        key: "beverage",

        children: [
          {
            label: "威士忌",
            key: "whisky",
          },
        ],
      },

      {
        label: "过去增多，未来减少",
        key: "the-past-increases-the-future-recedes",
      },
    ],
  },
];
</script>

<template>
       <!-- 展示 show-trigger     :collapsed="collapsed" -->
        <n-layout-sider
            bordered
            collapse-mode="width"
            :collapsed-width="64"
            :width="250"
            :native-scrollbar="false"
            :inverted="inverted"
            style=" height:auto"
            show-trigger
            :collapsed="collapsed"
            
          >
         
            <!-- 侧边栏 -->
            <n-menu
              :inverted="inverted"
              :collapsed-width="64"
              :options="menuOptions"
              
            />      
        </n-layout-sider>

</template>

<style>

</style>