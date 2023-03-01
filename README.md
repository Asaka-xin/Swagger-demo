# Swagger-demo
---

# Swagger 3（Springdoc）

Swagger 快速上手

## 前言

1. Swagger2于2017年停止支持，故本文档基于Swagger3(OpenAPi3.0)

## 1.介绍Swagger

**官方文档**：[https://doc.xiaominfo.com/docs/quick-start#spring-boot-2](https://doc.xiaominfo.com/docs/quick-start#spring-boot-2)

- 现目前最流行的API框架
- API文档自动生成同步（自动同步代码更新）
- 在线调试API

## 2.安装

**先决条件**

> - 必须基于SpringBoot项目
> - 最小依赖项为 SpringWeb

**示例环境**

> Java version : 8
>
> Maven version : 3.8.6
>
> SpringBoot Version: 2.7.8

#### 2.1创建基础SpringBoot工程

<img src="https://onebottle-1312477531.cos.ap-chengdu.myqcloud.com/202302160004177.png" alt="image-20230216000452049"  />

#### 2.2更新文件pom.xml

**解析依赖项**

> 1. Swagger技术
>
> - Swagger是遵循OpenApi3.0 的一项技术
>
> 2. 核心+UI = 实现(spingfox/springdoc)
>
> - SpringDoc
> - Knife4j是一个UI (增强版本)

```xml
   <dependency>
                <!--  swagger 3	-->
      			 <!--  依赖先后顺序不能gai	-->
                <groupId>com.github.xiaoymin</groupId>
                <artifactId>knife4j-openapi3-spring-boot-starter</artifactId>
                <version>4.0.0</version>
 	</dependency>
    <dependency>
            <!--    spring doc   -->
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-ui</artifactId>
            <version>1.6.14</version>
     </dependency>
```

#### 2.3配置

找到项目中的 ==application.properties==->**重命名**->==application.yml== [^1]

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
# Scan your controller package.
          packages-to-scan:
```

#### 2.4在代码中使用注解

##### 使用前

```java
@RestController
@RequestMapping("/default")
public class DefaultController {

    @GetMapping("/hello")
    public String index(){
        return "Hello Swagger3 !";
    }
```

##### 使用后

```java
@Tag(name = "默认分类")
@RestController
@RequestMapping("/default")
public class DefaultController {

    @Operation(summary = "默认信息")
    @Parameter(name = "id" , required = false, description = "序号")
    @GetMapping("/hello")
    public String index(){
        return "Hello Swagger3!";
    }
```

## 3.访问地址

Swagger UI : http://server:port/swagger-ui.html

Knife4j  ： http://server:port/doc.html

## 可选配置

在包com.xxx.xxx.config下新建配置类

```java
/*
* Knife4j的首页展示信息
* eng: Homepage display information of Knife4j
*/
@Configuration
public class SwaggerConfig {
    //对API进行分组
    //路径匹配规则 & 包扫描规则
    @Bean

    public GroupedOpenApi api() {return GroupedOpenApi.builder().group("all")
            .pathsToMatch("/**")
            .packagesToScan("com.xxx.controller").build();
    }

   //Display information of Swagger
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("This is your title")
                        .version("Your Version")
                        .contact(new io.swagger.v3.oas.models.info.Contact()
                                .name("Your Name")
                                .email("Your Email"))
                        .description("And your description"));

    }
}
```

