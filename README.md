
# <center>云e办项目总结
## 前言
本项目基于b站的云e办项目，视频链接：<a>https://www.bilibili.com/video/BV1ff4y1M7XK?p=71&share_source=copy_web ,
采用主流技术springboot+vue前后端分离开发，做完之后发现跟github上23kstar的vhr（微人事）项目有一点点相似...
## 项目截图
![image.png](http://icatw-blog.oss-cn-beijing.aliyuncs.com/articles/014a015e70db8fedb3a6352bdc4cc22a.png)
![image.png](http://icatw-blog.oss-cn-beijing.aliyuncs.com/articles/90e99ce311a5880e67a54154175f2a76.png)
![image.png](http://icatw-blog.oss-cn-beijing.aliyuncs.com/articles/c1ed6b222c679471d9e1df80e3423852.png)
![image.png](http://icatw-blog.oss-cn-beijing.aliyuncs.com/articles/a5de07da64dae300dbf27639ec483624.png)
![image.png](http://icatw-blog.oss-cn-beijing.aliyuncs.com/articles/1adcdf2d933bf1eeeea7bef62a901461.png)
![image.png](http://icatw-blog.oss-cn-beijing.aliyuncs.com/articles/4363ecaab6d9d386de5fb4bdc54e1553.png)
## 功能模块
- 员工资料：基本资料、高级资料
- 人事管理（尚未开发）
- 薪资管理：工资账套管理、员工账套管理（工资表管理、月末处理、工资表查询尚未开发）
- 统计管理（尚未开发）
- 系统管理：基础信息设置（部门管理、职位管理、职称管理、奖惩规则、权限组）、操作员管理（展示以及编辑操作员信息以及对应的角色信息）
- websocket在线聊天
## 项目技术栈
### 后端技术栈
1. Spring Boot
2. Spring Security
3. Mybatis+Mybatis-Plus
4. Redis
5. RabbitMQ
6. WebSocket
7. 阿里云oss
8. mail
9. ...

### 前端技术栈
1. Vue
2. ElementUI
3. axios
4. vue-router
5. Vuex
6. WebSocket
7. vue-cli4
8. ...

## 项目源码
gitee：https://gitee.com/icatw/cloudEOffice

github：https://github.com/icatw/cloudEOffice

原项目使用fastdfs作为分布式文件存储系统，而我改用了阿里云的oss作为图片存储，另外采用了ui界面更为美观的knife4j作为接口文档（仍然存在很多bug）
