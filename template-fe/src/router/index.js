import Vue from 'vue'
import Router from 'vue-router'
/* Layout */
import Layout from '../views/layout/Layout'

// in development-env not use lazy-loading, because lazy-loading too many pages will cause webpack hot update too slow. so only in production use lazy-loading;
// detail: https://panjiachen.github.io/vue-element-admin-site/#/lazy-loading

Vue.use(Router)


/**
 * hidden: true                   if `hidden:true` will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu, whatever its child routes length
 *                                if not set alwaysShow, only more than one route under the children
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noredirect           if `redirect:noredirect` will no redirct in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    title: 'title'               the name show in submenu and breadcrumb (recommend set)
    icon: 'svg-name'             the icon show in the sidebar,
  }
 **/
export const constantRouterMap = [
  {path: '/login', component: () => import('@/views/login/index'), hidden: true},
  {path: '/404', component: () => import('@/views/404'), hidden: true},
  {
    path: '/person/showNotice/:id',
    name: 'showNotice',
    component: () => import('@/views/agNotice/showNotice'),
    meta: {title: '公告预览'},
    hidden: true
    // hidden: true
  },
  {
    path: '/',
    component: Layout,
    redirect: '/person/notices',
    hidden: true
  },
  // {
  //   path: '/csp',
  //   component: Layout,
  //   name: '客服管理系统',
  //   meta: {title: '客服管理系统'},
  //   children: [
  //     {
  //       path: 'historySession',
  //       name: 'historySession',
  //       component: () => import('@/views/csp/history/history_session'),
  //       meta: {title: '历史会话'}
  //     },
  //     {
  //       path: 'noticeList',
  //       name: 'noticeList',
  //       component: () => import('@/views/csp/notice/notice_list'),
  //       meta: {title: '公告信息'}
  //     }
  //   ]
  // },
  // {
  //   path: '/user',
  //   component: Layout,
  //   name: '会员管理系统',
  //   meta: {title: '会员管理系统'},
  //   children: [
  //     {
  //       path: 'userManager',
  //       name: 'userManager',
  //       component: () => import('@/views/user/manager/user_manager'),
  //       meta: {title: '会员管理'}
  //     },
  //     {
  //       path: 'userSuggest',
  //       name: 'userSuggest',
  //       component: () => import('@/views/user/suggest/user_suggest'),
  //       meta: {title: '会员举报'}
  //     },
  //     {
  //       path: 'categoryManager',
  //       name: 'categoryManager',
  //       component: () => import('@/views/user/category/category_manager'),
  //       meta: {title: '类目管理'}
  //     }
  //   ]
  // },
  // {
  //   path: '/admin',
  //   component: Layout,
  //   name: '管理员管理系统',
  //   meta: {title: '管理员管理系统'},
  //   children: [
  //     {
  //       path: 'adminManager',
  //       name: 'adminManager',
  //       component: () => import('@/views/admin/manager/admin_manager'),
  //       meta: {title: '管理员管理'}
  //     },
  //     {
  //       path: 'roleManager',
  //       name: 'roleManager',
  //       component: () => import('@/views/admin/role/role_manager'),
  //       meta: {title: '角色管理'}
  //     },
  //     {
  //       path: 'menuManager',
  //       name: 'menuManager',
  //       component: () => import('@/views/admin/menu/menu_manager'),
  //       meta: {title: '菜单管理'}
  //     }
  //   ]
  // },
  // {
  //   path: '/bbs',
  //   component: Layout,
  //   name: 'bbs',
  //   meta: {title: '论坛管理系统'},
  //   children: [
  //     {
  //       path: 'lableManager',
  //       name: 'lableManager',
  //       component: () => import('@/views/bbs/lable/lable_manager'),
  //       meta: {title: '标签管理'}
  //     },
  //     {
  //       path: 'bbsManager',
  //       name: 'bbsManager',
  //       component: () => import('@/views/bbs/manager/bbs_manager'),
  //       meta: {title: '帖子管理'}
  //     },
  //     {
  //       path: 'bbsSetting',
  //       name: 'bbsSetting',
  //       component: () => import('@/views/bbs/manager/bbs_setting'),
  //       meta: {title: '帖子设置'},
  //       hidden: true
  //     },
  //     {
  //       path: 'noticeManager',
  //       name: 'noticeManager',
  //       component: () => import('@/views/bbs/notice/notice_manager'),
  //       meta: {title: '公告管理'}
  //     },
  //     {
  //       path: 'ideaManager',
  //       name: 'ideaManager',
  //       component: () => import('@/views/bbs/idea/idea_manager'),
  //       meta: {title: '意见管理'}
  //     },
  //     {
  //       path: 'ideaSetting',
  //       name: 'ideaSetting',
  //       component: () => import('@/views/bbs/idea/idea_setting'),
  //       meta: {title: '意见设置'},
  //       hidden: true
  //     }
  //   ]
  // },
  {
    path: '/person',
    component: Layout,
    name: 'perosn',
    meta: {title: '个人管理'},
    children: [
      {
        path: 'links',
        name: 'links',
        component: () => import('@/views/personalSetting/links/index'),
        meta: {title: '常用链接'}
      },
      {
        path: 'document',
        name: 'document',
        component: () => import('@/views/personalSetting/documents/index'),
        meta: {title: '文件管理'}
      },
      {
        path: 'phrases',
        name: 'phrases',
        component: () => import('@/views/personalSetting/phrases'),
        meta: {title: '常用语'},
      },
      {
        path: 'notices',
        name: 'notices',
        component: () => import('@/views/agNotice/list'),
        meta: {title: '公告管理'}
      },
      {
        path: 'noticeshow',
        name: 'noticeshow',
        component: () => import('@/views/agNotice/listJustShow'),
        meta: {title: '公告查看'},
        hidden: true
      },
      {
        path: 'summaries',
        name: 'summaries',
        component: () => import('@/views/personalSetting/summaries'),
        meta: {title: '小结管理'}
      },
      {
        path: 'create',
        name: 'create',
        component: () => import('@/views/agNotice/create'),
        meta: {title: '公告编辑'},
        hidden: true
      },
      {
        path: 'create/:id',
        name: 'create2',
        component: () => import('@/views/agNotice/create'),
        meta: {title: '公告编辑'},
        hidden: true
      }
      // ,
      // {
      //   path: 'showNotice/:id',
      //   name: 'showNotice',
      //   component: () => import('@/views/agNotice/showNotice'),
      //   meta: {title: '公告预览'},
      //   hidden: true
      //   // hidden: true
      // }
    ]
  }
]

