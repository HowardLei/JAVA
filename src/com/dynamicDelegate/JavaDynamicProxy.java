package com.dynamicDelegate;

import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Proxy;

/**
 * JavaDynamicProxy class
 *
 * @author apple
 * @date 2020/1/25
 */
public class JavaDynamicProxy  {
    public static void main(String[] args) {
        test();
    }
    private static void test() {
        JavaDeveloper tomDeveloper = new JavaDeveloper("Tom");
        JavaDeveloperHandler handler = new JavaDeveloperHandler(tomDeveloper);
        var runnableInterfaces = ArrayUtils.add(new Class[0], Runnable.class);
        var tomDeveloperProxy = (Runnable) Proxy.newProxyInstance(tomDeveloper.getClass().getClassLoader(), runnableInterfaces, handler);

        tomDeveloperProxy.run();
    }
}