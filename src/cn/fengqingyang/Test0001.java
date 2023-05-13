package cn.fengqingyang;

public class Test0001 {

    public static void main(String[] args) {

        String s = "abc";
        s = s + 1 + 2;
        s = s + (2 + 2);
        // String a = s.concat("1").concat("2");
        System.out.println(s.concat("1").concat("2"));
        // s.concat("" + 2 + 2);
        System.out.println(s.concat("" + 2 + 2));
        System.out.println(s);

    }

}
