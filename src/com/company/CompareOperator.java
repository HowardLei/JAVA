package com.company;

public class CompareOperator {
    public static void demo() {
        /*
        * 关于运算符的总结
        * 1、equals 方法与 == 之间的异同点
        *   '=='生成的是一个 boolean 结果，它们计算的是操作数的值之间的关系”
        *   注意：这个例子中，str2 引用的对象是一个新的对象，只是里面的数据与 str1 相同。 str3 同理。
        * */
        var str1 = "abc";
        var str2 = new String(str1);
        var str3 = new String(str2);
        System.out.println(str2 == str3);
    }
}
