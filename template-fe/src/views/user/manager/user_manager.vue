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
      <el-table-column label="昵称" width="200" align="nickName">
        <template slot-scope="scope">
            <span>{{scope.row.nickName}}</span>
        </template>
      </el-table-column>
      <el-table-column label="角色" width="110" align="role">
        <template slot-scope="scope">
            {{scope.row.role}}
        </template>
      </el-table-column>
      <el-table-column label="操作" width="200" align="operator">
          <template slot-scope="scope">
            <el-button type="primary" @click="closeReviewDialogVisible = true" >禁言</el-button>
          </template>
      </el-table-column>
    </el-table>
    <el-pagination background layout="prev, pager, next" :total="12"> </el-pagination>

    <el-dialog title="禁言设置" :visible.sync="closeReviewDialogVisible" width="30%" :before-close="handleClose">
    <el-form ref="form" label-width="80px">
        <el-form-item label="用户名">
            <el-input value="会员1" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="禁言天数">
            <el-input></el-input>
        </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
        <el-button @click="closeReviewDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="closeReviewDialogVisible = false">确 定</el-button>
    </span>
    </el-dialog>
  </div>
</template>

<script>

export default {
  data() {
    return {
      listLoading: true,
      closeReviewDialogVisible: false,
      formQuery: {
        eamil: '',
        userName: ''
      },
      userItems: [{
        'email': 'xxxxx@ucar.com',
        'nickName': '昵称1',
        'role': '普通会员'
      },
      {
        'email': 'xxxxx2@ucar.com',
        'nickName': '昵称2',
        'role': '普通会员'
      },
      {
        'email': 'xxxxx3@ucar.com',
        'nickName': '昵称3',
        'role': '普通会员'
      },
      {
        'email': 'xxxxx4@ucar.com',
        'nickName': '昵称4',
        'role': '普通会员'
      },
      {
        'email': 'xxxxx5@ucar.com',
        'nickName': '昵称5',
        'role': '普通会员'
      },
      {
        'email': 'xxxxx6@ucar.com',
        'nickName': '昵称6',
        'role': '普通会员'
      },
      {
        'email': 'xxxxx7@ucar.com',
        'nickName': '昵称7',
        'role': '普通会员'
      },
      {
        'email': 'xxxxx8@ucar.com',
        'nickName': '昵称8',
        'role': '普通会员'
      },
      {
        'email': 'xxxxx9@ucar.com',
        'nickName': '昵称9',
        'role': '普通会员'
      },
      {
        'email': 'xxxxx10@ucar.com',
        'nickName': '昵称10',
        'role': '普通会员'
      },
      {
        'email': 'xxxxx11@ucar.com',
        'nickName': '昵称11',
        'role': '普通会员'
      },
      {
        'email': 'xxxxx12@ucar.com',
        'nickName': '昵称12',
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
