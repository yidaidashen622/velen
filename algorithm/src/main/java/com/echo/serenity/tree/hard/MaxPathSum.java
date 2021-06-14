package com.echo.serenity.tree.hard;

import com.echo.serenity.tree.TreeNode;

public class MaxPathSum {
    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftSum = Math.max(dfs(node.left), 0);
        int rightSum = Math.max(dfs(node.right), 0);
        res = Math.max(res, leftSum + rightSum + node.val);
        return Math.max(leftSum, rightSum) + node.val;
    }
}
