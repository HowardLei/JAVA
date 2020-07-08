package com.dynamicDelegate;

import java.lang.reflect.*;

/**
 * JavaDeveloperHandler class
 *
 * @author apple
 * @date 2020/6/18
 */
public class JavaDeveloperHandler implements InvocationHandler {

    Object object;

    public JavaDeveloperHandler(Object object) {
        this.object = object;
    }

    /**
     * 代理对象调用方法的时候触发该方法
     *
     * @param proxy  代理对象
     * @param method 代理对象调用的方法对象
     * @param args   代理对象调用的方法保存的参数
     * @return 原对象调用方法后的返回值
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("听音乐....");
        method.invoke(object, args);
        System.out.println("打游戏....");
        return null;
    }
}
