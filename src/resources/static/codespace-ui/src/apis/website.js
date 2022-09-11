// 导入axios实例
import axios from '../axios/index'
let {get, post } = axios

//获取站长推荐网站
export const getTop10Website = data => get("/space/website/getTop10Website")