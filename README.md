# Spring 知识体系与开发实践
> author: 爱酱油不爱醋
> since: 2020-09-02
- 参考文献: 
    - <a href="https://spring.io/projects/spring-boot#overview">Spring.io</a>
    - 《Spring实战 第四版》
    - 《Spring实战 第五版》
    - 《SpringBoot实战》 

## 解耦思想
### 解耦与控制反转

任何一个有实际意义的应用都会有两个类或者更多的类构成，这些类的属性和功能相互协作来完成特定的功能

#### 高度耦合的类

按照传统的面向对象编程，每个对象负责管理与自己相互协作的对象（即它所依赖的对象），这会导致高度耦合。


A 程序员和 MacBook 电脑相互协作完成 code() 这个编程方法 
```java
/**
 * A程序员，一个只使用 MacBook 的程序员
 *
 * @author 爱酱油不爱醋
 * @version 1.0
 */
public class AProgrammer implements Programmer {
	
	private final MacBookComputer macBookComputer;
	
	public AProgrammer() {
		this.macBookComputer = new MacBookComputer();
	}
	
	@Override
	public void code() {
		macBookComputer.write();
	}
}
```

现在，一名开发部的主管和 A 程序员相互协作完成 task() 这个任务方法
```java
/**
 * IT 开发部 Leader 的 A 实现
 *
 * @author 爱酱油不爱醋
 * @version 1.0
 */
public class AITLeader implements ITLeader {
	
	private final AProgrammer aProgrammer;
	
	public AITLeader() {
		aProgrammer = new AProgrammer();
	}
	
	@Override
	public void task() {
		aProgrammer.code();
	}
}
```

在实际调用中，我们发现类与类的相互耦合非常严重，这就映射现实生活中：我安排IT开发部的A领导，那么他只会安排 A 程序员去做事，
同时还要为该程序员准备一台苹果笔记本！
```java
@SpringBootTest
public class ACodeTest {
	
	/**
	 * 强耦合类与类的测试
	 */
	@Test
	public void codingATest() {
		AITLeader aitLeader = new AITLeader();
		aitLeader.task();
	}
}
```

#### 通过接口部分解耦

B程序员，可以接受任何实现了**电脑**这个接口功能的电脑
```java
/**
 * B程序员，可接受任何电脑
 *
 * @author 爱酱油不爱醋
 * @version 1.0
 */
public class BProgrammer implements Programmer {
	
	private final Computer computer;
	
	public BProgrammer(Computer computer) {
		this.computer = computer;
	}
	
	@Override
	public void code() {
		computer.write();
	}
}
```

同理，现在有一名 IT 开发部的 Leader，他可以接受任何实现了**程序员**这个接口功能的程序员

```java
/**
 * IT 开发部 Leader 的 B 实现
 *
 * @author 爱酱油不爱醋
 * @version 1.0
 */
public class BITLeader implements ITLeader {
	
	private final Programmer programmer;
	
	public BITLeader(Programmer programmer) {
		this.programmer = programmer;
	}
	
	@Override
	public void task() {
		programmer.code();
	}
}
```

在类方法初始化并调用电脑和程序员的方法时，电脑和程序员呈现着高度可替代性！
```java
/**
 * 开发任务测试
 *
 * @author 爱酱油不爱醋
 * @version 1.0
 */
@SpringBootTest
public class ACodeTest {

	/**
	 * 面向接口编程的测试
	 */
	@Test
	public void codingBTest() {
	
//		Computer computer = new HuaweiComputer();
		Computer computer = new XiaomiComputer();
		
		//Programmer programmer = new BProgrammer(computer);
		Programmer programmer = new AProgrammer();
		
		BITLeader bitLeader = new BITLeader(programmer);
		bitLeader.task();
	}
	
}
```
在面向对象编程当中，此处又称为**面向接口编程**

#### 控制反转
现在我们视电脑和程序员为**组件（Compoent）**，它们应作为一个独立的**个体**或**部件**，任我们任意的组装成一个具有实际意义的应用！

一个实现了电脑接口功能的电脑
```java
/**
 * 戴尔的电脑实现
 *
 * @author 爱酱油不爱醋
 * @version 1.0
 */
@Service
public class DaierComputer implements Computer {
	
	@Override
	public void write() {
		System.out.println("正在使用戴尔笔记本编程");
	}
}
```

这是一种茶
```java
/**
 * 绿茶，一种茶的实现
 *
 * @author 爱酱油不爱醋
 * @version 1.0
 */
@Component
public class GreenTea implements Tea {
	
	@Override
	public void drink() {
		System.out.println("绿茶真好喝!");
	}
}
```

