package com.echo.serenity.tree.easy;

import java.util.ArrayList;
import java.util.List;

public class IncreasingBST {

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);

        TreeNode dummyNode = new TreeNode(-1);
        TreeNode curNode = dummyNode;
        for (Integer integer : list) {
            curNode.right = new TreeNode(integer);
            curNode = curNode.right;
        }
        return dummyNode.right;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
