package CoreJavaFundamentals.Chapter05;

import java.util.ArrayList;

/**
 * ObjectAnalyzerTest class
 *
 * @author apple
 * @date 2019-08-20
 */
public class ObjectAnalyzerTest {
    public static void main(String[] args) {
        var square = new ArrayList<Integer>();
        for (var i = 0; i < 5; i++) {
            square.add(i * i);
        }
        System.out.println(new ObjectAnalyzer().toString(square));
    }
}
