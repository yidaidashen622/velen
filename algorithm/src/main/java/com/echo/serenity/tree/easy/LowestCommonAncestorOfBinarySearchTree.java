package com.echo.serenity.tree.easy;

import com.echo.serenity.tree.TreeNode;

public class LowestCommonAncestorOfBinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            }else if (p.val > ancestor.val && q.val > ancestor.val){
                ancestor = ancestor.right;
            }else {
                break;
            }
        }
        return ancestor;
    }
}
