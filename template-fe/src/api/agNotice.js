/**
 * API
 *
 * @author junwei.xiong
 * @since 2018-09-26 10:03:33
 */
import request, {post, get} from '@/utils/request'
const addAgNotice = body => post(`/api/agnotice/save.do_`,body);
const updateAgNotice = body => post('/api/agnotice/update.do_', body);

export default {
    getAgNotice: autoId => get(`/api/agnotice/info/${autoId}.do_`),
    addAgNotice,
    getAgNoticeList:query => post(`/api/agnotice/list.do_`,query),
    updateAgNotice,
    deleteAgNotice: autoId => get(`/api/agnotice/delete/${autoId}.do_`),
    saveAgNotice: (body, key='autoId')  => {
        return body && body[key] ? updateAgNotice(body) : addAgNotice(body);
    }
}
