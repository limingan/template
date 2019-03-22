<template>
  <div class="app-container">
    <el-form :inline="true" :model="formQuery" class="demo-form-inline">
        <el-form-item label="反馈状态">
            <el-select v-model="formQuery.status" placeholder="请选择状态">
                <el-option label="已处理" value="shanghai1"></el-option>
                <el-option label="未处理" value="beijing2"></el-option>
                <el-option label="不处理" value="beijing3"></el-option>
                <el-option label="处理中" value="beijing4"></el-option>
            </el-select>
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
      <el-table-column label="状态" width="110" align="status">
        <template slot-scope="scope">
            {{scope.row.status}}
        </template>
      </el-table-column>
      <el-table-column label="处理人" width="200" align="operatorUser">
        <template slot-scope="scope">
            <span>{{scope.row.operatorUser}}</span>
        </template>
      </el-table-column>
      <el-table-column label="内容缩写" align="content">
        <template slot-scope="scope">
            {{scope.row.content}}
        </template>
      </el-table-column>
      <el-table-column label="操作" width="200" align="operator">
          <template slot-scope="scope">
            <el-button type="primary" @click="processDialogVisible = true" >处理</el-button>
            <el-button type="primary" @click="processDialogVisible = true" >查看</el-button>
          </template>
      </el-table-column>
    </el-table>
    <el-pagination background layout="prev, pager, next" :total="12"> </el-pagination>

    <el-dialog title="用户反馈" :visible.sync="processDialogVisible" width="30%">
    <el-form ref="form" label-width="80px">
        <el-form-item label="处理状态">
            <el-select v-model="formQuery.status" placeholder="请选择状态">
                <el-option label="已处理" value="shanghai1"></el-option>
                <el-option label="未处理" value="beijing2"></el-option>
                <el-option label="不处理" value="beijing3"></el-option>
                <el-option label="处理中" value="beijing4"></el-option>
            </el-select>
        </el-form-item>
        <el-form-item label="处理人">
            <el-input :disabled="true" value="admin"></el-input>
        </el-form-item>
        <el-form-item label="原因">
            <el-input :disabled="true" value="选项1、选项2、选项3"></el-input>
        </el-form-item>
        <el-form-item label="活动形式">
            <el-input :rows="10" type="textarea" value="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum laoreet. Proin gravida dolor sit amet lacus accumsan et viverra justo commodo. Proin sodales pulvinar tempor. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nam fermentum, nulla luctus pharetra vulputate, felis tellus mollis orci, sed rhoncus sapien nunc eget." :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="处理描述">
            <el-input :rows="5" type="textarea"></el-input>
        </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
        <el-button @click="processDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="processDialogVisible = false">确 定</el-button>
    </span>
    </el-dialog>
  </div>
</template>

<script>

export default {
  data() {
    return {
      listLoading: true,
      processDialogVisible: false,
      formQuery: {
        status: ''
      },
      userItems: [{
        'status': '已处理',
        'operatorUser': 'xxx',
        'content': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. ...'
      },
      {
        'status': '已处理',
        'operatorUser': 'xxx',
        'content': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. ...'
      },
      {
        'status': '已处理',
        'operatorUser': 'xxx',
        'content': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. ...'
      },
      {
        'status': '已处理',
        'operatorUser': 'xxx',
        'content': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. ...'
      },
      {
        'status': '已处理',
        'operatorUser': 'xxx',
        'content': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. ...'
      },
      {
        'status': '已处理',
        'operatorUser': 'xxx',
        'content': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. ...'
      },
      {
        'status': '已处理',
        'operatorUser': 'xxx',
        'content': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. ...'
      },
      {
        'status': '已处理',
        'operatorUser': 'xxx',
        'content': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. ...'
      },
      {
        'status': '已处理',
        'operatorUser': 'xxx',
        'content': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. ...'
      },
      {
        'status': '已处理',
        'operatorUser': 'xxx',
        'content': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. ...'
      },
      {
        'status': '已处理',
        'operatorUser': 'xxx',
        'content': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. ...'
      },
      {
        'status': '已处理',
        'operatorUser': 'xxx',
        'content': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. ...'
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
    onSubmit() {}
  }
}
</script>
