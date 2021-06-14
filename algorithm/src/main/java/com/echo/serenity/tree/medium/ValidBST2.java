package com.echo.serenity.tree.medium;

import com.echo.serenity.tree.TreeNode;

import java.util.Stack;

public class ValidBST2 {

    /**
     * 中序遍历，二叉搜索树「中序遍历」得到的值构成的序列一定是升序的
     */
    public boolean isValidBST(TreeNode root) {
        int preValue = Integer.MIN_VALUE;
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode node = root;
        while(node!=null || !nodes.isEmpty()){
            while(node!=null){
                nodes.push(node);
                node = node.left;
            }
            TreeNode popNode = nodes.pop();
            if (popNode.val > preValue){
                return false;
            }
            preValue = popNode.val;
            node = popNode.right;
        }
        return true;
    }


}
