package Shape;

public class Point {

    private double x;
    private double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    Point() {
        this.x = 0;
        this.y = 0;
    }

    Point(Point point) {
        this(point.x, point.y);
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    protected double getX() {
        return this.x;
    }

    protected double getY() {
        return this.y;
    }
}
