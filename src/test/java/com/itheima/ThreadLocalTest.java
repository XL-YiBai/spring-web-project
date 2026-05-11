package com.itheima;

/**
 * ThreadLocal：线程的局部变量
 * 哪个线程存的，只能哪个线程取，也只能哪个线程删，是线程隔离的
 * 一次请求，Tomcat 就会分配一个线程来处理这个请求，也就是一个请求对应一个线程
 */

public class ThreadLocalTest {

    private static ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) {
        local.set("Main Message");

        // 创建线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                local.set("Sub Message");
                System.out.println(Thread.currentThread().getName() + " : " + local.get());
            }
        }).start();

        System.out.println(Thread.currentThread().getName() + " : " + local.get());

        local.remove();

        System.out.println(Thread.currentThread().getName() + " : " + local.get());
    }
}
