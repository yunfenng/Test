package test;

import java.util.ArrayList;
import java.util.List;

public class TestOverride {

    public static void main(String[] args) {

        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();

        // 在 A 中存在 show(A obj)，直接调用
        a.show(a); // A.show(A)
        // 在 A 中不存在 show(B obj)，将 B 转型成其父类 A
        a.show(b); // A.show(A)
        // 在 B 中存在从 A 继承来的 show(C obj)，直接调用
        b.show(c); // A.show(C)
        // 在 B 中不存在 show(D obj)，但是存在从 A 继承来的 show(C obj)，将 D 转型成其父类 C
        b.show(d); // A.show(C)

        // 引用的还是 B 对象，所以 ba 和 b 的调用结果一样
        A ba = new B();
        ba.show(c); // A.show(C)
        ba.show(d); // A.show(C)
    }
}


/**
 * 重写（Override）
 *
 * 存在于继承体系中，指子类实现了一个与父类在方法声明上完全相同的一个方法。
 *
 * 为了满足里式替换原则，重写有以下三个限制：
 *
 * 子类方法的访问权限必须大于等于父类方法；
 * 子类方法的返回类型必须是父类方法返回类型或为其子类型。
 * 子类方法抛出的异常类型必须是父类抛出异常类型或为其子类型。
 * 使用 @Override 注解，可以让编译器帮忙检查是否满足上面的三个限制条件。
 *
 * 下面的示例中，SubClass 为 SuperClass 的子类，SubClass 重写了 SuperClass 的 func() 方法。其中：
 *
 * 子类方法访问权限为 public，大于父类的 protected。
 * 子类的返回类型为 ArrayList，是父类返回类型 List 的子类。
 * 子类抛出的异常类型为 Exception，是父类抛出异常 Throwable 的子类。
 * 子类重写方法使用 @Override 注解，从而让编译器自动检查是否满足限制条件。
 */

class SuperClass {
    protected List<Integer> func() throws Throwable {
        return new ArrayList<>();
    }
}

class SubClass extends SuperClass {
    @Override
    public ArrayList<Integer> func() throws Exception {
        return new ArrayList<>();
    }
}

/**
 * 在调用一个方法时，先从本类中查找看是否有对应的方法，如果没有再到父类中查看，看是否从父类继承来。
 * 否则就要对参数进行转型，转成父类之后看是否有对应的方法。总的来说，方法调用的优先级为：
 *
 *         this.func(this)
 *         super.func(this)
 *         this.func(super)
 *         super.func(super)
 */

/*
    A
    |
    B
    |
    C
    |
    D
 */
class A {

    public void show(A obj) {
        System.out.println("A.show(A)");
    }

    public void show(C obj) {
        System.out.println("A.show(C)");
    }
}

class B extends A {

    @Override
    public void show(A obj) {
        System.out.println("B.show(A)");
    }
}

class C extends B {

}

class D extends C {

}
























