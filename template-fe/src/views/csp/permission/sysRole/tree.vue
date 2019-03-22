<template>
  <div class="app-container">
    <el-row>
      <el-button type="primary" icon="el-icon-plus" @click="addNode(0)">添加角色组</el-button>
    </el-row>
    <el-row>
      <el-input placeholder="菜单名称过滤" v-model="filterText"></el-input>
      <el-tree class="filter-tree" :data="roleTree" :props="defaultProps" default-expand-all
               :filter-node-method="filterNode" :expand-on-click-node="false" ref="roleTree">
        <span class="custom-tree-node" slot-scope="{ node, data }">
          <span>{{ node.label }}</span>
          <span v-if="data.type <= maxLevel && data.autoId > 2">
            <el-button
              type="text"
              size="mini"
              @click="() => addChildMenu(data)">
              添加角色
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
          <span v-if="data.type > maxLevel">
            <el-button
              type="text"
              size="mini"
              @click="() => grantMenu(data)">
              授权
            </el-button>
             <span v-if="data.autoId > 20">
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
        </span>

      </el-tree>
    </el-row>
  </div>
</template>

<script>
  import api from '@/api/csp/permission/sysRole';
  import {dateFormat, dateTimeFormat} from '@/utils';

  export default {
    watch: {
      filterText(val) {
        this.$refs.roleTree.filter(val)
      }
    },
    data() {
      return {
        filterText: '',
        roleTree: null,
        maxLevel: 1,
        defaultProps: {
          children: 'children',
          label: 'roleName'
        }
      }
    },
    created() {
      this.loadData()
    },
    methods: {
      loadData() {
        api.getTree().then(response => {
          this.roleTree = response.re
        }).catch(err => {
        })
      },
      filterNode(value, data) {
        if (!value) return true
        return data.roleName.indexOf(value) !== -1
      },
      addChildMenu(data) {
        let parentId = data.autoId;
        this.$router.push({path: '/permission/sysRoleAdd', query: {autoId: 0, parentId: parentId}})
      },
      addNode() {
        this.$router.push({path: '/permission/sysRoleGroupAdd'})
      },
      edit(data) {
        let autoId = data.autoId;
        let type = data.type;
        let parentId = data.parentId;
        if (type === 1) {
          this.$router.push({path: '/permission/sysRoleGroupEdit', query: {autoId: autoId}})
        } else {
          this.$router.push({path: '/permission/sysRoleEdit', query: {autoId: autoId, parentId: parentId}})
        }
      },
      remove(node, data) {
        let children = node.data.children;
        if (null != children && children.length > 0) {
          this.$message({
            message: '分组包含角色，不能删除!',
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
            api.deleteSysRole(data.autoId).then(response => {
              this.$message({
                message: '删除成功!',
                type: 'warning'
              });
              this.loadData()
            }).catch(err => {
            })
          })
        }
      },
      grantMenu(data) {
        this.$router.push({path: '/permission/grantMenu', query: {autoId: data.autoId}})
      }
    }
  }
</script>
