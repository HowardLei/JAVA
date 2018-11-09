package Shape;

public class Square extends CloseFigure implements Area{

    private Point p1, p2;

    public Square(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Square() {
        this(new Point(), new Point(1, 1));
    }

    /**
     * 判断一个图形是不是正方形
     * @return 是不是正方形
     */
    public boolean isSquare() {
        return Math.abs(p1.getX() - p2.getX()) == Math.abs(p1.getY() - p2.getY());
    }

    private double length() {
        return Math.abs(p1.getX() - p2.getX());
    }

    /**
     * 求正方形的面积
     * @return 面积大小
     */
    @Override
    public double area() {
        return Math.abs(p1.getX() - p2.getX()) * Math.abs(p1.getY() - p2.getY());
    }

    @Override
    public String toString() {
        return String.format("这个正方形的边长为 %f cm，面积为 %f cm^2。", this.length(), this.area());
    }
}
