<template>
  <div class="app-container">
    <!--<el-dialog :visible.sync="dialogVisible">-->
    <!--<img width="100%" :src="dialogImageUrl" alt="">-->
    <!--</el-dialog>-->
    <el-button type="primary" @click="openDialog()">新增文件</el-button>
    <el-row :gutter="20">
      <el-col v-for="(o, index) in this.linkList" :key="o.id" style="padding-top: 10px;width: 170px">
        <div @click="openUrl(o.filepath)">
          <el-card :body-style="{ padding: '0px' }">
            <img :src="getIcon(o.filename)" class="avatar">
            <div style="padding: 14px;">
            <span style="
                display: block;
                  overflow: hidden;
                 text-overflow: ellipsis;
                 white-space: nowrap;
                 width: 100%;">
              {{o.desc}}</span>
              <div class="bottom clearfix">
                <el-button type="text" class="button" @click.stop="deleteUrl(o.autoId)">删除</el-button>
              </div>
            </div>
          </el-card>
        </div>
      </el-col>
    </el-row>

    <el-dialog v-el-drag-dialog :visible.sync="dialogTableVisible" :close-on-click-modal="false" title="新增文件">
      <el-form ref="form" :model="linkForm" label-width="80px">
        <!--<el-form-item label="连接名称" prop="linkName"-->
        <!--:rules="[{ required: true, message: '请输入链接名', trigger: 'blur' }]"-->
        <!--&gt;-->
        <!--<el-input v-model="linkForm.name"></el-input>-->
        <!--</el-form-item>-->
        <el-form-item label="文件描述" prop="desc"
                      :rules="[{ required: true, message: '请输入文件描述', trigger: 'blur'},
                       {  max: 20, message: '长度必须小于 20 个字符', trigger: 'blur' }]">
          <el-input v-model="linkForm.desc"></el-input>
        </el-form-item>

        <el-form-item label="上传文件" prop="uploadId"
                      :rules="[{ required: true, message: '请上传文件', trigger: 'blur'}]">
          <el-upload
            v-loading="loading2"
            class="avatar-uploader"
            :action=getUploadUrl()
            method:="post"
            :show-file-list="false"
            :on-error="handleAvatarerror"
            :on-success="handleAvatarSuccess"
            :before-upload="beforeAvatarUpload">
            <img v-if="imageUrl" :src="imageUrl" class="avatar"/>
            <i v-else class="el-icon-plus avatar-uploader-icon" style="border: 1px solid"></i>
            <div style="max-width: 250px">
              <div align="center" v-if="imageName" style="
                overflow: hidden;
                 text-overflow: ellipsis;
                 white-space: nowrap;
                 width: 100%;"><span>{{this.imageName}}</span></div>
            </div>
          </el-upload>
        </el-form-item>
        <div align="center" style="width: 100%">
          <el-button v-loading="loading" type="success" @click="saveUrl()">
            发布
          </el-button>
          <el-button v-loading="loading" type="warning"
                     @click="dialogTableVisible = false;linkForm=defaultLinkForm;imageUrl='';imageName=''">
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
      url: '/api/cmsdocumeninfo/list.do_',
      headers: {
        'content-type': 'application/json'
      },
      method: 'post',
      data: form
    })
  }

  export function deleteLinkUrl(form) {
    return request({
      url: '/api/cmsdocumeninfo/delete/' + form + '.do_',
      method: 'get'
    })
  }

  export function saveLinkUrl(form) {
    return request({
      url: '/api/cmsdocumeninfo/save.do_',
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
      var checkAge = (rule, value, callback) => {

      }
      return {
        dialogTableVisible: false,
        imageUrl: '',
        linkList: [],
        postForm: {"pageIndex": 1, "pageSize": 200},
        loading: false,
        loading2: false,
        baseURL: process.env.BASE_API,
        linkForm: {
          desc: '',
          uploadId: ''
        },
        defaultLinkForm: {
          desc: '',
          uploadId: ''
        },
        imageName: ''

      }
    },
    created() {
      this.search();
    }
    ,
    methods: {
      openDialog() {
        this.dialogTableVisible = true
        this.linkForm = {
          desc: '',
          uploadId: ''
        }
        this.imageUrl = ''
        this.imageName = ''

      },
      getUploadUrl: function () {
        return this.baseURL + "/api/udfs/uploadFile.do_"
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
        this.$refs.form.validate((valid) => {
          if (valid) {
            this.loading = true
            saveLinkUrl(this.linkForm).then(response => {
              this.$message({
                message: '保存成功!',
                type: 'success'
              })
              this.loading = false
              this.search()
              this.dialogTableVisible = false
              this.linkForm = this.defaultLinkForm
            }).catch(() => {
              this.loading = false
            });
          }
        })

      },
      getIcon(fileName) {
        var fileExtend = '';
        if (fileName != null) {
          fileExtend = fileName.substring(fileName.lastIndexOf('.')).toLowerCase();
        }
        console.log(fileExtend)
        if (fileExtend == '.jpg' || fileExtend == '.jpeg') {
          return process.env.BASE_API + "/static/img/icon_jpg_256.png"
        } else if (fileExtend == '.txt') {
          return process.env.BASE_API + "/static/img/icon_txt_256.png"
        } else if (fileExtend == '.gif') {
          return process.env.BASE_API + "/static/img/icon_gif_256.png"
        } else if (fileExtend == '.png') {
          return process.env.BASE_API + "/static/img/icon_png_256.png"
        } else if (fileExtend == '.pdf') {
          return process.env.BASE_API + "/static/img/icon_pdf_256.png"
        } else if (fileExtend == '.xls' || fileExtend == '.xlsx') {
          return process.env.BASE_API + "/static/img/icon_xlsx_256.png"
        } else if (fileExtend == '.docx' || fileExtend == '.doc') {
          return process.env.BASE_API + "/static/img/icon_docx_256.png"
        } else {
          return "error"
        }
      },
      openUrl(url) {
        let fileName = url// 文件地址
        var fileExtend = '';
        if (fileName != null) {
          fileExtend = fileName.substring(fileName.lastIndexOf('.')).toLowerCase();
        }
        if (fileExtend == '.gif' || fileExtend == '.jpg' || fileExtend == '.png' || fileExtend == '.pdf' || fileExtend == '.jpeg') {
          window.open(url)
        } else {
          let downName = (new Date()).getTime() + fileExtend // 文件下载名称
          const blob = new Blob([fileName])
          if (window.navigator.msSaveOrOpenBlob) {
            // 兼容IE10
            navigator.msSaveBlob(blob, downName)
          } else {
            //  chrome/firefox
            let aTag = document.createElement('a')
            aTag.download = downName
            aTag.href = url
            aTag.click()
            URL.revokeObjectURL(aTag.href)
          }
        }
      },
      // v-el-drag-dialog onDrag callback function
      handleDrag() {
        this.$refs.select.blur()
      },
      handleAvatarSuccess(res, file) {
        console.log(res)
        if (res.success) {
          this.imageUrl = this.getIcon(res.re.filename)
          this.loading2 = false
          this.imageName = file.name
          this.linkForm.uploadId = res.re.autoId
          this.$refs.form.validate((valid) => {
          })
        } else {
          this.$message({
            message: res.code,
            type: 'error'
          })
          this.loading2 = false
        }
        // this.imageUrl = URL.createObjectURL(file.raw);
        // this.linkForm.linkPicUrl = res.re;
      },
      handleAvatarerror() {
        this.$message({
          message: '网络错误',
          type: 'error'
        })
        this.loading2 = false
      },
      // TXT,.txt,.DOC,.doc,.DOCX,.docx,.XLS,.xls,.XLSX,.xlsx,.PDF,.pdf,.GIF,.gif,.PNG,.png,.JPG,.jpg,.JPEG
      beforeAvatarUpload(file) {
        this.loading2 = true
        console.log(file.type)
        var isJPG = true
        const isLt2M = file.size / 1024 / 1024 < 10;
        if (this.getIcon(file.name) == 'error') {
          isJPG = false
          this.$message.error('格式必须为.txt，.doc，.docx.，xls，xlsx，pdf，.gif,.png,.jpg,.jpeg');
          this.loading2 = false
        }
        if (!isLt2M) {
          this.$message.error('上传文件的大小不能超过 10MB!');
          this.loading2 = false
        }
        console.log(file.name)
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
