<template>
  <div class="app-container">
    <el-form :inline="true" :model="formQuery" class="demo-form-inline">
        <el-form-item label="类目名称">
            <el-input v-model="formQuery.categoryName" placeholder="类目名称"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="onSubmit">查询</el-button>
            <el-button type="primary" @click="categoryDialogVisible = true">新增</el-button>
        </el-form-item>
    </el-form>
    <el-table :data="userItems" v-loading="listLoading" element-loading-text="Loading" border fit highlight-current-row>
      <el-table-column align="center" label='ID' width="95">
        <template slot-scope="scope">
            {{scope.$index + 1}}
        </template>
      </el-table-column>
      <el-table-column label="类目名称" width="200">
        <template slot-scope="scope">
            {{scope.row.categoryName}}
        </template>
      </el-table-column>
      <el-table-column label="描述" align="nickName">
        <template slot-scope="scope">
            <span>{{scope.row.describe}}</span>
        </template>
      </el-table-column>
      <el-table-column label="状态" width="110" align="role">
        <template slot-scope="scope">
            {{scope.row.status}}
        </template>
      </el-table-column>
      <el-table-column label="操作" width="200" align="operator">
        <template slot-scope="scope">
          <el-button type="primary" >删除</el-button>
          <el-button type="primary" @click="categoryDialogVisible = true" >查看</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination background layout="prev, pager, next" :total="12"> </el-pagination>

    <el-dialog title="类目设置" :visible.sync="categoryDialogVisible" width="30%" :before-close="handleClose">
    <el-form ref="form" label-width="80px">
        <el-form-item label="类目名称">
          <el-input value="神州优出"></el-input>
        </el-form-item>
        <el-form-item label="状态">
          <el-radio-group>
            <el-radio label="启用"></el-radio>
            <el-radio label="禁用"></el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="地址">
          <el-input></el-input>
        </el-form-item>
        <el-form-item label="描述">
          <el-input type="textarea"></el-input>
        </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
        <el-button @click="categoryDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="categoryDialogVisible = false">确 定</el-button>
    </span>
    </el-dialog>
  </div>
</template>

<script>

export default {
  data() {
    return {
      listLoading: true,
      categoryDialogVisible: false,
      formQuery: {
        categoryName: ''
      },
      userItems: [{
        'categoryName': '优车社区',
        'describe': '描述描述描述',
        'status': '启用'
      },
      {
        'categoryName': '优车社区',
        'describe': '描述描述描述',
        'status': '启用'
      },
      {
        'categoryName': '优车社区',
        'describe': '描述描述描述',
        'status': '启用'
      },
      {
        'categoryName': '优车社区',
        'describe': '描述描述描述',
        'status': '启用'
      },
      {
        'categoryName': '优车社区',
        'describe': '描述描述描述',
        'status': '启用'
      },
      {
        'categoryName': '优车社区',
        'describe': '描述描述描述',
        'status': '启用'
      },
      {
        'categoryName': '优车社区',
        'describe': '描述描述描述',
        'status': '启用'
      },
      {
        'categoryName': '优车社区',
        'describe': '描述描述描述',
        'status': '启用'
      },
      {
        'categoryName': '优车社区',
        'describe': '描述描述描述',
        'status': '启用'
      },
      {
        'categoryName': '优车社区',
        'describe': '描述描述描述',
        'status': '启用'
      },
      {
        'categoryName': '优车社区',
        'describe': '描述描述描述',
        'status': '启用'
      },
      {
        'categoryName': '优车社区',
        'describe': '描述描述描述',
        'status': '启用'
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
