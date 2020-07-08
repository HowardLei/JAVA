package TheArtOfJavaConcurrencyProgramming.chapter1;

/**
 * ConcurrencyTest class
 *
 * @author apple
 * @date 2020/3/28
 */
public class ConcurrencyTest {
    private static final long COUNT = 10000001;

    /**
     * 通过这段程序，只想证明一点，不一定在所有情况下，串行都比并行慢。
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }
    private static void concurrency() throws InterruptedException {
        var start = System.currentTimeMillis();
        var thread = new Thread(() -> {
            var a = 10;
            for (var i = 0; i < COUNT; i++) {
                a += 5;
            }
        });
        thread.start();
        var b = 0;
        for (long i = 0; i < COUNT; i++) {
            b--;
        }
        thread.join();
        var time = System.currentTimeMillis() - start;
        System.out.println("Concurrency :" + time + "ms, b = " + b);
    }
    private static void serial() {
        var start = System.currentTimeMillis();
        var a = 10;
        for (var i = 0; i < COUNT; i++) {
            a += 5;
        }
        var b = 0;
        for (long i = 0; i < COUNT; i++) {
            b--;
        }
        var time = System.currentTimeMillis() - start;
        System.out.println("Serial:" + time + "ms, b = " + b + ", a = " + a);
    }
}
