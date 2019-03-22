import request, {post, get} from '@/utils/request'
const addMenu = body => post(`/api/menu/save.do_`,body);
const updateMenu = body => post('/api/menu/update.do_', body);

export default {
  getMenu: id => get(`/api/menu/info/${id}.do_`),
  addMenu,
  getMenuList:query => get(`/api/menu/list.do_`,query),
  updateMenu,
  deleteMenu: id => get(`/api/menu/delete/${id}.do_`),
  getTreeList: (query) => get(`/api/menu/treeList.do_`),
  getTreeListNameCh: (query) =>get(`/api/menu/treeListNameCh.do_`),
  saveMenu: (body, key='id')  => {
    return body && body[key] ? updateMenu(body) : addMenu(body);
  }
}
