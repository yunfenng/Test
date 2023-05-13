package cn.fengqingyang;

public class Crito2 {

    private static void m1(long... v) {
        System.out.println("Yes");
    }

    private static void m1(int v1, int v2) {
        System.out.println("No");
    }

    public static void main(String[] args) {

        int result1 = Integer.MAX_VALUE + 1;
        int result2 = Integer.MIN_VALUE - 1;

        m1(result1, result2); // No

        System.out.println(result1);
        System.out.println(result2);

    }

}

// 在编译期间既没有检测到溢出，
// 也没有以任何方式将类型从Integer更改成long，
// 因此与重载决策无关。

