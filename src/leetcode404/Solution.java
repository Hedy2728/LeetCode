package leetcode404;
import zju.hm.TreeNode;

public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {

        return sumOfLeft(root, false);
    }

    private int sumOfLeft(TreeNode root, boolean flag) {
        int sum = 0;
        if (root == null) {
            return 0;
        }
        if (root.left != null || root.right != null) {
            sum += sumOfLeft(root.left, true);
            sum += sumOfLeft(root.right, false);
        }
        else if (flag) {
            sum += root.left.val;
        }
        return sum;
    }
}
