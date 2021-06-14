package com.echo.serenity.tree.base;

public class VerifyOrder {

    public boolean verifyPostorder(int[] postorder) {
        return verify(postorder, 0, postorder.length - 1);
    }

    private boolean verify(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int root = postorder[end];
        int k = start;
        while (k < end && postorder[k] < root) {
            k++;
        }
        for (int i = k; i < end; i++) {
            if (postorder[i] < root) { //判断右侧的节点均大于跟节点
                return false;
            }
        }
        return verify(postorder, start, k - 1) && verify(postorder, k, end - 1);
    }

}
