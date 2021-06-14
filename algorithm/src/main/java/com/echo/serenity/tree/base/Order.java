package com.echo.serenity.tree.base;

import com.echo.serenity.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Order {

    public List<TreeNode> preOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Stack<TreeNode> nodes = new Stack<>();
        ArrayList<TreeNode> result = new ArrayList<>();
        TreeNode node = root;
        while (node != null || !nodes.isEmpty()) {
            while (node != null) {
                result.add(node);
                nodes.push(node);
                node = node.left;
            }
            node = nodes.pop().right;
        }
        return result;
    }


    public List<TreeNode> inOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Stack<TreeNode> nodes = new Stack<>();
        ArrayList<TreeNode> result = new ArrayList<>();
        TreeNode node = root;
        while (node != null || !nodes.isEmpty()) {
            while (node != null) {
                nodes.push(node);
                node = node.left;
            }
            TreeNode popNode = nodes.pop();
            result.add(popNode);
            node = popNode.right;
        }
        return result;
    }

    public List<TreeNode> postOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<TreeNode> result = new ArrayList<>();
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode node = root;
        TreeNode prev = null;
        while (node != null || !nodes.isEmpty()) {
            while (node != null) {
                nodes.push(node);
                node = node.left;
            }
            TreeNode tmpNode = nodes.pop();
            if (tmpNode.right == null || tmpNode.right == prev) {
                result.add(tmpNode);
                prev = tmpNode;
                node = null;
            } else {
                nodes.push(tmpNode);
                node = tmpNode.right;
            }
        }
        return result;
    }


}
