package CoreJavaFundamentals.chapter08;

import java.time.LocalDate;

/**
 * PairTest2 class
 *
 * @author apple
 * @date 2020/2/17
 */
public class PairTest2 {
    public static void main(String[] args) {
        var birthdays = new LocalDate[]{
                LocalDate.of(1906, 1, 9),
                LocalDate.of(1815, 12, 10),
                LocalDate.of(1903, 12, 3),
                LocalDate.of(1910, 5, 22)
        };
        var minmax = ArrayAlg.minmax(birthdays);
        System.out.println(minmax.getFirst());
        System.out.println(minmax.getSecond());
    }
}

class Person {

    private boolean isDelicious;

    public Person(Boolean isDelicious) {
        this.isDelicious = isDelicious;
    }

    public static void main(String[] args) {
        var me = new Person(null);
        var you = new Person(false);
        while (true) {
            System.out.println("我做饭你吃吗？");
            if (!you.isDelicious) {
                System.out.println("不吃");
                System.out.println("我做的难吃你就不吃了啊？");
            } else {
                System.out.println("吃");
                System.out.println("我做的不好吃啊");
            }
        }
    }
}