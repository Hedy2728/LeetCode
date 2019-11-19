package leetcode404;
import zju.hm.TreeNode;

import java.util.Stack;

public class Solution2 {
    public int sumOfLeftLeaves(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int res = 0;

        if (root == null) {
            return 0;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null) {
                    res += node.left.val;
                }
                else {
                    stack.push(node.left);
                }
            }


            if (node.right != null) {
                if (node.right.left != null || node.right.right != null) {
                    stack.push(node.right);
                }
            }
        }
        return res;
    }
}
