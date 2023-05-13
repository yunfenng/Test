package test;

/**
 * @Author: Jaa
 * @Date: 2023/4/13 21:01
 * @Description:
 */
public class TestFinally02 {

    public static void main(String[] args) {
        System.out.println("the result of test is: " + test());
    }

    private static int test() {
        int i = 0;

        try {
            i++;
            System.out.println("this is try ...");
            System.out.println("the value of i is: " + i);
            return calc(i);
        } catch (Exception e) {
            System.out.println("this is catch ...");
        } finally {
            i++;
            System.out.println("this is finally ...");
            System.out.println("the value of i is: " + i);
        }

        return i;
    }

    private static int calc(int i) {
        System.out.println("this is calc ...");
        System.out.println("the value of i is: " + i);
        return i;
    }

}
