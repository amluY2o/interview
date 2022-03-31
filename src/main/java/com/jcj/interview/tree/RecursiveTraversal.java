package com.jcj.interview.tree;

public class RecursiveTraversal implements Traversal {

    @Override
    public void preOrder(TreeNode treeNode) {
        if(treeNode != null){
            System.out.print(treeNode.getValue() + " ");
            preOrder(treeNode.getLeft());
            preOrder(treeNode.getRight());
        }
    }

    @Override
    public void infixOrder(TreeNode treeNode) {
        if(treeNode != null){
            infixOrder(treeNode.getLeft());
            System.out.print(treeNode.getValue() + " ");
            infixOrder(treeNode.getRight());
        }
    }

    @Override
    public void postOrder(TreeNode treeNode) {
        if(treeNode != null){
            postOrder(treeNode.getLeft());
            postOrder(treeNode.getRight());
            System.out.print(treeNode.getValue() + " ");
        }
    }
}
