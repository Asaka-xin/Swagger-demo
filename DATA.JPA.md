# JPA

#### pom.xml

```xml
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
	
```

#### application.yml

```properties
server.port=8080
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/employee?useSSL=false
spring.datasource.username=root
spring.datasource.password=1234
spring.jpa.hibernate.ddl-auto=update //数据库映射操作策略
spring.jpa.show-sql=true //显示SQL

```

### 注解参考：

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

实体类编写：

```java
package com.asaka.swaggerhello.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
}

```

### Interface继承JPARepository

```java
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
```

### 控制类

```java
package com.ydlclass.jpa.ydljpa;

import com.ydlclass.jpa.ydljpa.dao.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class YdljpaApplicationTests {

    @Autowired
    UserRepository userRepository;
    
    @Test
    public void testQuery(){
        userRepository.findById(1).ifPresent(System.out::println);
    }
    
}
```

### 添加操纵：

```java
  @Test
    public void testAdd(){
        User user=new User();
        //user.setId(2);
        user.setUsername("itnanls");
        user.setPassword("ydl666");

        User saveUser = userRepository.save(user); //新增 返回的实体中带着实体id
        System.out.println(saveUser);
    }
```

```java
 @Test
    public void testDel(){
        userRepository.deleteById(3);
    }
```

