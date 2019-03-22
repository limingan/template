<template>
  <div class="app-container">
    <!--<el-dialog :visible.sync="dialogVisible">-->
    <!--<img width="100%" :src="dialogImageUrl" alt="">-->
    <!--</el-dialog>-->
    <el-button type="primary" @click="openDialog">新增链接</el-button>
    <el-row :gutter="20">
      <el-col v-for="(o, index) in this.linkList" :key="o.id" style="padding-top: 10px;width: 170px">
        <div @click="openUrl(o.linkUrl)">
          <el-card :body-style="{ padding: '0px' }">
            <img v-if="!(o.linkPicUrl==null)" :src="o.linkPicUrl" class="avatar">
            <img v-if="o.linkPicUrl==null"
                 src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1538222784876&di=c117fa8b33d5abb2def150441240a96e&imgtype=0&src=http%3A%2F%2Fimg.25pp.com%2Fuploadfile%2Fapp%2Ficon%2F20170303%2F1488524966265793.jpg"
                 class="image">
            <div style="padding: 14px;">
            <span style="
                overflow: hidden;
                 text-overflow: ellipsis;
                 white-space: nowrap;
                 width: 100%;">
              {{o.linkName}}</span>
              <div class="bottom clearfix">
                <el-button type="text" class="button" @click.stop="deleteUrl(o.id)">删除</el-button>
              </div>
            </div>
          </el-card>
        </div>
      </el-col>
    </el-row>

    <el-dialog v-el-drag-dialog :visible.sync="dialogTableVisible" :close-on-click-modal="false" title="新增常用链接">
      <el-form ref="form" :model="linkForm"  label-width="80px">
        <el-form-item label="链接名称" prop="linkName"
                      :rules="[{ required: true, message: '请输入链接名', trigger: 'blur' },
                      {  max: 8, message: '长度小于 8 个字符', trigger: 'blur' },
                      ]"
        >
          <el-input v-model="linkForm.linkName"></el-input>
        </el-form-item>
        <el-form-item label="链接地址" prop="linkUrl"
                      :rules="[{ required: true, message: '请输入链接地址', trigger: 'blur'},
                      { min: 3, max: 200, message: '长度在 3 到 200个字符', trigger: 'blur' },
                      { pattern: /^((https|http|ftp|rtsp|mms)?:\/\/)[^\s]+$/, message: '仅支持链接' }
                       ]">
          <el-input v-model="linkForm.linkUrl"></el-input>
        </el-form-item>
        <el-form-item label="显示图片">
          <el-upload
            v-loading="loading2"
            class="avatar-uploader"
            :action=getUploadUrl()
            method:="post"
            :show-file-list="false"
            :on-error="handleAvatarerror"
            :on-success="handleAvatarSuccess"
            :before-upload="beforeAvatarUpload">
            <img v-if="linkForm.linkPicUrl" :src="linkForm.linkPicUrl" class="avatar">
            <i v-else class="el-icon-plus avatar-uploader-icon"
               style="border: 1px solid"></i>
          </el-upload>
        </el-form-item>

        <div align="center" style="width: 100%">
          <el-button v-loading="loading" style="margin-left: 10px;" type="success" @click="saveUrl()" >
            发布
          </el-button>
          <el-button v-loading="loading" type="warning" @click="dialogTableVisible = false;linkForm=defaultLinkForm">
            返回
          </el-button>
        </div>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
  import elDragDialog from '@/directive/el-dragDialog' // base on element-ui
  import request from '@/utils/request'
  import Sticky from '@/components/Sticky'

  export function queryLinkList(form) {
    return request({
      url: '/api/cmsagenlink/list.do_',
      headers: {
        'content-type': 'application/json'
      },
      method: 'post',
      data: form
    })
  }

  export function deleteLinkUrl(form) {
    return request({
      url: '/api/cmsagenlink/delete/' + form + '.do_',
      method: 'get'
    })
  }

  export function saveLinkUrl(form) {
    return request({
      url: '/api/cmsagenlink/save.do_',
      headers: {
        'content-type': 'application/json'
      },
      method: 'post',
      data: form
    })
  }

  export default {
    name: 'DragDialogDemo',
    directives: {elDragDialog},
    components: {Sticky},
    data() {
      var checkAge = (rule, value, callback) =>{

      }
      return {
        isloading:false,
        dialogTableVisible: false,
        imageUrl: '',
        loading2:false,
        linkList: [],
        postForm: {"pageIndex": 1, "pageSize": 200},
        loading: false,
        linkForm: {
          linkName: '',
          linkUrl: '',
          linkPicUrl: ''
        },
        defaultLinkForm: {
          linkName: '',
          linkUrl: '',
          linkPicUrl: ''
        },
        rules: {
          linkName: [
            {required: true, message: '必须输入连接名', trigger: 'blur'}
          ]
        }
      }
    },
    created() {
      this.search();
    }
    ,
    methods: {
      openDialog(){
        this.dialogTableVisible = true
        this.linkForm={
          linkName: '',
          linkUrl: '',
          linkPicUrl: ''
        }

      },
      getUploadUrl:function(){
        return process.env.BASE_API+"/api/udfs/uploadFile.do_"
      },
      getIcon(fileName){
        var fileExtend='';
        if(fileName!=null){
          fileExtend=fileName.substring(fileName.lastIndexOf('.')).toLowerCase();
        }
        console.log(fileExtend)
        if(fileExtend=='.jpg'||fileExtend=='.png'||fileExtend=='.jpeg'||fileExtend=='.bmp'||fileExtend=='.gif'){
          return "success"
        }
        else {
          return "error"
        }
      },
      search() {
        queryLinkList(this.postForm).then(response => {
          if (response.success) {
            this.linkList = response.re.rows
          }
          console.log(this.linkList)
        }).catch(err => {
        })
      },
      deleteUrl(id) {
        let myid = id + ''
        this.$confirm('确认删除？')
          .then(() => {
            deleteLinkUrl(id).then(response => {
              this.$message({
                message: '删除成功!',
                type: 'success'
              })
              this.search()
            })
          })
          .catch(() => {

          });
      },
      saveUrl() {
        this.$refs.form.validate((valid) =>{
          if (valid) {
            this.isloading=true
            saveLinkUrl(this.linkForm).then(response => {
              this.$message({
                message: '保存成功!',
                type: 'success'
              })
              this.search()
              this.dialogTableVisible = false
              this.linkForm = this.defaultLinkForm
              this.isloading=false
            }).catch(() => {
              this.isloading=false
            });
          }
        })

      },
      openUrl(url) {
        window.open(url);
      },
      // v-el-drag-dialog onDrag callback function
      handleDrag() {
        this.$refs.select.blur()
      },
      handleAvatarSuccess(res, file) {
        if(res.success){
          this.linkForm.linkPicUrl = res.re.filepath;
          this.loading2=false
        }else{
          this.$message({
            message: res.code,
            type: 'error'
          })
          this.loading2=false
        }
      },
      handleAvatarerror(res){
        this.$message({
          message: '网络错误',
          type: 'error'
        })
        this.loading2=false
      },
      beforeAvatarUpload(file) {
        console.log(file.type)
        var isJPG =true
        this.loading2=true
        const isLt2M = file.size / 1024 / 1024 < 1;
        if( this.getIcon(file.name)=='error'){
          isJPG = false
          this.$message.error('格式必须为.gif .png .jpg .jpeg .bmp');
          this.loading2=false
        }
        if (!isLt2M) {
          this.$message.error('上传头像图片大小不能超过 1MB!');
          this.loading2=false
        }
        return isJPG && isLt2M;
      }
    }
  }
</script>

<style scoped>
  .time {
    font-size: 13px;
    color: #999;
  }

  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }

  .button {
    padding: 0;
    float: right;
  }

  .image {
    width: 100%;
    display: block;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix:after {
    clear: both
  }

  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }

  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }

  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 148px;
    height: 148px;
    line-height: 148px;
    text-align: center;
  }

  .avatar {
    width: 148px;
    height: 148px;
    display: block;
  }
</style>
