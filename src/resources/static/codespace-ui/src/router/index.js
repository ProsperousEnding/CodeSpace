import { createRouter, createWebHashHistory } from "vue-router"

const routes=[{
    path:'/',
    redirect: '/Home/page',
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
          }]
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