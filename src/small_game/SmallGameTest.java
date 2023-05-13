package small_game;

import java.util.Random;

public class SmallGameTest {

    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            int a = r.nextInt(14) + 1;
            int b = 14 - a;
            int c = 12 - a;
            int d = 9 - c;

            if (b - d == 7) {
                System.out.println(a + " + " + b + " = 14");
                System.out.println("+   -");
                System.out.println(c + " + " + d + " = 9");
                System.out.println("|| ||");
                System.out.println("12  7");
                System.out.println("-----------------------");
                System.out.println("A = " +a + ", B = " + b + ", C = " + c + ", D = " + d);
                break;
            }
        }
    }
}

