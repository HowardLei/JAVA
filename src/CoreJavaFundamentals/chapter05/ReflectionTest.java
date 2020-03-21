package CoreJavaFundamentals.chapter05;

import java.lang.reflect.*;
import java.util.Scanner;

/**
 * ReflectionTest class
 *
 * @author apple
 * @date 2019-08-19
 */
public class ReflectionTest {
    public static void main(String[] args) {
        System.out.println(int.class.getName());
        var t = int.class;
        String name;
        if (args.length > 0) {
            name = args[0];
        } else {
            var in = new Scanner(System.in);
            System.out.println("Enter class name (e.g. java.util.Date): ");
            name = in.next();
        }
        try {
            var c1 = Class.forName(name);
            var supercl = c1.getSuperclass();
            var modifiers = Modifier.toString(c1.getModifiers());
            System.out.println(modifiers);
            if (modifiers.length() > 0) {
                System.out.print(modifiers + "");
            }
            System.out.print(" class " + name);
            if (supercl != null && supercl != Object.class) {
                System.out.print(" extends " + supercl.getName());
            }
            System.out.print(" {\n");
            printConstructors(c1);
            System.out.println();
            printMethods(c1);
            System.out.println();
            printFields(c1);
            System.out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
    public static void printConstructors(Class c1) {
        var constructors = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            var name = constructor.getName();
            System.out.print("   ");
            var modifiers = Modifier.toString(constructor.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + "");
            }
            System.out.print(name + "");
            var paramTypes = constructor.getParameterTypes();
            for (var i = 0; i < paramTypes.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }
    public static void printMethods(Class c1) {
        var methods = c1.getMethods();
        for (Method method : methods) {
            var retType = method.getReturnType();
            var name = method.getName();
            System.out.print("   ");
            var modifiers = Modifier.toString(method.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(retType.getName() + " " + name + "(");
            var paramTypes = method.getParameterTypes();
            for (var i = 0; i < paramTypes.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }
    public static void printFields(Class c1) {
        var fields = c1.getFields();
        for (Field field : fields) {
            var type = field.getType();
            var name = field.getName();
            System.out.print("   ");
            var modifiers = Modifier.toString(field.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(type.getName() + " " + name + ";");
        }
    }
}

