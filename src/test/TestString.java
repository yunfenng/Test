package test;

public class TestString {

    public static void main(String[] args) {
        // 使用 == 符合预期的情况，原因：指向相同的内存地址
        boolean bool1 = "val" == "val";
        System.out.println(bool1); // 输出：true

        // 使用 == 符合预期的情况，原因：指向相同的内存地址
        boolean bool2 = "val" == "v" + "al";
        System.out.println(bool2); // 输出：true

        // 使用 == 不符合预期的情况，看着相同，但它们并不同，原因：指向不同的内存地址
        boolean bool3 = new String("val") == "val";
        System.out.println(bool3); // 输出：false

        // 使用 == 不符合预期的情况，看着相同，但它们并不同，原因：指向不同的内存地址
        boolean bool4 = new String("val") == new String("val");
        System.out.println(bool3); // 输出：false

        // 这个两值是相同的，原因：比较具体的值，值相同
        boolean bool5 = new String("val").equals("val");
        System.out.println(bool3); // 输出：true

        //  其他相同的情况
        String one = "HELLO";
        String two = "HELLO";
        String three = new String("HELLO");
        String four = "hello";

        one.equals(two);            // true ，原因：比较具体的值，值相同
        one.equals(three);          // true ，原因：比较具体的值，值相同
        one.equalsIgnoreCase(four); // true ，原因：忽略大小写，比较具体的值，值相同

    }

}
