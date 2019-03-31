<template>
  <div class="app-container">
    <el-form :inline="true" :model="formQuery" :rules="formRules" ref="formQuery" class="demo-form-inline">
        <el-form-item label="关键字" prop="primaryKey">
            <el-input v-model="formQuery.primaryKey" placeholder="关键字"></el-input>
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
      <el-table-column label="发布者" width="200">
        <template slot-scope="scope">{{scope.row.publishName}}</template>
      </el-table-column>
      <el-table-column label="标题">
        <template slot-scope="scope">{{scope.row.title}}</template>
      </el-table-column>
      <el-table-column label="发布时间" width="200">
        <template slot-scope="scope">{{scope.row.createTime}}</template>
      </el-table-column>
      <el-table-column label="状态" width="100">
        <template slot-scope="scope">{{scope.row.status}}</template>
      </el-table-column>
      <el-table-column label="操作" width="100">
          <template slot-scope="scope">
            <el-button type="primary" @click="openNoticeDetail = true" >查看</el-button>
          </template>
      </el-table-column>
    </el-table>
    <el-pagination background layout="prev, pager, next" :total="total" :page-size="formQuery.pageSize"> </el-pagination>

    <el-dialog title="公告详情" :visible.sync="openNoticeDetail" width="50%">
    <div style="border-bottom: 1px #E7E6E6 dashed; padding-bottom: 10px; margin-bottom: 10px;">
      <p style="text-align: center; font-size: 20px">【以此为准】常用联系人更新为6.12【第二版】</p>
      <p style="text-align: right; margin: 0px;">2018-06-12 13:48:37</p>
      <p style="text-align: right; margin: 0px;">王艳艳-主管</p>
    </div>
    <div class="_content"><p class="MsoListParagraph" style=";margin-bottom: 0;margin-left:28px;margin-bottom:0;line-height:normal"><span style="font-size:13px;font-family:Wingdings">ü<span style="font-variant-numeric: normal;font-stretch: normal;font-size: 9px;line-height: normal;font-family: 'Times New Roman'">&nbsp; </span></span><strong><span style="font-size:13px;font-family: 宋体">常用联系人更为6.12【第二版】，已发送至公邮，更新内容如下：</span></strong></p><p class="MsoListParagraph" style=";margin-bottom: 0;margin-left:28px;margin-bottom:0;text-indent:0;line-height:16px"><span style="font-size:13px;font-family:宋体">1.</span><span style="font-size:13px;font-family:宋体">乌鲁木齐分公司4月已搬迁至：新疆省乌鲁木齐市鲤鱼山北路199号集电港A座514室</span></p><p class="MsoListParagraph" style=";margin-bottom: 0;margin-left:28px;margin-bottom:0;text-indent:0;line-height:16px"><span style="font-size:13px;font-family:宋体">2.</span><span style="font-size:13px;font-family:宋体">兰州安淼对接人信息变更</span></p><p class="MsoListParagraph" style=";margin-bottom: 0;margin-left:28px;margin-bottom:0;text-indent:0;line-height:16px"><span style="font-size: 13px; font-family: 宋体;">3.</span><span style="font-size: 13px; font-family: 宋体;">（6.12）北京畅达2厂，因政府相关部门的检查，我厂从即日起暂停营业，具体恢复时间以邮件通知为准，自即日起我厂暂时停止接待租期内车辆、专车车辆，以及拖车进厂，请引导到其他两厂，就近搭电救援的可以安排。</span></p><p class="MsoListParagraph" style=";margin-bottom: 0;margin-left:28px;margin-bottom:0;text-indent:0;line-height:16px"><span style="font-size: 13px; font-family: 宋体;">4. </span><span style="font-size: 13px; font-family: 宋体;">自2018年6月13日开始，广州安淼自建厂24小时救援电话由原号码13802966806变更为：18620460560，原号码将取消使用</span></p><p class="MsoListParagraph" style=";margin-bottom: 0;margin-left:28px;margin-bottom:0;text-indent:0;line-height:16px"><span style="font-size: 13px; font-family: 宋体;">5. </span><span style="font-size: 13px; font-family: 宋体;">石家庄资产主管变更为：王龙 ，联系方式：18033719953 ，邮箱：<a href="mailto:LONG.WANG01@qq.COM">LONG.WANG01@qq.COM</a></span></p><p class="MsoListParagraph" style=";margin-bottom: 0;margin-left:28px;margin-bottom:0;text-indent:0;line-height:16px"><span style="font-size: 13px; font-family: 宋体;">6. </span><span style="font-size: 13px; font-family: 宋体;">厦门前台信息有更新</span></p><p></p></div>
    <span slot="footer" class="dialog-footer">
        <el-button @click="openNoticeDetail = false">关 闭</el-button>
    </span>
    </el-dialog>
  </div>
</template>

<script>

export default {
  data() {
    return {
      listLoading: true,
      openNoticeDetail: false,
      formQuery: {
        primaryKey: '',
        pageNum: 1,
        pageSize: 7
      },
      formRules: {
        primaryKey: [
          { max: 5, message: '长度不超过100个字', trigger: 'blur' }
        ]
      },
      total: 10,
      items: [{
        publishName: '雷涛',
        title: '新增呼入短信模板',
        createTime: '2018-03-07 15:19:46',
        status: '过期'
      },
      {
        publishName: '姜学良',
        title: '新系统新建“保险理赔单登记”暂停使用，大家可通过后台新建',
        createTime: '2018-03-07 15:19:46',
        status: '过期'
      },
      {
        publishName: '姜学良',
        title: '截止16:30租车业务已全部切到新系统',
        createTime: '2018-02-03 16:39:49',
        status: '过期'
      },
      {
        publishName: '姜学良',
        title: '今天武汉陆续向新系统切换，目前线上排队！！请注意保持示闲',
        createTime: '2018-02-03 11:14:38',
        status: '过期'
      },
      {
        publishName: '姜学良',
        title: '注意把控小休、话后、外拨模式，做好忙线加班准备！',
        createTime: '2018-02-02 09:30:09',
        status: '过期'
      },
      {
        publishName: '姜学良',
        title: '2月1日起取消管控岗固定工位（5065/5911）',
        createTime: '2018-01-31 14:07:21',
        status: '过期'
      },
      {
        publishName: '天津-专车投诉主管-兰林丽',
        title: '测试',
        createTime: '2018-01-28 16:28:55',
        status: '过期'
      },
      {
        publishName: '索坤',
        title: '测试',
        createTime: '2018-01-28 09:41:51',
        status: '过期'
      },
      {
        publishName: '赵莹',
        title: '就餐',
        createTime: '2018-01-27 10:45:00',
        status: '过期'
      },
      {
        publishName: '王艳艳-主管',
        title: '【以此为准】常用联系人更新为6.12【第二版】',
        createTime: '2018-06-12 13:48:37',
        status: '过期'
      }],
      noticeDetail: {}
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
