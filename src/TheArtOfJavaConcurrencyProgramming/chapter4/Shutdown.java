package TheArtOfJavaConcurrencyProgramming.chapter4;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * Shutdown class
 *
 * @author apple
 * @date 2020/7/6
 */
public class Shutdown {
    @SneakyThrows
    public static void main(String[] args) {
        var runner = new Runner();
        var countThread = new Thread(runner, "CountThread");
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();

        var two = new Runner();
        countThread = new Thread(two, "CountThread");
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
        two.cancel();
    }

    private static class Runner implements Runnable {
        private long i;
        private volatile boolean on = true;
        @Override
        public void run() {
            while (on && Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("count i = " + i);
        }

        public void cancel() {
            on = false;
        }
    }
}
