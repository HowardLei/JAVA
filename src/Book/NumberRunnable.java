package Book;

public class NumberRunnable implements Runnable{
    int number;

    public NumberRunnable(int number) {
        this.number = number;
    }

    @Override
    public void run() {
    }

    public static void main(String[] args) {
        var target = new NumberRunnable();
        var thread = new Thread(target, "1stThead");
        thread.start();
    }
}
