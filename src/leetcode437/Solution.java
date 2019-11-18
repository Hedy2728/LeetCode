package leetcode437;
import zju.hm.TreeNode;

public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = pathSumFromRoot(root,sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        return res;
    }

    private int pathSumFromRoot(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val == sum) {
            res++;
        }
        res += pathSumFromRoot(root.left, sum-root.val) + pathSumFromRoot(root.right, sum-root.val);
        return res;
    }
}
