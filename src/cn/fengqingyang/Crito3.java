package cn.fengqingyang;

public class Crito3 {

    public static void main(String[] args) {

        /*
        * 从 0开始的编码是八进制表示法，故020 == 16
        * 020 == 16
        * */

        int x = 020;

        switch (x) {
            case 020:
                System.out.println("A");
            case 016:
                System.out.println("B");
            default:
                System.out.println("C");
                break;
        }

    }

}
