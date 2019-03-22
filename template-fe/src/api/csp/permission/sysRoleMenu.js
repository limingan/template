/**
 * API
 *
 * @author junwei.xiong
 * @since 2018-09-27 17:08:11
 */
import request, {post, get} from '@/utils/request'
const addSysRoleMenu = body => post(`/api/sysrolemenu/save.do_`,body);
const updateSysRoleMenu = body => post('/api/sysrolemenu/update.do_', body);

export default {
    getSysRoleMenu: autoId => get(`/api/sysrolemenu/info/${autoId}.do_`),
    addSysRoleMenu,
    getSysRoleMenuList:query => post(`/api/sysrolemenu/list.do_`,query),
    updateSysRoleMenu,
    deleteSysRoleMenu: autoId => get(`/api/sysrolemenu/delete/${autoId}.do_`),
    saveSysRoleMenu: (body, key='autoId')  => {
        return body && body[key] ? updateSysRoleMenu(body) : addSysRoleMenu(body);
    }
}
