package com.company;

import java.lang.reflect.*;

/**
 * Demo class
 *
 * @author apple
 * @date 2019-08-21
 */
public class Demo {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Test {
    public static void main(String[] args) {
        try {
            var cl = Class.forName("com.company.Demo");
            var cons = cl.getConstructor();
            var instance = cons.newInstance();
            var methods = cl.getDeclaredMethods();
            var fields = cl.getDeclaredFields();
            var constructors = cl.getDeclaredConstructors();
            for (Method method : methods) {
                System.out.println(method.getName());
            }
            AccessibleObject.setAccessible(fields, true);
            for (Field field : fields) {
                System.out.println(field.getName());
            }
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor.getName());
            }
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}