package Book;

public class Student extends Person {
    private String ID, department, speciality;
    // 团员属性
    private boolean member;
    Student(String ID, String department, String speciality, boolean member) {
        this();
        this.ID = ID;
        this.department = department;
        this.speciality = speciality;
        this.member = member;
    }

    Student() {
        super();
        this.ID = "";
        this.department = "";
        this.speciality = "";
        this.member = false;
    }
    /**
     * 重写父类的比较方法
     * */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof Student) {
            Student s = (Student)obj;
            return super.equals(s) && this.member == s.member && this.ID.equals(s.ID) && this.speciality.equals(s.speciality) && this.department.equals(s.department);
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + "学号是：" + this.ID + "," + this.department + "系" + this.speciality + "专业的学生。";
    }

}
