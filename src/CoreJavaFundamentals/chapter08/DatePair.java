package CoreJavaFundamentals.chapter08;

import java.time.LocalDate;

/**
 * DatePair class
 *
 * @author apple
 * @date 2020/2/20
 */
public class DatePair extends Pair<LocalDate> {
    private LocalDate date;

    public DatePair(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public void setFirst(LocalDate first) {
        super.setFirst(first);
    }

    @Override
    public void setSecond(LocalDate second) {
        super.setSecond(second);
    }

    @Override
    public String toString() {
        return "DatePair{" +
                "date=" + date +
                '}';
    }

    public static void main(String[] args) {
        var datePair = new DatePair(LocalDate.now());
        Pair<LocalDate> pair = datePair;
        pair.setFirst(LocalDate.now());
        System.out.println(pair);
    }
}
