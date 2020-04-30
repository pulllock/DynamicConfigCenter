# DynamicConfigCenter
DynamicConfigCenter 动态配置中心，从头开始实现一个DynamicConfigCenter，用来学习动态配置中心的设计和实现。

# 文档列表

# 运行

1. 启动Zookeeper
2. 启动mysql， 执行sql目录下的schema.sql和data.sql
3. 通过ZKClient创建一个节点或者使用RESTFul接口创建一个配置
4. DynamicConfigCenter-sample依赖DynamicConfigCenter-client包
5. DynamicConfigCenter-sample项目中配置dcc.properties
6. DynamicConfigCenter-sample项目启动
7. 通过localhost:8082/dcc/sample/testConfig获取配置
8. 通过ZKClient修改一个节点或者使用RESTFul接口修改一个配置，再次获取配置

# TODO

- DynamicConfigCenter-client增加当前机器信息上报