package Book;

public class Person {
    private int age;
    private String name;
    private Mydate birthday;
    private String sex, province, city;
    private static int count = 0;

    public Person(String name, Mydate birthday, String sex, String provice, String city, int age) {
        this.name = name;
        this.birthday = birthday;
        this.city = city;
        this.sex = sex;
        this.province = provice;
        this.age = age;
        count++;
    }

    public Person(Person p) {
        this(p.name, new Mydate(p.birthday), p.sex, p.province, p.city, p.age);
    }

    public Person() {
        this.city = "";
        this.province = "";
        this.age = 0;
        this.name = "";
        this.birthday = new Mydate(2000, 1, 1);
    }

    public static String showCount() {
        return "一共创建了 " + count + " 个人";
    }

    @Override
    public String toString() {
        return "我是" + this.name + "，今年" + this.age + "岁，家住" + this.province + "省" + this.city + "市人。";
    }
    /**
    * 重写父类的比较方法
    * 格式：if (obj == this) {
            return true;
        } else if (obj instanceof 当前类){
            Person p1 = (当前类) obj;
            return [super.equal(p1) &&] 当前类的属性的比较。 其中如果父类不是 Object 类的时候需要比较父类的属性是否相同。
        }
        return false;
    * */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Person) {
            Person p1 = (Person) obj;
            return this.name.equals(p1.name) && this.birthday.equals(p1.birthday) && this.sex.equals(p1.sex) && this.province.equals(p1.province) && this.city.equals(p1.city) && this.age == p1.age;
        }
        return false;
    }
}
