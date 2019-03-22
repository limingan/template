import request from '@/utils/request'

export function getMenuTree() {
  return request({
    url: '/menu/getMenuTree.do',
    method: 'post'
  })
}

export function deleteMenu() {
  return request({
    url: '/menu/delete.do',
    method: 'post'
  })
}
