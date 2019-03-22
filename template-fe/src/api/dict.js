/**
 * 人员表API
 *
 * @author ucar_gen
 * @since 2018-07-04 13:18:49
 */
import {getUnlimit} from '@/utils/request'
import projectConfig from '@/api/projectConfig'
export default {
    getDictDetailList:dictId => getUnlimit(`${projectConfig.rootPath}/sysdictionarydetail/list?limit=1000&page=1&parentId=${dictId}`),
    getDictDetailListByParentIds:parentIds => getUnlimit(`${projectConfig.rootPath}/sysdictionarydetail/getListByParentIds`, {parentIds : parentIds})
}
