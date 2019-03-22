import request from '@/utils/request'

// 历史会话列表查询
export function getHistorySessionList(params) {
  return request({
    url: '/csp/history_session',
    method: 'get',
    params
  })
}

// 历史会话语音听取
export function getHistorySessionRecord(formQuery) {
  return request({
    url: '/csp/history_session',
    method: 'post',
    data: {
      formQuery
    }
  })
}
