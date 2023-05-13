package cn.fengqingyang;

import java.util.Objects;

public class testObject {

    public static void main(String[] args) {

        Person dad = new Person("黄成栋", "man", 45);
        Person mom = new Person("董美玲", "woman", 43);
        Person son = new Person("黄小栋", "man", 19);

        System.out.println(dad); // cn.fengqingyang.Person@eb994c71
        System.out.println(mom); // cn.fengqingyang.Person@569ff50f
        System.out.println(son); // cn.fengqingyang.Person@e8de9df8

        System.out.println(dad.hashCode()); // -342274959
        System.out.println(mom.hashCode()); // 1453323535
        System.out.println(son.hashCode()); // -388063752

        Person p1 = new Person();
        Person p2 = new Person();

        System.out.println(p1 == p2); // false
        System.out.println(p1.equals(p2)); // true

        System.out.println(p1.hashCode()); // 29791
        System.out.println(p2.hashCode()); // 29791

    }

}

class Person {
    private String name;
    private String sex;
    private int age;

    public Person() {
    }

    public Person(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(sex, person.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sex, age);
    }
}

