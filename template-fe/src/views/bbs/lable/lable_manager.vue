<template>
  <div class="app-container">
    <el-form :inline="true" :model="formQuery" class="demo-form-inline">
        <el-form-item label="标签名称">
            <el-input v-model="formQuery.lableName" placeholder="标签名称"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="onSubmit">查询</el-button>
            <el-button type="primary" @click="setLableDialogVisible=true">新增</el-button>
        </el-form-item>
    </el-form>
    <el-table :data="userItems" v-loading="listLoading" element-loading-text="Loading" border fit highlight-current-row>
      <el-table-column align="center" label='ID' width="95">
        <template slot-scope="scope">
            {{scope.$index + 1}}
        </template>
      </el-table-column>
      <el-table-column label="标签名称" width="200">
        <template slot-scope="scope">
            {{scope.row.lableName}}
        </template>
      </el-table-column>
      <el-table-column label="所属类目" width="200" align="categoryName">
        <template slot-scope="scope">
            <span>{{scope.row.categoryName}}</span>
        </template>
      </el-table-column>
      <el-table-column label="描述" align="describe">
        <template slot-scope="scope">
            {{scope.row.describe}}
        </template>
      </el-table-column>
      <el-table-column label="操作" width="200" align="operator">
          <template slot-scope="scope">
            <el-button type="primary" @click="setLableDialogVisible = true" >修改</el-button>
            <el-button type="primary" >停用</el-button>
          </template>
      </el-table-column>
    </el-table>
    <el-pagination background layout="prev, pager, next" :total="12"> </el-pagination>

    <el-dialog title="标签设置" :visible.sync="setLableDialogVisible" width="30%" :before-close="handleClose">
    <el-form ref="form" label-width="80px">
        <el-form-item label="用户名">
            <el-input value="标签1"></el-input>
        </el-form-item>
        <el-form-item label="所属类目">
          <el-select v-model="form.categoryId" placeholder="请选择类目">
            <el-option label="神州优出" value="ucar"></el-option>
            <el-option label="用户反馈" value="user"></el-option>
          </el-select>
        </el-form-item>
         <el-form-item label="描述">
            <el-input :rows="5" type="textarea"></el-input>
        </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
        <el-button @click="setLableDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="setLableDialogVisible = false">确 定</el-button>
    </span>
    </el-dialog>
  </div>
</template>

<script>

export default {
  data() {
    return {
      listLoading: true,
      setLableDialogVisible: false,
      value3: true,
      formQuery: {
        lableName: ''
      },
      form: {
        categoryId: ''
      },
      userItems: [{
        'lableName': '标签名',
        'categoryName': '类目1',
        'describe': '描述'
      },
      {
        'lableName': '标签名2',
        'categoryName': '类目2',
        'describe': '描述'
      },
      {
        'lableName': '标签名3',
        'categoryName': '类目3',
        'describe': '描述'
      },
      {
        'lableName': '标签名4',
        'categoryName': '类目4',
        'describe': '描述'
      },
      {
        'lableName': '标签名5',
        'categoryName': '类目5',
        'describe': '描述'
      },
      {
        'lableName': '标签名6',
        'categoryName': '类目6',
        'describe': '描述'
      },
      {
        'lableName': '标签名7',
        'categoryName': '类目7',
        'describe': '描述'
      },
      {
        'lableName': '标签名8',
        'categoryName': '类目8',
        'describe': '描述'
      },
      {
        'lableName': '标签名9',
        'categoryName': '类目9',
        'describe': '描述'
      },
      {
        'lableName': '标签名10',
        'categoryName': '类目10',
        'describe': '描述'
      },
      {
        'lableName': '标签名11',
        'categoryName': '类目11',
        'describe': '描述'
      },
      {
        'lableName': '标签名12',
        'categoryName': '类目12',
        'describe': '描述'
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
