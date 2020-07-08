package CoreJavaFundamentals.chapter09;

import java.util.ArrayList;
import java.util.Collections;

/**
 * ShuffleTest class
 *
 * @author apple
 * @date 2020/3/26
 */
public class ShuffleTest {
    public static void main(String[] args) {
        var initialCapacity = 50;
        var numbers = new ArrayList<Integer>(initialCapacity);
        for (int i = 0; i < initialCapacity; i++) {
            numbers.add(i);
        }
        var integers = numbers.toArray(Integer[]::new);
        Collections.shuffle(numbers);
        var integerList = numbers.subList(0, 6);
        Collections.sort(integerList);
        System.out.println(integerList);
    }
}
