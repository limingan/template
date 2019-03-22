<template>
  <div class="app-container">
    <el-row :gutter="20">
      <el-form :inline="true" :model="queryParam">
        <el-form-item label="目录">
          <el-input v-model="queryParam.nameCh" placeholder="目录中文名/英文名"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="el-icon-search" @click="search">查询</el-button>
          <router-link :to="{ path: 'menuAdd' }">
            <el-button type="primary" icon="el-icon-plus">新增</el-button>
          </router-link>
          <el-button type="primary" icon="el-icon-edit" @click="edit">编辑</el-button>
          <el-button type="primary" icon="el-icon-delete" @click="del">删除</el-button>
        </el-form-item>
      </el-form>
    </el-row>
    <el-row :gutter="20">
      <el-table :data="list"
                v-loading.body="listLoading"
                element-loading-text="Loading"
                border
                fit
                highlight-current-row
                @selection-change="handleSelectionChange">
        <el-table-column
          type="selection"
          width="55">
        </el-table-column>
        <el-table-column align="center" label="目录英文名">
          <template slot-scope="scope">
            <router-link :to="{name: 'menuView', params: {id: scope.row.id}}">
              <el-button type="text">
                {{scope.row.name}}
              </el-button>
            </router-link>
          </template>
        </el-table-column>
        <el-table-column align="center" prop="nameCh" label="目录中文名">
        </el-table-column>
        <el-table-column align="center" prop="parentName" label="父目录">
        </el-table-column>
        <el-table-column align="center" prop="path" label="目录路径">
        </el-table-column>
        <el-table-column align="center" prop="component" label="vue组件">
        </el-table-column>
        <el-table-column align="center" prop="meta" label="meta">
        </el-table-column>
        <el-table-column align="center" prop="redirect" label="重定向">
        </el-table-column>
        <el-table-column align="center" prop="hidden" label="是否隐藏" :formatter="(row, column, value) => value === 0 ? '否':'是'">
        </el-table-column>
      </el-table>
      <el-pagination
        background
        layout="prev, pager, next"
        :total="total"
        @current-change="handleCurrentChange"
        @select="handleCurrentSelect">
      </el-pagination>
    </el-row>
  </div>
</template>

<script>
  import api from '@/api/menu'
  export default {
    data () {
      return {
        list: [],
        listLoading: true,
        multipleSelection: [],
        queryParam: {
          pageIndex: 1,
          pageSize: 10,
          nameCh:''
        },
        total:0
      };
    },
    /**钩子函数**/
    created(){
      this.search();
    },
    methods: {
      /*切换页面*/
      handleCurrentChange(v) {
        this.queryParam.pageIndex = v
        //alert(v)
        this.search()
      },
      handleSelectionChange(val) {
        this.checkLintArray = val
      },
      handleCurrentSelect(selection, row) {
        console.log(selection)
      },
      del() {
        var id = this.queryCheckLine()
        if (id) {
          this.$confirm('确定要删除吗?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning',
            center: true
          }).then(() => {
            api.deleteMenu(id).then(response => {
              this.$message({
                message: '删除成功!',
                type: 'warning'
              })
              this.search()
            })
          })
        }
      },
      edit() {
        const id = this.queryCheckLine();
        if(id)
          this.$router.push({name: 'menuEdit', params : {id: id }});
      },
      search () {
        this.listLoading = true;
        //this.handleCurrentChange(this.queryParam.pageIndex);
        //alert(this.queryParam.pageIndex)
        //alert(JSON.stringify(this.queryParam))
        api.getMenuList(this.queryParam)
          .then((data) => {
            this.queryParam.pageIndex = data.pageIndex;
            this.list = data.re.rows;
            this.total=data.re.total;
            this.listLoading = false
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
          var id = this.checkLintArray[0].id
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
