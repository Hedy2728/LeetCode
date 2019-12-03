package leetcode530;

import zju.hm.TreeNode;

import java.util.List;

public class Solution {
    int temp = Integer.MAX_VALUE;
    TreeNode preNode = null;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return temp;

    }

    public void inOrder(TreeNode root) {

        if (root == null) {
            return;
        }
        if (root.left != null) {
            inOrder(root.left);
        }
        if (preNode != null){
            temp = Math.min(temp, Math.abs(root.val - preNode.val));
        }

        preNode = root;
        if (root.right != null) {
            inOrder(root.right);
        }

    }
}
