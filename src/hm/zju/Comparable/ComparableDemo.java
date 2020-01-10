package hm.zju.Comparable;

import java.util.Iterator;
import java.util.TreeSet;

public class ComparableDemo {
    public static void main(String[] args) {
        TreeSet ts = new TreeSet<Student>();
        ts.add(new Student("aaa",10));
        ts.add(new Student("bbb",12));
        ts.add(new Student("ccc",19));
        ts.add(new Student("ddd",14));
        ts.add(new Student("eee",18));
        Iterator it = ts.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

class Student implements Comparable {
    private String name;
    private int age;
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name + this.age;
    }
    public int compareTo(Object o) {
        if (!(o instanceof Student)) {
            throw new RuntimeException("not a student member!");
        }

        Student s = (Student)o;
        System.out.println(this.name+" compareTo "+s.name);
        if (this.age == s.age) {
            return 0;
        }
        else if(this.age > s.age) {
            return 1;
        }
        else {
            return -1;
        }

    }

}
