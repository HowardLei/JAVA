package com.company;

public class Complex implements Comparable<Complex> {

    private double realNumber;
    private double imaginaryNumber;

    public Complex(double realNumber, double imaginaryNumber) {
        this.imaginaryNumber = imaginaryNumber;
        this.realNumber = realNumber;
    }

    /**
     * 字符串的构造方法，如果不成功抛出 NumberFormatException
     *
     * @param s 需要进行构造的字符串
     */
    public Complex(String s) throws NumberFormatException {
        // FIXME: 正则表达式还不对，匹配不上复数计算式
        if (s.matches("\\d+\\+\\d+i")) {
            String[] arr = s.split("\\+");
            this.realNumber = Double.parseDouble(arr[0]);
            arr[1] = arr[1].substring(0, arr[1].length() - 1);
            this.imaginaryNumber = Double.parseDouble(arr[1]);
        } else if (s.matches("\\d+\\-\\d+i")) {
            String[] arr = s.split("\\-");
            this.realNumber = Double.parseDouble(arr[0]);
            arr[1] = arr[1].substring(0, arr[1].length() - 1);
            this.imaginaryNumber = -Double.parseDouble(arr[1]);
        } else {
            throw new NumberFormatException("输入格式错误");
        }
    }

    /**
     * 拷贝构造方法
     *
     * @param number 需要重新创建的复数
     */
    public Complex(Complex number) {
        this.realNumber = number.realNumber;
        this.imaginaryNumber = number.imaginaryNumber;
    }

    public Complex() {
        this(0, 0);
    }

    public double getRealNumber() {
        return realNumber;
    }

    public double getImaginaryNumber() {
        return imaginaryNumber;
    }

    /**
     * 将一个串转化为复数，如果能转化返回转化成功的复数，否则抛出 NumberFormatException
     *
     * @param s 需要转化的字符串
     * @return 转化成功的复数对象
     */
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

    /**
     * 复数乘法
     * @param obj 乘数
     * @return 积
     * */
    public Complex multiple(Complex obj) {
        var real = this.realNumber * obj.realNumber - this.imaginaryNumber * obj.imaginaryNumber;
        var image = this.imaginaryNumber * obj.realNumber + this.realNumber * obj.imaginaryNumber;
        return new Complex(real, image);
    }

    /**
     * 复数除法
     * @param obj 除数
     * @return 商
     */
    public Complex divide(Complex obj) {
        var down = Math.pow(obj.realNumber, 2) + Math.pow(obj.imaginaryNumber, 2);
        var realUP = this.realNumber * obj.realNumber + this.imaginaryNumber * obj.imaginaryNumber;
        var imageUP = this.imaginaryNumber * obj.realNumber - this.realNumber * obj.imaginaryNumber;
        return new Complex(realUP / down, imageUP / down);
    }

    @Override
    public String toString() {
        return realNumber + "+" + imaginaryNumber + "i";
    }

    /**
     * 判断两个复数是否相同
     *
     * @param obj 需要比较复数
     * @return 如果相同返回 true ，否则返回 false
     */
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
     * 比较两个复数模的大小，实现的是 Comparable 接口中的方法
     *
     * @param number 需要比较的复数
     * @return 执行方法的复数大于比较的复数，返回1，小于返回-1，等于返回0.
     */
    @Override
    public int compareTo(Complex number) {
        double num1 = Math.sqrt(Math.pow(realNumber, 2) + Math.pow(imaginaryNumber, 2));
        double num2 = Math.sqrt(Math.pow(number.realNumber, 2) + Math.pow(number.imaginaryNumber, 2));
        return Double.compare(num1, num2);
    }

}
