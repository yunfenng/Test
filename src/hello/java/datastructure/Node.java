package hello.java.datastructure;

/**
 * 二叉排序树
 */
public class Node {
    private int value;
    private Node root;
    private Node left;
    private Node right;

    public Node() {
    }

    public Node(Node left, Node right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }


    /**
     * 向二叉排序树种插入节点
     * 1、循环查找需要插入的节点prev;
     * 2、如果二叉树的根节点为null，则说明二叉树是空树，直接将该节点设置为根节点；
     * 3、如果待插入的数据小于该节点的值，则将其插入该节点的左节点；
     * 4、如果待插入的数据大于该节点的值，则将其插入该节点的右节点。
     */
    public void insertBST(int key) {
        Node p = root;

        //记录查询节点的前一个节点
        Node prev = null;

        //一直查找下去，直到到达满足条件的节点位置
        while (p != null) {
            prev = p;
            if (key < p.getValue()) {
                p = p.getLeft();
            } else if (key > p.getValue()) {
                p = p.getRight();
            } else {
                return;
            }
        }

        //prev是待插入节点的父节点，根据节点值的大小，被插入对应的位置
        if (root == null) { //如果二叉树的根节点为null，则说明二叉树是空树，直接将该节点设置为根节点；
            root = new Node(key);
        } else if (key < prev.getValue()) { //如果待插入的数据小于该节点的值，则将其插入该节点的左节点；
            prev.setLeft(new Node(key));
        } else { //如果待插入的数据大于该节点的值，则将其插入该节点的右节点。
            prev.setRight(new Node(key));
        }

    }



}



























