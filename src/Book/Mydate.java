package Book;

public class Mydate {
    private int year;
    private int month;
    private int date;

    Mydate(int year, int month, int date) {
        this.year = year;
        this.date = date;
        this.month = month;
    }

    Mydate(Mydate date) {
        this(date.year, date.month,date.date);
    }

    @Override
    public String toString() {
        return String.format("%d年%02d月%02d日\n", this.year, this.month, this.date);
    }
}
