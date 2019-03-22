<!--
 编辑页面
 @author junwei.xiong
 @since 2018-09-26 10:03:33
-->
<template>
    <CrudEdit :api="api" :rules="rules" domainName="AgNotice" :formDataEx="formData" :dictTypes="dictTypes">
        <template slot-scope="scope" slot="eidtSlot">
            <el-row :gutter="20">
                <el-col :span="12">
                    <el-form-item label="内容" prop="content">
                        <el-input v-model="scope.formData.content"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="渠道号" prop="tenantId">
                        <el-input v-model="scope.formData.tenantId"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="标题" prop="title">
                        <el-input v-model="scope.formData.title"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="发送时间" prop="sendTime">
                        <el-input v-model="scope.formData.sendTime"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="不用暂时不填" prop="filePath">
                        <el-input v-model="scope.formData.filePath"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="开始时间" prop="beginTime">
                        <el-date-picker v-model="scope.formData.beginTime" type="date" placeholder="请选择开始时间"></el-date-picker>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="默认值0" prop="isSend">
                        <el-input v-model="scope.formData.isSend"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="默认值0" prop="status">
                        <el-input v-model="scope.formData.status"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="结束时间" prop="endTime">
                        <el-date-picker v-model="scope.formData.endTime" type="date" placeholder="请选择结束时间"></el-date-picker>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="发送人工号" prop="sender">
                        <el-input v-model="scope.formData.sender"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="" prop="createSender">
                        <el-input v-model="scope.formData.createSender"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="0全部班组 1班组 " prop="acceptType">
                        <el-input v-model="scope.formData.acceptType"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="逗号分隔 只有accpt_type为1有效 班组id" prop="acceptUsers">
                        <el-input v-model="scope.formData.acceptUsers"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="逗号分隔 只有accpt_type为1有效 班组名称" prop="acceptNames">
                        <el-input v-model="scope.formData.acceptNames"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="坐席有0 知识库1" prop="channelType">
                        <el-input v-model="scope.formData.channelType"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="发送者名字" prop="senderName">
                        <el-input v-model="scope.formData.senderName"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="是否置顶" prop="istop">
                        <el-input v-model="scope.formData.istop"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="公告类型" prop="noticetype">
                        <el-input v-model="scope.formData.noticetype"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="是否紧急" prop="isurgency">
                        <el-input v-model="scope.formData.isurgency"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
        </template>
    </CrudEdit>
</template>

<script>
    import api from '@/api/agNotice';
    import CrudEdit from '@/components/CrudEdit';
    export default {
        components: {CrudEdit},
        data() {
            return {
                api: api
                ,formData: {
                    autoId : '', 
                    content : '', 
                    tenantId : '', 
                    title : '', 
                    sendTime : '', 
                    filePath : '', 
                    beginTime : '', 
                    isSend : '', 
                    status : '', 
                    endTime : '', 
                    sender : '', 
                    createSender : '', 
                    acceptType : '', 
                    acceptUsers : '', 
                    acceptNames : '', 
                    channelType : '', 
                    senderName : '', 
                    istop : '', 
                    noticetype : '', 
                    isurgency : ''
                },
                rules: {
                },
                dictTypes : []
            }
        }
    }
</script>