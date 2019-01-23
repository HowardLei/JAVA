package Book;

public class NumberRunnable implements Runnable {
    int number;

    public NumberRunnable(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (var i = this.number; i < 50; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        // 用 lambda 表达式创建线程。注意：这里面的第一个参数原本为 runnable 接口。但是 runnable 接口当中的方法就实现一个 run 方法。所以可以利用 lambda 表达式自动推导表达式。
        var thread1 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
        }, "王尼玛的线程");
        thread1.start();
        // 默认方法创建一个线程并执行当前线程的线程体。
        var target = new NumberRunnable(1);
        var thread = new Thread(target);
        thread.start();
    }

}