package CoreJavaFundamentals.chapter09;

import java.util.HashSet;
import java.util.Scanner;

/**
 * SetTest class
 *
 * @author apple
 * @date 2020/3/22
 */
public class SetTest {
    public static void main(String[] args) {
        var words = new HashSet<String>();
        var totalTime = 0L;

        try (var in = new Scanner(System.in)) {
            while (in.hasNext()) {
                var word = in.next();
                var callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
            }
        }
        var iterator = words.iterator();
        for (var i = 0; i <= 20 && iterator.hasNext(); i++) {
            System.out.println(iterator.next());
        }
        System.out.println("....");
        System.out.println(words.size() + " distinct word." + totalTime + " llSeconds");
    }
}
