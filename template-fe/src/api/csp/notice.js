import request from '@/utils/request'

// 公告列表
export function getNoticeList(params) {
  return request({
    url: '/csp/notice_list',
    method: 'get',
    params
  })
}

// 公告详情
export function getNoticeDetail(formQuery) {
  return request({
    url: '/csp/notice_detail',
    method: 'post',
    data: {
      formQuery
    }
  })
}