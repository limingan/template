<template>
  <div class="app-container">
    <el-form :inline="true" :model="formQuery" class="demo-form-inline">
        <el-form-item label="邮箱">
            <el-input v-model="formQuery.eamil" placeholder="邮箱"></el-input>
        </el-form-item>
        <el-form-item label="用户名">
            <el-input v-model="formQuery.userName" placeholder="用户名"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="onSubmit">查询</el-button>
            <el-button type="primary" @click="addAdminDialogVisible=true">新增</el-button>
        </el-form-item>
    </el-form>
    <el-table :data="userItems" v-loading="listLoading" element-loading-text="Loading" border fit highlight-current-row>
      <el-table-column align="center" label='ID' width="95">
        <template slot-scope="scope">
            {{scope.$index + 1}}
        </template>
      </el-table-column>
      <el-table-column label="邮箱">
        <template slot-scope="scope">
            {{scope.row.email}}
        </template>
      </el-table-column>
      <el-table-column label="角色" width="200" align="role">
        <template slot-scope="scope">
            <span>{{scope.row.role}}</span>
        </template>
      </el-table-column>
      <el-table-column label="状态" width="110" align="status">
        <template slot-scope="scope">
            {{scope.row.status}}
        </template>
      </el-table-column>
      <el-table-column label="操作" width="220" align="operator">
          <template slot-scope="scope">
            <el-button type="primary" @click="setRoleDialogVisible = true" >设置启用</el-button>
            <el-button type="primary" >停用</el-button>
          </template>
      </el-table-column>
    </el-table>
    <el-pagination background layout="prev, pager, next" :total="12"> </el-pagination>

    <el-dialog title="设置权限" :visible.sync="setRoleDialogVisible" width="30%" :before-close="handleClose">
      <el-form ref="form" label-width="80px">
          <el-form-item label="用户名">
              <el-input value="会员1" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="所有启用">
            <el-checkbox style="margin-left:0px" label="备选项1" border></el-checkbox>
            <el-checkbox style="margin-left:0px" label="备选项2" border></el-checkbox>
            <el-checkbox style="margin-left:0px" label="备选项3" border></el-checkbox>
            <el-checkbox style="margin-left:0px" label="备选项4" border></el-checkbox>
            <el-checkbox style="margin-left:0px" label="备选项5" border></el-checkbox>
            <el-checkbox style="margin-left:0px" label="备选项6" border></el-checkbox>
            <el-checkbox style="margin-left:0px" label="备选项7" border></el-checkbox>
            <el-checkbox style="margin-left:0px" label="备选项8" border></el-checkbox>
          </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
          <el-button @click="setRoleDialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="setRoleDialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>

    <el-dialog title="新增管理员" :visible.sync="addAdminDialogVisible" width="30%" :before-close="handleClose">
      <el-form ref="form" label-width="80px">
          <el-form-item label="邮箱">
              <el-input value="admin99@ucarinc.com">ucarinc.com</el-input>
          </el-form-item>
          <el-form-item label="所有启用">
            <el-checkbox style="margin-left:0px" label="备选项1" border></el-checkbox>
            <el-checkbox style="margin-left:0px" label="备选项2" border></el-checkbox>
            <el-checkbox style="margin-left:0px" label="备选项3" border></el-checkbox>
            <el-checkbox style="margin-left:0px" label="备选项4" border></el-checkbox>
            <el-checkbox style="margin-left:0px" label="备选项5" border></el-checkbox>
            <el-checkbox style="margin-left:0px" label="备选项6" border></el-checkbox>
            <el-checkbox style="margin-left:0px" label="备选项7" border></el-checkbox>
            <el-checkbox style="margin-left:0px" label="备选项8" border></el-checkbox>
          </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
          <el-button @click="addAdminDialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="addAdminDialogVisible = false">确 定</el-button>
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
      addAdminDialogVisible: false,
      formQuery: {
        eamil: '',
        userName: ''
      },
      userItems: [{
        'email': 'xxxxx@qq.com',
        'status': '启用',
        'role': '普通会员'
      },
      {
        'email': 'xxxxx2@qq.com',
        'status': '启用',
        'role': '普通会员'
      },
      {
        'email': 'xxxxx3@qq.com',
        'status': '启用',
        'role': '普通会员'
      },
      {
        'email': 'xxxxx4@qq.com',
        'status': '启用',
        'role': '普通会员'
      },
      {
        'email': 'xxxxx5@qq.com',
        'status': '启用',
        'role': '普通会员'
      },
      {
        'email': 'xxxxx6@qq.com',
        'status': '启用',
        'role': '普通会员'
      },
      {
        'email': 'xxxxx7@qq.com',
        'status': '启用',
        'role': '普通会员'
      },
      {
        'email': 'xxxxx8@qq.com',
        'status': '启用',
        'role': '普通会员'
      },
      {
        'email': 'xxxxx9@qq.com',
        'status': '启用',
        'role': '普通会员'
      },
      {
        'email': 'xxxxx10@qq.com',
        'status': '启用',
        'role': '普通会员'
      },
      {
        'email': 'xxxxx11@qq.com',
        'status': '启用',
        'role': '普通会员'
      },
      {
        'email': 'xxxxx12@qq.com',
        'status': '启用',
        'role': '普通会员'
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
