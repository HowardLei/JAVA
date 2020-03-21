package CoreJavaFundamentals.chapter08;

import java.util.Objects;

/**
 * PairTest1 class
 *
 * @author apple
 * @date 2020/2/17
 */
public class PairTest1 {
    public static void main(String[] args) {
        var words = new String[]{"Mary", "had", "a", "little", "lamb"};
        var minmax = ArrayAlg.minmax(words);
        System.out.println(minmax.getFirst());
        System.out.println(minmax.getSecond());
    }
}

class ArrayAlg {
    public static <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }
    public static <T extends Comparable<T>> T min(T[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        var smallest = a[0];
        for (var i = 1; i < a.length; i++) {
            if (smallest.compareTo(a[i]) > 0) {
                smallest = a[i];
            }
        }
        return smallest;
    }
    public static <T extends Comparable<T>> Pair<T> minmax(T[] a) {
        if (Objects.isNull(a) || a.length == 0) {
            return null;
        }
        var min = a[0];
        var max = min;
        for (var i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }
            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }
        }
        return new Pair<>(min, max);
    }
}