package com.techsonnet.aop;

import com.techsonnet.aop.impl.CalImpl;

public class AopTest {
    public static void main(String[] args) {
        // 实例化委托对象
        Cal cal = new CalImpl();

        // 获取代理对象
        CalInvocationHandler calInvocationHandler = new CalInvocationHandler();
        Cal proxy = (Cal) calInvocationHandler.bind(cal);
        proxy.add(10,3);
    }
}
