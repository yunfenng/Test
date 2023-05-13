package xqjia123;

import java.util.ArrayList;
import java.util.List;

/**
 * final并不等同于immutable
 *
 */
public class Test002 {

    public static void main(String[] args) {
        final List<String> strList = new ArrayList<>();
        strList.add("Hello");
        strList.add("World");

        for (String s : strList) {
            System.out.println(s);
        }

        //List<String> unmodifiableList = List.of("Hello", "World");
        //unmodifiableList.add("again"); // Exception in thread "main" java.lang.UnsupportedOperationException

        /*
                final 只能约束 strList 这个引用不可以被赋值，但是 strList 对象行为不被 final 影响，
            添加元素等操作是完全正常的。如果我们真的希望对象本身是不可变的，那么需要相应的类支持不可变的行为。
            在上面这个例子中，List.of 方法创建的本身就是不可变 List，最后那句 add 是会在运行时抛出异常的。
         */
    }

}
