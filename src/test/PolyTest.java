package test;

public class PolyTest {
    public static void main(String[] args) {
        Fu fu = new Zi();
        System.out.println(fu.s); //父类
        fu.show(); //子类show...
    }
}

class Fu {
    String s = "父类";
    public void show() {
        System.out.println("父类show...");
    }
}

class Zi extends Fu {
    String s = "子类";
    public void show() {
        System.out.println("子类show...");
    }
}



