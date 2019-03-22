<template>
  <div class="createPost-container">
    <el-row :gutter="20" style="margin-top: 30px">
      <el-col :span="18" :offset="3">
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <el-row :gutter="20">
              <el-col :span="4"><div class="grid-content bg-purple" align="center">&nbsp;</div></el-col>
              <el-col :span="16"><div class="grid-content bg-purple" align="center"> <span><b>{{postForm.title}}</b></span></div></el-col>
              <el-col :span="4"><div class="grid-content bg-purple"><el-button style="float: right;" type="warning" @click="draftForm">返回</el-button></div></el-col>
            </el-row>
             <p align="center"> <span v-text="postForm.senderName"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: #ccc;font-weight: bold;font-size: small" v-text="postForm.sendTime"></span></p>
          </div>
           <span v-html="postForm.content"></span>
        </el-card>
      </el-col>
    </el-row>


  </div>
</template>

<script>
  import { formatDate } from 'element-ui/packages/date-picker/src/util';
  import Sticky from '@/components/Sticky'
  import {dateFormat, dateTimeFormat} from '@/utils';
  import request from '@/utils/request'
  export function getInfo(form) {
    return request({
      url: '/api/agnotice/info/' + form + '.do_',
      headers: {
        'content-type': 'application/json'
      },
      method: 'post',
    })
  }

  const defaultForm = {
    status: 'draft',
    title: '', // 文章题目
    content: '', // 文章内容
    istop: false,
    sendTime:'',
    senderName:'',
    isurgency: false,
    beginTime: undefined,
    endTime: undefined, // 前台展示时间
    autoId: undefined,
    acceptUserIds:'',
    acceptUserNames:''
  }
  export default {
    components:{Sticky},
    data() {
      return {
        postForm: Object.assign({}, defaultForm),
      }
    },
    created() {
      console.log(this.$route.params.id )
      if (this.$route.params.id ) {
        getInfo(this.$route.params.id).then(response => {
          defaultForm.acceptUserIds=response.re.acceptUserIds
          defaultForm.sendTime=formatDate(response.re.sendTime, 'yyyy-MM-dd HH:mm:ss')
          defaultForm.senderName=response.re.senderName
          defaultForm.acceptUserNames=response.re.acceptUserNames
          defaultForm.title=response.re.title
          defaultForm.content=response.re.content
          defaultForm.istop=response.re.istop
          defaultForm.isurgency=response.re.isurgency
          defaultForm.beginTime=response.re.beginTime
          defaultForm.endTime=response.re.endTime
          defaultForm.autoId=response.re.autoId
          this.isTop = defaultForm.istop>0?true:false
          this.isUrgency = defaultForm.isurgency>0?true:false
          this.postForm=defaultForm
        })
      } else {
        this.postForm = Object.assign({}, defaultForm)
      }
    },
    methods: {
      draftForm() {
        window.close()
        // this.$router.push({path: '/person/notices'})
      }
    }
  }
</script>
<style>
  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }

</style>
