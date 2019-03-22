import request from '@/utils/request'

export function getMessageList(params) {
  return request({
    url: '/message/queryUcarAbsMessageList.do_',
    method: 'post',
    params
  })
}


export function messageUpdate(params) {
  return request({
    url: '/message/mesUpdate.do_',
    method: 'post',
    params
  })
}


export function getMessageCount(params) {
  return request({
    url: '/message/findUnreadMesCount.do_',
    method: 'get',
    params
  })
}
