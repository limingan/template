<!--
 编辑页面
 @author junwei.xiong
 @since 2018-09-27 17:07:36
-->
<template>
  <div class="app-container">
    <el-row :gutter="24">
      <span style="margin-left: 30px;margin-bottom: 50px;font-size: 30px">给用户 {{email}} 授权</span>
    </el-row>
    <el-row>
      <el-input placeholder="角色名称过滤" v-model="filterText"></el-input>
      <el-tree class="filter-tree" show-checkbox :default-checked-keys="checkedNodes" node-key="autoId" :data="roleTree"
               :props="defaultProps"
               :check-strictly="true"
               default-expand-all
               @check="handleCheck"
               :filter-node-method="filterNode" :expand-on-click-node="false" ref="roleTree">
        <span class="custom-tree-node" slot-scope="{ node, data }">
          <span>{{ node.label }}</span>
        </span>
      </el-tree>
    </el-row>
    <el-row>
      <slot name="buttonsSlot">
        <el-button type="primary" @click="submitGrant">提交</el-button>
      </slot>
      <router-link :to="{ name: `sysEmployeeList` }">
        <el-button>返回</el-button>
      </router-link>
    </el-row>
  </div>
</template>

<script>
  import api from '@/api/csp/permission/sysEmployee';

  export default {
    watch: {
      filterText(val) {
        this.$refs.roleTree.filter(val)
      }
    },
    data() {
      return {
        employeeId: '',
        email: '',
        filterText: '',
        roleTree: null,
        checkedNodes: null,
        defaultProps: {
          children: 'children',
          label: 'roleName',
          id: "autoId"
        },
        rules: {
          menuName: [{required: true, message: '请输入角色名称', trigger: 'blur'}]
        }
      }
    },
    created() {
      let autoId = this.$route.query.autoId;
      this.loadUser(autoId);
      this.loadTree(autoId);
    },
    methods: {
      loadUser(autoId) {
        api.getSysEmployee(autoId).then(response => {
          this.email = response.re.email;
          this.employeeId = response.re.autoId;
        });
      },
      loadTree(autoId) {
        api.getEmployeeRole(autoId).then(response => {
          this.roleTree = response.re.list;
          this.checkedNodes = response.re.checkedList;
        })
      },
      filterNode(value, data) {
        if (!value) return true
        return data.roleName.indexOf(value) !== -1
      },
      submitGrant() {
        let checkNodes = this.$refs.roleTree.getCheckedNodes();
        let checkIds = [];
        let length = checkNodes.length;
        for (let i = 0; i < length; i++) {
          let node = checkNodes[i];
          if (node.type === 2) {
            checkIds.push(node.autoId)
          }
        }
        this.$confirm('确定授权吗?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
          center: true
        }).then(() => {
          let param = {
            "employeeId": this.employeeId,
            "roleIds": checkIds
          }
          api.grandRole(param).then(response => {
            this.$message({
              message: '授权成功!',
              type: 'warning'
            });
            this.loadTree(this.employeeId);
          })
        })
      },
      handleCheck(data, tree) {
        const checked = tree.checkedKeys.indexOf(data.autoId) !== -1;
        const type = data.type;
        const node = this.$refs.roleTree.getNode(data.autoId);
        if (checked) {
          if (type === 1) {
            this.handleGroupCheck(node);
          } else {
            this.handleRoleCheck(node);
          }
        } else {
          if (type === 1) {
            this.handleGroupUnCheck(node);
          } else {
            this.handleRoleUnCheck(node);
          }
        }
      },
      handleGroupCheck(node) {
        const strategy = node.data.strategy;
        const _this = this;
        if (strategy === 1) {
          if (node.childNodes !== undefined && node.childNodes !== null && node.childNodes.length > 0) {
            node.childNodes.forEach(function (child) {
              _this.$refs.roleTree.setChecked(child.data.autoId, true, false)
            })
          }
        } else {
          this.$message({
            message: `该分组下只能选择一个角色，请指定!`,
            type: 'error'
          });
          _this.$refs.roleTree.setChecked(node.data.autoId, false, false)
        }
      }
      , handleRoleCheck(node) {
        const _this = this;
        const parent = node.parent;
        if (parent !== undefined && parent !== null && parent.data.autoId > 0) {
          const strategy = parent.data.strategy;
          if (strategy === 1) {
            _this.$refs.roleTree.setChecked(parent.data.autoId, true, false)
          } else {
            if (parent.childNodes !== undefined && parent.childNodes !== null && parent.childNodes.length > 0) {
              parent.childNodes.forEach(function (child) {
                if (child.data.autoId !== node.data.autoId) {
                  _this.$refs.roleTree.setChecked(child.data.autoId, false, false)
                }
              })
            }
          }
        }
      }
      , handleGroupUnCheck(node) {
        const _this = this;
        if (node.childNodes !== undefined && node.childNodes !== null && node.childNodes.length > 0) {
          node.childNodes.forEach(function (child) {
            _this.$refs.roleTree.setChecked(child.data.autoId, false, false)
          })
        }
      }
      , handleRoleUnCheck(node) {
        const _this = this;
        const parent = node.parent;
        if (parent !== undefined && parent !== null && parent.data.autoId > 0) {
          let flag = _this.haveCheckChild(parent);
          if (!flag) {
            _this.$refs.roleTree.setChecked(parent.data.autoId, false, false);
          }
        }
      }
      , haveCheckChild(node) {
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
