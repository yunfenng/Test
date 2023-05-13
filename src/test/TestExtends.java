package test;

public class TestExtends {

    public static void main(String[] args) {
        Base base = new Son();
        base.print();
    }
}

class Base {
    int i = 9;

    public void print() {
        System.out.println("父类的print...");
        printf();
    }

    public void printf() {
        System.out.println("父类的printf...");
        System.out.println(i);
    }
}

class Son extends Base {
    int i = 7;

    public void printf() {
        System.out.println("子类的printf...");
        super.printf();
        System.out.println(i);
    }
}