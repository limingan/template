<template>
  <div class="app-container">
    <el-row>
      <el-col :span="4">
        <el-row style="padding-bottom:5px">
          <el-col :span="24">
            <el-button type="primary" icon="el-icon-edit" size="small">新增菜单</el-button>
            <el-button type="primary" icon="el-icon-delete" size="small">删除菜单</el-button>
          </el-col>
        </el-row>
        <el-input placeholder="输入关键字进行过滤" v-model="filterText"> </el-input>
        <el-tree class="filter-tree" :data="menuTree" :props="defaultProps" default-expand-all :filter-node-method="filterNode" ref="tree2"> </el-tree>
      </el-col>
      <el-col :span="20">
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="名称">
            <el-input v-model="form.name"></el-input>
          </el-form-item>
          <el-form-item label="类型">
            <el-select v-model="form.type" placeholder="请选择菜单类型">
              <el-option label="菜单组" value="group"></el-option>
              <el-option label="菜单" value="menu"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="图标">
            <el-input v-model="form.inco"></el-input>
          </el-form-item>
          <el-form-item label="地址">
            <el-input v-model="form.url"></el-input>
          </el-form-item>
          <el-form-item label="父节点">
            <el-select v-model="form.parentId" placeholder="请选择菜单类型">
              <el-option label="会员管理系统" value="userAdmin"></el-option>
              <el-option label="后台管理系统" value="admin"></el-option>
              <el-option label="论坛管理系统" value="bbs"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="状态">
            <el-radio-group v-model="form.status">
              <el-radio label="启用"></el-radio>
              <el-radio label="禁止"></el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="描述">
            <el-input type="textarea" v-model="form.describe"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="onSubmit">提交</el-button>
            <el-button>取消</el-button>
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>
  </div>
</template>

<script>

export default {
  watch: {
    filterText(val) {
      this.$refs.tree2.filter(val)
    }
  },
  data() {
    return {
      listLoading: true,
      filterText: '',
      form: {
        'name': '',
        'url': '',
        'inco': '',
        'parentId': '',
        'status': '',
        'describe': '',
        'type': []
      },
      menuTree: [{
        id: 1,
        label: '会员管理系统',
        children: [{
          id: 2,
          label: '会员管理'
        },
        {
          id: 3,
          label: '会员反馈'
        },
        {
          id: 4,
          label: '类目管理'
        }]
      },
      {
        id: 5,
        label: '管理员管理系统',
        children: [{
          id: 6,
          label: '管理员管理'
        },
        {
          id: 7,
          label: '角色管理'
        },
        {
          id: 8,
          label: '菜单管理'
        }]
      },
      {
        id: 9,
        label: '论坛管理系统',
        children: [{
          id: 10,
          label: '标签管理'
        },
        {
          id: 11,
          label: '帖子管理'
        },
        {
          id: 12,
          label: '公告管理'
        }]
      }],
      defaultProps: {
        children: 'children',
        label: 'label'
      }
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.listLoading = true
      this.listLoading = false
    },
    filterNode(value, data) {
      if (!value) return true
      return data.label.indexOf(value) !== -1
    },
    onSubmit() {}
  }
}
</script>
