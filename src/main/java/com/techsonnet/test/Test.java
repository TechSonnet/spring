package com.techsonnet.test;

import com.techsonnet.aop.Cal;
import com.techsonnet.entity.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Cal proxy = (Cal) applicationContext.getBean("calImpl");
        proxy.add(1,1);
    }
}
