package com.company;

public class Complex implements Comparable<Complex> {
    private int realNumber;
    private int imaginaryNumber;

    public Complex(int realNumber, int imaginaryNumber) {
        this.imaginaryNumber = imaginaryNumber;
        this.realNumber = realNumber;
    }
    Complex(String s) throws NumberFormatException {
        if (s.matches("\\d+\\+\\d+i")) {
            String[] arr = s.split("\\+");
            this.realNumber = Integer.parseInt(arr[0]);
            arr[1] = arr[1].substring(0, arr[1].length() - 1);
            this.imaginaryNumber = Integer.parseInt(arr[1]);
        } else if (s.matches("\\d+\\-\\d+i")) {
            String[] arr = s.split("\\-");
            this.realNumber = Integer.parseInt(arr[0]);
            arr[1] = arr[1].substring(0, arr[1].length() - 1);
            this.imaginaryNumber = -Integer.parseInt(arr[1]);
        } else {
            throw new NumberFormatException("输入格式错误");
        }
    }
    public static Complex parseComplex(String s) throws NumberFormatException {
        Complex number = new Complex(0, 0);
        if (s.matches("\\d+\\+\\d+i")) {
            String[] arr = s.split("\\+");
            number.realNumber = Integer.parseInt(arr[0]);
            arr[1] = arr[1].substring(0, arr[1].length() - 1);
            number.imaginaryNumber = Integer.parseInt(arr[1]);
            return number;
        } else if (s.matches("\\d+\\-\\d+i")) {
            String[] arr = s.split("\\-");
            number.realNumber = Integer.parseInt(arr[0]);
            arr[1] = arr[1].substring(0, arr[1].length() - 1);
            number.imaginaryNumber = -Integer.parseInt(arr[1]);
            return number;
        } else {
            throw new NumberFormatException("输入格式错误");
        }
    }
    /**
     * 复数加法的运算（对象方法）
     *
     * @param obj:需要计算的复数
     * @return 计算出的复数结果
     */
    public Complex add(Complex obj) {
        Complex res = new Complex(0, 0);
        res.realNumber = this.realNumber + obj.realNumber;
        res.imaginaryNumber = this.imaginaryNumber + obj.imaginaryNumber;
        return res;
    }

    /**
     * 复数的减法运算（对象方法）
     *
     * @param obj:需要计算的复数
     * @return 计算出的复数结果
     */
    public Complex delete(Complex obj) {
        Complex res = new Complex(0, 0);
        res.realNumber = this.realNumber - obj.realNumber;
        res.imaginaryNumber = this.imaginaryNumber - obj.imaginaryNumber;
        return res;
    }

    @Override
    public String toString() {
        return realNumber + "+" + imaginaryNumber + "i";
    }

    // 判断方法
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Complex) {
            Complex number = (Complex) obj;
            return this.realNumber == number.realNumber && this.imaginaryNumber == number.imaginaryNumber;
        }
        return false;
    }
    /**
     * 比较两个复数模的大小
     * @param number 需要比较的复数
     * @return 执行方法的复数大于比较的复数，返回1，小于返回-1，等于返回0.
     * */
    @Override
    public int compareTo(Complex number) {
        double num1 = Math.sqrt(Math.pow(realNumber, 2) + Math.pow(imaginaryNumber, 2));
        double num2 = Math.sqrt(Math.pow(number.realNumber, 2) + Math.pow(number.imaginaryNumber, 2));
        return Double.compare(num1, num2);
    }
}
