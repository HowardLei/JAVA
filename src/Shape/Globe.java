package Shape;

public class Globe implements Area, Volume {

    private double radious;
    private static final double pi = Math.PI;

    // 自定义初始化半径
    public Globe(double radious) {
        this.radious = radious;
    }
    // 初始化半径为1
    private Globe() {
        this(1);
    }

    @Override
    public double area() {
        return 4 * pi * Math.pow(radious, 2);
    }

    @Override
    public double volume() {
        return 4.0 / 3 * pi * Math.pow(radious, 3);
    }

    @Override
    public String toString() {
        return "这个球的半径为 " + radious + " m，表面积为 " + area() + " ，体积为 " + volume() + "";
    }
}
