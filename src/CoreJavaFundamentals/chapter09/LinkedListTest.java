package CoreJavaFundamentals.chapter09;

import java.util.*;

/**
 * LinkedListTest class
 *
 * @author apple
 * @date 2020/3/21
 */
public class LinkedListTest {
    public static void main(String[] args) {
        var stringList = new LinkedList<String>();
        stringList.add("Amy");
        stringList.add("Carl");
        stringList.add("Erica");

        var stringLinkedList = new LinkedList<String>();
        stringLinkedList.add("Bob");
        stringLinkedList.add("Doug");
        stringLinkedList.add("Frances");
        stringLinkedList.add("Gloria");

        var stringListIterator = stringList.listIterator();
        var iterator = stringLinkedList.iterator();

        while (iterator.hasNext()) {
            if (stringListIterator.hasNext()) {
                stringListIterator.next();
            }
            stringListIterator.add(iterator.next());
            System.out.println(stringListIterator.nextIndex());
        }

        System.out.println(stringList);
        iterator = stringLinkedList.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            if (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            }
        }

        System.out.println(stringLinkedList);

        stringList.removeAll(stringLinkedList);

        System.out.println(stringList);
        List<String> strings = new ArrayList<>();
        strings = Collections.synchronizedList(strings);
    }
}