package cn.fengqingyang;

/**
 *  问题：System.exit(0) 这个方法在执行过程中到底做了哪些事情？？、
 *
 *      API文档上描述System.exit方法会导致当前运行线程
 *  停止并使其它线程都终止，因此上面这段代码中的finally
 *  代码块不会被执行。
 *      进一步探索System.exit被调用后的行为，它在虚拟机
 *  在退出前会执行两个清除任务。
 *      第一，它会执行所有通过Runtime.addShutdownHook注册的shutdown hooks.
 *  它能有效的释放JVM之外的资源。
 *      第二，执行清除任务，运行相关的finalizer方法终结对象。
 *
 *      System.exit(0)表示正常退出JVM，
 *      而System.exit(1)表示异常退出JVM。
 *      参数只是通知操作系统程序的退出状态，0为正常，非0为异常。
 *
 */
public class Laches04 {

    public static void main(String[] args) {
        try {
            System.out.println("T"); //
            System.exit(0);
            double d = 5/0;
        } catch (Exception e) {
            System.out.println("C");
        } finally {
            System.out.println("F");
        }
    }

}
