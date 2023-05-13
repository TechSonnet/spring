package com.techsonnet.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class CalInvocationHandler implements InvocationHandler {

    // 接受委托对象
    private Object object = null;

    // 根据接受的委托对象，返回代理对象
    public Object bind(Object object) {
        this.object = object;

        /**
         * 这个返回代理对象的方法三个参数要格外注意
         *
         * Class<?>[] interfaces：用于获得委托对象的接口信息
         * ClassLoader loader：类加载器，用于根据获得的接口信息，把生成的代理对象加载到 JVM 中
         * InvocationHandler：InvocationHandler实例，传其本身即可
         */
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }


    //实现业务代码和⾮业务代码的解耦合
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(method.getName() + "⽅法的参数是" +
                Arrays.toString(args));
        Object result = method.invoke(this.object, args);
        System.out.println(method.getName() + "⽅法的结果是" + result);
        return result;
    }
}
