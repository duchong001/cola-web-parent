> 本项目旨在说明利用cola提供的archetype,来快速生成springboot+mybatisplus+swagger3.0+mysql的project，节约手动创建的时间，提高开发的效率.

[Cola最佳实践](https://blog.csdn.net/significantfrank/article/details/110934799?spm=1001.2014.3001.5502)

[Cola脚手架以及案例](https://github.com/alibaba/COLA)

# 1、生成项目结构

```shell
mvn archetype:generate  -DgroupId=com.duchong.demo.web -DartifactId=sample-web-4 -Dversion=1.0.0-SNAPSHOT -Dpackage=com.duchong.demo -DarchetypeArtifactId=cola-framework-archetype-web -DarchetypeGroupId=com.alibaba.cola -DarchetypeVersion=4.3.2 -DinteractiveMode=false -DarchetypeCatalog=local
```

# 2、导入schemas

```sql
CREATE TABLE `jtest_user` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `age` int(10) DEFAULT NULL COMMENT '年龄',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modify` datetime DEFAULT NULL COMMENT '修改时间',
  `gmt_delete` datetime DEFAULT NULL COMMENT '删除时间',
  `deleted` int(10) DEFAULT NULL COMMENT '是否已删除',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `modified_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `deleted_by` varchar(255) DEFAULT NULL COMMENT '删除人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='测试用户表';
```

# 3、修改端口和数据源配置

```yaml
spring:
    application:
        name: cola-web
    #兼容swagger3.0
    mvc:
        pathmatch:
            matching-strategy: ant_path_matcher
    # 配置数据源
    datasource:
        username: root
        password: root
        driver-class-name: com.mysql.cj.jdbc.Driver
        url: jdbc:mysql://localhost:3306/java-test?useSSL=false&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&serverTimezone=Asia/Shanghai
        type: com.alibaba.druid.pool.DruidDataSource
```

