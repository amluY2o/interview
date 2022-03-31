package com.jcj.interview.tree;

public class BinaryTreeOrderTest {

    public static void main(String[] args) {
        //Traversal traversal = new RecursiveTraversal();
        Traversal traversal = new NonRecursiveTraversal();

        TreeNode root = new TreeNode("A");
        TreeNode b = new TreeNode("B");
        TreeNode c = new TreeNode("C");
        TreeNode d = new TreeNode("D");
        TreeNode e = new TreeNode("E");
        TreeNode f = new TreeNode("F");

        root.setLeft(b);
        root.setRight(c);
        b.setLeft(d);
        c.setLeft(e);
        c.setRight(f);

        System.out.println("前序遍历：");
        traversal.preOrder(root);
        System.out.println();

        System.out.println("中序遍历：");
        traversal.infixOrder(root);
        System.out.println();

        System.out.println("后序遍历：");
        traversal.postOrder(root);


    }
}
