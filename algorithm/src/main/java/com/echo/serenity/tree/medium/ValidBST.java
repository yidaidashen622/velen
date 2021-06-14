package com.echo.serenity.tree.medium;

import com.echo.serenity.tree.TreeNode;

public class ValidBST {

    public boolean isValidBST(TreeNode root) {
        return validBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean validBST(TreeNode node, int lower, int higher) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= higher) {
            return false;
        }
        return validBST(node.left, lower, node.val) && validBST(node.right, node.val, higher);
    }
}
