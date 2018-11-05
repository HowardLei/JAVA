package Shape;

public class Square implements Area {
    private Point p1, p2;

    // 判断图形是不是正方形
    public boolean isSquare() {
        if (Math.abs(p1.getX() - p2.getX()) == Math.abs(p1.getY() - p2.getY())) {
            return true;
        } else {
            return false;
        }
    }

    private double length() {
        return Math.abs(p1.getX() - p2.getX());
    }

    @Override
    public double area() {
        return Math.abs(p1.getX() - p2.getX()) * Math.abs(p1.getY() - p2.getY());
    }

    @Override
    public String toString() {
        return String.format("这个正方形的边长为 %lf cm，面积为 %lf cm^2。", this.length(), this.area());
    }
}
