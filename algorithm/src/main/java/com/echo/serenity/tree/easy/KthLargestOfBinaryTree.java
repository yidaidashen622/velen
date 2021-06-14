package com.echo.serenity.tree.easy;

import com.echo.serenity.tree.TreeNode;

public class KthLargestOfBinaryTree {

    private int result;
    private int k;

    /**
     * 二叉搜索树的 中序遍历倒序 为 递减序列
     * 求 “二叉搜索树第k大的节点” 可转化为求 “此树的中序遍历倒序的第k个节点”。
     */
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return result;
    }

    private void dfs(TreeNode node) {
        if (node == null){
            return;
        }
        dfs(node.right);
        if (k == 0){
            return;
        }
        if (--k == 0) {
            result = node.val;
        }
        dfs(node.left);
    }
}
