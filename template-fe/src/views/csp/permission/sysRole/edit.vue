<!--
 编辑页面
 @author junwei.xiong
 @since 2018-10-23 14:01:47
-->
<template>
  <div class="app-container">
    <el-row>
      <el-col :span="24">
        <el-form ref="form" :rules="rules" :model="formData" label-width="120px">
          <el-row></el-row>
          <el-row :gutter="20">
            <el-col :span="12">
              <el-form-item label="所属分组" prop="parentName">
                <el-input v-model="formData.parentName" type="textarea" autosize :disabled="true"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="角色名称" prop="roleName">
                <el-input v-model="formData.roleName" type="textarea" autosize></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="角色代码" prop="roleCode">
                <el-input v-model="formData.roleCode" type="textarea" autosize></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="理想角色code" prop="extCode">
                <el-input v-model="formData.extCode" type="textarea" autosize></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="描述" prop="description">
                <el-input v-model="formData.description" type="textarea" autosize></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
      </el-col>
      <el-col :offset="1">
        <slot name="buttonsSlot">
          <el-button type="primary" @click="submitForm('form')">提交</el-button>
          <el-button @click="resetForm('form')">重置</el-button>
          <router-link :to="{ name: `sysRoleList` }">
            <el-button>返回</el-button>
          </router-link>
        </slot>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import api from '@/api/csp/permission/sysRole';

  export default {
    data() {
      return {
        formData: {
          autoId: '',
          roleName: '',
          roleCode: '',
          extCode: '',
          type: '',
          strategy: '',
          parentId: '',
          parentName: '',
          description: '',
          createTime: '',
          updateTime: ''
        },
        rules: {
          roleName: [{required: true, message: '请输入角色名称', trigger: 'blur'}, {max: 50, message: '长度小于50个字符'}]
          , roleCode: [{max: 50, message: '长度小于50个字符'}]
          , extCode: [{max: 18, message: '长度小于18个字符'}]
          , description: [{max: 200, message: '长度小于200个字符'}]
        },
        dictTypes:
          []
        , strategyList:
          [{
            value: 1,
            label: '多选'
          }, {
            value: 2,
            label: '单选'
          }]
      }
    },
    created() {
      let autoId = this.$route.query.autoId;
      let parentId = this.$route.query.parentId;
      this.loadData(autoId, parentId);
    },
    methods: {
      loadData(autoId, parentId) {
        api.getRole(autoId, parentId).then(response => this.formData = response.re);
      },
      resetForm(formName) {
        this.$confirm('确定要重置吗?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
          center: true
        }).then(() => {
          let parentName = this.formData.parentName;
          this.$refs[formName].resetFields()
          this.formData.parentName = parentName;
        })
      },
      submitForm(formName) {
        this.$refs[formName].validate(valid => {
          if (valid) {
            api.saveSysRole(this.formData).then(response => {
              this.$message({
                message: `操作成功!`,
                type: 'warning'
              });
              this.$router.push(`sysRoleList`);
            }).catch(err => {})
          }
        })
      }
    }
  }
</script>
