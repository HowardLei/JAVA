package TheArtOfJavaConcurrencyProgramming.chapter1;

/**
 * Test class
 *
 * @author apple
 * @date 2020/7/5
 */
public class Test {
    public static void main(String[] args) {
        var person = new Person();
        var t1 = new ThreadNew(person, 1, "T1线程");
        var t2 = new ThreadNew(person, 2, "T2线程");

        t1.start();
        t2.start();
    }
}
