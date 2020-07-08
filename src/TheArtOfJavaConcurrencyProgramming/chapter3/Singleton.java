package TheArtOfJavaConcurrencyProgramming.chapter3;

/**
 * Singleton class
 *
 * @author apple
 * @date 2020/7/6
 */
public class Singleton {
    private static volatile Singleton singleton;

    Singleton() {}

    /**
     * 通过双重校验来创建实例对象，注意：锁哪哪部分会被等待。
     * @return 单例对象
     */
    public static Singleton getInstance() {
        if (singleton == null) {
            // 保证实例化过程中实例化过程不会被打断
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
