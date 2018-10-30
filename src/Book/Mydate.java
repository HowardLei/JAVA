package Book;

public class Mydate {
    private int year;
    private int month;
    private int day;

    public Mydate(int year, int month, int date) {
        this.year = year;
        this.day = date;
        this.month = month;
    }

    public Mydate(Mydate date) {
        this(date.year, date.month,date.day);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Mydate) {
            Mydate mydate = (Mydate) obj;
            return this.year == mydate.year && this.month == mydate.month && this.day == mydate.day;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%d年%02d月%02d日\n", this.year, this.month, this.day);
    }
}
