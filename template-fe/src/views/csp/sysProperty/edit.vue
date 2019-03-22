<!--
 系统配置表编辑页面
 @author junwei.xiong
 @since 2018-10-25 10:16:39
-->
<template>
  <CrudEdit :api="api" :rules="rules" domainName="SysProperty" :formDataEx="formData" :dictTypes="dictTypes">
    <template slot-scope="scope" slot="eidtSlot">
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="配置项名称" prop="propertyName">
            <el-input v-model="scope.formData.propertyName"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="配置项值" prop="propertyValue">
            <el-input v-model="scope.formData.propertyValue"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="配置项说明" prop="description">
            <el-input v-model="scope.formData.description"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
    </template>
  </CrudEdit>
</template>

<script>
  import api from '@/api/csp/sysProperty';
  import CrudEdit from '@/components/CrudEdit';

  export default {
    components: {CrudEdit},
    data() {
      return {
        api: api
        , formData: {
          autoId: '',
          propertyName: '',
          propertyValue: '',
          description: ''
        },
        rules: {
          propertyName: [{required: true, message: '请输入配置项名称', trigger: 'blur'}]
          , propertyValue: [{required: true, message: '请输入配置项值', trigger: 'blur'}]

        },
        dictTypes: []
      }
    }
  }
</script>
