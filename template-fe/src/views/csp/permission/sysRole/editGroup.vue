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
              <el-form-item label="分组名称" prop="roleName">
                <el-input v-model="formData.roleName" type="textarea" autosize></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="分组策略" prop="strategy">
                <el-select v-model="formData.strategy" filterable placeholder="请选择策略">
                  <el-option
                    v-for="item in strategyList"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="描述" prop="description" type="textarea" autosize>
                <el-input v-model="formData.description"></el-input>
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
          strategy: 1,
          parentId: '',
          description: '',
          createTime: '',
          updateTime: ''
        },
        rules: {
          roleName: [{required: true, message: '请输入分组名称', trigger: 'blur'}, {max: 50, message: '长度小于50个字符'}]
          , description: [{max: 200, message: '长度小于200个字符'}]
        },
        dictTypes: []
        , strategyList: [{
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
      if (autoId) {
        this.loadData(autoId);
      }
    },
    methods: {
      loadData(autoId) {
        api.getSysRole(autoId).then(response => this.formData = response.re);
      },
      resetForm(formName) {
        this.$confirm('确定要重置吗?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
          center: true
        }).then(() => {
          this.$refs[formName].resetFields()
        })
      },
      submitForm(formName) {
        this.$refs[formName].validate(valid => {
          if (valid) {
            api.saveSysRole(this.formData).then(response => {
              this.$message({
                message: `修改成功!`,
                type: 'warning'
              });
              this.$router.push(`sysRoleList`);
            }).catch(err => this.$message({
              message: `${this.title}失败!`,
              type: 'warning'
            }))
          }
        })
      }
    }
  }
</script>
