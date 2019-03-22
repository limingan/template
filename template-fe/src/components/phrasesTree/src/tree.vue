<template>
  <div>
    <el-dialog
      title="确认要删除此项吗？"
      :visible.sync="delDialogVisible"
      width="30%"
      :append-to-body="true">

      <span slot="footer">
        <el-button
          size="small"
          @click="delDialogVisible = false">
            取 消
        </el-button>
        <el-button
          size="small"
          type="primary"
          @click="delSelect">
            确 定
        </el-button>
      </span>
    </el-dialog>

    <el-row>
      <div class="ly-tree-container">
        <div style="width: 30%">
          <el-input
            placeholder="输入关键字进行过滤"
            v-model="filterText">
          </el-input>
        </div>
        <el-tree
          default-expand-all
          v-loading="loading"
          :data="treeData"
          :props="defaultProps"
          :expand-on-click-node="false"
          ref="tree2"
          :filter-node-method="filterNode"
          :render-content="renderContent">
        </el-tree>
      </div>
    </el-row>
  </div>
</template>

<script>
  import request from '@/utils/request'
  import {
    getEditContent,
    getDefaultContent
  } from './tree.utils.js'
  import './tree.scss'
  export function getTree(workId) {
    return request({
      url: '/api/cmsphrases/getTree.do_',
      headers: {
        'content-type': 'application/json'
      },
      method: 'post',
      data: workId
    })
  }
  export function delItem(data, payload){
    for(let i = 0; i < data.length; i++) {
      if (data[i].autoid === payload.id) {
        deleteNode(payload.id)
        data.splice(i, 1)
        break
      }
      if (data[i].child && data[i].child.length) {
        delItem(data[i].child, payload)
      }
    }
  }
  export function deleteNode(nodeId) {
    return request({
      url: '/api/cmsphrases/delete/' + nodeId + '.do_',
      method: 'get'
    })
  }
  export function saveNode(node) {
    return request({
      url: '/api/cmsphrases/save.do_',
      headers: {
        'content-type': 'application/json'
      },
      method: 'post',
      data: node
    })
  }
  export function updateNode(node) {
    return request({
      url: '/api/cmsphrases/update.do_',
      headers: {
        'content-type': 'application/json'
      },
      method: 'post',
      data: node
    })
  }

  export default {
    name: 'ly-tree',
    watch: {
      filterText(val) {
        this.$refs.tree2.filter(val);
      }
    },
    data() {
      return {
        loading:true,
        filterText: '',
        treeData: [{
          "level":0,
          "autoid": 0,
          "pid": -1,
          "name": "常用语管理",
          "type": 0,
          "child":[]
        }],
        isEdit: false,
        edit_name: '',
        is_superuser: 'False',
        defaultProps: {
          children: 'child',
          label: 'name'
        },
        select_id: null,
        select_level: null,
        select_node: null,
        delDialogVisible: false,
        dataNode: {
          autoid:'',
          pid: '',
          name: '',
          status:'active',
          workid:'1111',
          type:''
        },
        workId:{
          workid:'1111'
        }
      }
    },

    created () {
      this.refresh()
    },

    methods: {
      refresh() {
        var s=[];
        getTree(this.workId).then(response => {
          // var newDate=this.changeNull(response.re)
          this.treeData[0].child = response.re
          this.is_superuser = true
          this.loading=false
        })
        // this.treeData.children = res.re
        // console.log(  this.treeData)
      },
      changeNull(arr) {
        for(var j = 0,len = arr.length; j < len; j++){
          if(arr[j].child==null){
            arr[j].child=[];
          }else if(arr[j].child.length>0){
            var arr2=arr[j].child;
            arr2=this.changeNull(arr2)
          }
        }
        return arr;
      },
      filterNode(value, data) {
        if (!value) return true;
        return data.name.indexOf(value) !== -1;
      },
      append(node, data, e) {
        e = event || window.event
        e.stopPropagation()
        if (!this.isEdit) {
          this.select_id = data.id
          this.edit_name = ''
          const newChild = {
            name: '',
            level: data.level + 1,
            isEdit: true
          }
          this.isEdit = true
          if (!data.child) {
            this.$set(data, 'child', [])
          }
          data.child.unshift(newChild)
        } else {
          this.$notify({
            type: 'error',
            title: '操作提示',
            message: '有正在编辑或添加的选项未完成！',
            duration: 2000
          })
        }
      },

      remove(node, data, e) {
        e = event || window.event
        e.stopPropagation()
        if (this.isEdit) {
          this.$notify({
            type: 'error',
            title: '操作提示',
            message: '有正在编辑或添加的选项未完成！',
            duration: 2000
          })
          return
        }
        this.select_node = node
        this.delDialogVisible = true
      },

      delSelect() {
        delItem(this.treeData, {id: this.select_node.data.autoid})
        this.delDialogVisible = false
        this.$notify({
          type: 'success',
          title: '操作提示',
          message: '删除成功!',
          duration: 2000
        })
      },

      update(node, data, e) {
        console.log(data)
        e = event || window.event
        e.stopPropagation()
        if (this.isEdit) {
          this.$notify({
            type: 'error',
            title: '操作提示',
            message: '有正在编辑或添加的选项未完成！',
            duration: 2000
          })
          return
        }
        // this.select_id = data.autoId
        // this.select_level =1
         this.edit_name = data.name
        data.isEdit=true
        this.isEdit=true
      },

       editMsg(data, node, e) {
        if(this.edit_name==null||this.edit_name=="") {
          data.isEdit=false
          data.isEdit=true
          return
        }
        this.loading=true
        let virtualNode = node.parent
        let params = {
          name: this.edit_name,
          autoId: virtualNode.data.autoId
        }
        e = event || window.event
        e.stopPropagation()
        if (this.edit_name.replace(/^\s+|\s+$/g, '')) {
          if(data.autoid==null) {
            this.dataNode.name=this.edit_name
            this.dataNode.pid=virtualNode.data.autoid
            this.dataNode.type=parseInt(virtualNode.data.type)+1;
            saveNode(this.dataNode).then(response =>{
              this.loading=false
              var newData = {
                "autoid": response.re,
                "pid": virtualNode.data.autoid,
                "name": this.edit_name,
                "child": [],
                "type":parseInt(virtualNode.data.type)+1
              }
              virtualNode.data.child.splice(1, 0, newData);
              virtualNode.data.child.splice(0, 1)
              this.$notify({
                type: 'success',
                title: '操作提示',
                message: '添加成功！',
                duration: 2000
              })
            }).catch(() => {
              this.loading = false
            })
          }else{
            this.dataNode.name=this.edit_name
            this.dataNode.pid=virtualNode.data.autoid
            this.dataNode.autoid=data.autoid
            if(this.edit_name!=data.name){
              updateNode(this.dataNode).then(res=>{
                this.loading=false
                this.$notify({
                  type: 'success',
                  title: '操作提示',
                  message: '添加成功！',
                  duration: 2000
                })
              }).catch(() => {
                this.loading = false
              })
            }
            data.name=this.edit_name
            data.isEdit=false
            this.isEdit = false
            this.select_id = null
            this.select_level = null
            this.loading=false
            return
          }
          this.isEdit = false
          this.select_id = null
          this.select_level = null

          return


          }

      },

      close(data, node, e) {
        e = event || window.event
        e.stopPropagation()
        console.log(data)
        if(data.autoid==null){
          node.parent.data.child.splice(0, 1)
        }else{
          data.isEdit=false
        }
        this.select_id = null
        this.select_level = null
        this.edit_name = data.name
        this.isEdit = false
      },

      nameChange(e) {
        e = event || window.event
        e.stopPropagation()
        this.edit_name = e.target.value
      },

      isSelect(data) {
        return data.id === this.select_id
          && data.level === this.select_level
      },

      renderContent(h, { node, data }) {
        return (
          <span class="ly-tree-node">
            {
              (this.isEdit === true && this.isSelect(data)) || data.isEdit
                ? <input
                  placeholder="输入值小于50字符"
                  maxlength="50"
                  ref="mybox"
                  class="ly-edit__text"
                  on-keyup={() => this.nameChange()}
                  value={this.edit_name} />
                : <span>{data.name}</span>
            }
            {
              (this.isEdit === true && this.isSelect(data)) || data.isEdit
                ? getEditContent.call(this, h, data, node)
                : getDefaultContent.call(this, h, data, node)
            }
          </span>)
      }
    }
  }
</script>
