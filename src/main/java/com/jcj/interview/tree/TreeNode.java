package com.jcj.interview.tree;

import lombok.*;

@Data
public class TreeNode {

    private String value;

    private TreeNode left;

    private TreeNode right;

    public TreeNode(String value) {
        this.value = value;
    }
}
