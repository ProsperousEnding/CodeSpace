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

import { useRoute, useRouter } from 'vue-router'
// 在组件中引入
import vueLive2d from 'vue-live2d'

let dataA = ref("0");

// 侧边栏主题
let inverted = ref(false);

let theme = ref(null);
function renderIcon(icon) {
  return () => h(NIcon, null, { default: () => h(icon) });
}
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
//侧边栏收缩工具
let collapsed=ref(false)

let live2dStyle=ref('position: fixed; bottom: 0; right: 0;')


</script>
<template>
  <n-config-provider :theme="theme">
    <n-space vertical size="large">
      <n-layout>
        <n-layout-header
          :inverted="inverted"
          style="display: flex; align-items: center; height: 60px"
          bordered
        >
          <!-- 头部 -->

          <n-image
            width="50"
            src="../public/Logo.png"
            preview-disabled
            style="margin-left: 20px"
          />

          <n-gradient-text
            type="info"
            size="20px"
            :gradient="{
              from: 'rgb(30, 40, 180)',
              to: 'rgb(170, 180, 170)',
            }"
            style="padding: 30px"
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

          <!-- 菜单信息 -->
         <n-switch  v-model:value="collapsed">
          <template #unchecked-icon>
        <n-icon :component="  ApertureOutline" />
      </template> 
         <template #checked-icon>
        <n-icon :component="ApertureSharp" />
      </template> 
      
      </n-switch>
          <n-menu mode="horizontal" :inverted="inverted" :options="titles" />
          <!-- <n-button @click="inverted=!inverted; if(theme==null){theme=darkTheme}else{theme=null}" >点击切换主题</n-button> -->
          <!-- <n-switch v-model:value="collapsed"> </n-switch> -->

    <!-- v-model:value="value" -->
          <n-input
            :style="{ width: '25%' }"
        
            type="text"
            placeholder="请输入搜索内容"
            style="margin-left: 2%"
          >
          <!-- 搜索框 -->
            <template #prefix>
              <n-icon :component="FlashOutline" />
            </template>
          </n-input>
          <n-button type="info" ghost> 搜索 </n-button>
<!-- 右侧默认头像 -->
  <n-avatar
      round
      :size="40"
      src="https://07akioni.oss-cn-beijing.aliyuncs.com/07akioni.jpeg"
      style="position:absolute;right:2%"
    />


        </n-layout-header>
<!-- 侧边栏 -->
        <n-layout has-sider>
          <n-layout-sider
            bordered
            collapse-mode="width"
            :collapsed-width="64"
            :width="250"
            :native-scrollbar="false"
            :inverted="inverted"
            style=" height:auto"
            :collapsed="!collapsed"
          >
            <!--  show-trigger     :collapsed="collapsed" -->
            <!-- 侧边栏 -->
            <n-menu
              :inverted="inverted"
              :collapsed-width="64"
              :options="menuOptions"
            />
               
          </n-layout-sider>
          <!-- <n-layout style="max-height: 320px" /> -->
          <n-layout-content :inverted="inverted" bordered>
        
          <router-view /> 
        <vueLive2d :style="live2dStyle"
      :model="['Potion-Maker/Pio', 'default-costume']"
      
      :width="200"
      :height="200"
      :size="220"></vueLive2d>
          </n-layout-content>
        </n-layout>
        <n-layout-footer
          :inverted="inverted"
          bordered
          position="absolute"
          style="height: 90px; padding: 40px"
          >成府路</n-layout-footer
        >
      </n-layout>
    </n-space>
  </n-config-provider>
</template>

<style scoped>
</style>