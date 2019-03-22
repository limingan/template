<!--
 CRUD列表页面基础组件
 @author ZhangBei
 @since 2018-07-18 08:41:45
-->
<template>
  <div class="app-container">
    <el-row :gutter="20">
      <el-form :inline="true" :model="queryParam">
        <slot name="querySlot" :queryParam="queryParam" :dictDetailList="dictDetailList"></slot>
        <slot name="buttonsSlot" :domainname="domainname" :dictDetailList="dictDetailList">
          <el-form-item>
            <el-button type="primary" icon="el-icon-search" @click="search('btn')" v-if="enaQueryBtn">查询</el-button>
            <router-link :to="addRouterUrl">
              <el-button type="primary" icon="el-icon-plus" v-show="hasPerms(this.perms.save)" v-if="enaAddBtn">新增
              </el-button>
            </router-link>
            <el-button type="primary" icon="el-icon-edit" @click="edit" v-show="hasPerms(this.perms.update)"
                       v-if="enaUpdateBtn">编辑
            </el-button>
            <el-button type="primary" icon="el-icon-delete" @click="del" v-show="hasPerms(this.perms.delete)"
                       v-if="enaDeleteBtn">删除
            </el-button>
          </el-form-item>
        </slot>
      </el-form>
    </el-row>
    <el-row :gutter="20">
      <el-table :data="list"
                v-loading.body="listLoading"
                element-loading-text="Loading"
                border
                fit
                highlight-current-row
                @sort-change='sortChange'
                @selection-change="handleSelectionChange">
        <slot name="tableColumnSlot"></slot>
      </el-table>
      <!--<el-pagination-->
      <!--background-->
      <!--layout="prev, pager, next"-->
      <!--:total="total"-->
      <!--@current-change="handleCurrentChange"-->
      <!--@select="handleCurrentSelect">-->
      <!--</el-pagination>-->

      <el-pagination layout="total, sizes, prev, pager, next, jumper" background
                     @size-change="handleSizeChange"
                     @current-change="handleCurrentChange"
                     :current-page="queryParam.pageIndex"
                     :page-size="queryParam.pageSize"
                     :total="total"
                     :page-sizes="[10, 20, 50, 100]"
      >
      </el-pagination>
    </el-row>
  </div>
</template>

