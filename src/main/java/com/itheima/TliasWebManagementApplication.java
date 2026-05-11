package com.itheima;

import com.itheima.utils.AliyunOSSOperator;
import com.itheima.utils.AliyunOSSProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

@ServletComponentScan // 开启了 Springboot 对 Servlet 组件的支持
@SpringBootApplication
public class TliasWebManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(TliasWebManagementApplication.class, args);
    }


    // 如果需要将第三方的类声明成 Bean 对象交给 IOC 容器管理，可以通过在启动类添加方法返回这个对象实例，并添加@Bean注解
    // 如果我们需要使用的 AliyunOSSProperties 对象已经是一个 Bean 对象，可以直接在入参中自动装配进来
    // 这种形式生成的 Bean 对象默认名字是该方法的名字
    // 但是一般不建议把它定义在启动类中，可以把这些 Bean 放到配置类集中管理，通过 @Configuration 声明一个配置类，例如这里我们移动到 CommonConfig.java 中
//    @Bean
//    public AliyunOSSOperator aliyunOSSOperator(AliyunOSSProperties aliyunOSSProperties) {
//        return new AliyunOSSOperator(aliyunOSSProperties);
//    }

}
