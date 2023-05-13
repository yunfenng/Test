package cn.fengqingyang;

public class Laches02 {

    public static void main(String[] args) {

        int i = 0x01;
        int j = 0x10;
        int k = i | j;

        System.out.println(i); // 1
        System.out.println(j); // 16
        System.out.println(k); // 17
        System.out.println(k^i); // 16
        System.out.println(i^k); // 16

    }
}
