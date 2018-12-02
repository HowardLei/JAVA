package com.company;

public class Main {

    public static void main(String[] args) {
        Complex number = new Complex("2+3i");
        Complex number1;
        try {
            number1 = new Complex("avsa+2");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            number1 = new Complex(0, 0);
            System.out.println(number1);
        }
        Complex number2 = new Complex(5, 3);
        number1 = number.add(number2);
        System.out.println("number + number2 的结果为：" + number1.toString());
        Complex number3 = new Complex(number);
        System.out.println("number 与 number1 的模比较结果为：" + IntToString(number.compareTo(number1)));
        System.out.println("number 与 number3 的模比较结果为：" + IntToString(number.compareTo(number3)));
        System.out.println("number 与 number2 是否相同？ 答：" + BoolToString(number.equals(number2)));
        System.out.println("number 与 number3 是否相同？ 答：" + BoolToString(number.equals(number3)));
    }

    /**
     * 调用 compareTo方法的时候返回的结果转换成串
     *
     * @param res 比较的时候转换的结果
     * @return 返回的串
     */
    public static final String IntToString(int res) {
        if (res == 0) {
            return "相同";
        } else if (res == -1) {
            return "小于";
        } else if (res == 1) {
            return "大于";
        } else {
            return "结果不对";
        }
    }

    public static final String BoolToString(boolean res) {
        if (res == true) {
            return "相同";
        } else {
            return "不同";
        }
    }
}