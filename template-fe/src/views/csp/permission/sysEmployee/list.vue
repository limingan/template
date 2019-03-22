<!--
 列表页
 @author junwei.xiong
 @since 2018-10-08 18:10:13
-->
<template>
  <CrudList ref="cp" :api="api" domainName="SysEmployee" :perms="perms" :parentRefs="this.$refs"
            :queryParamEx="queryParam"
            :dictFields="dictFields" :dictTypes="dictTypes" :enaUpdateBtn="false" :enaDeleteBtn="false"
            :addRouterUrl="{ path: `sysEmployeeAdd` }">
    <template slot-scope="scope" slot="querySlot">
      <el-form-item label="编号">
        <el-input v-model="scope.queryParam.number"></el-input>
      </el-form-item>
      <el-form-item label="姓名">
        <el-input v-model="scope.queryParam.name"></el-input>
      </el-form-item>
      <el-form-item label="电话">
        <el-input v-model="scope.queryParam.telephone"></el-input>
      </el-form-item>
      <el-form-item label="邮箱">
        <el-input v-model="scope.queryParam.email"></el-input>
      </el-form-item>
      <el-form-item label="工号">
        <el-input v-model="scope.queryParam.workNo"></el-input>
      </el-form-item>
      <el-form-item label="分机">
        <el-input v-model="scope.queryParam.extensionNumber"></el-input>
      </el-form-item>
      <el-form-item label="状态">
        <el-select v-model="scope.queryParam.status" clearable filterable placeholder="请选择状态">
          <el-option
            v-for="item in statusList"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>
      <!--<el-form-item label="是否已删除">-->
      <!--<el-select v-model="scope.queryParam.isDeleted" filterable placeholder="请选择是否已删除">-->
      <!--<el-option-->
      <!--v-for="item in isDeletedList"-->
      <!--:key="item.value"-->
      <!--:label="item.label"-->
      <!--:value="item.value">-->
      <!--</el-option>-->
      <!--</el-select>-->
      <!--</el-form-item>-->
    </template>
    <template slot="tableColumnSlot">
      <el-table-column align="center" prop="autoId" label="自增ID">false</el-table-column>
      <el-table-column align="center" prop="deptId" label="部门ID">false</el-table-column>
      <el-table-column align="center" label="编号">
        <template slot-scope="scope">
          {{scope.row.number}}
        </template>
      </el-table-column>
      <el-table-column align="center" label="姓名">
        <template slot-scope="scope">
          {{scope.row.name}}
        </template>
      </el-table-column>
      <el-table-column align="center" label="电话">
        <template slot-scope="scope">
          {{scope.row.telephone}}
        </template>
      </el-table-column>
      <el-table-column align="center" label="邮箱">
        <template slot-scope="scope">
          {{scope.row.email}}
        </template>
      </el-table-column>
      <el-table-column align="center" label="工号">
        <template slot-scope="scope">
          {{scope.row.workNo}}
        </template>
      </el-table-column>
      <el-table-column align="center" label="分机">
        <template slot-scope="scope">
          {{scope.row.extensionNumber}}
        </template>
      </el-table-column>
      <!--<el-table-column align="center" label="对应业务系统密码">-->
      <!--<template slot-scope="scope">-->
      <!--<router-link :to="{name: 'sysEmployeeView', params: {autoId: scope.row.autoId}}">-->
      <!--{{scope.row.password}}-->
      <!--</router-link>-->
      <!--</template>-->
      <!--</el-table-column>-->
      <el-table-column align="center" label="描述">
        <template slot-scope="scope">
          {{scope.row.description}}
        </template>
      </el-table-column>
      <el-table-column align="center" prop="gender" :formatter="formatGender" label="性别">false</el-table-column>
      <el-table-column align="center" prop="status" :formatter="formatStatus" label="状态">false</el-table-column>
      <!--<el-table-column align="center" prop="isDeleted" :formatter="formatIsDeleted" label="是否已删除">false</el-table-column>-->
      <el-table-column align="center" prop="createTime" label="创建时间" :formatter="dateFormat">false</el-table-column>
      <el-table-column align="center" prop="updateTime" label="修改时间" :formatter="dateFormat">false</el-table-column>
      <el-table-column align="center" label="操作" width="300">
        <template slot-scope="scope">
          <el-row>
            <el-tooltip class="item" effect="dark" content="修改" placement="top">
              <el-button type="primary" icon="el-icon-edit" circle @click="$refs.cp.edit(scope.row.autoId)"></el-button>
            </el-tooltip>
            <el-tooltip class="item" effect="dark" content="授权" placement="top">
              <el-button type="warning" icon="el-icon-setting" circle @click="grantRole(scope.row)"></el-button>
            </el-tooltip>
            <!--<el-tooltip class="item" effect="dark" content="修改密码" placement="top">-->
              <!--<el-button type="info" icon="el-icon-edit-outline" circle @click="modifyPassword(scope.row)"></el-button>-->
            <!--</el-tooltip>-->
            <el-tooltip class="item" effect="dark" content="删除" placement="top">
              <el-button type="danger" icon="el-icon-delete" circle @click="$refs.cp.del(scope.row.autoId)"></el-button>
            </el-tooltip>
          </el-row>
          <el-dialog title="修改密码" :visible.sync="dialogVisible" width="30%">
            <el-form :model="form">
              <el-form-item label="邮箱：" :label-width="formLabelWidth">
                {{form.email}}
              </el-form-item>
              <el-form-item label="密码：" :label-width="formLabelWidth">
                <el-input :type="passwordType" v-model="form.password" placeholder="请输入密码">
                  <i slot="suffix" title="显示密码" @click="changePass()" :class="passwordSlot"></i>
                </el-input>
              </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
              <el-button @click="cancelModifyPassword">取 消</el-button>
              <el-button type="primary" @click="doModifyPassword">确 定</el-button>
            </div>
          </el-dialog>
        </template>
      </el-table-column>
    </template>
  </CrudList>

