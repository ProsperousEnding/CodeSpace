import { createRouter, createWebHashHistory } from "vue-router"
import CodeHeader from '../components/CodeHeader.vue'
import Main from '../components/Main.vue'
const routes=[
    {
    path:'/',
    redirect: '/Main',
},
{
    path:'/Main',
    component:()=> import('../components/Main.vue'),
    children:[ {
      path: 'resouce',
      name:'Resource',
      component:  () => import('../pages/Resource.vue'), 
    },
  ]
},
{
    path:'/CodeHeader',
    component:()=> import('../components/CodeHeader.vue'),
},

    {
        path:'/Home',
        component:()=> import('../components/Home.vue'),
       children:[ {
            path: 'page',
            name:'Page',
            component:  () => import('../pages/Page.vue'), // 路由重定向 默认显示 login组件
          },
          {
            path: 'book',
            name: 'Book',
            component: () => import('../pages/Book.vue'),
          },
          {
            path: 'web',
            name: 'Web',
            component: () => import('../pages/Web.vue'),
          },
        
        ]
    },
    // {
    //     path:'/page',
    //     name:'Page',
    //     component:()=>import('../pages/Page.vue')
    // }
]
export const router=createRouter({
    history:createWebHashHistory(),
    routes,
})
export default router 