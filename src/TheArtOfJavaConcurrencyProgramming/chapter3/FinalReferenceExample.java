package TheArtOfJavaConcurrencyProgramming.chapter3;

/**
 * FinalReferenceExample class
 *
 * @author apple
 * @date 2020/7/6
 */
public class FinalReferenceExample {
    final int[] array;
    static FinalReferenceExample example;
    public FinalReferenceExample() {
        array = new int[1];
        array[0] = 1;
    }

    public static void writeOne() {
        example = new FinalReferenceExample();
    }
}
