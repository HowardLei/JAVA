package CoreJavaFundamentals.chapter09;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * TreeSetTest class
 *
 * @author apple
 * @date 2020/3/22
 */
public class TreeSetTest {
    public static void main(String[] args) {
        var parts = new TreeSet<Item>();
        parts.add(new Item("Toaster", 1234));
        parts.add(new Item("Widget", 4562));
        parts.add(new Item("modem", 9912));
        System.out.println(parts);

        var sortByDescription = new TreeSet<>(
                Comparator.comparing(Item::getDescription)
        );
        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }
}
