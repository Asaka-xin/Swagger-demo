# Swagger-demo
---

# 学习Swagger

- 认识API框架
- 解决如何使用Swagger

脚注：



## 前言

1. Swagger2于2017年停止支持，故本文档基于Swagger3(OpenAPi3.0)

## 1.介绍Swagger

**官方网站**：[https://swagger.io](https://swagger.io)

**官方文档（适用于2.x）**：[https://github.com/swagger-api/swagger-core/wiki/Swagger-2.X---Integration-and-Configuration](https://github.com/swagger-api/swagger-core/wiki/Swagger-2.X---Integration-and-Configuration)

- 现目前最流行的API框架
- API文档自动生成同步（自动同步代码更新）
- 在线测试API

## 2.安装

**先决条件**

> - 必须基于SpringBoot项目
> - 最小依赖项为SpringWeb

**示例环境**

> Java version : 8
>
>  Maven version : 3.8.6

#### 2.1创建基础SpringBoot工程

<img src="https://onebottle-1312477531.cos.ap-chengdu.myqcloud.com/202302160004177.png" alt="image-20230216000452049" style="zoom:80%;" />

#### 2.2更新文件pom.xml

加入如下依赖项

```xml
	<dependencies>
        <dependency>
			<!--    spring doc   -->
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-ui</artifactId>
            <version>1.6.13</version>
        </dependency>
        <dependency>
            <!--  swagger 3	-->
            <groupId>com.github.xiaoymin</groupId>
            <artifactId>knife4j-springdoc-ui</artifactId>
            <version>3.0.3</version>
        </dependency>
    </dependencies>
```

#### 2.3配置

找到项目中的 ==application.properties==->**重命名**->==application.yaml== [^1]

[^1]: *.properties格式文件无法写注释

加入以下配置；

```yaml

# springdoc-openapi configuration
# To get help follow the link to get more information
# https://doc.xiaominfo.com/docs/quick-start
springdoc:
    swagger-ui:
        path: /swagger-ui.html
        tags-sorter: alpha
        operations-sorter: alpha
    api-docs:
        path: /v3/api-docs
    group-configs:
        - group: 'default'
          paths-to-match: '/**'
#         Scan all your controllers package.
          packages-to-scan:
```

#### 2.4在代码中使用注解

