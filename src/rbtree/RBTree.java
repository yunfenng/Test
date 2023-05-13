package rbtree;


/**
 * ClassName: RBTree
 * Description:
 *   ①创建RBTree，定义颜色
 *   ②创建RBNode
 *   ③辅助方法定义：parentOf(node)，isRed(node)，isBlack(node)，setRed(node)，setBlack(node)，inOrderPrint(RBNode tree)
 *   ④左旋方法定义：leftRotate(node)
 *   ⑤右旋方法定义：rightRotate(node)
 *   ⑥公开插入接口方法定义：insert(K key, V value);
 *   ⑦内部插入接口方法定义：insert(RBNode node);
 *   ⑧修正插入导致红黑树失衡的方法定义：insertFIxUp(RBNode node);
 *   ⑨测试红黑树正确性
 */
public class RBTree<K extends Comparable<K>, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    /**定义根节点的引用*/
    private RBNode root;

    public RBNode getRoot() {
        return root;
    }

    /**
     * 公开的插入接口
     * @param key 键
     * @param value 值
     */
    public void insert(K key, V value) {
        RBNode node = new RBNode();
        node.setKey(key);
        node.setValue(value);
        node.setColor(RED);
        insert(node);
    }

    /**
     * 内部插入接口定义
     * @param node
     */
    private void insert(RBNode node) {
        //1.找到插入的位置
        RBNode parent = null;
        RBNode x = this.root;
        while(x != null) {
            parent = x;

            //a > b 则返回 1，否则返回 -1 ，相等返回0
            int cmp = node.key.compareTo(parent.key);

            if(cmp < 0) {
                x = x.left;
            } else if(cmp == 0) {
                parent.setValue(node.value);
                return;
            } else {
                x = x.right;
            }
        }

        node.parent = parent;

        if(parent != null) {
            if(node.key.compareTo(parent.key) < 0) {
                parent.left = node;
            } else {
                parent.right = node;
            }
        } else {
            this.root = node;
        }

        //插入之后需要进行修复红黑树，让红黑树再次平衡。
        insertFixUp(node);
    }

    /**
     * 插入后修复红黑树平衡的方法
     *     |---情景1：红黑树为空树，将根节点染成黑色
     *     |---情景2：插入节点的key已经存在，不需要处理
     *     |---情景3：插入节点的父节点为黑色，因为插入的路径黑色节点个数无变化，所以红黑树依然平衡，不需要处理
     *
     *     情景4 需要咱们去处理
     *     |---情景4：插入节点的父节点为红色
     *          |---情景4.1：叔叔节点存在，并且为红色（父-叔 双红），
     *                      将爸爸和叔叔节点染为黑色，将爷爷节点染为红色，并再以爷爷节点为当前节点进行下一步处理
     *          |---情景4.2：叔叔节点不存在，或者为黑色，父节点为爷爷节点的左子树
     *               |---情景4.2.1：插入节点为其父节点的左子节点（LL情况），将爸爸染成黑色，将爷爷染为红色，以爷爷节点进行右旋
     *               |---情景4.2.2：插入节点为其父节点的右子节点（LR情况），
     *                             以爸爸节点进行左旋，得到LL双红情景(4.2.1)，然后指定爸爸节点为当前节点进行下一步处理
     *          |---情景4.3：叔叔节点不存在，或者为黑色，父节点为爷爷节点的右子树，
     *               |---情景4.3.1：插入节点为其父节点的右子节点（RR情况），将爸爸染成黑色，将爷爷染为红色，以爷爷节点进行左旋
     *               |---情景4.3.2：插入节点为其父节点的左子节点（RL情况），
     *                             以爸爸节点进行右旋，得到RR双红情景(4.3.1)，然后指定爸爸节点为当前节点进行下一步处理
     */
    private void insertFixUp(RBNode node) {
        this.root.setColor(BLACK);

        RBNode parent = parentOf(node);
        RBNode gparent = parentOf(parent);

        // 情景4：插入节点的父节点为红色
        if (parent != null && isRed(parent)) {
            // 如果父节点是红色，那么必然存在祖父节点
            RBNode uncle = null;

            if (parent == gparent.left) { // 父节点是祖父节点的左子树
                uncle = gparent.right;

                // 情景4.1：叔叔节点存在，并且为红色（父-叔 双红）
                if (uncle != null && isRed(uncle)) {
                    // 将爸爸和叔叔节点染为黑色，将爷爷节点染为红色，并再以爷爷节点为当前节点进行下一步处理
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(gparent);
                    insertFixUp(gparent);
                    return;
                }

                // 情景4.2：叔叔节点不存在，或者为黑色
                if (uncle == null || isBlack(uncle)) {
                    // 情景4.2.1：插入节点为其父节点的左子节点（LL情况），将爸爸染成黑色，将爷爷染为红色，以爷爷节点进行右旋
                    if (node == parent.left) {
                        setBlack(parent);
                        setRed(gparent);
                        rightRotate(gparent);
                        return;
                    }
                    // 情景4.2.2：插入节点为其父节点的右子节点（LR情况），以爸爸节点进行左旋，得到LL双红情景(4.2.1)，然后指定爸爸节点为当前节点进行下一步处理
                    if (node == parent.right) {
                        leftRotate(parent);
                        insertFixUp(parent);
                        return;
                    }
                }

            } else { // 父节点是祖父节点的右子树
                uncle = gparent.left;

                // 情景4.1：叔叔节点存在，并且为红色（父-叔 双红）
                if (uncle != null && isRed(uncle)) {
                    // 将爸爸和叔叔节点染为黑色，将爷爷节点染为红色，并再以爷爷节点为当前节点进行下一步处理
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(gparent);
                    insertFixUp(gparent);
                    return;
                }

                // 情景4.3：叔叔节点不存在，或者为黑色
                if (uncle == null || isBlack(uncle)) {
                    // 情景4.3.1：插入节点为其父节点的右子节点（RR情况），将爸爸染成黑色，将爷爷染为红色，以爷爷节点进行左旋
                    if (node == parent.right) {
                        setBlack(parent);
                        setRed(gparent);
                        leftRotate(gparent);
                        return;
                    }
                    // 情景4.3.2：插入节点为其父节点的左子节点（RL情况），以爸爸节点进行右旋，得到RR双红情景(4.3.1)，然后指定爸爸节点为当前节点进行下一步处理
                    if (node == parent.left) {
                        rightRotate(parent);
                        insertFixUp(parent);
                        return;
                    }
                }
            }
        }
    }


    /**
     * 中序遍历(对外开放)
     */
    public void inOrderPrint() {
        if (this.root != null) {
            inOrderPrint(this.root);
        }
    }

    private void inOrderPrint(RBNode node) {
        inOrderPrint(node.left);
        System.out.println("key: " + node.getKey() + ", value: " + node.getValue());
        inOrderPrint(node.right);
    }

    /**
     * 左旋方法
     * 左旋示意图：左旋x节点
     *    p                   p
     *    |                   |
     *    x                   y
     *   / \         ---->   / \
     *  lx  y               x   ry
     *     / \             / \
     *    ly  ry          lx  ly
     *
     * 1. 将x的右子节点指向y的左子节点，并将y的左子节点的父节点更新为x
     * 2. 当x的父节点不为空时，将x的父节点指向y，并更新y的父节点为x的父节点
     * 3. 将y的左子节点指向x，并更新x的父节点为y
     */
    private void leftRotate(RBNode x) {
        RBNode y = x.right;
        // 1. 将x的右子节点指向y的左子树，并将y的左节点的父节点更新为x
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        // 2. 当x的父节点不为空时，将x的父节点指向y，并更新y的父节点为x的父节点
        if (x.parent != null) {
            if (x.parent.left == x) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
            y.parent = x.parent;
        } else {
            this.root = y;
            this.root.parent = null;
        }

        // 3. 将y的左子节点指向x，并更新x的父节点为y
        y.left = x;
        x.parent = y;
    }

    /**
     * 右旋方法
     * 右旋示意图：右旋y节点
     *
     *      p                       p
     *      |                       |
     *      y                       x
     *     / \          ---->      / \
     *    x   ry                  lx  y
     *   / \                         / \
     *  lx  ly                      ly  ry
     *
     * 1. 将y的左子节点指向x的左子节点，更新x的左子节点的父节点为y
     * 2. 当y的父节点不为空时，将y的父节点指向x，并更新x的父节点为y的父节点
     * 3. 将x的右子节点指向y，更新y的父节点为x
     */
    private void rightRotate(RBNode y) {
        RBNode x = y.left;
        // 1. 将y的左子节点指向x的右子节点，更新x的左子节点的父节点为y
        y.left = x.right;
        if (x.right != null) {
            x.right.parent = y;
        }
        // 2. 当y的父节点不为空时，将y的父节点指向x，并更新x的父节点为y的父节点
        if (y.parent != null) {
            if (y == y.parent.left) {
                y.parent.left = x;
            } else {
                y.parent.right = x;
            }
            x.parent = y.parent;
        } else {
            this.root = x;
            this.root.parent = null;
        }
        // 3. 将x的右子节点指向y，更新y的父节点为x
        x.right = y;
        y.parent = x;
    }

    /**
     * 设置当前节点是黑色
     * @param node
     */
    private void setBlack(RBNode node) {
        if (node != null) {
            node.setColor(BLACK);
        }
    }

    /**
     * 设置当前节点是红色
     * @param node
     */
    private void setRed(RBNode node) {
        if (node != null) {
            node.setColor(RED);
        }
    }

    /**
     * 判断当前节点是否为黑色
     * @param node
     * @return
     */
    private boolean isBlack(RBNode node) {
        if (node != null) {
            return node.color == BLACK;
        }
        return false;
    }

    /**
     * 判断当前节点是否为红色
     * @param node
     * @return
     */
    private boolean isRed(RBNode node) {
        if (node != null) {
            return node.color == RED;
        }
        return false;
    }

    /**
     * 获取当前节点的父节点
     * @param node
     * @return
     */
    private RBNode parentOf(RBNode node) {
        if (node != null) {
            return node.parent;
        }
        return null;
    }

    /**
     * 创建 RBNode
     * @param <K>
     * @param <V>
     */
    static class RBNode<K extends Comparable<K>, V> {
        private RBNode left;
        private RBNode right;
        private RBNode parent;
        private boolean color;
        private K key;
        private V value;

        public RBNode() {
        }

        public RBNode(RBNode left, RBNode right, RBNode parent, boolean color, K key, V value) {
            this.left = left;
            this.right = right;
            this.parent = parent;
            this.color = color;
            this.key = key;
            this.value = value;
        }

        public RBNode getLeft() {
            return left;
        }

        public void setLeft(RBNode left) {
            this.left = left;
        }

        public RBNode getRight() {
            return right;
        }

        public void setRight(RBNode right) {
            this.right = right;
        }

        public RBNode getParent() {
            return parent;
        }

        public void setParent(RBNode parent) {
            this.parent = parent;
        }

        public boolean isColor() {
            return color;
        }

        public void setColor(boolean color) {
            this.color = color;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

    }

    /**
     * Print Method
     */
    public void padding(String ch, int n) {
        int i;
        for (i = 0; i < n; i++) {
            System.out.printf(ch);
        }

    }

    void print_node(RBNode root, int level) {
        if (root == null) {
            padding("\t", level);
            System.out.println("NIL");
        } else {
            print_node(root.right, level + 1);
            padding("\t", level);
            if (root.color == BLACK) {
                System.out.printf(root.key + "(" + (root.isColor() ? "红" : "黑") + ")" + "\n");
            } else
                System.out.printf(root.key + "(" + (root.isColor() ? "红" : "黑") + ")" + "\n");
            print_node(root.left, level + 1);
        }
    }

    void print_tree() {
        print_node(this.root, 0);
        System.out.printf("-------------------------------------------\n");
    }

}
