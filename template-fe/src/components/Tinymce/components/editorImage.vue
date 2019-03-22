<template>
  <div class="upload-container">
    <el-button :style="{background:color,borderColor:color}" icon="el-icon-upload" size="mini" type="primary"
               @click="openDialog">上传图片
    </el-button>
    <el-dialog :visible.sync="dialogVisible">
      <el-upload
        ref="uploadIMG"
        :multiple="true"
        :show-file-list="true"
        :on-remove="handleRemove"
        :limit="5"
        :on-success="handleSuccess"
        :before-upload="beforeUpload"
        class="editor-slide-upload"
        :action=getUploadUrl()
        :on-exceed="handleExceed"
        list-type="picture-card">
        <el-button  size="small" type="primary">点击上传</el-button>
      </el-upload>
      <el-button @click="dialogVisible = false">取 消</el-button>
      <el-button type="primary" @click="handleSubmit">确 定</el-button>
    </el-dialog>
  </div>
</template>

<script>
  // import { getToken } from 'api/qiniu'

  export default {
    name: 'EditorSlideUpload',
    props: {
      color: {
        type: String,
        default: '#1890ff'
      }
    },
    data() {
      return {
        picNum: 0,
        canUpload: true,
        dialogVisible: false,
        listObj: {},
        fileList: [],
      }
    },
    methods: {
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
      handleExceed(files, fileList) {
        this.$message.warning(`限制上传 5个文件`)
      },
      openDialog(){
        this.listObj={},
        this.fileList=[],
        this.dialogVisible=true
        this.canUpload = true
        this.picNum=0
        if(this.$refs.uploadIMG){
          this.$refs.uploadIMG.clearFiles()
        }
      },
      getUploadUrl() {
        return process.env.BASE_API + "/api/udfs/uploadFile.do_"
      },
      checkAllSuccess() {
        return Object.keys(this.listObj).every(item => this.listObj[item].hasSuccess)
      },
      handleSubmit() {
        const arr = Object.keys(this.listObj).map(v => this.listObj[v])
        if (!this.checkAllSuccess()) {
          this.$message('请等待所有图片上传成功 或 出现了网络问题，请刷新页面重新上传！')
          return
        }
        this.$emit('successCBK', arr)
        this.listObj = {}
        this.fileList = []
        this.dialogVisible = false
      },
      handleSuccess(response, file) {
        if (response.success) {
          const uid = file.uid
          const objKeyArr = Object.keys(this.listObj)
          for (let i = 0, len = objKeyArr.length; i < len; i++) {
            if (this.listObj[objKeyArr[i]].uid === uid) {
              this.listObj[objKeyArr[i]].url = response.re.filepath
              this.listObj[objKeyArr[i]].hasSuccess = true
              return
            }
          }
        } else {
          this.$message({
            message: '上传失败',
            type: 'error'
          })
        }
      },
      handleRemove(file) {
        this.picNum--
        const uid = file.uid
        const objKeyArr = Object.keys(this.listObj)
        if (this.picNum < 5) {
          this.canUpload = true
        }
        for (let i = 0, len = objKeyArr.length; i < len; i++) {
          if (this.listObj[objKeyArr[i]].uid === uid) {
            delete this.listObj[objKeyArr[i]]
            return
          }
        }
      },
      beforeUpload(file) {
        console.log(file.type)
        var isJPG =true
        const isLt2M = file.size / 1024 / 1024 < 1;
        if( this.getIcon(file.name)=='error'){
          isJPG = false
          this.$message.error('格式必须为.gif .png .jpg .jpeg .bmp');
          return false
        }
        if (!isLt2M) {
          this.$message.error('上传头像图片大小不能超过 1MB!');
          return false
        }

        const _self = this
        const _URL = window.URL || window.webkitURL
        const fileName = file.uid
        this.listObj[fileName] = {}
        let a=new Promise((resolve, reject) => {
          const img = new Image()
          img.src = _URL.createObjectURL(file)
          img.onload = function () {
            _self.listObj[fileName] = {hasSuccess: false, uid: file.uid, width: this.width, height: this.height}
          }
          resolve(true)
        }) && isJPG && isLt2M;
        return a;
      }

    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .editor-slide-upload {
    margin-bottom: 20px;
    /deep/ .el-upload--picture-card {
      width: 100%;
    }
  }
</style>
