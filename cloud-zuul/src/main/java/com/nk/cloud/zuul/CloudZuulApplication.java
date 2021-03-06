package com.nk.cloud.zuul;

import com.netflix.zuul.filters.FilterRegistry;
import com.nk.cloud.zuul.filter.PreRequsetFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


/**
 * Created on 2017/10/19.
 */

@SpringBootApplication
//@EnableZuulProxy是@EnableZuulServer的超集。换句话说，@EnableZuulProxy包含@EnableZuulServer安装的所有过滤器。
// “代理”中的其他过滤器启用路由功能。如果你想要一个“空白”Zuul，你应该使用@EnableZuulServer。
@EnableZuulProxy
public class CloudZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudZuulApplication.class,args);

        //添加zuul自定义过滤器
        FilterRegistry registration=FilterRegistry.instance();
        registration.put("PreRequestFilter",new PreRequsetFilter());

    }

    @Component
    //spring boot初始化完成后会自动执行本类的run方法
    public static class MyCommandLineRunner implements CommandLineRunner {

        @Value("${test.name}")
        public String testName;

        @Autowired
        private JavaMailSender javaMailSender;

        @Override
        public void run(String... args) throws Exception {
            System.out.println("spring boot 启动后会执行这个方法");
            System.out.println(testName);

            System.out.println(javaMailSender.toString());
        }
    }
}
