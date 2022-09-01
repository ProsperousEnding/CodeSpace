import axios from './axios/index'
import { createApp } from 'vue'
import App from './App.vue'
import router from './router/index'
createApp(App).use(router).mount('#app')
createApp(App).config.globalProperties.$axios = axios;