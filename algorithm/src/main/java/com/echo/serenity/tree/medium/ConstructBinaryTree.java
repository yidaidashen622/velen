package com.echo.serenity.tree.medium;

import com.echo.serenity.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree {

    private final Map<Integer, Integer> indexMap = new HashMap<>();

    /**
     * preorder = [3,9,20,15,7]
     * inorder = [9,3,15,20,7]
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight) {
            return null;
        }
        int inorderRoot = indexMap.get(preorder[preorderLeft]);
        TreeNode root = new TreeNode(preorder[preorderLeft]);
        int leftSubtreeSize = inorderRoot - preorderLeft;
        root.left = buildTree(preorder, inorder, preorderLeft + 1, preorderLeft + leftSubtreeSize, inorderLeft, inorderRoot - 1);
        root.right = buildTree(preorder, inorder, preorderLeft + leftSubtreeSize + 1, preorderRight, inorderRoot + 1, inorderRight);
        return root;
    }


}
