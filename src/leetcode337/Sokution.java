package leetcode337;
import zju.hm.TreeNode;

public class Sokution {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int planA = root.val;
        if (root.left != null) {
            planA += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            planA += rob(root.right.left) + rob(root.right.right);
        }

        int planB = rob(root.left) +rob(root.right);

        return Math.max(planA, planB);
    }
}
