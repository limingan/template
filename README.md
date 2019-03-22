# Getting Start

## 1.介绍
项目脚手架,项目已内置所有必须的配置文件并已做好调试工作，迁移后仅需做简单配置即可使用。

## 2.启动
调试阶段，需要分前后端启动，请分别移步至  
[template-fe 前端项目启动](template-fe/README.md#1)  
[template-bg 后端项目启动](template-bg/README.md#2)  

## 3.目录结构
```   
├── template-fe         vue.js前端(nodejs项目)
├── template-bg         java服务端(web项目)

```
fe,os项目目录结构移步至  
[template-fe 前端项目目录结构](template-fe/README.md#3)  
[template-bg 后端项目目录结构](template-bg/README.md#3)  

## 4.移植

### 远程仓库设置
1. 设置好gitlab的 **SSH keys**  
2. 在gitlab建好你的项目仓库


## 5.部署
项目在maven:package过程会自动将fe,bg项目的打包结果合并至 `项目/target/项目` 下，将文件夹放在tomcat的webapp目录下即可。  

## 6.开发指南
fe,bg项目开发指南移步至  
[template-fe 前端项目开发指南](template-fe/README.md#4)  
[template-bg 后端项目开发指南](template-bg/README.md#4)  


## 7.技术规范  
fe.bg项目开发指南移步至  
[template-fe 前端项目技术规范](template-fe/README.md#5)  
[template-bg 后端项目技术规范](template-bg/README.md#5)  


