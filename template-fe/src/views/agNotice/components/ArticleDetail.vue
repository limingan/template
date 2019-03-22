<template>
  <div class="createPost-container">
    <el-form ref="postForm" :model="postForm" :rules="rules" class="form-container">
      <div class="createPost-main-container">
        <el-row>
          <sticky :class-name="'sub-navbar '+postForm.status" align="right">
            <el-button v-loading="loading" style="margin-left: 10px;" type="success" @click="submitForm">发布
            </el-button>
            <el-button v-loading="loading" type="warning" @click="draftForm">返回</el-button>
          </sticky>

          <el-col :span="24">
            <el-form-item style="margin-bottom: 40px;" prop="title">
              <MDinput v-model="postForm.title" :maxlength="100" name="name" required>
                标题
              </MDinput>
            </el-form-item>

            <div class="postInfo-container">
              <el-row>
                <el-col :span="8">&nbsp;&nbsp;&nbsp;&nbsp;
                  <el-switch
                    v-model='isTop'
                    active-text="置顶"
                    inactive-text="不置顶">
                  </el-switch>
                </el-col>
                <el-col :span="8">&nbsp;
                  <el-switch
                    v-model="isUrgency"
                    active-text="紧急"
                    inactive-text="不紧急">
                  </el-switch>
                </el-col>
              </el-row>
            </div>
            <div class="postInfo-container">&nbsp;</div>
            <div class="postInfo-container">
              <el-row>
                <el-form-item label-width="100px" label="开始时间:" class="postInfo-container-item" prop="endTime"
                              :rules="endTimeRule"
                >
                  <!--:rules="[{ required: true, message: '需要输入内容', trigger: 'blur'}]">-->

                  <el-date-picker
                    v-model="beginAndEndTime"
                    type="datetimerange"
                    align="right"
                    start-placeholder="开始日期"
                    end-placeholder="结束日期"
                    :editable="false"
                    :default-time="['8:00:00', '12:00:00']">
                  </el-date-picker>
                </el-form-item>


                <!--<el-col :span="8">-->
                <!--<el-form-item label-width="100px" label="开始时间:" class="postInfo-container-item" prop="beginTime"-->
                <!--:rules="[{ required: true, message: '需要输入内容', trigger: 'blur'}]">-->
                <!--<el-date-picker v-model="postForm.beginTime" type="datetime" format="yyyy-MM-dd HH:mm:ss" placeholder="选择日期时间"/>-->
                <!--</el-form-item>-->
                <!--</el-col>-->
                <!--<el-col :span="8">-->
                <!--<el-form-item label-width="100px" label="结束时间:" class="postInfo-container-item" prop="endTime"-->
                <!--:rules="[{ required: true, message: '需要输入内容', trigger: 'blur'}]">-->
                <!--<el-date-picker v-model="postForm.endTime" type="datetime" format="yyyy-MM-dd HH:mm:ss" placeholder="选择日期时间"/>-->
                <!--</el-form-item>-->
                <!--</el-col>-->
              </el-row>

            </div>
            <div class="postInfo-container">
              <el-row>
                <el-col :span="8">
                  <span @click="dialogVisible = true">
                  <el-form-item label-width="100px" label="接收用户:" prop="acceptNames" @click="alert(123)"
                                :rules="[{ required: true, message: '需要输入内容', trigger: 'blur'}]">
                    <el-input v-model="postForm.acceptNames" :readonly="true">
                      <el-button slot="append" icon="el-icon-search" ></el-button>
                    </el-input>
                  </el-form-item>
                  </span>
                </el-col>
              </el-row>
              <el-dialog
                :visible.sync="dialogVisible"
              >
                <el-tree
                  :data="data2"
                  show-checkbox
                  ref="tree"
                  node-key="id"
                  :default-checked-keys="postForm.acceptUsers==null?'':postForm.acceptUsers.split(',')"
                  :props="defaultProps">
                </el-tree>
                <span slot="footer" class="dialog-footer">
                  <el-button @click="dialogVisible = false">取 消</el-button>
                  <el-button type="primary" @click="getSelectUser">确 定</el-button>
                </span>
              </el-dialog>
            </div>

          </el-col>
        </el-row>
        <!--<el-form-item prop="content" :rules="[{ required: true, message: '需要输入内容', trigger: 'blur'},-->
                       <!--{ min: 10, max: 5000, message: '长度在 10 到 5000 个字符', trigger: 'blur' }]"></el-form-item>-->
        <div class="editor-container">
          <Tinymce ref="editor" :height="400" v-model="postForm.content"/>
        </div>
      </div>


    </el-form>

  </div>
</template>

