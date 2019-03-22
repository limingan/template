<!--
 列表页
 @author junwei.xiong
 @since 2018-09-27 17:07:14
-->
<template>
    <CrudList :api="api" domainName="SysEmployeeRole" :perms="perms" :parentRefs="this.$refs"  :queryParamEx="queryParam" :dictFields="dictFields" :dictTypes="dictTypes">
        <template slot-scope="scope" slot="querySlot">
            <el-form-item label="员工ID">
                <el-input-number ref="employeeId" v-model="scope.queryParam.employeeId"></el-input-number>
            </el-form-item>
            <el-form-item label="角色名称">
                <el-input-number ref="roleId" v-model="scope.queryParam.roleId"></el-input-number>
            </el-form-item>
        </template>
        <template slot="tableColumnSlot">
            <el-table-column type="selection" width="55">
            </el-table-column>
            <el-table-column align="center"              prop="autoId" label="自增ID" >false</el-table-column>
            <el-table-column align="center"              prop="employeeId" label="员工ID" >false</el-table-column>
            <el-table-column align="center"              prop="roleId" label="角色名称" >false</el-table-column>
            <el-table-column align="center"              prop="createTime" label="创建时间"  :formatter="dateFormat">false</el-table-column>
        </template>
    </CrudList>
</template>
<script>
    import api from '@/api/sysEmployeeRole';
    import CrudList from '@/components/CrudList';
    import { dateFormat, dateTimeFormat } from '@/utils';
    export default {
        components: { CrudList },
        data () {
            return {
                api: api,
            perms:{
              save:  'sysemployeerole:save',
              update:  'sysemployeerole:update',
              delete:  'sysemployeerole:delete',
            },
                queryParam: {
                    employeeId:''
                    ,roleId:''
                }
        ,dictFields : []
        ,dictTypes : []
                }
        },
        methods: {
            dateFormat,
            dateTimeFormat
        }
    }
</script>
