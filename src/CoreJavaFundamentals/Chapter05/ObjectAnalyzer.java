package CoreJavaFundamentals.Chapter05;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * ObjectAnalyzer class
 *
 * @author apple
 * @date 2019-08-20
 */
public class ObjectAnalyzer {
    private ArrayList<Object> visited = new ArrayList<>();

    public String toString(Object obj) {
        if (obj == null) {
            return "null";
        }
        if (visited.contains(obj)) {
            return "...";
        }
        visited.add(obj);
        var cl = obj.getClass();
        if (cl == String.class) {
            return (String)obj;
        }
        if (cl.isArray()) {
            var r = cl.getComponentType() + "[]{";
            for (var i = 0; i < Array.getLength(obj); i++) {
                if (i > 0) {
                    r += ",";
                }
                var val = Array.get(obj, i);
                if (cl.getComponentType().isPrimitive()) {
                    r += val;
                } else {
                    r += toString(val);
                }
            }
            return r + "}";
        }
        var r = cl.getName();
        do {
            r += "[";
            var fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            for (Field field : fields) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    if (!r.endsWith("[")) {
                        r += ",";
                    }
                    r += field.getName() + "=";
                    try {
                        var t = field.getType();
                        var val = field.get(obj);
                        if (t.isPrimitive()) {
                            r += val;
                        } else {
                            r += toString(val);
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            r += "]";
            cl = cl.getSuperclass();
        }
        while (cl != null);
        return r;
    }
}