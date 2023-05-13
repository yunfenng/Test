package cn.fengqingyang;

public class Crito1 {

    public static void main(String[] args) {

        CharSequence charSequence = "21";
        String str1 = "21";
        String str2 = "21".substring(0);
        String str3 = new String("21");

        System.out.println(charSequence == str1); // true
        System.out.println(charSequence == str2); // true
        System.out.println(charSequence == str3); // false
        System.out.println(charSequence.equals(str3)); // true
        System.out.println(str1 == str3); // false

        /*
        * String str = "str";
        * 这种就是直接在常量池中取，若常量池中有，则直接返回；
        * 若不存在，则在常量池中生成一个，然后返回。
        *
        * substring(0) 等价于 String str = "str";
        *
        * new 堆生成的时候指向的是堆中的对象。
        *
        * 为什么说CharSequence 等价于 String？？
        *   因为 String 的父接口是 CharSequence
        *   父类是所有子类必须遵循的规范，子类可以出现的地方父类一定可以替换它。
        *   Java 设计者必须保证行为一致，就是保证两行代码在底层实现的时候必须是相同的。
        *
        * String 底层其实是char数组实现的
        * 而 CharSequence 底层是字符数组的行为规范。
        *
        * */

    }
}
