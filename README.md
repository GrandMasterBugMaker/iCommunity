<!-- TOC -->

- [iCommunity](#icommunity)
  - [技术选型](#技术选型)
  - [项目架构](#项目架构)
  - [功能简介](#功能简介)
<!-- /TOC -->

# iCommunity

一个基于SpringBoot的用户体验反馈平台，框架使用了SSM，数据库采用了Mysql和Redis，使用Kafka作为消息队列，以及Elastic Search作为搜索引擎。

- 项目演示地址:[iCommunity](http://123.57.86.122:8080/)
    - 用户名:java
    - 密码:java

## 技术选型

- 框架:SpringBoot+Mybatis
- 数据库:MySQL
- 中间件:分布式缓存Redis + 消息队列Kafka + 全文检索ElasticSearch + 本地缓存Caffeine + 定时任务Quartz
- 构建工具:Apache Maven
- 版本控制工具:Git
- 集成开发环境:IntelliJ IDEA

## 项目架构
![](https://picgp.oss-cn-beijing.aliyuncs.com/img/20210408051708.png)
## 功能简介

- 基于 SpringBoot 和 Mybatis 框架实现基础的注册、登录、发帖、评论等功能
- 使用 Redis 实现点赞、关注功能，优化登录模块——缓存用户信息、存储登录Ticket和验证码，解决分布式Session问题
- 用户信息绑定ThreadLocal
- 使用Kafka处理发送评论、点赞和关注等系统通知，并使用事件进行封装，构建异步消息系统。
- 对热帖排行模块，使用分布式缓存Redis和本地缓存Caffeine作为多级缓存，避免了缓存雪崩，将QPS提升了20倍(10-200)，大大提升了网站访问速度。并使用Quartz定时更新热帖排行
