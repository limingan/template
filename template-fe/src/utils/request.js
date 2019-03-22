import axios from 'axios'
import {Message, MessageBox} from 'element-ui'
import store from '../store'

// 创建axios实例
const service = axios.create({
  baseURL: process.env.BASE_API, // api的base_url
  timeout: 45000, // 请求超时时间
  withCredentials: true
})

// request拦截器
service.interceptors.request.use(config => {
  // if (store.getters.token) {
  //   config.headers['X-Token'] = getToken() // 让每个请求携带自定义token 请根据实际情况自行修改
  // }
  config.headers['Content-Type'] = 'application/json'
  config.headers['Request-Ajax'] = 'true'
  return config
}, error => {
  // Do something with request error
  console.log(error) // for debug
  Promise.reject(error)
})

// respone拦截器
service.interceptors.response.use(
  response => {
    const res = response.data
    if (res.status === 401) {
      store.dispatch('GotoLogin', this.loginForm).then(() => {
        this.loading = false
      }).catch(() => {
        this.loading = false
      })
    }
    if (!res.success) {
      Message({
        message: res.msg,
        type: 'error',
        duration: 5 * 1000
      })
      return Promise.reject('error')
    } else {
      return response.data
    }
  },
  error => {
    console.log('err' + error)// for debug
    Message({
      message: "系统繁忙，请稍后再试！",
      type: 'success',
      duration: 5 * 1000
    })
  }
);

function deleteEmptyProperty(object) {
  for (var i in object) {
    var value = object[i];
    if (typeof value === 'object') {
      if (Array.isArray(value)) {
        if (value.length == 0) {
          delete object[i];
          continue;
        }
      }
      deleteEmptyProperty(value);
      if (value === '' || value === null || value === undefined) {
        delete object[i];
      }
    } else {
      if (value === '' || value === null || value === undefined) {
        delete object[i];
      } else {
      }
    }
  }
}

export const post = (url, params) => {
  let newParams = Object.assign({}, params);
  // deleteEmptyProperty(newParams);
  return service({
    url,
    method: 'post',
    data: JSON.stringify(newParams),
    headers: {
      'Content-Type': 'application/json'
    }
  });
}
export const get = (url, params) => {
  let newParams = Object.assign({}, params);
  // deleteEmptyProperty(newParams);
  return service({
    url,
    method: 'get',
    params: newParams
  });
}
export const getUnlimit = (url, params) => axios.create({
  baseURL: process.env.BASE_API, // api的base_url
  timeout: 15000, // 请求超时时间
  withCredentials: true
})({
  url,
  method: 'get',
  params
});
export default service
