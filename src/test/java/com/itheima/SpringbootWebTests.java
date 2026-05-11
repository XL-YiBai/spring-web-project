package com.itheima;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * 关于 IOC 容器中的 Bean 对象可以通过 @Scope 设置默认值
 * 这里我们针对 Controller 中的 DeptController 进行测试，
 * 针对 DeptController 设置不同的 scope ，打印1000次，以及看 DeptController 的无参构造打印次数来判断是否是同一个
 *
 * 在声明 Bean 对象时可以通过 @Scope 来设置Bean的作用域，例如 @Scope("prototype")
 * 作用域如下：
 * singleton    容器内同名称的 Bean 只有一个 实例（单例） （默认）
 * prototype    每次使用该 Bean 时会创建新的实例（非单例，多例）
 * request      每个请求范围内会创建新的实例（web环境独有，了解即可）
 * session      每个会话范围内会创建新的实例（web环境独有，了解即可）
 * application  每个应用范围内会创建新的实例（web环境独有，了解即可）
 *
 * 默认 singleton 的 Bean，在容器启动的时候被创建并放入 IOC 容器，可以添加 @Lazy 注解来延迟初始化（延迟到第一次使用时创建）
 *
 * 如果一个 Bean 是无状态的 Bean 就可以使用单例的 Bean。我们的 Controller、Service、Dao 都是无状态的，也就不存在多线程共享数据的问题
 * 单例的 Bean 比较节约资源，性能更高，减少对象的创建和销毁次数
 *
 * 如果一个 Bean 需要保存数据，例如要处理本次请求的一些数据统计，如果还是单例的话，就会存在问题，就变成了所有数据的统计了，而不是单次
 * public class DataProcessor {
 *     private Interger errCount = 0; // 错误数据统计
 * }
 *
 * 有状态的 Bean 内部会保存状态，多个线程同时操作该 Bean 可能会出现数据不一致，这样的Bean是线程不安全的
 */

@SpringBootTest
public class SpringbootWebTests {

    private ApplicationContext applicationContext; // IOC 容器

    @Test
    public void testScope() {
        for (int i = 0; i < 1000; i++) {
            Object deptController = applicationContext.getBean("deptController");
            System.out.println(deptController);
        }
    }
}
