<template>
  <div class="app-container">
    <el-form :inline="true" :model="formQuery" :rules="formRules" ref="formQuery" class="demo-form-inline">
        <el-form-item label="会话时间" prop="sessionTime">
          <el-date-picker
            v-model="formQuery.sessionTime"
            type="daterange"
            align="right"
            unlink-panels
            range-separator="-"
            start-placeholder="开始日期"
            end-placeholder="结束日期"
            :picker-options="pickerOptions">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="服务渠道" prop="sessionTime">
          <el-select v-model="formQuery.channelCode" placeholder="请选择">
            <el-option
              v-for="item in channelCodeItem"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="工号">
            <el-input v-model="formQuery.workNo" placeholder="工号"></el-input>
        </el-form-item>
        <el-form-item label="会话ID">
            <el-input v-model="formQuery.sessionId" placeholder="会话ID"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="onSubmit">查询</el-button>
            <el-button @click="onClean">重置</el-button>
        </el-form-item>
    </el-form>
    <el-table :data="items" v-loading="listLoading" element-loading-text="Loading" empty-text="暂无数据" border fit highlight-current-row>
      <el-table-column align="center" label='ID' width="50">
        <template slot-scope="scope">
            {{scope.$index + 1}}
        </template>
      </el-table-column>
      <el-table-column label="账号信息">
        <template slot-scope="scope">
          客户账号：{{scope.row.sendAccount}} <br/>
          接收账号：{{scope.row.acceptedAccount}} <br/>
          坐席工号：{{scope.row.workNos}}
        </template>
      </el-table-column>
      <el-table-column label="坐席信息">
        <template slot-scope="scope">
          坐席姓名：{{scope.row.workName}}  <br/>
          所属组织：{{scope.row.changeStatus}}
        </template>
      </el-table-column>
      <el-table-column label="会话状态">
        <template slot-scope="scope">
          会话关闭：{{scope.row.callStatus}} <br/>
          满意度：{{scope.row.status}}
        </template>
      </el-table-column>
      <el-table-column label="会话信息">
        <template slot-scope="scope">
          会话时长：8秒 <br/> 
          开始时间：{{scope.row.createTime}} <br/>
          结束时间：{{scope.row.endTime}} 
        </template>
      </el-table-column>
      <el-table-column label="操作" width="200">
          <template slot-scope="scope">
            <el-button type="primary" >小结</el-button>
            <el-button type="primary" >消息</el-button>
          </template>
      </el-table-column>
    </el-table>
    <el-pagination background layout="prev, pager, next" :total="total" :page-size="formQuery.pageSize"> </el-pagination>
  </div>
</template>

<script>
import { getHistorySessionList } from '@/api/csp/history'

export default {
  data() {
    return {
      listLoading: true,
      closeReviewDialogVisible: false,
      formRules: {
        sessionTime: [
          { required: true, message: '请选择会话时间', trigger: 'blur' }
        ],
        channelCode: [
          { required: true, message: '请选择服务渠道', trigger: 'blur' }
        ]
      },
      formQuery: {
        sessionTime: '',
        beginDate: '',
        endDate: '',
        tenantCode: '6000',
        workNo: '',
        sessionId: '',
        channelCode: '1000',
        pageNum: 1,
        pageSize: 7
      },
      total: 0,
      channelCodeItem: [
        {
          value: '1000',
          label: '语音'
        }
      ],
      items: [],
      pickerOptions: {
        disabledDate(time) {
          const end = new Date()
          const start = new Date()
          start.setTime(start.getTime() - 3600 * 1000 * 24 * 30)
          console.log(start.getTime())
          return start.getTime() > time.getTime() && end.getTime() < time.getTime()
        },
        shortcuts: [{
          text: '最近一周',
          onClick(picker) {
            const end = new Date()
            const start = new Date()
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 7)
            picker.$emit('pick', [start, end])
          }
        }, {
          text: '最近半个月',
          onClick(picker) {
            const end = new Date()
            const start = new Date()
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 14)
            picker.$emit('pick', [start, end])
          }
        }, {
          text: '最近一个月',
          onClick(picker) {
            const end = new Date()
            const start = new Date()
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 30)
            picker.$emit('pick', [start, end])
          }
        }]
      }
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.listLoading = true
      const _this = this
      getHistorySessionList(this.formQuery).then(response => {
        console.log(response)
        _this.items = response.data
        _this.total = response.total
      })
      this.listLoading = false
    },
    onSubmit() {
      this.$refs['formQuery'].validate((valid) => {
        if (valid) {
          alert('submit!')
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    onClean() {
      this.$refs['formQuery'].resetFields()
    }
  }
}
</script>
