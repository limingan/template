<template>
  <div class="app-container">
    <el-row>
      <el-col :span="24">
        <el-form ref="form" :rules="rules" :model="formData" label-width="120px" :disabled="formDisabled">
          <el-row :gutter="20">
            <el-col :span="12">
              <el-form-item label="目录英文名" prop="name">
                <el-input v-model="formData.name"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="目录中文名" prop="nameCh">
                <el-input v-model="formData.nameCh"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">

              <el-form-item label="父菜单" prop="parentId">
                <el-popover
                  placement="right"
                  width="400"
                  trigger="click">
                  <el-tree
                    :data="props"
                    node-key="id"
                    :props="defaultProps"
                    @node-click="handleNodeClick">
                  </el-tree>
                  <el-button slot="reference" type="primary">{{formData.parentName}}</el-button>
                </el-popover>

              </el-form-item>
            </el-col>

            <el-col :span="12">

              <el-form-item label="meta" prop="meta">
                <el-popover
                  placement="bottom"
                  width="600"
                  trigger="click">

                  <el-form :model="keyValueForm" ref="keyValueForm" label-width="120px" class="demo-dynamic">
                    <el-form-item
                      v-for="(domain, index) in keyValueForm.domains"
                      :label="'key-value' + index"
                      :key="domain.key"
                      :prop="'domains.' + index + '.value'"
                      :rules="[
      { required: true, message: '请输入key-value', trigger: 'blur' },
      { pattern :regularExpression, message: '请输入正确的key-value格式 如：'+tips, trigger: ['blur', 'change']
    }]">
                      <el-input v-model="domain.value" style="width:300px;margin-right:10px;"  ></el-input>

                      <el-button @click.prevent="removeDomain(domain)" >删除</el-button>
                    </el-form-item>
                    <el-form-item>
                      <el-button type="primary" @click="submitForm('keyValueForm')">确定</el-button>
                      <el-button @click="addDomain">新增key-value</el-button>
                      <el-button @click="resetForm('keyValueForm')">重置</el-button>
                    </el-form-item>
                  </el-form>

                  <el-button slot="reference"  type="primary">{{formData.meta}}</el-button>
                </el-popover>

              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="目录路径" prop="path">
                <el-input v-model="formData.path"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="vue组件" prop="component">
                <el-input v-model="formData.component"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="重定向" prop="redirect">
                <el-input v-model="formData.redirect"></el-input>
              </el-form-item>
            </el-col>

            <el-col :span="12">
              <el-form-item label="是否隐藏">
                <el-radio-group v-model="formData.hidden">
                  <el-radio-button :label="0">否</el-radio-button>
                  <el-radio-button :label="1">是</el-radio-button>
                </el-radio-group>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
      </el-col>
      <el-col :offset="1">
        <el-button type="primary" @click="submitForm('form')" v-if="!formDisabled">提交</el-button>
        <el-button @click="resetForm('form')" v-if="!formData.id">重置</el-button>
        <router-link :to="{ name: 'menuList' }">
          <el-button>返回</el-button>
        </router-link>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import api from '@/api/menu';

  export default {
    data() {
      return {
        title: '新增',
        formDisabled: false,
        formData: {
          id: '',
          name: '',
          nameCh: '',
          component: '',
          parentId: '',
          meta: '',
          icon: '',
          redirect: '',
          hidden: '',
          parentName: ''
        },
        regularExpression:/\"[A-Za-z0-9]+\":\"[A-Za-z0-9]+\"/,
        tips:'"aa":"aa"',
        props: [{
          id: '',
          label: '',
          children: ''
        }],
        defaultProps: {
          children: 'children',
          label: 'label'
        },
        pram: {
          pageIndex: '',
          pageNo: ''
        },
        keyValueForm: {
          domains: [{
            value: ''
          }],
          email: ''
        },

        rules: {

          name: [
            { required: true, message: '请输入目录英文名', trigger: 'blur' }
          ],
          nameCh: [
            {required: true, message: '请输入目录中文名', trigger: 'blur'}
          ],
          component: [
            {required: true, message: '请输入vue组件', trigger: 'blur'}
          ],
          meta: [
            {required: true, message: '请输入meta', trigger: 'blur'}
          ],
          path: [
            {required: true, message: '请输入目录路径', trigger: 'blur'}
          ],
          hidden: [
            {required: true, message: '请选择是否隐藏', trigger: 'blur'}
          ],
        }
      }
    },
    mounted() {
    },
    created() {
      let id = this.$route.params['id'];
      console.log(id);
      if (id) {
        const curRoutName = this.$route.name;
        curRoutName.endsWith("View") && (this.formDisabled = true);
        curRoutName.endsWith("Edit") && (this.title = "修改");
        api.getMenu(id).then(response => this.formData = response.re);
      }
      api.getTreeListNameCh().then(response => {
        this.props = response.re
      });

    },
    methods: {

      handleNodeClick(data) {
        this.formData.parentId = data.id
        this.formData.parentName = data.label
      },

      submitForm(formName) {
        if (formName == "keyValueForm") {
          this.$refs[formName].validate((valid) => {
            if (valid) {
              let str = "";
              for (let i = 0; i < this.keyValueForm.domains.length; i++) {
                str = str + this.keyValueForm.domains[i].value + ",";
              }
              this.formData.meta = "{" + str.substr(0, str.length - 1) + "}";
            }
          });
        } else if (formName == "form") {
          this.$refs[formName].validate((valid) => {
            if (valid) {
              api.saveMenu(this.formData).then(response => {
                this.$message({
                  message: `${this.title}成功!`,
                  type: 'warning'
                })
                this.$router.push('menuList')
              }).catch(err => this.$message({
                message: `${this.title}失败!`,
                type: 'warning'
              }))
            }
          })
        }

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

      removeDomain(item) {
        var index = this.keyValueForm.domains.indexOf(item)
        if (index !== 0) {
          this.keyValueForm.domains.splice(index, 1)
        }
      },
      addDomain() {
        this.keyValueForm.domains.push({
          value: '',
          key: Date.now()
        });
      }

    }
  }
</script>
