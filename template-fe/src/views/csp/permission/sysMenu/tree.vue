<template>
  <div class="app-container">
    <el-row>
      <el-button type="primary" icon="el-icon-plus" @click="addNode(0)">添加一级菜单</el-button>
    </el-row>
    <el-row>
      <el-input placeholder="菜单名称过滤" v-model="filterText"></el-input>
      <el-tree class="filter-tree" :data="menuTree" :props="defaultProps" default-expand-all
               :filter-node-method="filterNode" :expand-on-click-node="false" ref="menuTree">
        <span class="custom-tree-node" slot-scope="{ node, data }">
          <span>{{ node.label }}</span>
          <span v-if="data.menuLevel <= maxMenuLevel">
            <el-button
              type="text"
              size="mini"
              @click="() => addChildMenu(data)">
              添加子菜单
            </el-button>
            <el-button
              type="text"
              size="mini"
              @click="() => addNode(data.parentId)">
              添加同级菜单
            </el-button>
            <el-button
              type="text"
              size="mini"
              @click="() => edit(data)">
              修改
            </el-button>
            <el-button
              type="text"
              size="mini"
              @click="() => remove(node, data)">删除
            </el-button>
          </span>
          <span v-if="data.menuLevel > maxMenuLevel">
            <el-button
              type="text"
              size="mini"
              @click="() => addNode(data.parentId)">
              添加同级菜单
            </el-button>
            <el-button
              type="text"
              size="mini"
              @click="() => edit(data)">
              修改
            </el-button>
            <el-button
              type="text"
              size="mini"
              @click="() => remove(node, data)">删除
            </el-button>
          </span>
        </span>
      </el-tree>
    </el-row>
  </div>
</template>

<script>
  import api from '@/api/csp/permission/sysMenu';
  import {dateFormat, dateTimeFormat} from '@/utils';

  export default {
    watch: {
      filterText(val) {
        this.$refs.menuTree.filter(val)
      }
    },
    data() {
      return {
        filterText: '',
        menuTree: [],
        maxMenuLevel: 3,
        defaultProps: {
          children: 'children',
          label: 'menuName'
        }
      }
    },
    created() {
      this.loadData()
    },
    methods: {
      loadData() {
        api.getTree().then(response => {
          if (null !== response.re && response.re !== undefined) {
            this.menuTree = response.re;
          } else {
            this.menuTree = [];
          }
        })
      },
      filterNode(value, data) {
        if (!value) return true
        return data.menuName.indexOf(value) !== -1
      },
      addChildMenu(data) {
        let parentId = data.autoId;
        if (data.menuLevel > this.maxMenuLevel) {
          this.$message({
            message: '菜单最多层级为4层!',
            type: 'warning'
          })
          return false
        }
        this.$router.push({path: '/permission/sysMenuAdd', query: {autoId: 0, parentId: parentId}})
      },
      addNode(parentId) {
        this.$router.push({path: '/permission/sysMenuAdd', query: {autoId: 0, parentId: parentId}})
      },
      edit(data) {
        let autoId = data.autoId;
        let parentId = data.parentId;
        this.$router.push({path: '/permission/sysMenuEdit', query: {autoId: autoId, parentId: parentId}})
        // let routeData = this.$router.resolve({path: '/permission/sysMenuEdit', query: {autoId: autoId, parentId: parentId}});
        // window.open(routeData.href, '_blank');
      },
      remove(node, data) {
        let children = node.data.children;
        if (null != children && children.length > 0) {
          this.$message({
            message: '菜单包含子节点，不能删除!',
            type: 'warning'
          })
          return false
        } else {
          this.$confirm('确定要删除吗?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning',
            center: true
          }).then(() => {
            api.deleteSysMenu(data.autoId).then(response => {
              this.$message({
                message: '删除成功!',
                type: 'warning'
              });
              this.loadData()
            })
          })
        }
      }
    }
  }
</script>
