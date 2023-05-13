package cn.fengqingyang;

public class Ion implements Runnable {

    public static void main(String[] args) {

        Thread t = new Thread(new Ion());
        t.start();
        System.out.println("2");
        t.run();
        System.out.println("3");
    }

    @Override
    public void run() {
        System.out.println("1");
    }
}

// 2
// 1
// 3
// 1