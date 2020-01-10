package hm_test.Reflect_Test;

public class Person {
    private String name;
    private String gender;
    private int age;

    private Person() {
        //
    }
    public Person(String name, String gender, int age) {
        super();
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
    //getter、和setter方法
    private String getName() {
        return name;
    }
    private void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "姓名：" + name + "年龄: " + age;
    }
}
