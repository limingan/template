<!--
 编辑页面
 @author junwei.xiong
 @since 2018-09-27 17:07:36
-->
<template>
  <div class="app-container">
    <el-row>
      <el-col :span="24">
        <el-form ref="form" :rules="rules" :model="formData" label-width="120px">
          <el-row></el-row>
          <el-row :gutter="20">
            <el-col :span="12">
              <el-form-item label="父菜单名称" prop="parentName">
                <el-input v-model.trim="formData.parentName" type="textarea" autosize :disabled="true"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="菜单名称" prop="menuName">
                <el-input v-model.trim="formData.menuName" type="textarea" autosize></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="菜单链接" prop="menuUrl">
                <el-input v-model.trim="formData.menuUrl" type="textarea" autosize></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="描述" prop="description">
                <el-input v-model.trim="formData.description" type="textarea" autosize></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
      </el-col>
      <el-col :offset="1">
        <slot name="buttonsSlot">
          <el-button type="primary" @click="submitForm('form')">提交</el-button>
          <el-button @click="resetForm('form')">重置</el-button>
          <router-link :to="{ name: `sysMenuList` }">
            <el-button>返回</el-button>
          </router-link>
        </slot>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import api from '@/api/csp/permission/sysMenu';

  export default {
    data() {
      return {
        formData: {
          autoId: '',
          parentId: '',
          parentName: '',
          menuName: '',
          menuUrl: '',
          description: ''
        },
        rules: {
          menuName: [{required: true, message: '请输入菜单名称', trigger: 'blur'}
            , {max: 50, message: '长度小于50个字符'}]
          , menuUrl: [{max: 100, message: '长度小于100个字符'}]
          , description: [{max: 200, message: '长度小于200个字符'}]
        }
      }
    },
    created() {
      let autoId = this.$route.query.autoId;
      let parentId = this.$route.query.parentId;
      this.loadData(autoId, parentId);
    },
    methods: {
      loadData(autoId, parentId) {
        api.getSysMenu(autoId, parentId).then(response => this.formData = response.re);
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
            // this.api[`save${this.domainName}`](this.formData).then(response => {
            api.saveSysMenu(this.formData).then(response => {
              this.$message({
                message: `操作成功!`,
                type: 'warning'
              });
              this.$router.push(`sysMenuList`);
            }).catch(err => this.$message({
              message: `操作失败!`,
              type: 'warning'
            }))
          }
        })
      }
    }
  }
</script>