</template>


<script>
  import api from '@/api/csp/permission/sysEmployee';
  import CrudList from '@/components/CrudList';
  import {dateFormat, dateTimeFormat} from '@/utils';

  export default {
    components: {CrudList},
    data() {
      return {
        api: api,
        passwordSlot: 'el-input__icon el-icon-view',
        passwordType: 'password',
        passwordTitle: '显示密码',
        perms: {
          save: 'sysemployee:save',
          update: 'sysemployee:update',
          delete: 'sysemployee:delete',
        },
        queryParam: {
          number: ''
          , name: ''
          , telephone: ''
          , email: ''
          , workNo: ''
          , extensionNumber: ''
          , status: ''
        }
        , dictFields: []
        , dictTypes: []
        , statusList: [{
          value: 1,
          label: '在职'
        }, {
          value: 2,
          label: '离职'
        }]
        , isDeletedList: [{
          value: 0,
          label: '否'
        }, {
          value: 1,
          label: '是'
        }]
        , value: ''
        , dialogVisible: false
        , form: {
          autoId: '',
          number: '',
          name: '',
          email: '',
          password: ''
        }
        , formLabelWidth: '60px'
      }
    },
    methods: {
      dateFormat,
      dateTimeFormat,
      grantRole(data) {
        this.$router.push({path: '/permission/grantRole', query: {autoId: data.autoId}})
      },
      formatGender: function (row, column) {
        return row.gender == 1 ? "男" : row.gender == 2 ? "女" : "";
      },
      formatStatus: function (row, column) {
        return row.status == 1 ? "在职" : row.status == 2 ? "离职" : "";
      },
      formatIsDeleted: function (row, column) {
        return row.isDeleted == 0 ? "否" : row.isDeleted == 1 ? "是" : "";
      },
      changePass() {
        if (this.passwordType === 'input') {
          this.passwordSlot = 'el-input__icon el-icon-view';
          this.passwordType = 'password';
          this.passwordTitle = '隐藏密码';
        } else {
          this.passwordSlot = 'el-icon-circle-close-outline';
          this.passwordType = 'input';
          this.passwordTitle = '显示密码';
        }

      },
      modifyPassword(data) {
        this.form.email = data.email;
        this.form.autoId = data.autoId;
        this.form.number = data.number;
        this.form.name = data.name;
        this.dialogVisible = true
      },
      doModifyPassword() {
        let flag = this.validatePassword(this.form.password);
        if (!flag) {
          this.$message({
            message: `密码长度控制在8到20位，且必须包含大写字母，小写字母，数字，特殊符号其中三种!`,
            type: 'warning'
          })
          return false;
        }
        this.form.email = '';
        api.updateSysEmployee(this.form).then(response => {
          this.$message({
            message: `修改成功!`,
            type: 'warning'
          });
          this.dialogVisible = false;
          this.form.password = '';
        }).catch(err => this.$message({
          message: `修改失败!`,
          type: 'warning'
        }))
      },
      validatePassword(password) {
        let re = /^(?![a-zA-Z]+$)(?![A-Z0-9]+$)(?![A-Z\W_]+$)(?![a-z0-9]+$)(?![a-z\W_]+$)(?![0-9\W_]+$)[a-zA-Z0-9\W_]{8,20}$/;
        return re.test(password); // true
      },
      cancelModifyPassword() {
        this.form.password = '';
        this.dialogVisible = false;
      }
    }
  }
</script>
