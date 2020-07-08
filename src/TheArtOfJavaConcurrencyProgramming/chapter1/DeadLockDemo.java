package TheArtOfJavaConcurrencyProgramming.chapter1;

/**
 * DeadLockDeml class
 *
 * @author apple
 * @date 2020/3/28
 */
public class DeadLockDemo {
    private static String A = "A";
    private static String B = "B";
    public static void main(String[] args) {
//        new DeadLockDemo().deadLock();
        System.out.println("Double.toString(4312.321) = " + Double.toString(4312.321));
    }
    private void deadLock() {
        var thread = new Thread(() -> {
            synchronized (A) {
                try {
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B) {
                    System.out.println("1");
                }
            }
        });
        var thread1 = new Thread(() -> {
            synchronized (B) {
                synchronized (A) {
                    System.out.println("2");
                }
            }
        });
        thread.start();
        thread1.start();
    }
}