export const permissionMap = [{
  path: '/permission',
  component: Layout,
  name: 'permission',
  meta: {title: '权限管理'},
  children: [
    {
      path: 'sysMenuList',
      name: 'sysMenuList',
      component: () => import('@/views/csp/permission/sysMenu/tree'),
      meta: {title: '菜单管理'}
    }, {
      path: 'sysMenuAdd',
      name: 'sysMenuAdd',
      component: () => import('@/views/csp/permission/sysMenu/edit'),
      meta: {title: '菜单新增'},
      hidden: true
    }, {
      path: 'sysMenuEdit',
      name: 'sysMenuEdit',
      component: () => import('@/views/csp/permission/sysMenu/edit'),
      meta: {title: '菜单修改'},
      hidden: true
    },
    {
      path: 'sysRoleList',
      name: 'sysRoleList',
      component: () => import('@/views/csp/permission/sysRole/tree'),
      meta: {title: '角色管理'}
    },
    {
      path: 'sysRoleGroupAdd',
      name: 'sysRoleGroupAdd',
      component: () => import('@/views/csp/permission/sysRole/editGroup'),
      meta: {title: '角色组新增'},
      hidden: true
    },
    {
      path: 'sysRoleGroupEdit',
      name: 'sysRoleGroupEdit',
      component: () => import('@/views/csp/permission/sysRole/editGroup'),
      meta: {title: '角色组修改'},
      hidden: true
    },
    {
      path: 'sysRoleAdd',
      name: 'sysRoleAdd',
      component: () => import('@/views/csp/permission/sysRole/edit'),
      meta: {title: '角色新增'},
      hidden: true
    },
    {
      path: 'sysRoleEdit',
      name: 'sysRoleEdit',
      component: () => import('@/views/csp/permission/sysRole/edit'),
      meta: {title: '角色修改'},
      hidden: true
    },
    {
      path: 'grantMenu',
      name: 'grantMenu',
      component: () => import('@/views/csp/permission/sysRole/grantMenu'),
      meta: {title: '角色授权菜单'},
      hidden: true
    },
    {
      path: 'sysEmployeeList',
      name: 'sysEmployeeList',
      component: () => import('@/views/csp/permission/sysEmployee/list'),
      meta: {title: '员工管理'}
    },
    {
      path: 'sysEmployeeAdd',
      name: 'sysEmployeeAdd',
      component: () => import('@/views/csp/permission/sysEmployee/edit'),
      meta: {title: '员工新增'},
      hidden: true
    }, {
      path: 'sysEmployeeEdit',
      name: 'sysEmployeeEdit',
      component: () => import('@/views/csp/permission/sysEmployee/edit'),
      meta: {title: '员工修改'},
      hidden: true
    },
    {
      path: 'grantRole',
      name: 'grantRole',
      component: () => import('@/views/csp/permission/sysEmployee/grantRole'),
      meta: {title: '授权角色'},
      hidden: true
    }
  ]
},
  {
    path: '/property',
    component: Layout,
    name: 'property',
    meta: {title: '系统参数'},
    children: [
      {
        path: 'sysPropertyList',
        name: 'sysPropertyList',
        component: () => import('@/views/csp/sysProperty/list'),
        meta: {title: '系统参数管理'}
      }, {
        path: 'sysPropertyAdd',
        name: 'sysPropertyAdd',
        component: () => import('@/views/csp/sysProperty/edit'),
        meta: {title: '系统参数新增'},
        hidden: true
      }, {
        path: 'sysPropertyEdit',
        name: 'sysPropertyEdit',
        component: () => import('@/views/csp/sysProperty/edit'),
        meta: {title: '系统参数新增'},
        hidden: true
      }]
  }]


const router = new Router({
  // mode: 'history', //后端支持可开
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRouterMap
});

export default router;
