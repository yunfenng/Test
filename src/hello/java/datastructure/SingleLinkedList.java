package hello.java.datastructure;

/**
 * 单链表
 */
public class SingleLinkedList {

    private int length;   //链表节点个数
    private Node head;  //头节点

    public SingleLinkedList() {
        length = 0;
        head = null;
    }

    //链表每个节点的数据结构描述类
    private class Node {
        private Object data;    //每个节点的数据
        private Node next;      //每个节点指向下一个节点的连接

        public Node(Object data) {
            this.data = data;
        }
    }

    //在链表头部添加元素
    public Object addHead(Object obj) {
        Node newHead = new Node(obj); //定义新节点

        if (length == 0) {
            head = newHead; //如果链表为空，则将该节点设置为头部节点
        } else { //设置当前节点为头部节点，并将当前节点的下一个节点指向原来的头部节点
            head = newHead;
            newHead.next = head;
        }

        length++; //链表长度+1
        return obj;
    }

    //删除指定元素，返回成功则返回true
    public boolean delete(Object value) {
        //如果链表为空，直接返回false
        if (length == 0) {
            return false;
        }

        Node current = head;
        Node previous = head;

        //如果链表不为空，则通过while找到要删除的元素
        while (current.data != value) {
            if (current.next == null) {
                return false;
            } else {
                previous = current;
                current = current.next;
            }
        }

        //如果删除的节点是头节点
        if (current == head) {
            head = current.next;
            length--;
        } else { //删除的节点不是头节点
            previous.next = current.next;
            length--;
        }

        return true;
    }

    //查找指定的元素，若找到了则返回节点Node，找不到则返回null
    public Node find(Object obj) {
        Node current = head;
        int tempSize = length;

        while (tempSize > 0) {
            if (obj.equals(current.data)) {
                return current;
            } else {
                current = current.next;
            }
            tempSize--;
        }
        return null;
    }

}
