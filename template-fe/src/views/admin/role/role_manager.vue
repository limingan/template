<template>
  <div class="app-container">
    <el-form :inline="true" :model="formQuery" class="demo-form-inline">
        <el-form-item label="角色名称">
            <el-input v-model="formQuery.roleName" placeholder="邮箱"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="onSubmit">查询</el-button>
            <el-button type="primary" @click="addRoleDialogVisible = true">新增</el-button>
        </el-form-item>
    </el-form>
    <el-table :data="userItems" v-loading="listLoading" element-loading-text="Loading" border fit highlight-current-row>
      <el-table-column align="center" label='ID' width="95">
        <template slot-scope="scope">
            {{scope.$index + 1}}
        </template>
      </el-table-column>
      <el-table-column label="角色名称" width="200" align="nickName">
        <template slot-scope="scope">
            <span>{{scope.row.roleName}}</span>
        </template>
      </el-table-column>
      <el-table-column label="描述" align="role">
        <template slot-scope="scope">
            {{scope.row.describe}}
        </template>
      </el-table-column>
      <el-table-column label="操作" width="400" align="operator">
          <template slot-scope="scope">
            <el-button type="primary" @click="addRoleDialogVisible = true">修改角色</el-button>
            <el-button type="primary" @click="setRoleDialogVisible = true" >设置权限</el-button>
            <el-button type="primary" >删除角色</el-button>
          </template>
      </el-table-column>
    </el-table>
    <el-pagination background layout="prev, pager, next" :total="12"> </el-pagination>

    <el-dialog title="设置权限" :visible.sync="setRoleDialogVisible" width="30%" :before-close="handleClose">
      <el-form ref="form" label-width="80px">
          <el-tree class="filter-tree" :data="menuTree" default-expand-all ref="tree2" show-checkbox> </el-tree>
      </el-form>
      <span slot="footer" class="dialog-footer">
          <el-button @click="setRoleDialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="setRoleDialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>

    <el-dialog title="新增权限" :visible.sync="addRoleDialogVisible" width="30%" :before-close="handleClose">
      <el-form ref="form" label-width="80px">
        <el-form-item label="角色名称">
            <el-input placeholder="角色名称"></el-input>
        </el-form-item>
        <el-form-item label="描述">
            <el-input :rows="5" type="textarea"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
          <el-button @click="addRoleDialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="addRoleDialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>

export default {
  data() {
    return {
      listLoading: true,
      setRoleDialogVisible: false,
      addRoleDialogVisible: false,
      formQuery: {
        roleName: ''
      },
      userItems: [{
        'roleName': '普通管理员',
        'describe': '普通管理员'
      },
      {
        'roleName': 'yyyyyyyy',
        'describe': 'yyyyyy'
      },
      {
        'roleName': 'xxxxx',
        'describe': 'xxxxxx'
      }],
      menuTree: [{
        id: 1,
        label: '会员管理系统',
        children: [{
          id: 2,
          label: '会员管理'
        },
        {
          id: 3,
          label: '会员反馈'
        },
        {
          id: 4,
          label: '类目管理'
        }]
      },
      {
        id: 5,
        label: '管理员管理系统',
        children: [{
          id: 6,
          label: '管理员管理'
        },
        {
          id: 7,
          label: '角色管理'
        },
        {
          id: 8,
          label: '菜单管理'
        }]
      },
      {
        id: 9,
        label: '论坛管理系统',
        children: [{
          id: 10,
          label: '标签管理'
        },
        {
          id: 11,
          label: '帖子管理'
        },
        {
          id: 12,
          label: '公告管理'
        }]
      }]
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.listLoading = true
      this.listLoading = false
    },
    onSubmit() {},
    handleClose(done) {
      this.$confirm('确认关闭？').then(_ => { done() }).catch(_ => {})
    }
  }
}
</script>
