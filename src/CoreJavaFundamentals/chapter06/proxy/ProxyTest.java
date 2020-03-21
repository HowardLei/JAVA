package CoreJavaFundamentals.chapter06.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 * ProxyTest class
 *
 * @author apple
 * @date 2020/2/14
 */
public class ProxyTest {

    public static void main(String[] args) {
        // 创建一个数组，用来保存代理对象
        var elements = new Object[1000];
        for (var i = 0; i < elements.length; i++) {
            var value = i + 1;
            var handler = new TraceHandler(value);
            var interfaces = new Class[]{Comparable.class};
            elements[i] = Proxy.newProxyInstance(null, interfaces, handler);
        }
        var key = new Random().nextInt(elements.length) + 1;
        // 通过二分查找查找元素。
        var result = Arrays.binarySearch(elements, key);
        if (result >= 0) {
            System.out.println(elements[result]);
        }
    }
}

/**
 * 创建一个实现调用处理器（InvocationHandler）接口的类，其中的 invoke 方法为当代理对象触发了接口数组当中的方法的时候，该方法就会先于原调用方法执行。
 */
class TraceHandler implements InvocationHandler {
    // 保存
    private Object target;

    public TraceHandler(Object target) {
        this.target = target;
    }

    /**
     * 代理对象调用方法的时候触发该方法
     * @param proxy 代理对象
     * @param method 代理对象调用的方法对象
     * @param args 代理对象调用的方法保存的参数
     * @return 原对象调用方法后的返回值
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print(target);
        System.out.print("." + method.getName() + "(");
        if (Objects.nonNull(args)) {
            for (var i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i < args.length - 1) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println(")");
        // 如果还想触发原对象的方法的话，需要手动调用 method.invoke 方法来指定调用对象和调用参数
        // 返回值即为代理对象触发原方法的返回值。
        return method.invoke(target, args);
    }
}
