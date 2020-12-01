# nateshao-boot-20-async

> 此 demo 主要演示了 Spring Boot 如何使用原生提供的异步任务支持，实现异步执行任务。

## pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.4.0</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.nateshao</groupId>
    <artifactId>nateshao-boot-20-async</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>nateshao-boot-20-async</name>
    <description>Demo project for Spring Boot</description>

    <properties>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>
```

## application.yml

```yaml
spring:
  task:
    execution:
      pool:
        # 最大线程数
        max-size: 16
        # 核心线程数
        core-size: 16
        # 存活时间
        keep-alive: 10s
        # 队列大小
        queue-capacity: 100
        # 是否允许核心线程超时
        allow-core-thread-timeout: true
      # 线程名称前缀
      thread-name-prefix: async-task-
```

## SpringBootDemoAsyncApplication.java

```java
@EnableAsync
@SpringBootApplication
public class SpringBootDemoAsyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoAsyncApplication.class, args);
    }

}
```

## TaskFactory.java

```java
@Component
@Slf4j
public class TaskFactory {

    /**
     * 模拟5秒的异步任务
     */
    @Async
    public Future<Boolean> asyncTask1() throws InterruptedException {
        doTask("asyncTask1", 5);
        return new AsyncResult<>(Boolean.TRUE);
    }

    /**
     * 模拟2秒的异步任务
     */
    @Async
    public Future<Boolean> asyncTask2() throws InterruptedException {
        doTask("asyncTask2", 2);
        return new AsyncResult<>(Boolean.TRUE);
    }

    /**
     * 模拟3秒的异步任务
     */
    @Async
    public Future<Boolean> asyncTask3() throws InterruptedException {
        doTask("asyncTask3", 3);
        return new AsyncResult<>(Boolean.TRUE);
    }

    /**
     * 模拟5秒的同步任务
     */
    public void task1() throws InterruptedException {
        doTask("task1", 5);
    }

    /**
     * 模拟2秒的同步任务
     */
    public void task2() throws InterruptedException {
        doTask("task2", 2);
    }

    /**
     * 模拟3秒的同步任务
     */
    public void task3() throws InterruptedException {
        doTask("task3", 3);
    }

    private void doTask(String taskName, Integer time) throws InterruptedException {
        log.info("{}开始执行，当前线程名称【{}】", taskName, Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(time);
        log.info("{}执行成功，当前线程名称【{}】", taskName, Thread.currentThread().getName());
    }
}
```

## TaskFactoryTest.java

```java
@Slf4j
public class TaskFactoryTest extends SpringBootDemoAsyncApplicationTests {
    @Autowired
    private TaskFactory task;

    /**
     * 测试异步任务
     */
    @Test
    public void asyncTaskTest() throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        Future<Boolean> asyncTask1 = task.asyncTask1();
        Future<Boolean> asyncTask2 = task.asyncTask2();
        Future<Boolean> asyncTask3 = task.asyncTask3();

        // 调用 get() 阻塞主线程
        asyncTask1.get();
        asyncTask2.get();
        asyncTask3.get();
        long end = System.currentTimeMillis();

        log.info("异步任务全部执行结束，总耗时：{} 毫秒", (end - start));
    }

    /**
     * 测试同步任务
     */
    @Test
    public void taskTest() throws InterruptedException {
        long start = System.currentTimeMillis();
        task.task1();
        task.task2();
        task.task3();
        long end = System.currentTimeMillis();

        log.info("同步任务全部执行结束，总耗时：{} 毫秒", (end - start));
    }
}
```

## 运行结果

### 异步任务

```bash
```

### 同步任务

```bash
```

## 参考

- Spring Boot 异步任务线程池的配置 参考官方文档：https://docs.spring.io/spring-boot/docs/2.1.0.RELEASE/reference/htmlsingle/#boot-features-task-execution-scheduling
