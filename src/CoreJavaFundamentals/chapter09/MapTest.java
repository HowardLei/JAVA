package CoreJavaFundamentals.chapter09;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * MapTest class
 *
 * @author apple
 * @date 2020/3/25
 */
public class MapTest {
    public static void main(String[] args) {
        var map = new HashMap<String, Integer>();
        map.put("123", 123);
        map.put("456", 456);
        map.put("789", 789);
//        var otherMap = new HashMap<String, Integer>();
//        otherMap.putAll(map);
//        otherMap.put("456", 123);
//        System.out.println(map);
//
//        map.remove("123");
//
//        map.put("456", 123);
//
//        System.out.println(map.get("789"));
//        map.entrySet().forEach(System.out::println);
//        map.forEach((s, integer) -> {
//            System.out.println("key = " + s + ", value = " + integer);
//        });
//        map.clear();
        var stringIntegerLinkedHashMap = new LinkedHashMap<String, Integer>();
        stringIntegerLinkedHashMap.put("132", 123);
        stringIntegerLinkedHashMap.put("312", 32141);
        stringIntegerLinkedHashMap.putAll(map);
        stringIntegerLinkedHashMap.entrySet().forEach(System.out::println);
    }
}
