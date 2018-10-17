package com.company;

public class Student extends Person {
    protected String studentID;
    protected int grade;
    Student() {
        super(0, "none", true);
        this.studentID = "0";
        this.grade = 1;
    }

    Student(int age, String name, boolean sex, String studentID, int grade) {
        super(age, name, sex);
        this.studentID = studentID;
        this.grade = grade;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentID() {
        return this.studentID;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return this.grade;
    }
}