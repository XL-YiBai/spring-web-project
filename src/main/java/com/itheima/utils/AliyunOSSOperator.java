package com.itheima.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AliyunOSSOperator {

    public AliyunOSSOperator(AliyunOSSProperties aliyunOSSProperties) {}

//    // 方式一：可以通过 Spring 的 Value 注解，一个个获取在 application.yml 配置的变量内容
//    @Value("${aliyun.oss.endpoint}")
//    private String endpoint;
//    @Value("${aliyun.oss.bucketName}")
//    private String buketName;
//    @Value("${aliyun.oss.region}")
//    private String region;

    // 方式二：定义一个和配置文件相同属性的实体类 AliyunOSSProperties，然后直接给 IOC 容器托管
    @Autowired
    private AliyunOSSProperties aliyunOSSProperties;
}
