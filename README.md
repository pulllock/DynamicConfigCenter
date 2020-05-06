# DynamicConfigCenter
DynamicConfigCenter 动态配置中心，从头开始实现一个DynamicConfigCenter，用来学习动态配置中心的设计和实现。

# 文档列表

- [DynamicConfigCenter设计的思路](https://cxis.me/2020/04/25/DynamicConfigCenter设计的思路/)
- [DynamicConfigCenter设计文档](https://cxis.me/2020/04/26/DynamicConfigCenter设计文档/)
- [DynamicConfigCenter中Zookeeper相关操作](https://cxis.me/2020/04/27/DynamicConfigCenter中Zookeeper相关操作/)
- [DynamicConfigCenter中Zookeeper监听机制使用](https://cxis.me/2020/04/28/DynamicConfigCenter中Zookeeper监听机制使用/)
- [DynamicConfigCenter中的监听器模式](https://cxis.me/2020/04/28/DynamicConfigCenter中的监听器模式/)
- [DynamicConfigCenter中基于Spring的Schema扩展功能](https://cxis.me/2020/05/04/DynamicConfigCenter中基于Spring的Schema扩展功能/)
- [DynamicConfigCenter总结]()

# 运行

1. 启动Zookeeper
2. 启动mysql， 执行sql目录下的schema.sql和data.sql
3. 通过ZKClient创建一个节点或者使用RESTFul接口创建一个配置
4. DynamicConfigCenter-sample依赖DynamicConfigCenter-client包
5. DynamicConfigCenter-sample项目中配置dcc.properties
6. DynamicConfigCenter-sample项目启动
7. 通过localhost:8082/dcc/sample/testConfig获取配置
8. 通过ZKClient修改一个节点或者使用RESTFul接口修改一个配置，再次获取配置

# 使用

1. 依赖DynamicConfigCenter-client包
2. 有三种方式使用

## 直接使用

```
DCC.get("xxxxxx");
```

## 使用xml配置文件

在Spring配置文件中增加标签，启用功能：
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:dcc="https://www.cxis.me/schema/dcc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       https://www.cxis.me/schema/dcc
       https://www.cxis.me/schema/dcc/dcc-config.xsd
">

    <dcc:config/>
</beans>
```

使用`@Value`注解注入属性

## 使用注解

使用注解`@EnableDCC`注解启用功能，使用`@Value`注解注入属性

# TODO

- DynamicConfigCenter-client增加当前机器信息上报
- DynamicConfigCenter-client自定义注解
- DynamicConfigCenter-admin区分环境