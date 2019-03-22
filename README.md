# Getting Start

## 1.介绍
ycc项目脚手架,项目已内置所有必须的配置文件并已做好调试工作，迁移后仅需做简单配置即可使用。

## 2.启动
调试阶段，需要分前后端启动，请分别移步至  
[ycctemplate-fe 前端项目启动](master/ycctemplate-fe/README.md#1)  
[ycctemplate-os 后端项目启动](master/ycctemplate-os/README.md#2)  

## 3.目录结构
```
├── ycctemplate-api        远程服务SDK(jar包)    
├── ycctemplate-fe         vue.js前端(nodejs项目)
├── ycctemplate-os         java服务端(web项目)

```
fe,os项目目录结构移步至  
[ycctemplate-fe 前端项目目录结构](master/ycctemplate-fe/README.md#3)  
[ycctemplate-os 后端项目目录结构](master/ycctemplate-os/README.md#3)  

## 4.移植

### 远程仓库设置
1. 设置好gitlab的 **SSH keys**  
2. 在gitlab建好你的项目仓库

### 本地设置
1. `git clone git@10.3.4.127:ycc/yccmtsapi.git`  
2. 在根目录下全局替换 **ycctemplate** ,以及包结构中的 **tamplate** 为你的项目名
3. `rm -rf .git`
4. `git init`
5. `git add .`
6. `git commit -m "first commit"`
6. `git remote add origin git@10.3.4.127:ycc/你的项目仓库.git`
7. `git push -u origin master`

## 5.部署
ycc项目在maven:package过程会自动将fe,os项目的打包结果合并至 `ycc项目/target/ycc项目` 下，可以使用普通tomcat项目的UDA部署任务即可。  
[示例jira任务](http://jira.10101111.com/browse/UDEPLOY-3638)  
[如何创建UDA上线审批JIRA的流程](http://wiki.10101111.com/pages/viewpage.action?pageId=116949988)  
**注意：ycc项目的部署任务应建在 jira 的 YCCDEPLOY 项目下，不要被示例误导。** 

## 6.开发指南
fe,os项目开发指南移步至  
[ycctemplate-fe 前端项目开发指南](master/ycctemplate-fe/README.md#4)  
[ycctemplate-os 后端项目开发指南](master/ycctemplate-os/README.md#4)  


## 7.技术规范  
fe.os项目开发指南移步至  
[ycctemplate-fe 前端项目技术规范](master/ycctemplate-fe/README.md#5)  
[ycctemplate-os 后端项目技术规范](master/ycctemplate-os/README.md#5)  


