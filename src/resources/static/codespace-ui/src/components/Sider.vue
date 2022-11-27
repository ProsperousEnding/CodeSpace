
<script setup>
    import { defineComponent, h, ref } from "vue";
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
import { useRoute, useRouter } from 'vue-router'
let theme = ref(null);
function renderIcon(icon) {
  return () => h(NIcon, null, { default: () => h(icon) });
}
const menuOptions =ref( [
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
]);
</script>

<template>
  <!-- 侧边栏 -->

            <!--  show-trigger     :collapsed="collapsed" -->
            <!-- 侧边栏 -->
            <div>
            <n-menu
              :inverted="inverted"
              :collapsed-width="64"
              :options="menuOptions"
            />
        </div>
               
        
</template>
<style>

</style>