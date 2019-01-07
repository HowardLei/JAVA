package Book;

public class ObjectArray {
    public static void print(Object value[]) {
        if (value != null) {
            for (Object aValue : value) {
                if (aValue != null) {
                    System.out.println(aValue);
                }
            }
        }
    }

    /**
     * 数组的合并
     *
     * @param value1 需要合并的第一个数组
     * @param value2 需要合并的第二个数组
     * @return 合并完成的数组
     */
    public static Object[] concat(Object value1[], Object value2[]) {
        if (value1 == null && value2 == null) {
            return null;
        } else {
            if (value1 == null) {
                return value2;
            }
            if (value2 == null) {
                return value1;
            }
            Object[] array = new Object[value1.length + value2.length];
            int i = 0;
            for (Object aValue1 : value1) {
                array[i++] = aValue1;
                System.out.println(i);
            }
            for (Object aValue2 : value2) {
                array[i++] = aValue2;
            }
            return array;
        }
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[12];
        for (int j = 0; j < a.length; j++) {
            a[j] = j;
        }
        for (Integer integer : a) {
            System.out.println(integer);
        }
        Integer[] b = new Integer[4];
        for (int i = 0; i < b.length; i++) {
            b[i] = i + a[a.length - 1];
        }
        Object[] array = concat(a, b);
        for (var s : array) {
            System.out.println(s);
        }
    }
}