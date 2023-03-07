# JPA

#### pom.xml

```xml
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
	
```

#### application.yml

```yml
spring:
  datasource:
    driver-class-name: 
    url: 
    username: 
    password: 
  jpa:
    hibernate:
    # auto make table
      ddl-auto: update
    # Console Print SQL
    show-sql: true
```

**@Entity** :定义对象将会成为被JPA管理的实体，将映射到指定的数据库表。
**@Table** :指定数据库的表名。
**@Id**定义属性为数据库的主键，一个实体里面必须有一个。
**@IdClass**利用外部类的联合主键。
**@GeneratedValue**为主键生成策略
**@Basic**表示属性是到数据库表的字段的映射。如果实体的字段上没有任何注解，默认即为@Basic。
**@Transient**表示该属性并非一个到数据库表的字段的映射，表示非持久化属性，与@Basic作用相反。JPA映射数据库的时候忽略它。
**@Column**定义该属性对应数据库中的列名。
**@Temporal**用来设置Date类型的属性映射到对应精度的字段。
**@Lob** 将属性映射成数据库支持的大对象类型，支持以下两种数据库类型的字段。

关联关系注解
**@JoinColumn**定义外键关联的字段名称
**@OneToOne**关联关系
**@OneToMany与@ManyToOne**可以相对存在，也可只存在一方。
**@ManyToMany**表示多对多，和@OneToOne、@ManyToOne一样也有单向、双向之分。单向双向和注解没有关系，只看实体类之间是否相互引用。

https://blog.csdn.net/matafeiyanll/article/details/124603090

![](https://img-blog.csdnimg.cn/18437df67d574c5c9adc71c9f269fd28.png)