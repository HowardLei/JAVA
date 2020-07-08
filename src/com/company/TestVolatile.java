package com.company;

/**
 * TestVolatile class
 *
 * @author apple
 * @date 2020/4/14
 */
public class TestVolatile {
    public static void main(String[] args) {
        var runnable = new RunnableImpl();
        var thread = new Thread(runnable);
        thread.start();
        while (true) {
            if (runnable.isFlag()) {
                System.out.println("主线程读取到的 flag 为" + runnable.isFlag());
                break;
            }
        }
    }
}

class RunnableImpl implements Runnable {

    public boolean isFlag() {
        return flag;
    }

    private boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("ThreadDemo 线程修改后的 flag = " + flag);
    }
}