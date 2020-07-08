package TheArtOfJavaConcurrencyProgramming.chapter1;

import lombok.AllArgsConstructor;

/**
 * ThreadNew class
 *
 * @author apple
 * @date 2020/7/5
 */
@AllArgsConstructor
public class ThreadNew extends Thread {
    private Person person;
    private int flag;
    private String name;

    @Override
    public void run() {
        System.out.println(name + "开始启动");
        if (flag == 1) {
            person.run1();
        } else {
            person.run2();
        }
    }
}
