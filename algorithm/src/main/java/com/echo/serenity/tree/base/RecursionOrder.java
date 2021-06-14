package com.echo.serenity.tree.base;

import com.echo.serenity.tree.TreeNode;
import com.google.common.collect.Lists;

import java.util.List;

public class RecursionOrder {

    public List<TreeNode> preOrder(TreeNode root) {
        List<TreeNode> nodes = Lists.newArrayList();
        preOrder(root, nodes);
        return nodes;
    }


    public List<TreeNode> inOrder(TreeNode root) {
        List<TreeNode> nodes = Lists.newArrayList();
        inOrder(root, nodes);
        return nodes;
    }

    public List<TreeNode> postOrder(TreeNode root) {
        List<TreeNode> nodes = Lists.newArrayList();
        postOrder(root, nodes);
        return nodes;
    }

    private void preOrder(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        list.add(node);
        preOrder(node.left, list);
        preOrder(node.right, list);
    }

    private void inOrder(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node);
        inOrder(node.right, list);
    }

    private void postOrder(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node);
    }


}
