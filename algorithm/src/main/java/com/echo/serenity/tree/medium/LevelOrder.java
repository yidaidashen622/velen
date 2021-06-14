package com.echo.serenity.tree.medium;

import com.echo.serenity.tree.TreeNode;

import java.util.*;

public class LevelOrder {

    public List<TreeNode> levelOrder1(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<TreeNode> result = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.remove();
            result.add(node);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        return result;
    }

    public List<List<TreeNode>> levelOrder2(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<TreeNode>> result = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            LinkedList<TreeNode> tmp = new LinkedList<>();
            for (int i = nodes.size(); i > 0; i--) {
                TreeNode node = nodes.remove();
                tmp.add(node);
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
            if (nodes.size() % 2  == 1) {
                Collections.reverse(tmp);
            }
            result.add(tmp);
        }
        return result;

    }

}