一个实现了程序员接口功能的 D 程序员，它需要电脑和茶，那么将有 IOC 容器通过装配的方式给予它
```java
/**
 * D 程序员实现
 *
 * @author 爱酱油不爱醋
 * @version 1.0
 */
@Service
public class DProgrammer implements Programmer {
	
	@Resource
	private DaierComputer computer;
	
	@Resource
	private GreenTea tea;
	
	@Override
	public void code() {
		tea.drink();
		computer.write();
	}
}
```

在实际的应用当中，我们同样通过 IOC 容器的装配，分配这名程序员开始工作！
```java
/**
 * 开发任务测试
 *
 * @author 爱酱油不爱醋
 * @version 1.0
 */
@SpringBootTest
public class ACodeTest {
	
	@Resource
	private DProgrammer dProgrammer;
	
	/**
	 * 控制反转的测试
	 */
	@Test
	public void codingCDTest() {
		dProgrammer.code();
	}
	
}
```

## Spring核心概念

Spring 框架通过**依赖注入**和 **AOP** 和**消除样板式代码**来简化企业级的 Java 开发，
Spring 提供了一个庞大的生态和应用来服务各个领域的 Java 编程。

Spring 的使命：**简化 Java 开发**

#### Bean 与 IOC 容器
Bean 在 Spring 中代表着**组件**的含义，是 IOC 的基础编程模型

Spring Bean 有以下几个特点：
- 单例的，并在 IOC 容器初始化时创建
- 有作用域，作用域由 Spring 控制
- IOC 管理着 Bean 的生命周期

IOC：**依赖控制反转**，对象(bean)的创建由 IOC 创建，并统一进行管理，即“对象依赖关系的管理”被反转了。

```text
在实际开发当中，我更喜欢将 IOC 容器视为一个这样的泛型 Map<String, Bean> 的 Map 集合 
```

IOC 由 **BeanFactory** 和 **ApplicationContext**
- BeanFactory: 实现了容器的最基本功能
- ApplicationContext: 应用上下文，作为容器的高级形态存在

#### 标识 Spring Bean
标识 Spring bean 的注解
- @Component: 一个类型级的注解，能够标识一个 Spring Bean
- @Service: 标识服务级别的 Spring Bean
- @Controller: 标识控制器的 Spring Bean
- @Repository: 标识 DAO 层的 Spring Bean
- 


### AOP

#### 横切关注点
在系统当中，有一些系统级别服务会经常散步在各个模块的功能组件当中，而这些服务并不是模块的核心业务，如：
- 日志功能
- 事务功能
- 权限功能
- ...

这些系统级别的服务在 AOP 思想当中被称为**横切关注点**，横切关注点被模块化和封装的类被称为**切面**

```text
一个简单的类比，就比如保安或后勤岗位

如果我们将一座写字楼类比为我们的系统，每一层都是业务部门，比如我们IT开发部在6楼。
那么我们想在每一层都安置保安和后勤部门，但保安与后勤部门与我们每一层楼的功能职责其实并不相关，我们可以说保安和后勤部门是横切关注点。
```

#### 通知 advice
- 前置通知 Before : 在目标前被调用之前调用切面方法
- 后置通知 After : 在目标方法完成之后调用切面方法，此通知不关心被目标方法的输出结果什么
- 返回通知 After-retuning : 在目标方法成功执行之后调用切面方法
- 异常通知 After-retuning : 在目标方法成功执行之后调用通知
- 环绕通知 Around : 通知包裹了的目标方法，在被通知方法调用之前和调用之后执行切面方法

## Spring 全家桶概述

### Spring Boot

官网的定义：
```text
Spring Boot 的设计是可以尽可能地启动和运行，只需要最少的 Spring 配置。Spring Boot 对构建生产应用程序具有独特的方式。
```

这种**独特的方式**表现在：
- 起步依赖
- 约定大于配置
- 自动配置


#### 起步依赖


#### 自动配置
#### 约定大于配置
#### @SpringApplication


### Spring Data
#### 消除连接的模板代码
#### 数据库操作语言的映射


### Spring MVC
#### MVC编程思想
#### 常用的开发注解


### Spring AMQP
#### 消息协议
#### 常用的消息中间件
- RabbitMQ
- Kafka


### Spring Security
#### 概述


### Spring Cloud
#### 概述
#### 常见的微服务解决方案
- 4Netfix
- Alibaba


## Spring 开发实践
### 全局异常处理


### 简化多线程编程


### 配置信息读写


### 自定义 Bean 实例


### 自定义切面


### 利用 @Transactional 定义事务回滚


### 利用 WebSocket 实现双工通信


### 利用 Spring Retry 进行重试
