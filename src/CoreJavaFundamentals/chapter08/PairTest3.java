package CoreJavaFundamentals.chapter08;

import java.util.ArrayList;
import java.util.Objects;

/**
 * PairTest3 class
 *
 * @author apple
 * @date 2020/3/12
 */
public class PairTest3 {
    public static void main(String[] args) {
        var arrayListClass = ArrayList.class;
        var fields = arrayListClass.getFields();
        var declaredFields = arrayListClass.getDeclaredFields();
        System.out.println(fields.length);
        System.out.println(declaredFields.length);
    }
}

class PairAlg {
    public static boolean hasNulls(Pair<?> p) {
        return Objects.isNull(p.getFirst()) || Objects.isNull(p.getSecond());
    }

    public void swap(Pair<?> pair) {
        pair.setFirst(null);
        var first = pair.getFirst();
        var name = first.getClass().getName();
        swapHelper(pair);
    }

    public static <T> void swapHelper(Pair<T> pair) {
        var first = pair.getFirst();
        pair.setFirst(pair.getSecond());
        pair.setSecond(first);
    }
}