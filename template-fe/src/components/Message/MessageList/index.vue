<template>
  <div>
    <el-row>
      <el-form :inline="true" :model="editForm">
        <el-button type="primary" icon="el-icon-edit" @click="messageUpdate">设为已读</el-button>
      </el-form>
    </el-row>
    <el-row>
      <el-input type="hidden"></el-input>
    </el-row>

    <el-row>
      <el-table :data="list" v-loading.body="listLoading"  element-loading-text="Loading" border fit highlight-current-row :row-class-name="tableRowClassName"
                @selection-change="handleSelectionChange">

        <el-table-column type="selection" width="55"></el-table-column>

        <el-table-column align="center" label='发件人' width="300">
          <template slot-scope="scope">
            {{scope.row.empId}}
          </template>
        </el-table-column>

        <el-table-column align="center" label="消息内容" >
          <template slot-scope="scope">
            {{scope.row.messageContent}}
          </template>statusFilter
        </el-table-column>

        <el-table-column class-name="status-col" label="消息状态" align="center" width="200">
          <template slot-scope="scope">
            <el-tag :type="scope.row.isRead | statusFilter">{{scope.row.isRead=='1'?'已读':'未读'}}</el-tag>
          </template>
        </el-table-column>

        <el-table-column align="center" label="发生时间" width="200">
          <template slot-scope="scope">
            {{scope.row.createTime |formateLongDate}}
          </template>
        </el-table-column>
      </el-table>
      <el-pagination
        background
        layout="prev, pager, next"
        :total="total"
        @current-change="handleCurrentChange"
        @select="handleCurrentSelect">
      </el-pagination>
    </el-row>
  </div>
</template>

<script>
import { getToken } from '@/utils/auth' // 验权
import { getMessageList,messageUpdate } from '@/api/message'
import { formatDate } from '@/utils/index'

import Navbar  from '@/views/layout/components/Navbar'

export default {
  data() {
    return {
      list: null,
      listLoading: true,
      pageForm: {
        pageSize: '10',
        pageNo: '1',
        token: getToken()
      },
      editForm: {
        mesIds:''
      },
      total: 0
    }
  },
  filters: {
    statusFilter(status) {
      const statusMap = {
        '0': 'success',
        '1': 'danger'
      }
      return statusMap[status]
    },

    formateLongDate(date){
      let date1 = new Date(date);
      return formatDate(date1, 'yyyy-MM-dd hh:mm:ss');
    }
  },
  created() {
    this.fetchMessage()
  },
  methods: {
    handleCurrentChange(val) {
      this.pageForm.pageNo = val;
      this.fetchMessage()
    },
    handleSelectionChange(val) {
      this.checkLintArray = val
    },
    handleCurrentSelect(selection, row) {
      console.log(selection)
    },
    tableRowClassName({row, rowIndex}) {
      if (row.isRead === 1) {
        return 'success-row';
      } else {
        return 'warning-row';
      }
    },
    fetchMessage() {
      this.listLoading = true;
      getMessageList(this.pageForm).then(response => {
        this.list = response.re.rows;
        this.total = response.re.total;
        this.listLoading = false;
      })
    },

    messageUpdate() {
      if( this.checkLintArray == null || this.checkLintArray.length <= 0 ){
        this.$message({ message: '请先选择要操作的消息行数据!',  type: 'warning' });
        return false;
      }
      this.editForm.mesIds = '';
      var $flag = true;
      this.checkLintArray.forEach(val=>{
          if(val.isRead == '1'){
            this.$message({ message: '请检查选中消息是否全部为未读!',  type: 'warning' });
            $flag = false;
            return false;
          }
          this.editForm.mesIds = this.editForm.mesIds + val.id + ',';
      });
      if($flag){
        this.editForm.mesIds = this.editForm.mesIds.substring(0, this.editForm.mesIds.length - 1);
        messageUpdate(this.editForm).then(response => {
          Navbar.messageBus.$emit("message");
        this.$message({ message: '操作成功!',  type: 'warning' });
        this.fetchMessage();
      });
      }

    },
  }
}
</script>

<style>
  .el-table .warning-row {
    background: oldlace;
    font-weight: 800;
  }
</style>
