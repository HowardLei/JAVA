package CoreJavaFundamentals.chapter08;

import java.lang.reflect.*;
import java.util.*;

/**
 * GenericReflectionTest class
 *
 * @author apple
 * @date 2020/3/14
 */
public class GenericReflectionTest {
    public static void main(String[] args) {
        String name;
        if (args.length > 0) {
            name = args[0];
        } else {
            try (var in = new Scanner(System.in)) {
                System.out.println("Enter a class name (e.g. java.util.Collections):");
                name = in.next();
            }
        }
        try {
            var aClass = Class.forName(name);
            printClass(aClass);
            for (var method : aClass.getMethods()) {
                printMethod(method);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void printClass(Class<?> c1) {
        System.out.print(c1);
        printTypes(c1.getTypeParameters(), "<", ", ", ">", true);
        var genericSuperclass = c1.getGenericSuperclass();
        if (genericSuperclass != null) {
            System.out.print(" extends ");
            printType(genericSuperclass, false);
        }
        printTypes(c1.getGenericInterfaces(), " implements ", ", ", "", false);
        System.out.println();
    }

    public static void printMethod(Method method) {
        var methodName = method.getName();
        System.out.print(Modifier.toString(method.getModifiers()));
        System.out.print(" ");
        printTypes(method.getParameterTypes(), "<", ", ", "> ", true);
        printType(method.getGenericReturnType(), false);
        System.out.print(" ");
        System.out.print(methodName);
        System.out.print("(");
        printTypes(method.getGenericParameterTypes(), "", ", ", ", ", false);
        System.out.println(")");
    }

    public static void printTypes(Type[] types, String pre, String sep, String suf, boolean isDefinition) {
        if (pre.equals("extends") && Arrays.equals(types, new Type[]{Object.class})) {
            return;
        }

        if (types.length > 0) {
            System.out.print(pre);
        }
        for (int i = 0; i < types.length; i++) {
            if (i > 0) {
                System.out.print(sep);
            }
            printType(types[i], isDefinition);
        }
        if (types.length > 0) {
            System.out.print(suf);
        }
    }

    public static void printType(Type type, boolean isDefinition) {
        if (type instanceof Class) {
            var t = (Class<?>) type;
            System.out.print(t.getName());
        } else if (type instanceof TypeVariable) {
            var t = (TypeVariable<?>) type;
            System.out.print(t.getName());
            if (isDefinition) {
                printTypes(t.getBounds(), " extends ", " & ", "", false);
            }
        } else if (type instanceof WildcardType) {
            var t = (WildcardType) type;
            System.out.print("?");
            printTypes(t.getUpperBounds(), " extends ", " & ", "", false);
            printTypes(t.getLowerBounds(), " super ", " & ", "", false);
        } else if (type instanceof ParameterizedType) {
            var t = (ParameterizedType) type;
            var ownerType = t.getOwnerType();
            if (ownerType != null) {
                printType(ownerType, false);
                System.out.print(".");
            }
            printType(t.getRawType(), false);
            printTypes(t.getActualTypeArguments(), "<", ", ", ">", false);
        } else if (type instanceof GenericArrayType) {
            var t = (GenericArrayType) type;
            System.out.print("");
            printType(t.getGenericComponentType(), isDefinition);
            System.out.print("[]");
        }
    }
}