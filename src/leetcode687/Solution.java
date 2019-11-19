package leetcode687;
import zju.hm.TreeNode;

public class Solution {
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        if (root.left != null || root.right != null) {

        }


    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftPath = helper(root.left);
        int rightPath = helper(root.right);

        return Math.max(leftPath, rightPath);
    }
}
