<!--
 CRUD编辑页面基础组件
 @author ZhangBei
 @since 2018-07-18 08:41:45
-->
<template>
  <div class="app-container">
    <el-row>
      <el-col :span="24">
        <el-form ref="form" :rules="rules" :model="formData" label-width="120px" :disabled="formDisabled">
          <slot name="eidtSlot" :formData="formData" :dictDetailList="dictDetailList" :operateMode="operateMode"></slot>
        </el-form>
      </el-col>
      <el-col :offset="1">
        <slot name="buttonsSlot">
          <el-button type="primary" @click="submitForm('form')" v-if="!formDisabled">提交</el-button>
          <el-button @click="resetForm('form')" v-if="!formData.id">重置</el-button>
          <router-link :to="{ name: `${this.domainname}List` }">
            <el-button>返回</el-button>
          </router-link>
        </slot>
      </el-col>
    </el-row>
  </div>
</template>
<script>
  import dictApi from '@/api/dict';

  export default {
    name: 'crudedit',
    props: {
      api: {
        type: Object,
        default: null
      },
      rules: {
        type: Object,
        default: {}
      },
      domainName: {
        type: String,
        default: null
      },
      formDataEx: {
        type: Object,
        default: {}
      },
      dictTypes : {
        type: Array,
        default: []
      }
    },
    data() {
      return {
        title: '新增'
        , operateMode: 'add'
        , formDisabled: false,
        formData: this.formDataEx
        , dictDetailList: []
        , domainname: this.domainName.slice(0, 1).toLowerCase() + this.domainName.slice(1)
      }
    },
    created() {
      let id = this.$route.params['id'];
      if (id) {
        const curRoutName = this.$route.name;
        if (curRoutName.endsWith("View")) {
          this.formDisabled = true;
          this.operateMode = 'view';
          this.title = "查看";
        } else {
          this.operateMode = 'edit';
          this.title = "修改"
        }
        this.api[`get${this.domainName}`](id).then(response => this.formData = response.re);
      }
      this.dictTypes.length && dictApi.getDictDetailListByParentIds(this.dictTypes).then(res => {
        res.data.code === 0 && (this.dictDetailList = res.data.page.list);
      });
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate(valid => {
          if (valid) {
            this.api[`save${this.domainName}`](this.formData).then(response => {
              this.$message({
                message: `${this.title}成功!`,
                type: 'warning'
              });
              this.$router.push(`${this.domainname}List`);
            }).catch(err =>{})
          }
        })
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
    }
  }
</script>
