package leetcode112;
import zju.hm.TreeNode;

import java.util.ArrayList;

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        if (root.left == null) return hasPathSum(root.right, sum - root.val);
        if (root.right == null) return hasPathSum(root.left, sum - root.val);

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
