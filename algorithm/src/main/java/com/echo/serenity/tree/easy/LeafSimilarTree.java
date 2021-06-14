package com.echo.serenity.tree.easy;

import com.echo.serenity.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTree {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new ArrayList<>();
        List<Integer> leaf2 = new ArrayList<>();
        leafs(root1, leaf1);
        leafs(root2, leaf2);
        return leaf1.equals(leaf2);
    }

    private void leafs(TreeNode node, List<Integer> leafs) {
        if (node == null){
            return;
        }
        if (node.left == null && node.right == null) {
            leafs.add(node.val);
            return;
        }
        leafs(node.left, leafs);
        leafs(node.right, leafs);
    }
}
