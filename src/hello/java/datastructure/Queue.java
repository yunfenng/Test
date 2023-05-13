package hello.java.datastructure;

/**
 * 队列的数据结构
 */
public class Queue<E> {

    private Object[] data = null;
    private int maxSize;    //队列容量
    private int front;      //队列头，允许删除
    private int rear;       //队列尾，允许插入

    //构造函数，默认队列大小为10
    public Queue() {
        this(10);
    }

    public Queue(int initialSize) {
        if (initialSize >= 0) {
            this.maxSize = initialSize;
            data = new Object[initialSize];
            front = rear = 0;
        } else {
            throw new RuntimeException("初始化大小不能小于0：" + initialSize);
        }
    }

    //在队列的尾部插入数据
    public boolean add(E e) {
        if (rear == maxSize) {
            throw new RuntimeException("队列已满，无法插入新的元素");
        } else {
            data[rear++] = e;
            return true;
        }
    }

    //删除队列头部的元素
    public E poll() {
        if (empty()) {
            throw new RuntimeException("空队列异常！");
        } else {
            E value = (E) data[front];  //临时保存队列front端的元素的值
            data[front++] = null;       //释放队列front端的元素
            return value;
        }
    }

    //取出队列头部的元素，但不删除
    public E peek() {
        if (empty()) {
            throw new RuntimeException("空队列异常！");
        } else {
            return (E) data[front];
        }
    }

    public boolean empty() {
        if (data.length == 0) {
            return false;
        }
        return true;
    }

}