<script>
  import Tinymce from '@/components/Tinymce'
  import Upload from '@/components/Upload/singleImage3'
  import MDinput from '@/components/MDinput'
  import Sticky from '@/components/Sticky' // 粘性header组件
  import request from '@/utils/request'
  import {validateURL} from '@/utils/validate'
  import {fetchArticle} from '@/api/article'
  import {userSearch} from '@/api/remoteSearch'
  import Warning from './Warning'
  import {CommentDropdown, PlatformDropdown, SourceUrlDropdown} from './Dropdown'
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
    status: '',
    title: '', // 文章题目
    content: '', // 文章内容
    istop: 0,
    isurgency: 0,
    beginTime: undefined,
    endTime: undefined, // 前台展示时间
    autoId: undefined,
    acceptUserIds: '',
    acceptUserNames: '',
    acceptUsers: '',
    acceptNames: '',
  }

  export function submitForm(form) {
    return request({
      url: '/api/agnotice/save.do_',
      headers: {
        'content-type': 'application/json'
      },
      method: 'post',
      data: form
    })
  }

  export function getAllOrg() {
    return request({
      url: '/api/agnotice/getAllOrg.do_',
      headers: {
        'content-type': 'application/json'
      },
      method: 'post'
    })
  }

  export function updateForm(form) {
    return request({
      url: '/api/agnotice/update.do_',
      headers: {
        'content-type': 'application/json'
      },
      method: 'post',
      data: form
    })
  }

  export default {
    name: 'ArticleDetail',
    components: {Tinymce, MDinput, Upload, Sticky, Warning, CommentDropdown, PlatformDropdown, SourceUrlDropdown},
    props: {
      isEdit: {
        type: Boolean,
        default: false
      }
    },
    data() {
      var checkEndTime = (rule, value, callback) => {
        value=new Date(value)
        this.postForm.beginTime=new Date(this.postForm.beginTime)
        console.log(value.getTime())
        console.log(value)
        console.log(this.postForm.beginTime.getTime())
        if (!value.getTime()) {
          return callback(new Error('时间不能为空'));
        }
      else  if (parseInt(new Date().getTime()) > parseInt(value.getTime())) {
          callback(new Error('结束时间应该大于当前时间'));
        }
      else  if (parseInt(this.postForm.beginTime.getTime()) == parseInt(value.getTime())) {
          callback(new Error('结束时间不应等于开始时间'));
        }
        else {
          callback();
        }
      }
      const validateRequire = (rule, value, callback) => {
        if (value === '') {
          callback(new Error(rule.field + '为必传项'))
        } else {
          callback()
        }
      }
      const validateSourceUri = (rule, value, callback) => {
        if (value) {
          if (validateURL(value)) {
            callback()
          } else {
            this.$message({
              message: '外链url填写不正确',
              type: 'error'
            })
            callback(new Error('外链url填写不正确'))
          }
        } else {
          callback()
        }
      }
      return {
        endTimeRule: [
          {validator: checkEndTime, trigger: 'blur'}
        ],
        data2: [],
        beginAndEndTime: [],
        defaultProps: {
          children: 'children',
          label: 'label'
        },
        dialogVisible: false,
        postForm: Object.assign({}, defaultForm),
        ask: {
          title: '1'
        },
        isTop: false,
        isUrgency: false,
        loading: false,
        userListOptions: [],
        rules: {
          image_uri: [{validator: validateRequire}],
          title: [{validator: validateRequire}],
          content: [{validator: validateRequire}],
          source_uri: [{validator: validateSourceUri, trigger: 'blur'}]
        }
      }
    },
    computed: {
      contentShortLength() {
        return this.postForm.content_short.length
      }
    },
    watch: {
      beginAndEndTime(val, oldVal) {//普通的watch监听
        if (val) {
          if (val.length = 2) {
            this.postForm.beginTime = val[0]
            this.postForm.endTime = val[1]
          } else {
            this.postForm.beginTime = ''
            this.postForm.endTime = ''
          }
        } else {
          this.postForm.beginTime = ''
          this.postForm.endTime = ''
        }
      }
    },
    created() {
      getAllOrg().then(res => {
        this.data2 = getJsonTree(JSON.parse(res.re).data, null)
      })

      var getJsonTree = function (data, parentId) {
        var itemArr = [];
        for (var i = 0; i < data.length; i++) {
          var node = data[i];
          if (node.parentID == parentId) {
            var newNode = {id: node.id, label: node.name, children: getJsonTree(data, node.id)};
            itemArr.push(newNode);
          }
        }
        return itemArr;
      }
      if (this.$route.params.id) {
        getInfo(this.$route.params.id).then(response => {
          defaultForm.acceptUserIds=response.re.acceptUserIds
          defaultForm.sendTime=response.re.sendTime
          defaultForm.senderName=response.re.senderName
          defaultForm.acceptUserNames=response.re.acceptUserNames
          defaultForm.title=response.re.title
          defaultForm.content=response.re.content
          defaultForm.istop=response.re.istop
          defaultForm.isurgency=response.re.isurgency
          defaultForm.beginTime=response.re.beginTime
          defaultForm.endTime=response.re.endTime
          defaultForm.autoId=response.re.autoId
          defaultForm.acceptNames=response.re.acceptNames
          defaultForm.acceptUsers=response.re.acceptUsers
          this.isTop = defaultForm.istop>0?true:false
          this.isUrgency = defaultForm.isurgency>0?true:false
          this.postForm=defaultForm
          this.beginAndEndTime.push(this.postForm.beginTime)
          this.beginAndEndTime.push(this.postForm.endTime)
          this.isTop = this.postForm.istop > 0 ? true : false
          this.isUrgency = this.postForm.isurgency > 0 ? true : false
        })
      } else {
        defaultForm.acceptUserIds=''
        defaultForm.sendTime=''
        defaultForm.senderName=''
        defaultForm.acceptUserNames=''
        defaultForm.title=''
        defaultForm.content=''
        defaultForm.istop=''
        defaultForm.isurgency=''
        defaultForm.beginTime=''
        defaultForm.endTime=''
        defaultForm.autoId=''
        defaultForm.acceptNames=''
        defaultForm.acceptUsers=''
        this.isTop = false
        this.isUrgency = false
        this.postForm = Object.assign({}, defaultForm)
      }
    },
    methods: {
      getSelectUser() {
        var checked = this.$refs.tree.getCheckedNodes();
        var acceptUsersList = []
        var acceptUsersNameList = []
        for (let i = 0; i < checked.length; i++) {
          acceptUsersList.push(checked[i].id)
          acceptUsersNameList.push(checked[i].label)
        }
        this.postForm.acceptUsers = acceptUsersList.toString()
        this.postForm.acceptNames = acceptUsersNameList.toString()
        this.$refs.postForm.validate(valid => {
        })
        this.dialogVisible = false
      },
      fetchData(id) {
        fetchArticle(id).then(response => {
          this.postForm = response.data
          // Just for test
          this.postForm.title += `   Article Id:${this.postForm.id}`
          this.postForm.content_short += `   Article Id:${this.postForm.id}`
        }).catch(err => {
          console.log(err)
        })
      },
      submitForm() {
        this.postForm.display_time = parseInt(this.display_time / 1000)
        this.postForm.istop = this.isTop == true ? 1 : 0
        this.postForm.isurgency = this.isUrgency == true ? 1 : 0
        if (this.beginAndEndTime) {
          this.postForm.beginTime = this.beginAndEndTime[0]
          this.postForm.endTime = this.beginAndEndTime[1]
        }
        this.$refs.postForm.validate(valid => {
          console.log(this.postForm.content.length)
          if(this.postForm.content==''){
            this.$message({
              message: '内容必须填写',
              type: 'error'
            })
            valid=false
          }else if(this.postForm.content.length>20000){
            console.log(this.postForm.content.length)
            this.$message({
              message: '内容超长，必须小于20000字符',
              type: 'error'
            })
            valid=false
          }
          if (valid) {
            this.loading = true
            delete this.postForm["display_time"]
            if (this.$route.params.id) {
              updateForm(this.postForm).then(response => {
                this.listLoading = false
                this.$notify({
                  title: '成功',
                  message: '发布文章成功',
                  type: 'success',
                  duration: 2000
                })
                this.loading = false
                this.$router.push({path: '/person/notices'})
              }).catch(err => {
                this.loading = false
              })
            } else {
              delete this.postForm["autoId"]
              submitForm(this.postForm).then(response => {
                this.listLoading = false
                this.$notify({
                  title: '成功',
                  message: '发布文章成功',
                  type: 'success',
                  duration: 2000
                })
                this.loading = false
                this.$router.push({path: '/person/notices'})
              }).catch(err => {
                this.loading = false
              })
            }

          } else {
            return false
          }
        })
      },
      draftForm() {
         this.$router.push({path: '/person/notices'})
      },
      getRemoteUserList(query) {
        userSearch(query).then(response => {
          if (!response.data.items) return
          this.userListOptions = response.data.items.map(v => v.name)
        })
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  @import "src/styles/mixin.scss";

  .createPost-container {
    position: relative;
    .createPost-main-container {
      padding: 40px 45px 20px 50px;
      .postInfo-container {
        position: relative;
        @include clearfix;
        margin-bottom: 10px;
        .postInfo-container-item {
          float: left;
        }
      }
      .editor-container {
        min-height: 500px;
        margin: 0 0 30px;
        .editor-upload-btn-container {
          text-align: right;
          margin-right: 10px;
          .editor-upload-btn {
            display: inline-block;
          }
        }
      }
    }
    .word-counter {
      width: 40px;
      position: absolute;
      right: -10px;
      top: 0px;
    }
  }
</style>
