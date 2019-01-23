package Book;
/*
* 多线程总结：
* 1、自定义线程继承自 Thread 类（Thread 类本身已经实现 Runnable 接口）
* 2、一个线程在构造方法中，可以设置线程名（如果不自己设置，Java将自己提供一个线程名）、线程的优先级。
* 3、在自定义的线程体中重写 run 方法来设置这个线程做什么事情。已实现的 run 方法称为该线程的线程体。
* 4、每当要执行一个线程体的时候，需要先创建一个线程对象，重写他的 run 方法，在对线程对象调用 start 方法即可。（注意：调用 start 方法并不意味着该线程就能立刻执行，只是该线程的状态为 RUNNABLE ，在 JVM 中他正在执行，但可能等操作系统给他的其他资源（例如处理器）。）
* */
public class NumberThread extends Thread {

    private int first;

    public NumberThread(String name, int first) {
        super(name);
        this.first = first;
    }

    public NumberThread() {
        super();
        this.first = 0;
    }

    //当一个线程开始执行，调用 run 方法来执行。（注意：run 方法与程序执行的线程是否不同得看是在什么时候执行，如果是在主线程调用 run 方法，则在主线程执行，如果是调用线程对象的 start 方法，则 JVM 会自动为该线程开辟一个线程，执行 run 方法）
    @Override
    public void run() {
        System.out.println(this.getName() + ": ");
        for (int i = first; i < 10; i += 2) {
            System.out.println(i);
        }
        System.out.println(this.getName() + "结束");
    }

    public static void main(String[] args) {
        var firstThread = new NumberThread("奇数线程", 1);
        var secondThread = new NumberThread("偶数线程", 2);
        var demoThread = new NumberThread();
        var thread = new NumberThread();
        demoThread.start();
        firstThread.start();
        secondThread.start();
        System.out.println(demoThread.getState());
        System.out.println("Thread.activeCount() = " + Thread.activeCount());
    }
}
