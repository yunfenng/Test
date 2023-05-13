package test;

/**
 * @Author: Jaa
 * @Date: 2023/4/13 20:42
 * @Description:
 */
public class TestFinally01 {

    public static void main(String[] args) {
        try {
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally...");
        }
    }
}
