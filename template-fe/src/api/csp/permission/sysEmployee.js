/**
 * API
 *
 * @author junwei.xiong
 * @since 2018-10-08 18:10:13
 */
import {get, post} from '@/utils/request'

const addSysEmployee = body => post(`/api/sysemployee/save.do_`, body);
const updateSysEmployee = body => post('/api/sysemployee/update.do_', body);

export default {
  getSysEmployee: autoId => get(`/api/sysemployee/info/${autoId}.do_`),
  addSysEmployee,
  getSysEmployeeList: query => post(`/api/sysemployee/list.do_`, query),
  updateSysEmployee,
  deleteSysEmployee: autoId => get(`/api/sysemployee/delete/${autoId}.do_`),
  saveSysEmployee: (body, key = 'autoId') => {
    return body && body[key] ? updateSysEmployee(body) : addSysEmployee(body);
  },
  grandRole: query => post(`/api/sysemployee/grantrole.do_`, query),
  getEmployeeRole: autoId => get(`/api/sysemployee/getemployeerole/${autoId}.do_`),
  isPlatformManager: () => get(`/api/sysemployee/isPlatformManager.do_`)
}
