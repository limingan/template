import {getUnlimit} from '@/utils/request';
import projectConfig from '@/api/projectConfig'
import api from '@/api/csp/permission/sysEmployee';
import {permissionMap, constantRouterMap} from '@/router'

const app = {
  state: {
    routes: []
  },
  mutations: {
    SET_ROUTES: (state, routes) => {
      state.routes = routes;
    }
  },
  actions: {
    InitMenus: ({commit}) => {
      let routes = [];
      routes = constantRouterMap.concat(permissionMap)
      commit('SET_ROUTES', routes)
      // api.isPlatformManager().then(response => {
      //   let routes = [];
      //   if (response.re) {
      //     routes = constantRouterMap.concat(permissionMap)
      //   } else {
      //     routes = constantRouterMap
      //   }
      //   commit('SET_ROUTES', routes)
      // })
    }
  }
}

export default app
