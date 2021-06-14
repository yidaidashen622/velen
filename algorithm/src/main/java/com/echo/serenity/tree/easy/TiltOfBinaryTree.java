package com.echo.serenity.tree.easy;

import com.echo.serenity.tree.TreeNode;

public class TiltOfBinaryTree {
    private int tilt = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return tilt;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftTilt = dfs(node.left);
        int rightTilt = dfs(node.right);
        tilt += Math.abs(leftTilt - rightTilt);
        return leftTilt + rightTilt + node.val;
    }
}
