<!--
 编辑页面
 @author junwei.xiong
 @since 2018-10-08 18:10:13
-->
<template>
  <CrudEdit :api="api" :rules="rules" domainName="SysEmployee" :formDataEx="formData" :dictTypes="dictTypes">
    <template slot-scope="scope" slot="eidtSlot">
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="姓名" prop="name">
            <el-input v-model.trim="scope.formData.name"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="手机" prop="telephone">
            <el-input v-model.trim="scope.formData.telephone"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item label="邮箱" prop="loginId">
            <el-input v-model.trim="scope.formData.loginId"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="6">
          @<el-select v-model="scope.formData.domain" filterable>
            <el-option
              v-for="item in domainList"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-col>
        <el-col :span="12">
          <el-form-item label="工号" prop="workNo">
            <el-input v-model.trim="scope.formData.workNo"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="分机" prop="extensionNumber">
            <el-input v-model.trim="scope.formData.extensionNumber"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="编号" prop="number">
            <el-input v-model.trim="scope.formData.number"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="性别" prop="gender">
            <el-select v-model="scope.formData.gender" filterable placeholder="请选择性别">
              <el-option
                v-for="item in genderList"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="状态" prop="status">
            <el-select v-model="scope.formData.status" filterable placeholder="请选择状态">
              <el-option
                v-for="item in statusList"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="描述" prop="description" type="textarea" autosize>
            <el-input v-model.trim="scope.formData.description"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
    </template>
  </CrudEdit>
</template>

<script>
  import api from '@/api/csp/permission/sysEmployee';
  import CrudEdit from '@/components/CrudEdit';

  export default {
    components: {CrudEdit},
    data() {
      return {
        api: api
        , formData: {
          autoId: '',
          deptId: '',
          number: '',
          name: '',
          loginId: '',
          telephone: '',
          gender: '',
          email: '',
          workNo: '',
          extensionNumber: '',
          password: '',
          description: '',
          status: 1,
          isDeleted: '',
          createTime: '',
          updateTime: '',
          domain: 'ucarinc.com'
        },
        rules: {
          number: [{
            pattern: /^[1-9]\d{7}$/,
            message: '只能输入首位不为0的8位纯数字'
          }]
          , name: [{
            required: true,
            message: '请输入员工姓名',
            trigger: 'blur'
          }, {
            min: 2,
            max: 50,
            message: '长度在 2 到 50 个字符'
          }]
          , telephone: [{
            required: true,
            message: '请输入手机号码',
            trigger: 'blur'
          }, {
            validator: function (rule, value, callback) {
              if (/^1[34578]\d{9}$/.test(value) == false) {
                callback(new Error("请输入正确的手机号"));
              } else {
                callback();
              }
            }, trigger: 'blur'
          }
          ]
          , loginId: [{required: true, message: '请输入邮箱', trigger: 'blur'}, {
            max: 50,
            message: '长度控制在 50 个字符内'
          }]
          , workNo: [{required: true, message: '请输入账号', trigger: 'blur'},
            , {
              pattern: /^[1-9][0-9]{3,5}$/,
              message: '只能输入首位不为0的4到6位纯数字'
            }
          ]
          , extensionNumber: [{required: true, message: '请输入分机号', trigger: 'blur'},
            , {
              pattern: /^[1-9][0-9]{3,5}$/,
              message: '只能输入4到6位纯数字'
            }
          ]
          , description: [{max: 200, message: '长度小于200个字符'}]
        }
        , statusList: [{
          value: 1,
          label: '在职'
        }, {
          value: 2,
          label: '离职'
        }]
        , genderList: [{
          value: 1,
          label: '男'
        }, {
          value: 2,
          label: '女'
        }]
        , domainList: [{
          value: 'ucarinc.com',
          label: 'ucarinc.com'
        }, {
          value: 'zuche.com',
          label: 'zuche.com'
        }, {
          value: 'luckincoffee.com',
          label: 'luckincoffee.com'
        }, {
          value: 'lucky.com',
          label: 'lucky.com'
        }]
        , dictTypes: []
      }
    }
  }
</script>
