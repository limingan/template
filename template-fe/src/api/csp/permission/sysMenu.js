/**
 * API
 *
 * @author junwei.xiong
 * @since 2018-09-27 15:30:59
 */
import {get, post} from '@/utils/request'

const addSysMenu = body => post(`/api/sysmenu/save.do_`, body);
const updateSysMenu = body => post('/api/sysmenu/update.do_', body);

export default {
  getSysMenu: (autoId, parentId) => get(`/api/sysmenu/info/${autoId}/${parentId}.do_`),
  addSysMenu,
  getSysMenuList: query => post(`/api/sysmenu/list.do_`, query),
  updateSysMenu,
  deleteSysMenu: autoId => get(`/api/sysmenu/delete/${autoId}.do_`),
  saveSysMenu: (body, key = 'autoId') => {
    return body && body[key] ? updateSysMenu(body) : addSysMenu(body);
  },
  getTree: () => get(`/api/sysmenu/gettree.do_`)
}
