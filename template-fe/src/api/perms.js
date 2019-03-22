/**
 * 权限API
 *
 * @author ucar_gen
 * @since 2018-07-04 13:18:49
 */
import {get, post} from '@/utils/request'

//获取用户权限信息，并将权限信息抓换成set结构

export default {
  getPermsSet: (query) => get(`/api/system/permsSet.do_`),

  //判断用户权限
  hasPerms(perms) {
    // var permsSet = new Set(localStorage.getItem("userPermsSet").split(","))
    // return permsSet.has(perms)
    return true;
  }
}
