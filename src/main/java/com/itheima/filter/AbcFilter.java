// 项目中多个过滤器会形成过滤器链
// 存在多个过滤器时，会默认按照过滤器类名排序，成为一个过滤器链，所以先进入 AbcFilter 再进入 DemoFilter
package com.itheima.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

//@WebFilter(urlPatterns = "/*") // 拦截所有请求
//@WebFilter(urlPatterns = "/login") // 拦截具体路径
//@WebFilter(urlPatterns = "/emps/*") // 拦截 /emps 开头的路径
@Slf4j
public class AbcFilter implements Filter {

    // 初始化方法，在Web服务器启动的时候执行，只执行一次
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init 初始化方法运行...");
    }

    // 拦截到请求之后执行，会执行多次
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("拦截到了请求...放行前...");
        // 放行
        filterChain.doFilter(servletRequest, servletResponse);

        log.info("拦截到了请求...放行后..."); // 相当于访问完资源之后，回到 Filter 进行收尾
    }

    // 销毁方法，Web服务器关闭的时候执行，只执行一次
    @Override
    public void destroy() {
        log.info("destroy 销毁方法...");
    }
}
