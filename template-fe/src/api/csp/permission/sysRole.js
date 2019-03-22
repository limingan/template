/**
 * API
 *
 * @author junwei.xiong
 * @since 2018-09-27 15:31:32
 */
import {get, post} from '@/utils/request'

const addSysRole = body => post(`/api/sysrole/save.do_`, body);
const updateSysRole = body => post('/api/sysrole/update.do_', body);

export default {
  getRole: (autoId, parentId) => get(`/api/sysrole/info/${autoId}/${parentId}.do_`),
  getSysRole: autoId => get(`/api/sysrole/info/${autoId}.do_`),
  addSysRole,
  getSysRoleList: query => post(`/api/sysrole/list.do_`, query),
  updateSysRole,
  deleteSysRole: autoId => get(`/api/sysrole/delete/${autoId}.do_`),
  saveSysRole: (body, key = 'autoId') => {
    return body && body[key] ? updateSysRole(body) : addSysRole(body);
  },
  getRoleMenu: autoId => get(`/api/sysrole/getrolemenu/${autoId}.do_`),
  grandMenu: query => post(`/api/sysrole/grantmenu.do_`, query),
  getTree: () => get(`/api/sysrole/gettree.do_`)
}
