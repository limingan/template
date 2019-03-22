<!--
 列表页
 @author junwei.xiong
 @since 2018-09-27 17:07:36
-->
<template>
    <CrudList :api="api" domainName="SysMenu" :perms="perms" :parentRefs="this.$refs"  :queryParamEx="queryParam" :dictFields="dictFields" :dictTypes="dictTypes">
        <template slot-scope="scope" slot="querySlot">
            <el-form-item label="父级权限">
                <el-input-number ref="parentId" v-model="scope.queryParam.parentId"></el-input-number>
            </el-form-item>
            <el-form-item label="菜单名称">
                <el-input v-model="scope.queryParam.menuName" ></el-input>
            </el-form-item>
            <el-form-item label="菜单链接">
                <el-input v-model="scope.queryParam.menuUrl" ></el-input>
            </el-form-item>
        </template>
        <template slot="tableColumnSlot">
            <el-table-column type="selection" width="55">
            </el-table-column>
            <el-table-column align="center"              prop="autoId" label="自增ID" >false</el-table-column>
            <el-table-column align="center"              prop="parentId" label="父级权限" >false</el-table-column>
            <el-table-column align="center" label="菜单名称" >
                <template slot-scope="scope">
                    <router-link :to="{name: 'sysMenuView', params: {autoId: scope.row.autoId}}">
                        <el-button type="text">{{scope.row.menuName}}</el-button>
                    </router-link>
                </template>
            </el-table-column>
            <el-table-column align="center" label="菜单链接" >
                <template slot-scope="scope">
                    <router-link :to="{name: 'sysMenuView', params: {autoId: scope.row.autoId}}">
                        <el-button type="text">{{scope.row.menuUrl}}</el-button>
                    </router-link>
                </template>
            </el-table-column>
            <el-table-column align="center" label="描述" >
                <template slot-scope="scope">
                    <router-link :to="{name: 'sysMenuView', params: {autoId: scope.row.autoId}}">
                        <el-button type="text">{{scope.row.description}}</el-button>
                    </router-link>
                </template>
            </el-table-column>
            <el-table-column align="center"              prop="createTime" label="创建时间"  :formatter="dateFormat">false</el-table-column>
            <el-table-column align="center"              prop="updateTime" label="修改时间"  :formatter="dateFormat">false</el-table-column>
        </template>
    </CrudList>
</template>
<script>
    import api from '@/api/csp/permission/sysMenu';
    import CrudList from '@/components/CrudList';
    import { dateFormat, dateTimeFormat } from '@/utils';
    export default {
        components: { CrudList },
        data () {
            return {
                api: api,
            perms:{
              save:  'sysmenu:save',
              update:  'sysmenu:update',
              delete:  'sysmenu:delete',
            },
                queryParam: {
                    parentId:''
                    ,menuName:''
                    ,menuUrl:''
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
