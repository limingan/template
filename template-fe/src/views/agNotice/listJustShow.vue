<!--
 列表页
 @author junwei.xiong
 @since 2018-09-26 10:03:33
-->
<template>
  <CrudList ref="cp" :api="api" domainName="AgNotice" :perms="perms" :parentRefs="this.$refs" :queryParamEx="queryParam"
            :dictFields="dictFields" :dictTypes="dictTypes" :enaUpdateBtn="false" :enaDeleteBtn="false" :enaAddBtn="false"
            :addRouterUrl="{ path: `create` }">
    <template slot-scope="scope" slot="querySlot">
      <el-form-item label="标题">
        <el-input  v-model="scope.queryParam.title"></el-input>
      </el-form-item>
      <el-form-item label="开始时间">
        <el-date-picker v-model="scope.queryParam.beginTime" type="date" placeholder="请选择开始时间"></el-date-picker>
      </el-form-item>
      <el-form-item label="结束时间">
        <el-date-picker v-model="scope.queryParam.endTime" type="date" placeholder="请选择结束时间"></el-date-picker>
      </el-form-item>
    </template>

    <template slot="tableColumnSlot">
      <el-table-column type="selection" width="55">
      </el-table-column>
      <el-table-column align="center" label="发送者名字">
        <template slot-scope="scope">
          <el-button type="text">{{scope.row.senderName}}</el-button>
        </template>
      </el-table-column>
      <el-table-column align="center" label="标题">
        <template slot-scope="scope">
           <span style="
                overflow: hidden;
                 text-overflow: ellipsis;
                 white-space: nowrap;
                 width: 100%;">{{scope.row.title}}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" prop="sendTime" label="创建时间" :formatter="dateTimeFormat">false</el-table-column>

      <el-table-column align="center" prop="beginTime" label="开始时间" :formatter="dateFormat">false</el-table-column>

      <el-table-column align="center" prop="endTime" label="结束时间" :formatter="dateFormat">false</el-table-column>

      <el-table-column align="center" label="是否置顶">
        <template slot-scope="scope">
            <span type="text"  v-if="scope.row.istop==1">置顶</span>
            <span type="text"  v-else>不置顶</span >
        </template>
      </el-table-column>
      <el-table-column align="center" label="用户">
        <template slot-scope="scope">
            <!--<el-button type="text">{{}}</el-button>-->
             <el-tooltip class="item" effect="dark" placement="top-start">
               <div slot="content" style="max-width: 150px">{{scope.row.acceptNames}}</div>
              <span style="
                overflow: hidden;
                 text-overflow: ellipsis;
                 white-space: nowrap;
                 width: 100%;">{{scope.row.acceptNames}}</span>
            </el-tooltip>
        </template>
      </el-table-column>
      <el-table-column align="center" label="是否过期">
        <template slot-scope="scope">
          <el-button type="text" v-if="scope.row.endTime<Date.parse(new Date())"><span style="color: crimson">已过期</span></el-button>
          <el-button type="text" v-else><span style="color: #67c23a">未过期</span></el-button>
        </template>
      </el-table-column>
      <el-table-column align="center" label="操作" width="400">
        <template slot-scope="scope">
          <el-row>
            <el-tooltip class="item" effect="dark" content="预览" placement="top">
              <el-button icon="el-icon-search" circle @click="showNotice(scope.row)"></el-button>
            </el-tooltip>
            <el-dialog
              :visible.sync="dialogVisible"
             >
              <div class="block">
                <span class="demonstration">延期至</span>
                <el-date-picker
                  v-model="notice.endTime"
                  type="datetime"
                  placeholder="选择日期时间">
                </el-date-picker>
              </div>
              <span slot="footer" class="dialog-footer">
                  <el-button @click="dialogVisible = false">取 消</el-button>
                  <el-button type="primary" @click="updateNotice">确 定</el-button>
                </span>
            </el-dialog>
          </el-row>
        </template>
      </el-table-column>
    </template>
  </CrudList>
</template>

<script>

  import request from '@/utils/request'
  import api from '@/api/agNotice';
  import CrudList from '../../components/CrudList';
  import {dateFormat, dateTimeFormat} from '@/utils';

  export function updateForm(form) {
    return request({
      url: '/api/agnotice/updateEndTime.do_',
      headers: {
        'content-type': 'application/json'
      },
      method: 'post',
      data: form
    })
  }

  export function deleteForm(form) {
    return request({
      url: '/api/agnotice/delete/' + form + '.do_',
      headers: {
        'content-type': 'application/json'
      },
      method: 'post',
      data: form
    })
  }

  export default {
    inject: ['reload'],
    components: {CrudList},
    data() {
      return {
        dialogVisible: false,
        list: [],
        api: api,
        id: {
          id: ''
        },
        notice:{
          autoId:'',
          endTime:''
        },
        perms: {
          save: 'agnotice:save',
          update: 'agnotice:update',
          delete: 'agnotice:delete',
        },
        queryParam: {
          title: ''
          , beginTime: ''
          , endTime: ''
        }
        , dictFields: []
        , dictTypes: []
      }
    },
    methods: {
      handleClose(done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
      },
      updateNotice(){
        updateForm(this.notice).then(response => {
          if(response.success){
            this.dialogVisible = false
            this.$notify({
              title: '成功',
              message: '更新成功',
              type: 'success',
              duration: 2000
            })
            this.$refs.cp.search();
          }else{
            this.$notify({
              title: '失败',
              message: '更新失败',
              type: 'error',
              duration: 2000
            })
          }

        })
      },
      dateFormat,
      dateTimeFormat,
      fetchData() {
        this.listLoading = true
        this.listLoading = false
      },
      onSubmit() {
      },
      clickSettingBBS(msg) {
        console.log(msg)
        this.$router.push({path: '/person/create', query: {noticeId: '1', isEdit: true, notice: msg}})
      },
      showNotice(msg) {
        this.$router.push({path: '/person/showNotice', query: {noticeId: '1', isEdit: true, notice: msg}})
      },
      updateTimeNotice(msg) {
        this.dialogVisible = true
        this.notice.autoId=msg.autoId
        this.notice.endTime=msg.endTime
      },
      deleteNotice(msg) {
        this.$confirm('确定要删除吗?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
          center: true
        }).then(() => {
          api.deleteAgNotice(msg.autoId).then(response => {
            // deleteForm(msg.autoId).then(response => {
            this.listLoading = false
            this.$notify({
              title: '成功',
              message: '删除成功',
              type: 'success',
              duration: 2000
            })
            this.$refs.cp.search();
          }).catch(err => {
            this.loading = false
          })
        })
      }
    }
  }
</script>
