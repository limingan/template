<!--
 编辑页面
 @author junwei.xiong
 @since 2018-09-27 17:07:36
-->
<template>
  <div class="app-container">
    <el-row :gutter="24">
      <span style="margin-left: 30px;margin-bottom: 50px;font-size: 30px">给角色 {{roleName}} 授权</span>
    </el-row>
    <el-row>
      <el-input placeholder="菜单名称过滤" v-model="filterText"></el-input>
      <el-tree class="filter-tree" show-checkbox :default-checked-keys="checkedNodes" node-key="autoId" :data="menuTree"
               :props="defaultProps"
               :check-strictly="true"
               default-expand-all
               @check="handleCheck"
               :filter-node-method="filterNode" :expand-on-click-node="false" ref="menuTree">
        <span class="custom-tree-node" slot-scope="{ node, data }">
          <span>{{ node.label }}</span>
        </span>
      </el-tree>
    </el-row>
    <el-row>
      <slot name="buttonsSlot">
        <el-button type="primary" @click="submitGrant">提交</el-button>
      </slot>
      <router-link :to="{ name: `sysRoleList` }">
        <el-button>返回</el-button>
      </router-link>
    </el-row>
  </div>
</template>

<script>
  import api from '@/api/csp/permission/sysRole';

  export default {
    watch: {
      filterText(val) {
        this.$refs.menuTree.filter(val)
      }
    },
    data() {
      return {
        roleId: '',
        roleName: '',
        filterText: '',
        menuTree: [],
        checkedNodes: [],
        defaultProps: {
          children: 'children',
          label: 'menuName',
          id: "autoId"
        },
        rules: {
          menuName: [{required: true, message: '请输入菜单名称', trigger: 'blur'}]
        }
      }
    },
    created() {
      let autoId = this.$route.query.autoId;
      this.loadRole(autoId);
      this.loadTree(autoId);
    },
    methods: {
      loadRole(autoId) {
        api.getSysRole(autoId).then(response => {
          this.roleName = response.re.roleName;
          this.roleId = response.re.autoId;
        });
      },
      loadTree(autoId) {
        api.getRoleMenu(autoId).then(response => {
          this.menuTree = response.re.list;
          this.checkedNodes = response.re.checkedList;
        })
      },
      filterNode(value, data) {
        if (!value) return true
        return data.menuName.indexOf(value) !== -1
      },
      submitGrant() {
        let checkIds = this.$refs.menuTree.getCheckedKeys();
        this.$confirm('确定授权吗?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
          center: true
        }).then(() => {
          let param = {
            "roleId": this.roleId,
            "menuIds": checkIds
          }
          api.grandMenu(param).then(response => {
            this.$message({
              message: '授权成功!',
              type: 'warning'
            });
            this.loadTree(this.roleId);
          })
        })
      },
      handleCheck(data, tree) {
        const checked = tree.checkedKeys.indexOf(data.autoId) !== -1;
        const node = this.$refs.menuTree.getNode(data.autoId);
        if (checked) {
          this.traverseChildCheck(node);
          this.traverseParentCheck(node);
        } else {
          this.traverseChildUnCheck(node);
          this.traverseParentUnCheck(node);
        }
      },
      traverseChildCheck(node) {
        const _this = this;
        if (node.childNodes !== undefined && node.childNodes !== null && node.childNodes.length > 0) {
          node.childNodes.forEach(function (child) {
            _this.$refs.menuTree.setChecked(child.data.autoId, true, false)
            _this.traverseChildCheck(child);
          })
        }
      },
      traverseParentCheck(node) {
        const _this = this;
        const parent = node.parent;
        if (parent !== undefined && parent !== null && parent.data.autoId > 0) {
          _this.$refs.menuTree.setChecked(parent.data.autoId, true, false)
          _this.traverseParentCheck(parent);
        }
      },
      traverseChildUnCheck(node) {
        const _this = this;
        if (node.childNodes !== undefined && node.childNodes !== null && node.childNodes.length > 0) {
          node.childNodes.forEach(function (child) {
            _this.$refs.menuTree.setChecked(child.data.autoId, false, false)
            _this.traverseChildUnCheck(child);
          })
        }
      },
      traverseParentUnCheck(node) {
        const _this = this;
        const parent = node.parent;
        if (parent !== undefined && parent !== null && parent.data.autoId > 0) {
          let flag = _this.haveCheckChild(parent);
          if (!flag) {
            _this.$refs.menuTree.setChecked(parent.data.autoId, false, false);
            _this.traverseParentUnCheck(parent);
          }
        }
      },
      haveCheckChild(node) {
        let flag = false;
        if (node.childNodes !== undefined && node.childNodes !== null && node.childNodes.length > 0) {
          let children = node.childNodes;
          let size = children.length;
          for (let i = 0; i < size; i++) {
            let child = children[i];
            if (child.checked) {
              flag = true;
              break;
            }
          }
        }
        return flag;
      }
    }
  }
</script>
