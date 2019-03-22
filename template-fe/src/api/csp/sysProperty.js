/**
 * 系统配置表API
 *
 * @author junwei.xiong
 * @since 2018-10-25 10:16:39
 */
import request, {post, get} from '@/utils/request'
const addSysProperty = body => post(`/api/sysproperty/save.do_`,body);
const updateSysProperty = body => post('/api/sysproperty/update.do_', body);

export default {
    getSysProperty: id => get(`/api/sysproperty/info/${id}.do_`),
    addSysProperty,
    getSysPropertyList:query => post(`/api/sysproperty/list.do_`,query),
    updateSysProperty,
    deleteSysProperty: id => get(`/api/sysproperty/delete/${id}.do_`),
    saveSysProperty: (body, key='autoId')  => {
        return body && body[key] ? updateSysProperty(body) : addSysProperty(body);
    }
}
