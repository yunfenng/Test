package test;

public class TestString01 {

    public static void main(String[] args) {
        f();
    }

    public static void f() {
        String[] a = new String[2];
        Object[] b = a;
        a[0] = "hi";
        b[1] = Integer.valueOf(42);
        //Exception in thread "main" java.lang.ArrayStoreException: java.lang.Integer
    }

}
