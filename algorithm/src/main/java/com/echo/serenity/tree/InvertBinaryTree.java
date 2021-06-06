package com.echo.serenity.tree;


import java.util.Stack;

public class InvertBinaryTree {

    public TreeNode mirrorTreeDfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = mirrorTreeDfs(root.right);
        root.right = mirrorTreeDfs(tmp);
        return root;
    }

    public TreeNode mirrorTreeBfs(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;

    }
}
