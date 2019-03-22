import axios from 'axios'
import { Message } from 'element-ui'
import store from '../store'
import { getToken } from '@/utils/auth'
import qs from 'qs'

// 创建axios实例
const service = axios.create({
  baseURL: process.env.BASE_API, // api的base_url
  timeout: 5000, // 请求超时时间
  withCredentials: true
})

// request拦截器
service.interceptors.request.use(config => {
  // if (store.getters.token) {
  //   config.headers['X-Token'] = getToken() // 让每个请求携带自定义token 请根据实际情况自行修改
  // }
  // if (config.method === 'post' || config.method === 'put') {
  //   if (config.data !== undefined && config.data !== null) {
  //     if (config.data.form !== undefined && config.data.form !== null) {
  //       config.data = qs.stringify({
  //         ...config.data.form
  //       })
  //     } else {
  //       config.data = qs.stringify({
  //         ...config.data
  //       })
  //     }
  //   }
  // } else if (config.method === 'get') {
  //   if (config.params !== undefined && config.params !== null) {
  //     if (config.params.formQuery !== undefined && config.params.formQuery !== null) {
  //       config.params = {
  //         ...config.params.formQuery
  //       }
  //     } else {
  //       config.params = {
  //         ...config.params.formQuery
  //       }
  //     }
  //   }
  // }
  return config
}, error => {
  // Do something with request error
  console.log(error) // for debug
  Promise.reject(error)
})

// respone拦截器
service.interceptors.response.use(
  response => {
    return response.data
  },
  error => {
    console.log('err' + error)// for debug
    Message({
      message: error.message,
      type: 'error',
      duration: 5 * 1000
    })
    return Promise.reject(error)
  }
)

export default service
