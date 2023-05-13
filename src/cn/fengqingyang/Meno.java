package cn.fengqingyang;

public class Meno {

    public static void main(String[] args) {
        m(); // 2
    }

    public static void m(int ... a) {
        System.out.println("1");
    }

    public static void m(short ... b) {
        System.out.println("2");
    }

}
