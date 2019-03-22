/**
 * API
 *
 * @author junwei.xiong
 * @since 2018-09-27 17:07:14
 */
import request, {post, get} from '@/utils/request'
const addSysEmployeeRole = body => post(`/api/sysemployeerole/save.do_`,body);
const updateSysEmployeeRole = body => post('/api/sysemployeerole/update.do_', body);

export default {
    getSysEmployeeRole: autoId => get(`/api/sysemployeerole/info/${autoId}.do_`),
    addSysEmployeeRole,
    getSysEmployeeRoleList:query => post(`/api/sysemployeerole/list.do_`,query),
    updateSysEmployeeRole,
    deleteSysEmployeeRole: autoId => get(`/api/sysemployeerole/delete/${autoId}.do_`),
    saveSysEmployeeRole: (body, key='autoId')  => {
        return body && body[key] ? updateSysEmployeeRole(body) : addSysEmployeeRole(body);
    }
}
