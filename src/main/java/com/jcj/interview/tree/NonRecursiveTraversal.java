package com.jcj.interview.tree;

import java.util.List;
import java.util.Stack;

/**
 * 非递归遍历
 */
public class NonRecursiveTraversal implements Traversal {

    @Override
    public void preOrder(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                continue;
            }
            System.out.print(node.getValue() + " ");
            stack.push(node.getRight());
            stack.push(node.getLeft());
        }
    }

    @Override
    public void infixOrder(TreeNode treeNode) {

    }

    @Override
    public void postOrder(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                continue;
            }
            System.out.print(node.getValue() + " ");
            stack.push(node.getLeft());
            stack.push(node.getRight());
        }
    }
}