<script>
  import dictApi from '@/api/dict';
  import permUtils from '@/api/perms';

  export default {
    name: 'crudlist',
    props: {
      api: {
        type: Object,
        default: null
      },
      domainName: {
        type: String,
        default: null
      },
      queryParamEx: {
        type: Object,
        default: {}
      },
      dictFields: {
        type: Array,
        default: []
      },
      dictTypes: {
        type: Array,
        default: []
      },
      parentRefs: {
        type: Object,
        default: {}
      },
      perms: {
        type: Object,
        default: {}
      },
      enaQueryBtn: {
        type: Boolean,
        default: true
      },
      enaAddBtn: {
        type: Boolean,
        default: true
      },
      enaDeleteBtn: {
        type: Boolean,
        default: true
      },
      enaUpdateBtn: {
        type: Boolean,
        default: true
      },
      addRouterUrl: {
        type: Object,
        default: null
      }
    },
    data() {
      return {
        list: [],
        domainname: this.domainName.slice(0, 1).toLowerCase() + this.domainName.slice(1),
        listLoading: true,
        multipleSelection: [],
        queryParam: Object.assign({
          pageIndex: 1
          , pageSize: 10
        }, this.queryParamEx),
        total: 0
        , dictDetailList: []
        , currentPageRows: ''
      };
    },
    /**钩子函数**/
    created() {
      this.dictTypes.length && dictApi.getDictDetailListByParentIds(this.dictTypes).then(res => {
        if (res.data.code === 0) {
          this.dictMap = {};
          this.dictDetailList = res.data.page.list;
          this.dictDetailList.forEach(item => this.dictMap[item.id] = item);
        }
      });
      this.search();
    },
    mounted() {
      this.clearNumberInputsDefaultValue();
    },
    methods: {
      hasPerms: permUtils.hasPerms,
      /*切换页面*/
      handleCurrentChange(v) {
        this.queryParam.pageIndex = v
        this.search()
      },
      handleSelectionChange(val) {
        this.checkLintArray = val
      },
      handleSizeChange(val) {
        this.queryParam.pageSize = val
        this.search()
      },
      handleCurrentSelect(selection, row) {
        console.log(selection)
      },
      clearNumberInputsDefaultValue() {
        for (let fiedItem in this.parentRefs) {
          if (this.parentRefs[fiedItem].$refs && this.parentRefs[fiedItem].input && this.parentRefs[fiedItem].$refs.input.$emit)
            this.parentRefs[fiedItem].$refs.input.$emit('change', '');
        }
      },
      del(id) {
        id = id || this.queryCheckLine()


        if (id) {
          this.$confirm('确定要删除吗?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning',
            center: true
          }).then(() => {
            this.api[`delete${this.domainName}`](id).then(response => {
              this.$message({
                message: '删除成功!',
                type: 'warning'
              });
              if (this.currentPageRows === 1 && this.queryParam.pageIndex > 1) {
                let pageIndex = this.queryParam.pageIndex - 1;
                this.queryParam.pageIndex = pageIndex;
              }
              this.search()
            })
          }).catch(() => {
          })
        }
      },
      edit(id) {
        id = id || this.queryCheckLine()
        if (id) {
          this.$router.push({name: `${this.domainname}Edit`, params: {id: id}});
        }
      },
      initDict() {
        if (this.dictFields.length) {
          this.list.forEach(item => {
            this.dictFields.forEach(dictFied => {
              if (this.dictMap[item[dictFied]]) {
                item[dictFied] = this.dictMap[item[dictFied]].title;
              }
            });
          });
        }
      },
      search(btn) {
        if (btn) {
          this.queryParam.pageIndex = 1;
        }
        this.listLoading = true;
        this.api[`get${this.domainName}List`](this.queryParam)
          .then((data) => {
            if ((null === data.re.rows || data.re.rows.length < 1) && data.re.total > 0) {
              this.queryParam.pageIndex = data.re.page;
              this.search();
            } else {
              this.list = data.re.rows;
              this.total = data.re.total;
              this.initDict();
              this.currentPageRows = this.list.length;
              this.listLoading = false;
            }
          })
      },
      createNotice() {
        this.$router.push({path: '/person/create', query: {isEdit: false}})
      },
      sortChange(column, prop, order) {
        this.queryParam.propParameter = column.prop;
        this.queryParam.sortMethod = column.order;
        this.listLoading = true;
        console.log(column + '-' + column.prop + '-' + column.order)
        this.api[`get${this.domainName}List`](this.queryParam)
          .then((data) => {
            this.list = data.re.rows;
            this.total = data.re.total;
            this.listLoading = false;
            this.initDict();
          })
      },
      queryCheckLine() {
        if (this.checkLintArray == null || this.checkLintArray.length <= 0) {
          this.$message({
            message: '请选中一行数据!',
            type: 'warning'
          })
          return false
        }
        this.checkLintArray.forEach(element => {
          console.log(element)
        })
        if (this.checkLintArray.length === 1) {
          var id = this.checkLintArray[0].autoId
          return id;
        } else if (this.checkLintArray.length > 1) {
          this.$message({
            message: '请有且仅有一行数据被选中!',
            type: 'warning'
          })
          return false
        }
      }
    }
  }
</script>

<style scoped>
  .hamburger {
    display: inline-block;
    cursor: pointer;
    width: 20px;
    height: 20px;
    transform: rotate(90deg);
    transition: .38s;
    transform-origin: 50% 50%;
  }

  .hamburger.is-active {
    transform: rotate(0deg);
  }
</style>
