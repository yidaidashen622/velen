package com.echo.serenity.tree.easy;

import com.echo.serenity.tree.TreeNode;

public class MaxDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


}
