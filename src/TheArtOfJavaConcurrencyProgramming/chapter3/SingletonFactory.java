package TheArtOfJavaConcurrencyProgramming.chapter3;

/**
 * SingletonFactory class
 *
 * @author apple
 * @date 2020/7/6
 */
public class SingletonFactory {
    private static class SingletonHolder {
        private static final Singleton singleton = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.singleton;
    }
}
