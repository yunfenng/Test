package cn.fengqingyang.demo01;

public class Demo01InnerClass {

    public static void main(String[] args) {

        Outer.Inner obj = new Outer().new Inner();
        obj.methodInner();

        Outer outer = new Outer();
        outer.methodOuter();

    }

}
