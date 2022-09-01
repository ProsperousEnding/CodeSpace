// 导入axios实例
import axios from '../axios/index'
let {get, post } = axios

// //发送验证码
// export const sendCaptcha = data => get("/captcha/sent",data)

// //验证验证码
// export const verifyCaptcha = data => post("/captcha/verify",data)

// //注册(修改密码)
// export const register = data => post("/register/cellphone",data)

//获取新闻
export const getNewsList = data => post("/space/news/getNewsList")