package Shape;

public class Line {
    private Point x, y;

    Line(Point p1, Point p2) {
        this.x = p1;
        this.y = p2;
    }

    public double length() {
        double x = Math.pow(this.x.getX() - this.y.getX(), 2) + Math.pow(this.x.getY() - this.y.getY(), 2);
        return Math.sqrt(x);
    }

    public final String lengthString() {
        return this.length() + "";
    }

    @Override
    public String toString() {
        return "这条直线的长度为" + this.length();
    }
}
