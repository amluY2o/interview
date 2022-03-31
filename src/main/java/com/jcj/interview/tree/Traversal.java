package com.jcj.interview.tree;

import java.util.List;

/**
 * 遍历
 * @author JCJ
 */
public interface Traversal {

    /**
     * 前序遍历
     * @param treeNode
     */
    void preOrder(TreeNode treeNode);

    /**
     * 中序遍历
     * @param treeNode
     */
    void infixOrder(TreeNode treeNode);

    /**
     * 后续遍历
     * @param treeNode
     */
    void postOrder(TreeNode treeNode);
}
