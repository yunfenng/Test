package niuke.poly;

class A {
    int m = 10;
    public int func1(int a, int b) {
        return a - b;
    }
}

class B extends A {
    int m = 20;
    public int func1(int a, int b) {
        return a + b;
    }
}

public class ChildClass {

    public static void main(String[] args) {
        A a = new B();
        B b = new B();
        System.out.println(a.m);
        System.out.println(b.m);
        System.out.println("Result = " + a.func1(100, 50));
        System.out.println("Result = " + b.func1(100, 50));
    }
}




