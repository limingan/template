<!--
 系统配置表列表页
 @author junwei.xiong
 @since 2018-10-25 10:16:39
-->
<template>
  <CrudList ref="cp" :api="api" domainName="SysProperty" :perms="perms" :parentRefs="this.$refs"
            :queryParamEx="queryParam" :dictFields="dictFields" :dictTypes="dictTypes" :enaUpdateBtn="false"
            :enaDeleteBtn="false"
            :addRouterUrl="{ path: `sysPropertyAdd` }">
    <template slot-scope="scope" slot="querySlot">
      <el-form-item label="配置项名称">
        <el-input v-model="scope.queryParam.propertyName"></el-input>
      </el-form-item>
      <el-form-item label="配置项值">
        <el-input v-model="scope.queryParam.propertyValue"></el-input>
      </el-form-item>
    </template>
    <template slot="tableColumnSlot">
      <el-table-column type="selection" width="55">
      </el-table-column>
      <el-table-column align="center" prop="autoId" label="自增主键">false</el-table-column>
      <el-table-column align="center" label="配置项名称">
        <template slot-scope="scope">
          {{scope.row.propertyName}}
        </template>
      </el-table-column>
      <el-table-column align="center" label="配置项值">
        <template slot-scope="scope">
          {{scope.row.propertyValue}}
        </template>
      </el-table-column>
      <el-table-column align="center" label="配置项说明">
        <template slot-scope="scope">
          {{scope.row.description}}
        </template>
      </el-table-column>
      <el-table-column align="center" label="操作" width="300">
        <template slot-scope="scope">
          <el-row>
            <el-tooltip class="item" effect="dark" content="修改" placement="top">
              <el-button type="primary" icon="el-icon-edit" circle @click="$refs.cp.edit(scope.row.autoId)"></el-button>
            </el-tooltip>
            <el-tooltip class="item" effect="dark" content="删除" placement="top">
              <el-button type="danger" icon="el-icon-delete" circle @click="$refs.cp.del(scope.row.autoId)"></el-button>
            </el-tooltip>
          </el-row>
        </template>
      </el-table-column>
    </template>
  </CrudList>
</template>
<script>
  import api from '@/api/csp/sysProperty';
  import CrudList from '@/components/CrudList';

  export default {
    components: {CrudList},
    data() {
      return {
        api: api,
        perms: {
          save: 'sysproperty:save',
          update: 'sysproperty:update',
          delete: 'sysproperty:delete',
        },
        queryParam: {
          id: ''
          , propertyName: ''
          , propertyValue: ''
        }
        , dictFields: []
        , dictTypes: []
      }
    },
    methods: {}
  }
</script>
