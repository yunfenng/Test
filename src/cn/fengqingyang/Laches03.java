package cn.fengqingyang;

public class Laches03 {

    public static void main(String[] args) {
        x((byte)3 + (byte) 5);
    }

    public static void x(Byte i) {
        System.out.println("B");
    }

    public static void x(Number i) {
        System.out.println("N"); //
    }

}
