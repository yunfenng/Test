package cn.fengqingyang;

/**
 * What will happen if we run this program?
 * t1
 * t2
 */
public class Meno1 {

    public static void main(String[] args) {

        for (int i = 0; i < 1; i = iplusplus(i)) {
            System.out.println("t1");
        }

    }

    private static int iplusplus(int i) {
        System.out.println("t2");
        return ++i;
    }

}
