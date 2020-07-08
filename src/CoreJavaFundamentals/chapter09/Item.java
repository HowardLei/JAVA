package CoreJavaFundamentals.chapter09;

import java.util.Objects;

/**
 * Item class
 *
 * @author apple
 * @date 2020/3/22
 */
public class Item implements Comparable<Item> {
    private String description;
    private int partNumber;

    public Item(String description, int partNumber) {
        this.description = description;
        this.partNumber = partNumber;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", partNumber=" + partNumber +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, partNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        var other = (Item) obj;
        return Objects.equals(description, other.description);
    }

    @Override
    public int compareTo(Item o) {
        var compare = Integer.compare(partNumber, o.partNumber);
        return compare != 0 ? compare : description.compareTo(o.description);
    }
}
