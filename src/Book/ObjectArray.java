package Book;

import javax.swing.text.StyledEditorKit;

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
            int i = 0, j = 0;
            for (int k = 0; k < value1.length; k++) {
                array[i++] = value1[k];
            }
            for (int q = 0; q < value2.length; q++) {
                array[i++] = value2[q];
            }
            return array;
        }
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[12];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        Integer[] b = new Integer[4];
        for (int i = 1; i < b.length; i++) {
            b[i] = i;
        }
        Object[] array = concat(a, b);
        for (Object i: array) {
            System.out.println(i);
        }
    }
}