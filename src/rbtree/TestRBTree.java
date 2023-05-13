package rbtree;

import java.util.Scanner;

/**
 * TestRBTree
 */
public class TestRBTree {

    public static void main(String[] args) {
        RBTree<String, Object> rbt = new RBTree();

        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入key:");
            String key = sc.next();

            rbt.insert(key, null);

            TreeOperation.show(rbt.getRoot());
            // rbt.print_tree();
        }
    }
}
