package TheArtOfJavaConcurrencyProgramming.chapter4;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * Profiler class
 *
 * @author apple
 * @date 2020/7/6
 */
public class Profiler {
    private static final ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    @SneakyThrows
    public static void main(String[] args) {
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: " + Profiler.end() + " mills");
    }

    public static final void begin() {
        threadLocal.set(System.currentTimeMillis());
    }

    public static final long end() {
        return System.currentTimeMillis() - threadLocal.get();
    }

}
