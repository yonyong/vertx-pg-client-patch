vertx-pg-client 补丁
===============================  
### maven依赖
执行 mvn clean install命令后 , 在项目中引入本组件
```xml
<dependency>
    <groupId>top.yonyong</groupId>
    <artifactId>vertx-pg-client-patch</artifactId>
    <version>1.0.0</version>
</dependency>
```
### 1、修复功能 
```
修复 vertx-pg-client string类型无法自动转换数据库字段类型的问题
```
### 2、补丁原理 
```
1. 修改PgParamDesc#prepare(TupleInternal)逻辑，字段类型解析功能增强
2. 修改DataTypeCodec二进制编码和文本编码逻辑
```
### 3、适用版本 
```
io.vertx:vertx-pg-client:4.2.7
```
### 4、注意事项
```
1）补丁包需要位于pom文件依赖最顶端
```
### 特别说明
低于spring boot 2.3版本以下的项目不建议引用此组件。  
由于springboot在2.3版本以后才支持限定jar包加载顺序，因此版本较低时，本组件无法保证在linux系统上加载顺序优先于scg eureka组件。  
因此低版本建议参考代码自行实现。
