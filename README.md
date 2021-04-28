<!-- TOC -->

- [iCommunity](#icommunity)
  - [技术选型](#技术选型)
  - [项目架构](#项目架构)
  - [功能简介](#功能简介)
    - [模块介绍](#模块介绍)
  - [注册与登录功能的实现](#注册与登录功能的实现)
    - [密码MD5加密](#密码md5加密)
    - [会话管理(分布式Session问题)](#会话管理分布式session问题)
    - [Kaptcha生成验证码](#kaptcha生成验证码)
    - [Loginticket生成凭证 记录登录状态](#loginticket生成凭证-记录登录状态)
      - [V1:将用户登录凭证ticket存到mysql的login_ticket表中](#v1将用户登录凭证ticket存到mysql的login_ticket表中)
      - [V2:使用Redis优化登录模块](#v2使用redis优化登录模块)
  - [发布帖子](#发布帖子)
  - [发表评论以及私信](#发表评论以及私信)
    - [评论](#评论)
    - [私信](#私信)
  - [使用Redis实现点赞关注](#使用redis实现点赞关注)
    - [点赞功能](#点赞功能)
    - [我收到的赞：](#我收到的赞)
    - [关注、取消关注功能](#关注取消关注功能)
  - [Kafka，实现异步消息系统](#kafka实现异步消息系统)
    - [发送系统通知](#发送系统通知)
  - [Spring Quartz实现定时热帖排行](#spring-quartz实现定时热帖排行)
    - [Quartz](#quartz)
    - [热帖排行](#热帖排行)
  - [使用本地缓存Caffeine优化网站性能](#使用本地缓存caffeine优化网站性能)
    - [JMeter压力测试](#jmeter压力测试)

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
