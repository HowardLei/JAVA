package com.company;

/**
 * StaticTest class
 *
 * @author apple
 * @date 2019-07-24
 */

public class StaticTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Tom", 40000);
        staff[1] = new Employee("Dick", 60000);
        staff[2] = new Employee("Harry", 65000);
        for (Employee e : staff) {
            e.setId();
            System.out.println("name=" + e.getName() + ",id=" + e.getId() + ",salary=" + e.getSalary());
        }
    }
}
/**
 * Employee
 */
class Employee {
    private static int nextID = 1;
    private String name;
    private double salary;
    private int id;

    public Employee(String n, double s) {
        name = n;
        salary = s;
        id = 0;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @return the salary
     */
    public double getSalary() {
        return salary;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     *
     */
    public void setId() {
        id = nextID;
        nextID++;
    }
    /**
     * @return the nextID
     */
    public static int getNextID() {
        return nextID;
    }
    public static void main(String[] args) {
        Employee e = new Employee("Harry", 5000);
        System.out.println(e.getName() + " " + e.getSalary());
    }
}