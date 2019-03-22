<!--
 编辑页面
 @author junwei.xiong
 @since 2018-09-27 17:08:11
-->
<template>
    <CrudEdit :api="api" :rules="rules" domainName="SysRoleMenu" :formDataEx="formData" :dictTypes="dictTypes">
        <template slot-scope="scope" slot="eidtSlot">
            <el-row :gutter="20">
                <el-col :span="12">
                    <el-form-item label="角色名称" prop="roleId">
                        <el-input-number v-model="scope.formData.roleId"></el-input-number>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="功能ID" prop="menuId">
                        <el-input-number v-model="scope.formData.menuId"></el-input-number>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="创建时间" prop="createTime">
                        <el-date-picker v-model="scope.formData.createTime" type="date" placeholder="请选择创建时间"></el-date-picker>
                    </el-form-item>
                </el-col>
            </el-row>
        </template>
    </CrudEdit>
</template>

<script>
    import api from '@/api/sysRoleMenu';
    import CrudEdit from '@/components/CrudEdit';
    export default {
        components: {CrudEdit},
        data() {
            return {
                api: api
                ,formData: {
                    autoId : '', 
                    roleId : '', 
                    menuId : '', 
                    createTime : ''
                },
                rules: {
                },
                dictTypes : []
            }
        }
    }
</script>