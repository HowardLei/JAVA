package CoreJavaFundamentals;

import java.util.Optional;
import java.util.Random;

/**
 * ConstructorTest class
 *
 * @author apple
 * @date 2019-07-24
 */
public class ConstructorTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Harry", 40000);
        staff[1] = new Employee(60000);
        staff[2] = new Employee();

        for (Employee e : staff) {
            System.out.println("name=" + e.getName() + ",id=" + e.getId() + ",salary=" + e.getSalary());
        }
    }
}

class Employee {
    private static int nextID;
    private int id;
    private String name = "";
    private double salary;

    static {
        var generator = new Random();
        nextID = generator.nextInt(10000);
    }

    {
        id = nextID;
        nextID++;
    }

    public Employee(String n, double s) {
        name = n;
        salary = s;
    }
    public Employee(double s) {
        this("Employee #" + nextID, s);
    }
    public Employee() {

    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

}