import router from './router'
import NProgress from 'nprogress' // Progress 进度条
import 'nprogress/nprogress.css' // Progress 进度条样式
import {getToken, setToken} from '@/utils/auth' // 验权

const whiteList = ['/login', '/favicon.ico'] // 不重定向白名单
router.beforeEach((to, from, next) => {
  NProgress.start()
  const ticket = getParamString('ticket')
  if (!getToken() && ticket) {
    setToken(ticket)
  }
  if (getToken()) {
    if (to.path === '/login') {
      next({path: '/'})
      NProgress.done() // if current page is dashboard will not trigger	afterEach hook, so manually handle it
    } else {
      next()
    }
  } else {
    // if (whiteList.indexOf(to.path) !== -1) {
    //   next()
    // } else {
    //   store.dispatch('GotoLogin', this.loginForm).then(() => {
    //     this.loading = false
    //   }).catch(() => {
    //     this.loading = false
    //   })
    // }
    next()
  }
})

router.afterEach(() => {
  NProgress.done() // 结束Progress
})

function getParamString(name) {
  var paramUrl = window.location.search.substr(1);
  var paramStrs = paramUrl.split('&');
  var params = {};
  for (var index = 0; index < paramStrs.length; index++) {
    params[paramStrs[index].split('=')[0]] = decodeURI(paramStrs[index].split('=')[1]);
  }
  return params[name];
}

if (getParamString("token")) {
  if (!getToken()) {
    setToken(getParamString("token"));
  }
}
