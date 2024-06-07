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
1. 修改PgParamDesc#prepare(TupleInternal)逻辑，字段类型解析功能增强,支持VARCHAR类型转换
2. 修改DataTypeCodec二进制编码和文本编码逻辑，支持VARCHAR类型的属性值编码
```
### 3、适用版本 
```
io.vertx:vertx-pg-client:4.2.7
```
### 4、注意事项
```
1）补丁包需要位于pom文件依赖最顶端
2）补丁包基于4.2.7研发，建议与vertx-pg-client版本一致
3）可参考实现逻辑，不导入本补丁包，自行修改vertx-pg-client源码
```
