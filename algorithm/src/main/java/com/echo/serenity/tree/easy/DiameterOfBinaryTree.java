package com.echo.serenity.tree.easy;

import com.echo.serenity.tree.TreeNode;

public class DiameterOfBinaryTree {
    private int result = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return result;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        result = Math.max(result, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }

}
