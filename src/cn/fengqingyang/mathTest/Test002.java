package cn.fengqingyang.mathTest;

public class Test002 {

    public static void main(String[] args) {
        int a = 150;
        int b = 210;
        int c = 165;

//        int temp = a > b ? a : b;
//        int max = temp > c ? temp : c;

        int max = a > b ? a > c ? a : c : b > c ? b : c;
        System.out.println(max);
    }

}
