<template>
  <div class="app-container">
    <el-form :inline="true" :model="formQuery" class="demo-form-inline">
        <el-form-item label="帖子标题">
            <el-input v-model="formQuery.bbsName" placeholder="帖子标题"></el-input>
        </el-form-item>
        <el-form-item label="标签名称">
            <el-input v-model="formQuery.labelName" placeholder="标签名称"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="onSubmit">查询</el-button>
        </el-form-item>
    </el-form>
    <el-table :data="userItems" v-loading="listLoading" element-loading-text="Loading" border fit highlight-current-row>
      <el-table-column align="center" label='ID' width="95">
        <template slot-scope="scope">
            {{scope.$index + 1}}
        </template>
      </el-table-column>
      <el-table-column label="标签" width="110">
        <template slot-scope="scope">
            {{scope.row.label}}
        </template>
      </el-table-column>
      <el-table-column label="类型" width="110" align="nickName">
        <template slot-scope="scope">
            <span>{{scope.row.type}}</span>
        </template>
      </el-table-column>
      <el-table-column label="发帖时间" width="110" align="role">
        <template slot-scope="scope">
            {{scope.row.createTime}}
        </template>
      </el-table-column>
      <el-table-column label="帖子标题" align="role">
        <template slot-scope="scope">
            {{scope.row.bbsName}}
        </template>
      </el-table-column>
      <el-table-column label="查看人数" width="110" align="role">
        <template slot-scope="scope">
            {{scope.row.lookNum}}
        </template>
      </el-table-column>
      <el-table-column label="收藏人数" width="110" align="role">
        <template slot-scope="scope">
            {{scope.row.favoriteNum}}
        </template>
      </el-table-column>
      <el-table-column label="评论总数" width="110" align="role">
        <template slot-scope="scope">
            {{scope.row.commentNum}}
        </template>
      </el-table-column>
      <el-table-column label="操作" width="200" align="operator">
          <template slot-scope="scope">
            <el-button type="primary" @click="clickSettingBBS" >设置</el-button>
            <el-button type="primary" @click="settingCommentDialogVisible=true" >评论</el-button>
          </template>
      </el-table-column>
    </el-table>
    <el-pagination background layout="prev, pager, next" :total="12"> </el-pagination>
    <!-- 评论设置模态窗 -->
    <el-dialog title="评论设置" :visible.sync="settingCommentDialogVisible" width="50%">
      <el-form :inline="true" ref="form" label-width="80px">
        <el-form-item label="评论楼层">
          <el-input v-model="formQuery.homeNum" placeholder="评论楼层"></el-input>
        </el-form-item>
        <el-form-item label="评论内容">
          <el-input v-model="formQuery.comment" placeholder="评论内容"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">查询</el-button>
        </el-form-item>
      </el-form>
      <el-table :data="commentItems" v-loading="listLoading" element-loading-text="Loading" border fit highlight-current-row>
        <el-table-column align="center" label='ID' width="95">
          <template slot-scope="scope">
              {{scope.$index + 1}}
          </template>
        </el-table-column>
        <el-table-column label="楼层" width="110">
          <template slot-scope="scope">
              {{scope.row.homeNum}}
          </template>
        </el-table-column>
        <el-table-column label="评论者" width="110" align="nickName">
          <template slot-scope="scope">
              <span>{{scope.row.operator}}</span>
          </template>
        </el-table-column>
        <el-table-column label="评论时间" width="110" align="role">
          <template slot-scope="scope">
              {{scope.row.createTime}}
          </template>
        </el-table-column>
        <el-table-column label="评论内容" align="role">
          <template slot-scope="scope">
              {{scope.row.comment}}
          </template>
        </el-table-column>
        <el-table-column label="操作" width="200" align="operator">
          <template slot-scope="scope">
            <el-button type="primary" @click="clickSettingBBS" >删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-pagination background layout="prev, pager, next" :total="999"></el-pagination>
    </el-dialog>
  </div>
</template>

<script>

export default {
  data() {
    return {
      listLoading: true,
      settingCommentDialogVisible: false,
      formQuery: {
        homeNum: '',
        comment: ''
      },
      userItems: [{
        'label': '团建活动',
        'type': '精华',
        'createTime': '2018-07-24 13:00:23',
        'operator': 'xx@qq.com',
        'bbsName': '发一个帖子',
        'lookNum': '999',
        'favoriteNum': '20',
        'commentNum': '100'
      },
      {
        'label': '团建活动',
        'type': '精华',
        'createTime': '2018-07-24 13:00:23',
        'operator': 'xx@qq.com',
        'bbsName': '发一个帖子',
        'lookNum': '999',
        'favoriteNum': '20',
        'commentNum': '100'
      },
      {
        'label': '团建活动',
        'type': '精华',
        'createTime': '2018-07-24 13:00:23',
        'operator': 'xx@qq.com',
        'bbsName': '发一个帖子',
        'lookNum': '999',
        'favoriteNum': '20',
        'commentNum': '100'
      },
      {
        'label': '团建活动',
        'type': '精华',
        'createTime': '2018-07-24 13:00:23',
        'operator': 'xx@qq.com',
        'bbsName': '发一个帖子',
        'lookNum': '999',
        'favoriteNum': '20',
        'commentNum': '100'
      },
      {
        'label': '团建活动',
        'type': '精华',
        'createTime': '2018-07-24 13:00:23',
        'operator': 'xx@qq.com',
        'bbsName': '发一个帖子',
        'lookNum': '999',
        'favoriteNum': '20',
        'commentNum': '100'
      }],
      commentItems: [{
        homeNum: '1',
        createTime: '2018-07-09 22:40:34',
        operator: 'xxxxxxxxxxxxx',
        comment: '赞赞赞赞赞赞赞赞赞赞~~~~~~~~~~'
      },
      {
        homeNum: '1',
        createTime: '2018-07-09 22:40:34',
        operator: 'xxxxxxxxxxxxx',
        comment: '赞赞赞赞赞赞赞赞赞赞~~~~~~~~~~'
      },
      {
        homeNum: '1',
        createTime: '2018-07-09 22:40:34',
        operator: 'xxxxxxxxxxxxx',
        comment: '赞赞赞赞赞赞赞赞赞赞~~~~~~~~~~'
      },
      {
        homeNum: '1',
        createTime: '2018-07-09 22:40:34',
        operator: 'xxxxxxxxxxxxx',
        comment: '赞赞赞赞赞赞赞赞赞赞~~~~~~~~~~'
      },
      {
        homeNum: '1',
        createTime: '2018-07-09 22:40:34',
        operator: 'xxxxxxxxxxxxx',
        comment: '赞赞赞赞赞赞赞赞赞赞~~~~~~~~~~'
      }]
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
    onSubmit() {},
    clickSettingBBS() {
      this.$router.push({ path: '/bbs/bbsSetting', query: { bbsId: '1' }})
    }
  }
}
</script>
